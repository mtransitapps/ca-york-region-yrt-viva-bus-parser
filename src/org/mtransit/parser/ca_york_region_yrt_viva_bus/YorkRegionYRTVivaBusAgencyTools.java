package org.mtransit.parser.ca_york_region_yrt_viva_bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.mtransit.commons.OneBusAwayCommons;
import org.mtransit.parser.CleanUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Pair;
import org.mtransit.parser.SplitUtils;
import org.mtransit.parser.SplitUtils.RouteTripSpec;
import org.mtransit.parser.Utils;
import org.mtransit.parser.ca_york_region_yrt_viva_bus.Stops;
import org.mtransit.parser.gtfs.data.GCalendar;
import org.mtransit.parser.gtfs.data.GCalendarDate;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GSpec;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.gtfs.data.GTrip;
import org.mtransit.parser.gtfs.data.GTripStop;
import org.mtransit.parser.mt.data.MAgency;
import org.mtransit.parser.mt.data.MDirectionType;
import org.mtransit.parser.mt.data.MRoute;
import org.mtransit.parser.mt.data.MTrip;
import org.mtransit.parser.mt.data.MTripStop;

// https://www.yrt.ca/en/about-us/developer-centre.aspx
// https://www.yrt.ca/en/about-us/google-transit-feed-specification--gtfs-.aspx
// https://www.yrt.ca/google/google_transit.zip
// http://www.yrt.ca/en/aboutus/developer.asp
// http://www.yrt.ca/en/aboutus/GTFS.asp
// http://www.yrt.ca/google/google_transit.zip
// https://www.yrt.ca/google/google_transit.zip
public class YorkRegionYRTVivaBusAgencyTools extends DefaultAgencyTools {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			args = new String[3];
			args[0] = "input/gtfs.zip";
			args[1] = "../../mtransitapps/ca-york-region-yrt-viva-bus-android/res/raw/";
			args[2] = ""; // files-prefix
		}
		new YorkRegionYRTVivaBusAgencyTools().start(args);
	}

	private HashSet<String> serviceIds;

	@Override
	public void start(String[] args) {
		System.out.printf("\nGenerating YRT Viva bus data...");
		long start = System.currentTimeMillis();
		this.serviceIds = extractUsefulServiceIds(args, this);
		super.start(args);
		System.out.printf("\nGenerating YRT Viva bus data... DONE in %s.\n", Utils.getPrettyDuration(System.currentTimeMillis() - start));
	}

	@Override
	public boolean excludingAll() {
		return this.serviceIds != null && this.serviceIds.isEmpty();
	}

	@Override
	public boolean excludeCalendar(GCalendar gCalendar) {
		if (this.serviceIds != null) {
			return excludeUselessCalendar(gCalendar, this.serviceIds);
		}
		return super.excludeCalendar(gCalendar);
	}

	@Override
	public boolean excludeCalendarDate(GCalendarDate gCalendarDates) {
		if (this.serviceIds != null) {
			return excludeUselessCalendarDate(gCalendarDates, this.serviceIds);
		}
		return super.excludeCalendarDate(gCalendarDates);
	}

	@Override
	public boolean excludeTrip(GTrip gTrip) {
		if (gTrip.getTripHeadsign().startsWith("YRT Training Bus")) {
			return true; // exclude training bus
		}
		if (this.serviceIds != null) {
			return excludeUselessTrip(gTrip, this.serviceIds);
		}
		return super.excludeTrip(gTrip);
	}

	private static final String TTC = "TTC ";

	@Override
	public boolean excludeRoute(GRoute gRoute) {
		if (gRoute.getRouteLongName().startsWith(TTC)) {
			return true; // skip TTC agency bus routes
		}
		if (gRoute.getRouteLongName().endsWith(" TRAINING BUS")) {
			return true; // exclude training bus
		}
		return super.excludeRoute(gRoute);
	}

	@Override
	public Integer getAgencyRouteType() {
		return MAgency.ROUTE_TYPE_BUS;
	}

	private static final Pattern DIGITS = Pattern.compile("[\\d]+");

	private static final String VIVA = "viva";
	private static final String BLUE = "blue";
	private static final String BLUE_A = "blue-a";
	private static final String GREEN = "green";
	private static final String ORANGE = "orange";
	private static final String PINK = "pink";
	private static final String PURPLE = "purple";
	private static final String YELLOW = "yellow";

	private static final long _98_99_RID = 9899L;
	private static final String RSN_98_99 = "98/99";
	private static final String RSN_98_99_ = "98|99";
	private static final String RSN_098_099 = "098/099";
	private static final String RSN_098_099_ = "098|099";

	private static final long RID_ENDS_WITH_A = 10_000L;
	private static final long RID_ENDS_WITH_B = 20_000L;
	private static final long RID_ENDS_WITH_C = 30_000L;
	private static final long RID_ENDS_WITH_D = 40_000L;
	private static final long RID_ENDS_WITH_E = 50_000L;
	private static final long RID_ENDS_WITH_F = 60_000L;

	private static final String A = "a";
	private static final String B = "b";
	private static final String C = "c";
	private static final String D = "d";
	private static final String E = "e";
	private static final String F = "f";

	private static final long VIVA_BLUE_RID = 601L;
	private static final long VIVA_BLUE_A_RID = 602L;
	private static final long VIVA_PURPLE_RID = 603L;
	private static final long VIVA_PINK_RID = 604L;
	private static final long VIVA_ORANGE_RID = 605L;
	private static final long VIVA_GREEN_RID = 606L;
	private static final long VIVA_YELLOW_RID = 607L;

	@Override
	public long getRouteId(GRoute gRoute) {
		String routeLongName = gRoute.getRouteLongName();
		String routeShortName = gRoute.getRouteShortName();
		if (routeShortName != null && routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return Integer.valueOf(routeShortName); // using route short name as route ID
		}
		String routeShortNameLC = routeShortName.toLowerCase(Locale.ENGLISH);
		String routeLongNameLC = routeLongName.toLowerCase(Locale.ENGLISH);
		if (routeLongNameLC.contains(VIVA)) {
			if (routeLongNameLC.endsWith(BLUE)) {
				return VIVA_BLUE_RID;
			} else if (routeLongNameLC.endsWith(BLUE_A)) {
				return VIVA_BLUE_A_RID;
			} else if (routeLongNameLC.endsWith(GREEN)) {
				return VIVA_GREEN_RID;
			} else if (routeLongNameLC.endsWith(ORANGE)) {
				return VIVA_ORANGE_RID;
			} else if (routeLongNameLC.endsWith(PINK)) {
				return VIVA_PINK_RID;
			} else if (routeLongNameLC.endsWith(PURPLE)) {
				return VIVA_PURPLE_RID;
			} else if (routeLongNameLC.endsWith(YELLOW)) {
				return VIVA_YELLOW_RID;
			}
		}
		if (RSN_98_99.equals(routeShortNameLC) //
				|| RSN_98_99_.equals(routeShortNameLC) //
				|| RSN_098_099.equals(routeShortNameLC) //
				|| RSN_098_099_.equals(routeShortNameLC)) {
			return _98_99_RID;
		}
		try {
			Matcher matcher = DIGITS.matcher(routeShortName);
			if (matcher.find()) {
				long digits = Long.parseLong(matcher.group());
				if (routeShortNameLC.endsWith(A)) {
					return RID_ENDS_WITH_A + digits;
				} else if (routeShortNameLC.endsWith(B)) {
					return RID_ENDS_WITH_B + digits;
				} else if (routeShortNameLC.endsWith(C)) {
					return RID_ENDS_WITH_C + digits;
				} else if (routeShortNameLC.endsWith(D)) {
					return RID_ENDS_WITH_D + digits;
				} else if (routeShortNameLC.endsWith(E)) {
					return RID_ENDS_WITH_E + digits;
				} else if (routeShortNameLC.endsWith(F)) {
					return RID_ENDS_WITH_F + digits;
				}
			}
		} catch (Exception e) {
			System.out.printf("\nError while extracting route ID for %s!\n", gRoute);
			e.printStackTrace();
			System.exit(-1);
			return -1l;
		}
		System.out.printf("\nUnexpected route ID for %s!\n", gRoute);
		System.exit(-1);
		return -1l;
	}

	@Override
	public String getRouteColor(GRoute gRoute) {
		if (getRouteId(gRoute) == VIVA_YELLOW_RID) {
			if ("F7FE2E".equalsIgnoreCase(gRoute.getRouteColor())) {
				return "FFCC00";
			}
		}
		return super.getRouteColor(gRoute);
	}

	private static final Pattern REMOVE_LEADING_ZEROS = Pattern.compile("(^0+)", Pattern.CASE_INSENSITIVE);

	@Override
	public String getRouteShortName(GRoute gRoute) {
		String routeLongNameLC = gRoute.getRouteLongName().toLowerCase(Locale.ENGLISH);
		if (routeLongNameLC.startsWith(VIVA)) {
			return CleanUtils.cleanLabel(routeLongNameLC.substring(VIVA.length()));
		}
		String routeShortName = gRoute.getRouteShortName();
		String routeShortNameLC = routeShortName.toLowerCase(Locale.ENGLISH);
		if (routeShortNameLC.startsWith(VIVA)) {
			return CleanUtils.cleanLabel(routeShortNameLC.substring(VIVA.length()));
		}
		if (routeLongNameLC.equalsIgnoreCase("yellow")) {
			return CleanUtils.cleanLabel(routeLongNameLC);
		}
		if (routeShortName != null && routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return routeShortName;
		}
		StringBuilder sb = new StringBuilder();
		routeShortName = routeShortName.replaceAll("\\/", "|");
		String[] rsns = routeShortName.split("\\|");
		for (String rsn : rsns) {
			if (sb.length() > 0) {
				sb.append("|");
			}
			sb.append(REMOVE_LEADING_ZEROS.matcher(rsn).replaceAll(StringUtils.EMPTY));
		}
		return sb.toString();
	}

	private static final Pattern SS = Pattern.compile("((^|\\W){1}(school special|ss)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String SS_REPLACEMENT = "$2SS$4";

	private static final Pattern GW = Pattern.compile("((^|\\W){1}(g[\\.]?w[\\.]?)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String GW_REPLACEMENT = "$2GW$4";

	private static final Pattern GO = Pattern.compile("((^|\\W){1}(go)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String GO_REPLACEMENT = "$2GO$4";

	private static final String RLN_VIVA = "Viva";

	@Override
	public String getRouteLongName(GRoute gRoute) {
		if (gRoute.getRouteLongName().toLowerCase(Locale.ENGLISH).startsWith(VIVA) //
				|| gRoute.getRouteShortName().toLowerCase(Locale.ENGLISH).startsWith(VIVA)) {
			return RLN_VIVA;
		}
		if (gRoute.getRouteLongName().toLowerCase(Locale.ENGLISH).equalsIgnoreCase("yellow")) {
			return RLN_VIVA;
		}
		if (StringUtils.isEmpty(gRoute.getRouteLongName())) {
			System.out.printf("\nUnexpected route long name for %s!\n", gRoute);
			System.exit(-1);
			return null;
		}
		String routeLongName = gRoute.getRouteLongName();
		routeLongName = routeLongName.toLowerCase(Locale.ENGLISH);
		routeLongName = SS.matcher(routeLongName).replaceAll(SS_REPLACEMENT);
		routeLongName = GW.matcher(routeLongName).replaceAll(GW_REPLACEMENT);
		routeLongName = GO.matcher(routeLongName).replaceAll(GO_REPLACEMENT);
		routeLongName = CleanUtils.cleanSlashes(routeLongName);
		routeLongName = CleanUtils.removePoints(routeLongName);
		routeLongName = CleanUtils.cleanStreetTypes(routeLongName);
		return CleanUtils.cleanLabel(routeLongName);
	}

	private static final String AGENCY_COLOR = "0079C2"; // BLUE (Android App Icon)

	@Override
	public String getAgencyColor() {
		return AGENCY_COLOR;
	}

	private static final String PARK_AND_RIDE_SHORT = "P&R";
	private static final String UNIVERSITY_SHORT = "U";

	private static final String _AND_ = " & ";

	private static final String HIGHWAY_400 = "Hwy 400";
	private static final String HIGHWAY_7 = "Hwy 7";
	private static final String DON_MILLS = "Don Mills";
	private static final String DON_MILLS_STATION = DON_MILLS + " Sta";
	private static final String MARTIN_GROVE = "Martin Grv";
	private static final String FINCH_TERMINAL = "Finch Terminal";
	private static final String YORK_UNIVERSITY = "York " + UNIVERSITY_SHORT;
	private static final String VAUGHAN_MILLS = "Vaughan Mills";
	private static final String VAUGHAN_MILLS_MALL = VAUGHAN_MILLS + " Mall";
	private static final String VAUGHAN_MILLS_TERMINAL = VAUGHAN_MILLS + " Terminal";
	private static final String WOODBINE_AVENUE = "Woodbine Ave";
	private static final String MARKHAM = "Markham";
	private static final String BERCZY = "Berczy";
	private static final String UNIONVILLE_GO_STATION = "Unionville GO Sta";
	private static final String GREEN_LANE = "Grn Ln";
	private static final String NEWMARKET_TERMINAL = "Newmarket Terminal";
	private static final String MARKVILLE_MALL = "Markville Mall";
	private static final String RICHMOND_HL_CTR = "Richmond Hl Ctr";
	private static final String SENECA_COLLEGE_KING_CAMPUS = "Seneca College King Campus";
	private static final String BATHURST = "Bathurst";
	private static final String AURORA_GO_STATION = "Aurora GO Sta";
	private static final String STONE_ROAD = "Stone Rd";
	private static final String TESTON_ROAD = "Teston Rd";
	private static final String LEBOVIC_CAMPUS_DRIVE = "Lebovic Campus Dr";
	private static final String PROMENADE_TERMINAL = "Promenade Terminal";
	private static final String MAPLE_GO = "Maple GO";
	private static final String MAPLE_GO_STATION = MAPLE_GO + " Sta";
	private static final String SENECA_KING = "Seneca King";
	private static final String MAIN_STREET = "Main St";
	private static final String RUTHERFORD = "Rutherford";
	private static final String SLASH = " / ";
	private static final String KLEINBURG = "Kleinburg";
	private static final String NAPA_VALLEY = "Napa Vly";
	private static final String STEELES_AVE = "Steeles Ave";
	private static final String WOODBINE_CENTER = "Woodbine Ctr";
	private static final String STEELES = "Steeles";
	private static final String GLEN_SHIELDS = "Gln Shields";
	private static final String DROP_OFF_ONLY = "Drop Off Only";
	private static final String P_OFF_ONLY = "P Off Only";
	private static final String YONGE = "Yonge";
	private static final String YONGE_STREET = YONGE + " St";
	private static final String MIDDLEFIELD = "Middlefield";
	private static final String COPPER_CREEK_DRIVE = "Copper Crk Dr";
	private static final String MARKHAM_ROAD = "Markham Rd";
	private static final String BERNARD_TERMINAL = "Bernard Terminal";
	private static final String BEAVER_CREEK = "Beaver Crk";
	private static final String MINGAY = "Mingay";
	private static final String PIONEER_VLG = "Pioneer Vlg";
	private static final String PIONEER_VLG_TERMINAL = PIONEER_VLG + " Terminal";
	private static final String MAJOR_MACKENZIE = "Major Mackenzie";
	private static final String CANADA_DRIVE = "Canada Dr";
	private static final String SMART_CENTRES_PLACE = "SmartCentres Pl";


	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;
	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		map2.put(21L, new RouteTripSpec(21L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "Vellore", //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, VAUGHAN_MILLS_TERMINAL) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6273"), // VAUGHAN MILLS TERMINAL PLATFORM 5
								Stops.ALL_STOPS.get("4295"), // ++
								Stops.ALL_STOPS.get("6615"), // == VELLORE AV / MAJOR MACKENZIE DR
								Stops.ALL_STOPS.get("6899"), // != #AM POETRY DR / FLOURISH ST
								Stops.ALL_STOPS.get("5731"), // != #AM CANADA DR / SUMMIT DR
								Stops.ALL_STOPS.get("5732"), // != #AM CANADA DR / CITYVIEW BLVD =>
								Stops.ALL_STOPS.get("6849"), // != #PM MAJOR MACKENZIE DR / FOSSIL HILL RD
								Stops.ALL_STOPS.get("6920"), // != #PM CITYVIEW BLVD / VENICE GT
								Stops.ALL_STOPS.get("6919"), // != #PM CANADA DR / SUMMIT DR =>
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6919"), // != #PM CANADA DR / SUMMIT DR <=
								Stops.ALL_STOPS.get("6898"), // != #PM POETRY DR / MAJOR MACKENZIE DR
								Stops.ALL_STOPS.get("5732"), // != #AM CANADA DR / CITYVIEW BLVD <=
								Stops.ALL_STOPS.get("5733"), // != #AM CITYVIEW BLVD STOP # 5733
								Stops.ALL_STOPS.get("6848"), // != #AM MAJOR MACKENZIE DR / FOSSIL HIL RD
								Stops.ALL_STOPS.get("6620"), // == VELLORE AV / EURO PLACE
								Stops.ALL_STOPS.get("3049"), // ++
								Stops.ALL_STOPS.get("6273"), // VAUGHAN MILLS TERMINAL PLATFORM 5
						})) //
				.compileBothTripSort());
		map2.put(31L, new RouteTripSpec(31L, //
				OneBusAwayCommons.EAST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "East", // Aurora GO Sta
				OneBusAwayCommons.WEST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "West") // ??
				.addTripSort(OneBusAwayCommons.EAST_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1210"), // "3336", // "1210", // AURORA HEIGHTS DR / WHISPERING PINE
								Stops.ALL_STOPS.get("2512"), // "335", // "2512", // == YONGE ST STOP # 2512
								Stops.ALL_STOPS.get("2410"), // "3564", // "2410", // == ST. JOHN'S SDRD / OLD YONGE ST
								Stops.ALL_STOPS.get("5245"), // "4053", // "5245", // == INDUSTRIAL PKWY / WELLINGTON ST
								Stops.ALL_STOPS.get("6093"), // "7809", // "6093", // != WELLINGTON ST STOP # 6093
								Stops.ALL_STOPS.get("5253"), // "4058", // "5253", // == INDUSTRIAL PKWY STOP # 5253
								Stops.ALL_STOPS.get("6424"), // "7661", // "6424", // AURORA GO STATION PLATFORM #2
						})) //
				.addTripSort(OneBusAwayCommons.WEST_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6424"), // "7661", // "6424", // AURORA GO STATION PLATFORM #2
								Stops.ALL_STOPS.get("6391"), // "5897", // "6391", // WELLINGTON ST / TEMPERANCE ST
								Stops.ALL_STOPS.get("1191"), // "3329", // "1191", // == WELLINGTON ST / HAIDA DR
								Stops.ALL_STOPS.get("4748"), // "3903", // "4748", // != WELLINGTON ST / MCDONALD DR
								Stops.ALL_STOPS.get("5079"), // "4021", // "5079", // != MCDONALD DR / HAIDA DR
								Stops.ALL_STOPS.get("4737"), // "3893", // "4737", // != HAIDA DR / MCDONALD ST
								Stops.ALL_STOPS.get("4736"), // "3892", // "4736", // == HAIDA DR / AURORA HEIGHTS DR
								Stops.ALL_STOPS.get("1210"), // "3336", // "1210", // AURORA HEIGHTS DR / WHISPERING PINE
						})) //
				.compileBothTripSort());
		map2.put(40L, new RouteTripSpec(40L, //
				OneBusAwayCommons.EAST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL, //
				OneBusAwayCommons.WEST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, WOODBINE_AVENUE) //
				.addTripSort(OneBusAwayCommons.EAST_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6512"), // "7841", // "6512", // RODICK RD / WOODBINE AV
								Stops.ALL_STOPS.get("1461"), // "1911", // "1461", // ++ TOWN CENTRE BLVD / HIGHWAY 7
								Stops.ALL_STOPS.get("1827"), // "2152", // "1827", // MARKVILLE MALL STOP #1827
						})) //
				.addTripSort(OneBusAwayCommons.WEST_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1827"), // "2152", // "1827", // MARKVILLE MALL STOP #1827
								Stops.ALL_STOPS.get("1541"), // "1990", // "1541", // ++ BUCHANAN DR / SPANHOUSE CRES
								Stops.ALL_STOPS.get("6512"), // "7841", // "6512", // RODICK RD / WOODBINE AV
						})) //
				.compileBothTripSort());
		map2.put(41L, new RouteTripSpec(41L, //
				OneBusAwayCommons.EAST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKHAM, //
				OneBusAwayCommons.WEST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL) //
				.addTripSort(OneBusAwayCommons.EAST_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1827"), // "2152", // "1827", // MARKVILLE MALL STOP #1827
								Stops.ALL_STOPS.get("1814"), // "2145", // "1814", // RAYMERVILLE DR / CARPENTER CRT
								Stops.ALL_STOPS.get("1844"), // "2169", // "1844", // LARKIN AV / SAWYER CRES
						})) //
				.addTripSort(OneBusAwayCommons.WEST_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1844"), // "2169", // "1844", // LARKIN AV / SAWYER CRES
								Stops.ALL_STOPS.get("1862"), // "2184", // "1862", // BULLOCK DR / SNIDER DR
								Stops.ALL_STOPS.get("1827"), // "2152", // "1827", // MARKVILLE MALL STOP #1827
						})) //
				.compileBothTripSort());
		map2.put(42L, new RouteTripSpec(42L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, BERCZY) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("5977"), // MAIN ST UNIONVILLE / ENTERPRISE BLV
								Stops.ALL_STOPS.get("9745"), // != RIVIS RD / YMCA BLVD
								Stops.ALL_STOPS.get("4171"), // <> UNIONVILLE GO STATION PLATFORM 2
								Stops.ALL_STOPS.get("4907"), // != YMCA BLVD / RIVIS RD
								Stops.ALL_STOPS.get("2971"), // MAJOR MACKENZIE DR / RIDGECREST RD
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("2971"), // MAJOR MACKENZIE DR / RIDGECREST RD
								Stops.ALL_STOPS.get("1824"), // CARLTON RD / MCCOWAN RD
								Stops.ALL_STOPS.get("4906"), // != YMCA BLVD / RIVIS RD
								Stops.ALL_STOPS.get("4171"), // <> UNIONVILLE GO STATION PLATFORM 2
								Stops.ALL_STOPS.get("9744"), // != RIVIS RD / YMCA BLVD
								Stops.ALL_STOPS.get("6308"), // ENTERPRISE DR / MAIN STREET
						})) //
				.compileBothTripSort());
		map2.put(44L, new RouteTripSpec(44L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, GREEN_LANE, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, NEWMARKET_TERMINAL) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("4691"), // "1204", // "4691" // NEWMARKET GO TERMINAL PLATFORM 6
								Stops.ALL_STOPS.get("1971"), // "3379", // "1971" // != UPPER CANADA MALL STOP # 1971
								Stops.ALL_STOPS.get("5944"), // "5093", // "5944" // == DAVIS DR / FORD WILSON DR
								Stops.ALL_STOPS.get("5698"), // "4122", // "5698" // WOODSPRING AV / ALFRED SMITH WAY
								Stops.ALL_STOPS.get("4680"), // "1195", // "4680" // GREEN LANE / YONGE ST
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("4680"), // "1195", // "4680" // GREEN LANE / YONGE ST
								Stops.ALL_STOPS.get("5421"), // "4086", // "5421" // LONDON RD / YORKSHIRE DR
								Stops.ALL_STOPS.get("4691"), // "1204", // "4691" // NEWMARKET GO TERMINAL PLATFORM 6
						})) //
				.compileBothTripSort());
		map2.put(45L, new RouteTripSpec(45L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MINGAY, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1827"), // "2152", // "1827" // MARKVILLE MALL STOP #1827
								Stops.ALL_STOPS.get("1383"), // "1874", // "1383" // BUR OAK AV / DOGWOOD ST
								Stops.ALL_STOPS.get("4799"), // "1234", // "4799" // MAJOR MACKENZIE DR / MINGAY AV
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("4799"), // "1234", // "4799" // MAJOR MACKENZIE DR / MINGAY AV
								Stops.ALL_STOPS.get("5541"), // "5619", // "5541" // RAYMERVILLE DR / BENDAMERE CRES
								Stops.ALL_STOPS.get("1827"), // "2152", // "1827" // MARKVILLE MALL STOP #1827
						})) //
				.compileBothTripSort());
		map2.put(84L, new RouteTripSpec(84L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "North", //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "South") //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("4839"), // "3923", // "4839" // KING RD / YONGE ST
								Stops.ALL_STOPS.get("2658"), // "3723", // "2658" // HUMBERLAND DR / WOODHAVEN CRES
								Stops.ALL_STOPS.get("2659"), // "349", // "2659" // YONGE ST / COON'S RD
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("2659"), // "349", // "2659" // YONGE ST / COON'S RD
								Stops.ALL_STOPS.get("2359"), // "2380", // "2359" // NORTH LAKE RD / OLDE BAYVIEW AV,
								Stops.ALL_STOPS.get("4839"), // "3923", // "4839" // KING RD / YONGE ST
						})) //
				.compileBothTripSort());
		map2.put(204L, new RouteTripSpec(204L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, BERCZY, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("4171"), // UNIONVILLE GO STATION PLATFORM 2
								Stops.ALL_STOPS.get("6127"), // MCCOWAN RD STOP # 6127
								Stops.ALL_STOPS.get("2971"), // MAJOR MACKENZIE DR / RIDGECREST RD
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("2971"), // MAJOR MACKENZIE DR / RIDGECREST RD
								Stops.ALL_STOPS.get("6092"), // == BUR OAK AV STOP # 6092
								Stops.ALL_STOPS.get("1401"), // != BUR OAK AV / THE BRIDLE WALK,
								Stops.ALL_STOPS.get("6690"), // != THE BRIDLE WALK / HOST AV
								Stops.ALL_STOPS.get("4171"), // UNIONVILLE GO STATION PLATFORM 2
						})) //
				.compileBothTripSort());
		map2.put(522L, new RouteTripSpec(522L, //
				OneBusAwayCommons.EAST, MTrip.HEADSIGN_TYPE_STRING, "East", //
				OneBusAwayCommons.WEST, MTrip.HEADSIGN_TYPE_STRING, "West") //
				.addTripSort(OneBusAwayCommons.EAST, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("5246"), // HAGGERMANS CORNER
								Stops.ALL_STOPS.get("1552"), // M-S HOSPITAL
								Stops.ALL_STOPS.get("5986"), // CORNELL PARK AV / WALKERVILLE RD
						})) //
				.addTripSort(OneBusAwayCommons.WEST, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("5986"), // CORNELL PARK AV / WALKERVILLE RD
								Stops.ALL_STOPS.get("6305"), // TONY WONG PLACE / KENNEDY RD
								Stops.ALL_STOPS.get("5246"), // HAGGERMANS CORNER
						})) //
				.compileBothTripSort());
		map2.put(589L, new RouteTripSpec(589L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "Bernard / Dunlop St", //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, StringUtils.EMPTY) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("7106"), // "6525", // "7106" // HILLCREST MALL
								Stops.ALL_STOPS.get("5319"), // "1366", // "5319" // OBSERVATORY TOWERS STOP # 5319
								Stops.ALL_STOPS.get("2961"), // "490", // "2961" // == MAJOR MACKENZIE DR / HARDING BLVD
								Stops.ALL_STOPS.get("2962"), // "491", // "2962" // != MAJOR MACKENZIE DR / ARNOLD CRES
								Stops.ALL_STOPS.get("2964"), // "493", // "2964" // != MAJOR MACKENZIE DR / YONGE ST
								Stops.ALL_STOPS.get("4694"), // "1207", // "4694" // != xx YONGE ST / ARNOLD CRES
								Stops.ALL_STOPS.get("5322"), // "1368", // "5322" // != MCCONAGHY CENTRE STOP # 5322
								Stops.ALL_STOPS.get("4694"), // "1207", // "4694" // != xx YONGE ST / ARNOLD CRES
								Stops.ALL_STOPS.get("2965"), // "494", // "2965" // == MAJOR MACKENZIE DR / BAKER AV
								Stops.ALL_STOPS.get("6605"), // "6049", // "6605" // ==
								Stops.ALL_STOPS.get("5839"), // "4763", // "5839" // xx
								Stops.ALL_STOPS.get("4402"), // "1098", // "4402" // xx
								Stops.ALL_STOPS.get("1152"), // "1722", // "1152" // !=
								Stops.ALL_STOPS.get("5839"), // "4763", // "5839" // xx
								Stops.ALL_STOPS.get("4402"), // "1098", // "4402" // xx
								Stops.ALL_STOPS.get("5839"), // "4763", // "5839" // xx
								Stops.ALL_STOPS.get("1693"), // "207", // "1693" // ==
								Stops.ALL_STOPS.get("2750"), // "372", // "2750" // DUNLOP ST STOP #
								Stops.ALL_STOPS.get("6321"), // "7612", // "6321" // UPPER YONGE PLACE
								Stops.ALL_STOPS.get("7228"), // "8042", // "7228" // MON SHEONG COURT STOP # 7228
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { /* no stops */})) //
				.compileBothTripSort());
		map2.put(590L, new RouteTripSpec(590L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, StringUtils.EMPTY, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "Hillcrest Mall") //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { /* no stops */})) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("7228"), // "8042", // "7228" // MON SHEONG COURT STOP # 7228
								Stops.ALL_STOPS.get("6321"), // "7612", // "6321" // UPPER YONGE PLACE
								Stops.ALL_STOPS.get("4628"), // "1182", // "4628" // RICHMOND HEIGHTS NO FRILLS STOP # 4
								Stops.ALL_STOPS.get("1707"), // "215", // "1707" // MAJOR MACKENZIE DR / BAKER AV
								Stops.ALL_STOPS.get("4950"), // "1287", // "4950" // MAJOR MACKENZIE DR / YONGE ST
								Stops.ALL_STOPS.get("4694"), // "1207", // "4694" // YONGE ST / ARNOLD CRES
								Stops.ALL_STOPS.get("5322"), // "1368", // "5322" // MCCONAGHY CENTRE STOP # 5322
								Stops.ALL_STOPS.get("6125"), // "5382", // "6125" // HARDING BLVD / KERSEY CRES
								Stops.ALL_STOPS.get("7106"), // "6525", // "7106" // HILLCREST MALL
						})) //
				.compileBothTripSort());
		map2.put(801L, new RouteTripSpec(801L, //
				OneBusAwayCommons.NORTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				OneBusAwayCommons.SOUTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(OneBusAwayCommons.NORTH, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("7232"), // OPERATIONS CENTRE
								Stops.ALL_STOPS.get("6501"), // OAK RIDGES C.C. STOP # 6501
								Stops.ALL_STOPS.get("4934"), // ELGIN WEST C.C. STOP # 4934
								Stops.ALL_STOPS.get("7231"), // RICHMOND HILL WAVE POOL
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6501"), // OAK RIDGES C.C. STOP # 6501
								Stops.ALL_STOPS.get("4934"), // ELGIN WEST C.C. STOP # 4934
								Stops.ALL_STOPS.get("7231"), // RICHMOND HILL WAVE POOL
								Stops.ALL_STOPS.get("7232"), // OPERATIONS CENTRE
						})) //
				.compileBothTripSort());
		map2.put(802L, new RouteTripSpec(802L, //
				OneBusAwayCommons.NORTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				OneBusAwayCommons.SOUTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(OneBusAwayCommons.NORTH, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("7233"), // ELGIN BARROW ARENA
								Stops.ALL_STOPS.get("7235"), // ROUGE WOODS COMMUNITY CENTRE
								Stops.ALL_STOPS.get("7232"), // OPERATIONS CENTRE
						})) //
				.addTripSort(OneBusAwayCommons.SOUTH, //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("7232"), // OPERATIONS CENTRE
								Stops.ALL_STOPS.get("7233"), // ELGIN BARROW ARENA
								Stops.ALL_STOPS.get("7235"), // ROUGE WOODS COMMUNITY CENTRE
						})) //
				.compileBothTripSort());
		ALL_ROUTE_TRIPS2 = map2;
	}

	@Override
	public String cleanStopOriginalId(String gStopId) {
		gStopId = CleanUtils.cleanMergedID(gStopId);
		return gStopId;
	}

	@Override
	public Pair<Long[], Integer[]> splitTripStop(MRoute mRoute, GTrip gTrip, GTripStop gTripStop, ArrayList<MTrip> splitTrips, GSpec routeGTFS) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return SplitUtils.splitTripStop(mRoute, gTrip, gTripStop, routeGTFS, ALL_ROUTE_TRIPS2.get(mRoute.getId()), this);
		}
		return super.splitTripStop(mRoute, gTrip, gTripStop, splitTrips, routeGTFS);
	}

	@Override
	public int compareEarly(long routeId, List<MTripStop> list1, List<MTripStop> list2, MTripStop ts1, MTripStop ts2, GStop ts1GStop, GStop ts2GStop) {
		if (ALL_ROUTE_TRIPS2.containsKey(routeId)) {
			return ALL_ROUTE_TRIPS2.get(routeId).compare(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop, this);
		}
		return super.compareEarly(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop);
	}

	@Override
	public ArrayList<MTrip> splitTrip(MRoute mRoute, GTrip gTrip, GSpec gtfs) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return ALL_ROUTE_TRIPS2.get(mRoute.getId()).getAllTrips();
		}
		return super.splitTrip(mRoute, gTrip, gtfs);
	}

	@Override
	public void setTripHeadsign(MRoute mRoute, MTrip mTrip, GTrip gTrip, GSpec gtfs) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return; // split
		}
		String tripHeadsign = gTrip.getTripHeadsign();
		if (tripHeadsign.startsWith(mRoute.getShortName())) {
			tripHeadsign = tripHeadsign.substring(mRoute.getShortName().length() + 1);
		}
		if (isGoodEnoughAccepted()) {
			if (mRoute.getId() >= 400L && mRoute.getId() <= 499L) {
				mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign) + " " + gTrip.getDirectionId(), gTrip.getDirectionId());
				return;
			}
		}
		String tripHeadsignLC = gTrip.getTripHeadsign().toLowerCase(Locale.ENGLISH);
		if (tripHeadsignLC.endsWith("- nb")) {
			mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), OneBusAwayCommons.NORTH);
			return;
		} else if (tripHeadsignLC.endsWith("- sb")) {
			mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), OneBusAwayCommons.SOUTH);
			return;
		} else if (tripHeadsignLC.endsWith("- wb")) {
			mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), OneBusAwayCommons.WEST);
			return;
		} else if (tripHeadsignLC.endsWith("- eb")) {
			mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), OneBusAwayCommons.EAST);
			return;
		}
		if (tripHeadsignLC.endsWith("- mo")) {
			mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), OneBusAwayCommons.MORNING);
			return;
		} else if (tripHeadsignLC.endsWith("- af")) {
			mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), OneBusAwayCommons.AFTERNOON);
			return;
		}
		System.out.printf("\nUnexpected trips to set: %s!\n", gTrip);
		System.exit(-1);
		return;
	}

	@Override
	public boolean mergeHeadsign(MTrip mTrip, MTrip mTripToMerge) {
		List<String> headsignsValues = Arrays.asList(mTrip.getHeadsignValue(), mTripToMerge.getHeadsignValue());
		if (mTrip.getRouteId() == 2L) {
			if (Arrays.asList( //
					MARKHAM_ROAD, //
					COPPER_CREEK_DRIVE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(MARKHAM_ROAD, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					FINCH_TERMINAL, //
					MIDDLEFIELD //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(FINCH_TERMINAL, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 3L) {
			if (Arrays.asList( //
					YONGE, //
					PIONEER_VLG_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(PIONEER_VLG_TERMINAL, mTrip.getHeadsignId());
				return true;
			}
			if (Arrays.asList( //
					"P " + "Off Only", //
					DON_MILLS //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(DON_MILLS, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 4L) {
			if (Arrays.asList( //
					"Bayview", //
					"Woodbine" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Woodbine", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 5L) {
			if (Arrays.asList( //
					DROP_OFF_ONLY, //
					P_OFF_ONLY, //
					FINCH_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(FINCH_TERMINAL, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					DROP_OFF_ONLY, //
					P_OFF_ONLY, //
					GLEN_SHIELDS //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(GLEN_SHIELDS, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 7L) {
			if (Arrays.asList( //
					STEELES, //
					WOODBINE_CENTER //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(WOODBINE_CENTER, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 8L) {
			if (Arrays.asList( //
					"Clayton / Harvest Moon", //
					STEELES_AVE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(STEELES_AVE, mTrip.getHeadsignId()); // Clayton / Harvest Moon
				return true;
			}
		} else if (mTrip.getRouteId() == 12L) {
			if (Arrays.asList( //
					STEELES, //
					"Steeles Ave", //
					"Steeles AV" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Steeles Ave", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 13L) {
			if (Arrays.asList( //
					NAPA_VALLEY, //
					KLEINBURG, //
					NAPA_VALLEY + SLASH + KLEINBURG //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(NAPA_VALLEY + SLASH + KLEINBURG, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					RUTHERFORD, //
					"Steeles Ave", //
					"Steeles AV" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Steeles Ave", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 14L) {
			if (Arrays.asList( //
					"BoxGrove Bypass", //
					"Copper Crk" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Copper Crk", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 15L) {
			if (Arrays.asList( //
					MAIN_STREET, //
					YONGE_STREET //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(YONGE_STREET, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 20L) {
			if (Arrays.asList( //
					YORK_UNIVERSITY, //
					PIONEER_VLG, //
					PIONEER_VLG_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(PIONEER_VLG, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 22L) {
			if (Arrays.asList( //
					SENECA_COLLEGE_KING_CAMPUS, // <>
					SENECA_KING, //
					"Villanova HS" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Villanova HS", mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					SENECA_COLLEGE_KING_CAMPUS, // <>
					BATHURST + " St", //
					MAPLE_GO_STATION //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(MAPLE_GO_STATION, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 23L) {
			if (Arrays.asList( //
					PROMENADE_TERMINAL, //
					FINCH_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(FINCH_TERMINAL, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					LEBOVIC_CAMPUS_DRIVE, //
					TESTON_ROAD //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(TESTON_ROAD, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 24L) {
			if (Arrays.asList( //
					"Don MIlls Sta", //
					DON_MILLS_STATION //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(DON_MILLS_STATION, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 26L) {
			if (Arrays.asList( //
					VAUGHAN_MILLS_MALL, //
					SMART_CENTRES_PLACE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(SMART_CENTRES_PLACE, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 32L) {
			if (Arrays.asList( //
					"Henderson", //
					STONE_ROAD //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(STONE_ROAD, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					AURORA_GO_STATION, //
					BATHURST, //
					"Seneca", //
					SENECA_COLLEGE_KING_CAMPUS, //
					STONE_ROAD //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Seneca", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 33L) {
			if (Arrays.asList( //
					"State Farm", //
					"404 " + PARK_AND_RIDE_SHORT //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("404 " + PARK_AND_RIDE_SHORT, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 33L + RID_ENDS_WITH_A) { // 33A
			if (Arrays.asList( //
					YONGE_STREET, //
					"Murray" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Murray", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 50L) {
			if (Arrays.asList( //
					"Pefferlaw", //
					"Sutton" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Sutton", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 51L) {
			if (Arrays.asList( //
					"Simcoe Lndg", //
					"Ferncroft" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Ferncroft", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 52L) {
			if (Arrays.asList( //
					"North St", //
					"Newmarket Terminal" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Newmarket Terminal", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 56L) {
			if (Arrays.asList( //
					"404 Town Ctr", //
					NEWMARKET_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(NEWMARKET_TERMINAL, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 82L) {
			if (Arrays.asList( //
					"St Robert", //
					"Commerce Vly Dr" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Commerce Vly Dr", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 83L) {
			if (Arrays.asList( //
					"Richmond Hl H.S", //
					BERNARD_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(BERNARD_TERMINAL, mTrip.getHeadsignId()); // Richmond Hl H.S
				return true;
			}
		} else if (mTrip.getRouteId() == 85L) {
			if (Arrays.asList( //
					DROP_OFF_ONLY, //
					P_OFF_ONLY, //
					NAPA_VALLEY //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(NAPA_VALLEY, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 85L + RID_ENDS_WITH_C) { // 85C
			if (Arrays.asList( //
					VAUGHAN_MILLS, //
					VAUGHAN_MILLS_MALL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(VAUGHAN_MILLS_MALL, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 86L) {
			if (Arrays.asList( //
					RICHMOND_HL_CTR, //
					"Richmond Hl Ctr Terminal" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(RICHMOND_HL_CTR, mTrip.getHeadsignId()); // Richmond Hl Ctr Terminal
				return true;
			}
		} else if (mTrip.getRouteId() == 90L + RID_ENDS_WITH_B) { // 90B
			if (Arrays.asList( //
					HIGHWAY_7, //
					BEAVER_CREEK //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(BEAVER_CREEK, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 105L) {
			if (Arrays.asList( //
					RUTHERFORD, //
					MAJOR_MACKENZIE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(MAJOR_MACKENZIE, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					"Confederation Pkwy", //
					"Sheppard West Sta" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Sheppard West Sta", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 107L) {
			if (Arrays.asList( //
					PIONEER_VLG_TERMINAL, //
					"Drummond Dr" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(PIONEER_VLG_TERMINAL, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 165L) {
			if (Arrays.asList( //
					MAJOR_MACKENZIE + _AND_ + HIGHWAY_400, //
					CANADA_DRIVE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(CANADA_DRIVE, mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					YORK_UNIVERSITY, //
					PIONEER_VLG_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(PIONEER_VLG_TERMINAL, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 223L) {
			if (Arrays.asList( //
					"Ford Wilson", //
					"Sawmill Vly", //
					"Ford Wilson / Sawmill Vly" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Ford Wilson / Sawmill Vly", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 320L) {
			if (Arrays.asList( //
					"West Beaver Crk", //
					"East Beaver Crk" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("East Beaver Crk", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 444L) {
			if (Arrays.asList( //
					"Commerce Vly 0", //
					"Hwy 7 0" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Commerce Vly 0", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 501L + RID_ENDS_WITH_A) { // 501A
			if (Arrays.asList( //
					"Bramalea City Ctr", //
					"Downtown Brampton Terminal" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Downtown Brampton Terminal", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 760L) {
			if (Arrays.asList( //
					VAUGHAN_MILLS, //
					"Canada's Wonderland" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Canada's Wonderland", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == _98_99_RID) {
			if (Arrays.asList( //
					NEWMARKET_TERMINAL, //
					GREEN_LANE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(GREEN_LANE, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == VIVA_BLUE_RID) {
			if (Arrays.asList( //
					BERNARD_TERMINAL, //
					NEWMARKET_TERMINAL //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(NEWMARKET_TERMINAL, mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == VIVA_ORANGE_RID) {
			if (Arrays.asList( //
					"Pine Vly", //
					MARTIN_GROVE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(MARTIN_GROVE, mTrip.getHeadsignId());
				return true;
			}
		}
		System.out.printf("\nUnexpected trips to merge: %s & %s!\n", mTrip, mTripToMerge);
		System.exit(-1);
		return false;
	}

	private static final Pattern BYPASSING = Pattern.compile("((^|\\W){1}(bypassing)(\\W|$){1})", Pattern.CASE_INSENSITIVE);

	private static final Pattern STARTS_WITH_ROUTE_NUMBER = Pattern.compile("(^rt [\\d]+ )", Pattern.CASE_INSENSITIVE);

	private static final Pattern ENDS_WITH_BOUND = Pattern.compile("( \\- [s|e|w|n]b$)", Pattern.CASE_INSENSITIVE);

	private static final Pattern ENDS_WITH_AM_PM = Pattern.compile("( \\- (af|am|mo|pm)$)", Pattern.CASE_INSENSITIVE);

	private static final Pattern STARTS_WITH_DASH = Pattern.compile("(^\\- )", Pattern.CASE_INSENSITIVE);

	private static final Pattern PARK_AND_RIDE = Pattern.compile("((^|\\W){1}(park and ride|park & ride|P\\+R)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String PARK_AND_RIDE_REPLACEMENT = "$2" + PARK_AND_RIDE_SHORT + "$4";

	private static final Pattern UNIVERSITY_ = Pattern.compile("((^|\\W){1}(university)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String UNIVERSITY_REPLACEMENT = "$2" + UNIVERSITY_SHORT + "$4";

	private static final Pattern SECONDARY_SCHOOL_ = Pattern.compile("((^|\\W){1}(" //
			+ "secondary school special" //
			+ "|" //
			+ "secondary school" //
			+ ")(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String SECONDARY_SCHOOL_REPLACEMENT_ = "$2" + "SS" + "$4";

	private static final Pattern HIGH_SCHOOL_ = Pattern.compile("((^|\\W){1}(" //
			+ "high school special" //
			+ "|" //
			+ "high school" //
			+ ")(\\W|$){1})", Pattern.CASE_INSENSITIVE);

	private static final String HIGH_SCHOOL_REPLACEMENT_ = "$2" + "HS" + "$4";

	private static final Pattern SCHOOL_ = Pattern.compile("((^|\\W){1}(" //
			+ "school special" //
			+ "|" //
			+ "school" //
			+ ")(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String SCHOOL_REPLACEMENT_ = "$2" + "S" + "$4";

	private static final Pattern ENDS_WITH_DROP_OFF_ONLY = Pattern.compile("( DROP OFF ONLY$)", Pattern.CASE_INSENSITIVE);

	@Override
	public String cleanTripHeadsign(String tripHeadsign) {
		if (Utils.isUppercaseOnly(tripHeadsign, true, true)) {
			tripHeadsign = tripHeadsign.toLowerCase(Locale.ENGLISH);
		}
		tripHeadsign = STARTS_WITH_ROUTE_NUMBER.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = STARTS_WITH_DASH.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = ENDS_WITH_BOUND.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = ENDS_WITH_AM_PM.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = ENDS_WITH_DROP_OFF_ONLY.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = CleanUtils.keepToAndRemoveVia(tripHeadsign);
		Matcher matcherBYPASSING = BYPASSING.matcher(tripHeadsign);
		if (matcherBYPASSING.find()) {
			String gTripHeadsignBeforeBYPASSING = tripHeadsign.substring(0, matcherBYPASSING.start());
			tripHeadsign = gTripHeadsignBeforeBYPASSING;
		}
		tripHeadsign = SECONDARY_SCHOOL_.matcher(tripHeadsign).replaceAll(SECONDARY_SCHOOL_REPLACEMENT_);
		tripHeadsign = HIGH_SCHOOL_.matcher(tripHeadsign).replaceAll(HIGH_SCHOOL_REPLACEMENT_);
		tripHeadsign = SCHOOL_.matcher(tripHeadsign).replaceAll(SCHOOL_REPLACEMENT_);
		tripHeadsign = GO.matcher(tripHeadsign).replaceAll(GO_REPLACEMENT);
		tripHeadsign = PARK_AND_RIDE.matcher(tripHeadsign).replaceAll(PARK_AND_RIDE_REPLACEMENT);
		tripHeadsign = UNIVERSITY_.matcher(tripHeadsign).replaceAll(UNIVERSITY_REPLACEMENT);
		tripHeadsign = CleanUtils.CLEAN_AND.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.removePoints(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return CleanUtils.cleanLabel(tripHeadsign);
	}

	private static final Pattern STOP_CODE = Pattern.compile("( stop[\\W]*#[\\W]*[0-9]{1,4})", Pattern.CASE_INSENSITIVE);
	private static final String STOP_CODE_REPLACEMENT = "";

	private static final Pattern PLATFORM = Pattern.compile("( platform )", Pattern.CASE_INSENSITIVE);
	private static final String PLATFORM_REPLACEMENT = " P";

	private static final Pattern COMMUNITY_CENTRE = Pattern.compile("((^|\\W){1}(c\\.c\\.|cc|community centre)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String COMMUNITY_CENTRE_REPLACEMENT = "$2CC$4";

	private static final Pattern HIGH_SCHOOL = Pattern.compile("((^|\\W){1}(h\\.s\\.|hs|high school)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final String HIGH_SCHOOL_REPLACEMENT = "$2HS$4";

	@Override
	public String cleanStopName(String gStopName) {
		gStopName = gStopName.toLowerCase(Locale.ENGLISH);
		gStopName = GO.matcher(gStopName).replaceAll(GO_REPLACEMENT);
		gStopName = STOP_CODE.matcher(gStopName).replaceAll(STOP_CODE_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = PLATFORM.matcher(gStopName).replaceAll(PLATFORM_REPLACEMENT);
		gStopName = COMMUNITY_CENTRE.matcher(gStopName).replaceAll(COMMUNITY_CENTRE_REPLACEMENT);
		gStopName = HIGH_SCHOOL.matcher(gStopName).replaceAll(HIGH_SCHOOL_REPLACEMENT);
		gStopName = CleanUtils.removePoints(gStopName);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		gStopName = CleanUtils.cleanNumbers(gStopName);
		return CleanUtils.cleanLabel(gStopName);
	}

	@Override
	public int getStopId(GStop gStop) {
		if (!Utils.isDigitsOnly(gStop.getStopId())) {
			Matcher matcher = DIGITS.matcher(gStop.getStopId());
			if (matcher.find()) {
				return Integer.parseInt(matcher.group());
			}
			if ("VNYNBASB".equalsIgnoreCase(gStop.getStopId())) {
				return 10000;
			} else if ("VNBRYNSB".equalsIgnoreCase(gStop.getStopId())) {
				return 100001;
			} else if ("VNYNRONB".equalsIgnoreCase(gStop.getStopId())) {
				return 100002;
			} else if ("VNYNWDSB".equalsIgnoreCase(gStop.getStopId())) {
				return 100003;
			} else if ("VNYNCLNB".equalsIgnoreCase(gStop.getStopId())) {
				return 100004;
			} else if ("VNYN16SB".equalsIgnoreCase(gStop.getStopId())) {
				return 100005;
			} else if ("VNYNCTNB".equalsIgnoreCase(gStop.getStopId())) {
				return 100006;
			}
			System.out.printf("\nUnexpected stop ID for %s !\n", gStop);
			System.exit(-1);
			return -1;
		}
		return super.getStopId(gStop); // original stop ID used by real-time API
	}
}
