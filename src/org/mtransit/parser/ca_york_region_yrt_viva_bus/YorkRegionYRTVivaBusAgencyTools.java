package org.mtransit.parser.ca_york_region_yrt_viva_bus;

import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Utils;
import org.mtransit.parser.gtfs.data.GCalendar;
import org.mtransit.parser.gtfs.data.GCalendarDate;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.gtfs.data.GTrip;
import org.mtransit.parser.mt.data.MAgency;
import org.mtransit.parser.mt.data.MDirectionType;
import org.mtransit.parser.mt.data.MRoute;
import org.mtransit.parser.mt.data.MSpec;
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
		System.out.printf("Generating YRT Viva bus data...\n");
		long start = System.currentTimeMillis();
		this.serviceIds = extractUsefulServiceIds(args, this);
		super.start(args);
		System.out.printf("Generating YRT Viva bus data... DONE in %s.\n", Utils.getPrettyDuration(System.currentTimeMillis() - start));
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

	@Override
	public Integer getAgencyRouteType() {
		return MAgency.ROUTE_TYPE_BUS;
	}

	private static final Pattern DIGITS = Pattern.compile("[\\d]+");

	private static final String PURPLE = "purple";
	private static final String PINK = "pink";
	private static final String ORANGE = "orange";
	private static final String GREEN = "green";
	private static final String BLUE = "blue";
	private static final String VIVA = "viva";

	@Override
	public long getRouteId(GRoute gRoute) {
		String routeShortName = gRoute.route_short_name;
		if (routeShortName != null && routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return Integer.valueOf(routeShortName); // using route short name as route ID
		}
		String routeShortNameLC = routeShortName.toLowerCase(Locale.ENGLISH);
		if (routeShortNameLC.contains(VIVA)) {
			if (routeShortNameLC.contains(BLUE)) {
				return 220001l;
			} else if (routeShortNameLC.contains(GREEN)) {
				return 220002l;
			} else if (routeShortNameLC.contains(ORANGE)) {
				return 220003l;
			} else if (routeShortNameLC.contains(PINK)) {
				return 220004l;
			} else if (routeShortNameLC.contains(PURPLE)) {
				return 220005l;
			}
		}
		try {
			Matcher matcher = DIGITS.matcher(routeShortName);
			matcher.find();
			return Long.valueOf(matcher.group());
		} catch (Exception e) {
			System.out.println("Error while extracting route short name for route " + gRoute + "!");
			e.printStackTrace();
			System.exit(-1);
			return -1l;
		}
	}

	private static final String RSN_VIVA = "Viva";

	@Override
	public String getRouteShortName(GRoute gRoute) {
		String routeShortName = gRoute.route_short_name;
		if (routeShortName != null && routeShortName.length() > 0 && Utils.isDigitsOnly(routeShortName)) {
			return routeShortName;
		}
		String routeShortNameLC = routeShortName.toLowerCase(Locale.ENGLISH);
		if (routeShortNameLC.contains(VIVA)) {
			return RSN_VIVA;
		}
		try {
			Matcher matcher = DIGITS.matcher(routeShortName);
			matcher.find();
			return String.valueOf(Integer.valueOf(matcher.group()));
		} catch (Exception e) {
			System.out.println("Error while extracting route short name for route " + gRoute + "!");
			e.printStackTrace();
			System.exit(-1);
			return null;
		}
	}

	private static final String WONDERLAND_VAUGHAN_MILLS = "Wonderland/Vaughan Mills";
	private static final String RSN_760 = "760";
	private static final String YONGE = "Yonge";
	private static final String BAYVIEW = "Bayview";
	private static final String BATHURST = "Bathurst";
	private static final String RUTHERFORD = "Rutherford";
	private static final String RLN_PURPLE = "Purple";
	private static final String RLN_PINK = "Pink";
	private static final String RLN_ORANGE = "Orange";
	private static final String RLN_GREEN = "Green";
	private static final String RLN_BLUE = "Blue";

	@Override
	public String getRouteLongName(GRoute gRoute) {
		String routeShortNameLC = gRoute.route_short_name.toLowerCase(Locale.ENGLISH);
		if (routeShortNameLC.contains(VIVA)) {
			if (routeShortNameLC.contains(BLUE)) {
				return RLN_BLUE;
			} else if (routeShortNameLC.contains(GREEN)) {
				return RLN_GREEN;
			} else if (routeShortNameLC.contains(ORANGE)) {
				return RLN_ORANGE;
			} else if (routeShortNameLC.contains(PINK)) {
				return RLN_PINK;
			} else if (routeShortNameLC.contains(PURPLE)) {
				return RLN_PURPLE;
			}
		}
		Matcher matcher = DIGITS.matcher(gRoute.route_short_name);
		matcher.find();
		int rsn = Integer.parseInt(matcher.group());
		if (rsn == 85) {
			return RUTHERFORD;
		} else if (rsn == 88) {
			return BATHURST;
		} else if (rsn == 91) {
			return BAYVIEW;
		} else if (rsn == 98) {
			return YONGE;
		}
		if (StringUtils.isEmpty(gRoute.route_long_name)) {
			if (RSN_760.equals(routeShortNameLC)) {
				return WONDERLAND_VAUGHAN_MILLS; // service will begin on May 3, 2015
			}
			System.out.println("Unexpected route long name for " + gRoute);
			System.exit(-1);
			return null;
		}
		return MSpec.cleanLabel(gRoute.route_long_name.toLowerCase(Locale.ENGLISH));
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

	private static final String MINGAY = "Mingay";
	private static final String BERCZY = "Berczy";
	private static final String UNIONVILLE_LOCAL = "Unionville Local";
	private static final String BEAVER_CREEK_SHUTTLE = "Beaver Creek Shuttle";
	private static final String BERCZY_GO_SHUTTLE = "Berczy GO Shuttle";
	private static final String OAK_RIDGES = "Oak Ridges";
	private static final String AURORA_NORTH = "Aurora North";
	private static final String AFTERNOON = "Afternoon";
	private static final String MORNING = "Morning";

	@Override
	public void setTripHeadsign(MRoute route, MTrip mTrip, GTrip gTrip) {
		String gTripHeadsignLC = gTrip.trip_headsign.toLowerCase(Locale.ENGLISH);
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
		int directionId = gTrip.direction_id;
		String stationName = cleanTripHeadsign(gTrip.trip_headsign);
		if (gTripHeadsignLC.endsWith(MO)) {
			stationName = MORNING;
		} else if (gTripHeadsignLC.endsWith(AF)) {
			stationName = AFTERNOON;
		} else if (route.id == 31l) {
			if (directionId == 0) {
				stationName = AURORA_NORTH;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 40l) {
			if (directionId == 0) {
				stationName = UNIONVILLE_LOCAL;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 42l) {
			if (directionId == 0) {
				stationName = BERCZY;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 45l) {
			if (directionId == 0) {
				stationName = MINGAY;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 84l) {
			if (directionId == 0) {
				stationName = OAK_RIDGES;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 204l) {
			if (directionId == 0) {
				stationName = BERCZY_GO_SHUTTLE;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 244l) {
			if (directionId == 0) {
				stationName = BEAVER_CREEK_SHUTTLE;
			} else {
				System.out.println("Unexpected trip head sign for " + mTrip + " !");
				System.exit(-1);
			}
		} else if (route.id == 589l) {
			mTrip.setHeadsignDirection(MDirectionType.NORTH);
			return;
		} else if (route.id == 590l) {
			mTrip.setHeadsignDirection(MDirectionType.SOUTH);
			return;
		}
		mTrip.setHeadsignString(stationName, directionId);
	}

	@Override
	public String cleanTripHeadsign(String tripHeadsign) {
		return MSpec.cleanLabel(tripHeadsign);
	}

	private static final Pattern FIRST = Pattern.compile("(first )", Pattern.CASE_INSENSITIVE);
	private static final String FIRST_REPLACEMENT = "1st ";
	private static final Pattern SECOND = Pattern.compile("(second )", Pattern.CASE_INSENSITIVE);
	private static final String SECOND_REPLACEMENT = "2nd ";
	private static final Pattern THIRD = Pattern.compile("(third )", Pattern.CASE_INSENSITIVE);
	private static final String THIRD_REPLACEMENT = "3rd ";
	private static final Pattern FOURTH = Pattern.compile("(fourth )", Pattern.CASE_INSENSITIVE);
	private static final String FOURTH_REPLACEMENT = "4th";
	private static final Pattern FIFTH = Pattern.compile("(fifth )", Pattern.CASE_INSENSITIVE);
	private static final String FIFTH_REPLACEMENT = "5th ";
	private static final Pattern SIXTH = Pattern.compile("(sixth )", Pattern.CASE_INSENSITIVE);
	private static final String SIXTH_REPLACEMENT = "6th ";
	private static final Pattern SEVENTH = Pattern.compile("(seventh )", Pattern.CASE_INSENSITIVE);
	private static final String SEVENTH_REPLACEMENT = "7th ";
	private static final Pattern EIGHTH = Pattern.compile("(eighth )", Pattern.CASE_INSENSITIVE);
	private static final String EIGHTH_REPLACEMENT = "8th ";
	private static final Pattern NINTH = Pattern.compile("(ninth )", Pattern.CASE_INSENSITIVE);
	private static final String NINTH_REPLACEMENT = "9th ";

	private static final Pattern AT = Pattern.compile("( at )", Pattern.CASE_INSENSITIVE);
	private static final String AT_REPLACEMENT = " / ";

	private static final Pattern AND = Pattern.compile("( and )", Pattern.CASE_INSENSITIVE);
	private static final String AND_REPLACEMENT = " & ";

	private static final Pattern STOP_CODE = Pattern.compile("( stop # [0-9]{1,4})", Pattern.CASE_INSENSITIVE);
	private static final String STOP_CODE_REPLACEMENT = "";

	@Override
	public String cleanStopName(String gStopName) {
		gStopName = gStopName.toLowerCase(Locale.ENGLISH);
		gStopName = STOP_CODE.matcher(gStopName).replaceAll(STOP_CODE_REPLACEMENT);
		gStopName = AND.matcher(gStopName).replaceAll(AND_REPLACEMENT);
		gStopName = AT.matcher(gStopName).replaceAll(AT_REPLACEMENT);
		gStopName = FIRST.matcher(gStopName).replaceAll(FIRST_REPLACEMENT);
		gStopName = SECOND.matcher(gStopName).replaceAll(SECOND_REPLACEMENT);
		gStopName = THIRD.matcher(gStopName).replaceAll(THIRD_REPLACEMENT);
		gStopName = FOURTH.matcher(gStopName).replaceAll(FOURTH_REPLACEMENT);
		gStopName = FIFTH.matcher(gStopName).replaceAll(FIFTH_REPLACEMENT);
		gStopName = SIXTH.matcher(gStopName).replaceAll(SIXTH_REPLACEMENT);
		gStopName = SEVENTH.matcher(gStopName).replaceAll(SEVENTH_REPLACEMENT);
		gStopName = EIGHTH.matcher(gStopName).replaceAll(EIGHTH_REPLACEMENT);
		gStopName = NINTH.matcher(gStopName).replaceAll(NINTH_REPLACEMENT);
		return MSpec.cleanLabel(gStopName);
	}

	@Override
	public int getStopId(GStop gStop) {
		return super.getStopId(gStop); // original stop ID used by real-time API
	}
}
