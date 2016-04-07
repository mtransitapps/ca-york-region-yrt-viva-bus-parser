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
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Pair;
import org.mtransit.parser.SplitUtils;
import org.mtransit.parser.Utils;
import org.mtransit.parser.SplitUtils.RouteTripSpec;
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
import org.mtransit.parser.mt.data.MTripStop;
import org.mtransit.parser.CleanUtils;
import org.mtransit.parser.mt.data.MTrip;

// http://www.yorkregiontransit.com/en/aboutus/gtfsdownload.asp
// http://www.yrt.ca/en/aboutus/developer.asp
// http://www.yrt.ca/en/aboutus/GTFS.asp
// http://www.yrt.ca/google/google_transit.zip
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
	private static final String BLUE_A = "blue a";
	private static final String GREEN = "green";
	private static final String ORANGE = "orange";
	private static final String PINK = "pink";
	private static final String PURPLE = "purple";
	private static final String YELLOW = "yellow";

	private static final long _98_99_RID = 980099l;
	private static final String RSN_98_99 = "98/99";

	private static final long RID_ENDS_WITH_A = 10000l;
	private static final long RID_ENDS_WITH_B = 20000l;
	private static final long RID_ENDS_WITH_C = 30000l;
	private static final long RID_ENDS_WITH_E = 50000l;

	private static final String A = "a";
	private static final String B = "b";
	private static final String C = "c";
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
		String routeShortName = gRoute.getRouteShortName();
		if (routeShortName != null && routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return Integer.valueOf(routeShortName); // using route short name as route ID
		}
		String routeShortNameLC = routeShortName.toLowerCase(Locale.ENGLISH);
		if (routeShortNameLC.contains(VIVA)) {
			if (routeShortNameLC.endsWith(BLUE)) {
				return VIVA_BLUE_RID;
			} else if (routeShortNameLC.endsWith(BLUE_A)) {
				return VIVA_BLUE_A_RID;
			} else if (routeShortNameLC.endsWith(GREEN)) {
				return VIVA_GREEN_RID;
			} else if (routeShortNameLC.endsWith(ORANGE)) {
				return VIVA_ORANGE_RID;
			} else if (routeShortNameLC.endsWith(PINK)) {
				return VIVA_PINK_RID;
			} else if (routeShortNameLC.endsWith(PURPLE)) {
				return VIVA_PURPLE_RID;
			} else if (routeShortNameLC.endsWith(YELLOW)) {
				return VIVA_YELLOW_RID;
			}
		}
		if (RSN_98_99.equals(routeShortNameLC)) {
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
			if ("BAD405".equalsIgnoreCase(gRoute.getRouteColor())) {
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
		if (routeShortName != null && routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return routeShortName;
		}
		return REMOVE_LEADING_ZEROS.matcher(routeShortName).replaceAll(StringUtils.EMPTY);
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
		if (gRoute.getRouteLongName().toLowerCase(Locale.ENGLISH).startsWith(VIVA)) {
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

	private static final String WB = " - wb";
	private static final String EB = " - eb";
	private static final String SB = " - sb";
	private static final String NB = " - nb";

	private static final String MO = " - mo";
	private static final String AF = " - af";

	private static final String AM_HEADSIGN = "AM";
	private static final String PM_HEADSIGN = "PM";

	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;
	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		map2.put(VIVA_BLUE_RID, new RouteTripSpec(VIVA_BLUE_RID, // Viva Blue
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "70", "80", "88", "90", "91", //
								"110", "110_merged_3481041", "110_merged_3482320" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "110", "110_merged_3481041", "110_merged_3482320", //
								"94", "90", "92", "70" })) //
				.compileBothTripSort());
		map2.put(VIVA_BLUE_A_RID, new RouteTripSpec(VIVA_BLUE_A_RID, // Viva Blue A
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "70", "88", //
								"110", "110_merged_3481041", "110_merged_3482320" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "110", "110_merged_3481041", "110_merged_3482320", //
								"92", "70" })) //
				.compileBothTripSort());
		map2.put(VIVA_GREEN_RID, new RouteTripSpec(VIVA_GREEN_RID, // Viva Green
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "68", "47", "56" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "57", "62", //
								"117", "117_merged_3481040", "117_merged_3482319" })) //
				.compileBothTripSort());
		map2.put(VIVA_ORANGE_RID, new RouteTripSpec(VIVA_ORANGE_RID, // Viva Orange
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "60", "60_merged_3480281", "60_merged_3481560", //
								"123", "13", "10", "11", "744" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "5", "10", "19", "123", "20", //
								"60", "60_merged_3480281", "60_merged_3481560" })) //
				.compileBothTripSort());
		map2.put(VIVA_PINK_RID, new RouteTripSpec(VIVA_PINK_RID, // Viva Pink
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "5943", "39", "51" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "51", "38", "5943" })) //
				.compileBothTripSort());
		map2.put(VIVA_PURPLE_RID, new RouteTripSpec(VIVA_PURPLE_RID, // Viva Purple
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.EAST.getId(), //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.WEST.getId()) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "20", "26", "122", "121", "39", "111" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "111", "38", "122", "20" })) //
				.compileBothTripSort());
		map2.put(VIVA_YELLOW_RID, new RouteTripSpec(VIVA_YELLOW_RID, // Viva Yellow
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.EAST.getId(), //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.WEST.getId()) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "6005", "6508", //
								"6564", "6564_merged_3495513" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "6564", "6564_merged_349551", //
								"6513", "6511", //
								"6509", "6005" })) //
				.compileBothTripSort());
		map2.put(26l, new RouteTripSpec(26l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "4357", "1139", "466" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "466", "6238", "4357" })) //
				.compileBothTripSort());
		map2.put(31l, new RouteTripSpec(31l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.EAST.getId(), //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.WEST.getId()) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "3336", "3336_merged_3480127", "3336_merged_3481406", //
								"335", "335_merged_3480760", "335_merged_3482039",//
								"336", "336_merged_3480762", "336_merged_3482041", //
								"3564", "3564_merged_3480854", "3564_merged_3482133", //
								"4053", "4053_merged_3480612", "4053_merged_3481891", //
								"5994", "5994_merged_3480290", "5994_merged_3481569", //
								"4058", "4058_merged_3480617", "4058_merged_3481896", //
								"6003", "6003_merged_3480931", "6003_merged_3482210" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "6003", "6003_merged_3480931", "6003_merged_3482210", //
								"5936", "5936_merged_3480233", "5936_merged_3481512", //
								"3329", "3329_merged_3480056", "3329_merged_3481335", //
								"3903", "3903_merged_3480221", "3903_merged_3481500", //
								"4021", "4021_merged_3480292", "4021_merged_3481571", //
								"3893", "3893_merged_3480784", "3893_merged_3482063", //
								"3892", "3892_merged_3480783", "3892_merged_3482062", //
								"3336", "3336_merged_3480127", "3336_merged_3481406" })) //
				.compileBothTripSort());
		map2.put(40l, new RouteTripSpec(40l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.EAST.getId(), // Markville Mall
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.WEST.getId()) // Woodbine Ave
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "6074", "1911", "2152" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "2152", "1990", "6074" })) //
				.compileBothTripSort());
		map2.put(41l, new RouteTripSpec(41l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.EAST.getId(), //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.WEST.getId()) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "2152", "2145", "2169" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "2169", "2184", "2152" })) //
				.compileBothTripSort());
		map2.put(42l, new RouteTripSpec(42l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "5150", "50", "2750", "499" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "499", "2150", "2750", "49", "5593" })) //
				.compileBothTripSort());
		map2.put(45l, new RouteTripSpec(45l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "2152", "1874", "1234" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "1234", "5619", "2152" })) //
				.compileBothTripSort());
		map2.put(84l, new RouteTripSpec(84l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "3923", "3923_merged_3480422", "3923_merged_3481701", //
								"3723", "3723_merged_3480635", "3723_merged_3481914", //
								"349", "349_merged_3479829", "349_merged_3481108" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "349", "349_merged_3479829", "349_merged_3481108", //
								"2380", "2380_merged_3480469", "2380_merged_3481748", //
								"3923", "3923_merged_3480422", "3923_merged_3481701" })) //
				.compileBothTripSort());
		map2.put(90l + RID_ENDS_WITH_B, new RouteTripSpec(90l + RID_ENDS_WITH_B, // 90B
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), // Don Mills Station
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) // Highway 7
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "68", "2543" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "2543", "2540", "1604", //
								"2776", "2776_merged_3480385", "2776_merged_3481664" })) //
				.compileBothTripSort());
		map2.put(204l, new RouteTripSpec(204l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "2750", "1953", "499" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "499", "5368", "1882", "6289", "2750" })) //
				.compileBothTripSort());
		map2.put(244l, new RouteTripSpec(244l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "6075", "2665", "6276" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "6276", "2657", "6075" })) //
				.compileBothTripSort());
		map2.put(589l, new RouteTripSpec(589l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), // Bernard / Dunlop St
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "272", "1366", "490", //
								"491", "493", //
								"1207", "1368", "1207", //
								"494", "372", "5885" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { /* no stops */})) //
				.compileBothTripSort());
		map2.put(590l, new RouteTripSpec(590l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.NORTH.getId(), //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_DIRECTION, MDirectionType.SOUTH.getId()) // Hillcrest Mall
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { /* no stops */})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "5885", "1182", "215", //
								"1287", //
								"1207", "1368", //
								"5382", "272" })) //
				.compileBothTripSort());
		ALL_ROUTE_TRIPS2 = map2;
	}

	@Override
	public Pair<Long[], Integer[]> splitTripStop(MRoute mRoute, GTrip gTrip, GTripStop gTripStop, ArrayList<MTrip> splitTrips, GSpec routeGTFS) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return SplitUtils.splitTripStop(mRoute, gTrip, gTripStop, routeGTFS, ALL_ROUTE_TRIPS2.get(mRoute.getId()));
		}
		return super.splitTripStop(mRoute, gTrip, gTripStop, splitTrips, routeGTFS);
	}

	@Override
	public int compareEarly(long routeId, List<MTripStop> list1, List<MTripStop> list2, MTripStop ts1, MTripStop ts2, GStop ts1GStop, GStop ts2GStop) {
		if (ALL_ROUTE_TRIPS2.containsKey(routeId)) {
			return ALL_ROUTE_TRIPS2.get(routeId).compare(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop);
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
		String gTripHeadsignLC = gTrip.getTripHeadsign().toLowerCase(Locale.ENGLISH);
		if (gTripHeadsignLC.endsWith(NB)) {
			mTrip.setHeadsignDirection(MDirectionType.NORTH);
			return;
		} else if (gTripHeadsignLC.endsWith(SB)) {
			mTrip.setHeadsignDirection(MDirectionType.SOUTH);
			return;
		} else if (gTripHeadsignLC.endsWith(EB)) {
			mTrip.setHeadsignDirection(MDirectionType.EAST);
			return;
		} else if (gTripHeadsignLC.endsWith(WB)) {
			mTrip.setHeadsignDirection(MDirectionType.WEST);
			return;
		}
		if (gTripHeadsignLC.endsWith(MO)) {
			mTrip.setHeadsignString(AM_HEADSIGN, gTrip.getDirectionId());
			return;
		} else if (gTripHeadsignLC.endsWith(AF)) {
			mTrip.setHeadsignString(PM_HEADSIGN, gTrip.getDirectionId());
			return;
		}
		System.out.printf("\nUnexpected trip head sign for %s !\n", mTrip);
		System.exit(-1);
	}

	private static final Pattern STARTS_WITH_NUMBER = Pattern.compile("(^[\\d]+[\\S]*)", Pattern.CASE_INSENSITIVE);

	@Override
	public String cleanTripHeadsign(String tripHeadsign) {
		tripHeadsign = STARTS_WITH_NUMBER.matcher(tripHeadsign).replaceAll(StringUtils.EMPTY);
		tripHeadsign = GO.matcher(tripHeadsign).replaceAll(GO_REPLACEMENT);
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
		}
		return super.getStopId(gStop); // original stop ID used by real-time API
	}
}
