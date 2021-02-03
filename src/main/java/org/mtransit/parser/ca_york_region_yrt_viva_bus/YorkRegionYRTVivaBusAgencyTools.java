package org.mtransit.parser.ca_york_region_yrt_viva_bus;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mtransit.commons.OneBusAwayCommons;
import org.mtransit.parser.CleanUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.MTLog;
import org.mtransit.parser.Pair;
import org.mtransit.parser.SplitUtils;
import org.mtransit.parser.SplitUtils.RouteTripSpec;
import org.mtransit.parser.StringUtils;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mtransit.parser.StringUtils.EMPTY;

// https://www.yrt.ca/en/about-us/open-data.aspx
// https://www.yrt.ca/google/google_transit.zip
public class YorkRegionYRTVivaBusAgencyTools extends DefaultAgencyTools {

	public static void main(@Nullable String[] args) {
		if (args == null || args.length == 0) {
			args = new String[3];
			args[0] = "input/gtfs.zip";
			args[1] = "../../mtransitapps/ca-york-region-yrt-viva-bus-android/res/raw/";
			args[2] = ""; // files-prefix
		}
		new YorkRegionYRTVivaBusAgencyTools().start(args);
	}

	@Nullable
	private HashSet<Integer> serviceIds;

	@Override
	public void start(@NotNull String[] args) {
		MTLog.log("Generating YRT Viva bus data...");
		long start = System.currentTimeMillis();
		this.serviceIds = extractUsefulServiceIdInts(args, this, true);
		super.start(args);
		MTLog.log("Generating YRT Viva bus data... DONE in %s.", Utils.getPrettyDuration(System.currentTimeMillis() - start));
	}

	@Override
	public boolean excludingAll() {
		return this.serviceIds != null && this.serviceIds.isEmpty();
	}

	@Override
	public boolean excludeCalendar(@NotNull GCalendar gCalendar) {
		if (this.serviceIds != null) {
			return excludeUselessCalendarInt(gCalendar, this.serviceIds);
		}
		return super.excludeCalendar(gCalendar);
	}

	@Override
	public boolean excludeCalendarDate(@NotNull GCalendarDate gCalendarDates) {
		if (this.serviceIds != null) {
			return excludeUselessCalendarDateInt(gCalendarDates, this.serviceIds);
		}
		return super.excludeCalendarDate(gCalendarDates);
	}

	@Override
	public boolean excludeTrip(@NotNull GTrip gTrip) {
		final String tripHeadsignLC = gTrip.getTripHeadsignOrDefault().toLowerCase(Locale.ENGLISH);
		if (tripHeadsignLC.startsWith("yrt training bus")) {
			return true; // exclude training bus
		}
		if (this.serviceIds != null) {
			return excludeUselessTripInt(gTrip, this.serviceIds);
		}
		return super.excludeTrip(gTrip);
	}

	private static final String TTC = "TTC ";

	@Override
	public boolean excludeRoute(@NotNull GRoute gRoute) {
		if (gRoute.getRouteLongNameOrDefault().startsWith(TTC)) {
			return true; // skip TTC agency bus routes
		}
		if (gRoute.getRouteLongNameOrDefault().endsWith(" TRAINING BUS")) {
			return true; // exclude training bus
		}
		return super.excludeRoute(gRoute);
	}

	@NotNull
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
	public long getRouteId(@NotNull GRoute gRoute) {
		String routeLongName = gRoute.getRouteLongNameOrDefault();
		String routeShortName = gRoute.getRouteShortName();
		if (routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return Integer.parseInt(routeShortName); // using route short name as route ID
		}
		String routeShortNameLC = routeShortName.toLowerCase(Locale.ENGLISH);
		String routeLongNameLC = routeLongName.toLowerCase(Locale.ENGLISH);
		if (routeLongNameLC.contains(VIVA)) {
			if (routeLongNameLC.endsWith(BLUE)
					|| routeShortNameLC.endsWith(BLUE)) {
				return VIVA_BLUE_RID;
			} else if (routeLongNameLC.endsWith(BLUE_A)) {
				return VIVA_BLUE_A_RID;
			} else if (routeLongNameLC.endsWith(GREEN)
					|| routeShortNameLC.endsWith(GREEN)) {
				return VIVA_GREEN_RID;
			} else if (routeLongNameLC.endsWith(ORANGE)
					|| routeShortNameLC.endsWith(ORANGE)) {
				return VIVA_ORANGE_RID;
			} else if (routeLongNameLC.endsWith(PINK)) {
				return VIVA_PINK_RID;
			} else if (routeLongNameLC.endsWith(PURPLE)
					|| routeShortNameLC.endsWith(PURPLE)) {
				return VIVA_PURPLE_RID;
			} else if (routeLongNameLC.endsWith(YELLOW)
					|| routeShortNameLC.endsWith(YELLOW)) {
				return VIVA_YELLOW_RID;
			}
		} else {
			if (routeShortNameLC.equalsIgnoreCase(BLUE)) {
				return VIVA_BLUE_RID;
			} else if (routeShortNameLC.equalsIgnoreCase(GREEN)) {
				return VIVA_GREEN_RID;
			} else if (routeShortNameLC.equalsIgnoreCase(ORANGE)) {
				return VIVA_ORANGE_RID;
			} else if (routeShortNameLC.equalsIgnoreCase(PURPLE)) {
				return VIVA_PURPLE_RID;
			} else if (routeShortNameLC.equalsIgnoreCase(YELLOW)) {
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
			throw new MTLog.Fatal(e, "Error while extracting route ID for %s!", gRoute);
		}
		throw new MTLog.Fatal("Unexpected route ID for %s!", gRoute);
	}

	@Nullable
	@Override
	public String getRouteColor(@NotNull GRoute gRoute) {
		if (getRouteId(gRoute) == VIVA_YELLOW_RID) {
			if ("F7FE2E".equalsIgnoreCase(gRoute.getRouteColor())) {
				return "FFCC00";
			}
		}
		return super.getRouteColor(gRoute);
	}

	private static final Pattern REMOVE_LEADING_ZEROS = Pattern.compile("(^0+)", Pattern.CASE_INSENSITIVE);

	@Nullable
	@Override
	public String getRouteShortName(@NotNull GRoute gRoute) {
		String routeLongNameLC = gRoute.getRouteLongNameOrDefault().toLowerCase(Locale.ENGLISH);
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
		if (routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return routeShortName;
		}
		StringBuilder sb = new StringBuilder();
		routeShortName = routeShortName.replace("/", "|");
		String[] rsns = routeShortName.split("\\|");
		for (String rsn : rsns) {
			if (sb.length() > 0) {
				sb.append("|");
			}
			sb.append(REMOVE_LEADING_ZEROS.matcher(rsn).replaceAll(EMPTY));
		}
		return sb.toString();
	}

	private static final Pattern SS = Pattern.compile("((^|\\W)(school special|ss)(\\W|$))", Pattern.CASE_INSENSITIVE);
	private static final String SS_REPLACEMENT = "$2" + "SS" + "$4";

	private static final String RLN_VIVA = "Viva";

	@NotNull
	@Override
	public String getRouteLongName(@NotNull GRoute gRoute) {
		String routeLongName = gRoute.getRouteLongNameOrDefault();
		final String rsn = gRoute.getRouteShortName();
		if (routeLongName.toLowerCase(Locale.ENGLISH).startsWith(VIVA) //
				|| rsn.toLowerCase(Locale.ENGLISH).startsWith(VIVA)) {
			return RLN_VIVA;
		}
		String routeShortNameLC = rsn.toLowerCase(Locale.ENGLISH);
		if (routeShortNameLC.equalsIgnoreCase(BLUE)) {
			return RLN_VIVA;
		} else if (routeShortNameLC.equalsIgnoreCase(GREEN)) {
			return RLN_VIVA;
		} else if (routeShortNameLC.equalsIgnoreCase(ORANGE)) {
			return RLN_VIVA;
		} else if (routeShortNameLC.equalsIgnoreCase(PURPLE)) {
			return RLN_VIVA;
		} else if (routeShortNameLC.equalsIgnoreCase(YELLOW)) {
			return RLN_VIVA;
		}
		if (StringUtils.isEmpty(routeLongName)) {
			//noinspection ConstantConditions // FIXME
			if (true) {
				return "Route " + rsn;
			}
			throw new MTLog.Fatal("Unexpected route long name for %s!", gRoute);
		}
		routeLongName = CleanUtils.toLowerCaseUpperCaseWords(Locale.ENGLISH, routeLongName, getIgnoredWords());
		routeLongName = SS.matcher(routeLongName).replaceAll(SS_REPLACEMENT);
		routeLongName = CleanUtils.cleanSlashes(routeLongName);
		routeLongName = CleanUtils.cleanStreetTypes(routeLongName);
		return CleanUtils.cleanLabel(routeLongName);
	}

	private static final String AGENCY_COLOR = "0079C2"; // BLUE (Android App Icon)

	@NotNull
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
	private static final String FINCH_TERMINAL = "Finch Term";
	private static final String YORK_UNIVERSITY = "York " + UNIVERSITY_SHORT;
	private static final String VAUGHAN_MILLS = "Vaughan Mills";
	private static final String VAUGHAN_MILLS_MALL = VAUGHAN_MILLS + " Mall";
	private static final String VAUGHAN_MILLS_TERMINAL = VAUGHAN_MILLS + " Term";
	private static final String WOODBINE_AVENUE = "Woodbine Ave";
	private static final String MARKHAM = "Markham";
	private static final String BERCZY = "Berczy";
	private static final String UNIONVILLE_GO_STATION = "Unionville GO Sta";
	private static final String GREEN_LANE = "Grn Ln";
	private static final String NEWMARKET_TERMINAL = "Newmarket Term";
	private static final String MARKVILLE_MALL = "Markville Mall";
	private static final String RICHMOND_HL_CTR = "Richmond Hl Ctr";
	private static final String SENECA_COLLEGE_KING_CAMPUS = "Seneca College King Campus";
	private static final String BATHURST = "Bathurst";
	private static final String STONE_ROAD = "Stone Rd";
	private static final String TESTON_ROAD = "Teston Rd";
	private static final String LEBOVIC_CAMPUS_DRIVE = "Lebovic Campus Dr";
	private static final String PROMENADE_TERMINAL = "Promenade Term";
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
	private static final String BERNARD_TERMINAL = "Bernard Term";
	private static final String BEAVER_CREEK = "Beaver Crk";
	private static final String MINGAY = "Mingay";
	private static final String PIONEER_VLG = "Pioneer Vlg";
	private static final String PIONEER_VLG_TERMINAL = PIONEER_VLG + " Term";
	private static final String MAJOR_MACKENZIE = "Major Mackenzie";
	private static final String CANADA_DRIVE = "Canada Dr";
	private static final String SMART_CENTRES_PLACE = "SmartCentres Pl";

	private static final HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;

	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<>();
		//noinspection deprecation
		map2.put(21L, new RouteTripSpec(21L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "Vellore", //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, VAUGHAN_MILLS_TERMINAL) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"6273", // VAUGHAN MILLS TERMINAL PLATFORM 5
								"4295", // ++
								"6615", // == VELLORE AV / MAJOR MACKENZIE DR
								"6899", // != #AM POETRY DR / FLOURISH ST
								"5731", // != #AM CANADA DR / SUMMIT DR
								"5732", // != #AM CANADA DR / CITYVIEW BLVD =>
								"6849", // != #PM MAJOR MACKENZIE DR / FOSSIL HILL RD
								"6920", // != #PM CITYVIEW BLVD / VENICE GT
								"6919" // != #PM CANADA DR / SUMMIT DR =>
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"6919", // != #PM CANADA DR / SUMMIT DR <=
								"6898", // != #PM POETRY DR / MAJOR MACKENZIE DR
								"5732", // != #AM CANADA DR / CITYVIEW BLVD <=
								"5733", // != #AM CITYVIEW BLVD STOP # 5733
								"6848", // != #AM MAJOR MACKENZIE DR / FOSSIL HIL RD
								"6620", // == VELLORE AV / EURO PLACE
								"3049", // ++
								"6273" // VAUGHAN MILLS TERMINAL PLATFORM 5
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(31L, new RouteTripSpec(31L, //
				OneBusAwayCommons.EAST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "East", // Aurora GO Sta
				OneBusAwayCommons.WEST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "West") // ??
				.addTripSort(OneBusAwayCommons.EAST_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"1210", // AURORA HEIGHTS DR / WHISPERING PINE
								"2512", // == YONGE ST STOP # 2512
								"2410", // == ST. JOHN'S SDRD / OLD YONGE ST
								"5245", // == INDUSTRIAL PKWY / WELLINGTON ST
								"6093", // != WELLINGTON ST STOP # 6093
								"5253", // == INDUSTRIAL PKWY STOP # 5253
								"6424" // AURORA GO STATION PLATFORM #2
						)) //
				.addTripSort(OneBusAwayCommons.WEST_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"6424", // AURORA GO STATION PLATFORM #2
								"6391", // WELLINGTON ST / TEMPERANCE ST
								"1191", // == WELLINGTON ST / HAIDA DR
								"4748", // != WELLINGTON ST / MCDONALD DR
								"5079", // != MCDONALD DR / HAIDA DR
								"4737", // != HAIDA DR / MCDONALD ST
								"4736", // == HAIDA DR / AURORA HEIGHTS DR
								"1210" // AURORA HEIGHTS DR / WHISPERING PINE
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(40L, new RouteTripSpec(40L, //
				OneBusAwayCommons.EAST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL, //
				OneBusAwayCommons.WEST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, WOODBINE_AVENUE) //
				.addTripSort(OneBusAwayCommons.EAST_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"6512", // RODICK RD / WOODBINE AV
								"1461", // ++ TOWN CENTRE BLVD / HIGHWAY 7
								"1827" // MARKVILLE MALL STOP #1827
						)) //
				.addTripSort(OneBusAwayCommons.WEST_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"1827", // MARKVILLE MALL STOP #1827
								"1541", // ++ BUCHANAN DR / SPANHOUSE CRES
								"6512" // RODICK RD / WOODBINE AV
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(41L, new RouteTripSpec(41L, //
				OneBusAwayCommons.EAST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKHAM, //
				OneBusAwayCommons.WEST_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL) //
				.addTripSort(OneBusAwayCommons.EAST_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"1827", // MARKVILLE MALL STOP #1827
								"1814", // RAYMERVILLE DR / CARPENTER CRT
								"1844" // LARKIN AV / SAWYER CRES
						)) //
				.addTripSort(OneBusAwayCommons.WEST_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"1844", // LARKIN AV / SAWYER CRES
								"1862", // BULLOCK DR / SNIDER DR
								"1827" // MARKVILLE MALL STOP #1827
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(42L, new RouteTripSpec(42L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, BERCZY) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"5977", // MAIN ST UNIONVILLE / ENTERPRISE BLV
								"9745", // != RIVIS RD / YMCA BLVD
								"4171", // <> UNIONVILLE GO STATION PLATFORM 2
								"4907", // != YMCA BLVD / RIVIS RD
								"2971" // MAJOR MACKENZIE DR / RIDGECREST RD
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"2971", // MAJOR MACKENZIE DR / RIDGECREST RD
								"1824", // CARLTON RD / MCCOWAN RD
								"4906", // != YMCA BLVD / RIVIS RD
								"4171", // <> UNIONVILLE GO STATION PLATFORM 2
								"9744", // != RIVIS RD / YMCA BLVD
								"6308" // ENTERPRISE DR / MAIN STREET
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(44L, new RouteTripSpec(44L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, GREEN_LANE, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, NEWMARKET_TERMINAL) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"7314", // NEWMARKET GO TERMINAL
								"4691", // NEWMARKET GO TERMINAL
								"1971", // != UPPER CANADA MALL STOP # 1971
								"5944", // == DAVIS DR / FORD WILSON DR
								"5698", // WOODSPRING AV / ALFRED SMITH WAY
								"4680" // GREEN LANE / YONGE ST
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"4680", // GREEN LANE / YONGE ST
								"5421", // LONDON RD / YORKSHIRE DR
								"4691", // NEWMARKET GO TERMINAL
								"7314" // NEWMARKET GO TERMINAL
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(45L, new RouteTripSpec(45L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MINGAY, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, MARKVILLE_MALL) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"1827", // MARKVILLE MALL STOP #1827
								"1383", // BUR OAK AV / DOGWOOD ST
								"4799" // MAJOR MACKENZIE DR / MINGAY AV
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"4799", // MAJOR MACKENZIE DR / MINGAY AV
								"5541", // RAYMERVILLE DR / BENDAMERE CRES
								"1827" // MARKVILLE MALL STOP #1827
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(84L, new RouteTripSpec(84L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "North", //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "South") //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"4839", // KING RD / YONGE ST
								"2658", // HUMBERLAND DR / WOODHAVEN CRES
								"2659" // YONGE ST / COON'S RD
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"2659", // YONGE ST / COON'S RD
								"2359", // NORTH LAKE RD / OLDE BAYVIEW AV,
								"4839" // KING RD / YONGE ST
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(204L, new RouteTripSpec(204L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, BERCZY, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, UNIONVILLE_GO_STATION) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"4171", // UNIONVILLE GO STATION PLATFORM 2
								"6127", // MCCOWAN RD STOP # 6127
								"2971" // MAJOR MACKENZIE DR / RIDGECREST RD
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"2971", // MAJOR MACKENZIE DR / RIDGECREST RD
								"6092", // == BUR OAK AV STOP # 6092
								"1401", // != BUR OAK AV / THE BRIDLE WALK,
								"6690", // != THE BRIDLE WALK / HOST AV
								"4171" // UNIONVILLE GO STATION PLATFORM 2
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(522L, new RouteTripSpec(522L, //
				OneBusAwayCommons.EAST, MTrip.HEADSIGN_TYPE_STRING, "East", //
				OneBusAwayCommons.WEST, MTrip.HEADSIGN_TYPE_STRING, "West") //
				.addTripSort(OneBusAwayCommons.EAST, //
						Arrays.asList( //
								"5246", // HAGGERMANS CORNER
								"1552", // M-S HOSPITAL
								"5986" // CORNELL PARK AV / WALKERVILLE RD
						)) //
				.addTripSort(OneBusAwayCommons.WEST, //
						Arrays.asList( //
								"5986", // CORNELL PARK AV / WALKERVILLE RD
								"6305", // TONY WONG PLACE / KENNEDY RD
								"5246" // HAGGERMANS CORNER
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(589L, new RouteTripSpec(589L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "Bernard / Dunlop St", //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, EMPTY) //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"7106", // HILLCREST MALL
								"5319", // OBSERVATORY TOWERS STOP # 5319
								"2961", // == MAJOR MACKENZIE DR / HARDING BLVD
								"2962", // != MAJOR MACKENZIE DR / ARNOLD CRES
								"2964", // != MAJOR MACKENZIE DR / YONGE ST
								"4694", // != xx YONGE ST / ARNOLD CRES
								"5322", // != MCCONAGHY CENTRE STOP # 5322
								"4694", // != xx YONGE ST / ARNOLD CRES
								"2965", // == MAJOR MACKENZIE DR / BAKER AV
								"6605", // ==
								"5839", // xx
								"4402", // xx
								"1152", // !=
								"5839", // xx
								"4402", // xx
								"5839", // xx
								"1693", // ==
								"2750", // DUNLOP ST STOP #
								"6321", // UPPER YONGE PLACE
								"7228" // MON SHEONG COURT STOP # 7228
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Collections.emptyList()) // NO STOPS
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(590L, new RouteTripSpec(590L, //
				OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, EMPTY, //
				OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, MTrip.HEADSIGN_TYPE_STRING, "Hillcrest Mall") //
				.addTripSort(OneBusAwayCommons.NORTH_SPLITTED_CIRCLE, //
						Collections.emptyList()) // NO STOPS
				.addTripSort(OneBusAwayCommons.SOUTH_SPLITTED_CIRCLE, //
						Arrays.asList( //
								"7228", // MON SHEONG COURT STOP # 7228
								"6321", // UPPER YONGE PLACE
								"4628", // RICHMOND HEIGHTS NO FRILLS STOP # 4
								"1707", // MAJOR MACKENZIE DR / BAKER AV
								"4950", // MAJOR MACKENZIE DR / YONGE ST
								"4694", // YONGE ST / ARNOLD CRES
								"5322", // MCCONAGHY CENTRE STOP # 5322
								"6125", // HARDING BLVD / KERSEY CRES
								"7106" // HILLCREST MALL
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(801L, new RouteTripSpec(801L, //
				OneBusAwayCommons.NORTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				OneBusAwayCommons.SOUTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(OneBusAwayCommons.NORTH, //
						Arrays.asList( //
								"7232", // OPERATIONS CENTRE
								"6501", // OAK RIDGES C.C. STOP # 6501
								"4934", // ELGIN WEST C.C. STOP # 4934
								"7231" // RICHMOND HILL WAVE POOL
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH, //
						Arrays.asList( //
								"6501", // OAK RIDGES C.C. STOP # 6501
								"4934", // ELGIN WEST C.C. STOP # 4934
								"7231", // RICHMOND HILL WAVE POOL
								"7232" // OPERATIONS CENTRE
						)) //
				.compileBothTripSort());
		//noinspection deprecation
		map2.put(802L, new RouteTripSpec(802L, //
				OneBusAwayCommons.NORTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				OneBusAwayCommons.SOUTH, MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(OneBusAwayCommons.NORTH, //
						Arrays.asList( //
								"7233", // ELGIN BARROW ARENA
								"7235", // ROUGE WOODS COMMUNITY CENTRE
								"7232" // OPERATIONS CENTRE
						)) //
				.addTripSort(OneBusAwayCommons.SOUTH, //
						Arrays.asList( //
								"7232", // OPERATIONS CENTRE
								"7233", // ELGIN BARROW ARENA
								"7235" // ROUGE WOODS COMMUNITY CENTRE
						)) //
				.compileBothTripSort());
		ALL_ROUTE_TRIPS2 = map2;
	}

	@NotNull
	@Override
	public String cleanStopOriginalId(@NotNull String gStopId) {
		gStopId = CleanUtils.cleanMergedID(gStopId);
		return gStopId;
	}

	@NotNull
	@Override
	public Pair<Long[], Integer[]> splitTripStop(@NotNull MRoute mRoute, @NotNull GTrip gTrip, @NotNull GTripStop gTripStop, @NotNull ArrayList<MTrip> splitTrips, @NotNull GSpec routeGTFS) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return SplitUtils.splitTripStop(mRoute, gTrip, gTripStop, routeGTFS, ALL_ROUTE_TRIPS2.get(mRoute.getId()), this);
		}
		return super.splitTripStop(mRoute, gTrip, gTripStop, splitTrips, routeGTFS);
	}

	@Override
	public int compareEarly(long routeId, @NotNull List<MTripStop> list1, @NotNull List<MTripStop> list2,
							@NotNull MTripStop ts1, @NotNull MTripStop ts2,
							@NotNull GStop ts1GStop, @NotNull GStop ts2GStop) {
		if (ALL_ROUTE_TRIPS2.containsKey(routeId)) {
			return ALL_ROUTE_TRIPS2.get(routeId).compare(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop, this);
		}
		return super.compareEarly(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop);
	}

	@NotNull
	@Override
	public ArrayList<MTrip> splitTrip(@NotNull MRoute mRoute, @Nullable GTrip gTrip, @NotNull GSpec gtfs) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return ALL_ROUTE_TRIPS2.get(mRoute.getId()).getAllTrips();
		}
		return super.splitTrip(mRoute, gTrip, gtfs);
	}

	@Override
	public void setTripHeadsign(@NotNull MRoute mRoute, @NotNull MTrip mTrip, @NotNull GTrip gTrip, @NotNull GSpec gtfs) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return; // split
		}
		String tripHeadsign = gTrip.getTripHeadsignOrDefault();
		if (tripHeadsign.startsWith(mRoute.getShortNameOrDefault())) {
			tripHeadsign = tripHeadsign.substring(mRoute.getShortNameOrDefault().length() + 1);
		}
		if (mRoute.getId() >= 400L && mRoute.getId() <= 499L) {
			mTrip.setHeadsignString(
					cleanTripHeadsign(tripHeadsign) + " " + gTrip.getDirectionId(),
					gTrip.getDirectionIdOrDefault()
			);
			return; // TODO better
		}
		String tripHeadsignLC = gTrip.getTripHeadsignOrDefault().toLowerCase(Locale.ENGLISH);
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
		throw new MTLog.Fatal("Unexpected trips to set: %s!", gTrip);
	}

	@Override
	public boolean mergeHeadsign(@NotNull MTrip mTrip, @NotNull MTrip mTripToMerge) {
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
					"Drop Off Only", //
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
		} else if (mTrip.getRouteId() == 10L) {
			if (Arrays.asList( //
					"Kipling Ave", // <>
					"SmartVMC Bus Term" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SmartVMC Bus Term", mTrip.getHeadsignId());
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
			if (Arrays.asList( //
					VAUGHAN_MILLS_MALL, //
					"SmartVMC Bus Term" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SmartVMC Bus Term", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 32L) {
			if (Arrays.asList( //
					"Henderson", //
					STONE_ROAD // <>
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(STONE_ROAD, mTrip.getHeadsignId());
				return true;
			}
			if (Arrays.asList( //
					STONE_ROAD, // <>
					"Cardinal Carter HS", //
					BATHURST //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString(BATHURST, mTrip.getHeadsignId());
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
					"Newmarket Term" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Newmarket Term", mTrip.getHeadsignId());
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
		} else if (mTrip.getRouteId() == 58L) {
			if (Arrays.asList( //
					"Hwy 48", //
					"404 Town Ctr" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("404 Town Ctr", mTrip.getHeadsignId());
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
					"Richmond Hl HS", //
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
					"Richmond Hl Ctr Term" //
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
					"Downtown Brampton Term" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Downtown Brampton Term", mTrip.getHeadsignId());
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
		throw new MTLog.Fatal("Unexpected trips to merge: %s & %s!", mTrip, mTripToMerge);
	}

	private static final Pattern STARTS_WITH_ROUTE_NUMBER = Pattern.compile("(^rt [\\d]+ )", Pattern.CASE_INSENSITIVE);

	private static final Pattern ENDS_WITH_DASH_BOUND = Pattern.compile("( - [sewn]b$)", Pattern.CASE_INSENSITIVE);

	private static final Pattern ENDS_WITH_AM_PM = Pattern.compile("( - (af|am|mo|pm)$)", Pattern.CASE_INSENSITIVE);

	private static final Pattern STARTS_WITH_DASH = Pattern.compile("(^- )", Pattern.CASE_INSENSITIVE);

	private static final Pattern ENDS_WITH_DROP_OFF_ONLY = Pattern.compile("( drop off only$)", Pattern.CASE_INSENSITIVE);

	private static final Pattern SPECIAL_ = CleanUtils.cleanWords("special");

	@NotNull
	@Override
	public String cleanTripHeadsign(@NotNull String tripHeadsign) {
		tripHeadsign = CleanUtils.toLowerCaseUpperCaseWords(Locale.ENGLISH, tripHeadsign, getIgnoredWords());
		tripHeadsign = STARTS_WITH_ROUTE_NUMBER.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = STARTS_WITH_DASH.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = ENDS_WITH_DASH_BOUND.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = ENDS_WITH_AM_PM.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = ENDS_WITH_DROP_OFF_ONLY.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = SPECIAL_.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = CleanUtils.keepToAndRemoveVia(tripHeadsign);
		tripHeadsign = CleanUtils.CLEAN_AND.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return CleanUtils.cleanLabel(tripHeadsign);
	}

	private static final Pattern STOP_CODE = Pattern.compile("( stop[\\W]*#[\\W]*[0-9]{1,4})", Pattern.CASE_INSENSITIVE);
	private static final String STOP_CODE_REPLACEMENT = "";

	private String[] getIgnoredWords() {
		return new String[]{
				"CHS", "GO", "HS",
		};
	}

	@NotNull
	@Override
	public String cleanStopName(@NotNull String gStopName) {
		gStopName = CleanUtils.toLowerCaseUpperCaseWords(Locale.ENGLISH, gStopName, getIgnoredWords());
		gStopName = STOP_CODE.matcher(gStopName).replaceAll(STOP_CODE_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		gStopName = CleanUtils.cleanNumbers(gStopName);
		return CleanUtils.cleanLabel(gStopName);
	}

	@Override
	public int getStopId(@NotNull GStop gStop) {
		//noinspection deprecation
		final String stopId = gStop.getStopId();
		if (!Utils.isDigitsOnly(stopId)) {
			Matcher matcher = DIGITS.matcher(stopId);
			if (matcher.find()) {
				return Integer.parseInt(matcher.group());
			}
			if ("VNYNBASB".equalsIgnoreCase(stopId)) {
				return 10_000;
			} else if ("VNBRYNSB".equalsIgnoreCase(stopId)) {
				return 100_001;
			} else if ("VNYNRONB".equalsIgnoreCase(stopId)) {
				return 100_002;
			} else if ("VNYNWDSB".equalsIgnoreCase(stopId)) {
				return 100_003;
			} else if ("VNYNCLNB".equalsIgnoreCase(stopId)) {
				return 100_004;
			} else if ("VNYN16SB".equalsIgnoreCase(stopId)) {
				return 100_005;
			} else if ("VNYNCTNB".equalsIgnoreCase(stopId)) {
				return 100_006;
			}
			throw new MTLog.Fatal("Unexpected stop ID for %s !", gStop);
		}
		return super.getStopId(gStop); // original stop ID used by real-time API
	}
}
