package org.mtransit.parser.ca_york_region_yrt_viva_bus;

import static org.mtransit.commons.Constants.SPACE_;
import static org.mtransit.commons.RegexUtils.DIGITS;
import static org.mtransit.commons.StringUtils.EMPTY;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mtransit.commons.CharUtils;
import org.mtransit.commons.CleanUtils;
import org.mtransit.commons.provider.OneBusAwayProviderCommons;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.MTLog;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.mt.data.MAgency;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.yrt.ca/en/about-us/open-data.aspx
// https://www.yrt.ca/google/google_transit.zip
public class YorkRegionYRTVivaBusAgencyTools extends DefaultAgencyTools {

	public static void main(@NotNull String[] args) {
		new YorkRegionYRTVivaBusAgencyTools().start(args);
	}

	@Nullable
	@Override
	public List<Locale> getSupportedLanguages() {
		return LANG_EN;
	}

	@Override
	public boolean defaultExcludeEnabled() {
		return true;
	}

	@NotNull
	@Override
	public String getAgencyName() {
		return "YRT Viva";
	}

	@NotNull
	@Override
	public Integer getAgencyRouteType() {
		return MAgency.ROUTE_TYPE_BUS;
	}

	@Override
	public boolean defaultRouteIdEnabled() {
		return true;
	}

	@Override
	public boolean useRouteShortNameForRouteId() {
		return false; // default route ID look good
	}

	@NotNull
	public String cleanRouteOriginalId(@NotNull String routeId) {
		return CleanUtils.cleanMergedID(routeId);
	}

	@Nullable
	@Override
	public String fixColor(@Nullable String color) {
		if ("F7FE2E".equalsIgnoreCase(color)) {
			return "FFCC00";
		}
		return super.fixColor(color);
	}

	private static final Pattern REMOVE_LEADING_ZEROS = Pattern.compile("(^0+)", Pattern.CASE_INSENSITIVE);

	@NotNull
	@Override
	public String cleanRouteShortName(@NotNull String routeShortName) {
		routeShortName = REMOVE_LEADING_ZEROS.matcher(routeShortName).replaceAll(EMPTY);
		routeShortName = CleanUtils.cleanLabel(routeShortName); // viva -> Viva
		return super.cleanRouteShortName(routeShortName);
	}

	private static final Pattern SS = CleanUtils.cleanWords("school special", "ss");
	private static final String SS_REPLACEMENT = CleanUtils.cleanWordsReplacement("SS");

	@Override
	public boolean defaultRouteLongNameEnabled() {
		return true;
	}

	@NotNull
	@Override
	public String cleanRouteLongName(@NotNull String routeLongName) {
		routeLongName = CleanUtils.toLowerCaseUpperCaseWords(getFirstLanguageNN(), routeLongName, getIgnoredWords());
		routeLongName = SS.matcher(routeLongName).replaceAll(SS_REPLACEMENT);
		routeLongName = CleanUtils.cleanSlashes(routeLongName);
		routeLongName = CleanUtils.cleanStreetTypes(routeLongName);
		return CleanUtils.cleanLabel(routeLongName);
	}

	@Override
	public boolean defaultAgencyColorEnabled() {
		return true;
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
	public boolean directionFinderEnabled() {
		return true;
	}

	// SYNC WITH GH:ca-york-region-yrt-viva-bus-android:src/main/res/values/oba_values.xml (https://git.io/Jtuhy)
	private static final Pattern ENDS_W_DASH_TYPE_ = Pattern.compile("((.+) - (\\w{2}))", Pattern.CASE_INSENSITIVE);
	private static final String ENDS_W_DASH_TYPE_REPLACEMENT_KEEP = "$3-$2"; // "Abcdef - AA" -> "AA-Abcdeb"

	private static final Pattern SPECIAL_ = CleanUtils.cleanWords("special");

	private static final Pattern _DASH_ = Pattern.compile("( - )");

	@NotNull
	@Override
	public String cleanTripHeadsign(@NotNull String tripHeadsign) { // used for OBA real-time provider
		tripHeadsign = ENDS_W_DASH_TYPE_.matcher(tripHeadsign).replaceAll(ENDS_W_DASH_TYPE_REPLACEMENT_KEEP);
		tripHeadsign = SPECIAL_.matcher(tripHeadsign).replaceAll(EMPTY);
		tripHeadsign = _DASH_.matcher(tripHeadsign).replaceAll(SPACE_);
		return OneBusAwayProviderCommons.cleanTripHeadsign(tripHeadsign, getIgnoredWords());
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
		gStopName = CleanUtils.toLowerCaseUpperCaseWords(getFirstLanguageNN(), gStopName, getIgnoredWords());
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
		if (!CharUtils.isDigitsOnly(stopId)) {
			final Matcher matcher = DIGITS.matcher(stopId);
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
		return super.getStopId(gStop); // original stop ID used by real-time API (OBA & GTFS-RT)
	}
}
