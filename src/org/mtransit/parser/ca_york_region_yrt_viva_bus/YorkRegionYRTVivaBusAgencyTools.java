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
import org.mtransit.parser.CleanUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Pair;
import org.mtransit.parser.SplitUtils;
import org.mtransit.parser.SplitUtils.RouteTripSpec;
import org.mtransit.parser.Utils;
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

	private static final long _98_99_RID = 980099l;
	private static final String RSN_98_99 = "98/99";
	private static final String RSN_098_099 = "098/099";

	private static final long RID_ENDS_WITH_A = 10000l;
	private static final long RID_ENDS_WITH_B = 20000l;
	private static final long RID_ENDS_WITH_C = 30000l;
	private static final long RID_ENDS_WITH_D = 40000l;
	private static final long RID_ENDS_WITH_E = 50000l;

	private static final String A = "a";
	private static final String B = "b";
	private static final String C = "c";
	private static final String D = "d";
	private static final String E = "e";

	private static final long VIVA_BLUE_RID = 601l;
	private static final long VIVA_BLUE_A_RID = 602l;
	private static final long VIVA_GREEN_RID = 606l;
	private static final long VIVA_ORANGE_RID = 605l;
	private static final long VIVA_PINK_RID = 604l;
	private static final long VIVA_PURPLE_RID = 603l;
	private static final long VIVA_YELLOW_RID = 607l;

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
		if (RSN_98_99.equals(routeShortNameLC) || RSN_098_099.equals(routeShortNameLC)) {
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
		String[] rsns = routeShortName.split("/");
		for (String rsn : rsns) {
			if (sb.length() > 0) {
				sb.append("/");
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
	private static final String HIGHWAY_404 = "Hwy 404";
	private static final String HIGHWAY_404_PARK_AND_RIDE = HIGHWAY_404 + " " + PARK_AND_RIDE_SHORT;
	private static final String DON_MILLS_STATION = "Don Mills Sta";
	private static final String MC_COWAN_ROAD = "McCowan Rd";
	private static final String MARTIN_GROVE = "Martin Grv";
	private static final String FINCH_TERMINAL = "Finch Terminal";
	private static final String MARKHAM_STOUFFVILLE_HOSPITAL = "Markham Stouffville Hosp";
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
	private static final String MAPLE_GO_STATION = "Maple GO Stn";
	private static final String MAPLE_GO = "Maple GO";
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


	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;
	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		map2.put(VIVA_BLUE_RID, new RouteTripSpec(VIVA_BLUE_RID, // Viva Blue
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, NEWMARKET_TERMINAL, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, FINCH_TERMINAL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"9769", // "70", // FINCH GO BUS TERMINAL PLATFORM 2
								"9779", // "80", // YONGE / 16TH-CARRVILLE,YONGE ST & 16TH AV
								"9787", // "88", // != YONGE / ELGIN MILLS,YONGE ST & ELGIN MILLS RD
								"9789", // "90", // <> BERNARD TERMINAL PLATFORM 2
								"9790", // "91", // != YONGE / BERNARD,YONGE ST & BERNARD AV
								"9809", // "110", // NEWMARKET GO TERMINAL PLATFORM 9
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"9809", // "110", // NEWMARKET GO TERMINAL PLATFORM 9
								"9799", // "100", // YONGE / HENDERSON,YONGE ST & HENDERSON DR
								"9793", // "94", // != YONGE / 19TH-GAMBLE,YONGE ST & GAMBLE RD
								"9789", // "90", // <> BERNARD TERMINAL PLATFORM 2
								"9791", // "92", // != YONGE / BERNARD,YONGE ST & BERNARD AV
								"9769", // "70", // FINCH GO BUS TERMINAL PLATFORM 2
						})) //
				.compileBothTripSort());
		map2.put(VIVA_BLUE_A_RID, new RouteTripSpec(VIVA_BLUE_A_RID, // Viva Blue A
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, NEWMARKET_TERMINAL, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, FINCH_TERMINAL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"9769", // "70", // FINCH GO BUS TERMINAL PLATFORM 2
								"9787", // "88", // YONGE / ELGIN MILLS,YONGE ST & ELGIN MILLS RD
								"9809", // "110", // NEWMARKET GO TERMINAL PLATFORM 9
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"9809", // "110", // NEWMARKET GO TERMINAL PLATFORM 9
								"9791", // "92", // YONGE / BERNARD,YONGE ST & BERNARD AV,
								"9769", // "70", // FINCH GO BUS TERMINAL PLATFORM 2
						})) //
				.compileBothTripSort());
		map2.put(VIVA_GREEN_RID, new RouteTripSpec(VIVA_GREEN_RID, // Viva Green
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, MC_COWAN_ROAD, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DON_MILLS_STATION) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"9767", // "68", // DON MILLS STATION
								"9742", // "47", // ENTERPRISE / WARDEN,ENTERPRISE BLVD & WARDEN AV
								"9751", // "56", // HWY 7 / MCCOWAN,HIGHWAY 7 & MCCOWAN RD
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"9752", // "57", // HWY 7 / MCCOWAN,HIGHWAY 7 & MCCOWAN RD
								"9761", // "62", // WARDEN AV / 14TH AV
								"9816", // "117", // SHEPPARD / DON MILLS
						})) //
				.compileBothTripSort());
		map2.put(VIVA_ORANGE_RID, new RouteTripSpec(VIVA_ORANGE_RID, // Viva Orange
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, MARTIN_GROVE, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, RICHMOND_HL_CTR) // SHEPPARD_WEST
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"9821", // "122", // RICHMOND HILL CENTRE PLATFORM 2
								"9708", // "13", // == HWY 7 / ANSLEY GROVE
								"9705", // "10", // <> HWY 7 / PINE VALLEY => SOUTH
								"9706", // "11", // != HWY 7 / PINE VALLEY
								"9702", // "7", // HWY 7 / KIPLING
								"3525", // "744", // MARTIN GROVE RD / HIGHWAY 7
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"9700", // "5", // HWY 7 / MARTIN GROVE
								"9703", // "8", // != HWY 7 / ISLINGTON
								"9705", // "10", // <> HWY 7 / PINE VALLEY
								"9707", // "12", // != HWY 7 / ANSLEY GROVE
								"9821", // "122", // RICHMOND HILL CENTRE PLATFORM 2
						})) //
				.compileBothTripSort());
		map2.put(VIVA_PINK_RID, new RouteTripSpec(VIVA_PINK_RID, // Viva Pink
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, FINCH_TERMINAL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"9836", // "7747", // FINCH GO BUS TERMINAL PLATFORM 1
								"9734", // "39", // HWY 7 / ALLSTATE
								"9746", // "51", // UNIONVILLE STATION PLATFORM 1
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"9746", // "51", // UNIONVILLE STATION PLATFORM 1
								"9733", // "38", // HWY 7 / EAST BEAVER CREEK
								"9836", // "7747", // FINCH GO BUS TERMINAL PLATFORM 1
						})) //
				.compileBothTripSort());
		map2.put(VIVA_PURPLE_RID, new RouteTripSpec(VIVA_PURPLE_RID, // Viva Purple
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, MARKHAM_STOUFFVILLE_HOSPITAL, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, PIONEER_VLG) // YORK_UNIVERSITY) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"7195", // "7959", // PIONEER VILLAGE STATION PLATFORM 1
								"9715", // "20", // == YORK UNIVERSITY
								"9854", // "6911", // != HIGHWAY 7 / KEELE ST
								"9718", // "23", // == CENTRE / DUFFERIN
								"9721", // "26", // == BATHURST / ATKINSON
								"9820", // "121", // <> RICHMOND HILL CENTRE PLATFORM 1 CONTINUE
								"VN603EB1", // "8027", // !=
								"9724", // "29", // !=
								"9734", // "39", // HWY 7 / ALLSTATE
								"9740", // "45", // == HWY 7 / TOWN CENTRE
								"9865", // "7982", // != HWY 7 / WARDEN AV
								"4176", // "2753", // != HWY 7 / KENNEDY RD
								"9842", // "6230", // != CEDARLAND DR / WARDEN AV
								"9747", // "52", // != KENNEDY RD / HWY 7
								"9749", // "54", // == HWY 7 / BULLOCK
								"9810", // "111", // MARKHAM STOUFFVILLE HOSPITAL
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"9810", // "111", // MARKHAM STOUFFVILLE HOSPITAL
								"9750", // "55", // == HWY 7 / BULLOCK
								"VN603WB6", // "8039", // != 7 HWY & HIGHWAY 7
								"4716", // "2916", // != HWY 7 / KENNEDY RD
								"9866", // "7983", // != HWY 7 / WARDEN AV
								"9748", // "53", // != KENNEDY RD / HWY 7
								"9841", // "6229", // != CEDARLAND DR / WARDEN AV
								"9741", // "46", // == HWY 7 / TOWN CENTRE
								"9733", // "38", // HWY 7 / EAST BEAVER CREEK
								"9725", // "30", // == HWY 7 & BAYVIEW AV
								"9820", // "121", // <> RICHMOND HILL CENTRE PLATFORM 1 => END
								"9821", // "122", // != RICHMOND HILL CENTRE PLATFORM 2 CONTINUE
								"9722", // "27", // != BATHURST ST & ATKINSON AV
								"9822", // "123", // YORK UNIVERSITY
								"7195", // "7959", // PIONEER VILLAGE STATION PLATFORM 1
						})) //
				.compileBothTripSort());
		map2.put(VIVA_YELLOW_RID, new RouteTripSpec(VIVA_YELLOW_RID, // Viva Yellow
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, HIGHWAY_404_PARK_AND_RIDE, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, NEWMARKET_TERMINAL) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"6426", // "7828", // NEWMARKET GO TRML PLAT 10
								"9847", // "6907", // SOUTH LAKE HOSPITAL
								"9856", // "6574", // DAVIS DR / HIGHWAY 404
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"9856", // "6574", // DAVIS DR / HIGHWAY 404
								"9848", // "7112", // SOUTH LAKE HOSPITAL
								"6426", // "7828", // NEWMARKET GO TRML PLAT 10
						})) //
				.compileBothTripSort());
		map2.put(21L, new RouteTripSpec(21L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Vellore", //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VAUGHAN_MILLS_TERMINAL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"6273", // "5479", // VAUGHAN MILLS TERMINAL PLATFORM 5
								"4295", // "1074", // ++
								"6615", // "6006", // == VELLORE AV / MAJOR MACKENZIE DR
								"6899", // "6337", // != #AM POETRY DR / FLOURISH ST
								"5731", // "4066", // != #AM CANADA DR / SUMMIT DR
								"5732", // "4738", // != #AM CANADA DR / CITYVIEW BLVD =>
								"6849", // "6674", // != #PM MAJOR MACKENZIE DR / FOSSIL HILL RD
								"6920", // "6351", // != #PM CITYVIEW BLVD / VENICE GT
								"6919", // "6350", // != #PM CANADA DR / SUMMIT DR =>
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"6919", // "6350", // != #PM CANADA DR / SUMMIT DR <=
								"6898", // "6336", // != #PM POETRY DR / MAJOR MACKENZIE DR
								"5732", // "4738", // != #AM CANADA DR / CITYVIEW BLVD <=
								"5733", // "4068", // != #AM CITYVIEW BLVD STOP # 5733
								"6848", // "6673", // != #AM MAJOR MACKENZIE DR / FOSSIL HIL RD
								"6620", // "5716", // == VELLORE AV / EURO PLACE
								"3049", // "515", // ++
								"6273", // "5479", // VAUGHAN MILLS TERMINAL PLATFORM 5
						})) //
				.compileBothTripSort());
		map2.put(26L, new RouteTripSpec(26L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Brandon Gt", // MAPLE
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "SmartCentres Pl") // VAUGHAN_MILLS_TERMINAL
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"7207", // "7971", // SMARTCENTRES PLACE BUS TERMINAL
								"4308", // "1079", // != VAUGHAN MILLS MALL STOP # 4308
								"3319", // "568", // <> VAUGHAN MILLS TERMINAL PLATFORM 6
								"6768", // "6198", // != CALDARI RD / GRANITERIDGE RD
								"4499", // "1139", // ++ MELVILLE AV / EDDINGTON PL
								"2930", // "466", // MELVILLE AV / MAPLE MEADOWS LANE
								"4501", // "1141", // BRANDON GATE DR / JANE ST
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"4501", // "1141", // BRANDON GATE DR / JANE ST
								"6646", // "5341", // ++ MELVILLE AV / KELSO CR
								"6767", // "6197", // != CALDARI RD / GRANITERIDGE RD
								"3319", // "568", // <> VAUGHAN MILLS TERMINAL PLATFORM 6
								"4320", // "1088", // != VAUGHAN MILLS MALL STOP # 4320
								"7207", // "7971", // SMARTCENTRES PLACE BUS TERMINAL
						})) //
				.compileBothTripSort());
		map2.put(31L, new RouteTripSpec(31L, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "East", // Aurora GO Sta
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "West") // ??
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"1210", // "3336", // AURORA HEIGHTS DR / WHISPERING PINE
								"2512", // "335", // == YONGE ST STOP # 2512
								"2410", // "3564", // == ST. JOHN'S SDRD / OLD YONGE ST
								"5245", // "4053", // == INDUSTRIAL PKWY / WELLINGTON ST
								"6093", // "7809", // != WELLINGTON ST STOP # 6093
								"5253", // "4058", // == INDUSTRIAL PKWY STOP # 5253
								"6424", // "7661", // AURORA GO STATION PLATFORM #2
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"6424", // "7661", // AURORA GO STATION PLATFORM #2
								"6391", // "5897", // WELLINGTON ST / TEMPERANCE ST
								"1191", // "3329", // == WELLINGTON ST / HAIDA DR
								"4748", // "3903", // != WELLINGTON ST / MCDONALD DR
								"5079", // "4021", // != MCDONALD DR / HAIDA DR
								"4737", // "3893", // != HAIDA DR / MCDONALD ST
								"4736", // "3892", // == HAIDA DR / AURORA HEIGHTS DR
								"1210", // "3336", // AURORA HEIGHTS DR / WHISPERING PINE
						})) //
				.compileBothTripSort());
		map2.put(40l, new RouteTripSpec(40l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, WOODBINE_AVENUE) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"6512", // "7841", // RODICK RD / WOODBINE AV
								"1461", // "1911", // ++ TOWN CENTRE BLVD / HIGHWAY 7
								"1827", // "2152", // MARKVILLE MALL STOP #1827
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"1827", // "2152", // MARKVILLE MALL STOP #1827
								"1541", // "1990", // ++ BUCHANAN DR / SPANHOUSE CRES
								"6512", // "7841", // RODICK RD / WOODBINE AV
						})) //
				.compileBothTripSort());
		map2.put(41l, new RouteTripSpec(41l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, MARKHAM, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"1827", // "2152", // MARKVILLE MALL STOP #1827
								"1814", // "2145", // RAYMERVILLE DR / CARPENTER CRT
								"1844", // "2169", // LARKIN AV / SAWYER CRES
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"1844", // "2169", // LARKIN AV / SAWYER CRES
								"1862", // "2184", // BULLOCK DR / SNIDER DR
								"1827", // "2152", // MARKVILLE MALL STOP #1827
						})) //
				.compileBothTripSort());
		map2.put(42l, new RouteTripSpec(42l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BERCZY) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"5977", // "7803", // MAIN ST UNIONVILLE / ENTERPRISE BLV
								"9745", // "50", // RIVIS RD / YMCA BLVD
								"4171", // "2750", // UNIONVILLE GO STATION PLATFORM 2
								"2971", // "499", // MAJOR MACKENZIE DR / RIDGECREST RD
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"2971", // "499", // MAJOR MACKENZIE DR / RIDGECREST RD
								"1824", // "2150", // CARLTON RD / MCCOWAN RD
								"4171", // "2750", // UNIONVILLE GO STATION PLATFORM 2
								"9744", // "49", // RIVIS RD / YMCA BLVD
								"6308", // "7628", // ENTERPRISE DR / MAIN STREET
						})) //
				.compileBothTripSort());
		map2.put(44l, new RouteTripSpec(44l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, GREEN_LANE, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, NEWMARKET_TERMINAL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"4691", // "1204", // NEWMARKET GO TERMINAL PLATFORM 6
								"1971", // "3379", // != UPPER CANADA MALL STOP # 1971
								"5944", // "5093", // == DAVIS DR / FORD WILSON DR
								"5698", // "4122", // WOODSPRING AV / ALFRED SMITH WAY
								"4680", // "1195", // GREEN LANE / YONGE ST
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"4680", // "1195", // GREEN LANE / YONGE ST
								"5421", // "4086", // LONDON RD / YORKSHIRE DR
								"4691", // "1204", // NEWMARKET GO TERMINAL PLATFORM 6
						})) //
				.compileBothTripSort());
		map2.put(45l, new RouteTripSpec(45l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, MINGAY, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"1827", // "2152", // MARKVILLE MALL STOP #1827
								"1383", // "1874", // BUR OAK AV / DOGWOOD ST
								"4799", // "1234", // MAJOR MACKENZIE DR / MINGAY AV
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"4799", // "1234", // MAJOR MACKENZIE DR / MINGAY AV
								"5541", // "5619", // RAYMERVILLE DR / BENDAMERE CRES
								"1827", // "2152", // MARKVILLE MALL STOP #1827
						})) //
				.compileBothTripSort());
		map2.put(84l, new RouteTripSpec(84l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "North", //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "South") //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"4839", // "3923", // KING RD / YONGE ST
								"2658", // "3723", // HUMBERLAND DR / WOODHAVEN CRES
								"2659", // "349", // YONGE ST / COON'S RD
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"2659", // "349", // YONGE ST / COON'S RD
								"2359", // "2380", // NORTH LAKE RD / OLDE BAYVIEW AV,
								"4839", // "3923", // KING RD / YONGE ST
						})) //
				.compileBothTripSort());
		map2.put(90l + RID_ENDS_WITH_B, new RouteTripSpec(90l + RID_ENDS_WITH_B, // 90B
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BEAVER_CREEK, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DON_MILLS_STATION) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"9767", // "68", // DON MILLS STATION
								"2920", // "2543", // EAST BEAVER CREEK RD / HIGHWAY 7
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"2920", // "2543", // EAST BEAVER CREEK RD / HIGHWAY 7
								"2917", // "2540", // WEST BEAVER CREEK RD / WERTHEIM CRT,
								"1014", // "1604", // COMMERCE VALLEY DR STOP # 1014
								"4215", // "2776", // SHEPPARD AV / DON MILLS RD
						})) //
				.compileBothTripSort());
		map2.put(98l, new RouteTripSpec(98l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, GREEN_LANE, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BERNARD_TERMINAL) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"4197", // "3787", // BERNARD TERMINAL PLATFORM 5
								"4680", // "1195", // GREEN LANE / YONGE ST
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"4680", // "1195", // GREEN LANE / YONGE ST
								"4197", // "3787", // BERNARD TERMINAL PLATFORM 5
						})) //
				.compileBothTripSort());
		map2.put(204L, new RouteTripSpec(204L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BERCZY, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"4171", // "2750", // UNIONVILLE GO STATION PLATFORM 2
								"1505", // "1953", // CARLTON RD / MANSFIELD LANE
								"2971", // "499", // MAJOR MACKENZIE DR / RIDGECREST RD
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"2971", // "499", // MAJOR MACKENZIE DR / RIDGECREST RD
								"6092", // "5258", // == BUR OAK AV STOP # 6092
								"1401", // "1882", // != BUR OAK AV / THE BRIDLE WALK,
								"6690", // "6077", // != THE BRIDLE WALK / HOST AV
								"4171", // "2750", // UNIONVILLE GO STATION PLATFORM 2
						})) //
				.compileBothTripSort());
		map2.put(522L, new RouteTripSpec(522L, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "East", //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "West") //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"5246", // "4651", // HAGGERMANS CORNER STOP #5246
								"5986", // "7804", // CORNELL PARK AV / WALKERVILLE RD
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"5986", // "7804", // CORNELL PARK AV / WALKERVILLE RD
								"6305", // "7626", // TONY WONG PLACE / KENNEDY RD
								"5246", // "4651", // HAGGERMANS CORNER STOP #5246
						})) //
				.compileBothTripSort());
		map2.put(589l, new RouteTripSpec(589l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Bernard / Dunlop St", //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "") //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"7106", // "6525", // HILLCREST MALL
								"5319", // "1366", // OBSERVATORY TOWERS STOP # 5319
								"2961", // "490", // == MAJOR MACKENZIE DR / HARDING BLVD
								"2962", // "491", // != MAJOR MACKENZIE DR / ARNOLD CRES
								"2964", // "493", // != MAJOR MACKENZIE DR / YONGE ST
								"4694", // "1207", // != xx YONGE ST / ARNOLD CRES
								"5322", // "1368", // != MCCONAGHY CENTRE STOP # 5322
								"4694", // "1207", // != xx YONGE ST / ARNOLD CRES
								"2965", // "494", // == MAJOR MACKENZIE DR / BAKER AV
								"6605", // "6049", // ==
								"5839", // "4763", // xx
								"4402", // "1098", // xx
								"1152", // "1722", // !=
								"5839", // "4763", // xx
								"4402", // "1098", // xx
								"5839", // "4763", // xx
								"1693", // "207", // ==
								"2750", // "372", // DUNLOP ST STOP #
								"6321", // "7612", // UPPER YONGE PLACE
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { /* no stops */})) //
				.compileBothTripSort());
		map2.put(590L, new RouteTripSpec(590L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, StringUtils.EMPTY, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Hillcrest Mall") //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { /* no stops */})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"6321", // "7612", // UPPER YONGE PLACE
								"4628", // "1182", // RICHMOND HEIGHTS NO FRILLS STOP # 4
								"1707", // "215", // MAJOR MACKENZIE DR / BAKER AV
								"4950", // "1287", // MAJOR MACKENZIE DR / YONGE ST
								"4694", // "1207", // YONGE ST / ARNOLD CRES
								"5322", // "1368", // MCCONAGHY CENTRE STOP # 5322
								"6125", // "5382", // HARDING BLVD / KERSEY CRES
								"7106", // "6525", // HILLCREST MALL
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
		if (isGoodEnoughAccepted()) {
			if (tripHeadsign.startsWith(mRoute.getShortName())) {
				tripHeadsign = tripHeadsign.substring(mRoute.getShortName().length() + 1);
			}
			if (mRoute.getId() >= 400L && mRoute.getId() <= 499L) {
				mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign) + " " + gTrip.getDirectionId(), gTrip.getDirectionId());
				return;
			}
		}
		mTrip.setHeadsignString(cleanTripHeadsign(tripHeadsign), gTrip.getDirectionId() == null ? 0 : gTrip.getDirectionId());
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
					"Steeles AV" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Steeles AV", mTrip.getHeadsignId());
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
					"Steeles AV" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Steeles AV", mTrip.getHeadsignId());
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
					SENECA_COLLEGE_KING_CAMPUS, //
					SENECA_KING, //
					"Villanova HS" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Villanova HS", mTrip.getHeadsignId());
				return true;
			} else if (Arrays.asList( //
					MAPLE_GO, //
					MAPLE_GO_STATION //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(MAPLE_GO, mTrip.getHeadsignId());
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
		} else if (mTrip.getRouteId() == 105L) {
			if (Arrays.asList( //
					RUTHERFORD, //
					MAJOR_MACKENZIE //
					).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(MAJOR_MACKENZIE, mTrip.getHeadsignId());
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
		}
		System.out.printf("\nUnexpected trips to merge: %s & %s!\n", mTrip, mTripToMerge);
		System.exit(-1);
		return false;
	}

	private static final Pattern TO = Pattern.compile("((^|\\W){1}(to)(\\W|$){1})", Pattern.CASE_INSENSITIVE);
	private static final Pattern VIA = Pattern.compile("((^|\\W){1}(via)(\\W|$){1})", Pattern.CASE_INSENSITIVE);

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

	@Override
	public String cleanTripHeadsign(String tripHeadsign) {
		if (Utils.isUppercaseOnly(tripHeadsign, true, true)) {
			tripHeadsign = tripHeadsign.toLowerCase(Locale.ENGLISH);
		}
		tripHeadsign = STARTS_WITH_ROUTE_NUMBER.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = STARTS_WITH_DASH.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = ENDS_WITH_BOUND.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = ENDS_WITH_AM_PM.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		Matcher matcherTO = TO.matcher(tripHeadsign);
		if (matcherTO.find()) {
			String gTripHeadsignAfterTO = tripHeadsign.substring(matcherTO.end());
			tripHeadsign = gTripHeadsignAfterTO;
		}
		Matcher matcherVIA = VIA.matcher(tripHeadsign);
		if (matcherVIA.find()) {
			String gTripHeadsignBeforeVIA = tripHeadsign.substring(0, matcherVIA.start());
			tripHeadsign = gTripHeadsignBeforeVIA;
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
