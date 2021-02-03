package org.mtransit.parser.ca_york_region_yrt_viva_bus;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mtransit.parser.CleanUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.MTLog;
import org.mtransit.parser.StringUtils;
import org.mtransit.parser.Utils;
import org.mtransit.parser.gtfs.data.GCalendar;
import org.mtransit.parser.gtfs.data.GCalendarDate;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GSpec;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.gtfs.data.GTrip;
import org.mtransit.parser.mt.data.MAgency;
import org.mtransit.parser.mt.data.MRoute;
import org.mtransit.parser.mt.data.MTrip;

import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mtransit.parser.Constants.SPACE_;
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

	@NotNull
	@Override
	public String cleanStopOriginalId(@NotNull String gStopId) {
		gStopId = CleanUtils.cleanMergedID(gStopId);
		return gStopId;
	}

	@Override
	public void setTripHeadsign(@NotNull MRoute mRoute, @NotNull MTrip mTrip, @NotNull GTrip gTrip, @NotNull GSpec gtfs) {
		mTrip.setHeadsignString(
				cleanTripHeadsign(gTrip.getTripHeadsignOrDefault()),
				gTrip.getDirectionIdOrDefault()
		);
	}

	@Override
	public boolean directionFinderEnabled() {
		return true;
	}

	@Override
	public boolean mergeHeadsign(@NotNull MTrip mTrip, @NotNull MTrip mTripToMerge) {
		throw new MTLog.Fatal("Unexpected trips to merge: %s & %s!", mTrip, mTripToMerge);
	}

	private static final Pattern ENDS_W_DASH_TYPE_ = Pattern.compile("((.+) - (\\w{2}))", Pattern.CASE_INSENSITIVE);
	private static final String ENDS_W_DASH_TYPE_REPLACEMENT_KEEP = "$3-$2"; // "Abcdef - AA" -> "AA-Abcdeb"

	private static final Pattern SPECIAL_ = CleanUtils.cleanWords("special");

	private static final Pattern _DASH_ = Pattern.compile("( - )");

	@NotNull
	@Override
	public String cleanTripHeadsign(@NotNull String tripHeadsign) {
		tripHeadsign = ENDS_W_DASH_TYPE_.matcher(tripHeadsign).replaceAll(ENDS_W_DASH_TYPE_REPLACEMENT_KEEP);
		tripHeadsign = SPECIAL_.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = _DASH_.matcher(tripHeadsign).replaceAll(SPACE_);
		tripHeadsign = CleanUtils.toLowerCaseUpperCaseWords(Locale.ENGLISH, tripHeadsign, getIgnoredWords());
		tripHeadsign = CleanUtils.keepToAndRemoveVia(tripHeadsign);
		tripHeadsign = CleanUtils.CLEAN_AND.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		tripHeadsign = CleanUtils.CLEAN_AT.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.cleanBounds(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return CleanUtils.cleanLabel(tripHeadsign);
	}

	private static final Pattern REMOVE_STOP_CODE_ = Pattern.compile("( stop[\\W]*#[\\W]*[0-9]{1,4})", Pattern.CASE_INSENSITIVE);
	private static final String REMOVE_STOP_CODE_REPLACEMENT = "";

	private String[] getIgnoredWords() {
		return new String[]{
				"CHS", "GO", "HS",
				"AM", "MO", "PM", "AF",
				"EB", "WB", "NB", "SB",
		};
	}

	@NotNull
	@Override
	public String cleanStopName(@NotNull String gStopName) {
		gStopName = CleanUtils.toLowerCaseUpperCaseWords(Locale.ENGLISH, gStopName, getIgnoredWords());
		gStopName = REMOVE_STOP_CODE_.matcher(gStopName).replaceAll(REMOVE_STOP_CODE_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		gStopName = CleanUtils.cleanBounds(gStopName);
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
