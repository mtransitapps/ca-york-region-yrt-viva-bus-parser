package org.mtransit.parser.ca_york_region_yrt_viva_bus;

import java.util.HashMap;

public class Stops {

	private static HashMap<String, String> ALL_STOPS;

	public static HashMap<String, String> getALL_STOPS() {
		if (ALL_STOPS == null) {
			synchronized (Stops.class) {
				if (ALL_STOPS == null) {
					ALL_STOPS = new HashMap<String, String>();
					ALL_STOPS = init1(ALL_STOPS);
					ALL_STOPS = init2(ALL_STOPS);
				}
			}
		}
		return ALL_STOPS;
	}

	private static HashMap<String, String> init1(HashMap<String, String> allStops) {
		allStops.put("stop_code", "stop_id"); // stop_name
		allStops.put("1867", "1867"); // WILLIAM BERCZY BLVD / WEATHERILL RD
		allStops.put("4447", "4447"); // BLOOMINGTON RD / YONGE ST
		allStops.put("4373", "4373"); // MAIN ST UNIONVILLE / FRED VARLEY DR
		allStops.put("1843", "1843"); // LARKIN AV / PIPHER GATE
		allStops.put("1020", "1020"); // SOUTH PARK RD / COMMERCE VALLEY DR
		allStops.put("4026", "4026"); // PROMENADE TERMINAL PLATFORM 4
		allStops.put("4027", "4027"); // PROMENADE TERMINAL PLATFORM 5
		allStops.put("4024", "4024"); // PROMENADE TERMINAL PLATFORM 1
		allStops.put("4025", "4025"); // PROMENADE TERMINAL PLATFORM 2
		allStops.put("4022", "4022"); // CENTRE ST STOP # 4022
		allStops.put("4023", "4023"); // CENTRE ST / NEW WESTMINSTER DR
		allStops.put("4021", "4021"); // CENTRE ST / CARL TENNEN ST
		allStops.put("6594", "6594_merged_3513095"); // BUR OAK AV STOP # 6594
		allStops.put("9736", "9736"); // HWY 7 / WOODBINE
		allStops.put("5988", "5988"); // STONE RD STOP # 5988
		allStops.put("5989", "5989"); // CARLTON RD / LIEBECK CRES
		allStops.put("5983", "5983"); // HAMPTON GREEN STOP # 5983
		allStops.put("5980", "5980"); // AUSTIN DR / KARMA RD
		allStops.put("5981", "5981"); // AUSTIN DR STOP # 5981
		allStops.put("5986", "5986"); // CORNELL PARK AV / WALKERVILLE RD
		allStops.put("5987", "5987"); // TRENCH ST STOP # 5987
		allStops.put("5984", "5984"); // GORD'S NO FRILLS STOP # 5984
		allStops.put("5985", "5985"); // MAIN ST MARKHAM / THOMSON CRT
		allStops.put("1159", "1159"); // MURRAY DR / NISBET DR
		allStops.put("3999", "3999"); // CONFEDERATION PKWY / DUFFERIN ST
		allStops.put("3998", "3998"); // DUFFERIN ST / CONFEDERATION PKWY
		allStops.put("3997", "3997"); // DUFFERIN ST / TEN OAKS BLVD
		allStops.put("3996", "3996"); // DUFFERIN ST / DUFFERIN HILL DR
		allStops.put("3995", "3995"); // KEELE ST / ADMINISTRATION RD
		allStops.put("3994", "3994"); // KEELE ST STOP # 3994
		allStops.put("3993", "3993"); // KEELE ST / RIVERMEDE RD
		allStops.put("3992", "3992"); // KEELE ST STOP # 3992
		allStops.put("3991", "3991"); // KEELE ST / BOWES RD
		allStops.put("3990", "3990"); // KEELE ST / LANGSTAFF RD
		allStops.put("4839", "4839"); // KING RD / YONGE ST
		allStops.put("6357", "6357"); // BLUE WILLOW DR / MATTHEW DR
		allStops.put("5747", "5747"); // DUFFERIN ST / DISTRICT AV
		allStops.put("6272", "6272"); // PETER RUPERT AV STOP # 6272
		allStops.put("5009", "5009_merged_3513101"); // CANADA COMPUTERS STOP # 5009
		allStops.put("4684", "4684"); // YONGE ST / KENNEDY ST
		allStops.put("6150", "6150"); // BRODIE DR STOP # 6150
		allStops.put("6151", "6151"); // BRODIE DR / ORLANDO DR
		allStops.put("6152", "6152"); // REEVES WAY BLVD / KEN LAUSHWAY AV
		allStops.put("3688", "3688"); // STEELES AV / JANE ST
		allStops.put("6154", "6154"); // PARKER AV / MAPLE GROVE AV
		allStops.put("6155", "6155"); // NINTH LINE / HIGHWAY 7
		allStops.put("6156", "6156"); // BOX GROVE BYPASS / COPPER CREEK DR
		allStops.put("1296", "1296"); // WHITE'S HILL AV / COUNTRY GLEN RD
		allStops.put("6158", "6158"); // HAZELTON AV / ADASTRA CRES
		allStops.put("6159", "6159"); // HAZELTON AV / ROCKLIFFE GT
		allStops.put("4683", "4683"); // YONGE ST / CHURCH ST
		allStops.put("4732", "4732"); // HIGHWAY 7 / MILLWAY AV
		allStops.put("4733", "4733"); // HIGHWAY 7 / HUNTINGTON RD
		allStops.put("6795", "6795"); // ZENWAY BLVD / HIGHWAY 27
		allStops.put("4736", "4736"); // HAIDA DR / AURORA HEIGHTS DR
		allStops.put("4737", "4737"); // HAIDA DR / MCDONALD ST
		allStops.put("2318", "2318"); // YONGE ST / GLEN CAMERON RD
		allStops.put("2319", "2319"); // YONGE ST / MEADOWVIEW AV
		allStops.put("2316", "2316"); // YONGE ST / THORNRIDGE DR
		allStops.put("2317", "2317"); // YONGE ST / ARNOLD AV
		allStops.put("2314", "2314"); // YONGE ST / UPLANDS AV
		allStops.put("2315", "2315"); // YONGE ST / THORNHILL AV
		allStops.put("2312", "2312"); // YONGE ST / LONGBRIDGE RD
		allStops.put("2313", "2313"); // YONGE ST / BUNKER RD
		allStops.put("2310", "2310"); // YONGE ST STOP # 2310
		allStops.put("2311", "2311"); // YONGE ST / LANGSTAFF RD
		allStops.put("5854", "5854"); // NINTH LINE  STOP # 5854
		allStops.put("5855", "5855"); // NINTH LINE STOP # 5855
		allStops.put("5856", "5856"); // NINTH LINE STOP # 5856
		allStops.put("5857", "5857"); // NINTH LINE STOP # 5857
		allStops.put("5850", "5850"); // KEELE ST / KING VAUGHAN RD
		allStops.put("5851", "5851"); // CHURCH ST / ROSE WAY
		allStops.put("5852", "5852"); // NINTH LINE / MAJOR MACKENZIE DR
		allStops.put("4526", "4526"); // WORTHINGTON AV / LORRIDGE ST
		allStops.put("9706", "9706_merged_3513082"); // HWY 7 / PINE VALLEY
		allStops.put("5859", "5859"); // METRO RD / GWENDOLYN BLVD
		allStops.put("4293", "4293_merged_3513105"); // EAST GWILLIMBURY GO STATION PLATFORM 11
		allStops.put("3773", "3773"); // EDGELEY BLVD / PORTAGE PKWAY
		allStops.put("3771", "3771"); // INTERCHANGE WAY / COMMERCE ST
		allStops.put("3770", "3770"); // WESTON RD / HIGHWAY 7
		allStops.put("4789", "4789"); // LEGACY DR / ROUGE BANK DR
		allStops.put("6724", "6724"); // STOUFFVILLE RD / HIGHWAY 48
		allStops.put("4522", "4522"); // JEFFERSON FOREST DR / BUSH RIDGES A
		allStops.put("4655", "4655"); // SANDFORD ST / MULOCK DR
		allStops.put("4654", "4654"); // SANDFORD ST / LLOYD ST
		allStops.put("4657", "4657"); // LORNE AV / DAVIS DR
		allStops.put("4656", "4656"); // SANDFORD ST / STELLICK AV
		allStops.put("4651", "4651"); // LORNE AV / EAGLE ST
		allStops.put("4650", "4650"); // LORNE AV / PARK AV
		allStops.put("4653", "4653"); // SANDFORD ST / HANDLEY CRES
		allStops.put("4652", "4652"); // SANDFORD ST / DON MOR DR
		allStops.put("6587", "6587"); // MAVRINAC BLVD / GUNDY WAY
		allStops.put("4520", "4520"); // SHADOW FALLS DR / WOLF TRAIL CRES
		allStops.put("4659", "4659"); // KENNEDY ST / MURRAY DR
		allStops.put("4658", "4658"); // KENNEDY ST / BATHURST ST
		allStops.put("4784", "4784"); // BUR OAK AV / ROYAL FEATHERS ST
		allStops.put("2006", "2006"); // LESLIE ST / CROWDER BLVD
		allStops.put("2268", "2268"); // STONE RD / CROWS NEST GATE
		allStops.put("2269", "2269"); // STONE RD / FIFE RD
		allStops.put("6190", "6190"); // KING RD / SCHOMBERG RD
		allStops.put("2266", "2266"); // STONE RD / PRIMEAU DR
		allStops.put("2267", "2267"); // STONE RD STOP # 2267
		allStops.put("2265", "2265"); // STONE RD / OCTOBER LANE
		allStops.put("2440", "2440"); // MULOCK DR / DOUBLETREE LANE
		allStops.put("1643", "1643"); // ALDEN RD / MCPHERSON ST
		allStops.put("2447", "2447"); // LONGFORD DR / NEWBURY DR
		allStops.put("6449", "6449_merged_3513126"); // BLACK RIVER AND DALTON
		allStops.put("2448", "2448"); // HARRISON DR / CHERRYWOOD DR
		allStops.put("2449", "2449"); // HARRISON DR / LONDON RD
		allStops.put("7035", "7035"); // WILLIAM BERCZY BLVD / WILFRED MURIS
		allStops.put("2103", "2103"); // YORKLAND ST / DEVONSLEIGH BLVD
		allStops.put("2102", "2102"); // DEVONSLEIGH BLVD / BROOKWOOD DR
		allStops.put("3282", "3282"); // BATHURST ST / AUTUMN HILL RD
		allStops.put("2101", "2101"); // DEVONSLEIGH BLVD / WOODSTONE AV
		allStops.put("4148", "4148"); // HIGHWAY 7 / BRUCE ST
		allStops.put("4813", "4813"); // MAJOR MACKENZIE DR / MINGAY AV
		allStops.put("4812", "4812"); // MAJOR MACKENZIE DR / STRICKER AV
		allStops.put("4811", "4811"); // MAJOR MACKENZIE DR / STRICKER AV
		allStops.put("2045", "2045"); // EAGLE ST / MILLARD AV
		allStops.put("4817", "4817"); // MAJOR MACKENZIE DR / HIGHWAY 48
		allStops.put("2043", "2043"); // CROSSLAND GATE / ALEX DONER DR
		allStops.put("4815", "4815"); // BUR OAK AV / ANDERSON AV
		allStops.put("2041", "2041"); // CROSSLAND GATE / FAIRWAY GDNS
		allStops.put("2107", "2107"); // DEVONSLEIGH BLVD / 19TH AV
		allStops.put("4819", "4819"); // MAJOR MACKENZIE DR / ROY RAINEY AV
		allStops.put("4818", "4818"); // MAJOR MACKENZIE DR / RALPH CHALMERS
		allStops.put("1297", "1297"); // DENISON ST / KENNEDY RD
		allStops.put("2048", "2048"); // EAGLE ST / MCCAFFREY RD
		allStops.put("2049", "2049"); // EAGLE ST STOP # 2049
		allStops.put("6378", "6378"); // WILLIAMSON RD / FOREST VALLEY RD
		allStops.put("6379", "6379"); // WILLIAMSON RD / FOREST VALLEY RD
		allStops.put("1088", "1088"); // ESNA PARK DR / ALDEN RD
		allStops.put("2105", "2105"); // DEVONSLEIGH BLVD / SUMMITCREST DR
		allStops.put("5515", "5515"); // GEORGINA FIRE STATION
		allStops.put("6370", "6370"); // HIGHWAY 27 /  INNOVATION DR
		allStops.put("6371", "6371"); // MEDALLION BLVD / MORNING STAR DR
		allStops.put("6372", "6372"); // MORNING STAR DR / NICKLE GATE
		allStops.put("2104", "2104"); // DEVONSLEIGH BLVD / SUMMITCREST DR
		allStops.put("6374", "6374"); // MORNING STAR DR / MARTIN GROVE RD
		allStops.put("6375", "6375"); // MCCOWAN RD STOP # 6375
		allStops.put("6376", "6376"); // WILLIAMSON RD / MIRAMAR DR
		allStops.put("6377", "6377"); // WILLIAMSON RD / PARK PLACE DR
		allStops.put("2143", "2143"); // WELDRICK RD / CHURCH ST
		allStops.put("2839", "2839"); // ROSE BRANCH DR / LENO MILLS AV
		allStops.put("2838", "2838"); // ROSE BRANCH DR / COUGAR CRT
		allStops.put("3064", "3064"); // RUTHERFORD RD / BATHURST ST
		allStops.put("1060", "1060"); // SPADINA RD / BROOKSHILL CRES
		allStops.put("2810", "2810"); // AVENUE RD / OAK AV
		allStops.put("2836", "2836"); // BAYVIEW AV / WOODRIVER ST
		allStops.put("4108", "4108"); // SIMCOE AV / METRO RD
		allStops.put("3519", "3519"); // MARTIN GROVE RD STOP # 3519
		allStops.put("7269", "7269"); // MURRELL BLVD / APPLEGATE DR
		allStops.put("2732", "2732"); // REDSTONE RD / SHIRLEY DR
		allStops.put("7264", "7264"); // CENTRE ST / ELIZABETH ST
		allStops.put("3511", "3511"); // STEELES AV / GIHON SPRING DR
		allStops.put("5299", "5299"); // RED MAPLE RD STOP # 5299
		allStops.put("3517", "3517"); // MARTIN GROVE RD STOP # 3517
		allStops.put("3515", "3515"); // MARTIN GROVE RD / STEELES AV
		allStops.put("6204", "6204"); // MCCLELLAN WAY / BATHURST ST
		allStops.put("6205", "6205"); // MCCLELLAN WAY / ALLENVALE DR
		allStops.put("6206", "6206"); // MCCLELLAN WAY / BONNY MEADOWS DR
		allStops.put("6207", "6207"); // MCCLELLAN WAY / BROOKEVIEW DR
		allStops.put("2688", "2688"); // ROLLINGHILL RD / RICHVALLEY CRES
		allStops.put("2689", "2689"); // CANYON HILL AV / LEYBURN AV
		allStops.put("6202", "6202"); // PROSPECT ST / 100M SOUTH OF DAVIS D
		allStops.put("2686", "2686"); // GAMBLE RD / ROLLINGHILL RD
		allStops.put("2687", "2687"); // ROLLINGHILL RD / GLENIS GATE
		allStops.put("6208", "6208"); // MCCLELLAN WAY / TAMARAC TRAIL
		allStops.put("2681", "2681"); // ROLLINGHILL RD / RICHVALLEY CRES
		allStops.put("2682", "2682"); // ROLLINGHILL RD / GLENIS GATE
		allStops.put("2683", "2683"); // ROLLINGHILL RD / GAMBLE RD
		allStops.put("3391", "3391"); // ROYAL ORCHARD BLVD / SHADY LANE CRE
		allStops.put("6808", "6808"); // LESLIE ST STOP # 6808
		allStops.put("6809", "6809"); // LESLIE ST / HOLBORN RD
		allStops.put("6806", "6806"); // KING RD / STAN ROOTS ST
		allStops.put("6807", "6807"); // HIGHWAY 27 / HIGHWAY 7
		allStops.put("6804", "6804"); // CREDITSTONE RD / GRANITERIDGE RD
		allStops.put("6805", "6805"); // KIRBY RD / KEELE ST
		allStops.put("6802", "6802"); // GLENWOODS AV STOP # 6802
		allStops.put("6803", "6803"); // CREDITSTONE RD / GRANITERIDGE RD
		allStops.put("6800", "6800"); // CARRICK AV / CHARTWELL CRES
		allStops.put("6801", "6801"); // CARRICK AV STOP # 6801
		allStops.put("9744", "9744"); // RIVIS RD / YMCA BLVD
		allStops.put("9745", "9745"); // RIVIS RD / YMCA BLVD
		allStops.put("9746", "9746"); // UNIONVILLE GO STATION PLATFORM 1
		allStops.put("5404", "5404"); // DALTON RD / WOODRIVER BEND
		allStops.put("9740", "9740"); // HWY 7 / TOWN CENTRE
		allStops.put("9741", "9741"); // HWY 7 / TOWN CENTRE
		allStops.put("9742", "9742"); // ENTERPRISE BLVD / WARDEN AV
		allStops.put("9743", "9743"); // ENTERPRISE BLVD / WARDEN AV
		allStops.put("6882", "6882"); // CORNELL ROUGE BLVD / RIVERLANDS AV
		allStops.put("9748", "9748"); // KENNEDY RD / HWY 7
		allStops.put("9749", "9749"); // HWY 7 / BULLOCK
		allStops.put("3394", "3394"); // NAPA VALLEY AV / CASA VISTA DR
		allStops.put("3207", "3207"); // HILLMOUNT RD / MARKLAND ST
		allStops.put("1622", "1622"); // HILLMOUNT RD / HOPECREST RD
		allStops.put("3205", "3205"); // HILLMOUNT RD STOP # 3205
		allStops.put("3204", "3204"); // HILLMOUNT RD STOP # 3204
		allStops.put("3203", "3203"); // HAZELTON AV / CASTLEVIEW CRES
		allStops.put("3202", "3202"); // HAZELTON AV / WINTER CREEK CRES
		allStops.put("1997", "1997"); // LESLIE ST / MULOCK DR
		allStops.put("1624", "1624"); // HILLMOUNT RD / WOODBINE AV
		allStops.put("1999", "1999"); // LESLIE ST / CROWDER BLVD
		allStops.put("1998", "1998"); // LESLIE ST STOP # 1998
		allStops.put("5188", "5188"); // MAIN ST / CEMETERY LANE
		allStops.put("1628", "1628"); // WOODBINE AV / 16TH AV
		allStops.put("3209", "3209"); // HILLMOUNT RD STOP # 3209
		allStops.put("3208", "3208"); // HILLMOUNT RD STOP # 3208
		allStops.put("3012", "3012"); // 16TH AV / RODICK RD
		allStops.put("9794", "9794"); // YONGE / KING
		allStops.put("6013", "6013"); // HARDING BLVD / BRILLINGER ST
		allStops.put("3013", "3013"); // 16TH AV / TOWNSON RD
		allStops.put("5058", "5058"); // MAIN ST / BEXHILL RD
		allStops.put("3010", "3010"); // 16TH AV / NUFIELD GATE
		allStops.put("2860", "2860"); // BAYVIEW AV / TAYLOR MILLS DR S
		allStops.put("2861", "2861"); // BAYVIEW AV / CROSBY AV
		allStops.put("2862", "2862"); // BAYVIEW AV / CARTIER CRES
		allStops.put("2863", "2863"); // BAYVIEW AV / CENTRE ST
		allStops.put("2864", "2864"); // BAYVIEW AV / MARAMAK RD
		allStops.put("2865", "2865"); // BAYVIEW AV / MAJOR MACKENZIE DR
		allStops.put("2866", "2866"); // BAYVIEW AV / PALMER AV
		allStops.put("2867", "2867"); // BAYVIEW AV / WELDRICK RD
		allStops.put("2868", "2868"); // BAYVIEW AV / HILLSVIEW DR
		allStops.put("2869", "2869"); // BAYVIEW AV / ARDWOLD GATE
		allStops.put("4694", "4694"); // YONGE ST / ARNOLD CRES
		allStops.put("2070", "2070"); // GORHAM ST / LESLIE ST
		allStops.put("3566", "3566"); // MARTIN GROVE RD STOP # 3566
		allStops.put("3014", "3014"); // 16TH AV / WOODBINE AV
		allStops.put("1199", "1199"); // WELLINGTON ST / YONGE ST
		allStops.put("1198", "1198"); // COMMERCE VALLEY DR STOP # 1198
		allStops.put("3348", "3348"); // NEW WESTMINSTER DR STOP # 3348
		allStops.put("3349", "3349"); // ISLINGTON AV / SPRING BERRY GATE
		allStops.put("7078", "7078"); // SHEPPARD AV / HERON'S HILL WAY
		allStops.put("7079", "7079"); // SHEPPARD AV / PARKWAY FOREST DR
		allStops.put("3342", "3342"); // ATKINSON AV / EDMUND SEAGER DR
		allStops.put("1190", "1190"); // COMMERCE VALLEY DR / SOUTH PARK RD
		allStops.put("5452", "5452"); // REEVES WAY BLVD / HOOVER PARK DR
		allStops.put("1192", "1192"); // COMMERCE VALLEY DR / LESLIE ST
		allStops.put("3346", "3346"); // VAUGHAN MILLS MALL STOP # 3346
		allStops.put("3347", "3347"); // ATKINSON AV / BATHURST ST
		allStops.put("3344", "3344"); // ATKINSON AV STOP # 3344
		allStops.put("3345", "3345"); // ATKINSON AV / FLAMINGO RD
		allStops.put("1759", "1759"); // WELLINGTON ST / BERCZY ST
		allStops.put("1758", "1758"); // WELLINGTON ST / INDUSTRIAL PKWY
		allStops.put("1757", "1757"); // JOHN WEST WAY / WELLINGTON ST
		allStops.put("1756", "1756"); // JOHN WEST WAY / MUNICIPAL DR
		allStops.put("1755", "1755"); // JOHN WEST WAY / EVELYN BUCK LANE
		allStops.put("1754", "1754"); // HOLLIDGE BLVD / JOHN WEST WAY
		allStops.put("1752", "1752"); // HOLLIDGE BLVD / BAYVIEW AV
		allStops.put("1751", "1751"); // HOLLIDGE BLVD STOP # 1751
		allStops.put("1750", "1750"); // JOHN WEST WAY / HOLLIDGE BLVD
		allStops.put("4259", "4259"); // YONGE ST STOP # 4259
		allStops.put("4258", "4258"); // YONGE ST / YONGEHURST RD
		allStops.put("6974", "6974"); // RUTHERFORD RD / SPRINGSIDE RD
		allStops.put("1174", "1174"); // VALLEYMEDE DR / RED OAK DR
		allStops.put("6972", "6972"); // BATHURST ST / COLLINS CRT
		allStops.put("1172", "1172"); // VALLEYMEDE DR / LEICESTER RD
		allStops.put("1170", "1170"); // VALLEYMEDE DR / CHALMERS RD
		allStops.put("1008", "1008"); // RED MAPLE RD / BANTRY AV
		allStops.put("4255", "4255"); // HIGH TECH RD / NAHANNI DR
		allStops.put("4254", "4254"); // LANGSTAFF RD / SILMAR DR
		allStops.put("4257", "4257"); // HIGH TECH RD / FERRIS ST
		allStops.put("1178", "1178"); // VALLEYMEDE DR / HIGHWAY 7
		allStops.put("5537", "5537"); // RAYMERVILLE DR / QUARRY STONE DR
		allStops.put("5536", "5536"); // RAYMERVILLE DR / TAILOR ST
		allStops.put("5539", "5539"); // RAYMERVILLE DR / SANDERLING DR
		allStops.put("5538", "5538"); // RAYMERVILLE DR / COBBLER CRES
		allStops.put("1285", "1285"); // BUR OAK AV / RIVERLANDS AV
		allStops.put("1284", "1284"); // DENISON ST STOP # 1284
		allStops.put("1287", "1287"); // BUR OAK AV / THE MEADOWS AV
		allStops.put("1286", "1286"); // DENISON ST / CARTMEL DR
		allStops.put("1281", "1281"); // CARRVILLE RD / BATHURST ST
		allStops.put("1280", "1280"); // DENISON ST / TOWNLEY AV
		allStops.put("1283", "1283"); // RUTHERFORD RD / THOMAS COOK AV
		allStops.put("1282", "1282"); // DENISON ST / HILLCROFT DR
		allStops.put("7171", "7171"); // DUFFERIN ST / STEELES AV
		allStops.put("1289", "1289"); // DENISON ST / EDEN AV
		allStops.put("1288", "1288"); // DENISON ST / BRIMLEY RD
		allStops.put("3668", "3668"); // STEELES AV / MARKBROOK LANE
		allStops.put("7188", "7188"); // DUFFERIN ST STOP # 7188
		allStops.put("7189", "7189"); // DUFFERIN ST / OVERBROOK PL
		allStops.put("1579", "1579"); // BOXWOOD CRES / SPARTA CRT
		allStops.put("1578", "1578"); // RODICK RD / HANS DR
		allStops.put("1573", "1573"); // RUSSELL JARVIS DR / BLACK WALNUT DR
		allStops.put("1572", "1572"); // JOHN BUTTON BLVD / TOMLINSON CIR
		allStops.put("7182", "7182"); // DUFFERIN ST / FINCH AV
		allStops.put("1570", "1570"); // JOHN BUTTON BLVD / BUTTONFIELD RD
		allStops.put("1577", "1577"); // LEGACY DR / HONEYSUCKLE DR
		allStops.put("1576", "1576"); // RODICK RD / 16TH AV
		allStops.put("1575", "1575"); // LEGACY DR / RUSSEL JARVIS DR
		allStops.put("1574", "1574"); // JOHN BUTTON BLVD / RODICK RD
		allStops.put("4260", "4260"); // YONGE ST / SPRUCE AV
		allStops.put("4261", "4261"); // YONGE ST / OAK AV
		allStops.put("1873", "1873"); // KENNEDY RD / BUR OAK AV
		allStops.put("4521", "4521"); // JEFFERSON FOREST DR / SHADOW FALLS
		allStops.put("2008", "2008"); // LESLIE ST / MULOCK DR
		allStops.put("1295", "1295"); // DENISON ST / FRESNO CRT
		allStops.put("3767", "3767"); // WESTON RD / CHANCELLOR DR
		allStops.put("8010", "8010"); // MAJOR MACKENZIE DR / PROSPECTORS DR
		allStops.put("6572", "6572"); // CORNELL CENTRE BLVD / RUSTLE WOODS
		allStops.put("6573", "6573"); // RUSTLE WOODS AV / CORNELL CENTRE BL
		allStops.put("6570", "6570"); // RAVINEVIEW DR / CANYON GATE CRES
		allStops.put("6571", "6571"); // PEAK POINT BLVD / KEELE ST
		allStops.put("6577", "6577"); // HOLLANDVIEW TRL / MCMASTER AV
		allStops.put("6574", "6574"); // BUR OAK AV / CHURCH ST
		allStops.put("5628", "5628"); // CHURCH ST / COUNTRY GLEN RD
		allStops.put("5627", "5627"); // CHURCH ST / BUR OAK AV
		allStops.put("5626", "5626"); // CHURCH ST / BUR OAK AV
		allStops.put("4381", "4381"); // HENDERSON DR / TAMARAC TRL
		allStops.put("5624", "5624"); // BUR OAK AV / HIGHWAY 7
		allStops.put("4918", "4918"); // RUTHERFORD RD / VAUGHAN MILLS RD
		allStops.put("5622", "5622"); // HIGHWAY 7 / STONEY STANTON RD
		allStops.put("1371", "1371"); // MEADOWVIEW AV / YONGE ST
		allStops.put("1370", "1370"); // BUR OAK AV / MINGAY AV
		allStops.put("1373", "1373"); // CLARK AV / YONGE ST
		allStops.put("4591", "4591"); // MAPLE SUGAR LANE / THORNHILL WOODS
		allStops.put("1375", "1375"); // CLARK AV / SPRINGFIELD WAY
		allStops.put("1374", "1374"); // BUR OAK AV / MARKHAM RD
		allStops.put("1377", "1377"); // CLARK AV / CHARLES ST
		allStops.put("4269", "4269"); // MAJOR MACKENZIE DR / WARDEN AV
		allStops.put("1378", "1378"); // CLARK AV / HILDA AV
		allStops.put("5888", "5888"); // RUTHERFORD RD / JACOB KEFFER PKWY
		allStops.put("2744", "2744"); // CROSBY AV / PUGSLEY AV
		allStops.put("3834", "3834"); // TESTON RD / JANE ST
		allStops.put("3835", "3835"); // JANE ST / AMERICA AV
		allStops.put("3836", "3836"); // MELVILLE AV / AVRO RD
		allStops.put("3837", "3837"); // MELVILLE AV / NORWOOD AV
		allStops.put("3830", "3830"); // MELVILLE AV / MAJOR MACKENZIE DR
		allStops.put("3831", "3831"); // AHMADIYYA AV / TAHIR ST
		allStops.put("3832", "3832"); // AHMADIYYA AV / MOSQUE GATE
		allStops.put("3833", "3833"); // MOSQUE GATE / TESTON RD
		allStops.put("4595", "4595"); // PLEASANT RIDGE AV / MISTYSUGAR TRL
		allStops.put("3838", "3838"); // MELVILLE AV / SPRINGSIDE RD
		allStops.put("3839", "3839"); // SPRINGSIDE RD / PARKTREE DR
		allStops.put("1635", "1635"); // 14TH AV / WARDEN AV
		allStops.put("4031", "4031"); // PROMENADE TERMINAL PLATFORM 8
		allStops.put("5994", "5994"); // HELEN AV / GREENWATER GATE
		allStops.put("4033", "4033"); // CENTRE ST / ATKINSON AV
		allStops.put("4032", "4032"); // CENTRE ST / BATHURST ST
		allStops.put("4035", "4035"); // CENTRE ST / MARKWOOD LANE
		allStops.put("4034", "4034"); // CENTRE ST / ROSE GREEN DR
		allStops.put("4037", "4037"); // CENTRE ST / BROOKE ST
		allStops.put("4036", "4036"); // CENTRE ST / OAKBANK RD
		allStops.put("4039", "4039"); // CENTRE ST / YONGE ST
		allStops.put("4038", "4038"); // CENTRE ST / OLD YONGE ST
		allStops.put("1347", "1347"); // JOHN ST / PORTERFIELD CRES
		allStops.put("5999", "5999"); // CASTAN AV / PIERA GDNS
		allStops.put("4598", "4598"); // MAPLE SUGAR LANE / SUGARFOREST DR
		allStops.put("6793", "6793"); // HIGHWAY 7 / MONTGOMERY CT
		allStops.put("4599", "4599"); // MAPLE SUGAR LANE / DANIEL REAMAN CR
		allStops.put("4734", "4734"); // HIGHWAY 7 / MILLWAY AV
		allStops.put("4735", "4735"); // CONOVER AV / BOREALIS AV
		allStops.put("1084", "1084"); // ESNA PARK DR STOP # 1084
		allStops.put("4842", "4842"); // LARKIN AV / TILMAN CIR
		allStops.put("6929", "6929"); // MILLARD ST / BAKER HILL BLVD
		allStops.put("2038", "2038"); // ALEX DONER DR / OTTON RD
		allStops.put("4738", "4738"); // HAIDA DR / WELLINGTON ST
		allStops.put("1244", "1244"); // ELSON ST / MARYDALE AV
		allStops.put("9878", "9878"); // HELEN EASTBOUND
		allStops.put("6143", "6143"); // MINGAY AV / GOLDEN MEADOW DR
		allStops.put("6142", "6142"); // MINGAY AV / MEAD TERRACE
		allStops.put("6141", "6141"); // MINGAY AV / MEAD TERRACE
		allStops.put("6140", "6140"); // MINGAY AV / GOLDEN MEADOW DR
		allStops.put("6147", "6147"); // BAIF BLVD / YONGE ST
		allStops.put("6798", "6798"); // KENNEDY RD STOP # 6798
		allStops.put("6145", "6145"); // HIGHWAY 7 / SADDLE CREEK DR
		allStops.put("6144", "6144"); // STONE MASON DR / RAYMERVILLE DR
		allStops.put("6149", "6149"); // VOGELL RD / BRODIE DR
		allStops.put("6799", "6799"); // KENNEDY RD STOP # 6799
		allStops.put("4345", "4345"); // REGENT ST / BRIDEWELL CRES
		allStops.put("6640", "6640"); // HIGHWAY 7 / WEST BEAVER CREEK RD
		allStops.put("6781", "6781"); // LANGSTAFF RD / HUNTINGTON RD
		allStops.put("2308", "2308"); // LESLIE ST / ELGIN ST
		allStops.put("6783", "6783"); // NEW HUNTINGTON RD / CONAIR PKWY
		allStops.put("6782", "6782"); // NEW HUNTINGTON RD / HUNTINGTON RD
		allStops.put("4729", "4729"); // CHURCH ST / WOOTTEN WAY
		allStops.put("4728", "4728"); // WOOTTEN WAY / CHURCH ST
		allStops.put("6787", "6787"); // 14TH AV STOP # 6787
		allStops.put("6786", "6786"); // 14TH AV STOP # 6786
		allStops.put("6789", "6789"); // HIGHWAY 7 / ALLSTATE PKWY
		allStops.put("4724", "4724"); // NINTH LINE / CORNELL PARK AV
		allStops.put("4727", "4727"); // HIGHWAY 7 / VERCLAIRE GATE
		allStops.put("2302", "2302"); // HARRY WALKER PKWY / PONY DR
		allStops.put("4721", "4721"); // YONGE ST / SUNSET BEACH RD
		allStops.put("2304", "2304"); // HARRY WALKER PKWY / TWINNEY DR
		allStops.put("4723", "4723"); // CHURCH ST / ROSE WAY
		allStops.put("2306", "2306"); // HARRY WALKER PKWY / GORHAM ST
		allStops.put("5845", "5845"); // MARKLAND ST / BARTLETT RD
		allStops.put("5844", "5844"); // RUTHERFORD RD / NAPA VALLEY AV
		allStops.put("5843", "5843"); // KRIEGHOFF AV / VILLAGE PKWY
		allStops.put("5842", "5842"); // FRED VARLEY DR / KRIEGHOFF AV
		allStops.put("5841", "5841"); // FRED VARLEY DR / SCIBERRAS RD
		allStops.put("5840", "5840"); // FRED VARLEY DR / ALDONA DR
		allStops.put("5849", "5849"); // KEELE ST / KING VAUGHAN RD
		allStops.put("5848", "5848"); // MAJOR MACKENZIE DR / VELLORE PARK A
		allStops.put("5105", "5105"); // FARMSTEAD RD / INDIGO ST
		allStops.put("3748", "3748"); // WESTON RD / VALERIA BLVD
		allStops.put("3749", "3749"); // WESTON RD / ASTONA BLVD
		allStops.put("3746", "3746"); // WESTON RD / LANGSTAFF RD
		allStops.put("3747", "3747"); // WESTON RD / CRESTMOUNT BLVD
		allStops.put("3744", "3744"); // WESTON RD / CARLAUREN RD
		allStops.put("3745", "3745"); // WESTON RD / ROYTEC RD
		allStops.put("3742", "3742"); // WESTON RD / CHRISLEA RD
		allStops.put("3743", "3743"); // WESTON RD / BLUE WILLOW DR
		allStops.put("3740", "3740"); // PINE VALLEY DR / STEELES AV
		allStops.put("3741", "3741"); // WESTON RD / HIGHWAY 7
		allStops.put("4620", "4620"); // ISLINGTON AV / MAJOR MACKENZIE DR
		allStops.put("4621", "4621"); // MULOCK DR / COLLEGE MANOR DR
		allStops.put("4622", "4622"); // MULOCK DR / COLLEGE MANOR DR
		allStops.put("4623", "4623"); // YONGE ST / HARDING BLVD
		allStops.put("4624", "4624"); // YONGE ST / HOPKINS ST
		allStops.put("4625", "4625"); // ISLINGTON AV / TURNING LEAF DR
		allStops.put("4626", "4626"); // ISLINGTON AV / SONOMA BLVD
		allStops.put("4627", "4627"); // ISLINGTON AV / NAPA VALLEY AV
		allStops.put("4628", "4628"); // NO FRILLS STOP # 4628
		allStops.put("4629", "4629"); // ISLINGTON AV / MAJOR MACKENZIE DR
		allStops.put("3591", "3591"); // STEELES AV / YONGE ST
		allStops.put("2275", "2275"); // STONEHAVEN AV / FOXCROFT BLVD
		allStops.put("2274", "2274"); // LESLIE ST / STONEHAVEN AV
		allStops.put("2277", "2277"); // STONEHAVEN AV / BEST CIR
		allStops.put("2276", "2276"); // STONEHAVEN AV / KINGSMERE AV
		allStops.put("2271", "2271"); // STONE RD / BAYVIEW AV
		allStops.put("2270", "2270"); // STONE RD / HAWTIN LANE
		allStops.put("2273", "2273"); // LESLIE ST / IVSBRIDGE BLVD
		allStops.put("2272", "2272"); // LESLIE ST / KINGDALE RD
		allStops.put("2279", "2279"); // STONEHAVEN AV / BAYVIEW AV
		allStops.put("2278", "2278"); // STONEHAVEN AV STOP # 2278
		allStops.put("2489", "2489"); // YONGE ST / SILVERWOOD DR
		allStops.put("4905", "4905"); // YMCA BLVD / KENNEDY RD
		allStops.put("7178", "7178"); // DUFFERIN ST / MARTIN ROSS DR
		allStops.put("1248", "1248"); // ELSON ST / COXWORTH AV
		allStops.put("1071", "1071"); // FARMSTEAD RD / SHIRLEY DR
		allStops.put("5389", "5389_merged_3513107"); // HIGH AND BURKE STREET
		allStops.put("2459", "2459"); // BRISTOL RD / ELMAN CRES
		allStops.put("2458", "2458"); // BRISTOL RD / ELMAN CRES
		allStops.put("2455", "2455"); // BRISTOL RD / STIVER DR
		allStops.put("2454", "2454"); // BRISTOL RD / BILLINGS CRES
		allStops.put("2457", "2457"); // BRISTOL RD / STIVER DR
		allStops.put("2456", "2456"); // BRISTOL RD / MCINTYRE CRT
		allStops.put("2451", "2451"); // LONDON RD / DORCHESTER ST
		allStops.put("2450", "2450"); // LONDON RD / YORKSHIRE DR
		allStops.put("2453", "2453"); // BRISTOL RD / BILLINGS CRES
		allStops.put("2452", "2452"); // DORCHESTER ST / SALISBURY LANE
		allStops.put("7116", "7116"); // 15TH SIDEROAD / BATHURST ST
		allStops.put("6313", "6313"); // VICTORIA SQUARE BLVD / MURISON DR
		allStops.put("3698", "3698"); // STEELES AV / KEELE ST
		allStops.put("2050", "2050"); // EAGLE ST / YONGE ST
		allStops.put("2053", "2053"); // EAGLE ST / SANDFORD ST
		allStops.put("2052", "2052"); // EAGLE ST / DONLIN AV
		allStops.put("2055", "2055"); // EAGLE ST / EDWARD ST
		allStops.put("2054", "2054"); // EAGLE ST / JAMES AV
		allStops.put("2057", "2057"); // EAGLE ST / ELLEN ST
		allStops.put("2056", "2056"); // EAGLE ST / LORNE AV
		allStops.put("3690", "3690"); // STEELES AV / MURRAY ROSS PKWY
		allStops.put("3691", "3691"); // ABERDEEN AV / ASHCROFT CRT
		allStops.put("4824", "4824"); // HOLLANDVIEW TRL / BRIDGENORTH DR
		allStops.put("4537", "4537"); // KEELE ST STOP # 4537
		allStops.put("3694", "3694"); // STEELES AV STOP # 3694
		allStops.put("3695", "3695"); // ABERDEEN AV / ANDREA LANE
		allStops.put("4532", "4532"); // KEELE ST / KIRBY RD
		allStops.put("3697", "3697"); // ABERDEEN AV / ANSLEY GROVE RD
		allStops.put("4649", "4649"); // LORNE AV / EAGLE ST
		allStops.put("6363", "6363"); // BLUE WILLOW DR / GRANTCREST GATE
		allStops.put("6362", "6362"); // BLUE WILLOW DR / WESTON RD
		allStops.put("6361", "6361"); // BLUE WILLOW DR / WESTON RD
		allStops.put("6360", "6360"); // BLUE WILLOW DR / POTTERY PLACE
		allStops.put("6367", "6367"); // HIGHWAY 27 / RUTHERFORD RD
		allStops.put("4856", "4856"); // MOUNT ALBERT RD / COLONEL WAYLING B
		allStops.put("6364", "6364"); // GREEN LANE
		allStops.put("1367", "1367"); // DONCASTER AV STOP # 1367
		allStops.put("4923", "4923"); // 16TH AV / ALEXANDER LAWRIE AV
		allStops.put("4402", "4402"); // WALMART STOP # 4402
		allStops.put("2578", "2578_merged_3513121"); // MOUNT ALBERT AND LESLIE STREET
		allStops.put("3527", "3527"); // MARTIN GROVE RD / ANDREW PARK
		allStops.put("5149", "5149"); // BATHURST ST / HEARTHSIDE AV
		allStops.put("3525", "3525"); // MARTIN GROVE RD / HIGHWAY 7
		allStops.put("3523", "3523"); // MARTIN GROVE RD / WOODSTREAM BLVD
		allStops.put("3521", "3521"); // MARTIN GROVE RD / ROYSUN RD
		allStops.put("7043", "7043"); // VICTORIA PARK AV / GORDON BAKER RD
		allStops.put("1976", "1976_merged_3513088"); // YONGE ST / GREEN LANE
		allStops.put("3529", "3529"); // MARTIN GROVE RD / RAYMOND RD
		allStops.put("7218", "7218"); // INTERCHANGE WAY / JANE ST
		allStops.put("7219", "7219"); // INTERCHANGE WAY / JANE ST
		allStops.put("3086", "3086"); // 16TH AV / NORMANDALE RD
		allStops.put("7210", "7210"); // MAJOR MACKENZIE DR / POETRY DR
		allStops.put("7211", "7211"); // MAJOR MACKENZIE DR / VELLORE AV
		allStops.put("7212", "7212"); // LESLIE ST / WALTER ENGLISH DR
		allStops.put("7213", "7213"); // LESLIE ST / WALTER ENGLISH DR
		allStops.put("7215", "7215"); // HIGHWAY 7 / MAPLECRETE RD
		allStops.put("7216", "7216"); // HIGHWAY 7 / MAPLECRETE RD
		allStops.put("7217", "7217"); // INTERCHANGE WAY / HIGHWAY 7
		allStops.put("6217", "6217"); // OLD COLONY RD / LEBOVIC DR
		allStops.put("6216", "6216"); // OLD COLONY RD / TIGER LILY ST
		allStops.put("6215", "6215"); // OLD COLONY RD / AUBERGINE ST
		allStops.put("3583", "3583"); // STEELES AV STOP # 3583
		allStops.put("6213", "6213"); // OLD COLONY RD / TIGER LILY ST
		allStops.put("6212", "6212"); // OLD COLONY RD / LEBOVIC DR
		allStops.put("2699", "2699"); // BATHURST ST / LADY DELORES AV
		allStops.put("2698", "2698"); // BATHURST ST / TESTON RD
		allStops.put("4472", "4472"); // VELLORE WOODS BLVD / BUCKSAW DR
		allStops.put("2696", "2696"); // SHAFTSBURY AV / BATHURST ST
		allStops.put("2694", "2694"); // SHAFTSBURY AV / OWL RIDGE DR
		allStops.put("2693", "2693"); // SHAFTSBURY AV / BROOKSIDE RD
		allStops.put("2692", "2692"); // SHAFTSBURY AV / BUCKHORN AV
		allStops.put("2691", "2691"); // CANYON HILL AV / SHAFTSBURY AV
		allStops.put("2690", "2690"); // CANYON HILL AV / PALOMINO DR
		allStops.put("6819", "6819"); // WOODBINE PARK AND RIDE STOP # 6819
		allStops.put("3226", "3226"); // COCHRANE DR / LANARK RD
		allStops.put("4558", "4558"); // NEWBRIDGE AV / KINGSHILL RD
		allStops.put("6811", "6811"); // LESLIE ST STOP # 6811
		allStops.put("1605", "1605"); // 14TH AV / CANFIELD DR
		allStops.put("6813", "6813"); // HIGHWAY 7 / DONALD COUSENS PKWY
		allStops.put("6812", "6812"); // LESLIE ST STOP # 6812
		allStops.put("6815", "6815"); // MARKLAND ST STOP # 6815
		allStops.put("6814", "6814"); // HARDING BLVD / YONGE ST
		allStops.put("3220", "3220"); // CENTURIAN DR / ALLSTATE PKWY
		allStops.put("9756", "9756"); // HWY 7 / WOOTTEN
		allStops.put("9755", "9755"); // HWY 7 / WOOTTEN
		allStops.put("9754", "9754"); // HWY 7 / MAIN MARKHAM
		allStops.put("9753", "9753"); // HWY 7 / MAIN MARKHAM
		allStops.put("9752", "9752"); // HWY 7 / MCCOWAN
		allStops.put("9751", "9751"); // HWY 7 / MCCOWAN
		allStops.put("9750", "9750"); // HWY 7 / BULLOCK
		allStops.put("1606", "1606"); // HOLLINGHAM RD / BAYCLIFFE RD
		allStops.put("3232", "3232"); // COCHRANE DR STOP # 3232
		allStops.put("3233", "3233"); // COCHRANE DR / EAST VALHALLA DR
		allStops.put("3230", "3230"); // COCHRANE DR STOP # 3230
		allStops.put("3231", "3231"); // COCHRANE DR STOP # 3231
		allStops.put("3236", "3236"); // VALLEYWOOD DR STOP # 3236
		allStops.put("5198", "5198"); // WHITES HILL AV / WALKERVILLE RD
		allStops.put("3234", "3234"); // ALLSTATE PKWY / VALLEYWOOD DR
		allStops.put("1619", "1619"); // 14TH AV / BECKENRIDGE DR
		allStops.put("1616", "1616"); // WOODBINE AV / PERSONNA BLVD
		allStops.put("1965", "1965"); // BATHURST ST / NER ISRAEL DR
		allStops.put("3238", "3238"); // VALLEYWOOD DR / RENFREW DR
		allStops.put("3239", "3239"); // RENFREW DR / HOOPER RD
		allStops.put("1612", "1612"); // HOLLINGHAM RD / BRANTWOOD CRT
		allStops.put("1961", "1961"); // BATHURST ST / MARC SANTI BLVD
		allStops.put("1610", "1610"); // HOLLINGHAM RD / GLAMORGAN CRT
		allStops.put("1611", "1611"); // 14TH AV / MCCOWAN RD
		allStops.put("3674", "3674"); // STEELES AV STOP # 3674
		allStops.put("2063", "2063"); // GORHAM ST / CROWDER BLVD
		allStops.put("6638", "6638"); // HIGHWAY 7 / COMMERCE VALLEY DR EAST
		allStops.put("1363", "1363"); // DONCASTER AV STOP # 1363
		allStops.put("5772", "5772"); // MIDDLEFIELD RD / GOLDEN AV
		allStops.put("2873", "2873"); // BAYVIEW AV STOP # 2873
		allStops.put("2872", "2872"); // BAYVIEW AV / DUNCAN RD
		allStops.put("2871", "2871"); // BAYVIEW AV / 16TH AV
		allStops.put("2870", "2870"); // BAYVIEW AV / FERN AV
		allStops.put("2877", "2877"); // BAYVIEW AV / CRESWICK RD
		allStops.put("2876", "2876"); // BAYVIEW AV / HIGH TECH RD
		allStops.put("2875", "2875"); // BAYVIEW AV / BANTRY AV
		allStops.put("2874", "2874"); // BAYVIEW AV / SPRINGBROOK DR
		allStops.put("3281", "3281"); // BATHURST ST / SUMMERIDGE DR
		allStops.put("2879", "2879"); // BAYVIEW AV / LANGSTAFF RD
		allStops.put("2878", "2878"); // BAYVIEW AV STOP # 2878
		allStops.put("4632", "4632"); // ISLINGTON AV / NAPA VALLEY AV
		allStops.put("3355", "3355"); // ISLINGTON AV / RUSHWORTH CRES
		allStops.put("3354", "3354"); // NEW WESTMINSTER DR / CLARK AV
		allStops.put("3357", "3357"); // ISLINGTON AV STOP # 3357
		allStops.put("3356", "3356"); // NEW WESTMINSTER DR / COULTERS MILL
		allStops.put("3350", "3350"); // NEW WESTMINSTER DR / BEVERLEY GLEN
		allStops.put("3353", "3353"); // ISLINGTON AV / SEVILLA BLVD
		allStops.put("3352", "3352"); // NEW WESTMINSTER DR / KATERINA AV
		allStops.put("3359", "3359"); // ISLINGTON AV / NASHVILLE RD
		allStops.put("3358", "3358"); // NEW WESTMINSTER DR / JOSEPH AARON B
		allStops.put("2671", "2671"); // YONGE ST / TOWER HILL RD
		allStops.put("5449", "5449"); // HOOVER PARK DR / DORCAS GATE
		allStops.put("7069", "7069"); // VICTORIA PARK AV / HUNTINGWOOD DR
		allStops.put("7068", "7068"); // VICTORIA PARK AV / OLD SHEPPARD AV
		allStops.put("5443", "5443"); // REEVES WAY BLVD / NINTH LINE
		allStops.put("5442", "5442"); // REEVES WAY BLVD / HIRAM JOHNSON RD
		allStops.put("5441", "5441"); // REEVES WAY BLVD / JOSEPH TODD AV
		allStops.put("5440", "5440"); // REEVES WAY BLVD / RICHARD UNDERHILL
		allStops.put("7063", "7063"); // VICTORIA PARK AV / PLEASANT VIEW DR
		allStops.put("5446", "5446"); // HOOVER PARK DR / SANDIFORD DR
		allStops.put("5445", "5445"); // HOOVER PARK DR / MOSTAR ST
		allStops.put("5444", "5444"); // HOOVER PARK DR / WELDON RD
		allStops.put("1768", "1768"); // NINTH LINE / CORNELL PARK AV
		allStops.put("1769", "1769"); // NINTH LINE / MERLIN GATE
		allStops.put("1763", "1763"); // NINTH LINE / DONALD COUSENS PKWY
		allStops.put("1761", "1761"); // YONGE ST / MURRAY DR
		allStops.put("1766", "1766"); // NINTH LINE / TIERS GATE
		allStops.put("1767", "1767"); // NINTH LINE / FINCHAM AV
		allStops.put("1764", "1764"); // NINTH LINE / BUR OAK AV
		allStops.put("1765", "1765"); // NINTH LINE / 16TH AV
		allStops.put("1142", "1142"); // SPADINA RD / WELDRICK RD
		allStops.put("1143", "1143"); // CHISWICK CRES / MCCLELLAN WAY
		allStops.put("1140", "1140"); // SPADINA RD / STRATHEARN AV
		allStops.put("1141", "1141"); // MCCLELLAN WAY / BROOKEVIEW DR
		allStops.put("1146", "1146"); // SPADINA RD / MARLBOROUGH ST
		allStops.put("1147", "1147"); // MCCLELLAN WAY / BATHURST ST
		allStops.put("1144", "1144"); // SPADINA RD / BROOKSHILL CRES
		allStops.put("6966", "6966"); // VAUGHAN MILLS RD / HUMBERVIEW DR
		allStops.put("6969", "6969"); // NAPA VALLEY AV / MONTEBELLO AV
		allStops.put("6968", "6968"); // VAUGHAN MILLS RD / ROSELAWN DR
		allStops.put("1148", "1148"); // SPADINA RD / BOAKE TRL
		allStops.put("1149", "1149"); // BATHURST ST / 15TH SDRD
		allStops.put("2966", "2966"); // MAJOR MACKENZIE DR / PUGSLEY AV
		allStops.put("5500", "5500"); // LESLIE ST / BALMORAL HTS
		allStops.put("1546", "1546"); // NINTH LINE / KENILWORTH GATE
		allStops.put("1544", "1544"); // RUSSELL JARVIS DR / WHITE BLUFF LAN
		allStops.put("1545", "1545"); // GLENCOVE DR / WARDEN AV
		allStops.put("1542", "1542"); // ROUGE BANK DR / LEGACY DR
		allStops.put("1543", "1543"); // BUCHANAN DR / GLENCOVE DR
		allStops.put("1540", "1540"); // ROUGE BANK DR / SILVERFLOWER AV
		allStops.put("1541", "1541"); // BUCHANAN DR / SPANHOUSE CRES
		allStops.put("1548", "1548"); // NINTH LINE / HIGHWAY 7
		allStops.put("1549", "1549"); // HIGHWAY 7 / TOWN CENTRE BLVD
		allStops.put("7199", "7199"); // PIONEER VILLAGE STATION PLATFORM 5
		allStops.put("7198", "7198"); // PIONEER VILLAGE STATION PLATFORM 4
		allStops.put("7193", "7193"); // SHEPPARD WEST STATION
		allStops.put("7192", "7192"); // SHEPPARD AV W / DUFFERIN ST
		allStops.put("7191", "7191"); // ALLEN RD / RIMROCK RD
		allStops.put("7190", "7190"); // ALLEN RD / RIMROCK RD
		allStops.put("7197", "7197"); // PIONEER VILLAGE STATION PLATFORM 3
		allStops.put("7196", "7196"); // PIONEER VILLAGE STATION PLATFORM 2
		allStops.put("7195", "7195"); // PIONEER VILLAGE STATION PLATFORM 1
		allStops.put("7194", "7194"); // SHEPPARD WEST STATION
		allStops.put("2929", "2929"); // CRANSTON PARK AV / CUNNINGHAM DR
		allStops.put("7113", "7113"); // HUNTINGTON RD / LANGSTAFF RD
		allStops.put("5618", "5618"); // BOX GROVE BYP / OAKBOROUGH RD
		allStops.put("5619", "5619"); // BOX GROVE BY PASS / OAKBOROUGH DR
		allStops.put("6569", "6569"); // RAVINEVIEW DR / CANYON GATE CRES
		allStops.put("6568", "6568"); // RAVINEVIEW DR / VISTA GATE
		allStops.put("3321", "3321"); // VAUGHAN MILLS TERMINAL PLATFORM 7
		allStops.put("6565", "6565"); // RAVINEVIEW DR / BEAVERBROOK CRES
		allStops.put("6564", "6564"); // KIRBY RD / RAVINEVIEW DR
		allStops.put("5610", "5610"); // FIRST COMMERCE DR STOP # 5610
		allStops.put("6566", "6566"); // RAVINEVIEW DR / BEAVERBROOK CRES
		allStops.put("5616", "5616"); // BATHURST ST / TOWER HILL DR
		allStops.put("5617", "5617"); // BATHURST ST / JEFFERSON SDRD
		allStops.put("5615", "5615"); // ELGIN ST / PATTERSON ST
		allStops.put("5475", "5475"); // KINGSHILL RD / HOLTBY ST
		allStops.put("1388", "1388"); // CLARK AV / NEW WESTMINSTER DR
		allStops.put("1389", "1389"); // BUR OAK AV / MCCOWAN RD
		allStops.put("9807", "9807_merged_3513090"); // YONGE / MULOCK
		allStops.put("6934", "6934"); // MAIN ST / DONNA LEE TR
		allStops.put("1384", "1384"); // CLARK AV / BATHURST ST
		allStops.put("1385", "1385"); // BUR OAK AV / ROY RAINEY AV
		allStops.put("1386", "1386"); // CLARK AV / SOUTH PROMENADE
		allStops.put("1380", "1380"); // CLARK AV / ATKINSON AV
		allStops.put("1381", "1381"); // BUR OAK AV / MINGAY AV
		allStops.put("1382", "1382"); // CLARK AV / YORK HILL BLVD
		allStops.put("1383", "1383"); // BUR OAK AV / DOGWOOD ST
		allStops.put("3827", "3827"); // MELVILLE AV / SPRINGSIDE RD
		allStops.put("3826", "3826"); // SPRINGSIDE RD / PARKTREE DR
		allStops.put("9873", "9873"); // BATHURST & HIGHWAY 7
		allStops.put("3824", "3824"); // JANE ST / RUTHERFORD RD
		allStops.put("3822", "3822"); // JANE ST / LOCKE ST
		allStops.put("3821", "3821"); // JANE ST / BAGG ST
		allStops.put("3581", "3581"); // STEELES AV / HENDERSON AV
		allStops.put("6878", "6878"); // CORNELL ROUGE BLVD / AUTUMN GLOW DR
		allStops.put("2769", "2769"); // SHAFTSBURY AV / CANYON HILL AV
		allStops.put("3829", "3829"); // MELVILLE AV / AVRO RD
		allStops.put("3041", "3041"); // RUTHERFORD RD / BABAK BLVD
		allStops.put("2768", "2768"); // SHAFTSBURY AV / BUCKHORN AV
		allStops.put("4212", "4212"); // DON MILLS RD / GOODVIEW RD
		allStops.put("3040", "3040"); // RUTHERFORD RD / PINE VALLEY DR
		allStops.put("1093", "1093"); // ELGIN MILLS RD / LESLIE ST
		allStops.put("3043", "3043"); // RUTHERFORD RD / FOSSIL HILL RD
		allStops.put("4827", "4827"); // ST. JOHN'S SDRD / EARL STEWART DR
		allStops.put("4282", "4282"); // LANGSTAFF RD / STAN GATE
		allStops.put("4283", "4283"); // LANGSTAFF RD / WESTON RD
		allStops.put("4280", "4280"); // ANSLEY GROVE RD / LANGSTAFF RD
		allStops.put("4281", "4281"); // ANSLEY GROVE RD / LANGSTAFF RD
		allStops.put("4287", "4287"); // YONGE ST / WESTWOOD LANE
		allStops.put("4284", "4284"); // MAJOR MACKENZIE DR / STARLING BLVD
		allStops.put("4285", "4285"); // CHANCELLOR DR / ABERDEEN AV
		allStops.put("5461", "5461"); // SELWYN RD / CROSSROADS DR
		allStops.put("9818", "9818_merged_3513087"); // EAGLE ST / YONGE ST
		allStops.put("4289", "4289"); // THE SHOPS ON STEELES STOP # 4289
		allStops.put("5190", "5190"); // LESLIE ST / 16TH AV
		allStops.put("2762", "2762"); // BATHURST ST / ELGIN MILLS RD
		allStops.put("1169", "1169"); // MURRAY DR / KENNEDY ST
		allStops.put("9707", "9707_merged_3513111"); // HWY 7 / ANSLEY GROVE
		allStops.put("2098", "2098"); // BERNARD AV / PRICE ST
		allStops.put("7058", "7058"); // VICTORIA PARK AV / ERNEST AV
		allStops.put("6943", "6943"); // BOX GROVE COLLECTOR RD STOP # 6943
		allStops.put("7059", "7059"); // VICTORIA PARK AV / ERNEST AV
		allStops.put("6176", "6176"); // MAGNA CENTRE STOP # 6176
		allStops.put("1771", "1771"); // NINTH LINE / DONALD COUSENS PKWY
		allStops.put("6174", "6174"); // CHURCH ST / YONGE ST
		allStops.put("6175", "6175"); // TOM TAYLOR PLACE
		allStops.put("6172", "6172"); // MANHATTAN DR / LEXINGTON DR
		allStops.put("1770", "1770"); // NINTH LINE / 16TH AV
		allStops.put("4758", "4758"); // BUR OAK AV / NORTHVALE RD
		allStops.put("4759", "4759"); // BUR OAK AV / GAS LAMP LANE
		allStops.put("6977", "6977"); // MINGAY AV / HAMMERSLY BLVD
		allStops.put("6778", "6778"); // NEW HUNTINGTON RD / HUNTINGTON RD
		allStops.put("6779", "6779"); // HUNTINGTON RD STOP# 6779
		allStops.put("1369", "1369"); // DONCASTER AV STOP # 1369
		allStops.put("4750", "4750"); // WELLINGTON ST / JOHN WEST WAY
		allStops.put("4751", "4751"); // WELLINGTON ST / BAYVIEW AV
		allStops.put("6776", "6776"); // ZENWAY BLVD / NEW HUNTINGTON RD
		allStops.put("6777", "6777"); // NEW HUNTINGTON RD / CONAIR PKWY
		allStops.put("4754", "4754"); // NINTH LINE / VICTORIA WOOD AV
		allStops.put("4755", "4755"); // BUR OAK AV / NINTH LINE
		allStops.put("6772", "6772"); // LONDON RD / ERIN TRAIL
		allStops.put("4757", "4757"); // BUR OAK AV / HIGHBURY CRT
		allStops.put("6705", "6705"); // STOUFFVILLE RD / BAYVIEW AV
		allStops.put("5873", "5873"); // HENDERSON AV / CERSWELL AV
		allStops.put("5876", "5876"); // BUR OAK AV / KENNEDY RD
		allStops.put("5874", "5874"); // HENDERSON AV / CERSWELL AV
		allStops.put("5875", "5875"); // BUR OAK AV /MADISON HEIGHTS
		allStops.put("5879", "5879"); // INDUSTRIAL PKWY / COUSINS DR
		allStops.put("3759", "3759"); // WESTON RD / DAVOS RD
		allStops.put("3758", "3758"); // WESTON RD / VILLA ROYALE AV
		allStops.put("1075", "1075"); // SHIRLEY DR / FUTURA AV
		allStops.put("3751", "3751"); // WESTON RD / HAWKVIEW BLVD
		allStops.put("3750", "3750"); // WESTON RD / RUTHERFORD RD
		allStops.put("3753", "3753"); // WESTON RD / ASHBERRY BLVD
		allStops.put("3752", "3752"); // WESTON RD / COMDEL BLVD
		allStops.put("3755", "3755"); // WESTON RD / HAWSTONE RD
		allStops.put("3754", "3754"); // WESTON RD / VILLA ROYALE AV
		allStops.put("3757", "3757"); // WESTON RD / MARIA ANTONIA RD
		allStops.put("3756", "3756"); // MAJOR MACKENZIE DR / WESTON RD
		allStops.put("2190", "2190"); // ESSEX AV / MAJOR MACKENZIE DR
		allStops.put("2191", "2191"); // NEWKIRK RD / CENTRE ST
		allStops.put("4631", "4631"); // ISLINGTON AV / TUSCAN WOODS TRL
		allStops.put("2193", "2193"); // NEWKIRK RD / CROSBY AV
		allStops.put("2194", "2194"); // NEWKIRK RD / TAYLOR MILLS DR
		allStops.put("4636", "4636"); // MELVILLE AV / EDDINGTON PL
		allStops.put("2196", "2196"); // NEWKIRK RD / BEECHY DR
		allStops.put("4634", "4634"); // ISLINGTON AV / SONOMA BLVD
		allStops.put("2198", "2198"); // ELGIN MILLS RD / YONGE ST
		allStops.put("2199", "2199"); // ELGIN MILLS RD / CREEKVIEW AV
		allStops.put("4639", "4639"); // LORNE AV / QUEEN ST
		allStops.put("4638", "4638"); // ISLINGTON AV / TUSCAN WOODS TRL
		allStops.put("5430", "5430"); // MILLARD ST / HEMLOCK DR
		allStops.put("2200", "2200"); // ELGIN MILLS RD STOP # 2200
		allStops.put("2201", "2201"); // ELGIN MILLS RD / SHAFTSBURY AV
		allStops.put("2202", "2202"); // ELGIN MILLS RD / LARRATT LANE
		allStops.put("2203", "2203"); // ELGIN MILLS RD STOP # 2203
		allStops.put("2204", "2204"); // ELGIN MILLS RD / HIRAM RD
		allStops.put("2205", "2205"); // ELGIN MILLS RD / BATHURST ST
		allStops.put("2206", "2206"); // ELGIN MILLS RD / BATHURST ST
		allStops.put("2207", "2207"); // ELGIN MILLS RD / TANNERY CRT
		allStops.put("2208", "2208"); // ELGIN MILLS RD STOP # 2208
		allStops.put("2209", "2209"); // ELGIN MILLS RD / LARRATT LANE
		allStops.put("9706", "9706_merged_3513110"); // HWY 7 / PINE VALLEY
		allStops.put("2939", "2939"); // JANE ST / CUNNINGHAM DR
		allStops.put("6688", "6688"); // BOX GROVE BYPASS STOP # 6688
		allStops.put("2005", "2005"); // LESLIE ST / GORHAM ST
		allStops.put("3210", "3210"); // HILLMOUNT RD / MARKLAND ST
		allStops.put("6680", "6680"); // KEELE ST / STEELES AV
		allStops.put("6681", "6681"); // LEBOVIC CAMPUS DR / GESHER CRES
		allStops.put("6682", "6682"); // BATHURST ST STOP # 6682
		allStops.put("6683", "6683"); // PUGSLEY ST / CENTRE ST
		allStops.put("6684", "6684"); // LAKELAND CRES / NORTH LAKE RD
		allStops.put("5464", "5464"); // SELWYN RD / PLATINUM AV
		allStops.put("6687", "6687"); // LANGSTAFF RD / ISLINGTON AV
		allStops.put("5004", "5004"); // KENNEDY RD / 16TH AV
		allStops.put("2046", "2046"); // EAGLE ST / GLENWAY CIR
		allStops.put("1350", "1350"); // BUR OAK AV / THE BRIDLE WALK
		allStops.put("2047", "2047"); // EAGLE ST / CROSSLAND GATE
		allStops.put("1446", "1446"); // GLEN SHIELDS AV / BAY HILL DR
		allStops.put("2422", "2422"); // EARL STEWART DR / BRIDGENORTH DR
		allStops.put("2423", "2423"); // MCMASTER AV / HOLLIDGE BLVD
		allStops.put("2424", "2424"); // MCMASTER AV / HOLLIDGE BLVD
		allStops.put("6273", "6273"); // VAUGHAN MILLS TERMINAL PLATFORM 5
		allStops.put("2426", "2426"); // EARL STEWART DR / MCMASTER AV
		allStops.put("2427", "2427"); // MCMASTER AV / HOLLANDVIEW TRL
		allStops.put("4429", "4429"); // ELGIN MILLS RD / YONGE ST
		allStops.put("6578", "6578"); // GATEWAY DR / ST. JOHN'S SDRD
		allStops.put("2042", "2042"); // CROSSLAND GATE / FAIRWAY GDNS
		allStops.put("6356", "6356"); // BLUE WILLOW DR / MATTHEW DR
		allStops.put("4838", "4838"); // KING RD / KINGSHILL RD
		allStops.put("6354", "6354"); // BLUE WILLOW DR / ANSLEY GROVE RD
		allStops.put("6355", "6355"); // BLUE WILLOW DR / ANSLEY GROVE RD
		allStops.put("6352", "6352"); // JANE ST / APPLEWOOD CRES
		allStops.put("2040", "2040"); // ALEX DONER DR / CROSSLAND GATE
		allStops.put("4529", "4529"); // KING RD / FISHER ST
		allStops.put("4528", "4528"); // KEELE ST STOP # 4528
		allStops.put("4527", "4527"); // JEFFERSON FOREST DR / YONGE ST
		allStops.put("3682", "3682"); // STEELES AV / NORFINCH DR
		allStops.put("4525", "4525"); // JEFFERSON FOREST DR / ARDEN VALLEY
		allStops.put("4524", "4524"); // JEFFERSON FOREST DR / SHADOW FALLS
		allStops.put("4523", "4523"); // JEFFERSON FOREST DR / HUNTING RIDGE
		allStops.put("3686", "3686"); // STEELES AV / JANE ST
		allStops.put("6358", "6358"); // BLUE WILLOW DR / FIELDSTONE DR
		allStops.put("6359", "6359"); // BLUE WILLOW DR / MICHELLE DR
		allStops.put("6194", "6194"); // QUEEN ST / HIGHWAY 50
		allStops.put("6195", "6195"); // THE GORE RD / HIGHWAY 7
		allStops.put("6196", "6196"); // THE GORE RD / FOGAL RD
		allStops.put("6197", "6197"); // FOGAL RD / NEXUS AV
		allStops.put("2518", "2518"); // YONGE ST STOP # 2518
		allStops.put("6191", "6191"); // KING RD / PARKER AV
		allStops.put("6192", "6192"); // KING RD / BOND CRES
		allStops.put("6193", "6193"); // STIVER DR / BRISTOL RD
		allStops.put("2515", "2515"); // YONGE ST / SAVAGE RD
		allStops.put("2517", "2517"); // YONGE ST / WILLIAM ROE BLVD
		allStops.put("2510", "2510"); // YONGE ST / MARK ST
		allStops.put("2511", "2511"); // YONGE ST / VALHALLA CRT
		allStops.put("2512", "2512"); // YONGE ST STOP # 2512
		allStops.put("2513", "2513"); // YONGE ST / ST. JOHN'S SDRD
		allStops.put("2734", "2734"); // REDSTONE RD STOP # 2734
		allStops.put("1625", "1625"); // 14TH AV / MCDOWELL GATE
		allStops.put("2737", "2737"); // REDSTONE RD / MONACO CRES
		allStops.put("2730", "2730"); // REDSTONE RD / FRANK ENDEAN RD
		allStops.put("2731", "2731"); // REDSTONE RD / JAGUAR GATE
		allStops.put("5298", "5298"); // FINCHAM AV / NOEL ST
		allStops.put("2733", "2733"); // REDSTONE RD / MONACO CRES
		allStops.put("5296", "5296"); // NINTH LINE STOP # 5296
		allStops.put("5297", "5297"); // NINTH LINE STOP # 5297
		allStops.put("5294", "5294"); // MEDALLION BLVD / GATES RD
		allStops.put("5295", "5295"); // CORONATION ST / FOREST DR
		allStops.put("2738", "2738"); // REDSTONE RD / SHIRLEY DR
		allStops.put("2739", "2739"); // REDSTONE RD / JAGUAR GATE
		allStops.put("5290", "5290"); // REDSTONE RD / TOPOROWSKI AV
		allStops.put("5291", "5291"); // REDSTONE RD / PRINCETON AV
		allStops.put("3531", "3531"); // MORNING STAR DR / MARTIN GROVE RD
		allStops.put("3533", "3533"); // MORNING STAR DR / CABINET CRES
		allStops.put("3535", "3535"); // MORNING STAR DR / NICKLE GATE
		allStops.put("5059", "5059"); // MAIN ST / DEVIATION RD
		allStops.put("3537", "3537"); // MORNING STAR DR / MEDALLION BLVD
		allStops.put("5054", "5054"); // RED MAPLE RD / HIGH TECH RD
		allStops.put("5055", "5055"); // YONGE ST / PATRICIA AV
		allStops.put("5057", "5057"); // MAIN ST / PENN AV
		allStops.put("5050", "5050"); // MAJOR MACKENZIE DR / MARKLAND ST
		allStops.put("5051", "5051"); // MAJOR MACKENZIE DR / RALPH CHALMERS
		allStops.put("5052", "5052"); // MAJOR MACKENZIE DR STOP # 5052
		allStops.put("5053", "5053"); // SILVER LINDEN DR / IRON HORSE AV
		allStops.put("1814", "1814"); // RAYMERVILLE DR / CARPENTER CRT
		allStops.put("1815", "1815"); // RAYMERVILLE DR / QUARRY STONE DR
		allStops.put("1816", "1816"); // RAYMERVILLE DR / SMITHY ST
		allStops.put("1817", "1817"); // RAYMERVILLE DR / STONE MASON DR
		allStops.put("1810", "1810"); // MAIN ST / WELDON RD
		allStops.put("1811", "1811"); // MAIN ST / NINTH LINE
		allStops.put("1812", "1812"); // SNIDER DR / RAYMERVILLE DR
		allStops.put("1813", "1813"); // RAYMERVILLE DR / BYER DR
		allStops.put("7201", "7201"); // HIGHWAY 407 STATION PLATFORM 6
		allStops.put("7200", "7200"); // HIGHWAY 407 STATION PLATFORM 3
		allStops.put("6222", "6222"); // METRO RD NORTH / JOEL AV
		allStops.put("6223", "6223"); // METRO RD NORTH / JOEL AV
		allStops.put("6220", "6220"); // OLD COLONY RD / YONGE ST
		allStops.put("6221", "6221"); // LADY FENYROSE AV / MIDVALE HEIGHTS
		allStops.put("6226", "6226"); // BATHURST ST STOP # 6226
		allStops.put("6224", "6224"); // METRO RD NORTH / ALEXANDER BLVD
		allStops.put("6225", "6225"); // METRO RD NORTH / ALEXANDER BLVD
		allStops.put("6228", "6228"); // WOODBINE AV / MAJOR MACKENZIE DR
		allStops.put("6229", "6229"); // OLD COLONY RD / BAYVIEW AV
		allStops.put("6996", "6996"); // LAWFORD RD / MAJOR MACKENZIE DR
		allStops.put("6997", "6997"); // FOSSIL HILL RD / MARIA ANTONIA RD
		allStops.put("6990", "6990"); // VIA CAMPANILE / BASILICA DR
		allStops.put("2795", "2795"); // HUNTERS POINT DR / TIFFANY GATE
		allStops.put("3408", "3408"); // ISLINGTON AV / HUMBERWOOD GATE
		allStops.put("6991", "6991"); // VIA CAMPANILE / LA ROCCA AV
		allStops.put("9762", "9762"); // WARDEN AV / DENISON ST
		allStops.put("9763", "9763"); // WARDEN AV / DENISON ST
		allStops.put("9760", "9760"); // WARDEN AV / 14TH AV
		allStops.put("9761", "9761"); // WARDEN AV / 14TH AV
		allStops.put("9766", "9766"); // FINCH / SENECA HILL
		allStops.put("9767", "9767"); // DON MILLS STATION
		allStops.put("9764", "9764"); // ESNA PARK / STEELES
		allStops.put("9765", "9765"); // GORDON BAKER RD / MCNICOLL AV
		allStops.put("9768", "9768"); // DON MILLS RD / LEITH HILL RD
		allStops.put("9769", "9769"); // FINCH GO BUS TERMINAL PLATFORM 2
		allStops.put("1445", "1445"); // JOHN BUTTON BLVD / HOODVIEW CRT
		allStops.put("1609", "1609"); // 14TH AV / COPPARD AV
		allStops.put("1608", "1608"); // HOLLINGHAM RD / LOCKRIDGE AV
		allStops.put("4951", "4951"); // FRED VARLEY DR / FONTHILL BLVD
		allStops.put("3229", "3229"); // COCHRANE DR STOP # 3229
		allStops.put("3228", "3228"); // LANARK RD / WOODBINE AV
		allStops.put("1979", "1979"); // YONGE ST / BONSHAW AV
		allStops.put("1978", "1978"); // YONGE ST STOP # 1978
		allStops.put("1601", "1601"); // 14TH AV / MARKHAM RD
		allStops.put("1600", "1600"); // HOLLINGHAM RD / HALSTEAD DR
		allStops.put("1603", "1603"); // 14TH AV / OLD 14TH AV
		allStops.put("1602", "1602"); // HOLLINGHAM RD / NADINE CRES
		allStops.put("1973", "1973"); // YONGE ST / LONDON RD
		allStops.put("1604", "1604"); // HOLLINGHAM RD / CALDERBRIDGE CRES
		allStops.put("1607", "1607"); // 14TH AV / FEATHERSTONE AV
		allStops.put("1970", "1970"); // EAGLE ST / JOHN BOWSER CRES
		allStops.put("4000", "4000"); // CONFEDERATION PKWY / STAFFERN DR
		allStops.put("2163", "2163"); // WELDRICK RD / KERSEY CRES
		allStops.put("2162", "2162"); // WELDRICK RD / SPRINGHEAD GDNS
		allStops.put("5330", "5330"); // WILLOWBROOK RD / BAYVIEW AV
		allStops.put("2617", "2617"); // YONGE ST / SAWMILL VALLEY DR
		allStops.put("2848", "2848"); // BAYVIEW AV / MEGARRY CRT
		allStops.put("2849", "2849"); // BAYVIEW AV STOP # 2849
		allStops.put("2846", "2846"); // WOODRIVER ST / SUBRISCO AV
		allStops.put("2847", "2847"); // SUBRISCO AV / BAYVIEW AV
		allStops.put("2844", "2844"); // WOODRIVER ST / BILBERMAR DR
		allStops.put("2845", "2845"); // WOODRIVER ST / BILBERMAR DR
		allStops.put("2842", "2842"); // ROSE BRANCH DR / COUGAR CRT
		allStops.put("2843", "2843"); // ROSE BRANCH DR / WOODRIVER ST
		allStops.put("2840", "2840"); // ROSE BRANCH DR / ELGIN MILLS RD
		allStops.put("2841", "2841"); // ROSE BRANCH DR / LENO MILLS AV
		allStops.put("5476", "5476"); // KINGSHILL RD / SELLECK DR
		allStops.put("5477", "5477"); // KINGSHILL RD / POULIAS AV
		allStops.put("5474", "5474"); // KINGSHILL RD / ROWLEY ST
		allStops.put("3323", "3323"); // VAUGHAN MILLS TERMINAL PLATFORM 8
		allStops.put("3324", "3324"); // ATKINSON AV / DUNDURN CRES
		allStops.put("5473", "5473"); // KINGSHILL RD / BROCKDALE ST
		allStops.put("3326", "3326"); // ATKINSON AV / DUNDURN CRES
		allStops.put("5471", "5471"); // KINGSHILL RD / SELLECK DR
		allStops.put("3328", "3328"); // ATKINSON AV STOP # 3328
		allStops.put("5478", "5478"); // LARRATT LANE / RED ROCK DR
		allStops.put("5479", "5479"); // BOX GROVE BYPASS / COPPER CREEK DR
		allStops.put("1775", "1775"); // MAIN ST / TENTH LINE
		allStops.put("1777", "1777"); // HEMLOCK DR / GEOFFREY CRES
		allStops.put("5277", "5277"); // HIGHWAY 27 / RUTHERFORD RD
		allStops.put("5270", "5270"); // MARTIN GROVE RD / CABERNET CIR
		allStops.put("5271", "5271"); // STEELES AV LOOP STOP # 5271
		allStops.put("7052", "7052"); // VICTORIA PARK AV / PAWNEE AV
		allStops.put("7053", "7053"); // VICTORIA PARK AV / MORECAMBE GT
		allStops.put("7050", "7050"); // VICTORIA PARK AV / NAVAHO DR
		allStops.put("7051", "7051"); // VICTORIA PARK AV / NAVAHO DR
		allStops.put("7056", "7056"); // VICTORIA PARK AV / FINCH AV
		allStops.put("1778", "1778"); // HEMLOCK DR / ASPEN CRES
		allStops.put("7054", "7054"); // VICTORIA PARK AV / HARE GT
		allStops.put("7055", "7055"); // VICTORIA PARK AV / HARE GATE
		allStops.put("1179", "1179"); // MURRAY DR / SEATON DR
		allStops.put("7222", "7222_merged_3513096"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("1551", "1551"); // TOWN CENTRE BLVD / COX BLVD
		allStops.put("6998", "6998"); // ST URBAIN DR / BRADEN WAY
		allStops.put("1158", "1158"); // VALLEYMEDE DR STOP # 1158
		allStops.put("2999", "2999"); // 16TH AV / ROY RAINEY AV
		allStops.put("1155", "1155"); // ALLAURA BLVD STOP # 1155
		allStops.put("1154", "1154"); // FOOD BASICS STOP # 1154
		allStops.put("1157", "1157"); // ALLAURA BLVD / YONGE ST
		allStops.put("1156", "1156"); // VALLEYMEDE DR / HORIZON CRT
		allStops.put("1151", "1151"); // 15TH SDRD / DUFFERIN ST
		allStops.put("1150", "1150"); // SPADINA RD / 16TH AV
		allStops.put("1153", "1153"); // EDWARD ST / ALLAURA BLVD
		allStops.put("1152", "1152"); // FOOD BASICS STOP # 1152
		allStops.put("6958", "6958"); // NAPA VALLEY AV / ROTA CRES
		allStops.put("7204", "7204_merged_3513076"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("3371", "3371"); // ISLINGTON AV / SUNSET RIDGE
		allStops.put("1555", "1555"); // CHURCH ST / COUNTRY GLEN RD
		allStops.put("5513", "5513"); // PEFFERLAW RD / GRIFFITH AV
		allStops.put("9872", "9872_merged_3513125"); // BATHURST & HIGHWAY 7
		allStops.put("9781", "9781"); // YONGE / WELDRICK
		allStops.put("3602", "3602"); // WESTON RD / HIGHWAY 7
		allStops.put("1554", "1554"); // TOWN CENTRE BLVD / APPLE CREEK BLVD
		allStops.put("2998", "2998"); // 16TH AV / MINGAY AV
		allStops.put("1550", "1550"); // BUTTERNUT LANE STOP # 1550
		allStops.put("1553", "1553"); // TOWN CENTRE BLVD / WALLIS WAY
		allStops.put("1552", "1552"); // M-S HOSPITAL STOP # 1552
		allStops.put("3038", "3038"); // RUTHERFORD RD / ISLINGTON AV
		allStops.put("3039", "3039"); // RUTHERFORD RD STOP # 3039
		allStops.put("1556", "1556"); // APPLE CREEK BLVD STOP # 1556
		allStops.put("3034", "3034"); // RUTHERFORD RD / ST. CLARE BLVD
		allStops.put("3035", "3035"); // RUTHERFORD RD / VIA CAMPANILE
		allStops.put("3036", "3036"); // RUTHERFORD RD / PINE VALLEY DR
		allStops.put("3037", "3037"); // RUTHERFORD RD STOP # 3037
		allStops.put("3030", "3030"); // RUTHERFORD RD / JANE ST
		allStops.put("3031", "3031"); // RUTHERFORD RD / SWEETRIVER BLVD
		allStops.put("3032", "3032"); // RUTHERFORD RD / WESTON RD
		allStops.put("2997", "2997"); // 16TH AV / QUARRY STONE DR
		allStops.put("2990", "2990"); // 16TH AV / MAIN ST MARKHAM
		allStops.put("1558", "1558"); // APPLE CREEK BLVD / CORBY RD
		allStops.put("4265", "4265"); // MAJOR MACKENZIE DR / CEDAR AV
		allStops.put("2992", "2992"); // 16TH AV / MINTLEAF GATE
		allStops.put("2993", "2993"); // 16TH AV / ALFRED PATERSON DR
		allStops.put("4072", "4072_merged_3513020"); // GLENWOOD AND THE QUEENSWAY S
		allStops.put("2994", "2994"); // 16TH AV / NINTH LINE
		allStops.put("1909", "1909"); // KENNEDY RD / AVOCA DR
		allStops.put("2995", "2995"); // 16TH AV / FINCHAM AV
		allStops.put("2805", "2805"); // PEARSON AV / WESTWOOD LANE
		allStops.put("5604", "5604"); // LOCKE ST STOP # 5604
		allStops.put("5607", "5607"); // LESLIE ST / STATE FARM WAY
		allStops.put("5601", "5601"); // LOCKE ST / CREDITSTONE RD
		allStops.put("2996", "2996"); // 16TH AV / HIGHWAY 48
		allStops.put("5603", "5603"); // LOCKE ST STOP # 5603
		allStops.put("5602", "5602"); // LOCKE ST / CREDITSTONE RD
		allStops.put("3033", "3033"); // RUTHERFORD RD / FOSSIL HILL RD
		allStops.put("5609", "5609"); // FIRST COMMERCE DR / STATE FARM WAY
		allStops.put("5135", "5135"); // PARKWAY AV STOP # 5135
		allStops.put("9722", "9722"); // BATHURST / ATKINSON
		allStops.put("1975", "1975"); // YONGE ST STOP # 1975
		allStops.put("5134", "5134"); // PARKWAY AV / SIR GALAHAD PL
		allStops.put("1419", "1419"); // CALVERT RD / WOODBINE AV
		allStops.put("6510", "6510"); // 9TH LINE / HARE FARM GATE
		allStops.put("6511", "6511"); // 9TH LINE / HARE FARM GATE
		allStops.put("6512", "6512"); // RODICK RD / WOODBINE AV
		allStops.put("1903", "1903"); // KENNEDY RD / LEE AV
		allStops.put("2809", "2809"); // EDGAR AV / AVENUE RD
		allStops.put("3048", "3048"); // DAVOS RD / WESTON RD
		allStops.put("3292", "3292"); // BATHURST ST / MAJOR MACKENZIE DR
		allStops.put("1399", "1399"); // BUR OAK AV / GLENBROOK DR
		allStops.put("1398", "1398"); // CLARK AV / DUFFERIN ST
		allStops.put("1397", "1397"); // BUR OAK AV / RIDGECREST RD
		allStops.put("1396", "1396"); // CLARK AV STOP # 1396
		allStops.put("1394", "1394"); // CLARK AV / BROWNRIDGE DR
		allStops.put("1393", "1393"); // BUR OAK AV / STONEBRIDGE DR
		allStops.put("1392", "1392"); // CLARK AV / JUDITH AV
		allStops.put("1391", "1391"); // BUR OAK AV / HILLWOOD ST
		allStops.put("1390", "1390"); // CLARK AV STOP # 1390
		allStops.put("3810", "3810"); // EDGELEY BLVD / COURTLAND AV
		allStops.put("3622", "3622"); // ANSLEY GROVE RD / SNIDER GREEN
		allStops.put("3817", "3817"); // JANE ST / CIDERMILL AV
		allStops.put("3818", "3818"); // JANE ST / PENNSYLVANIA AV
		allStops.put("3819", "3819"); // JANE ST / PORTAGE PKWY
		allStops.put("1420", "1420"); // CLARK AV / YORK HILL BLVD
		allStops.put("6885", "6885"); // CORNELL ROUGE BLVD / HONEY GLEN AV
		allStops.put("4493", "4493"); // MARTIN GROVE RD / SILVERSTONE DR
		allStops.put("9862", "9862_merged_3513006"); // HIGHWAY 7 / KENNEDY RD
		allStops.put("5143", "5143"); // CLEGG RD / WARDEN AV
		allStops.put("4692", "4692"); // YONGE ST / WRIGHT ST
		allStops.put("7268", "7268"); // MURRELL BLVD / APPLEGATE DR
		allStops.put("6424", "6424"); // AURORA GO STATION PLATFORM 2
		allStops.put("6425", "6425"); // INDUSTRIAL PKWY / YONGE ST
		allStops.put("6426", "6426"); // NEWMARKET GO PLATFORM 10
		allStops.put("1680", "1680"); // MAJOR MACKENZIE DR / WOODBINE AV
		allStops.put("6420", "6420"); // DUFFIELD DR / KENNEDY RD
		allStops.put("4298", "4298"); // HIGHWAY 7 / RODICK RD
		allStops.put("6422", "6422"); // MAIN ST / 10TH LINE
		allStops.put("6423", "6423"); // AURORA GO STATION PLATFORM 3
		allStops.put("4295", "4295"); // ASHBERRY BLVD / WESTON RD
		allStops.put("4297", "4297"); // ASHBERRY BLVD / OLAND DR
		allStops.put("1423", "1423"); // RODICK RD / RACHEL CRES
		allStops.put("6428", "6428"); // METRO RD / LENNOX AV
		allStops.put("6429", "6429"); // HIGH ST / DALTON RD
		allStops.put("2972", "2972"); // RIDGECREST RD / MAJOR MACKENZIE DR
		allStops.put("6412", "6412"); // MULOCK DR / COLUMBUS WAY
		allStops.put("9851", "9851"); // DAVIS DR / LESLIE ST
		allStops.put("4695", "4695"); // YONGE ST / HIGH TECH RD
		allStops.put("7267", "7267"); // JANE ST / FREDERICK BANTING ST
		allStops.put("7266", "7266"); // JANE ST / FREDERICK BANTING ST
		allStops.put("2590", "2590"); // DAVIS DR / LUNDY'S LANE
		allStops.put("7261", "7261"); // VICTORIA ST / CHURCH ST
		allStops.put("6169", "6169"); // YONGE ST / HOMEWOOD AV
		allStops.put("6168", "6168"); // WOODBINE AV / ELGIN MILLS RD
		allStops.put("6161", "6161"); // HAZELTON AV / VINE CLIFF BLVD
		allStops.put("1971", "1971"); // UPPER CANADA MALL STOP # 1971
		allStops.put("6163", "6163"); // STONY HILL BLVD / VICTORIA SQUARE B
		allStops.put("6162", "6162"); // HAZELTON AV / STONY HILL BLVD
		allStops.put("6165", "6165"); // WOODBINE AV / PRINCE OF WALES
		allStops.put("6167", "6167"); // WOODBINE AV / LORD MELBORNE ST
		allStops.put("6166", "6166"); // HONDA STOP # 6166
		allStops.put("4749", "4749"); // WELLINGTON ST / WELLS ST
		allStops.put("4748", "4748"); // WELLINGTON ST / MCDONALD DR
		allStops.put("6769", "6769"); // BAYVIEW AV / SUMMIT TRAIL DR
		allStops.put("6768", "6768"); // CALDARI RD / GRANITERIDGE RD
		allStops.put("4743", "4743"); // CONOVER AV / STARR CRES
		allStops.put("4742", "4742"); // HARTWELL WAY / BAYVIEW AV
		allStops.put("4741", "4741"); // BAYVIEW AV / HARTWELL WAY
		allStops.put("4740", "4740"); // GATEWAY DR / KIRKVALLEY CRES
		allStops.put("4747", "4747"); // WELLINGTON ST / HILLDALE RD
		allStops.put("4746", "4746"); // WELLINGTON ST / MCLEOD DR
		allStops.put("4745", "4745"); // WELLINGTON ST / BATHURST ST
		allStops.put("4744", "4744"); // CONOVER AV / BROOKS AV
		allStops.put("6887", "6887"); // KEELE ST STOP # 6887
		allStops.put("7291", "7291"); // HIGHWAY 7 / WHITMORE RD
		allStops.put("5869", "5869"); // WESTON RD / MAJOR MACKENZIE DR
		allStops.put("5868", "5868"); // RUTHERFORD RD / CRIMSON FOREST DR
		allStops.put("4697", "4697"); // HIGHWAY 7 STOP # 4697
		allStops.put("5865", "5865"); // LARKIN AV / SAWYER CRES
		allStops.put("6200", "6200"); // ZENWAY BLVD / NEW HUNTINGTON RD
		allStops.put("5867", "5867"); // RUTHERFORD RD / BLUE GROUSE RD
		allStops.put("5866", "5866"); // RAVENSHOE RD STOP # 5866
		allStops.put("5861", "5861"); // WOODSPRING AV / FORD WILSON BLVD
		allStops.put("5860", "5860"); // METRO RD / GARDEN AV
		allStops.put("5863", "5863"); // ELGIN MILLS RD / PRINCE REGENT ST
		allStops.put("5862", "5862"); // WOODSPRING AV / ART WEST AV
		allStops.put("6950", "6950"); // DAVIS DR / FORHAN AV
		allStops.put("1424", "1424"); // CLARK AV / HILDA AV
		allStops.put("2331", "2331"); // FINCH GO BUS TERMINAL PLATFORM 11
		allStops.put("5350", "5350"); // PEARSON AV STOP # 5350
		allStops.put("6796", "6796"); // METRO RD / CHARLES CRES
		allStops.put("2183", "2183"); // WELDRICK RD STOP # 2183
		allStops.put("2333", "2333"); // FINCH GO BUS TERMINAL PLATFORM 14
		allStops.put("2187", "2187"); // ESSEX AV / PALISER CRES
		allStops.put("2186", "2186"); // WELDRICK RD / ESSEX AV
		allStops.put("2185", "2185"); // WELDRICK RD STOP # 2185
		allStops.put("2184", "2184"); // WELDRICK RD / CHURCH ST
		allStops.put("2189", "2189"); // ESSEX AV / ELMWOOD AV
		allStops.put("2188", "2188"); // ESSEX AV / PALMER AV
		allStops.put("4602", "4602"); // TIERRA AV / TREASURE RD
		allStops.put("4603", "4603"); // SILVERWOOD AV / YORKLAND ST
		allStops.put("4600", "4600"); // MAPLE SUGAR LANE / THORNHILL WOODS
		allStops.put("2335", "2335"); // FINCH GO BUS TERMINAL PLATFORM 16
		allStops.put("2213", "2213"); // INDUSTRIAL PKWY / ENGLEHARD DR
		allStops.put("2212", "2212"); // INDUSTRIAL PKWY STOP # 2212
		allStops.put("2211", "2211"); // INDUSTRIAL PKWY / MARY ST
		allStops.put("2210", "2210"); // ELGIN MILLS RD / REGENT ST
		allStops.put("2216", "2216"); // INDUSTRIAL PKWY / VANDORF SDRD
		allStops.put("2215", "2215"); // INDUSTRIAL PKWY STOP # 2215
		allStops.put("2214", "2214"); // INDUSTRIAL PKWY STOP # 2214
		allStops.put("2680", "2680"); // ROLLINGHILL RD / SKYWOOD DR
		allStops.put("2219", "2219"); // BAYVIEW AV / SPRING FARM RD
		allStops.put("6453", "6453"); // METRO RD / RAINES ST
		allStops.put("6209", "6209"); // OLD COLONY RD / CAROUSEL CRES
		allStops.put("2338", "2338"); // YONGE ST / CUMMER AV
		allStops.put("6699", "6699"); // HIGHWAY 50 / RUTHERFORD RD
		allStops.put("6698", "6698"); // HOLLANDVIEW TRL / BRIDGENORTH DR
		allStops.put("2339", "2339"); // YONGE ST / OTONABEE AV
		allStops.put("6693", "6693"); // ILAN RAMON BLVD / GEORGE KIRBY ST
		allStops.put("6692", "6692"); // BOX GROVE BYPASS / 14TH AV
		allStops.put("6691", "6691"); // THE BRIDLE WALK / MADISON HEIGHTS
		allStops.put("6690", "6690"); // THE BRIDLE WALK / HOLST AV
		allStops.put("6697", "6697"); // JANE ST STOP # 6697
		allStops.put("6696", "6696"); // JANE ST / RUTHERFORD RD
		allStops.put("6695", "6695"); // ILAN RAMON BLVD / RUTHERFORD RD
		allStops.put("6694", "6694"); // ILAN RAMON BLVD / MARC SANTI BLVD
		allStops.put("1426", "1426"); // CLARK AV / CHARLES ST
		allStops.put("2439", "2439"); // MULOCK DR / YONGE ST
		allStops.put("9856", "9856"); // DAVIS DR / HIGHWAY 404
		allStops.put("2195", "2195"); // NEWKIRK RD STOP # 2195
		allStops.put("2432", "2432"); // SANDFORD ST / SAVAGE RD
		allStops.put("2431", "2431"); // SANDFORD ST / STELLICK AV
		allStops.put("6900", "6900"); // POETRY DR / FLOURISH ST
		allStops.put("9852", "9852"); // DAVIS DR / LESLIE ST
		allStops.put("2435", "2435"); // SAWMILL VALLEY DR / COLUMBUS WAY
		allStops.put("2434", "2434"); // SAWMILL VALLEY DR / JOE PERSECHINI
		allStops.put("6459", "6459"); // DALTON RD STOP # 6459
		allStops.put("3761", "3761"); // WESTON RD / RUTHERFORD RD
		allStops.put("4203", "4203"); // DON MILLS RD / CLIFFWOOD RD
		allStops.put("1161", "1161"); // MURRAY DR / CORBETT CRES
		allStops.put("6953", "6953"); // NAPA VALLEY AV / FOREST FOUNTAIN DR
		allStops.put("5764", "5764"); // ELSON ST / EASTVALE DR
		allStops.put("6341", "6341"); // MAJOR MACKENZIE DR / VIA ROMANO BLVD
		allStops.put("6340", "6340"); // GAMBLE RD / COLESBROOK RD
		allStops.put("4518", "4518"); // NORTH LAKE RD / LAKELAND CRES
		allStops.put("4519", "4519"); // JEFFERSON FOREST DR / ARDEN VALLEY
		allStops.put("6345", "6345"); // BATHURST ST / NER ISRAEL DR
		allStops.put("6344", "6344"); // MINTHORN CT / COMMERCE VALLEY DR
		allStops.put("6347", "6347"); // JANE ST / CIDERMILL AV
		allStops.put("6346", "6346"); // JANE ST / MACINTOSH BLVD
		allStops.put("4512", "4512"); // WORTHINGTON AV / YONGE ST
		allStops.put("6348", "6348"); // JANE ST / PIPPIN RD
		allStops.put("4510", "4510"); // WORTHINGTON AV / ASHFIELD DR
		allStops.put("4511", "4511"); // WORTHINGTON AV / YONGE ST
		allStops.put("4516", "4516"); // WOOD RIM DR / ALOE AV
		allStops.put("4517", "4517"); // WOOD RIM DR / NORTH LAKE RD
		allStops.put("4514", "4514"); // WOOD RIM DR / ALOE AV
		allStops.put("4515", "4515"); // WOOD RIM DR / WORTHINGTON AV
		allStops.put("6187", "6187"); // KING RD / BOND CRES
		allStops.put("6186", "6186"); // EAGLE ROCK WAY / GO PARKING LOT
		allStops.put("6185", "6185"); // MAJOR MACKENZIE DR / ILAN RAMON BLV
		allStops.put("6183", "6183"); // VICTORIA ST / WELLINGTION ST W
		allStops.put("6182", "6182"); // MINGAY AV / CASTLEMORE AV
		allStops.put("1162", "1162"); // VALLEYMEDE DR / EMMANUEL DR
		allStops.put("2508", "2508"); // YONGE ST / GILBERT DR
		allStops.put("2507", "2507"); // YONGE ST STOP # 2507
		allStops.put("2505", "2505"); // YONGE ST / COON'S RD
		allStops.put("2504", "2504"); // YONGE ST / WORTHINGTON AV
		allStops.put("2502", "2502"); // YONGE ST / ELM GROVE AV
		allStops.put("2501", "2501"); // YONGE ST / ASHFIELD DR
		allStops.put("6188", "6188"); // KING RD / PARKER AV
		allStops.put("2727", "2727"); // NEAL DR / CROSBY AV
		allStops.put("5288", "5288"); // MAJOR MACKENZIE DR / THE BRIDLE WAL
		allStops.put("2725", "2725"); // NEAL DR / MCCONVEY DR
		allStops.put("2724", "2724"); // NEAL DR / MCCONVEY DR
		allStops.put("2723", "2723"); // NEAL DR / TAYLOR MILLS DR
		allStops.put("2722", "2722"); // NEAL DR / ELGIN MILLS RD
		allStops.put("2721", "2721"); // NEAL DR / TAYLOR MILLS DR
		allStops.put("2720", "2720"); // NEAL DR / MCCONVEY DR
		allStops.put("5281", "5281"); // WESTON RD STOP # 5281
		allStops.put("5280", "5280"); // ST. ROBERT CATHOLIC H.S. STOP # 528
		allStops.put("5283", "5283"); // LEGACY DR / LADY FERN DR
		allStops.put("5282", "5282"); // WESTON RD STOP # 5282
		allStops.put("5285", "5285"); // PARTICIPATION HOUSE STOP # 5285
		allStops.put("5284", "5284"); // LEGACY DR / LADY FERN DR
		allStops.put("5287", "5287"); // MAJOR MACKENZIE DR / THE BRIDLE WAL
		allStops.put("2728", "2728"); // CROSBY AV / BAYVIEW AV
		allStops.put("5371", "5371"); // NATANYA BLVD / CHURCH ST
		allStops.put("5485", "5485"); // BOX GROVE BYP / RIZAL AV
		allStops.put("5049", "5049"); // MAJOR MACKENZIE DR / LESLIE ST
		allStops.put("5048", "5048"); // MAJOR MACKENZIE DR / FORESTWOOD ST
		allStops.put("5047", "5047"); // MAJOR MACKENZIE DR / BOAKE TRL
		allStops.put("5046", "5046"); // MAJOR MACKENZIE DR / SPADINA RD
		allStops.put("5045", "5045"); // MAJOR MACKENZIE DR / OLD MARKHAM RD
		allStops.put("5044", "5044"); // ISLINGTON AV STOP # 5044
		allStops.put("7239", "7239"); // PORTAGE PWKY / EDGELEY BLVD
		allStops.put("3042", "3042"); // RUTHERFORD RD / VELMAR DR
		allStops.put("3684", "3684"); // STEELES AV / PETER KAISER GATE
		allStops.put("9818", "9818_merged_3513115"); // EAGLE ST / YONGE ST
		allStops.put("1809", "1809"); // MAIN ST / MOSTAR ST
		allStops.put("1808", "1808"); // MAIN ST / SANDIFORD DR
		allStops.put("6717", "6717"); // MILLARD ST / GLAD PARK AV
		allStops.put("6239", "6239"); // CONFEDERATION PKWY / CAMDEN DR
		allStops.put("6238", "6238"); // CONFEDERATION PKWY / TEN OAKS BLVD
		allStops.put("4990", "4990"); // KIPLING AV / WOODBRIDGE AV
		allStops.put("6235", "6235"); // FINCH GO BUS TERMINAL PLATFORM 3
		allStops.put("6234", "6234"); // REEVES WAY BLVD / NORTHWAY AV
		allStops.put("6237", "6237"); // CENTRE ST / WADE GATE
		allStops.put("6236", "6236"); // TESTON RD / VIA ROMANO BLVD
		allStops.put("6231", "6231"); // METRO RD N / CIVIC CENTRE RD
		allStops.put("6230", "6230"); // MCNAUGHTON RD / MAJOR MACKENZIE DR
		allStops.put("6233", "6233"); // ROUGE BANK DR / BOX GROVE BYPASS
		allStops.put("6232", "6232"); // METRO RD N / CIVIC CENTRE RD
		allStops.put("6599", "6599"); // BETTY ROMAN BLVD / PRINCE REGENT ST
		allStops.put("6957", "6957"); // NAPA VALLEY AV / SONOMA BLVD
		allStops.put("6871", "6871_merged_3513100"); // LAKERIDGE AND HIGHWAY 48
		allStops.put("9779", "9779"); // YONGE / 16TH-CARRVILLE
		allStops.put("9778", "9778"); // YONGE / BANTRY-SCOTT
		allStops.put("9775", "9775"); // YONGE / ROYAL ORCHARD
		allStops.put("9774", "9774"); // YONGE / CENTRE
		allStops.put("9777", "9777"); // YONGE / BANTRY-SCOTT
		allStops.put("9776", "9776"); // YONGE / ROYAL ORCHARD
		allStops.put("9771", "9771"); // YONGE / CLARK
		allStops.put("9770", "9770"); // YONGE / STEELES
		allStops.put("9773", "9773"); // YONGE / CENTRE
		allStops.put("9772", "9772"); // YONGE / CLARK
		allStops.put("1256", "1256"); // MIDDLEFIELD RD STOP # 1256
		allStops.put("1948", "1948"); // LESLIE ST STOP # 1948
		allStops.put("1942", "1942"); // LESLIE ST / SUMMERDALE DR
		allStops.put("1940", "1940"); // LESLIE ST / LYNDHURST DR
		allStops.put("1941", "1941"); // LESLIE ST / 14TH LANE
		allStops.put("1946", "1946"); // LESLIE ST / EAST WILMOT ST
		allStops.put("1947", "1947"); // LESLIE ST / EAST BEAVER CREEK RD
		allStops.put("1945", "1945"); // LESLIE ST / EAST PEARCE ST
		allStops.put("1252", "1252"); // ELSON ST / MARY PEARSON DR
		allStops.put("1163", "1163"); // MURRAY DR / GLASS DR
		allStops.put("4268", "4268"); // MAJOR MACKENZIE DR / OLD 17TH AV
		allStops.put("2859", "2859"); // BAYVIEW AV STOP # 2859
		allStops.put("2858", "2858"); // TAYLOR MILLS DR / MARYBAY CRES
		allStops.put("1250", "1250"); // ELSON ST / IRENEMOUNT CRES
		allStops.put("3206", "3206"); // HILLMOUNT RD / MARKLAND ST
		allStops.put("2851", "2851"); // BAYVIEW AV / JUDLEA CRT
		allStops.put("2850", "2850"); // BAYVIEW AV / ELGIN MILLS RD
		allStops.put("2853", "2853"); // TAYLOR MILLS DR / NEAL DR
		allStops.put("2852", "2852"); // TAYLOR MILLS DR / ALVERNA RD
		allStops.put("2855", "2855"); // TAYLOR MILLS DR / PERKINS RD
		allStops.put("2854", "2854"); // TAYLOR MILLS RD / TAYLOR MILLS RD
		allStops.put("2857", "2857"); // TAYLOR MILLS DR / NEAL DR
		allStops.put("2856", "2856"); // TAYLOR MILLS DR / KERSWELL DR
		allStops.put("1490", "1490"); // 14TH AV / BRIMLEY RD
		allStops.put("1491", "1491"); // CARLTON RD / MAIN ST UNIONVILLE
		allStops.put("1492", "1492"); // 14TH AV / CALDBECK AV
		allStops.put("7046", "7046"); // VICTORIA PARK AV / TEMPO AV
		allStops.put("1494", "1494"); // 14TH AV / TILLIE SQ
		allStops.put("7040", "7040"); // VICTORIA PARK AV STOP #7040
		allStops.put("5467", "5467"); // TOWER HILL RD / SKYWOOD DR
		allStops.put("5466", "5466"); // TOWER HILL RD / SELWYN RD
		allStops.put("5469", "5469"); // BATHURST ST / KING VAUGHAN RD
		allStops.put("1995", "1995"); // MULOCK DR / TAPESTRY LANE
		allStops.put("3338", "3338"); // ATKINSON AV / SPRING GATE BLVD
		allStops.put("7049", "7049"); // VICTORIA PARK AV / MCNICOLL AV
		allStops.put("7048", "7048"); // VICTORIA PARK AV / MCNICOLL AV
		allStops.put("5187", "5187"); // HIGHWAY 27 / ROYALPARK WAY
		allStops.put("5267", "5267"); // MARTIN GROVE RD / GARFELLA DR
		allStops.put("1701", "1701"); // MAJOR MACKENZIE DR / NEWKIRK RD
		allStops.put("5265", "5265"); // MARTIN GROVE RD / FINCH AV
		allStops.put("1703", "1703"); // MAJOR MACKENZIE DR / CEDAR AV
		allStops.put("1704", "1704"); // CARRVILLE RD / PLAISANCE RD
		allStops.put("1705", "1705"); // MAJOR MACKENZIE DR / PUGSLEY AV
		allStops.put("1706", "1706"); // SENECA COLLEGE STOP # 1706
		allStops.put("1707", "1707"); // MAJOR MACKENZIE DR / BAKER AV
		allStops.put("1709", "1709"); // MAJOR MACKENZIE DR / ARNOLD CRES
		allStops.put("1168", "1168"); // VALLEYMEDE DR / QUEENS COLLEGE DR
		allStops.put("1996", "1996"); // MULOCK DR / FERNBANK RD
		allStops.put("4572", "4572"); // HILDA AV / CRESTWOOD RD
		allStops.put("5269", "5269"); // MARTIN GROVE RD / GIHON SPRING DR
		allStops.put("5268", "5268"); // MARTIN GROVE RD / SILVERSTONE DR
		allStops.put("4573", "4573"); // HILDA AV / YORK HILL BLVD
		allStops.put("4574", "4574"); // HILDA AV / YORK HILL BLVD
		allStops.put("7057", "7057"); // VICTORIA PARK AV / FINCH AV
		allStops.put("1129", "1129"); // HENDERSON DR / POPLAR CRES
		allStops.put("5189", "5189"); // JOHN ST / NOLAN CRT
		allStops.put("4576", "4576"); // HILDA AV / STEELES AV
		allStops.put("6989", "6989"); // ST FRANCIS AV / AMPEZZO AV
		allStops.put("6988", "6988"); // ST FRANCIS AV / ST CLARE BLVD
		allStops.put("1120", "1120"); // FARMSTEAD RD / RUSHINGBROOK DR
		allStops.put("1121", "1121"); // DENISON ST / CARTMEL DR
		allStops.put("6985", "6985"); // DAVIS DR / FORHAN AV
		allStops.put("1123", "1123"); // DENISON ST STOP # 1123
		allStops.put("1124", "1124"); // FARMSTEAD RD / BAYVIEW AV
		allStops.put("1125", "1125"); // DENISON ST / HILLCROFT DR
		allStops.put("1126", "1126"); // CENTRE ST / BEAVERTON RD
		allStops.put("1127", "1127"); // DENISON ST / TOWNLEY AV
		allStops.put("4578", "4578"); // ATKINSON AV / SPRING GATE BLVD
		allStops.put("9807", "9807_merged_3513118"); // YONGE / MULOCK
		allStops.put("3961", "3961"); // KEELE ST / MASTERS AV
		allStops.put("9785", "9785"); // YONGE / CROSBY
		allStops.put("3169", "3169"); // WARDEN AV / ENTERPRISE BLVD
		allStops.put("4072", "4072_merged_3513009"); // GLENWOODS AV STOP # 4072
		allStops.put("2989", "2989"); // 16TH AV / QUARRY STONE DR
		allStops.put("2988", "2988"); // 16TH AV / STONE MASON DR
		allStops.put("2833", "2833"); // SUBRISCO AV / WOODRIVER ST
		allStops.put("3373", "3373"); // ISLINGTON AV / RUTHERFORD RD
		allStops.put("3029", "3029"); // RUTHERFORD RD / MELVILLE AV
		allStops.put("3028", "3028"); // RUTHERFORD RD / ROTATIONAL DR
		allStops.put("3027", "3027"); // RUTHERFORD RD / GREENOCK DR
		allStops.put("2982", "2982"); // 16TH AV / LONGWATER CHASE
		allStops.put("2981", "2981"); // 16TH AV / KENNEDY RD
		allStops.put("2980", "2980"); // 16TH AV / SWAN LAKE BLVD
		allStops.put("2987", "2987"); // 16TH AV / CAIRNS DR
		allStops.put("2986", "2986"); // 16TH AV / MCCOWAN RD
		allStops.put("2985", "2985"); // 16TH AV / SARATOGA RD
		allStops.put("2984", "2984"); // 16TH AV / SHORTHILL DR
		allStops.put("1018", "1018"); // COMMERCE VALLEY DR / SOUTH PARK RD
		allStops.put("4685", "4685"); // YONGE ST / GILBERT DR
		allStops.put("1014", "1014"); // COMMERCE VALLEY DR STOP # 1014
		allStops.put("1016", "1016"); // COMMERCE VALLEY DR / LESLIE ST
		allStops.put("1010", "1010"); // RED MAPLE RD / ONEIDA CRES
		allStops.put("1011", "1011"); // COMMERCE VALLEY DR STOP # 1011
		allStops.put("1012", "1012"); // RED MAPLE RD / HIGH TECH RD
		allStops.put("1013", "1013"); // COMMERCE VALLEY DR STOP # 1013
		allStops.put("1234", "1234"); // DENISON ST / MIDDLEFIELD RD
		allStops.put("4909", "4909"); // LESLIE ST / ELGIN ST
		allStops.put("1236", "1236"); // DENISON ST / COXWORTH AV
		allStops.put("1230", "1230"); // DENISON ST / COPPARD AV
		allStops.put("4198", "4198"); // BERNARD TERMINAL PLATFORM 6
		allStops.put("4199", "4199"); // BERNARD AV / YONGE ST
		allStops.put("4197", "4197"); // BERNARD TERMINAL PLATFORM 5
		allStops.put("4195", "4195"); // BERNARD TERMINAL PLATFORM 3
		allStops.put("1238", "1238"); // DENISON ST STOP # 1238
		allStops.put("4190", "4190"); // NEWMARKET GO TERMINAL PLATFORM 8
		allStops.put("5670", "5670"); // JEFFERSON SDRD / MILOS RD
		allStops.put("5671", "5671"); // JEFFERSON SDRD / LOURAKIS ST
		allStops.put("5672", "5672"); // JEFFERSON SDRD / BATHURST ST
		allStops.put("5673", "5673"); // TOWER HILL RD / ALHART ST
		allStops.put("4358", "4358"); // MAIN ST UNIONVILLE / HIGHWAY 7
		allStops.put("5675", "5675"); // GAMBLE RD / COLESBROOK RD
		allStops.put("5676", "5676"); // GAMBLE RD / HARVEST CRT
		allStops.put("5677", "5677"); // GAMBLE RD / ROTHBURY RD
		allStops.put("5678", "5678"); // NINTH LINE / RUPERT AV
		allStops.put("5679", "5679"); // ELM RD / GLAD PARK AV
		allStops.put("4356", "4356"); // MAIN ST UNIONVILLE / FRED VARLEY DR
		allStops.put("4357", "4357"); // MAIN ST UNIONVILLE / STATION LANE
		allStops.put("4350", "4350"); // MCCALLUM DR / BATHURST ST
		allStops.put("4351", "4351"); // REGENT ST / THEOBALDS CIR
		allStops.put("6509", "6509"); // COON'S RD / YONGE ST
		allStops.put("6508", "6508"); // COON'S RD / CYNTHIA CRES
		allStops.put("4679", "4679"); // YONGE ST STOP # 4679
		allStops.put("6503", "6503"); // BAYVIEW PARK LANE / SUNSET BEACH BL
		allStops.put("6502", "6502"); // BAYVIEW AV / BAYVIEW PARK LANE
		allStops.put("6501", "6501"); // OAK RIDGES C.C. STOP # 6501
		allStops.put("6001", "6001"); // BAYVIEW AV / 19TH AV
		allStops.put("6507", "6507"); // COON'S RD / CYNTHIA CRES
		allStops.put("6506", "6506"); // BLOOMFIELD TRL / COON'S RD
		allStops.put("6505", "6505"); // BLOOMIFIELD TRAIL / FERN VALLEY CRE
		allStops.put("6504", "6504"); // BLOOMFIELD TRL / BLOOMINGTON RD
		allStops.put("4686", "4686"); // YONGE ST / RIDGE RD
		allStops.put("2487", "2487"); // YONGE ST / INDUSTRIAL RD
		allStops.put("2485", "2485"); // YONGE ST / LEVENDALE RD
		allStops.put("3809", "3809"); // EDGELEY BLVD / LANGSTAFF RD
		allStops.put("3808", "3808"); // EDGELEY BLVD / APPLEWOOD CRES
		allStops.put("3805", "3805"); // EDGELEY BLVD STOP # 3805
		allStops.put("3804", "3804"); // JANE ST / HIGHWAY 7
		allStops.put("3807", "3807"); // EDGELEY BLVD / CIDERMILL AV
		allStops.put("3806", "3806"); // EDGELEY BLVD / PENNSYLVANIA AV
		allStops.put("3801", "3801"); // JANE ST STOP # 3801
		allStops.put("3800", "3800"); // INTERCHANGE WAY / EXCHANGE AV
		allStops.put("3803", "3803"); // JANE ST / DOUGHTON RD
		allStops.put("4904", "4904"); // YMCA BLVD / KENNEDY RD
		allStops.put("9862", "9862"); // HIGHWAY 7 / KENNEDY RD
		allStops.put("4804", "4804"); // MELVILLE AV / HUDSON DR
		allStops.put("1630", "1630"); // WOODBINE AV / MILLBROOK GATE
		allStops.put("4907", "4907"); // YMCA BLVD / RIVIS RD
		allStops.put("3312", "3312"); // BATHURST ST / CLARK AV
		allStops.put("4906", "4906"); // YMCA BLVD / RIVIS RD
		allStops.put("4074", "4074"); // THE QUEENSWAY / BISCAYNE BLVD
		allStops.put("6437", "6437"); // METRO RD / MONTSELL AV
		allStops.put("6436", "6436"); // METRO RD / MONTSELL AV
		allStops.put("6435", "6435"); // LESLIE ST STOP # 6435
		allStops.put("6434", "6434"); // LESLIE ST STOP # 6434
		allStops.put("5708", "5708"); // WOODSPRING AV / MEMORIAL GARDENS WA
		allStops.put("5709", "5709"); // WOODSPRING AV / RAY SNOW BLVD
		allStops.put("6430", "6430"); // HIGH ST / DALTON RD
		allStops.put("5705", "5705"); // WOODSPRING AV / BONSHAW AV
		allStops.put("5706", "5706"); // WOODSPRING AV / GILPIN DR
		allStops.put("5707", "5707"); // WOODSPRING AV / WILLIAM BOOTH AV
		allStops.put("5700", "5700"); // WOODSPRING AV / ASPENWOOD DR
		allStops.put("5701", "5701"); // ASPENWOOD DR / MARBLE PL
		allStops.put("6439", "6439"); // METRO RD / HUNTLEY DR
		allStops.put("5703", "5703"); // ASPENWOOD DR / COACHWHIP TRL
		allStops.put("9786", "9786"); // YONGE / CROSBY
		allStops.put("7253", "7253"); // BATHURST ST / HIGHWAY 7
		allStops.put("5434", "5434"); // TENTH LINE / AINTREE DR
		allStops.put("1437", "1437"); // RODICK RD / JOHN BUTTON BLVD
		allStops.put("5009", "5009_merged_3513073"); // SHOPPERS DRUG MART STOP # 5009
		allStops.put("2249", "2249"); // BAYVIEW AV / MULOCK DR
		allStops.put("3370", "3370"); // NEW WESTMINSTER DR / CLARK AV
		allStops.put("1960", "1960"); // BATHURST ST / LEBOVIC CAMPUS DR
		allStops.put("5008", "5008_merged_3513074"); // 404 TOWN CENTRE STOP # 5008
		allStops.put("9855", "9855"); // DAVIS DR / MAIN ST
		allStops.put("6326", "6326"); // WOODBINE AV / DUNNVILLE RD
		allStops.put("1421", "1421"); // WOODBINE AV / RODICK RD
		allStops.put("4772", "4772"); // VELLORE WOODS BLVD / SHADETREE CRES
		allStops.put("4773", "4773"); // VELLORE WOODS BLVD / ASHBERRY BLVD
		allStops.put("4299", "4299"); // HIGHWAY 7 / CHALMERS RD
		allStops.put("4778", "4778"); // FOSSIL HILL RD / ST. URBAIN DR
		allStops.put("4779", "4779"); // FOSSIL HILL RD / DAVOS RD
		allStops.put("3063", "3063"); // RUTHERFORD RD / THORNHILL WOODS DR
		allStops.put("6758", "6758"); // KEELE ST / MALOY ST
		allStops.put("4177", "4177"); // HIGHWAY 7 / SWANSEA RD
		allStops.put("4171", "4171"); // UNIONVILLE GO STATION PLATFORM 2
		allStops.put("4172", "4172"); // UNIONVILLE GO STATION PLATFORM 3
		allStops.put("3062", "3062"); // RUTHERFORD RD / KEELE ST
		allStops.put("6752", "6752"); // CLEGG RD STOP # 6752
		allStops.put("6753", "6753"); // CLEGG RD / SOUTH TOWN CENTRE BLVD
		allStops.put("6751", "6751"); // CLEGG RD STOP # 6751
		allStops.put("4178", "4178"); // HIGHWAY 7 STOP # 4178
		allStops.put("4179", "4179"); // HIGHWAY 7 / CONSERVATION AV
		allStops.put("6754", "6754"); // CLEGG RD / SOUTH TOWN CENTRE BLVD
		allStops.put("6755", "6755"); // CENTRE ST / ATKINSON AV
		allStops.put("5818", "5818"); // JOHN DEISMAN BLVD / TIERRA AV
		allStops.put("5819", "5819"); // MAST RD / QUEEN ISABELLA CRES
		allStops.put("7176", "7176"); // DUFFERIN ST / SUPERTEST RD
		allStops.put("4311", "4311_merged_3513120"); // MAJOR MACKENZIE DR / CITYVIEW BLVD
		allStops.put("5810", "5810"); // DRUMMOND DR / LONGWOOD DR
		allStops.put("5811", "5811"); // DRUMMOND DR / ST. JOAN OF ARC AV
		allStops.put("5812", "5812"); // DRUMMOND DR / KEELE ST
		allStops.put("5813", "5813"); // GRAND VALLEY BLVD / GIANMARCO WAY
		allStops.put("5814", "5814"); // GRAND VALLEY BLVD / DISCOVERY TRL
		allStops.put("5815", "5815"); // GRAND VALLEY BLVD / TREASURE RD
		allStops.put("5816", "5816"); // MAST RD / DEL FRANCESCO WAY
		allStops.put("7170", "7170"); // DUFFERIN ST / STEELES AV
		allStops.put("4888", "4888"); // WILLOWBROOK RD / RAVENCLIFFE RD
		allStops.put("4296", "4296"); // HIGHWAY 7 / MAIN ST UNIONVILLE
		allStops.put("2949", "2949"); // MAJOR MACKENZIE DR STOP # 2949
		allStops.put("1962", "1962"); // BATHURST ST / RUTHERFORD RD
		allStops.put("2948", "2948"); // MAJOR MACKENZIE DR / KEELE ST
		allStops.put("4619", "4619"); // JANE ST / MAJOR MACKENZIE DR
		allStops.put("4618", "4618"); // WELLINGTON ST / TIMPSON DR
		allStops.put("2946", "2946"); // MAJOR MACKENZIE DR / NETHERFORD RD
		allStops.put("4611", "4611"); // MELVILLE AV / NORWOOD AV
		allStops.put("4610", "4610"); // TIERRA AV / TREASURE RD
		allStops.put("3500", "3500"); // WOODBRIDGE AV / WALLACE ST
		allStops.put("4615", "4615"); // INTERCHANGE WAY / EXCHANGE AV
		allStops.put("4614", "4614"); // FOSSIL HILL RD / MARIA ANTONIA RD
		allStops.put("4617", "4617"); // THORNHILL WOODS DR / AUTUMN HILL BL
		allStops.put("5060", "5060"); // MAIN ST / LONDON RD
		allStops.put("1098", "1098"); // DENISON ST / WARDEN AV
		allStops.put("5148", "5148"); // BATHURST ST / KINGSHILL RD
		allStops.put("2228", "2228"); // PROSPECT ST / PEARSON ST
		allStops.put("2226", "2226"); // BAYVIEW AV / BONDI AV
		allStops.put("2227", "2227"); // BAYVIEW AV / COLLEGE ST
		allStops.put("2224", "2224"); // BAYVIEW AV / NEWPARK BLVD
		allStops.put("2225", "2225"); // BAYVIEW AV / MULOCK DR
		allStops.put("2222", "2222"); // BAYVIEW AV / BROOKER RDGE
		allStops.put("2223", "2223"); // BAYVIEW AV / STONEHAVEN AV
		allStops.put("2220", "2220"); // BAYVIEW AV STOP # 2220
		allStops.put("2221", "2221"); // BAYVIEW AV / ST. JOHN'S SDRD
		allStops.put("5924", "5924"); // DONALD COUSENS PKWY / MAJOR MACKENZ
		allStops.put("2705", "2705"); // MILL ST / LEISURE LANE
		allStops.put("5926", "5926"); // MORNING DOVE DR / CORNELL ROUGE BLV
		allStops.put("5927", "5927"); // CORNELL ROUGE BLVD / WHITE'S HILL A
		allStops.put("5920", "5920"); // 16TH AV / CORNELL ROUGE BLVD
		allStops.put("5921", "5921"); // DONALD COUSENS PKWY / COUNTRY GLEN
		allStops.put("5922", "5922"); // DONALD COUSENS PKWY / NINTH LINE
		allStops.put("5923", "5923"); // DONALD COUSENS PKWY / CASTLEMORE AV
		allStops.put("5928", "5928"); // WHITE'S HILL AV / JOHN ALLAN CAMERO
		allStops.put("2707", "2707"); // MILL ST / BRIDGEPORT ST
		allStops.put("1099", "1099"); // ELGIN MILLS RD / SHIRLEY DR
		allStops.put("5458", "5458"); // TOWER HILL RD / GOLDLIST DR
		allStops.put("4883", "4883"); // MOUNT ALBERT RD / PARNHAM CRES
		allStops.put("4311", "4311_merged_3513092"); // MAJOR MACKENZIE DR / CITYVIEW BLVD
		allStops.put("5459", "5459"); // TOWER HILL RD / SELWYN RD
		allStops.put("2701", "2701"); // BATHURST ST / QUEEN FILOMENA AV
		allStops.put("1052", "1052"); // VALLEYMEDE DR / MEADOWCLIFFE AV
		allStops.put("5068", "5068"); // GRIST MILL RD / STEGMAN RD
		allStops.put("4767", "4767"); // BUR OAK AV / CORNELL PARK AV
		allStops.put("1053", "1053"); // JOHN ST / PORTERFIELD CRES
		allStops.put("4501", "4501"); // BRANDON GATE DR / JANE ST
		allStops.put("4500", "4500"); // MCNAUGHTON RD / CRANSTON PARK AV
		allStops.put("1054", "1054"); // VALLEYMEDE DR / 16TH AV
		allStops.put("2797", "2797"); // HUNTERS POINT DR / LANGSTAFF RD
		allStops.put("1055", "1055"); // JOHN ST STOP # 1055
		allStops.put("2088", "2088"); // EAGLE ST / GLENWAY CIR
		allStops.put("2089", "2089"); // EAGLE ST / MILLARD AV
		allStops.put("1056", "1056"); // SPADINA RD / BOAKE TRL
		allStops.put("2082", "2082"); // EAGLE ST / SCOTT AV
		allStops.put("2083", "2083"); // EAGLE ST / CAROL AV
		allStops.put("2080", "2080"); // EAGLE ST / LORNE AV
		allStops.put("2081", "2081"); // EAGLE ST / EDWARD ST
		allStops.put("2086", "2086"); // EAGLE ST / MCCAFFREY RD
		allStops.put("2087", "2087"); // EAGLE ST / PEEVERS CRES
		allStops.put("2084", "2084"); // EAGLE ST / DIXON BLVD
		allStops.put("1431", "1431"); // RODICK RD / CALVERT RD
		allStops.put("1191", "1191"); // WELLINGTON ST / HAIDA DR
		allStops.put("2538", "2538"); // MOUNT ALBERT RD / STONEHILL BLVD
		allStops.put("2539", "2539"); // MOUNT ALBERT RD / HILL ST
		allStops.put("3056", "3056"); // RUTHERFORD RD / SWEETRIVER BLVD
		allStops.put("7075", "7075"); // SHEPPARD AV / CONSUMERS RD
		allStops.put("2532", "2532"); // GRIST MILL RD / MOUNT ALBERT RD
		allStops.put("2533", "2533"); // GRIST MILL RD / HILLTOP DR
		allStops.put("2530", "2530"); // MOUNT ALBERT RD / VALLEYVIEW DR
		allStops.put("2531", "2531"); // MOUNT ALBERT RD / HOLLAND RIVER BLV
		allStops.put("2536", "2536"); // HOLLAND RIVER BLVD / TYSON DR
		allStops.put("2537", "2537"); // MOUNT ALBERT RD / GRIST MILL RD
		allStops.put("2534", "2534"); // HILLTOP DR / PLANK RD
		allStops.put("2535", "2535"); // HILLTOP DR / HOLLAND RIVER BLVD
		allStops.put("2712", "2712"); // DUNLOP ST / PUGSLEY AV
		allStops.put("4321", "4321"); // EDGELEY BLVD / FOUR VALLEY DR
		allStops.put("2710", "2710"); // DUNLOP ST / YONGE ST
		allStops.put("2711", "2711"); // DUNLOP ST STOP # 2711
		allStops.put("2716", "2716"); // CROSBY AV / NEAL DR
		allStops.put("2717", "2717"); // NEAL DR / CROSBY AV
		allStops.put("2714", "2714"); // CROSBY AV / NEWKIRK RD
		allStops.put("2715", "2715"); // CROSBY AV STOP # 2715
		allStops.put("5454", "5454"); // HOOVER PARK DR / THICKETWOOD BLVD
		allStops.put("2718", "2718"); // NEAL DR / TAYLOR MILLS DR
		allStops.put("2719", "2719"); // NEAL DR / MCCONVEY DR
		allStops.put("4293", "4293_merged_3513077"); // EAST GWILLIMBURY GO STN PLATFORM 11
		allStops.put("1194", "1194"); // LESLIE ST STOP # 1194
		allStops.put("5078", "5078"); // WELLINGTON ST / BAYVIEW AV
		allStops.put("5079", "5079"); // MCDONALD DR / HAIDA DR
		allStops.put("7225", "7225"); // CARLISLE ST / PRIMROSE LN
		allStops.put("7224", "7224"); // LONDON RD / DORCHESTER ST
		allStops.put("7227", "7227"); // HUNTINGTON RD / TRADE VALLEY DR
		allStops.put("7226", "7226"); // CARLISLE ST / PRIMROSE LN
		allStops.put("5072", "5072"); // MAIN ST / BRISTOL RD
		allStops.put("5073", "5073"); // MAIN ST / PENN AV
		allStops.put("1196", "1196"); // LESLIE ST STOP # 1196
		allStops.put("5076", "5076"); // WELLINGTON ST / MAVRINAC RD
		allStops.put("5077", "5077"); // WELLINGTON ST / CONOVER AV
		allStops.put("5074", "5074"); // STATE FARM WAY STOP # 5074
		allStops.put("5075", "5075"); // WELLINGTON ST / LESLIE ST
		allStops.put("1832", "1832"); // MCCOWAN RD / RAYMERVILLE DR
		allStops.put("1833", "1833"); // RAYMERVILLE DR STOP # 1833
		allStops.put("1830", "1830"); // MCCOWAN RD / HIGHWAY 7
		allStops.put("1831", "1831"); // MCCOWAN RD / BULLOCK DR
		allStops.put("3799", "3799"); // INTERCHANGE WAY / COMMERCE ST
		allStops.put("1837", "1837"); // RAYMERVILLE DR / HICKORY DR
		allStops.put("1834", "1834"); // RAYMERVILLE DR / MERCER CRES
		allStops.put("1835", "1835"); // RAYMERVILLE DR / GRAHAM CRES
		allStops.put("3795", "3795"); // JANE ST STOP # 3795
		allStops.put("3794", "3794"); // JANE ST STOP # 3794
		allStops.put("1838", "1838"); // RAYMERVILLE DR / SNIDER DR
		allStops.put("1839", "1839"); // LARKIN AV / BRYANT RD
		allStops.put("3791", "3791"); // PORTAGE PKWY / EDGELEY BLVD
		allStops.put("3793", "3793"); // JANE ST / STEELES AV
		allStops.put("4981", "4981"); // SAVAGE RD / JELLY AV
		allStops.put("4980", "4980"); // SAVAGE RD / CASSIE RD
		allStops.put("2156", "2156"); // AVENUE RD / CASTLE ROCK DR
		allStops.put("2157", "2157"); // AVENUE RD / CARRVILLE RD
		allStops.put("4985", "4985"); // LANGSTAFF RD / VAUGHAN MILLS RD
		allStops.put("4984", "4984"); // LANGSTAFF RD / WOODCROFT LANE
		allStops.put("4987", "4987"); // KIPLING AV / HURRICANE AV
		allStops.put("4986", "4986"); // KIPLING AV / BEECHNUT RD
		allStops.put("4989", "4989"); // KIPLING AV STOP # 4989
		allStops.put("4988", "4988"); // KIPLING AV / MEETING HOUSE RD
		allStops.put("6242", "6242"); // YONGE ST / ELDERBERRY TR
		allStops.put("6243", "6243"); // BEAVER CREEK RD W / GRANTON CRT
		allStops.put("2158", "2158"); // AVENUE RD / SPRINGHEAD GDNS
		allStops.put("2408", "2408"); // BLOOMINGTON RD / BATHURST ST
		allStops.put("9861", "9861"); // HIGHWAY 7 / KENNEDY RD
		allStops.put("5382", "5382"); // METRO RD / DALTON RD
		allStops.put("5384", "5384"); // DALTON RD / GREW BLVD
		allStops.put("3065", "3065"); // CARRVILLE RD / MYERS BLVD
		allStops.put("5388", "5388"); // HIGH ST / MIDDLE ST
		allStops.put("2015", "2015"); // MULOCK DR / SANDFORD ST
		allStops.put("4877", "4877"); // MOUNT ALBERT RD / MCCOWAN RD
		allStops.put("3055", "3055"); // RUTHERFORD RD / WESTON RD
		allStops.put("4088", "4088_merged_3513019"); // GEORGINA ICE PALACE
		allStops.put("1955", "1955"); // LESLIE ST / VIA RENZO DR
		allStops.put("1991", "1991"); // MULOCK DR / CANE PKWY
		allStops.put("1957", "1957"); // ELGIN MILLS RD / REDSTONE RD
		allStops.put("1956", "1956"); // LESLIE ST / TOPOROWSKI AV
		allStops.put("1951", "1951"); // LESLIE ST / STAPLES AV
		allStops.put("1950", "1950"); // LESLIE ST / ORLANDO AV
		allStops.put("1953", "1953"); // LESLIE ST / MAJOR MACKENZIE DR
		allStops.put("1952", "1952"); // LESLIE ST STOP # 1952
		allStops.put("9700", "9700"); // HWY 7 / MARTIN GROVE
		allStops.put("9701", "9701"); // HWY 7 / KIPLING
		allStops.put("9702", "9702"); // HWY 7 / KIPLING
		allStops.put("9703", "9703"); // HWY 7 / ISLINGTON
		allStops.put("9704", "9704"); // HWY 7 / ISLINGTON
		allStops.put("1958", "1958"); // BATHURST ST / VALLEY VISTA DR
		allStops.put("4870", "4870"); // KING ST / MAINPRIZE CRES
		allStops.put("7204", "7204_merged_3513104"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("6923", "6923"); // CITYVIEW BLVD STOP # 6923
		allStops.put("1745", "1745"); // WELLINGTON ST / BERCZY ST
		allStops.put("2357", "2357"); // NORTH LAKE RD / WILDWOOD AV
		allStops.put("3241", "3241"); // WOODBINE AV / RIVIERA DR
		allStops.put("3240", "3240"); // HOOPER RD / WOODBINE AV
		allStops.put("1990", "1990"); // MULOCK DR / SANDFORD ST
		allStops.put("2069", "2069"); // GORHAM ST / NICHOLSON RD
		allStops.put("7203", "7203_merged_3513103"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("6865", "6865"); // BATHURST ST / VERDI RD
		allStops.put("4637", "4637"); // FOSSIL HILL RD / FIRENZA RD
		allStops.put("4825", "4825"); // HOLLIDGE BLVD / JOHN WEST WAY
		allStops.put("3710", "3710"); // STEELES AV / HIDDEN TRL
		allStops.put("2750", "2750"); // DUNLOP ST STOP # 2750
		allStops.put("1177", "1177"); // MURRAY DR / GOLF LINKS DR
		allStops.put("1826", "1826"); // MCCOWAN RD / BULLOCK DR
		allStops.put("1176", "1176"); // VALLEYMEDE DR / LEICESTER RD
		allStops.put("1993", "1993"); // MULOCK DR / STEVEN CRT
		allStops.put("4900", "4900"); // ROYAL ORCHARD BLVD / BAY THORN DR
		allStops.put("7030", "7030"); // HUNTINGTON RD STOP # 7030
		allStops.put("7031", "7031"); // WILFRED MURISON AV / THE BRIDLE WAL
		allStops.put("7032", "7032"); // WILFRED MURISON AV / HUBNER AV
		allStops.put("1480", "1480"); // 14TH AV STOP # 1480
		allStops.put("7034", "7034"); // WILFRED MURISON AV / WILLIAM BERCZY
		allStops.put("5499", "5499"); // LESLIE ST / BALMORAL HTS
		allStops.put("7036", "7036"); // WILLIAM BERCZY BLVD / BECKETT AV
		allStops.put("3309", "3309"); // BATHURST ST / CENTRE ST
		allStops.put("3306", "3306"); // BATHURST ST / WORTH BLVD
		allStops.put("5495", "5495"); // HAZELTON AV / VINE CLIFF BLVD
		allStops.put("1489", "1489"); // CARLTON RD / POMANDER RD
		allStops.put("5497", "5497"); // LESLIE ST STOP # 5497
		allStops.put("5490", "5490"); // 16TH AV / CORNELL CENTRE BLVD
		allStops.put("3303", "3303"); // BATHURST ST / GAMBLE RD
		allStops.put("5492", "5492"); // WHITE'S HILL AV / BITTERSWEET ST
		allStops.put("6973", "6973"); // BATHURST ST / COLLINS CRT
		allStops.put("1713", "1713"); // MAJOR MACKENZIE DR STOP # 1713
		allStops.put("1712", "1712"); // 15TH SDRD / BATHURST ST
		allStops.put("1711", "1711"); // MAJOR MACKENZIE DR / TRENCH ST
		allStops.put("1710", "1710"); // 15TH SDRD / DUFFERIN ST
		allStops.put("1717", "1717"); // MAJOR MACKENZIE DR / BATHURST ST
		allStops.put("5257", "5257"); // UPPER CANADA MALL STOP # 5257
		allStops.put("1715", "1715"); // MAJOR MACKENZIE DR / HEADDON GATE
		allStops.put("2410", "2410"); // ST. JOHN'S SDRD / OLD YONGE ST
		allStops.put("1719", "1719"); // MAJOR MACKENZIE DR / DUFFERIN ST
		allStops.put("5259", "5259"); // BATHURST ST / PUCCINI DR
		allStops.put("2145", "2145"); // SPRINGHEAD GDNS / WELDRICK RD
		allStops.put("4318", "4318"); // EDGELEY BLVD / FOUR VALLEY DR
		allStops.put("2144", "2144"); // WELDRICK RD STOP # 2144
		allStops.put("9721", "9721_merged_3513117"); // BATHURST / ATKINSON
		allStops.put("2415", "2415"); // INDUSTRIAL PKWY STOP # 2415
		allStops.put("4060", "4060"); // RAVENSHOE RD / THE QUEENSWAY
		allStops.put("2142", "2142"); // WELDRICK RD STOP # 2142
		allStops.put("5946", "5946"); // JANE ST / AUTO VAUGHAN DR
		allStops.put("1139", "1139"); // MCCLELLAN WAY / BRIARDALE PL
		allStops.put("1138", "1138"); // FRANK ENDEAN RD / MAJOR MACKENZIE D
		allStops.put("5947", "5947"); // JANE ST / AUTO VAUGHAN DR
		allStops.put("1133", "1133"); // HENDERSON DR / LEE GATE
		allStops.put("1132", "1132"); // CENTRE ST / BAYVIEW AV
		allStops.put("1131", "1131"); // HENDERSON DR / POPLAR CRES
		allStops.put("1130", "1130"); // CENTRE ST / BEAVERTON RD
		allStops.put("1137", "1137"); // MCCLELLAN WAY / TAMARAC TRL
		allStops.put("1136", "1136"); // FRANK ENDEAN RD / CASSATA AV
		allStops.put("1135", "1135"); // HENDERSON DR / BALDWIN RD
		allStops.put("1134", "1134"); // FARMSTEAD RD / FRANK ENDEAN RD
		allStops.put("2792", "2792"); // PEARSON AV / GARDEN AV
		allStops.put("7095", "7095"); // MEMORIAL CIR STOP # 7095
		allStops.put("4061", "4061"); // THE QUEENSWAY / BRECKEN DR
		allStops.put("6978", "6978"); // MARTIN GROVE / STEELES AV
		allStops.put("9864", "9864"); // ENTERPRISE BLVD / POST RD
		allStops.put("2793", "2793"); // GARDEN AV STOP # 2793
		allStops.put("4066", "4066"); // THE QUEENSWAY STOP # 4066
		allStops.put("4256", "4256"); // HIGH TECH RD / SILVER LINDEN DR
		allStops.put("2790", "2790"); // PEARSON AV / WESTWOOD LANE
		allStops.put("2796", "2796"); // HUNTERS POINT DR / HIGHWAY 7
		allStops.put("5943", "5943"); // YONGE ST STOP # 5943
		allStops.put("3018", "3018"); // 16TH AV / LESLIE ST
		allStops.put("3019", "3019"); // 16TH AV / DEWBOURNE AV
		allStops.put("7148", "7148"); // MURRELL BLVD / BALEBERRY CR
		allStops.put("7149", "7149"); // MOUNT ALBERT RD / COUNTRYMAN RD
		allStops.put("1994", "1994"); // MULOCK DR / BAYVIEW AV
		allStops.put("7144", "7144"); // MURRELL BLVD / LARKFIELD CR
		allStops.put("7145", "7145"); // MURRELL BLVD / KAVANAGH AV
		allStops.put("7146", "7146"); // MURRELL BLVD / KESTER CT
		allStops.put("3011", "3011"); // 16TH AV / VILLAGE GATE DR
		allStops.put("7140", "7140"); // LESLIE ST / CENOTAPH BLVD
		allStops.put("3017", "3017"); // 16TH AV / VOGELL RD
		allStops.put("7142", "7142"); // GREEN LANE / MURRELL BLVD
		allStops.put("7143", "7143"); // MURRELL BLVD / MANOR HAMPTON ST
		allStops.put("6767", "6767"); // CALDARI RD / GRANITERIDGE RD
		allStops.put("2794", "2794"); // HUNTERS POINT DR / OLD SURREY LANE
		allStops.put("1009", "1009"); // COMMERCE VALLEY DR / MINTHORN CRT
		allStops.put("6766", "6766"); // CLEGG RD STOP # 6766
		allStops.put("1007", "1007"); // LESLIE ST / HIGHWAY 7
		allStops.put("1006", "1006"); // RED MAPLE RD / MACGREGOR AV
		allStops.put("1005", "1005"); // LESLIE ST / MINTHORN CRT
		allStops.put("1004", "1004"); // RED MAPLE RD / SILVER LINDEN DR
		allStops.put("1003", "1003"); // LESLIE ST / COMMERCE VALLEY DR
		allStops.put("1002", "1002"); // RED MAPLE RD / BANTRY AV
		allStops.put("1001", "1001"); // RED MAPLE RD / ONEIDA CRES
		allStops.put("4189", "4189"); // NEWMARKET GO TERMINAL PLATFORM 7
		allStops.put("1225", "1225"); // ORCHARD HEIGHTS BLVD / YONGE ST
		allStops.put("1224", "1224"); // ORCHARD HEIGHTS BLVD / PARKLAND CRT
		allStops.put("1222", "1222"); // ORCHARD HEIGHTS BLVD / BANFF DR
		allStops.put("1221", "1221"); // RICHMOND HILL GO STATION PLATFORM 7
		allStops.put("1220", "1220"); // ORCHARD HEIGHTS BLVD / HILL DR
		allStops.put("4180", "4180"); // HIGHWAY 7 / ROBINSON ST
		allStops.put("4182", "4182"); // HIGHWAY 7 / MILNE LANE
		allStops.put("4187", "4187"); // NEWMARKET GO TERMINAL PLATFORM 5
		allStops.put("1228", "1228"); // DENISON ST / MCCOWAN RD
		allStops.put("5663", "5663"); // JEFFERSON SDRD / SILVER MAPLE RD
		allStops.put("5662", "5662"); // JEFFERSON SDRD / BEECH AV
		allStops.put("5661", "5661"); // JEFFERSON SDRD / ALPACA DR
		allStops.put("5660", "5660"); // JEFFERSON SDRD / SELWYN RD
		allStops.put("6761", "6761"); // HUMBER COLLEGE BLVD / HIGHWAY 27
		allStops.put("4349", "4349"); // REGENT ST / OXFORD ST
		allStops.put("4348", "4348"); // REGENT ST / OATLANDS CRES
		allStops.put("4347", "4347"); // REGENT ST / GATCOMBE CIR
		allStops.put("4346", "4346"); // REGENT ST / ELLSWORTH AV
		allStops.put("5669", "5669"); // JEFFERSON SDRD / LAKE FORREST DR
		allStops.put("6760", "6760"); // HIGHWAY 48 STOP # 6760
		allStops.put("4343", "4343"); // ELLERY DR / WHITE LODGE CRES
		allStops.put("4342", "4342"); // ELLERY DR / HIGHGROVE CRES
		allStops.put("4341", "4341"); // SILVER LINDEN DR / QUETICO DR
		allStops.put("4340", "4340"); // ELLERY DR / WHITE LODGE CRES
		allStops.put("2882", "2882"); // BAYVIEW AV / ROMFIELD CIRCT
		allStops.put("2883", "2883"); // BAYVIEW AV / ROYAL ORCHARD BLVD
		allStops.put("2880", "2880"); // BAYVIEW AV / ROMFIELD CIRCT
		allStops.put("2881", "2881"); // BAYVIEW AV / DUNSINANE DR
		allStops.put("2886", "2886"); // BAYVIEW AV / THORNLEA RD
		allStops.put("2887", "2887"); // BAYVIEW AV / HUNT CLUB CRT
		allStops.put("2884", "2884"); // BAYVIEW AV STOP # 2884
		allStops.put("2885", "2885"); // BAYVIEW AV / JOHN ST
		allStops.put("1072", "1072"); // JOHN ST STOP # 1072
		allStops.put("2888", "2888"); // BAYVIEW AV / PROCTOR AV
		allStops.put("2889", "2889"); // BAYVIEW AV / STEELES AV
		allStops.put("4064", "4064"); // THE QUEENSWAY / LAKEVIEW BLVD
		allStops.put("9710", "9710_merged_3513086"); // HWY 7 / WESTON
		allStops.put("3664", "3664"); // STEELES AV STOP # 3664
		allStops.put("3878", "3878"); // NORTH RIVERMEDE RD / CONNIE CRES
		allStops.put("3879", "3879"); // NORTH RIVERMEDE RD / BRADWICK DR
		allStops.put("6740", "6740_merged_3513021"); // KESWICK MARKETPLACE
		allStops.put("3870", "3870"); // BASALTIC RD STOP # 3870
		allStops.put("3871", "3871"); // BASALTIC RD / JACOB KEFFER PKWY
		allStops.put("3872", "3872"); // BASALTIC RD STOP # 3872
		allStops.put("3873", "3873"); // BASALTIC RD STOP # 3873
		allStops.put("3874", "3874"); // BASALTIC RD / PLANCHET RD
		allStops.put("3875", "3875"); // PLANCHET RD / LANGSTAFF RD
		allStops.put("3876", "3876"); // LANGSTAFF RD / CONNIE CRES
		allStops.put("3877", "3877"); // NORTH RIVERMEDE RD / LANGSTAFF RD
		allStops.put("5493", "5493"); // VICTORIA SQUARE BLVD / STONY HILL B
		allStops.put("6351", "6351"); // JANE ST / LANGSTAFF RD
		allStops.put("6402", "6402"); // JEFFERSON SDRD / YONGE ST
		allStops.put("6403", "6403"); // BULLOCK DR / LAIDLAW BLVD
		allStops.put("6401", "6401"); // RED MAPLE RD / 16TH AV
		allStops.put("6406", "6406"); // HONDA BLVD
		allStops.put("6407", "6407"); // YONGE ST / STOUFFVILLE RD
		allStops.put("6404", "6404"); // CANADA'S WONDERLAND STOP # 6404
		allStops.put("5718", "5718"); // HENDERSON DR / YONGE ST
		allStops.put("6409", "6409"); // WOODSPRING AV / ASPENWOOD DR
		allStops.put("3718", "3718"); // STEELES AV / TANGREEN CRT
		allStops.put("1922", "1922"); // LESLIE ST STOP # 1922
		allStops.put("5710", "5710"); // WOODSPRING AV / GORD CLELLAND GT
		allStops.put("1923", "1923"); // LESLIE ST / WEST PEARCE ST
		allStops.put("3883", "3883"); // RIVERMEDE RD / ORTONA CRT
		allStops.put("1924", "1924"); // LESLIE ST / HIGHWAY 7
		allStops.put("2474", "2474"); // YONGE ST STOP # 2474
		allStops.put("3310", "3310"); // BATHURST ST / EAST PROMENADE
		allStops.put("3273", "3273"); // BATHURST ST / STEELES AV
		allStops.put("3904", "3904"); // AUTUMN HILL BLVD / SANDWOOD DR
		allStops.put("3905", "3905"); // AUTUMN HILL BLVD / PLEASANT RIDGE A
		allStops.put("3906", "3906"); // TEN OAKS BLVD / DUFFERIN ST
		allStops.put("3907", "3907"); // TEN OAKS BLVD / FOREST RUN BLVD
		allStops.put("1926", "1926"); // LESLIE ST / COMMERCE VALLEY DR
		allStops.put("3902", "3902"); // THORNHILL WOODS DR / SUMMERIDGE DR
		allStops.put("3903", "3903"); // THORNHILL WOODS DR / COLTRANE DR
		allStops.put("6589", "6589"); // MAVRINAC BLVD / WELLINGTON AV
		allStops.put("6935", "6935"); // YORK DURHAM LINE / HOOVER PARK DR
		allStops.put("3908", "3908"); // TEN OAKS BLVD / FORECASTLE RD
		allStops.put("3112", "3112"); // MCCOWAN RD / SOUTH UNIONVILLE AV
		allStops.put("4761", "4761"); // BUR OAK AV / NORTHVALE RD
		allStops.put("4760", "4760"); // BUR OAK AV / 16TH AV
		allStops.put("4763", "4763"); // BUR OAK AV / COUNTRY GLEN RD
		allStops.put("4762", "4762"); // BUR OAK AV / TOULOUSE CRT
		allStops.put("4765", "4765"); // NINTH LINE / BUR OAK AV
		allStops.put("4764", "4764"); // BUR OAK AV / NINTH LINE
		allStops.put("6743", "6743"); // AUTUMN HILL BLVD / CHOPIN BLVD
		allStops.put("4766", "4766"); // NINTH LINE / NORTHVALE RD
		allStops.put("4769", "4769"); // OLD KENNEDY RD / STEELES AV
		allStops.put("4768", "4768"); // BUR OAK AV / CORNELL PARK AV
		allStops.put("4167", "4167"); // HIGHWAY 7 / VILLAGE PKWY
		allStops.put("4166", "4166"); // HIGHWAY 7 / VERCLAIRE GATE
		allStops.put("4164", "4164"); // HIGHWAY 7 / RODICK RD
		allStops.put("4163", "4163"); // HIGHWAY 7 / COCHRANE DR
		allStops.put("4162", "4162"); // HIGHWAY 7 / POND DR
		allStops.put("4161", "4161"); // HIGHWAY 7 / SOUTH PARK RD
		allStops.put("1473", "1473"); // BUCHANAN DR / VILLAGE PKWY
		allStops.put("1425", "1425"); // RODICK RD / PILGRIM DR
		allStops.put("4169", "4169"); // HIGHWAY 7 / MAIN ST UNIONVILLE
		allStops.put("5809", "5809"); // MEVILLE AV / MAJOR MACKENZIE DR
		allStops.put("5808", "5808"); // MCNAUGHTON RD / MAJOR MACKENZIE DR
		allStops.put("5803", "5803"); // QUEEN FILOMENA AV / GIORDANO WAY
		allStops.put("5802", "5802"); // VIA ROMANO BLVD / QUEEN FILOMENA AV
		allStops.put("5801", "5801"); // VIA ROMANO BLVD / FERRETTI ST
		allStops.put("5800", "5800"); // VIA ROMANO BLVD / SWEET EMILY CRT
		allStops.put("5807", "5807"); // MCNAUGHTON RD / CRANSTON PARK AV
		allStops.put("5806", "5806"); // MCNAUGHTON RD / ST. JOAN OF ARC AV
		allStops.put("5805", "5805"); // QUEEN FILOMENA AV / BATHURST ST
		allStops.put("5804", "5804"); // QUEEN FILOMENA AV / BATHURST ST
		allStops.put("1475", "1475"); // VILLAGE PKWY / KREIGHOFF AV
		allStops.put("6740", "6740"); // KESWICK MARKETPLACE
		allStops.put("7180", "7180"); // DUFFERIN ST STOP # 7180
		allStops.put("1907", "1907"); // KENNEDY RD / UNIONVILLE GATE
		allStops.put("7181", "7181"); // DUFFERIN ST / FINCH AV
		allStops.put("4320", "4320"); // VAUGHAN MILLS MALL STOP # 4320
		allStops.put("3579", "3579"); // STEELES AV / CONACHER DR
		allStops.put("2239", "2239"); // HURON HEIGHTS DR / DAVIS DR
		allStops.put("2238", "2238"); // HURON HEIGHTS DR / BEMAN DR
		allStops.put("5096", "5096"); // BUR OAK AV / RAINBOW VALLEY CRES
		allStops.put("7183", "7183"); // DUFFERIN ST / FINCH AV
		allStops.put("7241", "7241"); // STEELES AV / FOUNDERS RD
		allStops.put("2519", "2519"); // YONGE ST / KINGSTON RD
		allStops.put("7184", "7184"); // DUFFERIN ST / FINCH AV
		allStops.put("2235", "2235"); // ELGIN ST / HIBISCUS CRT
		allStops.put("2234", "2234"); // ELGIN ST / MAGNOLIA AV
		allStops.put("2237", "2237"); // WARATAH AV / WAYNE DR
		allStops.put("2236", "2236"); // ELGIN ST / WARATAH AV
		allStops.put("5937", "5937"); // 16TH AV / YORKTON BLVD
		allStops.put("5936", "5936"); // 16TH AV / YORKTON BLVD
		allStops.put("5934", "5934"); // MAJOR MACKENZIE DR / NICHOLS BLVD
		allStops.put("5933", "5933"); // ESTATE GARDEN DR / YONGE ST
		allStops.put("5932", "5932"); // MORNING DOVE DR / CORNELL CENTRE BL
		allStops.put("5931", "5931"); // CORNELL ROUGE BLVD / MORNING DOVE D
		allStops.put("5930", "5930"); // WHITE'S HILL AV / CORNELL ROUGE BLV
		allStops.put("7187", "7187"); // DUFFERIN ST / STANSTEAD DR
		allStops.put("5092", "5092"); // YONGE ST / DAVIS DR
		allStops.put("5939", "5939"); // 16TH AV / BUR OAK AV
		allStops.put("5938", "5938"); // 16TH AV / COUNTRY GLEN RD
		allStops.put("1631", "1631"); // 14TH AV / BIRCHMOUNT RD
		allStops.put("5093", "5093"); // YONGE ST / SILVER MAPLE RD
		allStops.put("3498", "3498"); // WOODBRIDGE AV / JAMES ST
		allStops.put("3499", "3499"); // STEELES AV / MAXOME AV
		allStops.put("3496", "3496"); // WOODBRIDGE AV / KIPLING AV
		allStops.put("3497", "3497"); // STEELES AV STOP # 3497
		allStops.put("3494", "3494"); // WOODBRIDGE AV / MOONSTONE PL
		allStops.put("3495", "3495"); // STEELES AV / LILLIAN ST
		allStops.put("3492", "3492"); // WOODBRIDGE AV / LEWIS DR
		allStops.put("3493", "3493"); // STEELES AV / WILLOWDALE AV
		allStops.put("3490", "3490"); // MARTIN GROVE RD / WOODBRIDGE AV
		allStops.put("3491", "3491"); // STEELES AV / DUMONT AV
		allStops.put("2095", "2095"); // BERNARD AV / YORKLAND ST
		allStops.put("2094", "2094"); // BERNARD AV / OLDHILL ST
		allStops.put("2097", "2097"); // BERNARD AV / VIEWMARK DR
		allStops.put("2096", "2096"); // BERNARD AV / OLDHILL ST
		allStops.put("2091", "2091"); // BERNARD AV / SQUIRE DR
		allStops.put("4575", "4575"); // HILDA AV / CRESTWOOD RD
		allStops.put("2093", "2093"); // BERNARD AV / VIEWMARK DR
		allStops.put("2092", "2092"); // BERNARD AV / PRICE ST
		allStops.put("3654", "3654"); // STEELES AV / HIGHWAY 27
		allStops.put("4579", "4579"); // ATKINSON AV / MANOR GATE
		allStops.put("3656", "3656"); // STEELES AV STOP # 3656
		allStops.put("5097", "5097"); // BUR OAK AV / CHANCERY RD
		allStops.put("2099", "2099"); // BERNARD AV / YORKLAND ST
		allStops.put("4604", "4604"); // SILVERWOOD AV STOP # 4604
		allStops.put("2666", "2666"); // YONGE ST / BOND CRES
		allStops.put("2527", "2527"); // YONGE ST STOP # 2527
		allStops.put("2526", "2526"); // YONGE ST / GREEN LANE
		allStops.put("2746", "2746"); // CROSBY AV / YONGE ST
		allStops.put("2523", "2523"); // YONGE ST / NORTH ST
		allStops.put("2667", "2667"); // YONGE ST / ESTATE GARDEN DR
		allStops.put("7044", "7044"); // VICTORIA PARK AV / SPARKS AV
		allStops.put("2529", "2529"); // MOUNT ALBERT RD / CHRISTOPHER ST
		allStops.put("2528", "2528"); // YONGE ST / MOUNT ALBERT RD
		allStops.put("4494", "4494"); // FINCH AV / WOODBINE DOWNS BLVD
		allStops.put("9784", "9784"); // YONGE / MAJOR MACKENZIE
		allStops.put("2663", "2663"); // YONGE ST / MAPLE GROVE AV
		allStops.put("5065", "5065"); // HOLLAND RIVER BLVD / HILLTOP DR
		allStops.put("4889", "4889"); // WILLOWBROOK RD / INNISBROOK CRES
		allStops.put("5067", "5067"); // GRIST MILL RD / HILLTOP DR
		allStops.put("5066", "5066"); // HILLTOP DR / SUMMIT CIR
		allStops.put("2709", "2709"); // HALL ST / WRIGHT ST
		allStops.put("2708", "2708"); // MILL ST / LUCAS ST
		allStops.put("4880", "4880"); // MOUNT ALBERT RD / WOODBINE AV
		allStops.put("2704", "2704"); // MILL ST / SUGAR MAPLE LANE
		allStops.put("4882", "4882"); // MOUNT ALBERT RD / DONLANDS AV
		allStops.put("2706", "2706"); // MILL ST / TRENCH ST
		allStops.put("4884", "4884"); // GREEN LANE / FALLINGBROOKE CRT
		allStops.put("2700", "2700"); // BATHURST ST / LADY NADIA DR
		allStops.put("2703", "2703"); // MILL ST / NEIGHBOURLY LANE
		allStops.put("4887", "4887"); // WILLOWBROOK RD / HOLM CRES
		allStops.put("1070", "1070"); // JOHN ST / DON MILLS RD
		allStops.put("6346", "6346_merged_3513016"); // JANE ST / MACINTOSH BLVD
		allStops.put("7287", "7287"); // COPPER CREEK DR STOP # 7287
		allStops.put("2748", "2748"); // CROSBY AV / PUGSLEY AV
		allStops.put("4408", "4408"); // T AND T SUPERMARKET STOP # 4408
		allStops.put("1828", "1828"); // MCCOWAN RD / HERITAGE RD
		allStops.put("1824", "1824"); // CARLTON RD / MCCOWAN RD
		allStops.put("1827", "1827"); // MARKVILLE MALL STOP # 1827
		allStops.put("4407", "4407"); // MCCALLUM DR / TOMLIN CRES
		allStops.put("4400", "4400"); // CENTRE ST STOP # 4400
		allStops.put("4401", "4401"); // CENTRE ST STOP # 4401
		allStops.put("1823", "1823"); // MCCOWAN RD / CARLTON RD
		allStops.put("2147", "2147"); // HILLCREST MALL STOP # 2147
		allStops.put("2146", "2146"); // YONGE ST / BAIF BLVD
		allStops.put("2413", "2413"); // INDUSTRIAL PKWY STOP # 2413
		allStops.put("2412", "2412"); // INDUSTRIAL PKWY STOP # 2412
		allStops.put("4978", "4978"); // SHANAHAN BLVD / CARADONNA CRES
		allStops.put("4979", "4979"); // SHANAHAN BLVD / SAVAGE RD
		allStops.put("2141", "2141"); // ESSEX AV / WELDRICK RD
		allStops.put("2140", "2140"); // ESSEX AV / MARCHWOOD CRES
		allStops.put("4974", "4974"); // GATEWAY DR / LIMERIDGE ST
		allStops.put("4975", "4975"); // GATEWAY DR / HAVERHILL TER
		allStops.put("4976", "4976"); // GATEWAY DR / CHIPPINGWOOD MNR
		allStops.put("4977", "4977"); // SHANAHAN BLVD STOP # 4977
		allStops.put("4972", "4972"); // CROWDER BLVD / PRITCHARD PL
		allStops.put("4973", "4973"); // GATEWAY DR / BILLINGHAM HTS
		allStops.put("5393", "5393"); // HIGHWAY 48 / HOLMES POINT RD
		allStops.put("5392", "5392"); // HIGHWAY 48 / WOODFIELD DR
		allStops.put("5391", "5391"); // HIGHWAY 48 / VIRGINIA BLVD
		allStops.put("5390", "5390"); // HIGHWAY 48 / PARK RD
		allStops.put("5397", "5397"); // HIGHWAY 48 / WOODFIELD DR
		allStops.put("5396", "5396"); // HIGHWAY 48 / HOLMES POINT RD
		allStops.put("2411", "2411"); // INDUSTRIAL PKWY / ST. JOHN'S SDRD
		allStops.put("5399", "5399"); // HIGHWAY 48 / PARK RD
		allStops.put("5398", "5398"); // HIGHWAY 48 / VIRGINIA BLVD
		allStops.put("1920", "1920"); // LESLIE ST / WEST BEAVER CREEK RD
		allStops.put("1921", "1921"); // LESLIE ST / WEST WILMOT ST
		allStops.put("3274", "3274"); // BATHURST ST / TOWNSGATE DR
		allStops.put("3275", "3275"); // BATHURST ST STOP # 3275
		allStops.put("3272", "3272"); // WOODBINE AV / ESNA PARK DR
		allStops.put("1925", "1925"); // LESLIE ST / MINTHORN CRT
		allStops.put("3270", "3270"); // VICTORIA PARK AV / STEELES AV
		allStops.put("1928", "1928"); // LESLIE ST / GREEN LANE
		allStops.put("1929", "1929"); // LESLIE ST / 14TH LANE
		allStops.put("5337", "5337"); // THORNHILL C.C. STOP # 5337
		allStops.put("3278", "3278"); // BATHURST ST STOP # 3278
		allStops.put("3474", "3474"); // MARTIN GROVE RD / JACKMAN CRES
		allStops.put("3475", "3475"); // MARTIN GROVE RD / FOREST DR
		allStops.put("3476", "3476"); // MARTIN GROVE RD / GOLDFINCH PL
		allStops.put("4227", "4227"); // DON MILLS RD / SKYMARK DR
		allStops.put("3470", "3470"); // FOREST DR / SADDLE TREE CRES
		allStops.put("2938", "2938"); // JANE ST / ROSEHEATH DR
		allStops.put("3472", "3472"); // MARTIN GROVE RD / TRITON AV
		allStops.put("3473", "3473"); // MARTIN GROVE RD / BELLONA ST
		allStops.put("3333", "3333"); // RUTHERFORD GO STATION PLATFORM 5
		allStops.put("1788", "1788"); // NINTH LINE / ELM RD
		allStops.put("4499", "4499"); // MELVILLE AV / EDDINGTON PL
		allStops.put("3478", "3478"); // MARTIN GROVE RD / MORNING STAR DR
		allStops.put("3479", "3479"); // MARTIN GROVE RD / CONDOTTI DR
		allStops.put("9876", "9876"); // COMMERCE EASTBOUND
		allStops.put("1365", "1365"); // DONCASTER AV STOP # 1365
		allStops.put("2937", "2937"); // MAJOR MACKENZIE DR / MELVILLE AV
		allStops.put("5027", "5027_merged_3513023"); // BAYVIEW AV STOP # 5027
		allStops.put("1986", "1986"); // YONGE ST STOP # 1986
		allStops.put("7074", "7074"); // SHEPPARD AV / SETTLERS RD
		allStops.put("6901", "6901"); // POETRY DR / GARYSCHOLL RD
		allStops.put("6479", "6479"); // THE QUEENSWAY STOP # 6479
		allStops.put("3319", "3319"); // VAUGHAN MILLS TERMINAL PLATFORM 6
		allStops.put("7022", "7022"); // CASTLE OAKS CROSSING / GARDENBROOKE
		allStops.put("7021", "7021"); // CASTLE OAKS CROSSING / THORNDALE RD
		allStops.put("7020", "7020"); // THE GORE RD / CASTLE OAKS CROSSING
		allStops.put("7027", "7027"); // CLARKWAY DR / CALIPER RD
		allStops.put("7026", "7026"); // CLARKWAY DR / ALTURA WAY
		allStops.put("5489", "5489"); // 16TH AV / BUR OAK AV
		allStops.put("5488", "5488"); // CORNELL CENTRE BLVD / 16TH AV
		allStops.put("5487", "5487"); // WHITE'S HILL AV / CORNWALL DR
		allStops.put("5486", "5486"); // WHITE'S HILL AV / BITTERSWEET ST
		allStops.put("3313", "3313"); // VAUGHAN MILLS TERMINAL PLATFORM 2
		allStops.put("7028", "7028"); // CLARKWAY RD / CASTLEMORE RD
		allStops.put("3315", "3315"); // VAUGHAN MILLS TERMINAL PLATFORM 3
		allStops.put("5482", "5482"); // 14TH AV / RIVERWALK DR
		allStops.put("3317", "3317"); // VAUGHAN MILLS TERMINAL PLATFORM 4
		allStops.put("3316", "3316"); // BATHURST ST STOP # 3316
		allStops.put("7023", "7023"); // CASTLE OAKS CROSSING / BELLCHASE TR
		allStops.put("5249", "5249"); // ALLAURA BLVD STOP # 5249
		allStops.put("1728", "1728"); // HENDERSON DR / TAMARAC TRL
		allStops.put("1729", "1729"); // MAJOR MACKENZIE DR / KILLIAN RD
		allStops.put("5245", "5245"); // INDUSTRIAL PKWY / WELLINGTON ST
		allStops.put("1727", "1727"); // MAJOR MACKENZIE DR STOP # 1727
		allStops.put("6575", "6575"); // BUR OAK AV STOP # 6575
		allStops.put("5241", "5241"); // STONEHAVEN AV / DILLMAN AV
		allStops.put("1723", "1723"); // MAJOR MACKENZIE DR STOP # 1723
		allStops.put("1721", "1721"); // MAJOR MACKENZIE DR / HILL ST
		allStops.put("6956", "6956"); // NAPA VALLEY AV / FONTESALVA AV
		allStops.put("6472", "6472"); // METRO RD / LAKE DR
		allStops.put("3361", "3361"); // ISLINGTON AV / BELL CRT
		allStops.put("5625", "5625"); // BUR OAK AV / HIGHWAY 7
		allStops.put("2013", "2013"); // MULOCK DR STOP # 2013
		allStops.put("7076", "7076"); // SHEPPARD AV / CONSUMERS RD
		allStops.put("3330", "3330"); // ATKINSON AV / ROSEDALE HEIGHTS DR
		allStops.put("6579", "6579"); // ST. JOHN'S SDRD STOP # 6579
		allStops.put("7025", "7025"); // CLARKWAY DR / CASTLE OAKS CROSSING
		allStops.put("6477", "6477"); // SHAFTSBURY AV / ELGIN MILLS RD
		allStops.put("2151", "2151"); // SPRINGHEAD GDNS / BAIF BLVD
		allStops.put("7024", "7024"); // CASTLE OAKS CROSSING / LONG BRANCH
		allStops.put("1042", "1042"); // VALLEYMEDE DR / BRIGGS AV
		allStops.put("7281", "7281"); // STONEHAVEN AV / TALLANTINE PL
		allStops.put("6476", "6476"); // LANGSTAFF RD STOP # 6476
		allStops.put("3005", "3005"); // 16TH AV / KENNEDY RD
		allStops.put("3004", "3004"); // 16TH AV / HARBORD ST
		allStops.put("5608", "5608"); // STATE FARM WAY / FIRST COMMERCE DR
		allStops.put("3006", "3006"); // 16TH AV / NORMANDALE RD
		allStops.put("3001", "3001"); // 16TH AV / STONEBRIDGE DR
		allStops.put("3000", "3000"); // 16TH AV / MCCOWAN RD
		allStops.put("3003", "3003"); // 16TH AV / WILLIAM BERCZY BLVD
		allStops.put("3002", "3002"); // 16TH AV / THE BRIDLE WALK
		allStops.put("1985", "1985"); // YONGE ST / GLADMAN AV
		allStops.put("5589", "5589"); // PUGSLEY AV / ROSEVIEW AV
		allStops.put("3009", "3009"); // 16TH AV / WARDEN AV
		allStops.put("7029", "7029"); // CASTLEMORE RD / APPLE VALLEY WAY
		allStops.put("2414", "2414"); // INDUSTRIAL PKWY STOP # 2414
		allStops.put("7203", "7203_merged_3513075"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("1588", "1588"); // RODICK RD / WOODBINE AV
		allStops.put("5484", "5484"); // BOX GROVE BYP / 14TH AV
		allStops.put("7159", "7159"); // EDGLEY BLVD / APPLEWOOD CRES
		allStops.put("7157", "7157"); // NINTH LINE / 14TH AV
		allStops.put("5483", "5483"); // RIVERWALK DR / BOX GROVE BYP
		allStops.put("7155", "7155"); // KING ST / VISCOUNT WAY
		allStops.put("1581", "1581"); // ROUGE BANK DR / SILVERFLOWER AV
		allStops.put("1586", "1586"); // RODICK RD / PILGRIM DR
		allStops.put("1587", "1587"); // BOXWOOD CRES / LEMSFORD DR
		allStops.put("1584", "1584"); // RODICK RD / MACRILL RD
		allStops.put("3314", "3314"); // BATHURST ST / MILNER GATE
		allStops.put("1038", "1038"); // VALLEYMEDE DR / CHALMERS RD
		allStops.put("1039", "1039"); // DONCASTER AV / HENDERSON AV
		allStops.put("5481", "5481"); // BOX GROVE BYP / RIZAL AV
		allStops.put("9808", "9808_merged_3513122"); // YONGE ST / EAGLE ST
		allStops.put("1032", "1032"); // VALLEYMEDE DR / SAMANTHA CIR
		allStops.put("1033", "1033"); // DONCASTER AV STOP # 1033
		allStops.put("1030", "1030"); // TIMES AV / HIGHWAY 7
		allStops.put("5480", "5480"); // BOX GROVE BYPASS/ COPPER CREEK DR
		allStops.put("1036", "1036"); // VALLEYMEDE DR / LEICESTER RD
		allStops.put("1037", "1037"); // DONCASTER AV STOP # 1037
		allStops.put("1034", "1034"); // VALLEYMEDE DR / RED OAK DR
		allStops.put("1035", "1035"); // DONCASTER AV STOP # 1035
		allStops.put("1213", "1213"); // RICHMOND HILL GO STATION PLATFORM 3
		allStops.put("1210", "1210"); // AURORA HEIGHTS DR / WHISPERING PINE
		allStops.put("1211", "1211"); // RICHMOND HILL GO STATION PLATFORM 2
		allStops.put("1216", "1216"); // ORCHARD HEIGHTS BLVD / FIELDING DR
		allStops.put("1217", "1217"); // RICHMOND HILL GO STATION PLATFORM 5
		allStops.put("1214", "1214"); // ORCHARD HEIGHTS BLVD / WHISPERING P
		allStops.put("1215", "1215"); // RICHMOND HILL GO STATION PLATFORM 4
		allStops.put("1218", "1218"); // ORCHARD HEIGHTS BLVD / CRAWFORD ROS
		allStops.put("1219", "1219"); // RICHMOND HILL GO STATION PLATFORM 6
		allStops.put("4245", "4245"); // LANGSTAFF RD / WESTON RD
		allStops.put("9718", "9718_merged_3513113"); // CENTRE / DUFFERIN
		allStops.put("5635", "5635"); // HOOVER PARK RD / CABIN TRAIL CRES
		allStops.put("5658", "5658"); // GAMBLE RD / SELWYN RD
		allStops.put("5659", "5659"); // TOWER HILL RD / BATHURST ST
		allStops.put("4372", "4372"); // SILVER LINDEN DR / MELVILLE ST
		allStops.put("7071", "7071"); // VICTORIA PARK AV /PATRICK BLVD
		allStops.put("5654", "5654"); // GREEN LANE / LESLIE ST
		allStops.put("4371", "4371"); // SILVER LINDEN DR / YUKON DR
		allStops.put("3335", "3335"); // RUTHERFORD GO STATION PLATFORM 6
		allStops.put("5653", "5653"); // KINGSHILL RD / NEWBRIDGE AV
		allStops.put("4375", "4375"); // VAUGHAN MILLS RD / AVDELL AV
		allStops.put("4831", "4831"); // BAYVIEW AV / HOLLIDGE BLVD
		allStops.put("4485", "4485"); // HUMBER COLLEGE BLVD / HUMBERLINE DR
		allStops.put("2899", "2899"); // BAYVIEW AV / LANGSTAFF RD
		allStops.put("2898", "2898"); // BAYVIEW AV / SYCAMORE DR
		allStops.put("2895", "2895"); // BAYVIEW AV / GREEN LANE
		allStops.put("2894", "2894"); // BAYVIEW AV / JOHN ST
		allStops.put("2897", "2897"); // BAYVIEW AV / DUNSINANE DR
		allStops.put("2896", "2896"); // BAYVIEW AV / WILLOWBROOK RD
		allStops.put("2891", "2891"); // BAYVIEW AV / DONCREST DR
		allStops.put("2890", "2890"); // BAYVIEW AV / STEELES AV
		allStops.put("2893", "2893"); // BAYVIEW AV / HARRIS WAY
		allStops.put("2892", "2892"); // BAYVIEW AV / LAURELEAF RD
		allStops.put("1454", "1454"); // GLEN SHIELDS AV / RIVIERA DR
		allStops.put("1455", "1455"); // APPLE CREEK BLVD / WHITEHALL DR
		allStops.put("1456", "1456"); // GLEN SHIELDS AV / CHERRY HILLS RD
		allStops.put("1457", "1457"); // APPLE CREEK BLVD / TOWN CENTRE BLVD
		allStops.put("1450", "1450"); // GLEN SHIELDS AV / SPYGLASS HILL RD
		allStops.put("1451", "1451"); // APPLE CREEK BLVD / RODICK RD
		allStops.put("1100", "1100"); // DENISON ST STOP # 1100
		allStops.put("1453", "1453"); // APPLE CREEK BLVD / CORBY RD
		allStops.put("3334", "3334"); // ATKINSON AV / CAMPBELL AV
		allStops.put("1458", "1458"); // GLEN SHIELDS AV / DUFFERIN ST
		allStops.put("1459", "1459"); // TOWN CENTRE BLVD / WALLIS WAY
		allStops.put("1108", "1108"); // DENISON ST / GORVETTE RD
		allStops.put("4830", "4830"); // BAYVIEW AV STOP # 4830
		allStops.put("4080", "4080"); // SIMCOE AV STOP # 4080
		allStops.put("4081", "4081"); // THE QUEENSWAY / CHURCH ST
		allStops.put("4082", "4082"); // CHURCH ST / CIRCLE RIDGE DR
		allStops.put("3868", "3868"); // WESTBURNE DR / RUTHERFORD RD
		allStops.put("4084", "4084"); // NATANYA BLVD / CHURCH ST
		allStops.put("4085", "4085"); // NATANYA BLVD / AILSA DR
		allStops.put("4086", "4086"); // NATANYA BLVD / WEXFORD DR
		allStops.put("4087", "4087"); // WEXFORD DR / SHERIE DR
		allStops.put("3863", "3863"); // BASALTIC RD STOP # 3863
		allStops.put("3862", "3862"); // BASALTIC RD STOP # 3862
		allStops.put("3861", "3861"); // BASALTIC RD / PLANCHET RD
		allStops.put("3860", "3860"); // LANGSTAFF RD / PLANCHET RD
		allStops.put("3867", "3867"); // WESTBURNE DR / RUTHERFORD RD
		allStops.put("3866", "3866"); // WESTBURNE DR STOP # 3866
		allStops.put("3865", "3865"); // BASALTIC RD STOP # 3865
		allStops.put("3864", "3864"); // BASALTIC RD / JACOB KEFFER PKWY
		allStops.put("7073", "7073"); // SHEPPARD AV / SETTLERS RD
		allStops.put("6201", "6201"); // ZENWAY BLVD / RAINBOW CREEK DR
		allStops.put("5728", "5728"); // WESTON RD / LORMEL GATE
		allStops.put("1977", "1977"); // YONGE ST / ASPENWOOD DR
		allStops.put("6419", "6419"); // FOSSIL HILL RD / RUTHERFORD RD
		allStops.put("9819", "9819"); // RICHMOND HILL CENTRE PLATFORM 3
		allStops.put("5722", "5722"); // NINTH LINE / ELGIN MILLS RD
		allStops.put("6414", "6414"); // COPPER CREEK DR / RIZAL AV
		allStops.put("9816", "9816"); // SHEPPARD / DON MILLS
		allStops.put("9817", "9817"); // YONGE / STEELES
		allStops.put("5726", "5726"); // SPRINGHEAD GRDNS / DENAVA GATE
		allStops.put("5727", "5727"); // WESTON RD / RETREAT BLVD
		allStops.put("6413", "6413"); // COPPER CREEK DR / STONECHURCH CRES
		allStops.put("5725", "5725"); // NINTH LINE / ELGIN MILLS RD
		allStops.put("4832", "4832"); // BAYVIEW AV / BOREALIS AV
		allStops.put("7109", "7109"); // MARTIN GROVE RD / HIGHWAY 27
		allStops.put("3917", "3917"); // KEELE ST / ADMINISTRATION RD
		allStops.put("3916", "3916"); // KEELE ST / JARDIN DR
		allStops.put("3915", "3915"); // KEELE ST / GREAT GULF DR
		allStops.put("3914", "3914"); // KEELE ST / RONROSE DR
		allStops.put("3913", "3913"); // KEELE ST / RONROSE DR
		allStops.put("3912", "3912"); // KEELE ST / SNIDERCROFT RD
		allStops.put("3911", "3911"); // CONFEDERATION PKWY / RUTHERFORD RD
		allStops.put("2137", "2137"); // NEWKIRK RD / MAJOR MACKENZIE DR
		allStops.put("9747", "9747"); // KENNEDY RD / HWY 7
		allStops.put("6343", "6343"); // CLARISSA DR / WELDRICK RD
		allStops.put("3919", "3919"); // KEELE ST / RIVERMEDE RD
		allStops.put("3918", "3918"); // KEELE ST STOP # 3918
		allStops.put("6730", "6730"); // STOUFFVILLE RD / BAYVIEW AV
		allStops.put("6731", "6731"); // RICHMOND GREEN H.S. STOP # 6731
		allStops.put("6732", "6732"); // YONGE ST / SILVER MAPLE RD
		allStops.put("6342", "6342"); // CLARISSA DR STOP # 6342
		allStops.put("4798", "4798"); // MAJOR MACKENZIE DR / KENNEDY RD
		allStops.put("6735", "6735"); // PETER RUPERT AV / JAZZ DR
		allStops.put("6736", "6736"); // STEELES AV / ISLINGTON AV
		allStops.put("6737", "6737"); // MAIN ST / SANDALE RD
		allStops.put("4794", "4794"); // MAJOR MACKENZIE DR / ANGUS GLEN BLV
		allStops.put("6739", "6739"); // GLENWOODS AV / ROSLEM AV
		allStops.put("4796", "4796"); // MAJOR MACKENZIE DR / KEELE ST
		allStops.put("4797", "4797"); // MAJOR MACKENZIE DR / ROY RAINEY AV
		allStops.put("3385", "3385"); // NAPA VALLEY AV / ROTA CRES
		allStops.put("4793", "4793"); // MAJOR MACKENZIE DR / WILLIAM BERCZY
		allStops.put("4152", "4152"); // HIGHWAY 7 / INTERCHANGE WAY
		allStops.put("5995", "5995"); // SOUTH UNIONVILLE AV / RAY ST
		allStops.put("4150", "4150"); // HIGHWAY 7 / MARYCROFT AV
		allStops.put("5835", "5835"); // HEMLOCK DR / TENTH LINE
		allStops.put("5832", "5832"); // ELGIN MILLS RD / JOHN BIRCHALL RD
		allStops.put("4157", "4157"); // HIGHWAY 7 / CENTRE ST
		allStops.put("4154", "4154"); // HIGHWAY 7 / CREDITSTONE RD
		allStops.put("5831", "5831"); // LESLIE ST STOP # 5831
		allStops.put("7041", "7041"); // VICTORIA PARK AV STOP #7041
		allStops.put("5997", "5997"); // CASTAN AV / AVOCA DR
		allStops.put("5838", "5838"); // 33 WELDRICK RD STOP # 5838
		allStops.put("5839", "5839"); // FOOD BASICS STOP # 5839
		allStops.put("6349", "6349"); // JANE ST / LANGSTAFF RD
		allStops.put("5996", "5996"); // SOUTH UNIONVILLE DR / HARRY COOK DR
		allStops.put("6904", "6904"); // POETRY DR / GALLANT PL
		allStops.put("9868", "9868"); // HIGHWAY 7 / VILLAGE PKWY
		allStops.put("4834", "4834"); // SUPERSTORE STOP # 4834
		allStops.put("4486", "4486"); // HUMBER COLLEGE BLVD STOP # 4486
		allStops.put("5991", "5991"); // EMILY CARR S.S. STOP # 5991
		allStops.put("9705", "9705_merged_3513127"); // HWY 7 / PINE VALLEY
		allStops.put("5993", "5993"); // PEFFERLAW RD / MORNING GLORY RD
		allStops.put("5633", "5633"); // HOOVER PARK RD / PARK DR
		allStops.put("5407", "5407"); // METRO RD / DALTON RD
		allStops.put("5992", "5992"); // APPLE CREEK BLVD / HOLLINGHAM RD
		allStops.put("3286", "3286"); // BATHURST ST / CARRVILLE RD
		allStops.put("1355", "1355"); // HENDERSON AV / ELGIN ST
		allStops.put("6903", "6903"); // POETRY DR / GALLANT PL
		allStops.put("4837", "4837"); // WALMART STOP # 4837
		allStops.put("6089", "6089"); // MCNAUGHTON RD / EAGLE CRT
		allStops.put("6084", "6084"); // ELSON ST / MARKHAM RD
		allStops.put("6082", "6082"); // ELSON ST / COXWORTH AV
		allStops.put("6083", "6083"); // ELSON ST / BEULAH DR
		allStops.put("6080", "6080"); // ELSON ST / JOYCEDALE ST
		allStops.put("6081", "6081"); // ELSON ST / IRENEMOUNT CRES
		allStops.put("6648", "6648"); // AUTUMN HILL BLVD / BATHURST GLEN DR
		allStops.put("9708", "9708_merged_3513080"); // HWY 7 / ANSLEY GROVE
		allStops.put("6029", "6029"); // SOUTH UNIONVILLE AV / PIERA GDNS
		allStops.put("6644", "6644"); // MELVILLE AV  / CUNNINGHAM DR
		allStops.put("6645", "6645"); // MELVILLE AV / CARRON AV
		allStops.put("6646", "6646"); // MELVILLE AV / KELSO CR
		allStops.put("6647", "6647"); // AUTUMN HILL BLVD / BATHURST ST
		allStops.put("6160", "6160"); // HAZELTON AV / LARKMEAD CRES
		allStops.put("6641", "6641"); // HIGHWAY 7 / VALLEYMEDE DR
		allStops.put("6642", "6642"); // MELVILLE AV / RUTHERFORD RD
		allStops.put("6643", "6643"); // CUNNINGHAM DR / CARRON AV
		allStops.put("5902", "5902"); // THOMAS COOK AV / LEBOVIC CAMPUS DR
		allStops.put("5903", "5903"); // LEBOVIC CAMPUS DR / RUMSEY RD
		allStops.put("5900", "5900"); // THOMAS COOK AV / WOLF CREEK CRES
		allStops.put("4836", "4836"); // BAYVIEW AV / RIVER RIDGE BLVD
		allStops.put("5906", "5906"); // MAJOR MACKENZIE DR / DONALD COUSENS
		allStops.put("5907", "5907"); // DONALD COUSENS PKWY / CASTLEMORE AV
		allStops.put("5904", "5904"); // LEBOVIC CAMPUS DR / ILAN RAMON BLVD
		allStops.put("5905", "5905"); // LEBOVIC CAMPUS DR / BATHURST ST
		allStops.put("1532", "1532"); // RUSSELL JARVIS DR / MEADOWGRASS CRE
		allStops.put("5908", "5908"); // DONALD COUSENS PKWY / NINTH LINE
		allStops.put("5909", "5909"); // DONALD COUSENS PKWY / COUNTRY GLEN
		allStops.put("4919", "4919"); // GREEN LANE / HUNTINGTON PARK DR
		allStops.put("3489", "3489"); // MARTIN GROVE RD / BELLONA ST
		allStops.put("3488", "3488"); // MARTIN GROVE RD / JACKMAN CRES
		allStops.put("2670", "2670"); // YONGE ST / TOWNWOOD DR
		allStops.put("3481", "3481"); // MARTIN GROVE RD / CASTLEPOINT DR
		allStops.put("3480", "3480"); // MARTIN GROVE RD / SICILIA ST
		allStops.put("3483", "3483"); // MARTIN GROVE RD / HIGHWAY 27
		allStops.put("3482", "3482"); // MARTIN GROVE RD / ANDY CRES
		allStops.put("3485", "3485"); // RUTHERFORD RD / CLARENCE ST
		allStops.put("3484", "3484"); // RUTHERFORD RD / FOREST FOUNTAIN DR
		allStops.put("3487", "3487"); // MARTIN GROVE RD / FOREST DR
		allStops.put("3486", "3486"); // RUTHERFORD RD / ISLINGTON AV
		allStops.put("4563", "4563"); // BOND CRES / BOND CRES
		allStops.put("4562", "4562"); // KING RD / DUFFERIN ST
		allStops.put("4561", "4561"); // KING RD / BATHURST ST
		allStops.put("4560", "4560"); // BLOOMINGTON RD / ACADEMY DR
		allStops.put("4567", "4567"); // NEWBRIDGE AV / GROVEWOOD ST
		allStops.put("1976", "1976_merged_3513116"); // GREEN LANE AND YONGE STREET
		allStops.put("4565", "4565"); // KING RD / BATHURST ST
		allStops.put("3648", "3648"); // STEELES AV STOP # 3648
		allStops.put("4569", "4569"); // NEWBRIDGE AV / BOND CRES
		allStops.put("3644", "3644"); // STEELES AV / OLD WESTON RD
		allStops.put("6993", "6993"); // ST URBAIN DR / SIENA DR
		allStops.put("3642", "3642"); // STEELES AV / DIRECTOR CRT
		allStops.put("3640", "3640"); // ANSLEY GROVE RD / RUSSET WAY
		allStops.put("2550", "2550"); // YONGE ST STOP # 2550
		allStops.put("1829", "1829"); // MCCOWAN RD / HERITAGE RD
		allStops.put("6398", "6398"); // WOOTTEN WAY / RAMONA BLVD
		allStops.put("2553", "2553"); // QUEENSVILLE SDRD / OAK AV
		allStops.put("2554", "2554"); // PARK AV / QUEENSVILLE SDRD
		allStops.put("2556", "2556"); // PARK AV / DONALDSON RD
		allStops.put("2557", "2557"); // PARK AV / SUNRISE ST
		allStops.put("2558", "2558"); // PARK AV / ORIOLE DR
		allStops.put("2559", "2559"); // CENTENNIAL AV / ORIOLE DR
		allStops.put("6390", "6390"); // LESLIE ST / POPPY LN
		allStops.put("6391", "6391"); // WELLINGTON ST / TEMPERANCE ST
		allStops.put("6396", "6396"); // YONGE ST / OLD YONGE ST
		allStops.put("3007", "3007"); // 16TH AV / NORMANDALE RD
		allStops.put("6394", "6394"); // RED MAPLE RD / COLSTON CT
		allStops.put("6395", "6395"); // BAYVIEW AV / COLLEGE ST
		allStops.put("2396", "2396"); // COON'S RD STOP # 2396
		allStops.put("2397", "2397"); // COON'S RD / BLOOMFIELD TRL
		allStops.put("2394", "2394"); // ASHFIELD DR / YONGE ST
		allStops.put("2395", "2395"); // COON'S RD / GROVEPARK ST
		allStops.put("2392", "2392"); // BAYSWATER AV / KINGSMEAD CRT
		allStops.put("2393", "2393"); // BAYSWATER AV / ASHFIELD DR
		allStops.put("2390", "2390"); // WORTHINGTON AV / LORRIDGE ST
		allStops.put("2398", "2398"); // BLOOMFIELD TRL / FERN VALLEY CRES
		allStops.put("2399", "2399"); // BLOOMFIELD TRL / BLOOMINGTON RD
		allStops.put("5010", "5010"); // BAYVIEW AV / CARBERRY ST
		allStops.put("5011", "5011"); // BAYVIEW AV / CARBERRY ST
		allStops.put("4899", "4899"); // ROYAL ORCHARD BLVD / KIRK DR
		allStops.put("4898", "4898"); // ROYAL ORCHARD BLVD / SHADY LANE CRE
		allStops.put("5014", "5014"); // STONEHAVEN AV / LOCKWOOD CIR
		allStops.put("5015", "5015"); // STONEHAVEN AV / LOCKWOOD CIR
		allStops.put("5016", "5016"); // STONEHAVEN AV / LESLIE ST
		allStops.put("2726", "2726"); // NEAL DR / TAYLOR MILLS DR
		allStops.put("4893", "4893"); // WILLOWBROOK RD / BRAEBURN DR
		allStops.put("2771", "2771"); // CANYON HILL AV / LEYBURN AV
		allStops.put("2772", "2772"); // CANYON HILL AV / YONGE ST
		allStops.put("2773", "2773"); // TRENCH ST / RICHMOND ST
		allStops.put("2774", "2774"); // TRENCH ST / MAJOR MACKENZIE DR
		allStops.put("2775", "2775"); // HARDING BLVD / LILLEY CRT
		allStops.put("4895", "4895"); // WILLOWBROOK RD / BAYVIEW AV
		allStops.put("4894", "4894"); // WILLOWBROOK RD / BRAEBURN DR
		allStops.put("1102", "1102"); // DENISON ST / BIRCHMOUNT RD
		allStops.put("4901", "4901"); // ROYAL ORCHARD BLVD / WILD CHERRY LA
		allStops.put("4252", "4252_merged_3513002"); // EAST GWILLIMBURY GO STN PLATFORM 12
		allStops.put("2800", "2800"); // GARDEN AV / FAIRVIEW AV
		allStops.put("1859", "1859"); // MAIN ST MARKHAM / SPRINGDALE ST
		allStops.put("6264", "6264"); // ROY RAINY AV / HERMITAGE BLVD
		allStops.put("3364", "3364"); // NEW WESTMINSTER DR / CONLEY ST
		allStops.put("6262", "6262"); // HURON HEIGHTS DR / HILL GATE
		allStops.put("6263", "6263"); // HURON HEIGHTS DR / HILL GATE
		allStops.put("6260", "6260"); // 15TH SDRD / EAST OF 1280 15TH SDRD
		allStops.put("6261", "6261"); // BRISTOL RD / VANDEN BERGH BLVD
		allStops.put("4417", "4417"); // MACKENZIE HOSPITAL STOP # 4417
		allStops.put("1851", "1851"); // PARKWAY AV STOP # 1851
		allStops.put("1852", "1852"); // PARKWAY AV / SIR CONSTANTINE DR
		allStops.put("1853", "1853"); // PARKWAY AV / SIR BEDEVERE PL
		allStops.put("1854", "1854"); // PARKWAY AV / PARAMOUNT RD
		allStops.put("3843", "3843"); // JANE ST / LOCKE ST
		allStops.put("4411", "4411"); // AL PALLADINI C.C STOP # 4411
		allStops.put("4410", "4410"); // SOUTH HILL PLAZA STOP # 4410
		allStops.put("6064", "6064"); // LEBOVIC CAMPUS DR / THOMAS COOK AV
		allStops.put("6065", "6065"); // THOMAS COOK AV / MARC SANTI BLVD
		allStops.put("6066", "6066"); // THOMAS COOK AV / RUTHERFORD RD
		allStops.put("3842", "3842"); // JANE ST / RIVEROCK GATE
		allStops.put("6060", "6060"); // LADY FENYROSE AV / TESTON RD
		allStops.put("6061", "6061"); // ILAN RAMON AV / VALLEY VISTA DR
		allStops.put("6062", "6062"); // ILAN RAMON AV / TIMNA CRES
		allStops.put("6063", "6063"); // LEBOVIC CAMPUS DR / ILAN RAMON BLVD
		allStops.put("4967", "4967"); // QUEEN ST / PROSPECT ST
		allStops.put("3845", "3845"); // JANE ST / COURTLAND AV
		allStops.put("4965", "4965"); // MAIN ST / DAVIS DR
		allStops.put("4964", "4964"); // MAIN ST / QUEEN ST
		allStops.put("6068", "6068"); // EAGLE ROCK WAY STOP # 6068
		allStops.put("4962", "4962"); // MAIN ST / BOTSFORD ST
		allStops.put("4961", "4961"); // MAIN ST / BOTSFORD ST
		allStops.put("3844", "3844"); // JANE ST / GENSAL GATE
		allStops.put("2604", "2604"); // DAVIS DR STOP # 2604
		allStops.put("2605", "2605"); // DAVIS DR / LORNE AV
		allStops.put("9724", "9724"); // HWY 7 / BAYVIEW
		allStops.put("5450", "5450"); // REEVES WAY BLVD / WILLIAM STARK RD
		allStops.put("2600", "2600"); // DAVIS DR STOP # 2600
		allStops.put("2601", "2601"); // DAVIS DR / GEORGE ST
		allStops.put("2602", "2602"); // DAVIS DR / BARBARA RD
		allStops.put("5433", "5433"); // TENTH LINE / NORTH ST
		allStops.put("2608", "2608"); // DAVIS DR / SUPERIOR ST
		allStops.put("2609", "2609"); // DAVIS DR / CHARLES ST
		allStops.put("9728", "9728"); // HWY 7 / WEST BEAVER CREEK
		allStops.put("9729", "9729"); // HWY 7 / WEST BEAVER CREEK
		allStops.put("1933", "1933"); // DON MILLS RD / SIMONSTON BLVD
		allStops.put("1932", "1932"); // DON MILLS RD / SIMONSTON BLVD
		allStops.put("1931", "1931"); // LESLIE ST / JOHN ST
		allStops.put("3262", "3262"); // WOODBINE AV / SHIELDS CRT
		allStops.put("1937", "1937"); // DON MILLS RD / SIMONSTON BLVD
		allStops.put("5129", "5129"); // JOHN ST / CHESTNUT GATE
		allStops.put("3267", "3267"); // VICTORIA PARK AV / I.B.M.
		allStops.put("1934", "1934"); // DON MILLS RD / STEELES AV
		allStops.put("5124", "5124"); // BUR OAK AV / FRED MCLAREN BLVD
		allStops.put("3268", "3268"); // VICTORIA PARK AV / TELSON RD
		allStops.put("5126", "5126"); // BUR OAK AV / FRED MCLAREN BLVD
		allStops.put("1938", "1938"); // DON MILLS RD / SIMONSTON BLVD
		allStops.put("5121", "5121"); // VALLEYWOOD DR STOP # 5121
		allStops.put("5122", "5122"); // VICTORIA PARK AV / STEELCASE RD
		allStops.put("5123", "5123"); // WOODBINE AV STOP # 5123
		allStops.put("3467", "3467"); // FOREST DR / HARMONIA CRES
		allStops.put("5451", "5451"); // REEVES WAY BLVD / JOSEPH TODD AV
		allStops.put("3465", "3465"); // WOODBRIDGE AV / FOREST DR
		allStops.put("3464", "3464"); // WOODBRIDGE AV / MOONSTONE PL
		allStops.put("3463", "3463"); // WOODBRIDGE AV / KIPLING AV
		allStops.put("7090", "7090"); // SYKES RD / MCGREGOR FARM TRAIL
		allStops.put("3461", "3461"); // WOODBRIDGE AV STOP # 3461
		allStops.put("3460", "3460"); // WOODBRIDGE AV / CLARENCE ST
		allStops.put("6351", "6351_merged_3513003"); // JANE ST / LANGSTAFF RD
		allStops.put("5435", "5435"); // TENTH LINE / KATHERINE CRES
		allStops.put("3468", "3468"); // FOREST DR / KAISER DR
		allStops.put("1582", "1582"); // RODICK RD / EYER DR
		allStops.put("7156", "7156"); // KING ST / VIVIAN CREEK RD
		allStops.put("2490", "2490"); // YONGE ST STOP # 2490
		allStops.put("1580", "1580"); // RODICK RD / CALVERT RD
		allStops.put("1193", "1193"); // WELLINGTON ST / MURRAY DR
		allStops.put("5439", "5439"); // REEVES WAY BLVD / HOOVER PARK DR
		allStops.put("7230", "7230"); // WOODBINE AV / GILLINGS ST
		allStops.put("7153", "7153"); // MURRELL BLVD / MANOR HAMPTON ST
		allStops.put("7152", "7152"); // MURRELL BLVD / SLATER CT
		allStops.put("2407", "2407"); // BLOOMINGTON RD / RED CARDINAL TRL
		allStops.put("7018", "7018"); // THE GORE RD / GARDENBROOKE TRL
		allStops.put("7019", "7019"); // THE GORE RD / STRATHDALE RD
		allStops.put("7016", "7016"); // COTTRELLE BLVD / THORNDALE RD
		allStops.put("7017", "7017"); // COTTRELLE BLVD / THE GORE RD
		allStops.put("7014", "7014"); // COTTRELLE BLVD / CLARKVIEW DR
		allStops.put("1585", "1585"); // ROUGE BANK DR / RUSSELL JARVIS DR
		allStops.put("7012", "7012"); // BAYVIEW AV STOP # 7012
		allStops.put("5453", "5453"); // REEVES WAY BLVD / RICHARD UNDERHILL
		allStops.put("1738", "1738"); // YONGE ST / EDWARD ST
		allStops.put("1068", "1068"); // JOHN ST / ROCKINGHAM CRT
		allStops.put("1731", "1731"); // MAJOR MACKENZIE DR / MCNAUGHTON RD
		allStops.put("5231", "5231"); // BATHURST ST / AUGUSTINE AV
		allStops.put("1732", "1732"); // HENDERSON DR / CARUSO GDNS
		allStops.put("5234", "5234"); // BAYVIEW AV / WHITELAW CRT
		allStops.put("5235", "5235"); // BAYVIEW AV / FAIRFIELD PL
		allStops.put("5236", "5236"); // BATHURST ST / STOCKDALE CRES
		allStops.put("1736", "1736"); // YONGE ST / EDWARD ST
		allStops.put("3895", "3895"); // THORNHILL WOODS DR / COLTRANE DR
		allStops.put("9808", "9808_merged_3513094"); // YONGE ST / EAGLE ST
		allStops.put("1195", "1195"); // WELLINGTON ST / HAIDA DR
		allStops.put("6788", "6788"); // HIGHWAY 7 / ALLSTATE PKWY
		allStops.put("2586", "2586"); // DAVIS DR / HOWARD RD
		allStops.put("3070", "3070"); // 16TH AV STOP # 3070
		allStops.put("3071", "3071"); // 16TH AV / RED MAPLE RD
		allStops.put("6884", "6884"); // CORNELL ROUGE BLVD / HONEY GLEN AV
		allStops.put("1596", "1596"); // HOLLINGHAM RD / BAYCLIFFE RD
		allStops.put("3074", "3074"); // 16TH AV / FERN AV
		allStops.put("3075", "3075"); // 16TH AV / BAYVIEW AV
		allStops.put("1593", "1593"); // ROXBURY ST / PEARMAIN CRT
		allStops.put("1592", "1592"); // HOLLINGHAM RD / CONISTAN RD
		allStops.put("3078", "3078"); // 16TH AV / WOODBINE AV
		allStops.put("3079", "3079"); // 16TH AV / BUTTONFIELD RD
		allStops.put("2956", "2956"); // MCCALLUM DR / TOMLIN CRES
		allStops.put("2957", "2957"); // MCCALLUM DR / TOMLIN CRES
		allStops.put("2950", "2950"); // MAJOR MACKENZIE DR / HILL ST
		allStops.put("2951", "2951"); // MAJOR MACKENZIE DR / DUFFERIN ST
		allStops.put("6888", "6888"); // MARTIN GROVE RD / LANGSTAFF RD
		allStops.put("2953", "2953"); // MAJOR MACKENZIE DR / DON HEAD VILLAGE
		allStops.put("5344", "5344"); // CANYON HILL AV / LARRATT LANE
		allStops.put("1024", "1024"); // SOUTH PARK RD / PARK COMMON BLVD
		allStops.put("7168", "7168"); // CHRISLEA RD / WESTON RD
		allStops.put("7169", "7169"); // CHRISLEA RD / WESTON RD
		allStops.put("1974", "1974"); // YONGE ST / BRISTOL RD
		allStops.put("1022", "1022"); // SOUTH PARK RD / POND DR
		allStops.put("7162", "7162"); // EDGELEY BLVD STOP # 7162
		allStops.put("7160", "7160"); // EDGELEY BLVD / CIDERMILL AV
		allStops.put("7161", "7161"); // EDGELEY BLVD / PENNSYLVANIA AV
		allStops.put("1029", "1029"); // HIGH TECH RD / RED MAPLE RD
		allStops.put("1028", "1028"); // TIMES AV / GALLERIA PKWY
		allStops.put("7164", "7164"); // PORTAGE PKWY / APPLEWOOD CRES
		allStops.put("7165", "7165"); // PORTAGE PKWY / APPLEWOOD CRES
		allStops.put("6763", "6763"); // BRISTOL RD / MALVERN CRES
		allStops.put("1197", "1197"); // WELLINGTON ST / GEORGE ST
		allStops.put("9709", "9709_merged_3513081"); // HWY 7 / WESTON
		allStops.put("6146", "6146"); // HIGHWAY 7 / SADDLE CREEK DR
		allStops.put("4365", "4365"); // SILVER LINDEN DR / MELVILLE ST
		allStops.put("4367", "4367"); // SILVER LINDEN DR / YUKON DR
		allStops.put("4366", "4366"); // SILVER LINDEN DR / FROBISHER ST
		allStops.put("4361", "4361"); // HIGH TECH RD / FERRIS ST
		allStops.put("1208", "1208"); // AURORA HEIGHTS DR / CRAWFORD ROSE D
		allStops.put("4362", "4362"); // SILVER LINDEN DR / RED MAPLE RD
		allStops.put("1204", "1204"); // COMMERCE VALLEY DR / MINTHORN CRT
		allStops.put("1200", "1200"); // COMMERCE VALLEY DR STOP # 1200
		allStops.put("1202", "1202"); // COMMERCE VALLEY DR STOP # 1202
		allStops.put("5061", "5061"); // MAIN ST / BRISTOL RD
		allStops.put("4270", "4270"); // MAJOR MACKENZIE DR / GLENBOURNE PK
		allStops.put("5457", "5457"); // NINTH LINE / 19TH AV
		allStops.put("5641", "5641"); // NINTH LINE / REEVES WAY BLVD
		allStops.put("5640", "5640"); // NINTH LINE / REEVES WAY BLVD
		allStops.put("5643", "5643"); // CANYON HILL AV / SHAFTSBURY AV
		allStops.put("5642", "5642"); // NINTH LINE / HOOVER PARK RD
		allStops.put("5645", "5645"); // 16TH AV / WILLIAMSON RD
		allStops.put("5644", "5644"); // LARRATT LANE / CANYON CREEK AV
		allStops.put("5647", "5647"); // MAJOR MACKENZIE DR / STONEBRIDGE DR
		allStops.put("5646", "5646"); // MAJOR MACKENZIE DR / STONEBRIDGE DR
		allStops.put("2002", "2002"); // DAVIS DR / LESLIE ST
		allStops.put("3108", "3108"); // MCCOWAN RD / WILFRED MURISON AV
		allStops.put("3109", "3109"); // MCCOWAN RD / 16TH AV
		allStops.put("2003", "2003"); // LESLIE ST / BIRCHWOOD DR
		allStops.put("3107", "3107"); // MCCOWAN RD / TRAIL RIDGE LANE
		allStops.put("3100", "3100"); // MCCOWAN RD / 16TH AV
		allStops.put("3101", "3101"); // MCCOWAN RD / TRAIL RIDGE LANE
		allStops.put("3102", "3102"); // MCCOWAN RD / WILFRED MURISON AV
		allStops.put("3103", "3103"); // MCCOWAN RD / BUR OAK AV
		allStops.put("1111", "1111"); // DENISON ST STOP # 1111
		allStops.put("1110", "1110"); // DENISON ST / KENNEDY RD
		allStops.put("1113", "1113"); // DENISON ST / TEDDINGTON AV
		allStops.put("1444", "1444"); // GLEN SHIELDS AV / NEW SEABURY DR
		allStops.put("1115", "1115"); // DENISON ST STOP # 1115
		allStops.put("1114", "1114"); // FARMSTEAD RD / SHIRLEY DR
		allStops.put("1441", "1441"); // JOHN BUTTON BLVD / CAPTAIN FRANCIS
		allStops.put("1440", "1440"); // GLEN SHIELDS AV / OAKMOUNT CRES
		allStops.put("1119", "1119"); // DENISON ST / BRIMLEY RD
		allStops.put("1118", "1118"); // FARMSTEAD RD / FRANK ENDEAN RD
		allStops.put("1506", "1506"); // 14TH AV / OLD 14TH AV
		allStops.put("1449", "1449"); // JOHN BUTTON BLVD / MELCHIOR CRES
		allStops.put("3284", "3284"); // BATHURST ST / TEEFY AV
		allStops.put("4093", "4093"); // WOODBINE AV / RIVERGLEN DR
		allStops.put("4092", "4092"); // WOODBINE AV / RIVEREDGE DR
		allStops.put("4091", "4091"); // WOODBINE AV / ARLINGTON DR
		allStops.put("4278", "4278"); // ABERDEEN AV / QUEENSTON CRES
		allStops.put("4097", "4097"); // BISCAYNE BLVD / OAKMEADOW BLVD
		allStops.put("4096", "4096"); // BISCAYNE BLVD / ROSELM AV
		allStops.put("4095", "4095"); // BISCAYNE BLVD / WINDOVER DR
		allStops.put("6780", "6780"); // HUNTINGTON RD STOP# 6780
		allStops.put("4099", "4099"); // BISCAYNE BLVD / BESSBOROUGH RD
		allStops.put("4098", "4098"); // BISCAYNE BLVD / BESSBOROUGH RD
		allStops.put("5308", "5308"); // NO FRILLS STOP # 5308
		allStops.put("4046", "4046"); // CENTRE ST / NEW WESTMINSTER DR
		allStops.put("2059", "2059"); // GORHAM ST / HAMILTON ST
		allStops.put("5735", "5735"); // CITYVIEW BLVD / RETREAT BLVD
		allStops.put("5734", "5734"); // CITYVIEW BLVD / LORMEL GATE
		allStops.put("5737", "5737"); // PETER RUPERT AV / DISTRICT AV
		allStops.put("5736", "5736"); // CITYVIEW BLVD / MAJOR MACKENZIE DR
		allStops.put("5731", "5731"); // CANADA DR / SUMMIT DR
		allStops.put("5730", "5730"); // CANADA DR / VELLORE PARK AV
		allStops.put("5733", "5733"); // CITYVIEW BLVD STOP # 5733
		allStops.put("5732", "5732"); // CANADA DR / CITYVIEW BLVD
		allStops.put("6785", "6785"); // HIGHWAY 27 / HIGHWAY 7
		allStops.put("1354", "1354"); // BUR OAK AV / RIDGECREST RD
		allStops.put("5738", "5738"); // PETER RUPERT AV / MAURIER BLVD
		allStops.put("6784", "6784"); // ZENWAY BLVD / HIGHWAY 27
		allStops.put("6468", "6468"); // METRO RD / MARIE ST
		allStops.put("6469", "6469"); // METRO RD / CHURCHILL LANE
		allStops.put("2009", "2009"); // MULOCK DR / ON BOGART CIR
		allStops.put("2035", "2035"); // CLEARMEADOW BLVD / CARRUTHERS AV
		allStops.put("9809", "9809"); // NEWMARKET GO TERMINAL PLATFORM 9
		allStops.put("6959", "6959"); // NAPA VALLEY AV / MONTE CARLO DR
		allStops.put("6460", "6460"); // DALTON RD / ROANOAK RD
		allStops.put("6461", "6461"); // DALTON RD / ROANOAK RD
		allStops.put("9805", "9805"); // YONGE / ORCHARD HEIGHTS
		allStops.put("9804", "9804"); // YONGE / ORCHARD HEIGHTS
		allStops.put("9803", "9803"); // YONGE ST / WELLINGTON ST
		allStops.put("6465", "6465"); // METRO RD / MARIE ST
		allStops.put("6466", "6466"); // METRO RD / HARDWOOD DR
		allStops.put("9800", "9800"); // YONGE / GOLF LINKS
		allStops.put("1086", "1086"); // ESNA PARK DR / ALDEN RD
		allStops.put("4725", "4725"); // NINTH LINE / FINCHAM AV
		allStops.put("3297", "3297"); // BATHURST ST / KING RD
		allStops.put("4851", "4851"); // WOOTTEN WAY / HAMILTON HALL DR
		allStops.put("2300", "2300"); // HARRY WALKER PKWY STOP # 2300
		allStops.put("1061", "1061"); // JOHN ST / DAWN HILL TRL
		allStops.put("4582", "4582"); // THORNHILL WOODS DR / MATISSE TRL
		allStops.put("2303", "2303"); // HARRY WALKER PKWY / DAVIS DR
		allStops.put("3922", "3922"); // KEELE ST STOP # 3922
		allStops.put("3923", "3923"); // KEELE ST / LANGSTAFF RD
		allStops.put("3920", "3920"); // KEELE ST STOP # 3920
		allStops.put("4726", "4726"); // NINTH LINE / WHITE'S HILL AV
		allStops.put("3926", "3926"); // KEELE ST STOP # 3926
		allStops.put("3927", "3927"); // KEELE ST STOP # 3927
		allStops.put("3924", "3924"); // KEELE ST STOP # 3924
		allStops.put("3925", "3925"); // KEELE ST STOP # 3925
		allStops.put("2305", "2305"); // HARRY WALKER PKWY STOP # 2305
		allStops.put("3928", "3928"); // KEELE ST STOP # 3928
		allStops.put("3929", "3929"); // KEELE ST / GANTNER GATE
		allStops.put("2578", "2578_merged_3513093"); // LESLIE ST / MOUNT ALBERT RD
		allStops.put("6405", "6405"); // HONDA BLVD
		allStops.put("6723", "6723"); // MAIN ST / PARK DR
		allStops.put("5656", "5656"); // GAMBLE RD / ROTHBURY RD
		allStops.put("6721", "6721"); // MAIN ST / FAIRVIEW AV
		allStops.put("6720", "6720"); // MAIN ST / WEST LAWN CRES
		allStops.put("6727", "6727"); // STOUFFVILLE RD / WARDEN AV
		allStops.put("6726", "6726"); // STOUFFVILLE RD / KENNEDY RD
		allStops.put("6725", "6725"); // STOUFFVILLE RD / MCCOWAN RD
		allStops.put("4788", "4788"); // RUSSELL JARVIS DR / LEGACY DR
		allStops.put("4787", "4787"); // WOOTTEN WAY / CHURCH ST
		allStops.put("4786", "4786"); // CHURCH ST / BUTTERNUT LANE
		allStops.put("4785", "4785"); // LARKIN AV / SPRAGG CIR
		allStops.put("6728", "6728"); // STOUFFVILLE RD / WOODBINE AV
		allStops.put("4783", "4783"); // JANE ST / INTERCHANGE WAY
		allStops.put("9863", "9863"); // ENTERPRISE BLVD / POST RD
		allStops.put("4781", "4781"); // FOSSIL HILL RD / FIRENZA RD
		allStops.put("4780", "4780"); // FOSSIL HILL RD / DAVOS RD
		allStops.put("5821", "5821"); // DEL FRANCESCO WAY / TREASURE RD
		allStops.put("5820", "5820"); // MAST RD / DEL FRANCESCO WAY
		allStops.put("5823", "5823"); // GRAND VALLEY BLVD / JANE ST
		allStops.put("5822", "5822"); // GRAND VALLEY BLVD / DISCOVERY TRL
		allStops.put("4149", "4149"); // HIGHWAY 7 / HELEN ST
		allStops.put("5824", "5824"); // HIGHWAY 27 / ROYALPARK WAY
		allStops.put("5826", "5826"); // LEMAR RD / CARLSON DR
		allStops.put("5829", "5829"); // ELGIN MILLS RD / JOHN BIRCHALL RD
		allStops.put("6954", "6954"); // NAPA VALLEY AV / AMARONE AV
		allStops.put("4147", "4147"); // HIGHWAY 7 / WOODSTREAM BLVD
		allStops.put("4146", "4146"); // HIGHWAY 7 STOP # 4146
		allStops.put("4141", "4141"); // HIGHWAY 7 / VAUGHAN VALLEY BLVD
		allStops.put("4140", "4140"); // HIGHWAY 7 / HIGHWAY 27
		allStops.put("6955", "6955"); // NAPA VALLEY AV / SUNSETRIDGE
		allStops.put("3856", "3856"); // NORTH RIVERMEDE RD / BRADWICK DR
		allStops.put("3857", "3857"); // NORTH RIVERMEDE RD / CONNIE CRES
		allStops.put("3854", "3854"); // NORTH RIVERMEDE RD / AUDIA CRT
		allStops.put("3855", "3855"); // NORTH RIVERMEDE RD / BRADWICK DR
		allStops.put("3852", "3852"); // RIVERMEDE RD / ORTONA CRT
		allStops.put("3853", "3853"); // NORTH RIVERMEDE RD / RIVERMEDE RD
		allStops.put("3850", "3850"); // RIVERMEDE RD / RAYETTE RD
		allStops.put("3851", "3851"); // RIVERMEDE RD / BOWES RD
		allStops.put("6485", "6485"); // METRO RD / ELMWOOD RD
		allStops.put("3858", "3858"); // NORTH RIVERMEDE RD / LANGSTAFF RD
		allStops.put("3859", "3859"); // LANGSTAFF RD / SPINNAKER WAY
		allStops.put("6965", "6965"); // VAUGHAN MILLS RD / HUMBERVIEW DR
		allStops.put("4497", "4497"); // TOWER HILL RD / YONGE ST
		allStops.put("6916", "6916"); // STANTON AV / WESTON RD
		allStops.put("4822", "4822"); // GATEWAY DR / SKIPTON TRL
		allStops.put("6740", "6740_merged_3513010"); // KESWICK MARKETPLACE STOP # 6740
		allStops.put("5472", "5472"); // KINGSHILL RD / HOLTBY ST
		allStops.put("6099", "6099"); // GREEN LANE CENTRE STOP # 6099
		allStops.put("6098", "6098"); // MCNAUGHTON RD / FALVO ST
		allStops.put("6091", "6091"); // BOXWOOD CRES STOP # 6091
		allStops.put("6090", "6090"); // FAIRVIEW MALL DR / GODSTONE RD
		allStops.put("6093", "6093"); // WELLINGTON ST STOP # 6093
		allStops.put("6092", "6092"); // BUR OAK AV STOP # 6092
		allStops.put("6095", "6095"); // MAJOR MACKENZIE DR / SIR BENSON DR
		allStops.put("5239", "5239"); // MCMASTER AV / HOLLANDVIEW TRL
		allStops.put("6097", "6097"); // MCNAUGHTON RD / FALVO ST
		allStops.put("6096", "6096"); // MAJOR MACKENZIE DR / SIR BENSON DR
		allStops.put("1182", "1182"); // SOUTH PARK RD / TIMES AV
		allStops.put("6659", "6659"); // ROYALPARK WAY / SUNDANCE CRT
		allStops.put("6658", "6658"); // ROYALPARK WAY STOP # 6658
		allStops.put("6657", "6657"); // HIGHWAY 7 / CORNELL CENTRE BLVD
		allStops.put("6656", "6656"); // HIGHWAY 7 / CORNELL CENTRE BLVD
		allStops.put("6655", "6655"); // CONOVER AV / HARTWELL WAY
		allStops.put("6654", "6654"); // MAJOR MACKENZIE DR / WOODBINE AV
		allStops.put("6653", "6653"); // KENNEDY RD / STEELES AV
		allStops.put("6652", "6652"); // 9TH LINE / CHURCH ST
		allStops.put("6651", "6651"); // AUTUMN HILL BLVD / BATHURST ST
		allStops.put("6650", "6650"); // AUTUMN HILL BLVD / BATHURST GLEN DR
		allStops.put("4647", "4647"); // CROSSLAND GATE / FAIRWAY GDNS
		allStops.put("5919", "5919"); // CORNELL CENTRE BLVD / WHITE'S HILL
		allStops.put("9861", "9861_merged_3513007"); // HIGHWAY 7 / KENNEDY RD
		allStops.put("5915", "5915"); // CORNELL CENTRE BLVD / HIGHWAY 7
		allStops.put("5916", "5916"); // CORNELL CENTRE BLVD / HIGHWAY 7
		allStops.put("5910", "5910"); // DONALD COUSENS PKWY / 16TH AV
		allStops.put("5912", "5912"); // CORNELL CENTRE BLVD / WHITE'S HILL
		allStops.put("9861", "9861_merged_3513018"); // HIGHWAY 7 / KENNEDY RD
		allStops.put("2289", "2289"); // LESLIE VALLEY DR / KEMP RD
		allStops.put("2125", "2125"); // ELGIN MILLS RD / EDWARD AV
		allStops.put("6385", "6385"); // JEFFERSON FOREST DR / MANCINI CRES
		allStops.put("6384", "6384"); // SHAFTSBURY AV / CANYON HILL AV
		allStops.put("3678", "3678"); // STEELES AV / ROSSDEAN DR
		allStops.put("6386", "6386"); // JEFFERSON FOREST DR / MAGDALAN CRES
		allStops.put("6381", "6381"); // WILLIAMSON RD / MAPLE RIDGE CRES
		allStops.put("6380", "6380"); // WILLIAMSON RD / 16TH AV
		allStops.put("6383", "6383"); // JEFFERSON SDRD / YONGE ST
		allStops.put("6382", "6382"); // FINCHAM AV / NOEL ST
		allStops.put("4556", "4556"); // NEWBRIDGE AV / GRAND OAK DR
		allStops.put("4557", "4557"); // NEWBRIDGE AV / GROVEWOOD ST
		allStops.put("4554", "4554"); // BOND CRES STOP # 4554
		allStops.put("4555", "4555"); // KING RD / WARREN RD
		allStops.put("6389", "6389"); // STONEHAVEN AV / BEST CIRCLE
		allStops.put("6388", "6388"); // STONEHAVEN AV / BAYVIEW AV
		allStops.put("4550", "4550"); // BLOOMINGTON RD / YONGE ST
		allStops.put("4551", "4551"); // KING RD / KING BLVD
		allStops.put("2543", "2543"); // YONGE ST / THOMPSON DR
		allStops.put("1106", "1106"); // DENISON ST / CLAYTON DR
		allStops.put("2541", "2541"); // YONGE ST / NORTH ST
		allStops.put("2540", "2540"); // MOUNT ALBERT RD / YONGE ST
		allStops.put("2547", "2547"); // YONGE ST / PARKSIDE DR
		allStops.put("2546", "2546"); // YONGE ST / DOANE RD
		allStops.put("2545", "2545"); // YONGE ST / BECKETT AV
		allStops.put("2549", "2549"); // YONGE ST / MAPLE ST
		allStops.put("2548", "2548"); // YONGE ST / CEDAR ST
		allStops.put("1104", "1104"); // DENISON ST STOP # 1104
		allStops.put("2381", "2381"); // NORTH LAKE RD / KAITLIN DR
		allStops.put("2380", "2380"); // NORTH LAKE RD / WILDWOOD AV
		allStops.put("2382", "2382"); // NORTH LAKE RD / LAKELAND CRES
		allStops.put("2387", "2387"); // NORTH LAKE RD / YONGE ST
		allStops.put("3672", "3672"); // STEELES AV / ISLINGTON AV
		allStops.put("2389", "2389"); // LORRIDGE ST / BAYSWATER AV
		allStops.put("2388", "2388"); // ASHFIELD DR / BAYSWATER AV
		allStops.put("5003", "5003"); // KENNEDY RD / BIRCHVIEW LANE
		allStops.put("5002", "5002"); // KENNEDY RD / THE BRIDLE TRL
		allStops.put("5001", "5001"); // KENNEDY RD / CARLTON RD
		allStops.put("5000", "5000"); // KENNEDY RD / AUSTIN DR
		allStops.put("5007", "5007"); // LESLIE ST / BIRCHWOOD DR
		allStops.put("3585", "3585"); // STEELES AV / JEWELL ST
		allStops.put("5005", "5005"); // KENNEDY RD / BUR OAK AV
		allStops.put("3587", "3587"); // STEELES AV / WILLOWDALE BLVD
		allStops.put("2763", "2763"); // BATHURST ST / CANYON HILL AV
		allStops.put("3589", "3589"); // STEELES AV / DUDLEY AV
		allStops.put("2761", "2761"); // BATHURST ST / OXFORD ST
		allStops.put("2760", "2760"); // BATHURST ST / REGENT ST
		allStops.put("2767", "2767"); // SHAFTSBURY AV / BROOKSIDE RD
		allStops.put("2766", "2766"); // SHAFTSBURY AV / OWL RIDGE DR
		allStops.put("2764", "2764"); // BATHURST ST / SHAFTSBURY AV
		allStops.put("3290", "3290"); // BATHURST ST / PEMBERTON RD
		allStops.put("6351", "6351_merged_3513014"); // JANE ST / LANGSTAFF RD
		allStops.put("6271", "6271"); // MARTIN GROVE RD / BRUNELLO GT
		allStops.put("6270", "6270"); // MARTIN GROVE RD / BRUNELLO GT
		allStops.put("4428", "4428"); // BLOOMINGTON RD / ACADEMY DR
		allStops.put("1848", "1848"); // WOOTTEN WAY / RAMONA BLVD
		allStops.put("6275", "6275"); // SNIVELY ST / WOLFSON CRES
		allStops.put("6274", "6274"); // 16TH AV / CACHET WOODS CRT
		allStops.put("6276", "6276"); // METRO RD N / FIRST AV
		allStops.put("6279", "6279"); // RUTHERFORD RD / GRAND TRUNK AV
		allStops.put("1842", "1842"); // LARKIN AV / LEHMAN CRES
		allStops.put("1841", "1841"); // LARKIN AV / MINTLEAF GATE
		allStops.put("1840", "1840"); // LARKIN AV / EASTWOOD CRES
		allStops.put("1847", "1847"); // FINCHAM AV / WOOTTEN WAY
		allStops.put("1846", "1846"); // FINCHAM AV STOP # 1846
		allStops.put("1845", "1845"); // LARKIN AV / FINCHAM AV
		allStops.put("1844", "1844"); // LARKIN AV / SAWYER CRES
		allStops.put("6077", "6077"); // BUR OAK AV / NINTH LINE
		allStops.put("6076", "6076"); // FRONTENAC DR / HIGHWAY 7
		allStops.put("6075", "6075"); // BATHURST ST / MILOS RD
		allStops.put("4959", "4959"); // WESTON RD / MAJOR MACKENZIE DR
		allStops.put("3291", "3291"); // BATHURST ST / MCCALLUM DR
		allStops.put("6072", "6072"); // LEBOVIC CAMPUS DR / ILAN RAMON BLVD
		allStops.put("6071", "6071"); // CROSBY AV / NEWKIRK RD
		allStops.put("4952", "4952"); // PARK AV / TALL PINES TRL
		allStops.put("4953", "4953"); // HAZELTON AV / MAJOR MACKENZIE DR
		allStops.put("4950", "4950"); // MAJOR MACKENZIE DR / YONGE ST
		allStops.put("1109", "1109"); // SHIRLEY DR / WAYSIDE AV
		allStops.put("4956", "4956"); // MAJOR MACKENZIE DR / OLD 17TH AV
		allStops.put("6079", "6079"); // MIDDLEFIELD RD STOP # 6079
		allStops.put("6078", "6078"); // NINTH LINE / SUNSET BLVD
		allStops.put("9731", "9731"); // HWY 7 / LESLIE
		allStops.put("2616", "2616"); // YONGE ST / MILLARD AV
		allStops.put("2615", "2615"); // DAVIS DR / BELFRY DR
		allStops.put("2614", "2614"); // DAVIS DR / CARLSON DR
		allStops.put("9735", "9735"); // HWY 7 / ALLSTATE
		allStops.put("2612", "2612"); // DAVIS DR / ROXBOROUGH RD
		allStops.put("2611", "2611"); // DAVIS DR / BOLTON AV
		allStops.put("2610", "2610"); // DAVIS DR / PROSPECT ST
		allStops.put("9739", "9739"); // HWY 7 / MONTGOMERY
		allStops.put("9738", "9738"); // HWY 7 / MONTGOMERY
		allStops.put("4540", "4540"); // KING RD / DOCTORS LANE
		allStops.put("3869", "3869"); // WESTBURNE DR / MOYAL CRT
		allStops.put("2619", "2619"); // YONGE ST / ST. JOHN'S SDRD
		allStops.put("3255", "3255"); // VICTORIA PARK AV / STEELCASE RD
		allStops.put("4083", "4083"); // CHURCH ST STOP # 4083
		allStops.put("3298", "3298"); // BATHURST ST / PUCCINI DR
		allStops.put("3299", "3299"); // BATHURST ST / LAURIER AV
		allStops.put("5139", "5139"); // RAYMERVILLE DR / BECK DR
		allStops.put("5138", "5138"); // RAYMERVILLE DR / BLACK CHERRY DR
		allStops.put("5137", "5137"); // RAYMERVILLE DR / HICKORY DR
		allStops.put("3295", "3295"); // BATHURST ST / GAMBLE RD
		allStops.put("3296", "3296"); // BATHURST ST / KINGSHILL RD
		allStops.put("1905", "1905"); // KENNEDY RD / DUFFIELD DR
		allStops.put("5133", "5133"); // WOOTTEN WAY / PARKWAY AV
		allStops.put("5132", "5132"); // MCCOWAN RD / SOUTHDALE DR
		allStops.put("5131", "5131"); // BATHURST ST / TOWER HILL RD
		allStops.put("5130", "5130"); // BATHURST ST / HEARTHSIDE AV
		allStops.put("3452", "3452"); // ISLINGTON AV / PINE GROVE RD
		allStops.put("3453", "3453"); // ISLINGTON AV / HAYHOE LANE
		allStops.put("3450", "3450"); // ISLINGTON AV / WILLIS RD
		allStops.put("3451", "3451"); // ISLINGTON AV / HARTMAN AV
		allStops.put("3456", "3456"); // ISLINGTON AV STOP # 3456
		allStops.put("3457", "3457"); // ISLINGTON AV / WYCLIFFE GATE
		allStops.put("3454", "3454"); // ISLINGTON AV / LANGSTAFF RD
		allStops.put("3455", "3455"); // ISLINGTON AV / KILORAN AV
		allStops.put("3458", "3458"); // ISLINGTON AV / ARISTA GATE
		allStops.put("3459", "3459"); // ISLINGTON AV / HUMBERWOOD GATE
		allStops.put("3293", "3293"); // BATHURST ST / MILL ST
		allStops.put("5425", "5425"); // NINTH LINE / ELM AV
		allStops.put("2787", "2787"); // EDGAR AV STOP # 2787
		allStops.put("4089", "4089"); // CHURCH ST / WOODBINE AV
		allStops.put("3402", "3402"); // NAPA VALLEY AV / FOREST FOUNTAIN DR
		allStops.put("6897", "6897"); // DAVOS RD / MONTEVERDE WAY
		allStops.put("1187", "1187"); // WELLINGTON ST / YONGE ST
		allStops.put("7154", "7154"); // KING ST / CHELTONWOOD CT
		allStops.put("7001", "7001"); // VIA CAMPANILE / LA ROCCA AV
		allStops.put("7003", "7003"); // ST FRANCIS AV / CUPOLA CRES
		allStops.put("7002", "7002"); // VIA CAMPANILE / BASILICA DR
		allStops.put("7005", "7005"); // ST FRANCIS AV / POMPEII RD
		allStops.put("7004", "7004"); // ST FRANCIS AV / ST NICHOLAS CRES
		allStops.put("6967", "6967"); // VAUGHAN MILLS RD / ROSELAWN DR
		allStops.put("1184", "1184"); // SOUTH PARK RD / PARK COMMON BLVD
		allStops.put("2004", "2004"); // LESLIE ST / SRIGLEY ST
		allStops.put("3738", "3738"); // PINE VALLEY DR / PINE YORK AV
		allStops.put("4588", "4588"); // THORNHILL WOODS DR / APPLE BLOSSOM
		allStops.put("5336", "5336"); // WEST PROMENADE / NEW WESTMINSTER DR
		allStops.put("7091", "7091"); // VETERANS WAY / BLACKHALL CRES
		allStops.put("6315", "6315"); // WOODSPRING AV / GREEN LANE
		allStops.put("5237", "5237"); // BATHURST ST / MCCLELLAN WAY
		allStops.put("9858", "9858"); // HIGHWAY 7 / CREDITSTONE RD
		allStops.put("7175", "7175"); // DUFFERIN ST / DOLOMITE DR
		allStops.put("7174", "7174"); // DUFFERIN ST / DOLOMITE DR
		allStops.put("3061", "3061"); // RUTHERFORD RD / GREENOCK DR
		allStops.put("3060", "3060"); // RUTHERFORD RD / ROTATIONAL DR
		allStops.put("3067", "3067"); // CARRVILLE RD / PLAISANCE RD
		allStops.put("3066", "3066"); // CARRVILLE RD / AVENUE RD
		allStops.put("7173", "7173"); // DUFFERIN ST / GERRY FITZGERALD DR
		allStops.put("6896", "6896"); // DAVOS RD / VIA AVELLINO RD
		allStops.put("2947", "2947"); // MAJOR MACKENZIE DR / GRAM ST
		allStops.put("6898", "6898"); // POETRY DR / MAJOR MACKENZIE DR
		allStops.put("2945", "2945"); // MAJOR MACKENZIE DR / AVRO RD
		allStops.put("3068", "3068"); // CARRVILLE RD STOP # 3068
		allStops.put("7179", "7179"); // DUFFERIN ST / MARTIN ROSS AV
		allStops.put("2942", "2942"); // MELVILLE AV / CRANSTON PARK AV
		allStops.put("2941", "2941"); // BRANDON GATE DR / MELVILLE AV
		allStops.put("2940", "2940"); // JANE ST / BRANDON GATE DR
		allStops.put("5357", "5357"); // LESLIE ST / MOUNT ALBERT RD
		allStops.put("1051", "1051"); // JOHN ST / BAYVIEW AV
		allStops.put("5355", "5355"); // LESLIE ST / QUEENSVILLE SDRD
		allStops.put("5354", "5354"); // THE QUEENSWAY / CRESTVIEW DR
		allStops.put("5353", "5353"); // DOVEDALE DR / LOWNDES AV
		allStops.put("5352", "5352"); // DOVEDALE DR STOP # 5352
		allStops.put("5351", "5351"); // JOHN WEST WAY / MUNICIPAL DR
		allStops.put("1057", "1057"); // JOHN ST / AILEEN RD
		allStops.put("1058", "1058"); // SPADINA RD / LYTTON BLVD
		allStops.put("1059", "1059"); // JOHN ST / BAYVIEW FAIRWAYS DR
		allStops.put("5359", "5359"); // LESLIE ST / QUEENSVILLE SDRD
		allStops.put("5358", "5358"); // LESLIE ST / MILNE LANE
		allStops.put("1696", "1696"); // RUTHERFORD RD / CONFEDERATION PKWY
		allStops.put("1697", "1697"); // MAJOR MACKENZIE DR STOP # 1697
		allStops.put("1694", "1694"); // RUTHERFORD RD / WESTBURNE DR
		allStops.put("1695", "1695"); // MAJOR MACKENZIE DR / BAYVIEW AV
		allStops.put("1692", "1692"); // RUTHERFORD RD / KEELE ST
		allStops.put("1693", "1693"); // MAJOR MACKENZIE DR / OLD MARKHAM RD
		allStops.put("1690", "1690"); // RUTHERFORD RD / BARRHILL RD
		allStops.put("1691", "1691"); // MAJOR MACKENZIE DR / FRANK ENDEAN R
		allStops.put("5657", "5657"); // GAMBLE RD / HARVEST CRT
		allStops.put("5470", "5470"); // KINGSHILL RD / AUGUSTINE AV
		allStops.put("1698", "1698"); // RUTHERFORD RD / FOREST RUN BLVD
		allStops.put("1699", "1699"); // MAJOR MACKENZIE DR / SUSSEX AV
		allStops.put("1278", "1278"); // DENISON ST / MCCOWAN RD
		allStops.put("1279", "1279"); // CARRVILLE RD / OKANAGAN DR
		allStops.put("4312", "4312"); // DON HEAD VILLAGE BLVD / O'CONNOR CR
		allStops.put("4313", "4313"); // MCCALLUM DR / DON HEAD VILLAGE BLVD
		allStops.put("4314", "4314"); // LANGSTAFF RD / VALERIA BLVD
		allStops.put("4315", "4315"); // EDGELEY BLVD / LANGSTAFF RD
		allStops.put("4316", "4316"); // EDGELEY BLVD / ROMINA DR
		allStops.put("1183", "1183"); // MURRAY DR / NISBET DR
		allStops.put("1270", "1270"); // MARKHAM RD / DENISON ST
		allStops.put("1271", "1271"); // YONGE ST / AURORA HEIGHTS DR
		allStops.put("1272", "1272"); // DENISON ST / MIDDLEFIELD RD
		allStops.put("1273", "1273"); // CARRVILLE RD / AVENUE RD
		allStops.put("1274", "1274"); // DENISON ST / FEATHERSTONE AV
		allStops.put("1275", "1275"); // CARRVILLE RD / MYERS BLVD
		allStops.put("1276", "1276"); // DENISON ST / COPPARD AV
		allStops.put("1277", "1277"); // CARRVILLE RD / AYR RD
		allStops.put("5729", "5729"); // WESTON RD / CANADA DR
		allStops.put("3008", "3008"); // 16TH AV / COUNTRY ESTATES DR
		allStops.put("3378", "3378"); // NEW WESTMINSTER DR / BEVERLEY GLEN
		allStops.put("6418", "6418"); // RIVERWALK DR / ANDRIANA CRES
		allStops.put("7045", "7045"); // VICTORIA PARK AV / SPARKS AV
		allStops.put("5515", "5515_merged_3513015"); // GEORGINA FIRE STATION
		allStops.put("1737", "1737"); // MAJOR MACKENZIE DR / JANE ST
		allStops.put("9877", "9877"); // COMMERCE WESTBOUND
		allStops.put("3119", "3119"); // MARKHAM RD STOP # 3119
		allStops.put("5460", "5460"); // SELWYN RD / HEARTHSIDE AV
		allStops.put("3117", "3117"); // MARKHAM RD / NEW DELHI DR
		allStops.put("3734", "3734"); // PINE VALLEY DR / VILLA PARK DR
		allStops.put("7047", "7047"); // VICTORIA PARK AV / TEMPO AV
		allStops.put("3111", "3111"); // MCCOWAN RD / SOUTHDALE DR
		allStops.put("3110", "3110"); // MCCOWAN RD / MANHATTAN DR
		allStops.put("1472", "1472"); // ALDEN RD / HOOD RD
		allStops.put("6415", "6415"); // COPPER CREEK DR / DONALD COUSENS PK
		allStops.put("1470", "1470"); // ALDEN RD / MCPHERSON ST
		allStops.put("5462", "5462"); // SELWYN RD / GAMBLE RD
		allStops.put("1476", "1476"); // 14TH AV / GOUGH RD
		allStops.put("1477", "1477"); // VILLAGE PKWY / PADGET PL
		allStops.put("1474", "1474"); // ALDEN RD / WARDEN AV
		allStops.put("5723", "5723"); // LESLIE ST STOP # 5723
		allStops.put("3337", "3337"); // RUTHERFORD GO STATION PLATFORM 7
		allStops.put("1478", "1478"); // 14TH AV / BIRCHMOUNT RD
		allStops.put("1479", "1479"); // CARLTON RD / VILLAGE PKWY
		allStops.put("6417", "6417"); // BOX GROVE COLLECTOR / 14TH AV
		allStops.put("2747", "2747"); // CROSBY AV / YONGE ST
		allStops.put("3336", "3336"); // ATKINSON AV / RODEO DR
		allStops.put("1304", "1304"); // WHITE'S HILL AV / BUR OAK AV
		allStops.put("1305", "1305"); // DENISON ST / BIRCHMOUNT RD
		allStops.put("1306", "1306"); // BUR OAK AV / ALMIRA AV
		allStops.put("1307", "1307"); // DENISON ST STOP # 1307
		allStops.put("1300", "1300"); // WHITE'S HILL AV / PASCOE DR
		allStops.put("1301", "1301"); // DENISON ST / CLAYTON DR
		allStops.put("1302", "1302"); // WHITE'S HILL AV / COUNTRY GLEN RD
		allStops.put("1303", "1303"); // DENISON ST STOP # 1303
		allStops.put("6411", "6411"); // YORKLAND ST / BERNARD AV
		allStops.put("7042", "7042"); // VICTORIA PARK AV / GORDON BAKER RD
		allStops.put("1308", "1308"); // BUR OAK AV / DONALD SIM AV
		allStops.put("1309", "1309"); // DENISON ST / WARDEN AV
		allStops.put("6410", "6410"); // YORKLAND ST / SILVERWOOD AV
		allStops.put("5741", "5741"); // PETER RUPERT AV / SANDVALLEY ST
		allStops.put("5742", "5742"); // PETER RUPERT AV / FREEDOM TRL
		allStops.put("2597", "2597"); // DAVIS DR / LONGFORD DR
		allStops.put("5744", "5744"); // DUFFERIN ST / FREEDOM TRL
		allStops.put("5745", "5745"); // DUFFERIN ST / IVY GLEN DR
		allStops.put("5746", "5746"); // DUFFERIN ST / MAURIER BLVD
		allStops.put("5468", "5468"); // BATHURST ST / JEFFERSON SDRD
		allStops.put("5748", "5748"); // DUFFERIN ST / RUTHERFORD RD
		allStops.put("5749", "5749"); // HWY 400 CARPOOL LOT STOP # 5749
		allStops.put("9813", "9813"); // ESNA PARK / STEELES
		allStops.put("4220", "4220"); // DON MILLS RD / VAN HORNE AV
		allStops.put("4221", "4221"); // DON MILLS RD / SENECA HILL DR
		allStops.put("4222", "4222"); // DON MILLS RD / FINCH AV
		allStops.put("3596", "3596"); // WESTON RD / CENTURY PL
		allStops.put("9838", "9838"); // HIGHWAY 7 / CHALMERS RD
		allStops.put("6478", "6478"); // FINCHAM AV STOP # 6478
		allStops.put("3595", "3595"); // STEELES AV / HILDA AV
		allStops.put("3362", "3362"); // NEW WESTMINSTER DR / STEELES AV
		allStops.put("6473", "6473"); // METRO RD / FIRST AV
		allStops.put("9833", "9833"); // HIGHWAY 7 / GALSWORTHY
		allStops.put("6471", "6471"); // METRO RD / LAKE DR
		allStops.put("6470", "6470"); // METRO RD / CHURCHILL LANE
		allStops.put("9836", "9836"); // FINCH GO BUS TERMINAL PLATFORM 1
		allStops.put("9837", "9837"); // HIGHWAY 7 / SOUTH PARK RD
		allStops.put("9834", "9834"); // HIGHWAY 7 / GALSWORTHY DR
		allStops.put("6474", "6474"); // GLENWOODS AV / LOWNDES AV
		allStops.put("5037", "5037"); // WESTON RD / HAWKVIEW BLVD
		allStops.put("3599", "3599"); // STEELES AV / PALM GATE BLVD
		allStops.put("1700", "1700"); // RUTHERFORD RD / DUFFERIN ST
		allStops.put("9710", "9710_merged_3513114"); // HWY 7 / WESTON
		allStops.put("3598", "3598"); // WESTON RD STOP # 3598
		allStops.put("3939", "3939"); // KEELE ST / MCNAUGHTON RD
		allStops.put("3938", "3938"); // KEELE ST / MASTERS AV
		allStops.put("5266", "5266"); // MARTIN GROVE RD / ALBION RD
		allStops.put("3935", "3935"); // KEELE ST STOP # 3935
		allStops.put("3934", "3934"); // KEELE ST / BARRHILL RD
		allStops.put("3937", "3937"); // KEELE ST / RAILWAY ST
		allStops.put("3936", "3936"); // KEELE ST / MAJOR MACKENZIE DR
		allStops.put("3931", "3931"); // KEELE ST / DINA RD
		allStops.put("1702", "1702"); // CARRVILLE RD STOP # 1702
		allStops.put("3933", "3933"); // KEELE ST / KNIGHTSWOOD AV
		allStops.put("3932", "3932"); // KEELE ST / FIELDGATE DR
		allStops.put("5264", "5264"); // RUTHERFORD RD / VELLORE WOODS BLVD
		allStops.put("6718", "6718"); // STOUFFER ST / MAIN ST
		allStops.put("6719", "6719"); // MAIN ST / PALMWOOD GATE
		allStops.put("6716", "6716"); // MILLARD ST / WEST LAWN CRES
		allStops.put("5263", "5263"); // RUTHERFORD RD / VELLORE WOODS BLVD
		allStops.put("6714", "6714"); // MILLARD ST / LANGEN GATE
		allStops.put("6715", "6715"); // MILLARD ST / WINLANE DR
		allStops.put("6712", "6712"); // MILLARD ST / AUTOMALL BLVD
		allStops.put("6713", "6713"); // MILLARD ST / BAKER HILL BLVD
		allStops.put("6710", "6710"); // STOUFFVILLE RD / MCCOWAN RD
		allStops.put("5262", "5262"); // MAJOR MACKENZIE DR / GRAND TRUNK AV
		allStops.put("4138", "4138"); // HIGHWAY 7 / PARKFIELD CRT
		allStops.put("4139", "4139"); // HIGHWAY 7 STOP # 4139
		allStops.put("6762", "6762"); // MAIN ST STOP # 6762
		allStops.put("5261", "5261"); // MAJOR MACKENZIE DR / PETER RUPERT A
		allStops.put("4434", "4434"); // BAYVIEW AV / WOODRIVER RD
		allStops.put("4130", "4130"); // HIGHWAY 7 / KEELE ST
		allStops.put("4131", "4131"); // HIGHWAY 7 / CREDITSTONE RD
		allStops.put("4132", "4132"); // HIGHWAY 7 / JANE ST
		allStops.put("4133", "4133"); // HIGHWAY 7 / EDGELEY BLVD
		allStops.put("4134", "4134"); // HIGHWAY 7 / NOVA STAR DR
		allStops.put("4135", "4135"); // HIGHWAY 7 / ABERDEEN AV
		allStops.put("4136", "4136"); // HIGHWAY 7 / WIGWOSS DR
		allStops.put("4137", "4137"); // HIGHWAY 7 / BRUCE ST
		allStops.put("5692", "5692"); // HIGHWAY 27 / WEST ROYAL GATE BLVD
		allStops.put("5693", "5693"); // KESWICK GARDENS STOP # 5693
		allStops.put("5690", "5690"); // VAUGHAN VALLEY BLVD / STONE RIDGE R
		allStops.put("5691", "5691"); // VAUGHAN VALLEY BLVD / HIGHWAY 7
		allStops.put("5696", "5696"); // WOODSPRING AV / MEMORIAL GARDENS WA
		allStops.put("5697", "5697"); // WOODSPRING AV / WILLIAM BOOTH AV
		allStops.put("5694", "5694"); // WOODSPRING AV / GORD CLELLAND GT
		allStops.put("5695", "5695"); // WOODSPRING AV / RAY SNOW BLVD
		allStops.put("3849", "3849"); // KEELE ST / DONEY CRES
		allStops.put("5698", "5698"); // WOODSPRING AV / ALFRED SMITH WAY
		allStops.put("5699", "5699"); // WOODSPRING AV / BONSHAW AV
		allStops.put("1900", "1900"); // KENNEDY RD / GORVETTE RD
		allStops.put("4430", "4430"); // BATHURST ST / WOODLAND ACRES CRES
		allStops.put("2136", "2136"); // NEWKIRK RD / CENTRE ST
		allStops.put("5304", "5304"); // BAIF BLVD STOP # 5304
		allStops.put("1871", "1871"); // KENNEDY RD / THE FAIRWAYS
		allStops.put("5305", "5305"); // YORKLAND ST / SQUIRE DR
		allStops.put("1067", "1067"); // FRANK ENDEAN RD / FARMSTEAD RD
		allStops.put("1510", "1510"); // 14TH AV / HORSTMAN ST
		allStops.put("1066", "1066"); // JOHN ST / CHESTNUT GATE
		allStops.put("4462", "4462"); // HARRY WALKER PKWY / STELLAR DR
		allStops.put("4044", "4044"); // CENTRE ST / ATKINSON AV
		allStops.put("4045", "4045"); // CENTRE ST / BATHURST ST
		allStops.put("6668", "6668"); // LEGACY DR / COTTONTAIL AV
		allStops.put("4047", "4047"); // CENTRE ST STOP # 4047
		allStops.put("4040", "4040"); // CENTRE ST / THORNBANK RD
		allStops.put("4041", "4041"); // CENTRE ST / OAKBANK RD
		allStops.put("4042", "4042"); // CENTRE ST / ERICA RD
		allStops.put("4043", "4043"); // CENTRE ST / ROSE GREEN DR
		allStops.put("6662", "6662"); // ROYALPARK WAY / SUNDANCE CRT
		allStops.put("6663", "6663"); // ROYALPARK WAY / PANORAMA CRES
		allStops.put("6660", "6660"); // ROYALPARK WAY / HIGHWAY 27
		allStops.put("6661", "6661"); // ROYALPARK WAY / HIGHWAY 27
		allStops.put("4048", "4048"); // CENTRE ST / VAUGHAN BLVD
		allStops.put("4049", "4049"); // CENTRE ST / CONCORD RD
		allStops.put("6664", "6664"); // ROYALPARK WAY STOP # 6664
		allStops.put("4580", "4580"); // CENTRE ST / ATKINSON AV
		allStops.put("4088", "4088"); // GEORGINA ICE PALACE
		allStops.put("5179", "5179"); // UPPER CANADA MALL STOP # 5179
		allStops.put("5961", "5961"); // MAIN ST / MARKET ST
		allStops.put("4463", "4463"); // LESLIE ST / RINGWELL DR
		allStops.put("5963", "5963"); // SRIGLEY ST / CRUSADER WAY
		allStops.put("3363", "3363"); // ISLINGTON AV / NASHVILLE RD
		allStops.put("5966", "5966"); // SRIGLEY ST / ORSI DR
		allStops.put("2134", "2134"); // NEWKIRK RD / CROSBY AV
		allStops.put("2288", "2288"); // LESLIE VALLEY DR / HERRIDGE CIR
		allStops.put("2051", "2051"); // EAGLE ST / DIXON BLVD
		allStops.put("3666", "3666"); // STEELES AV / KIPLING AV
		allStops.put("3662", "3662"); // STEELES AV / GIHON SPRING DR
		allStops.put("2281", "2281"); // PEDERSEN DR / EARL STEWART DR
		allStops.put("2282", "2282"); // HARRY WALKER PKWY STOP # 2282
		allStops.put("2283", "2283"); // HARRY WALKER PKWY / TWINNEY DR
		allStops.put("2284", "2284"); // HARRY WALKER PKWY / DAVIS DR
		allStops.put("2285", "2285"); // LESLIE VALLEY DR / MEADOW LANE
		allStops.put("2286", "2286"); // LESLIE VALLEY DR / VERNON PL
		allStops.put("2287", "2287"); // LESLIE VALLEY DR STOP # 2287
		allStops.put("4549", "4549"); // KEELE ST / VISTA GATE
		allStops.put("4548", "4548"); // BLOOMINGTON RD / ELDERBERRY TRL
		allStops.put("4541", "4541"); // KING RD / BANNER LANE
		allStops.put("4538", "4538"); // KEELE ST / BURTON GRV
		allStops.put("4543", "4543"); // KING RD / WARREN RD
		allStops.put("4542", "4542"); // KING RD / KING BLVD
		allStops.put("4545", "4545"); // KEELE ST / VISTA GATE
		allStops.put("4544", "4544"); // KING RD / DUFFERIN ST
		allStops.put("4547", "4547"); // BLOOMINGTON RD / RED CARDINAL TRL
		allStops.put("4539", "4539"); // KEELE ST / ELIZABETH GRV
		allStops.put("3921", "3921"); // KEELE ST / BOWES RD
		allStops.put("6639", "6639"); // HIGHWAY 7 / EAST BEAVER CREEK
		allStops.put("6797", "6797"); // METRO RD / GOLF RD
		allStops.put("2579", "2579"); // LESLIE ST / WARD AV
		allStops.put("2576", "2576"); // LESLIE ST / MOUNT ALBERT RD
		allStops.put("2577", "2577"); // LESLIE ST / FARR AV
		allStops.put("2574", "2574"); // LESLIE ST / WARD AV
		allStops.put("2575", "2575"); // LESLIE ST STOP # 2575
		allStops.put("4826", "4826"); // ST. JOHN'S SDRD / BAYVIEW AV
		allStops.put("2379", "2379"); // NORTH LAKE RD / FERGUS AV
		allStops.put("4461", "4461"); // RICHMOND HILL CENTRE PLATFORM 8
		allStops.put("4535", "4535"); // KING RD / WILLIAM ST
		allStops.put("2374", "2374"); // SUNSET BEACH RD / PARK CRES
		allStops.put("4927", "4927"); // 16TH AV / CHANCERY RD
		allStops.put("2370", "2370"); // SUNSET BEACH RD / LAKE AV
		allStops.put("2371", "2371"); // SUNSET BEACH RD / PARRY LANE
		allStops.put("2372", "2372"); // SUNSET BEACH RD / ENGLISH OAK DR
		allStops.put("2373", "2373"); // SUNSET BEACH RD / PARK CRES
		allStops.put("3593", "3593"); // STEELES AV STOP # 3593
		allStops.put("4329", "4329"); // EDGELEY BLVD / CORSTATE AV
		allStops.put("2596", "2596"); // DAVIS DR / HILL ST
		allStops.put("3693", "3693"); // ABERDEEN AV / ALLISTON RD
		allStops.put("3597", "3597"); // STEELES AV STOP # 3597
		allStops.put("2591", "2591"); // DAVIS DR / BAYVIEW PKWY
		allStops.put("2592", "2592"); // DAVIS DR STOP # 2592
		allStops.put("2593", "2593"); // DAVIS DR / MAIN ST
		allStops.put("5036", "5036"); // WESTON RD / DAVOS RD
		allStops.put("4530", "4530"); // KEELE ST / ELIZABETH GRV
		allStops.put("5034", "5034"); // RUTHERFORD RD / DUFFERIN ST
		allStops.put("5035", "5035"); // RUTHERFORD RD / CANADA'S WONDERLAND
		allStops.put("2598", "2598"); // DAVIS DR / BARBARA RD
		allStops.put("2599", "2599"); // DAVIS DR / GEORGE ST
		allStops.put("4823", "4823"); // HOLLANDVIEW TRL / STECKLEY ST
		allStops.put("1876", "1876"); // KENNEDY RD / THE BRIDLE TRL
		allStops.put("1877", "1877"); // KENNEDY RD / CARLTON RD
		allStops.put("1874", "1874"); // KENNEDY RD / 16TH AV
		allStops.put("1875", "1875"); // KENNEDY RD / BIRCHVIEW LANE
		allStops.put("4431", "4431"); // LESLIE ST / DAVIS DR
		allStops.put("3696", "3696"); // STEELES AV / FOUNDERS RD
		allStops.put("1870", "1870"); // KENNEDY RD / SCHOOL HOUSE RD
		allStops.put("4432", "4432"); // KENNEDY ST / CORNER RIDGE RD
		allStops.put("2133", "2133"); // NEWKIRK RD / TAYLOR MILLS DR
		allStops.put("4821", "4821"); // HOLLANDVIEW TRL / WOODROOF CRES
		allStops.put("4439", "4439"); // BATHURST ST / HUMBERLAND DR
		allStops.put("4438", "4438"); // LESLIE ST / GREEN LANE
		allStops.put("1878", "1878"); // KENNEDY RD / AUSTIN DR
		allStops.put("1082", "1082"); // ESNA PARK DR STOP # 1082
		allStops.put("4945", "4945"); // QUEENS PLATE DR STOP # 4945
		allStops.put("4944", "4944"); // QUEENS PLATE DR STOP # 4944
		allStops.put("6288", "6288"); // RUTHERFORD RD / ISLINGTON AV
		allStops.put("4940", "4940"); // PARKVIEW VILLAGE STOP # 4940
		allStops.put("4943", "4943"); // HIGHWAY 27 / QUEENS PLATE DR
		allStops.put("4942", "4942"); // NINTH LINE / MAIN ST
		allStops.put("9718", "9718_merged_3513085"); // CENTRE / DUFFERIN
		allStops.put("6597", "6597"); // ELGIN MILLS RD / WOODBINE AV
		allStops.put("6280", "6280"); // RUTHERFORD RD / PLEASANT RIDGE AV
		allStops.put("4948", "4948"); // 14TH AV / MIDDLEFIELD RD
		allStops.put("6282", "6282"); // ZENWAY BLVD / NEW ENTERPRISE WAY
		allStops.put("6042", "6042"); // THE BRIDLE WALK / WILFRED MURISON A
		allStops.put("2119", "2119"); // YORKLAND ST STOP # 2119
		allStops.put("6040", "6040"); // RIDGECREST RD / CASTLEMORE AV
		allStops.put("6041", "6041"); // RIDGECREST RD / BUR OAK AV
		allStops.put("6046", "6046"); // MANHATTAN DR / WALL ST
		allStops.put("6047", "6047"); // MANHATTAN DR / CARLTON RD
		allStops.put("6045", "6045"); // SHORTHILL DR / MANHATTAN DR
		allStops.put("2110", "2110"); // 19TH AV / DELISLE ST
		allStops.put("2111", "2111"); // DEVONSLEIGH BLVD / FALLING RIVER DR
		allStops.put("6048", "6048"); // MINGAY AV / EDWARD JEFFREYS AV
		allStops.put("6049", "6049"); // BUR OAK AV / MINGAY AV
		allStops.put("2114", "2114"); // DEVONSLEIGH BLVD / LARK CRES
		allStops.put("1122", "1122"); // FARMSTEAD RD / INDIGO ST
		allStops.put("2116", "2116"); // YORKLAND ST STOP # 2116
		allStops.put("2117", "2117"); // YORKLAND ST / BERNARD AV
		allStops.put("2622", "2622"); // HUMBERLAND DR / BATHURST ST
		allStops.put("5836", "5836"); // TENTH LINE / MAIN ST
		allStops.put("2620", "2620"); // YONGE ST STOP # 2620
		allStops.put("6984", "6984"); // DAVIS DR / HIGHWAY 404
		allStops.put("5437", "5437"); // HOOVER PARK DR / KRIBS DR
		allStops.put("1614", "1614"); // HOLLINGHAM RD / CONISTAN RD
		allStops.put("4153", "4153"); // HIGHWAY 7 / JANE ST
		allStops.put("5332", "5332"); // PROMENADE TERMINAL PLATFORM 3
		allStops.put("5834", "5834"); // VICTORIA SQUARE BLVD / REFLECTION R
		allStops.put("6982", "6982"); // LESLIE ST STOP # 6982
		allStops.put("1919", "1919"); // LESLIE ST / 16TH AV
		allStops.put("1918", "1918"); // LESLIE ST / HEADFORD AV
		allStops.put("1209", "1209"); // AURORA HEIGHTS DR / FALAN HEIGHTS C
		allStops.put("4151", "4151"); // HIGHWAY 7 / NOVA STAR DR
		allStops.put("6981", "6981"); // DAVIS DR / HARRY WALKER PKWY
		allStops.put("3289", "3289"); // BATHURST ST / WELDRICK RD
		allStops.put("3287", "3287"); // BATHURST ST / SHAW BLVD
		allStops.put("4156", "4156"); // HIGHWAY 7 / BALDWIN AV
		allStops.put("3285", "3285"); // BATHURST ST / BIRCH AV
		allStops.put("6980", "6980"); // DAVIS DR / HARRY WALKER PKWY
		allStops.put("1915", "1915"); // LESLIE ST / MAJOR MACKENZIE DR
		allStops.put("1914", "1914"); // LESLIE ST STOP # 1914
		allStops.put("6483", "6483"); // DALTON RD STOP # 6483
		allStops.put("5833", "5833"); // ELGIN MILLS RD / VICTORIA SQUARE BL
		allStops.put("2113", "2113"); // DEVONSLEIGH BLVD / SWAN CRT
		allStops.put("3449", "3449"); // ISLINGTON AV / THISTLEWOOD AV
		allStops.put("5830", "5830"); // ELGIN MILLS RD / LESLIE ST
		allStops.put("3445", "3445"); // ISLINGTON AV STOP # 3445
		allStops.put("3444", "3444"); // ISLINGTON AV STOP # 3444
		allStops.put("3447", "3447"); // ISLINGTON AV / HIGHWAY 7
		allStops.put("4155", "4155"); // HIGHWAY 7 / KEELE ST
		allStops.put("3441", "3441"); // STEELES AV LOOP STOP # 3441
		allStops.put("3440", "3440"); // ISLINGTON AV / STEELES AV
		allStops.put("3443", "3443"); // ISLINGTON AV STOP # 3443
		allStops.put("2115", "2115"); // DEVONSLEIGH BLVD / ATLAS CRT
		allStops.put("2756", "2756"); // MILL ST / SUGAR MAPLE LANE
		allStops.put("2757", "2757"); // MILL ST / SUGAR MAPLE LANE
		allStops.put("2754", "2754"); // MILL ST / LIBBY BLVD
		allStops.put("2755", "2755"); // MILL ST / WOOD LANE
		allStops.put("2752", "2752"); // WRIGHT ST / HALL ST
		allStops.put("2753", "2753"); // MILL ST / LUCAS ST
		allStops.put("2022", "2022"); // ALEX DONER DR / KIRBY CRES
		allStops.put("2023", "2023"); // ALEX DONER DR / OTTON RD
		allStops.put("2028", "2028"); // CLEARMEADOW BLVD / BARTHOLOMEW DR
		allStops.put("2029", "2029"); // CLEARMEADOW BLVD / DOUBLETREE LANE
		allStops.put("2758", "2758"); // MILL ST / ELLERY DR
		allStops.put("5286", "5286"); // BUR OAK AV / WHITE'S HILL AV
		allStops.put("9707", "9707_merged_3513083"); // HWY 7 / ANSLEY GROVE
		allStops.put("4017", "4017"); // DUFFERIN ST / BEVERLEY GLEN BLVD
		allStops.put("7222", "7222_merged_3513124"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("6920", "6920"); // CITYVIEW BLVD / VENICE GT
		allStops.put("9721", "9721_merged_3513089"); // BATHURST / ATKINSON
		allStops.put("2826", "2826"); // BAYVIEW AV / CARTIER CRES
		allStops.put("3706", "3706"); // STEELES AV STOP # 3706
		allStops.put("7150", "7150"); // MURRELL BLVD / BALEBERRY CR
		allStops.put("6311", "6311"); // COLUMBUS WAY / WARWICK CRES
		allStops.put("6486", "6486"); // METRO RD / ELMWOOD RD
		allStops.put("5091", "5091"); // CROSBY AV / NEWKIRK AV
		allStops.put("5792", "5792"); // VIA ROMANO BLVD / LADY VERONICA LAN
		allStops.put("5244", "5244"); // PEDERSEN DR / KIRKVALLEY CRES
		allStops.put("3613", "3613"); // STEELES AV STOP # 3613
		allStops.put("7015", "7015"); // COTTRELLE BLVD STOP # 7015
		allStops.put("4211", "4211"); // DON MILLS RD / VAN HORNE AV
		allStops.put("4596", "4596"); // PLEASANT RIDGE AV / SEABREEZE AV
		allStops.put("3384", "3384"); // ROYAL ORCHARD BLVD / INVERLOCHY BLV
		allStops.put("5463", "5463"); // SELWYN RD / GAMBLE RD
		allStops.put("2978", "2978"); // MAJOR MACKENZIE DR / MCCOWAN RD
		allStops.put("2979", "2979"); // 16TH AV / ALFRED PATERSON DR
		allStops.put("6868", "6868"); // CORNELL CENTRE BLVD / MORNING DOVE
		allStops.put("6869", "6869"); // KENNEDY RD / BECKETT AV
		allStops.put("7106", "7106"); // HILLCREST MALL STOP # 7106
		allStops.put("3059", "3059"); // RUTHERFORD RD / CREDITSTONE RD
		allStops.put("7108", "7108"); // FIRST COMMERCE DR STOP #7108
		allStops.put("2973", "2973"); // RIDGECREST RD / WILTSHIRE DR
		allStops.put("2970", "2970"); // MAJOR MACKENZIE DR / BAYVIEW AV
		allStops.put("2971", "2971"); // MAJOR MACKENZIE DR / RIDGECREST RD
		allStops.put("3052", "3052"); // VELLORE WOODS BLVD / OSPREY DR
		allStops.put("2977", "2977"); // THE BRIDLE WALK / MAJOR MACKENZIE
		allStops.put("3050", "3050"); // ASHBERRY BLVD / VELLORE WOODS BLVD
		allStops.put("3051", "3051"); // VELLORE WOODS BLVD / SHADETREE CRES
		allStops.put("5362", "5362"); // BISCAYNE BLVD / OAKMEADOW BLVD
		allStops.put("5363", "5363"); // BISCAYNE BLVD / ROSELM AV
		allStops.put("1041", "1041"); // HENDERSON AV / PROCTOR AV
		allStops.put("1040", "1040"); // VALLEYMEDE DR / HAZELMERE DR
		allStops.put("1047", "1047"); // HENDERSON AV / JOHN ST
		allStops.put("1046", "1046"); // VALLEYMEDE DR / SHEILA CRES
		allStops.put("1045", "1045"); // HENDERSON AV / ELGIN ST
		allStops.put("1044", "1044"); // VALLEYMEDE DR / BLACKMORE AV
		allStops.put("4597", "4597"); // PLEASANT RIDGE AV / FIRTREE TRL
		allStops.put("1049", "1049"); // JOHN ST / CANDICE GATE
		allStops.put("1048", "1048"); // VALLEYMEDE DR / STRATHEARN AV
		allStops.put("6475", "6475"); // HWY 27 / LANGSTAFF RD
		allStops.put("1681", "1681"); // GLEN SHIELDS AV / MARITA PL
		allStops.put("2983", "2983"); // 16TH AV / LONGWATER CHASE
		allStops.put("1683", "1683"); // DUFFERIN ST / GLEN SHIELDS AV
		allStops.put("5109", "5109"); // JANE ST / DOUGHTON RD
		allStops.put("1685", "1685"); // DUFFERIN ST STOP # 1685
		allStops.put("1725", "1725"); // MAJOR MACKENZIE DR / KEELE ST
		allStops.put("1689", "1689"); // RUTHERFORD RD / PETER RUPERT AV
		allStops.put("1688", "1688"); // MAJOR MACKENZIE DR / SHIRLEY DR
		allStops.put("5588", "5588"); // PUGSLEY AV / DUNSMORE CRES
		allStops.put("3025", "3025"); // 16TH AV / BERWICK CRES
		allStops.put("3724", "3724"); // PINE VALLEY DR / STRADA DR
		allStops.put("4302", "4302"); // HIGHWAY 7 / MARTIN GROVE RD
		allStops.put("3024", "3024"); // 16TH AV / ELM AV
		allStops.put("4306", "4306"); // VELLORE WOODS BLVD / ROBINS NEST DR
		allStops.put("4305", "4305"); // MELVILLE AV / RUTHERFORD RD
		allStops.put("4304", "4304"); // YONGE ST / OBSERVATORY LANE
		allStops.put("1262", "1262"); // EASTVALE DR / BILLINGSLEY CRES
		allStops.put("4309", "4309"); // YONGE ST / MAY AV
		allStops.put("4308", "4308"); // VAUGHAN MILLS MALL STOP # 4308
		allStops.put("1266", "1266"); // STEELES AV / MARKHAM RD
		allStops.put("1264", "1264"); // EASTVALE DR / STEELES AV
		allStops.put("1911", "1911"); // LESLIE ST / TOPOROWSKI AV
		allStops.put("1242", "1242"); // MARKHAM RD / ELSON ST
		allStops.put("4531", "4531"); // KEELE ST / STATION RD
		allStops.put("3021", "3021"); // 16TH AV / STRATHEARN AV
		allStops.put("5103", "5103"); // WOODBINE AV / CALVERT RD
		allStops.put("3020", "3020"); // 16TH AV / SPADINA RD
		allStops.put("7280", "7280"); // BAYVIEW AV / WORLEY HALL GT
		allStops.put("1913", "1913"); // LESLIE ST STOP # 1913
		allStops.put("3725", "3725"); // PINE VALLEY DR / TALL GRASS TRL
		allStops.put("1912", "1912"); // LESLIE ST / PRINCETON AV
		allStops.put("5106", "5106"); // CASSATA AV / FRANK ENDEAN RD
		allStops.put("3124", "3124"); // MAIN ST MARKHAM / THOMSON CRT
		allStops.put("5107", "5107"); // 19TH AV / DELISLE ST
		allStops.put("5240", "5240"); // LESLIE ST / MULOCK DR
		allStops.put("1469", "1469"); // BUCHANAN DR / SPANHOUSE CRES
		allStops.put("5104", "5104"); // SPADINA RD / CLARENDON DR
		allStops.put("1465", "1465"); // WARDEN AV / GLENCOVE DR
		allStops.put("1464", "1464"); // GLEN SHIELDS AV / RIVIERA DR
		allStops.put("1467", "1467"); // GLENCOVE DR / BUCHANAN DR
		allStops.put("1916", "1916"); // LESLIE ST STOP # 1916
		allStops.put("1461", "1461"); // TOWN CENTRE BLVD / HIGHWAY 7
		allStops.put("1460", "1460"); // GLEN SHIELDS AV / DUFFERIN ST
		allStops.put("1463", "1463"); // WARDEN AV STOP # 1463
		allStops.put("1462", "1462"); // GLEN SHIELDS AV / CHERRY HILLS DR
		allStops.put("1317", "1317"); // DENISON ST / ESNA PARK DR
		allStops.put("1316", "1316"); // BUR OAK AV / GREENSBOROUGH VILLAGE
		allStops.put("1315", "1315"); // DENISON ST STOP # 1315
		allStops.put("1314", "1314"); // BUR OAK AV / ALFRED PATERSON DR
		allStops.put("1313", "1313"); // DENISON ST STOP # 1313
		allStops.put("1312", "1312"); // BUR OAK AV / RIVERLANDS AV
		allStops.put("1311", "1311"); // DENISON ST / HOOD RD
		allStops.put("1310", "1310"); // BUR OAK AV / THE MEADOWS AV
		allStops.put("3276", "3276"); // BATHURST ST / CHABAD GATE
		allStops.put("1319", "1319"); // ESNA PARK DR STOP # 1319
		allStops.put("1318", "1318"); // BUR OAK AV / SWAN PARK RD
		allStops.put("9825", "9825"); // YONGE / SAVAGE
		allStops.put("9824", "9824"); // YONGE / JEFFERSON SDRD
		allStops.put("6444", "6444"); // METRO RD STOP # 6444
		allStops.put("9826", "9826"); // YONGE / SAVAGE
		allStops.put("6910", "6910"); // STANTON AV / SILVER STERLING CRES
		allStops.put("6911", "6911"); // STANTON AV / VIRTUE CRES
		allStops.put("6912", "6912"); // STANTON AV / VIRTUE CRES
		allStops.put("6913", "6913"); // STANTON AV / TRAMMEL DR
		allStops.put("4234", "4234"); // DON MILLS RD / FRESHMEADOW DR
		allStops.put("6918", "6918"); // CANADA DR / VELLORE PARK AV
		allStops.put("4232", "4232"); // DON MILLS RD / CLIFFWOOD RD
		allStops.put("4231", "4231"); // DON MILLS RD / MOGUL DR
		allStops.put("3448", "3448"); // ISLINGTON AV / WOODBRIDGE AV
		allStops.put("5591", "5591"); // PINE VALLEY DR / GALCAT DR
		allStops.put("5590", "5590"); // CHURCH ST / WOOTTEN WAY
		allStops.put("5592", "5592"); // PINE VALLEY DR / GALCAT DR
		allStops.put("3277", "3277"); // BATHURST ST / CLARK AV
		allStops.put("7077", "7077"); // SHEPPARD AV / HERON'S HILL WAY
		allStops.put("5494", "5494"); // STONY HILL BLVD / HAZELTON AV
		allStops.put("4609", "4609"); // WELLINGTON ST / MCLEOD DR
		allStops.put("1404", "1404"); // CLARK AV / JOSEPH AARON BLVD
		allStops.put("3948", "3948"); // KEELE ST / DRUMMOND DR
		allStops.put("3949", "3949"); // DRUMMOND DR / TREASURE HILL RD
		allStops.put("3446", "3446"); // ISLINGTON AV / PIONEER LANE
		allStops.put("6722", "6722"); // MAIN ST / MILL ST
		allStops.put("6189", "6189"); // KING RD / SCHOMBERG RD
		allStops.put("3940", "3940"); // KEELE ST STOP # 3940
		allStops.put("3941", "3941"); // KEELE ST / DRUMMOND DR
		allStops.put("3942", "3942"); // KEELE ST / TESTON RD
		allStops.put("3943", "3943"); // RAVINEVIEW DR / BEAVERBROOK CRES
		allStops.put("3944", "3944"); // RAVINEVIEW DR / PEAK POINT BLVD
		allStops.put("3945", "3945"); // RAVINEVIEW DR / KIRBY RD
		allStops.put("3946", "3946"); // KEELE ST / TESTON RD
		allStops.put("3947", "3947"); // KEELE ST STOP # 3947
		allStops.put("6709", "6709"); // STOUFFVILLE RD / KENNEDY RD
		allStops.put("6708", "6708"); // STOUFFVILLE RD / WARDEN AV
		allStops.put("5364", "5364"); // BISCAYNE BLVD / WOODBINE AV
		allStops.put("6703", "6703"); // SILVER MAPLE RD / YONGE ST
		allStops.put("3442", "3442"); // ISLINGTON AV / STEELES AV
		allStops.put("1992", "1992"); // MULOCK DR STOP # 1992
		allStops.put("6704", "6704"); // STOUFFVILLE RD / YONGE ST
		allStops.put("6707", "6707"); // STOUFFVILLE RD / WOODBINE AV
		allStops.put("1338", "1338"); // JOHN ST / COTTONWOOD CRT
		allStops.put("2024", "2024"); // ALEX DONER DR / SYKES RD
		allStops.put("4129", "4129"); // HIGHWAY 7 / BOWES RD
		allStops.put("4128", "4128"); // HIGHWAY 7 / NORTH RIVERMEDE RD
		allStops.put("1232", "1232"); // DENISON ST / FEATHERSTONE AV
		allStops.put("6387", "6387"); // JEFFERSON FOREST DR / SHADOW FALLS
		allStops.put("2025", "2025"); // BATHURST ST / KEITH AV
		allStops.put("4122", "4122"); // THE QUEENSWAY / GARDEN AV
		allStops.put("4121", "4121"); // THE QUEENSWAY / SILAS BLVD
		allStops.put("4120", "4120"); // THE QUEENSWAY / PARKVIEW RD
		allStops.put("4127", "4127"); // THE QUEENSWAY / HOLLYWOOD DR
		allStops.put("2026", "2026"); // CLEARMEADOW BLVD / CARRUTHERS AV
		allStops.put("6792", "6792"); // HIGHWAY 7 / MONTGOMERY CT
		allStops.put("4124", "4124"); // THE QUEENSWAY / CAMERON CRES
		allStops.put("2027", "2027"); // CLEARMEADOW BLVD / PLANTATION GATE
		allStops.put("5689", "5689"); // ZENWAY BLVD / VAUGHAN VALLEY BLVD
		allStops.put("5365", "5365"); // WOODBINE AV / RIVERGLEN DR
		allStops.put("3841", "3841"); // JANE ST / RUTHERFORD RD
		allStops.put("5681", "5681"); // MILLARD ST / NINTH LINE
		allStops.put("5680", "5680"); // GLAD PARK AV / MILLARD ST
		allStops.put("5683", "5683"); // HIGHWAY 27 / ROYAL GATE BLVD
		allStops.put("5682", "5682"); // NINTH LINE / RUPERT AV
		allStops.put("4707", "4707"); // CHURCH ST / RUSSELL STOVER CRT
		allStops.put("6153", "6153"); // 15TH SDRD STOP # 6153
		allStops.put("6211", "6211"); // OLD COLONY RD / PICNIC ST
		allStops.put("1092", "1092"); // DENISON ST STOP # 1092
		allStops.put("4192", "4192"); // NEWMARKET GO TERMINAL PLATFORM 11
		allStops.put("2751", "2751"); // DUNLOP ST / YONGE ST
		allStops.put("1050", "1050"); // VALLEYMEDE DR STOP # 1050
		allStops.put("1330", "1330"); // BUR OAK AV / NORTHSIDE RD
		allStops.put("6675", "6675"); // RIVERWALK DR / SELLWOOD LN
		allStops.put("6674", "6674"); // RIVERWALK DR / KENTVIEW CRES
		allStops.put("6677", "6677"); // COPPER CREEK DR / BERNBRIDGE RD
		allStops.put("6676", "6676"); // 14TH AV / VETTISE AV
		allStops.put("6671", "6671"); // ROYALPARK WAY / PANORAMA CRES
		allStops.put("6670", "6670"); // VAUGHAN MILLS RD STOP # 6670
		allStops.put("6673", "6673"); // LANGSTAFF RD / CRESTLAWN GT
		allStops.put("6672", "6672"); // VAUGHAN MILLS RD / ROYALPARK WAY
		allStops.put("6679", "6679"); // KING RD / SPRING HILL DR
		allStops.put("6678", "6678"); // COPPER CREEK DR / BOX GROVE BY PASS
		allStops.put("4057", "4057"); // THORNLODGE DR / CRITTENDEN DR
		allStops.put("4056", "4056"); // JOE DALES DR / THORNLODGE DR
		allStops.put("4055", "4055"); // WALTER DR / THE QUEENSWAY
		allStops.put("4054", "4054"); // WALTER DR STOP # 4054
		allStops.put("4053", "4053"); // LAKE DR / WALTER DR
		allStops.put("4052", "4052"); // LAKE DR / ROBERT ST
		allStops.put("4051", "4051"); // LAKE DR / RAVENSHOE RD
		allStops.put("4050", "4050"); // RAVENSHOE RD / WEST PARK HTS
		allStops.put("7172", "7172"); // DUFFERIN ST / GERRY FITZGERALD DR
		allStops.put("4605", "4605"); // YORKLAND ST / SQUIRE DR
		allStops.put("9841", "9841"); // CEDARLAND DR / WARDEN AV
		allStops.put("4059", "4059"); // RAVENSHOE RD / LAURENDALE AV
		allStops.put("4058", "4058"); // THORNLODGE DR / RAVENSHOE RD
		allStops.put("1617", "1617"); // 14TH AV / CANNING CRT
		allStops.put("5979", "5979"); // ANNA RUSSELL WAY STOP # 5979
		allStops.put("5978", "5978"); // ANNA RUSSELL WAY STOP # 5978
		allStops.put("6219", "6219"); // OLD COLONY RD / NANTUCKET DR
		allStops.put("6936", "6936"); // HOOVER PARK DR / YORK DURHAM LINE
		allStops.put("5465", "5465"); // SELWYN RD / ALPACA AV
		allStops.put("5977", "5977"); // MAIN ST UNIONVILLE / ENTERPRISE BLV
		allStops.put("5975", "5975"); // MARKHAM RD STOP # 5975
		allStops.put("5974", "5974"); // MAPLE SUGAR LAN / PLEASANT RIDGE AV
		allStops.put("7070", "7070"); // VICTORIA PARK AV / PATRICK BLVD
		allStops.put("3611", "3611"); // STEELES AV / FUTURITY GATE
		allStops.put("2299", "2299"); // HARRY WALKER PKWY / KERRISDALE BLVD
		allStops.put("2298", "2298"); // RINGWELL DR / HARRY WALKER PKWY
		allStops.put("3615", "3615"); // STEELES AV / ALNESS ST
		allStops.put("3617", "3617"); // STEELES AV STOP # 3617
		allStops.put("2293", "2293"); // LESLIE VALLEY DR / HERRIDGE CIR
		allStops.put("2292", "2292"); // LESLIE VALLEY DR / KEMP RD
		allStops.put("2291", "2291"); // BAYVIEW PKWY / LESLIE VALLEY DR
		allStops.put("2290", "2290"); // LESLIE VALLEY DR / BAYVIEW PKWY
		allStops.put("2297", "2297"); // RINGWELL DR STOP # 2297
		allStops.put("2296", "2296"); // LESLIE VALLEY DR / LESLIE ST
		allStops.put("2295", "2295"); // LESLIE VALLEY DR / NESBITT RD
		allStops.put("2294", "2294"); // LESLIE VALLEY DR / WARATAH AV
		allStops.put("5368", "5368"); // WEXFORD DR / WOODBINE AV
		allStops.put("6979", "6979"); // BATHURST ST STOP # 6979
		allStops.put("5252", "5252"); // MURRAY DR / YONGE ST
		allStops.put("5773", "5773"); // MIDDLEFIELD RD / HIGHGLEN AV
		allStops.put("1636", "1636"); // WOODBINE AV / CENTURIAN DR
		allStops.put("6939", "6939"); // HOOVER PARK DR / GREENFOREST GR
		allStops.put("4801", "4801"); // MCNAUGHTON RD / KEELE ST
		allStops.put("2561", "2561"); // TOLL RD / BRADFORD ST
		allStops.put("2560", "2560"); // CENTENNIAL AV / TOLL RD
		allStops.put("2562", "2562"); // BRADFORD ST / YONGE ST
		allStops.put("2567", "2567"); // MOUNT ALBERT RD / CONN DR
		allStops.put("5369", "5369"); // WEXFORD DR / LADYBURN DR
		allStops.put("3280", "3280"); // BATHURST ST / FLAMINGO RD
		allStops.put("5901", "5901"); // THOMAS COOK AV / MARC SANTI BLVD
		allStops.put("2369", "2369"); // SUNSET BEACH RD / YONGE ST
		allStops.put("2368", "2368"); // SUNSET BEACH RD / LAKE AV
		allStops.put("2367", "2367"); // SUNSET BEACH RD / PERRY LANE
		allStops.put("2366", "2366"); // SUNSET BEACH RD / DUNN DR
		allStops.put("2365", "2365"); // SUNSET BEACH RD STOP # 2365
		allStops.put("2364", "2364"); // SUNSET BEACH RD / PARK CRES
		allStops.put("2363", "2363"); // SUNSET BEACH RD / PARK CRES
		allStops.put("5293", "5293"); // EARL STEWART DR / BRIDGENORTH DR
		allStops.put("4491", "4491"); // MARTIN GROVE RD / ALBION RD
		allStops.put("2587", "2587"); // DAVIS DR / ASHTON RD
		allStops.put("5028", "5028"); // FAIRLY LAKE GARDENS STOP # 5028
		allStops.put("2585", "2585"); // DAVIS DR / BELFRY DR
		allStops.put("7293", "7293"); // HIGHWAY 7 / WESTON RD
		allStops.put("4333", "4333"); // REGENT ST / ELGIN MILLS RD
		allStops.put("2582", "2582"); // YONGE ST STOP # 2582
		allStops.put("2581", "2581"); // LESLIE ST / GREEN LANE
		allStops.put("2580", "2580"); // LESLIE ST / COLONEL WAYLING BLVD
		allStops.put("5023", "5023"); // ELGIN ST / BAYVIEW PKWY
		allStops.put("5191", "5191"); // HILDA AV / JONATHAN GATE
		allStops.put("5025", "5025"); // BAYVIEW AV / BALLYMORE DR
		allStops.put("5024", "5024"); // LESLIE ST / DAVIS DR
		allStops.put("2589", "2589"); // DAVIS DR / PATTERSON ST
		allStops.put("5026", "5026"); // BAYVIEW AV / HOLLANDVIEW TRL
		allStops.put("4440", "4440"); // ELGIN MILLS RD / SHIRLEY DR
		allStops.put("1860", "1860"); // MAIN ST MARKHAM / STATION ST
		allStops.put("1863", "1863"); // SNIDER DR / BACKUS CRT
		allStops.put("1862", "1862"); // BULLOCK DR / SNIDER DR
		allStops.put("4444", "4444"); // ELGIN MILLS RD / ENFORD RD
		allStops.put("3729", "3729"); // PINE VALLEY DR / GARVIEW CRT
		allStops.put("4446", "4446"); // BATHURST ST / HUMBERLAND DR
		allStops.put("1866", "1866"); // WILLIAM BERCZY BLVD / GABLE AV
		allStops.put("1869", "1869"); // WILLIAM BERCZY BLVD / WINSTON CASTL
		allStops.put("1868", "1868"); // WILLIAM BERCZY BLVD / CASTLEMORE AV
		allStops.put("3726", "3726"); // PINE VALLEY DR / HIGHWAY 7
		allStops.put("3727", "3727"); // PINE VALLEY DR / ROYAL GARDEN BLVD
		allStops.put("3722", "3722"); // PINE VALLEY DR / STEELES AV
		allStops.put("3723", "3723"); // PINE VALLEY DR / HANLAN RD
		allStops.put("4930", "4930"); // REDSTONE RD / PRINCETON AV
		allStops.put("4931", "4931"); // LESLIE ST / ELGIN MILLS RD
		allStops.put("4932", "4932"); // LESLIE ST STOP # 4932
		allStops.put("4933", "4933"); // LESLIE ST STOP # 4933
		allStops.put("4934", "4934"); // ELGIN WEST C.C. STOP # 4934
		allStops.put("4935", "4935"); // SHAFTSBURY AV / PAINTED ROCK AV
		allStops.put("4680", "4680"); // GREEN LANE / YONGE ST
		allStops.put("4681", "4681"); // YONGE ST / VALHALLA CRT
		allStops.put("4938", "4938"); // LANGSTAFF RD / BALDING BLVD
		allStops.put("4939", "4939"); // LANGSTAFF RD / PINE VALLEY DR
		allStops.put("4688", "4688"); // YONGE ST / NOTTINGHAM DR
		allStops.put("4689", "4689"); // YONGE ST / RIDGE RD
		allStops.put("2109", "2109"); // 19TH AV / ROCHESTER HILL ST
		allStops.put("6059", "6059"); // DIMARINO DR / LADY FENYROSE AV
		allStops.put("6058", "6058"); // VALLEY VISTA DR / BATHURST ST
		allStops.put("6055", "6055"); // MINGAY AV / 16TH AV
		allStops.put("6054", "6054"); // MINGAY AV / EDWARD JEFFREYS AV
		allStops.put("6057", "6057"); // ILAN RAMON AV / VALLEY VISTA DR
		allStops.put("6056", "6056"); // ILAN RAMON BLVD / GESHER CRES
		allStops.put("6051", "6051"); // ROY RAINEY AV / MAJOR MACKENZIE DR
		allStops.put("6050", "6050"); // ROY RAINEY AV / CASTLEMORE AV
		allStops.put("6053", "6053"); // MINGAY AV / BUR OAK AV
		allStops.put("6052", "6052"); // MINGAY AV / FRED MCLAREN BLVD
		allStops.put("5115", "5115"); // HIGHWAY 27 / NICKEL GATE
		allStops.put("5114", "5114"); // WARDEN AV STOP # 5114
		allStops.put("6500", "6500"); // DONALD COUSENS PKWY / DELRAY DR
		allStops.put("2639", "2639"); // BOND CRES STOP # 2639
		allStops.put("5113", "5113"); // APPLE CREEK BLVD / WARDEN AV
		allStops.put("5112", "5112"); // BAYCLIFFE RD / WARDEN AV
		allStops.put("2635", "2635"); // KINGSHILL RD / LONGWOOD AV
		allStops.put("2637", "2637"); // NEWBRIDGE AV / GRAND OAK DR
		allStops.put("5119", "5119"); // HUMBER COLLEGE BLVD / HIGHWAY 27
		allStops.put("5118", "5118"); // FINCH AV / HIGHWAY 27
		allStops.put("6951", "6951"); // HUMBER COLLEGE STOP # 6951
		allStops.put("6729", "6729"); // STOUFFVILLE RD / LESLIE ST
		allStops.put("5256", "5256"); // BED BATH BEYOND STOP # 5256
		allStops.put("3393", "3393"); // ROYAL ORCHARD BLVD / BLUE SPRUCE LA
		allStops.put("5292", "5292"); // SILVER LINDEN DR / GRASSLANDS AV
		allStops.put("3438", "3438"); // ISLINGTON AV STOP # 3438
		allStops.put("6069", "6069"); // CROSBY AV / BAYVIEW AV
		allStops.put("4936", "4936"); // LANGSTAFF RD / PINE VALLEY DR
		allStops.put("1240", "1240"); // DENISON ST / MARKHAM RD
		allStops.put("3430", "3430"); // ISLINGTON AV / HIGHWAY 7
		allStops.put("3431", "3431"); // SIMONSTON BLVD / CHUMLEIGH CRES
		allStops.put("3432", "3432"); // ISLINGTON AV / LEGION COURT RD
		allStops.put("3433", "3433"); // SIMONSTON BLVD / CHUMLEIGH CRES
		allStops.put("3434", "3434"); // ISLINGTON AV STOP # 3434
		allStops.put("3435", "3435"); // SIMONSTON BLVD / SNOWSHOE CRES
		allStops.put("3436", "3436"); // ISLINGTON AV STOP # 3436
		allStops.put("3437", "3437"); // SIMONSTON BLVD / FLOWERVALE RD
		allStops.put("2741", "2741"); // REDSTONE RD / BAYVIEW AV
		allStops.put("2740", "2740"); // REDSTONE RD / FRANK ENDEAN RD
		allStops.put("4590", "4590"); // THORNHILL WOODS DR / AUTUMN HILL BL
		allStops.put("2742", "2742"); // CROSBY AV / NEAL DR
		allStops.put("4848", "4848"); // PARKWAY AV / PARAMOUNT RD
		allStops.put("4849", "4849"); // PARKWAY AV / SIR BEDEVERE PL
		allStops.put("2031", "2031"); // DOUBLETREE LANE / JORDANRAY BLVD
		allStops.put("2030", "2030"); // DOUBLETREE LANE / AUSTINPAUL DR
		allStops.put("4844", "4844"); // LARKIN AV / EASTWOOD CRES
		allStops.put("4845", "4845"); // LARKIN AV / BRYANT RD
		allStops.put("4846", "4846"); // TIERS GATE / LARKIN AV
		allStops.put("4847", "4847"); // TIERS GATE / LARKIN AV
		allStops.put("4841", "4841"); // WORTHINGTON AV / ASHFIELD DR
		allStops.put("2039", "2039"); // ALEX DONER DR / BRIMSON DR
		allStops.put("4843", "4843"); // LARKIN AV / MINTLEAF GATE
		allStops.put("6871", "6871_merged_3513072"); // HIGHWAY 48 / LAKE RIDGE RD
		allStops.put("4937", "4937"); // LANGSTAFF RD / BALDING BLVD
		allStops.put("3910", "3910"); // CONFEDERATION PKWY / DUFFERIN HILL
		allStops.put("9814", "9814"); // GORDON BAKER / MCNICOLL
		allStops.put("5254", "5254"); // WELLINGTON ST / WELLS ST
		allStops.put("5401", "5401"); // HIGH ST / MIDDLE ST
		allStops.put("5203", "5203"); // KEELE ST / PEAK POINT BLVD
		allStops.put("5205", "5205"); // LOBLAWS STOP # 5205
		allStops.put("5204", "5204"); // KEELE ST / PEAK POINT BLVD
		allStops.put("5206", "5206"); // WHITE'S HILL AV / WALKERVILLE RD
		allStops.put("5199", "5199"); // BUR OAK AV / NUTHATCH LANE
		allStops.put("5760", "5760"); // DENISON ST / EASTVALE DR
		allStops.put("3545", "3545"); // MARTIN GROVE RD / SICILIA ST
		allStops.put("1618", "1618"); // MAJOR MACKENZIE DR / WOODBINE AV
		allStops.put("3543", "3543"); // MARTIN GROVE RD / DOLORES CRES
		allStops.put("3235", "3235"); // VALLEYWOOD DR STOP # 3235
		allStops.put("3548", "3548"); // MARTIN GROVE RD / CONDOTTI DR
		allStops.put("5255", "5255"); // COSTCO STOP # 5255
		allStops.put("9719", "9719_merged_3513112"); // CENTRE / DUFFERIN
		allStops.put("5195", "5195"); // SUNSET BEACH RD / YONGE ST
		allStops.put("4420", "4420"); // BAYVIEW AV / PENROSE ST
		allStops.put("5194", "5194"); // WORTHINGTON AV / WOOD RIM DR
		allStops.put("1964", "1964"); // BATHURST ST / TEEFY AV
		allStops.put("1966", "1966"); // BATHURST ST / AUTUMN HILL BLVD
		allStops.put("3069", "3069"); // CARRVILLE RD / YONGE ST
		allStops.put("2965", "2965"); // MAJOR MACKENZIE DR / BAKER AV
		allStops.put("2964", "2964"); // MAJOR MACKENZIE DR / YONGE ST
		allStops.put("1615", "1615"); // 14TH AV / TILLIE SQ
		allStops.put("2961", "2961"); // MAJOR MACKENZIE DR / HARDING BLVD
		allStops.put("2960", "2960"); // MAJOR MACKENZIE DR STOP # 2960
		allStops.put("2963", "2963"); // MAJOR MACKENZIE DR / ATKINSON ST
		allStops.put("2962", "2962"); // MAJOR MACKENZIE DR / ARNOLD CRES
		allStops.put("1780", "1780"); // MILLARD ST / LINDEN LANE
		allStops.put("1781", "1781"); // MILLARD ST / IRONWOOD CRES
		allStops.put("1782", "1782"); // MILLARD ST / BAYBERRY ST
		allStops.put("1783", "1783"); // MILLARD ST / BRAMBLE CRES
		allStops.put("2969", "2969"); // MAJOR MACKENZIE DR / SUSSEX AV
		allStops.put("2968", "2968"); // MAJOR MACKENZIE DR / ESSEX AV
		allStops.put("1786", "1786"); // MAIN ST / BLAKE ST
		allStops.put("1787", "1787"); // MAIN ST / CHARLES ST
		allStops.put("3049", "3049"); // ASHBERRY BLVD / AVOCET DR
		allStops.put("7112", "7112"); // MOUNT ALBERT RD STOP # 7112
		allStops.put("7111", "7111"); // MOUNT ALBERT RD STOP # 7111
		allStops.put("7110", "7110"); // KENNEDY ST / WINDHAM TRAIL
		allStops.put("5193", "5193"); // BLOOMINGTON RD / BLOOMFIELD TRL
		allStops.put("7115", "7115"); // KEELE ST / MALOY ST
		allStops.put("7114", "7114"); // LESLIE ST STOP #7114
		allStops.put("6877", "6877"); // CORNELL ROUGE BLVD / WHITE'S HILL A
		allStops.put("6876", "6876"); // CORNELL CENTRE AV / GAS LAMP LN
		allStops.put("6875", "6875"); // WHITE'S HILL AV / CORNELL CENTRE BL
		allStops.put("1963", "1963"); // BATHURST ST / BIRCH ST
		allStops.put("6872", "6872"); // SOUTH TOWN CENTRE BLVD / CLEGG RD
		allStops.put("3047", "3047"); // DAVOS RD / LUCERNE DR
		allStops.put("6870", "6870"); // KENNEDY RD / WILFRED MURISON AV
		allStops.put("2100", "2100"); // YORKLAND ST STOP # 2100
		allStops.put("1078", "1078"); // JOHN ST / WOODBINE AV
		allStops.put("1079", "1079"); // SHIRLEY DR / VENTURE AV
		allStops.put("1076", "1076"); // JOHN ST STOP # 1076
		allStops.put("1077", "1077"); // SHIRLEY DR / REDSTONE RD
		allStops.put("1074", "1074"); // JOHN ST / STEELCASE RD
		allStops.put("5376", "5376"); // METRO RD / WOODBINE AV
		allStops.put("7072", "7072"); // VICTORIA PARK AV / SHEPPARD AV
		allStops.put("5370", "5370"); // NATANYA BLVD / VERONA CRES
		allStops.put("5373", "5373"); // CHURCH ST / CIRCLE RIDGE DR
		allStops.put("5372", "5372"); // CHURCH ST STOP # 5372
		allStops.put("7290", "7290"); // HIGHWAY 7 / ANSLEY GROVE RD
		allStops.put("1678", "1678"); // MAJOR MACKENZIE DR / NICHOLS BLVD
		allStops.put("1679", "1679"); // GLEN SHIELDS AV / BOYNE HIGHLANDS C
		allStops.put("1674", "1674"); // MARKLAND ST / BARTLETT RD
		allStops.put("1676", "1676"); // MARKLAND ST / MAJOR MACKENZIE DR
		allStops.put("1677", "1677"); // GLEN SHIELDS AV / CROOKED STICK RD
		allStops.put("1670", "1670"); // HILLMOUNT RD / HOPECREST RD
		allStops.put("1671", "1671"); // GLEN SHIELDS AV / QUAKER RIDGE RD
		allStops.put("1672", "1672"); // HILLMOUNT RD / MARKLAND ST
		allStops.put("1673", "1673"); // GLEN SHIELDS AV / POINT O'WOODS DR
		allStops.put("1094", "1094"); // DENISON ST STOP # 1094
		allStops.put("1095", "1095"); // ELGIN MILLS RD / GOODE ST
		allStops.put("1096", "1096"); // DENISON ST / HOOD RD
		allStops.put("1097", "1097"); // ELGIN MILLS RD / MELBOURNE DR
		allStops.put("1090", "1090"); // ESNA PARK DR STOP # 1090
		allStops.put("1091", "1091"); // ELGIN MILLS RD / LESLIE ST
		allStops.put("4338", "4338"); // REGENT ST / BRIDEWELL CRES
		allStops.put("4339", "4339"); // HIGH TECH RD / NAHANNI DR
		allStops.put("4336", "4336"); // REGENT ST / FALKLAND PL
		allStops.put("4337", "4337"); // REGENT ST / ELLSWORTH AV
		allStops.put("4334", "4334"); // REGENT ST / OXFORD ST
		allStops.put("4335", "4335"); // REGENT ST / OATLANDS CRES
		allStops.put("4332", "4332"); // HIGH TECH RD / FAR NIENTE ST
		allStops.put("2552", "2552"); // QUEENSVILLE SDRD / YONGE ST
		allStops.put("4330", "4330"); // ELLERY DR / WILLETT CRES
		allStops.put("4331", "4331"); // VAUGHAN MILLS RD / THOMSON CREEK BL
		allStops.put("3135", "3135"); // MAIN ST MARKHAM / HIGHWAY 7
		allStops.put("5182", "5182"); // THE QUEENSWAY / PINE BEACH DR
		allStops.put("6399", "6399"); // WOOTTEN WAY / FINCHAM AV
		allStops.put("2058", "2058"); // WATER ST / DOUG DUNCAN DR
		allStops.put("1482", "1482"); // 14TH AV STOP # 1482
		allStops.put("3139", "3139"); // MARKHAM RD STOP # 3139
		allStops.put("6014", "6014"); // HARDING BLVD / BRILLINGER ST
		allStops.put("4100", "4100"); // BISCAYNE BLVD / HODGINS AV
		allStops.put("6791", "6791"); // HIGHWAY 7 / WOODBINE AV
		allStops.put("1246", "1246"); // ELSON ST / JORDANA DR
		allStops.put("7292", "7292"); // HIGHWAY 7 / WESTON RD
		allStops.put("5183", "5183"); // THE QUEENSWAY / IRENE DR
		allStops.put("5356", "5356"); // LESLIE ST / MILNE LANE
		allStops.put("5192", "5192"); // HILDA AV / JONATHAN GATE
		allStops.put("1481", "1481"); // CARLTON RD / FRED VARLEY DR
		allStops.put("4643", "4643"); // SANDFORD ST / DON MOR DR
		allStops.put("1410", "1410"); // CLARK AV / NEW WESTMINSTER DR
		allStops.put("1411", "1411"); // KENNEDY RD / CASTLEMORE AV
		allStops.put("1412", "1412"); // CLARK AV STOP # 1412
		allStops.put("1413", "1413"); // MAJOR MACKENZIE DR / ANGUS GLEN BLV
		allStops.put("1414", "1414"); // CLARK AV / SOUTH PROMENADE
		allStops.put("1415", "1415"); // CALVERT RD / THACKERAY CRT
		allStops.put("1416", "1416"); // CLARK AV / BATHURST ST
		allStops.put("1417", "1417"); // CALVERT RD / TOWNSON RD
		allStops.put("1322", "1322"); // BUR OAK AV / WILLIAMSON RD
		allStops.put("1323", "1323"); // ESNA PARK DR STOP # 1323
		allStops.put("1320", "1320"); // BUR OAK AV / STALMASTER RD
		allStops.put("1321", "1321"); // ESNA PARK DR / ALDEN RD
		allStops.put("1326", "1326"); // BUR OAK AV / MARKHAM RD
		allStops.put("1327", "1327"); // JOHN ST / WOODBINE AV
		allStops.put("1324", "1324"); // BUR OAK AV / ANDERSON AV
		allStops.put("1325", "1325"); // ESNA PARK DR STOP # 1325
		allStops.put("1328", "1328"); // BUR OAK AV / WILLIAMSON RD
		allStops.put("1329", "1329"); // JOHN ST / NOLAN CRT
		allStops.put("6210", "6210"); // OLD COLONY RD STOP # 6210
		allStops.put("1621", "1621"); // 14TH AV / NOBLE ST
		allStops.put("6397", "6397"); // WOOTTEN WAY / SIR TRISTRAM PL
		allStops.put("6907", "6907"); // POETRY DR / STANTON AV
		allStops.put("6906", "6906"); // POETRY DR / STORMONT TR
		allStops.put("6905", "6905"); // POETRY DR / STORMONT TR
		allStops.put("9853", "9853"); // HIGHWAY 7 / KEELE ST
		allStops.put("9854", "9854"); // HIGHWAY 7 / KEELE ST
		allStops.put("6902", "6902"); // POETRY DR / GARYSCHOLL RD
		allStops.put("6457", "6457"); // HIGH ST / SNOOKS RD
		allStops.put("9857", "9857"); // HIGHWAY 7 / CREDITSTONE RD
		allStops.put("4202", "4202"); // DON MILLS RD / FRESHMEADOW DR
		allStops.put("9859", "9859"); // VAUGHAN METROPOLITAN CENTRE EASTBOUND
		allStops.put("4200", "4200"); // BERNARD AV / YONGE ST
		allStops.put("5762", "5762"); // DENISON ST / ELSON ST
		allStops.put("5763", "5763"); // ELSON ST / TAWNEY RD
		allStops.put("6909", "6909"); // STANTON AV / SILVER STIRLING CRES
		allStops.put("4205", "4205"); // DON MILLS RD / PEBBLE BYWY
		allStops.put("4252", "4252_merged_3513013"); // EAST GWILLIMBURY GO STATION
		allStops.put("1917", "1917"); // LESLIE ST / GREENHILL AV
		allStops.put("3118", "3118"); // MARKHAM RD / KIRKHAM DR
		allStops.put("7294", "7294"); // HIGHWAY 7 / COMMERCE ST
		allStops.put("2072", "2072"); // GORHAM ST / CARLSON DR
		allStops.put("1620", "1620"); // MARKLAND ST / MAJOR MACKENZIE DR
		allStops.put("5389", "5389_merged_3513079"); // HIGH ST / BURKE ST
		allStops.put("1524", "1524"); // BOXWOOD CRES / 14TH AV
		allStops.put("1525", "1525"); // CARLTON RD / PENNOCK CRES
		allStops.put("1487", "1487"); // CARLTON RD / MCKAY CRES
		allStops.put("1527", "1527"); // CARLTON RD / PENNOCK CRES
		allStops.put("1520", "1520"); // BOXWOOD CRES / BRETTON CIR
		allStops.put("1521", "1521"); // CARLTON RD / POMANDER RD
		allStops.put("1522", "1522"); // BOXWOOD CRES / LANOR CRT
		allStops.put("1523", "1523"); // CARLTON RD / MCCKAY CRES
		allStops.put("6198", "6198"); // FOGAL RD / HIGHWAY 50
		allStops.put("1528", "1528"); // LEGACY DR / ROUGE BANK DR
		allStops.put("1529", "1529"); // CARLTON RD / MILLSTONE CRT
		allStops.put("1258", "1258"); // MIDDLEFIELD RD / DENISON ST
		allStops.put("3077", "3077"); // 16TH AV / CACHET WOODS CRT
		allStops.put("3959", "3959"); // KEELE ST / MCNAUGHTON RD
		allStops.put("3958", "3958"); // KEELE ST STOP # 3958
		allStops.put("2068", "2068"); // GORHAM ST STOP # 2068
		allStops.put("7295", "7295"); // HIGHWAY 7 / COMMERCE ST
		allStops.put("2071", "2071"); // GORHAM ST / EAST HILL CRT
		allStops.put("3953", "3953"); // CRANSTON PARK AV / PRINCETON GATE
		allStops.put("3952", "3952"); // DRUMMOND DR / CRANSTON PARK AV
		allStops.put("3951", "3951"); // DRUMMOND DR / MONTEITH CRES
		allStops.put("3950", "3950"); // DRUMMOND DR / ST. JOAN OF ARC AV
		allStops.put("3957", "3957"); // TESTON RD / KEELE ST
		allStops.put("3956", "3956"); // TESTON RD / ST. JOAN OF ARC AV
		allStops.put("3955", "3955"); // CRANSTON PARK AV / TESTON RD
		allStops.put("3954", "3954"); // CRANSTON PARK AV / ISAAC MURRAY AV
		allStops.put("4116", "4116"); // HIGHCASTLE AV / OLD HOMESTEAD RD
		allStops.put("4117", "4117"); // OLD HOMESTEAD RD / METRO RD
		allStops.put("4114", "4114"); // FERNCROFT DR / HIGHCASTLE AV
		allStops.put("4115", "4115"); // HIGHCASTLE AV / KERFOOT CRES
		allStops.put("4113", "4113"); // METRO RD / FERNCROFT DR
		allStops.put("4110", "4110"); // METRO RD / NIDA DR
		allStops.put("6199", "6199"); // FOGAL RD / HUNTINGTON RD
		allStops.put("4118", "4118"); // METRO RD / CHURCH ST
		allStops.put("4119", "4119"); // THE QUEENSWAY / CEDAR ST
		allStops.put("7080", "7080"); // BETTY ROMAN BLVD / REFLECTION RD
		allStops.put("4592", "4592"); // MAPLE SUGAR LANE / DANIEL REAMAN CR
		allStops.put("1626", "1626"); // WOODBINE AV / MARKLAND ST
		allStops.put("4908", "4908"); // LESLIE ST / WAYNE DR
		allStops.put("7102", "7102"); // LONDON RD / HARRISON DR
		allStops.put("1485", "1485"); // CARLTON RD / PENNOCK CRES
		allStops.put("7103", "7103"); // ROBINSON ST / WATER ST
		allStops.put("9719", "9719_merged_3513084"); // CENTRE / DUFFERIN
		allStops.put("7104", "7104"); // WATER ST / ROBINSON ST
		allStops.put("3820", "3820"); // JANE ST / HIGHWAY 7
		allStops.put("9730", "9730"); // HWY 7 / LESLIE
		allStops.put("2477", "2477"); // YONGE ST / MAY AV
		allStops.put("2077", "2077"); // WATER ST / DOUG DUNCAN DR
		allStops.put("3058", "3058"); // RUTHERFORD RD / JANE ST
		allStops.put("2476", "2476"); // YONGE ST / CLARISSA DR
		allStops.put("7221", "7221_merged_3513078"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("7107", "7107"); // BETTY ROMAN BLVD / BONHEUR RD
		allStops.put("1484", "1484"); // 14TH AV / MCDOWELL GATE
		allStops.put("5012", "5012"); // STONEHAVEN AV / BEST CIR
		allStops.put("6600", "6600"); // BETTY ROMAN BLVD / REFLECTION RD
		allStops.put("6601", "6601"); // BETTY ROMAN BLVD / WOODBINE AV
		allStops.put("6602", "6602"); // WOODBINE AV STOP # 6602
		allStops.put("6603", "6603"); // WOODBINE AV / ELGIN MILLS RD
		allStops.put("6605", "6605"); // MAJOR MACKENZIE DR / COLBORNE AV
		allStops.put("6606", "6606"); // VELLORE WOODS BLVD STOP # 6606
		allStops.put("6607", "6607"); // VELLORE WOODS BLVD STOP # 6607
		allStops.put("6608", "6608"); // DAVOS ROAD / FIORENTINA AV
		allStops.put("6609", "6609"); // DAVOS RD / FOSSIL HILL RD
		allStops.put("6438", "6438"); // METRO RD / HUNTLEY DR
		allStops.put("6866", "6866"); // NINTH LINE / FERNGLEN CRES
		allStops.put("4062", "4062"); // THE QUEENSWAY / JOE DALES DR
		allStops.put("4063", "4063"); // THE QUEENSWAY / WALTER DR
		allStops.put("5944", "5944"); // DAVIS DR / FORD WILSON DR
		allStops.put("5945", "5945"); // MEDALLION BLVD / HIGHWAY 27
		allStops.put("5942", "5942"); // YONGE ST STOP # 5942
		allStops.put("4067", "4067"); // THE QUEENSWAY / BAYVIEW AV
		allStops.put("5940", "5940"); // 16TH AV / BLACK CREEK DR
		allStops.put("5941", "5941"); // 16TH AV / BLACK CREEK DR
		allStops.put("2976", "2976"); // THE BRIDLE WALK / DRAWBRIDGE DR
		allStops.put("5180", "5180"); // THE QUEENSWAY / WYNHURST RD
		allStops.put("5017", "5017"); // MULOCK DR / YONGE ST
		allStops.put("5948", "5948"); // KINGSHILL RD / BATHURST ST
		allStops.put("5949", "5949"); // ROLLINGHILL RD / TOWER HILL RD
		allStops.put("2770", "2770"); // CANYON HILL AV / PALOMINO DR
		allStops.put("4442", "4442"); // ELGIN MILLS RD / BAYVIEW AV
		allStops.put("5780", "5780"); // YONGE ST STOP # 5780
		allStops.put("5781", "5781"); // YONGE ST STOP # 5781
		allStops.put("5019", "5019"); // EAGLE ST / WILLIAM ST
		allStops.put("2499", "2499"); // YONGE ST / LAKE AV
		allStops.put("6863", "6863"); // MAJOR MACKENZIE DR STOP # 6863
		allStops.put("5788", "5788"); // QUEEN FILOMENA AV / GIORDANO WAY
		allStops.put("5789", "5789"); // QUEEN FILOMENA AV / VIA ROMANO BLVD
		allStops.put("1043", "1043"); // HENDERSON AV / CLARK AV
		allStops.put("3601", "3601"); // STEELES AV / EMERALD LANE
		allStops.put("3600", "3600"); // WESTON RD / COLOSSUS DR
		allStops.put("3607", "3607"); // STEELES AV / DUFFERIN ST
		allStops.put("3606", "3606"); // WESTON RD STOP # 3606
		allStops.put("3605", "3605"); // STEELES AV / CONLEY ST
		allStops.put("3604", "3604"); // WESTON RD / ROWNTREE DAIRY RD
		allStops.put("6908", "6908"); // STANTON AV / POETRY DR
		allStops.put("3608", "3608"); // WESTON RD / AVIVA PARK DR
		allStops.put("5360", "5360"); // THE QUEENSWAY / RAVENSHOE RD
		allStops.put("4896", "4896"); // ROYAL ORCHARD BLVD / DORAL GATE
		allStops.put("5038", "5038"); // SHAFTSBURY AV / PAINTED ROCK AV
		allStops.put("5361", "5361"); // BISCAYNE BLVD / HODGINS AV
		allStops.put("2776", "2776"); // HARDING BLVD / KERSEY CRES
		allStops.put("2498", "2498"); // YONGE ST / OLD COLONY RD
		allStops.put("5366", "5366"); // WOODBINE AV / ARLINGTON DR
		allStops.put("2777", "2777"); // HARDING BLVD / ADDISON ST
		allStops.put("2074", "2074"); // GORHAM ST / MURIEL ST
		allStops.put("5367", "5367"); // WOODBINE AV / POLLOCK RD
		allStops.put("6118", "6118"); // PICKERING CRES STOP # 6118
		allStops.put("6119", "6119"); // BAYVIEW AV / NORTH LAKE RD
		allStops.put("9709", "9709_merged_3513109"); // HWY 7 / WESTON
		allStops.put("6114", "6114"); // 14TH AV / ROXBURY ST
		allStops.put("6115", "6115"); // 14TH AV / CHATELAINE DR
		allStops.put("6116", "6116"); // DENISON ST / COXWORTH AV
		allStops.put("6117", "6117"); // DENISON ST / MIDDLEFIELD RD
		allStops.put("6110", "6110"); // RAYMERVILLE DR / CRANDALL DR
		allStops.put("6111", "6111"); // RAYMERVILLE DR / WATERWHEEL ST
		allStops.put("6112", "6112"); // 14TH AV / BOXWOOD CRES
		allStops.put("6113", "6113"); // 14TH AV / BOXWOOD CRES
		allStops.put("7067", "7067"); // VICTORIA PARK AV STOP #7067
		allStops.put("2358", "2358"); // NORTH LAKE RD / FERGUS AV
		allStops.put("2359", "2359"); // NORTH LAKE RD / OLDE BAYVIEW AV
		allStops.put("3894", "3894"); // AUTUMN HILL BLVD / THORNHILL WOODS
		allStops.put("7066", "7066"); // VICTORIA PARK AV STOP #7066
		allStops.put("2352", "2352"); // ASHFIELD DR / YONGE ST
		allStops.put("2353", "2353"); // LAKELAND CRES STOP # 2353
		allStops.put("2351", "2351"); // YONGE ST / HIGH TECH RD
		allStops.put("2356", "2356"); // NORTH LAKE RD / KAITLIN DR
		allStops.put("7065", "7065"); // VICTORIA PARK AV / ALTAIR AV
		allStops.put("2354", "2354"); // LAKELAND CRES / PADDLE GATE
		allStops.put("2355", "2355"); // LAKELAND CRES / SYLVAN CRES
		allStops.put("7282", "7282"); // WILLIAM GRAHAM DR / CRANE ST
		allStops.put("6849", "6849"); // MAJOR MACKENZIE DR / FOSSIL HILL RD
		allStops.put("7064", "7064"); // VICTORIA PARK AV / CLYDESDALE DR
		allStops.put("1488", "1488"); // 14TH AV / NOBLE ST
		allStops.put("7285", "7285"); // JANE ST STOP # 7285
		allStops.put("2991", "2991"); // 16TH AV / FINCHAM AV
		allStops.put("5136", "5136"); // PARKWAY AV / WOOTTEN WAY
		allStops.put("7289", "7289"); // HIGHWAY 7 / PINE VALLEY DR
		allStops.put("7288", "7288"); // HIGHWAY 7 / PINE VALLEY DR
		allStops.put("3322", "3322"); // ATKINSON AV / ROSEDALE HEIGHTS DR
		allStops.put("7062", "7062"); // VICTORIA PARK AV / PLEASANT VIEW DR
		allStops.put("4453", "4453"); // RICHMOND HILL CENTRE PLATFORM 5
		allStops.put("4450", "4450"); // KENNEDY ST / MCGEE CRES
		allStops.put("1898", "1898"); // HARVEST MOON DR / MAITLAND DR
		allStops.put("7061", "7061"); // VICTORIA PARK AV / VAN HORNE AV
		allStops.put("3739", "3739"); // PINE VALLEY DR / VINYL CRT
		allStops.put("4454", "4454"); // RICHMOND HILL CENTRE PLATFORM 6
		allStops.put("3737", "3737"); // PINE VALLEY DR / TALL GRASS TRL
		allStops.put("3736", "3736"); // PINE VALLEY DR / HIGHWAY 7
		allStops.put("3735", "3735"); // PINE VALLEY DR / ROYAL GARDEN BLVD
		allStops.put("7060", "7060"); // VICTORIA PARK AV / VAN HORNE AV
		allStops.put("3733", "3733"); // PINE VALLEY DR / GARVIEW CRT
		allStops.put("3732", "3732"); // PINE VALLEY DR / WILLIS RD
		allStops.put("1892", "1892"); // STEELES AV / PUTNAM GATE
		allStops.put("3730", "3730"); // PINE VALLEY DR / CHANCELLOR DR
		allStops.put("4691", "4691"); // NEWMARKET GO TERMINAL PLATFORM 6
		allStops.put("4922", "4922"); // HIGH TECH RD / FAR NIENTE ST
		allStops.put("4693", "4693"); // YONGE ST / CENTRE ST
		allStops.put("4920", "4920"); // HIGH TECH RD / CAYMUS ST
		allStops.put("2132", "2132"); // NEWKIRK RD STOP # 2132
		allStops.put("4926", "4926"); // 16TH AV / NINTH LINE
		allStops.put("4925", "4925"); // 16TH AV / CHANCERY RD
		allStops.put("2131", "2131"); // NEWKIRK RD / BEECHY DR
		allStops.put("4699", "4699"); // HIGHWAY 7 / WIDEMAN ST
		allStops.put("4929", "4929"); // 16TH AV / ALEXANDER LAWRIE AV
		allStops.put("2138", "2138"); // ESSEX AV / ELMWOOD AV
		allStops.put("2139", "2139"); // ESSEX AV / PALMER AV
		allStops.put("6028", "6028"); // SOUTH UNIONVILLE AV / GEORGE MARTIN
		allStops.put("9839", "9839"); // YONGE ST / REGATTA AV
		allStops.put("1682", "1682"); // MAJOR MACKENZIE DR / LESLIE ST
		allStops.put("6020", "6020"); // BAYVIEW AV / NEWMAN AV
		allStops.put("6021", "6021"); // BAYVIEW AV / BETHESDA SDRD
		allStops.put("6022", "6022"); // BAYVIEW AV / OLD COLONY RD
		allStops.put("6023", "6023"); // BAYVIEW AV / STOUFFVILLE RD
		allStops.put("6024", "6024"); // BAYVIEW AV / 19TH AV
		allStops.put("6025", "6025"); // BAYVIEW AV STOP # 6025
		allStops.put("6026", "6026"); // SOUTH UNIONVILLE AV / REMBRANDT DR
		allStops.put("6027", "6027"); // SOUTH UNIONVILLE AV / MCCOWAN RD
		allStops.put("5181", "5181"); // THE QUEENSWAY / BAYVIEW AV
		allStops.put("5161", "5161"); // REDSTONE RD / MARACA DR
		allStops.put("5162", "5162"); // REDSTONE RD / TOPOROWSKI AV
		allStops.put("5163", "5163"); // GAMBLE RD / LACEWOOD DR
		allStops.put("5164", "5164"); // BATHURST ST STOP # 5164
		allStops.put("5165", "5165"); // DUFFERIN ST / CARAWAY DR
		allStops.put("5166", "5166"); // DUFFERIN ST / MAISON PARC CRT
		allStops.put("4924", "4924"); // 16TH AV / WILLIAMSON RD
		allStops.put("2640", "2640"); // BOND CRES / LITTLESIDE ST
		allStops.put("5169", "5169"); // SUMMERIDGE DR / PLEASANT RIDGE AV
		allStops.put("1686", "1686"); // MAJOR MACKENZIE DR / FORESTWOOD ST
		allStops.put("2645", "2645"); // BOND CRES / LITTLESIDE ST
		allStops.put("4252", "4252"); // EAST GWILLIMBURY GO STATION
		allStops.put("4803", "4803"); // MELVILLE AV / HUDSON DR
		allStops.put("4208", "4208"); // DON MILLS RD / AU LARGE BLVD
		allStops.put("4941", "4941"); // NINTH LINE / SUNSET BLVD
		allStops.put("7186", "7186"); // DUFFERIN ST STOP # 7186
		allStops.put("2749", "2749"); // DUNLOP ST / PUGSLEY AV
		allStops.put("3429", "3429"); // SIMONSTON BLVD / DERSINGHAM CRES
		allStops.put("3428", "3428"); // ISLINGTON AV / WOODBRIDGE AV
		allStops.put("4806", "4806"); // MAJOR MACKENZIE DR / HIGHWAY 48
		allStops.put("3423", "3423"); // SIMONSTON BLVD / THURGATE CRES
		allStops.put("3422", "3422"); // ISLINGTON AV / HARTMAN AV
		allStops.put("3421", "3421"); // SIMONSTON BLVD / GERMAN MILLS RD
		allStops.put("3420", "3420"); // ISLINGTON AV / GAMBLE ST
		allStops.put("3427", "3427"); // SIMONSTON BLVD / DON MILLS RD
		allStops.put("3426", "3426"); // ISLINGTON AV / THISTLEWOOD AV
		allStops.put("3425", "3425"); // SIMONSTON BLVD / WAGGONERS WELLS LA
		allStops.put("7177", "7177"); // DUFFERIN ST / SUPERTEST RD
		allStops.put("6334", "6334"); // MAJOR MACKENZIE RD / VIA RENZO
		allStops.put("6335", "6335"); // GAMBLE RD / COLESBROOK RD
		allStops.put("2000", "2000"); // LESLIE ST / GORHAM ST
		allStops.put("6337", "6337"); // JANE ST / AHMADIYYA AV
		allStops.put("6330", "6330"); // METRO RD / KENNEDY RD
		allStops.put("2007", "2007"); // LESLIE ST STOP # 2007
		allStops.put("6332", "6332"); // BASS PRO MILLS DR / EDGELEY BLVD
		allStops.put("6333", "6333"); // MAJOR MACKENZIE DR / VIA RENZO
		allStops.put("4585", "4585"); // THORNHILL WOODS DR / RUTHERFORD RD
		allStops.put("4584", "4584"); // THORNHILL WOODS DR / FOXWOOD RD
		allStops.put("4587", "4587"); // THORNHILL WOODS DR / FOXWOOD RD
		allStops.put("4854", "4854"); // MOUNT ALBERT RD / HOWARD AV
		allStops.put("6338", "6338"); // KENNEDY RD / CLAYTON DR
		allStops.put("6339", "6339"); // WOODBINE AV / RIVIERA DR
		allStops.put("4583", "4583"); // THORNHILL WOODS DR / SERENE WAY
		allStops.put("4850", "4850"); // WOOTTEN WAY / LINDEN LEA ST
		allStops.put("6961", "6961"); // VAUGHAN MILLS RD / LOIS DR
		allStops.put("5032", "5032"); // 16TH AV / MURAL ST
		allStops.put("6960", "6960"); // NAPA VALLEY AV / RUTHERFORD RD
		allStops.put("2118", "2118"); // YORKLAND ST / JUSTUS DR
		allStops.put("6455", "6455"); // METRO RD / VARNEY RD
		allStops.put("6963", "6963"); // VAUGHAN MILLS RD / DUNFOREST GATE
		allStops.put("1855", "1855"); // PARKWAY AV / ORCHARD ST
		allStops.put("1268", "1268"); // MARKHAM RD / ELSON ST
		allStops.put("1856", "1856"); // PARKWAY AV / MAIN ST MARKHAM
		allStops.put("9727", "9727"); // HWY 7 / VALLEYMEDE
		allStops.put("3026", "3026"); // 16TH AV / YONGE ST
		allStops.put("1857", "1857"); // MAIN ST MARKHAM / RAMONA BLVD
		allStops.put("2928", "2928"); // CRANSTON PARK AV / MCNAUGHTON RD
		allStops.put("6964", "6964"); // VAUGHAN MILLS RD / JOLANA CT
		allStops.put("7185", "7185"); // DUFFERIN ST STOP # 7185
		allStops.put("3556", "3556"); // MARTIN GROVE RD / AUBURN RD
		allStops.put("3554", "3554"); // MARTIN GROVE RD / HARRIS CRES
		allStops.put("5033", "5033"); // 16TH AV / BAYVIEW AV
		allStops.put("3552", "3552"); // MARTIN GROVE RD / ZINNIA PL
		allStops.put("3550", "3550"); // MARTIN GROVE RD / MORNING STAR DR
		allStops.put("2491", "2491"); // YONGE ST / DEVONSLEIGH BLVD
		allStops.put("1145", "1145"); // MCCLELLAN WAY / ALLENVALE DR
		allStops.put("3558", "3558"); // MARTIN GROVE RD / HIGHWAY 7
		allStops.put("6067", "6067"); // WOODBRIDGE AV / MARTIN GROVE RD
		allStops.put("6899", "6899"); // POETRY DR / FLOURISH ST
		allStops.put("6309", "6309"); // RUTHERFORD RD / RUTHERFORD GO
		allStops.put("2910", "2910"); // 16TH AV / GRANTON DR
		allStops.put("2911", "2911"); // 16TH AV / LESLIE ST
		allStops.put("2912", "2912"); // WEST BEAVER CREEK RD STOP # 2912
		allStops.put("2913", "2913"); // WEST BEAVER CREEK RD / WEST WILMOT
		allStops.put("2914", "2914"); // WEST BEAVER CREEK RD STOP # 2914
		allStops.put("2915", "2915"); // WEST BEAVER CREEK RD / POLLARD ST
		allStops.put("2916", "2916"); // WEST BEAVER CREEK RD / PEARCE ST
		allStops.put("2917", "2917"); // WEST BEAVER CREEK RD / WERTHEIM CRT
		allStops.put("2918", "2918"); // COMMERCE VALLEY DR / HIGHWAY 7
		allStops.put("2919", "2919"); // COMMERCE VALLEY DR STOP # 2919
		allStops.put("4968", "4968"); // MAIN ST / SIMCOE ST
		allStops.put("1794", "1794"); // MAIN ST / STOUFFER ST
		allStops.put("6421", "6421"); // AUTUMN HILL BLVD / DUFFERIN ST
		allStops.put("6848", "6848"); // MAJOR MACKENZIE DR / FOSSIL HIL RD
		allStops.put("6759", "6759"); // HIGHWAY 48 STOP # 6759
		allStops.put("4589", "4589"); // THORNHILL WOODS DR / MATISSE TRL
		allStops.put("5186", "5186"); // LESLIE ST / WAYNE DR
		allStops.put("2106", "2106"); // DEVONSLEIGH BLVD / LUBA AV
		allStops.put("7126", "7126"); // 16TH AV / RED MAPLE RD
		allStops.put("4079", "4079"); // SIMCOE AV / METRO RD
		allStops.put("6840", "6840"); // ANGUS GLEN BLVD / ROYAL TROON CRES
		allStops.put("5260", "5260"); // MAJOR MACKENZIE DR / MCNAUGHTON RD
		allStops.put("7122", "7122"); // DAVIS DR / SOUTH LAKE HOSPITAL
		allStops.put("7123", "7123"); // KEELE ST / HIGHWAY 7
		allStops.put("7120", "7120"); // MARKVILLE MALL STOP # 7120
		allStops.put("7121", "7121"); // 15TH SIDERD / BATHURST ST
		allStops.put("5031", "5031"); // 16TH AV STOP # 5031
		allStops.put("5309", "5309"); // NASHVILLE RD / HIGHWAY 27
		allStops.put("6306", "6306"); // EDGELEY BLVD / BASS PRO MILLS
		allStops.put("2493", "2493"); // YONGE ST / JEFFERSON FOREST DR
		allStops.put("6319", "6319"); // MAIN ST UNIONVILLE / UNIONVILLE GT
		allStops.put("5300", "5300"); // TIMOTHY ST STOP # 5300
		allStops.put("4963", "4963"); // MAIN ST / QUEEN ST
		allStops.put("1063", "1063"); // SPADINA RD / STRATHEARN AV
		allStops.put("1062", "1062"); // SPADINA RD / WELDRICK RD
		allStops.put("1065", "1065"); // SPADINA RD / CRESCENTVIEW RD
		allStops.put("1064", "1064"); // JOHN ST / COTTONWOOD CRT
		allStops.put("5306", "5306"); // WINNERS STOP # 5306
		allStops.put("5307", "5307"); // GRACE ST STOP # 5307
		allStops.put("4876", "4876_merged_3513011"); // STEWART'S FOODLAND STOP # 4876
		allStops.put("3023", "3023"); // 16TH AV / FERN AV
		allStops.put("2075", "2075"); // GORHAM ST / HAMILTON ST
		allStops.put("1669", "1669"); // GLEN SHIELDS AV / SPYGLASS HILL RD
		allStops.put("1668", "1668"); // WOODBINE AV / HILLMOUNT RD
		allStops.put("1666", "1666"); // WOODBINE AV / OAKFORD DR
		allStops.put("1665", "1665"); // GLEN SHIELDS AV / ROYAL COLWOOD CRT
		allStops.put("1664", "1664"); // WOODBINE AV / MAJOR MACKENZIE DR
		allStops.put("1663", "1663"); // DUFFERIN ST STOP # 1663
		allStops.put("1662", "1662"); // WOODBINE AV / MAJOR MACKENZIE DR
		allStops.put("1661", "1661"); // DUFFERIN ST / CLARK AV
		allStops.put("1660", "1660"); // WOODBINE AV / 16TH AV
		allStops.put("1087", "1087"); // ELGIN MILLS RD / GOODE ST
		allStops.put("9726", "9726"); // HWY 7 / VALLEYMEDE
		allStops.put("6592", "6592"); // COOPER CREEK / RIZAL AV
		allStops.put("6593", "6593"); // COOPER CREEK DR / BOSWELL RD
		allStops.put("1083", "1083"); // SHIRLEY DR / ELGIN MILLS RD
		allStops.put("6595", "6595"); // 9TH LINE / BERCZY GATE
		allStops.put("1081", "1081"); // SHIRLEY DR / ROMANCE DR
		allStops.put("1080", "1080"); // ESNA PARK DR STOP # 1080
		allStops.put("6598", "6598"); // VICTORIA SQUARE BLVD / BETTY ROMAN
		allStops.put("6756", "6756"); // HONDA BLVD /  WOODBINE AV
		allStops.put("4323", "4323"); // EDGELEY BLVD / FOUR VALLEY DR
		allStops.put("4322", "4322"); // EDGELEY BLVD / CORSTATE AV
		allStops.put("3966", "3966"); // KEELE ST / KNIGHTSWOOD AV
		allStops.put("2606", "2606"); // DAVIS DR / NIAGARA ST
		allStops.put("1089", "1089"); // ELGIN MILLS RD / REDSTONE RD
		allStops.put("4326", "4326"); // VELLORE WOODS BLVD / HAWSTONE RD
		allStops.put("3140", "3140"); // MARKHAM RD / HIGHGLEN AV
		allStops.put("3141", "3141"); // MARKHAM RD / GOLDEN AV
		allStops.put("3142", "3142"); // MARKHAM RD / DENISON ST
		allStops.put("9725", "9725"); // HWY 7 / BAYVIEW
		allStops.put("2828", "2828"); // BAYVIEW AV / FRANK ENDEAN RD
		allStops.put("2829", "2829"); // BAYVIEW AV / TAYLOR MILLS DR N
		allStops.put("1526", "1526"); // LEGACY DR / HONEYSUCKLE DR
		allStops.put("2824", "2824"); // BAYVIEW AV / MARAMAK RD
		allStops.put("2825", "2825"); // BAYVIEW AV / FARMSTEAD RD
		allStops.put("1904", "1904"); // KENNEDY RD / 14TH AV
		allStops.put("2827", "2827"); // BAYVIEW AV / REDSTONE RD
		allStops.put("2820", "2820"); // BAYVIEW AV / HILLSVIEW DR
		allStops.put("2821", "2821"); // BAYVIEW AV / WELDRICK RD
		allStops.put("2822", "2822"); // BAYVIEW AV / PALMER AV
		allStops.put("2823", "2823"); // BAYVIEW AV / MAJOR MACKENZIE DR
		allStops.put("3386", "3386"); // ROYAL ORCHARD BLVD / WILD CHERRY LA
		allStops.put("3387", "3387"); // NAPA VALLEY AV / MONTEBELLO AV
		allStops.put("5416", "5416"); // METRO RD / FERNCROFT DR
		allStops.put("5417", "5417"); // METRO RD / OLD HOMESTEAD RD
		allStops.put("3382", "3382"); // NEW WESTMINSTER DR / BATHURST ST
		allStops.put("3383", "3383"); // NAPA VALLEY AV / MONTE CARLO DR
		allStops.put("3380", "3380"); // NEW WESTMINSTER DR STOP # 3380
		allStops.put("3381", "3381"); // NAPA VALLEY AV / RUTHERFORD RD
		allStops.put("4807", "4807"); // MAJOR MACKENZIE DR / KENNEDY RD
		allStops.put("2603", "2603"); // DAVIS DR / PARKSIDE DR
		allStops.put("5418", "5418"); // THE QUEENSWAY / GLENWOODS AV
		allStops.put("5419", "5419"); // DORCHESTER ST / LONDON RD
		allStops.put("3388", "3388"); // ROYAL ORCHARD BLVD / BAY THORN DR
		allStops.put("3389", "3389"); // ROYAL ORCHARD BLVD / KIRK DR
		allStops.put("1409", "1409"); // BUR OAK AV / MCCAUL ST
		allStops.put("1408", "1408"); // CLARK AV STOP # 1408
		allStops.put("1403", "1403"); // BUR OAK AV / CRAWFORD ST
		allStops.put("1402", "1402"); // CLARK AV STOP # 1402
		allStops.put("1401", "1401"); // BUR OAK AV / THE BRIDLE WALK
		allStops.put("1400", "1400"); // CLARK AV STOP # 1400
		allStops.put("1407", "1407"); // BUR OAK AV / FAIRLAWN AV
		allStops.put("1406", "1406"); // CLARK AV / STONEMILL GATE
		allStops.put("1405", "1405"); // BUR OAK AV / WILLIAM BERCZY BLVD
		allStops.put("2494", "2494"); // YONGE ST / TOWNWOOD DR
		allStops.put("4215", "4215"); // SHEPPARD AV / DON MILLS RD
		allStops.put("4217", "4217"); // DON MILLS RD / FAIRVIEW MALL DR
		allStops.put("4437", "4437"); // BAYVIEW AV / FERN AV
		allStops.put("1339", "1339"); // JOHN ST / DAWN HILL TRL
		allStops.put("4210", "4210"); // DON MILLS RD / SENECA HILL DR
		allStops.put("4213", "4213"); // DON MILLS RD STOP # 4213
		allStops.put("4949", "4949"); // 14TH AV / MIDDLEFIELD RD
		allStops.put("1335", "1335"); // JOHN ST / LESLIE ST
		allStops.put("1334", "1334"); // BUR OAK AV / GREENSBOROUGH VILLAGE
		allStops.put("1337", "1337"); // JOHN ST / ROCKINGHAM CRT
		allStops.put("1336", "1336"); // BUR OAK AV / ALFRED PATERSON DR
		allStops.put("4219", "4219"); // DON MILLS RD / DEERFORD RD
		allStops.put("4218", "4218"); // DON MILLS RD / GODSTONE RD
		allStops.put("1333", "1333"); // JOHN ST STOP # 1333
		allStops.put("1332", "1332"); // BUR OAK AV / SWAN PARK RD
		allStops.put("6932", "6932"); // YORK DURHAM LINE / LORETTA CRES
		allStops.put("6933", "6933"); // MAIN ST / DONNA LEE TR
		allStops.put("6930", "6930"); // MILLARD ST / AUTOMALL BLVD
		allStops.put("9840", "9840"); // YONGE ST / REGATTA AV
		allStops.put("9847", "9847"); // SOUTH LAKE HOSPITAL
		allStops.put("6937", "6937"); // HOOVER PARK DR / PHILIP BROWN AV
		allStops.put("1902", "1902"); // KENNEDY RD / HIGHGLEN AV
		allStops.put("9844", "9844"); // DAVIS DR / LONGFORD DR
		allStops.put("4436", "4436"); // BATHURST ST / BLOOMINGTON RD
		allStops.put("6938", "6938"); // HOOVER PARK DR / PHILIP BROWN AV
		allStops.put("9848", "9848"); // SOUTH LAKE HOSPITAL
		allStops.put("5775", "5775"); // FONDA RD / GOLDEN AV
		allStops.put("5774", "5774"); // HIGHGLEN AV / FONDA RD
		allStops.put("5777", "5777"); // VICTORIA SQUARE BLVD / VINE CLIFF B
		allStops.put("5776", "5776"); // FONDA RD / RALPH CRT
		allStops.put("4425", "4425"); // KENNEDY ST / BATHURST ST
		allStops.put("3261", "3261"); // WOODBINE AV / 14TH AV
		allStops.put("3263", "3263"); // WOODBINE AV / 14TH AV
		allStops.put("1537", "1537"); // VILLAGE PKWY / BUCHANAN DR
		allStops.put("1536", "1536"); // RUSSELL JARVIS DR / ROUGE BANK DR
		allStops.put("1535", "1535"); // VILLAGE PKWY / ADDINGTON SQ
		allStops.put("1534", "1534"); // RUSSELL JARVIS DR / BLACK WALNUT DR
		allStops.put("1533", "1533"); // VILLAGE PKWY / WENTWORTH CRT
		allStops.put("3097", "3097"); // MCCOWAN RD / SOUTH UNIONVILLE AV
		allStops.put("1531", "1531"); // CARLTON RD / VILLAGE PKWY
		allStops.put("1530", "1530"); // LEGACY DR / RUSSELL JARVIS DR
		allStops.put("3265", "3265"); // VICTORIA PARK AV / STEELES AV
		allStops.put("3098", "3098"); // MCCOWAN RD / HIGHWAY 7
		allStops.put("3099", "3099"); // MCCOWAN RD / RAYMERVILLE DR
		allStops.put("3307", "3307"); // BATHURST ST / WESTMOUNT BLVD
		allStops.put("1539", "1539"); // BUCHANAN DR / FENWICK CRES
		allStops.put("1538", "1538"); // ROUGE BANK DR / LADY FERN DR
		allStops.put("5799", "5799"); // VIA ROMANO BLVD / SIR FRANCESCO ST
		allStops.put("1493", "1493"); // CARLTON RD / STANFORD RD
		allStops.put("7132", "7132"); // WILLIAM GRAHAM DR / HARTWELL WAY
		allStops.put("3057", "3057"); // RUTHERFORD RD / JULLIARD DR
		allStops.put("4101", "4101"); // THE QUEENSWAY / LAKEVIEW BLVD
		allStops.put("3269", "3269"); // VICTORIA PARK AV / I.B.M.
		allStops.put("4103", "4103"); // THE QUEENSWAY / HENRY ST
		allStops.put("4102", "4102"); // THE QUEENSWAY / MORTON AV
		allStops.put("4105", "4105"); // THE QUEENSWAY / MELS LANE
		allStops.put("4104", "4104"); // THE QUEENSWAY / SILAS BLVD
		allStops.put("4107", "4107"); // SIMCOE AV STOP # 4107
		allStops.put("4106", "4106"); // THE QUEENSWAY / CEDAR ST
		allStops.put("4109", "4109"); // METRO RD / CHURCH ST
		allStops.put("6336", "6336"); // JANE ST / AHMADIYYA AV
		allStops.put("4593", "4593"); // MAPLE SUGAR LANE / SUGARFOREST DR
		allStops.put("1026", "1026"); // SOUTH PARK RD STOP # 1026
		allStops.put("5771", "5771"); // MIDDLEFIELD RD / DENISON ST
		allStops.put("1939", "1939"); // DON MILLS RD / JOHN ST
		allStops.put("4207", "4207"); // DON MILLS RD / BEDLE AV
		allStops.put("5127", "5127"); // BUR OAK AV / COUNTRY RIDGE DR
		allStops.put("1188", "1188"); // SOUTH PARK RD / COMMERCE VALLEY DR
		allStops.put("2923", "2923"); // EAST BEAVER CREEK RD / FULTON WAY
		allStops.put("1901", "1901"); // KENNEDY RD / DENISON ST
		allStops.put("3377", "3377"); // RUTHERFORD RD / CLARENCE ST
		allStops.put("2544", "2544_merged_3513119"); // HOLLAND LANDING COMMUNITY CENTRE
		allStops.put("4669", "4669"); // HIGH TECH RD / SILVER LINDEN DR
		allStops.put("3892", "3892"); // AUTUMN HILL BLVD / PLEASANT RIDGE A
		allStops.put("3893", "3893"); // AUTUMN HILL BLVD / CHAGALL DR
		allStops.put("3890", "3890"); // TEN OAKS BLVD / FOREST RUN BLVD
		allStops.put("3891", "3891"); // TEN OAKS BLVD / DUFFERIN ST
		allStops.put("3896", "3896"); // THORNHILL WOODS DR / SUMMERIDGE DR
		allStops.put("9849", "9849"); // DAVIS DR / HURON HEIGHTS DR
		allStops.put("4204", "4204"); // DON MILLS RD / CLIFFWOOD RD
		allStops.put("1468", "1468"); // ALDEN RD / BENTLEY ST
		allStops.put("6745", "6745"); // LONDON RD / DOVER CRES
		allStops.put("7273", "7273"); // TENTH LINE / HOOVER PARK DR
		allStops.put("9862", "9862_merged_3513017"); // HIGHWAY 7 / KENNEDY RD
		allStops.put("3376", "3376"); // NEW WESTMINSTER DR / KATERINA AV
		allStops.put("6613", "6613"); // VELLORE AV / MARIA ANTONIA RD
		allStops.put("6612", "6612"); // VELLORE AV / AMY WOOD RD
		allStops.put("6611", "6611"); // DAVOS RD / VELLORE AV
		allStops.put("6610", "6610"); // DAVOS RD / KINGSVIEW RD
		allStops.put("1085", "1085"); // ELGIN MILLS RD / MELBOURNE DR
		allStops.put("6615", "6615"); // VELLORE AV / MAJOR MACKENZIE DR
		allStops.put("6614", "6614"); // VELLORE AV / VIA TOSCANA
		allStops.put("6986", "6986"); // DAVIS DR / LORNE AV
		allStops.put("9791", "9791"); // YONGE / BERNARD
		allStops.put("6619", "6619"); // MAJOR MACKENZIE DR / WESTON RD
		allStops.put("1496", "1496"); // 14TH AV / HOAKE RD
		allStops.put("4206", "4206"); // DON MILLS RD / MCNICOLL AV
		allStops.put("3462", "3462"); // WOODBRIDGE AV / JAMES ST
		allStops.put("5951", "5951"); // OLD KENNEDY RD / ALDERGROVE DR
		allStops.put("5950", "5950"); // OLD KENNEDY RD / SUNRISE DR
		allStops.put("5953", "5953"); // JANE ST / SPRINGSIDE RD
		allStops.put("1466", "1466"); // ALDEN RD / ESNA PARK DR
		allStops.put("5955", "5955"); // JANE ST / NORWOOD AV
		allStops.put("5954", "5954"); // JANE ST / SPRINGSIDE RD
		allStops.put("5957", "5957"); // JANE ST / MAJOR MACKENZIE DR
		allStops.put("5956", "5956"); // JANE ST / AVRO RD
		allStops.put("4075", "4075"); // THE QUEENSWAY / RIVERGLEN DR
		allStops.put("5958", "5958"); // KENNEDY RD / ANGUS GLEN BLVD
		allStops.put("4799", "4799"); // MAJOR MACKENZIE DR / MINGAY AV
		allStops.put("4071", "4071"); // LOWNDES AV / GLENWOODS AV
		allStops.put("4070", "4070"); // LOWNDES AV / ATHERTON CRES
		allStops.put("2406", "2406"); // BLOOMINGTON RD / ELDERBERRY TRL
		allStops.put("4072", "4072"); // GLENWOOD AND THE QUEENSWAY S
		allStops.put("5797", "5797"); // VIA ROMANO BLVD / COUNTRYWIDE CRT
		allStops.put("3967", "3967"); // KEELE ST / CROMWELL RD
		allStops.put("3964", "3964"); // KEELE ST STOP # 3964
		allStops.put("3965", "3965"); // KEELE ST / BARRHILL RD
		allStops.put("3962", "3962"); // KEELE ST / KILLIAN RD
		allStops.put("6816", "6816"); // MAJOR MACKENZIE DR EAST / GREENSPIR
		allStops.put("5791", "5791"); // VIA ROMANO BLVD / SIR STEVENS BLVD
		allStops.put("5790", "5790"); // VIA ROMANO BLVD / RIVERMILL CRES
		allStops.put("7092", "7092"); // VETERANS WAY / SHERMAN BROCK CRES
		allStops.put("1497", "1497"); // CARLTON RD / LORING CRES
		allStops.put("7278", "7278"); // HOOVER PARK DR / SANDIFORD DR
		allStops.put("3968", "3968"); // KEELE ST / DINA RD
		allStops.put("3969", "3969"); // KEELE ST / RUTHERFORD RD
		allStops.put("5184", "5184"); // LONDON RD / HAREWOOD BLVD
		allStops.put("7279", "7279"); // KENNEDY RD / HIGHWAY 7
		allStops.put("3638", "3638"); // ANSLEY GROVE RD / CHANCELLOR DR
		allStops.put("3639", "3639"); // STEELES AV STOP # 3639
		allStops.put("3636", "3636"); // ANSLEY GROVE RD STOP # 3636
		allStops.put("3637", "3637"); // STEELES AV / NORFINCH DR
		allStops.put("3634", "3634"); // ANSLEY GROVE RD / MISTY MEADOW DR
		allStops.put("3635", "3635"); // STEELES AV / ADESSO DR
		allStops.put("3632", "3632"); // ANSLEY GROVE RD / ABERDEEN AV
		allStops.put("3633", "3633"); // STEELES AV / JANE ST
		allStops.put("3630", "3630"); // ANSLEY GROVE RD / BELVIEW AV
		allStops.put("3631", "3631"); // STEELES AV / MURRAY ROSS PKWY
		allStops.put("1498", "1498"); // 14TH AV / MCCOWAN RD
		allStops.put("6451", "6451"); // HIGHWAY 48 STOP # 6451
		allStops.put("2073", "2073"); // GORHAM ST / ALEXANDER RD
		allStops.put("2345", "2345"); // YONGE ST / UPLANDS AV
		allStops.put("2344", "2344"); // YONGE ST / BAY THORN DR
		allStops.put("2347", "2347"); // YONGE ST / LONGBRIDGE RD
		allStops.put("2346", "2346"); // YONGE ST / BUNKER RD
		allStops.put("2341", "2341"); // YONGE ST / GLEN CAMERON RD
		allStops.put("2340", "2340"); // YONGE ST / MEADOWVIEW AV
		allStops.put("2343", "2343"); // YONGE ST / JOHN ST
		allStops.put("2342", "2342"); // YONGE ST / ELGIN ST
		allStops.put("6107", "6107"); // STONEY STANTON RD / HIGHWAY 7
		allStops.put("6392", "6392"); // RED MAPLE RD STOP # 6392
		allStops.put("6105", "6105"); // KENILWORTH GATE / OUTER BANKS DR
		allStops.put("6103", "6103"); // MAIN ST UNIONVILLE / CARLTON AV
		allStops.put("2348", "2348"); // YONGE ST / LANGSTAFF RD
		allStops.put("2469", "2469"); // QUEEN ST / ROXBOROUGH RD
		allStops.put("6100", "6100"); // DUFFERIN ST / GLEN SHIELDS AV
		allStops.put("9790", "9790"); // YONGE / BERNARD
		allStops.put("1499", "1499"); // CARLTON RD / FAWNBROOK CIR
		allStops.put("6450", "6450"); // HIGHWAY 48 STOP # 6450
		allStops.put("9797", "9797"); // YONGE / BLOOMINGTON
		allStops.put("6741", "6741"); // YONGE ST / CANYON HILL AV
		allStops.put("4616", "4616"); // TEN OAKS BLVD  / CONFEDERATION PKWY
		allStops.put("9796", "9796"); // YONGE / BLOOMINGTON
		allStops.put("2594", "2594"); // DAVIS DR / VINCENT ST
		allStops.put("6393", "6393"); // RED MAPLE RD / COLSTON CT
		allStops.put("2067", "2067"); // GORHAM ST / HARRY WALKER PKWY
		allStops.put("1639", "1639"); // ALDEN RD / 14TH AV
		allStops.put("6810", "6810"); // LESLIE ST / HOLBORN RD
		allStops.put("9795", "9795"); // YONGE / KING
		allStops.put("3708", "3708"); // STEELES AV / DUFFERIN ST
		allStops.put("4088", "4088_merged_3513008"); // WEXFORD DR / WOODBINE AV
		allStops.put("1889", "1889"); // KENNEDY RD / GORVETTE RD
		allStops.put("1888", "1888"); // KENNEDY RD / DENISON ST
		allStops.put("3702", "3702"); // STEELES AV / SHALE GATE
		allStops.put("1886", "1886"); // KENNEDY RD / LEE AV
		allStops.put("3700", "3700"); // STEELES AV / PETROLIA RD
		allStops.put("4465", "4465"); // MAJOR MACKENZIE DR STOP # 4465
		allStops.put("1883", "1883"); // KENNEDY RD / YMCA BLVD
		allStops.put("3707", "3707"); // STEELES AV / GERRY FITZGERALD DR
		allStops.put("3704", "3704"); // STEELES AV STOP # 3704
		allStops.put("3705", "3705"); // STEELES AV / ALNESS ST
		allStops.put("1595", "1595"); // ROXBURY ST / CHATELAINE DR
		allStops.put("6914", "6914"); // STANTON AV / TRAMMEL DR
		allStops.put("4795", "4795"); // MAJOR MACKENZIE DR / MARKLAND ST
		allStops.put("2122", "2122"); // ELGIN MILLS RD / EDWARD AV
		allStops.put("4668", "4668"); // MCCLELLAN WAY / MAHOGANY CRT
		allStops.put("6109", "6109"); // RAYMERVILLE DR / CAIRNS DR
		allStops.put("2127", "2127"); // ELGIN MILLS RD / OHIO RD
		allStops.put("6915", "6915"); // STANTON AV / PARISIENNE RD
		allStops.put("4916", "4916"); // YONGE ST / CENTRE AV
		allStops.put("4917", "4917"); // YONGE ST / STEELES AV
		allStops.put("4666", "4666"); // HENDERSON DR / MCCLELLAN WAY
		allStops.put("4915", "4915"); // YONGE ST STOP # 4915
		allStops.put("4660", "4660"); // LORNE AV / QUEEN ST
		allStops.put("5751", "5751"); // BATHURST ST / BEVERLEY GLEN BLVD
		allStops.put("4662", "4662"); // CROSSLAND GATE / FAIRWAY GDNS
		allStops.put("4911", "4911"); // JANE ST / AVRO RD
		allStops.put("1967", "1967"); // BATHURST ST / SUMMERIDGE DR
		allStops.put("6039", "6039"); // THE BRIDLE WALK / CASTLEMORE AV
		allStops.put("6917", "6917"); // CANADA DR / WESTON RD
		allStops.put("6452", "6452"); // METRO RD / RAINES ST
		allStops.put("4328", "4328"); // VELLORE WOODS BLVD / ASHBERRY BLVD
		allStops.put("6106", "6106"); // KENILWORTH GATE / MICHELINA TERR
		allStops.put("6033", "6033"); // MANHATTAN DR / WALL ST
		allStops.put("9821", "9821"); // RICHMOND HILL CENTRE PLATFORM 2
		allStops.put("6031", "6031"); // SOUTH UNIONVILLE AV / RAY ST
		allStops.put("6030", "6030"); // HARRY COOK DR / SOUTH UNIONVILLE AV
		allStops.put("9820", "9820"); // RICHMOND HILL CENTRE PLATFORM 1
		allStops.put("5173", "5173"); // THE QUEENSWAY / RICHMOND PARK DR
		allStops.put("5172", "5172"); // THE QUEENSWAY / DOVEDALE DR
		allStops.put("2659", "2659"); // YONGE ST / COON'S RD
		allStops.put("2658", "2658"); // HUMBERLAND DR / WOODHAVEN CRES
		allStops.put("5177", "5177"); // WOODBINE AV / WEXFORD DR
		allStops.put("9823", "9823"); // YONGE / JEFFERSON SDRD
		allStops.put("5175", "5175"); // METRO RD / NIDA DR
		allStops.put("5174", "5174"); // METRO RD / OLD HOMESTEAD RD
		allStops.put("2349", "2349"); // YONGE ST STOP # 2349
		allStops.put("2651", "2651"); // KINGSHILL RD / LONGWOOD AV
		allStops.put("5178", "5178"); // THE QUEENSWAY / METRO RD
		allStops.put("2657", "2657"); // HUMBERLAND DR / WOODHAVEN CRES
		allStops.put("2656", "2656"); // HUMBERLAND DR / RED CARDINAL TRL
		allStops.put("2655", "2655"); // COON'S RD / GREYFRIARS AV
		allStops.put("6102", "6102"); // MCNAUGHTON RD / KEELE ST
		allStops.put("3416", "3416"); // ISLINGTON AV STOP # 3416
		allStops.put("3417", "3417"); // GREEN LANE / HUNTINGTON PARK DR
		allStops.put("3414", "3414"); // ISLINGTON AV / KILORAN AV
		allStops.put("3415", "3415"); // GREEN LANE / HUNTINGTON PARK DR
		allStops.put("3412", "3412"); // ISLINGTON AV / WYCLIFFE GATE
		allStops.put("3413", "3413"); // GREEN LANE / KINGS COLLEGE RD
		allStops.put("3410", "3410"); // ISLINGTON AV / WYCLIFFE AV
		allStops.put("3411", "3411"); // GREEN LANE / AILEEN AV
		allStops.put("5185", "5185"); // MOUNT ALBERT RD STOP # 5185
		allStops.put("1117", "1117"); // DENISON ST / ALDERGROVE DR
		allStops.put("1597", "1597"); // CHATELAINE DR / 14TH AV
		allStops.put("9801", "9801"); // YONGE / GOLF LINKS
		allStops.put("3418", "3418"); // ISLINGTON AV / HAYHOE LANE
		allStops.put("3419", "3419"); // GREEN LANE / LESLIE ST
		allStops.put("5925", "5925"); // MORNING DOVE DR / QUAIL HOLLOW
		allStops.put("5348", "5348"); // FARMSTEAD RD / SHIRLEY DR
		allStops.put("6919", "6919"); // CANADA DR / SUMMIT DR
		allStops.put("6454", "6454"); // METRO RD / LAKE DR N
		allStops.put("2921", "2921"); // EAST BEAVER CREEK / YORK BLVD
		allStops.put("4869", "4869"); // KING ST / CENTRE ST
		allStops.put("6322", "6322"); // RICHMOND HILL COMMONS PLAZA
		allStops.put("1930", "1930"); // LESLIE ST / TANGLEWOOD TRL
		allStops.put("6320", "6320"); // SOUTH HILL PLAZA STOP # 6320
		allStops.put("4862", "4862"); // MOUNT ALBERT RD / DON ROSE BLVD
		allStops.put("2014", "2014"); // MULOCK DR / CANE PKWY
		allStops.put("4860", "4860"); // MOUNT ALBERT RD / MCCOWAN RD
		allStops.put("4861", "4861"); // MOUNT ALBERT RD / HIGHWAY 48
		allStops.put("4866", "4866"); // ELIZABETH ST STOP # 4866
		allStops.put("2010", "2010"); // MULOCK DR STOP # 2010
		allStops.put("6329", "6329"); // METRO RD / KENNEDY RD
		allStops.put("4865", "4865"); // ROYAL OAK RD / STOKES RD
		allStops.put("2922", "2922"); // EAST BEAVER CREEK RD / EAST PEARCE
		allStops.put("5160", "5160"); // REDSTONE RD / PRIMONT DR
		allStops.put("1452", "1452"); // GLEN SHIELDS AV / ROYAL COLWOOD CRT
		allStops.put("5349", "5349"); // PEARSON AV STOP # 5349
		allStops.put("6879", "6879"); // CORNELL ROUGE BLVD / AUTUMN GLOW DR
		allStops.put("2729", "2729"); // REDSTONE RD / QUEENSWAY DR
		allStops.put("3367", "3367"); // ISLINGTON AV / RUSHWORTH CRES
		allStops.put("5250", "5250"); // ALLAURA BLVD / EDWARD ST
		allStops.put("1591", "1591"); // BOXWOOD CRES / 14TH AV
		allStops.put("2926", "2926"); // EAST BEAVER CREEK RD STOP # 2926
		allStops.put("3562", "3562"); // MARTIN GROVE RD / ROYSUN RD
		allStops.put("3563", "3563"); // STEELES AV / REDLEA AV
		allStops.put("3560", "3560"); // MARTIN GROVE RD / REGINA RD
		allStops.put("7250", "7250"); // KEELE ST / HIGHWAY 7
		allStops.put("7251", "7251"); // HIGHWAY 7 / NEW HUNTINGTON RD
		allStops.put("3564", "3564"); // MARTIN GROVE RD STOP # 3564
		allStops.put("3565", "3565"); // STEELES AV / KENNEDY RD
		allStops.put("4594", "4594"); // PLEASANT RIDGE / MAPLE SUGAR LANE
		allStops.put("3568", "3568"); // MARTIN GROVE RD / STEELES AV
		allStops.put("2112", "2112"); // DEVONSLEIGH BLVD / LUBA AV
		allStops.put("6456", "6456"); // HIGH ST / SNOOKS RD
		allStops.put("5929", "5929"); // WHITE'S HILL AV / JOHN ALLAN CAMERO
		allStops.put("4484", "4484"); // HUMBER COLLEGE BLVD / FINCH AV
		allStops.put("5612", "5612"); // WELLINGTON ST / LESLIE ST
		allStops.put("1936", "1936"); // DON MILLS RD / STEELES AV
		allStops.put("4487", "4487"); // FINCH AV / HIGHWAY 27
		allStops.put("4480", "4480"); // FINCH AV / JOHN GARLAND BLVD
		allStops.put("4481", "4481"); // HUMBER COLLEGE BLVD / HUMBERLINE DR
		allStops.put("4482", "4482"); // HUMBER COLLEGE BLVD STOP # 4482
		allStops.put("4483", "4483"); // HUMBER COLLEGE BLVD / ARBORETUM BLV
		allStops.put("5413", "5413"); // METRO RD / WOODBINE AV
		allStops.put("6416", "6416"); // COPPER CREEK DR
		allStops.put("5761", "5761"); // DENISON ST / BUSSA RD
		allStops.put("3225", "3225"); // COCHRANE DR STOP # 3225
		allStops.put("4488", "4488"); // FINCH AV / WESTMORE DR
		allStops.put("6567", "6567"); // RAVINEVIEW DR / VISTA GATE
		allStops.put("6594", "6594_merged_3513123"); // BUR OAK AV STOP # 6594
		allStops.put("2903", "2903"); // BAYVIEW AV / BRIGGS AV
		allStops.put("2902", "2902"); // BAYVIEW AV / HIGH TECH RD
		allStops.put("2901", "2901"); // BAYVIEW AV / CRESWICK RD
		allStops.put("5611", "5611"); // FIRST COMMERCE DR / WELLINGTON ST
		allStops.put("6851", "6851"); // BULLOCK DR / LAIDLAW BLVD
		allStops.put("2906", "2906"); // BAYVIEW AV / DUNCAN RD
		allStops.put("2905", "2905"); // BAYVIEW AV STOP # 2905
		allStops.put("6852", "6852"); // MAJOR MACKENZIE DR STOP # 6852
		allStops.put("4892", "4892"); // WILLOWBROOK RD / TRIMBLE CRT
		allStops.put("6561", "6561"); // 9TH LINE / CHURCH ST
		allStops.put("6790", "6790"); // HIGHWAY 7 / WOODBINE AV
		allStops.put("2908", "2908"); // 16TH AV / STRATHEARN AV
		allStops.put("6560", "6560"); // SUNSET BEACH RD / BAYVIEW PARK LN
		allStops.put("7139", "7139"); // LESLIE ST / ST. JOHN'S SDRD
		allStops.put("7138", "7138"); // WILLIAM GRAHAM DR / LESLIE ST
		allStops.put("1906", "1906"); // KENNEDY RD STOP # 1906
		allStops.put("6447", "6447"); // METRO RD / BIRCH RD
		allStops.put("7131", "7131"); // WILLIAM GRAHAM DR / WARREN MCBRIDE
		allStops.put("7130", "7130"); // WILLIAM GRAHAM DR / SPARKS ST
		allStops.put("7133", "7133"); // WILLIAM GRAHAM DR / ROY HARPER AV
		allStops.put("6562", "6562"); // KEELE ST / KING RD
		allStops.put("7135", "7135"); // WILLIAM GRAHAM DR / ROY HARPER AV
		allStops.put("7134", "7134"); // WILLIAM GRAHAM DR / ST.JOHN'S SDRD
		allStops.put("7137", "7137"); // WILLIAM GRAHAM DR / SPARKS ST
		allStops.put("7136", "7136"); // WILLIAM GRAHAM DR / HARTWELL WAY
		allStops.put("3375", "3375"); // RUTHERFORD RD / ISLINGTON AV
		allStops.put("5319", "5319"); // OBSERVATORY TOWERS STOP # 5319
		allStops.put("5318", "5318"); // YONGE ST / DREWRY AV
		allStops.put("5246", "5246"); // HAGGERMANS CORNER STOP # 5246
		allStops.put("6299", "6299"); // GLENWOODS AV / WOODBINE AV
		allStops.put("4891", "4891"); // WILLOWBROOK RD / ABRAHAM AV
		allStops.put("6458", "6458"); // DALTON RD STOP # 6458
		allStops.put("5312", "5312"); // CLARK AV STOP # 5312
		allStops.put("5311", "5311"); // RUTHERFORD RD / ILAN RAMON BLVD
		allStops.put("5310", "5310"); // RUTHERFORD RD / ILAN RAMON BLVD
		allStops.put("5317", "5317"); // YONGE ST / CONNAUGHT AV
		allStops.put("5316", "5316"); // YONGE ST / MOORE PARK AV
		allStops.put("5315", "5315"); // YONGE ST / ABITIBI AV
		allStops.put("5314", "5314"); // YONGE ST / STEELES AV
		allStops.put("1658", "1658"); // WOODBINE AV / MILLBROOK GATE
		allStops.put("1659", "1659"); // DENISON ST / VICTORIA PARK AV
		allStops.put("1652", "1652"); // WOODBINE AV / MCINTOSH DR
		allStops.put("1653", "1653"); // DENISON ST / VICTORIA PARK AV
		allStops.put("1650", "1650"); // WOODBINE AV / HIGHWAY 7
		allStops.put("1651", "1651"); // DENISON ST / VICTORIA PARK AV
		allStops.put("1656", "1656"); // WOODBINE AV / HOOPER RD
		allStops.put("1657", "1657"); // DENISON ST / WOODBINE AV
		allStops.put("1654", "1654"); // WOODBINE AV / APPLE CREEK BLVD
		allStops.put("1655", "1655"); // DENISON ST / WOODBINE AV
		allStops.put("6582", "6582"); // MAVRINAC BLVD / HARTWELL WAY
		allStops.put("6581", "6581"); // MAVRINAC BLVD / LEWIS HONEY DR
		allStops.put("6580", "6580"); // ST. JOHN'S SDRD / MAVRINAC BLVD
		allStops.put("4890", "4890"); // WILLOWBROOK RD / CHARNWOOD PL
		allStops.put("6586", "6586"); // MAVRINAC BLVD / BOREALIS AV
		allStops.put("6585", "6585"); // MAVRINAC BLVD / IVY JAY CRES
		allStops.put("6584", "6584"); // MAVRINAC BLVD / SPRING FARM RD
		allStops.put("9733", "9733"); // HWY 7 / EAST BEAVER CREEK
		allStops.put("6588", "6588"); // MAVRINAC BLVD / HALLDORSON AV
		allStops.put("1632", "1632"); // WOODBINE AV / HOOPER RD
		allStops.put("1290", "1290"); // BUR OAK AV / DONALD SIM AV
		allStops.put("3424", "3424"); // ISLINGTON AV / DAVIDSON DR
		allStops.put("3217", "3217"); // COCHRANE DR / HIGHWAY 7
		allStops.put("3157", "3157"); // WARDEN AV / ENTERPRISE BLVD
		allStops.put("1583", "1583"); // ROUGE BANK DR / LADY FERN DR
		allStops.put("3155", "3155"); // WARDEN AV / CLEGG RD
		allStops.put("3154", "3154"); // WARDEN AV / HIGHWAY 7
		allStops.put("2837", "2837"); // WOODRIVER ST / ROSETREE ST
		allStops.put("1634", "1634"); // WOODBINE AV / VALLEYWOOD DR
		allStops.put("2835", "2835"); // WOODRIVER ST / CEDARHURST DR
		allStops.put("2834", "2834"); // WOODRIVER ST / RAWLINGS AV
		allStops.put("7128", "7128"); // LESLIE ST / ST. JOHN'S SDRD
		allStops.put("2832", "2832"); // SUBRISCO AV / CANTEX CRT
		allStops.put("2831", "2831"); // BAYVIEW AV STOP # 2831
		allStops.put("2830", "2830"); // BAYVIEW AV / ELGIN MILLS RD
		allStops.put("1436", "1436"); // GLEN SHIELDS AV / DUFFERIN ST
		allStops.put("3390", "3390"); // NAPA VALLEY AV / SONOMA BLVD
		allStops.put("1434", "1434"); // DUFFERIN ST / DRAPER BLVD
		allStops.put("1435", "1435"); // RODICK RD / 16TH AV
		allStops.put("3395", "3395"); // ROYAL ORCHARD BLVD / DORAL GATE
		allStops.put("1433", "1433"); // RODICK RD / HANS DR
		allStops.put("1430", "1430"); // CLARK AV / YONGE ST
		allStops.put("3396", "3396"); // NAPA VALLEY AV / SUNSET RIDGE
		allStops.put("9732", "9732"); // HWY 7 / EAST BEAVER CREEK
		allStops.put("3398", "3398"); // NAPA VALLEY AV / MONTE CARLO DR
		allStops.put("1981", "1981"); // DAVIS DR STOP # 1981
		allStops.put("1438", "1438"); // GLEN SHIELDS AV / OAKMOUNT CRES
		allStops.put("1439", "1439"); // JOHN BUTTON BLVD / MILITIA TRL
		allStops.put("5230", "5230"); // WATER ST STOP # 5230
		allStops.put("1730", "1730"); // HENDERSON DR / POPLAR CRES
		allStops.put("7129", "7129"); // WILLIAM GRAHAM DR / LESLIE ST
		allStops.put("5515", "5515_merged_3513004"); // PEFFERLAW RD / PINEVIEW CRT
		allStops.put("1299", "1299"); // DENISON ST / MILLIKEN MEADOWS DR
		allStops.put("6296", "6296"); // KESWICK MARKETPLACE STOP # 6296
		allStops.put("1348", "1348"); // BUR OAK AV / CRAWFORD ST
		allStops.put("1349", "1349"); // JOHN ST / BAYVIEW AV
		allStops.put("4262", "4262"); // YONGE ST / EDGAR AV
		allStops.put("4264", "4264"); // ABERDEEN AV / MISTY MEADOW DR
		allStops.put("4468", "4468"); // RICHMOND HILL CENTRE PLATFORM 7
		allStops.put("4266", "4266"); // MAJOR MACKENZIE DR / RICHARD PERSON
		allStops.put("4267", "4267"); // MAJOR MACKENZIE DR / HAZELTON AV
		allStops.put("1340", "1340"); // ANGUS GLEN C.C. STOP # 1340
		allStops.put("1341", "1341"); // JOHN ST / BAYVIEW FAIRWAYS DR
		allStops.put("1342", "1342"); // KENNEDY RD / ANGUS GLEN BLVD
		allStops.put("1343", "1343"); // JOHN ST / AILEEN RD
		allStops.put("1344", "1344"); // BUR OAK AV / FAIRLAWN AV
		allStops.put("1345", "1345"); // JOHN ST STOP # 1345
		allStops.put("1346", "1346"); // BUR OAK AV / HENRIETTA ST
		allStops.put("1734", "1734"); // HENDERSON DR / YONGE ST
		allStops.put("1887", "1887"); // KENNEDY RD / HIGHGLEN AV
		allStops.put("6218", "6218"); // OLD COLONY RD / BIRDSONG ST
		allStops.put("6928", "6928"); // MILLARD ST / GLAD PARK AV
		allStops.put("5167", "5167"); // DUFFERIN ST / CARAWAY DR
		allStops.put("9879", "9879"); // HELEN WESTBOUND
		allStops.put("6925", "6925"); // MILLARD ST / AZIMUTH LN
		allStops.put("6924", "6924"); // TOWN CENTRE BLVD / HIGHWAY 7
		allStops.put("6927", "6927"); // MILLARD ST / WAITE CRES
		allStops.put("6926", "6926"); // MILLARD ST / WINLANE DR
		allStops.put("6921", "6921"); // CITYVIEW BLVD / LORMEL GT
		allStops.put("1885", "1885"); // KENNEDY RD / 14TH AV
		allStops.put("9870", "9870"); // HIGHWAY 7 / SCIBERRAS RD
		allStops.put("6922", "6922"); // CITYVIEW BLVD / RETREAT BLVD
		allStops.put("5548", "5548"); // DUNNING AV / CAMERON AV
		allStops.put("5549", "5549"); // MULOCK DR / WILLOWICK DR
		allStops.put("9734", "9734"); // HWY 7 / ALLSTATE
		allStops.put("3368", "3368"); // NEW WESTMINSTER DR / EDGECROFT TRL
		allStops.put("5542", "5542"); // RAYMERVILLE DR / CAIRNS DR
		allStops.put("5543", "5543"); // RAYMERVILLE DR / ADRIAN CRES
		allStops.put("5540", "5540"); // RAYMERVILLE DR / SNIDER DR
		allStops.put("5541", "5541"); // RAYMERVILLE DR / BENDAMERE CRES
		allStops.put("5546", "5546"); // JOHN WEST WAY / HOLLANDVIEW TRL
		allStops.put("5547", "5547"); // WELLINGTON ST / BAYVIEW AV
		allStops.put("5544", "5544"); // RAYMERVILLE DR / MCCOWAN RD
		allStops.put("5545", "5545"); // JOHN WEST WAY / CIVIC SQUARE GATE
		allStops.put("1502", "1502"); // 14TH AV / FEATHERSTONE AV
		allStops.put("1503", "1503"); // CARLTON RD / HALTERWOOD CIR
		allStops.put("1500", "1500"); // 14TH AV / COPPARD AV
		allStops.put("1501", "1501"); // CARLTON RD / MANHATTAN DR
		allStops.put("5168", "5168"); // SUMMERIDGE DR / COUTURE GDNS
		allStops.put("1507", "1507"); // CARLTON RD / CENTRAL PARK DR
		allStops.put("1504", "1504"); // 14TH AV /CANFIELD DR
		allStops.put("1505", "1505"); // CARLTON RD / MARKVILLE HIGH SHOOL
		allStops.put("3085", "3085"); // 16TH AV / NORMANDALE RD
		allStops.put("3084", "3084"); // 16TH AV / VILLAGE PKWY
		allStops.put("1508", "1508"); // 14TH AV / MARKHAM RD
		allStops.put("1509", "1509"); // CARLTON RD / MANHATTAN DR
		allStops.put("3081", "3081"); // 16TH AV / GREYSTONE RD
		allStops.put("3080", "3080"); // 16TH AV / RODICK RD
		allStops.put("3083", "3083"); // 16TH AV / WARDEN AV
		allStops.put("3082", "3082"); // 16TH AV / LOCKRIDGE AV
		allStops.put("2152", "2152"); // BAIF BLVD / SPRINGHEAD GDNS
		allStops.put("2121", "2121"); // ELGIN MILLS RD / NEWKIRK RD
		allStops.put("9737", "9737"); // HWY 7 / WOODBINE
		allStops.put("3369", "3369"); // ISLINGTON AV / BINDERTWINE BLVD
		allStops.put("2120", "2120"); // ELGIN MILLS RD / OHIO RD
		allStops.put("1599", "1599"); // 14TH AV / HORSTMAN ST
		allStops.put("2123", "2123"); // ELGIN MILLS RD / NEAL DR
		allStops.put("6999", "6999"); // VIA CAMPANILE / GRAND VELLORE CRES
		allStops.put("5890", "5890"); // FOUR VALLEY DR STOP # 5890
		allStops.put("5891", "5891"); // FOUR VALLEY DR STOP # 5891
		allStops.put("5892", "5892"); // FOUR VALLEY DR / EDGELEY BLVD
		allStops.put("5893", "5893"); // FOUR VALLEY DR STOP # 5893
		allStops.put("5894", "5894"); // FOUR VALLEY DR STOP # 5894
		allStops.put("5895", "5895"); // FOUR VALLEY DR STOP # 5895
		allStops.put("5896", "5896"); // ESTATE GARDEN DR STOP # 5896
		allStops.put("5897", "5897"); // LITTLESIDE ST / TIMBER VALLEY AV
		allStops.put("5898", "5898"); // LITTLESIDE ST / TIMBER VALLEY AV
		allStops.put("5899", "5899"); // ESTATE GARDEN DR STOP # 5899
		allStops.put("2124", "2124"); // ELGIN MILLS RD / ROSE BRANCH DR
		allStops.put("3885", "3885"); // RIVERMEDE RD / RAYETTE RD
		allStops.put("3884", "3884"); // RIVERMEDE RD / BOWES RD
		allStops.put("3887", "3887"); // CONFEDERATION PKWY / DUFFERIN HILL
		allStops.put("3886", "3886"); // RIVERMEDE RD / KEELE ST
		allStops.put("3881", "3881"); // NORTH RIVERMEDE RD / AUDIA CRT
		allStops.put("3880", "3880"); // NORTH RIVERMEDE RD / BRADWICK DR
		allStops.put("1598", "1598"); // HOLLINGHAM RD / LOWESWATER AV
		allStops.put("3882", "3882"); // NORTH RIVERMEDE RD / RIVERMEDE RD
		allStops.put("2481", "2481"); // YONGE ST / LORNE AV
		allStops.put("2126", "2126"); // ELGIN MILLS RD / NEWKIRK RD
		allStops.put("3889", "3889"); // TEN OAKS BLVD / FORECASTLE RD
		allStops.put("3888", "3888"); // CONFEDERATION PKWY / TEN OAKS BLVD
		allStops.put("2935", "2935"); // MAJOR MACKENZIE DR / MELVILLE AV
		allStops.put("4233", "4233"); // DON MILLS RD / CLIFFWOOD RD
		allStops.put("4664", "4664"); // KENNEDY ST / DEERHORN CRES
		allStops.put("7125", "7125"); // MAIN ST / EASTERN GATE CR
		allStops.put("2128", "2128"); // ELGIN MILLS RD / YORKLAND ST
		allStops.put("3963", "3963"); // KEELE ST / MAJOR MACKENZIE DR
		allStops.put("5279", "5279"); // FORESTWOOD ST / LIBRA AV
		allStops.put("1884", "1884"); // KENNEDY RD / DUFFIELD DR
		allStops.put("2416", "2416"); // INDUSTRIAL PKWY / SCANLON CRT
		allStops.put("4667", "4667"); // BATHURST ST / HENDERSON DR
		allStops.put("4696", "4696"); // YONGE ST / GARDEN AV
		allStops.put("4863", "4863"); // MOUNT ALBERT RD STOP # 4863
		allStops.put("4665", "4665"); // MURRAY DR / MOSAICS AV
		allStops.put("4913", "4913"); // JANE ST / NORWOOD AV
		allStops.put("1292", "1292"); // BUR OAK AV / ALMIRA AV
		allStops.put("4910", "4910"); // LESLIE ST / STELLAR DR
		allStops.put("6628", "6628"); // VELLORE WOODS BLVD STOP # 6628
		allStops.put("6629", "6629"); // HOLLIDGE BLVD / HOLLANDVIEW TRL
		allStops.put("6738", "6738"); // MAIN ST / BAKER HILL RD
		allStops.put("6627", "6627"); // VELLORE WOODS BLVD / COMDEL BLVD
		allStops.put("6624", "6624"); // VELLORE AV / DAVOS RD
		allStops.put("4663", "4663"); // KENNEDY ST / CORNER RIDGE RD
		allStops.put("6622", "6622"); // VELLORE AV / MARIA ANTONIA RD
		allStops.put("6623", "6623"); // VELLORE AV / BELLINI AV
		allStops.put("6620", "6620"); // VELLORE AV / EURO PLACE
		allStops.put("6621", "6621"); // VELLORE AV / MEDITERRA DR
		allStops.put("4008", "4008"); // DUFFERIN ST / GLEN SHIELDS AV
		allStops.put("4009", "4009"); // DUFFERIN ST / VICEROY RD
		allStops.put("6702", "6702"); // SILVER MAPLE RD / PEXTON AV
		allStops.put("6994", "6994"); // FOSSIL HILL RD / ST URBAIN DR
		allStops.put("4001", "4001"); // CONFEDERATION PKWY STOP # 4001
		allStops.put("5837", "5837"); // MAJOR MACKENZIE DR / MCCOWAN RD
		allStops.put("4004", "4004"); // DUFFERIN ST / LANGSTAFF RD
		allStops.put("4005", "4005"); // DUFFERIN ST / RACCO PKWY
		allStops.put("4006", "4006"); // DUFFERIN ST / BEVERLEY GLEN BLVD
		allStops.put("4007", "4007"); // DUFFERIN ST / CENTRE ST
		allStops.put("3971", "3971"); // TIERRA AV / JANE ST
		allStops.put("3970", "3970"); // MELVILLE AV / PARKTREE DR
		allStops.put("3973", "3973"); // TIERRA AV / JOHN DEISMAN BLVD
		allStops.put("3972", "3972"); // TIERRA AV / DISCOVERY TRL
		allStops.put("3975", "3975"); // AMERICA AV / TREASURE RD
		allStops.put("3974", "3974"); // JOHN DEISMAN BLVD / AMERICA AV
		allStops.put("3977", "3977"); // AMERICA AV / JANE ST
		allStops.put("3976", "3976"); // AMERICA AV / DISCOVERY TRL
		allStops.put("3979", "3979"); // AMERICA AV / TREASURE RD
		allStops.put("3978", "3978"); // AMERICA AV / COAST AV
		allStops.put("1882", "1882"); // KENNEDY RD / UNIONVILLE GATE
		allStops.put("6706", "6706"); // STOUFFVILLE RD / LESLIE ST
		allStops.put("3365", "3365"); // ISLINGTON AV STOP # 3365
		allStops.put("2544", "2544_merged_3513091"); // YONGE ST / DUTCH SETTLERS CRT
		allStops.put("3628", "3628"); // ANSLEY GROVE RD / MISTY MEADOW DR
		allStops.put("6038", "6038"); // THE BRIDLE WALK / BUR OAK AV
		allStops.put("6995", "6995"); // FOSSIL HILL RD / MAJOR MACKENZIE DR
		allStops.put("9782", "9782"); // YONGE / WELDRICK
		allStops.put("3621", "3621"); // STEELES AV / TANDEM RD
		allStops.put("4145", "4145"); // HIGHWAY 7 / HIGHWAY 27
		allStops.put("4230", "4230"); // DON MILLS RD / MCNICOLL AV
		allStops.put("2301", "2301"); // HARRY WALKER PKWY / JOURNEY'S END C
		allStops.put("1069", "1069"); // FARMSTEAD RD / SHELL CRT
		allStops.put("3624", "3624"); // ANSLEY GROVE RD / CHANCELLOR DR
		allStops.put("4272", "4272"); // MAJOR MACKENZIE DR / GLENBOURNE PK
		allStops.put("3626", "3626"); // ANSLEY GROVE RD STOP # 3626
		allStops.put("1254", "1254"); // ELSON ST / MIDDLEFIELD RD
		allStops.put("5013", "5013"); // STONEHAVEN AV / BEST CIR
		allStops.put("6032", "6032"); // GREENWATER GATE / HELEN AV
		allStops.put("1881", "1881"); // KENNEDY RD / CASTAN AV
		allStops.put("9872", "9872_merged_3513097"); // BATHURST & HIGHWAY 7
		allStops.put("3366", "3366"); // NEW WESTMINSTER DR / MULLEN DR
		allStops.put("6346", "6346_merged_3513005"); // JANE ST / MACINTOSH BLVD
		allStops.put("2011", "2011"); // MULOCK DR / BAYVIEW AV
		allStops.put("2330", "2330"); // FINCH GO BUS TERMINAL PLATFORM 10
		allStops.put("4715", "4715"); // HIGHWAY 7 / FRONTENAC DR
		allStops.put("2332", "2332"); // FINCH GO BUS TERMINAL PLATFORM 12
		allStops.put("4717", "4717"); // HIGHWAY 7 STOP # 4717
		allStops.put("2334", "2334"); // FINCH GO BUS TERMINAL PLATFORM 15
		allStops.put("4711", "4711"); // NINTH LINE / ROSE WAY
		allStops.put("4712", "4712"); // HIGHWAY 7 / COSBURN RD
		allStops.put("1594", "1594"); // HOLLINGHAM RD / COLEDALE RD
		allStops.put("6132", "6132"); // MULOCK DR / LELSIE ST
		allStops.put("6133", "6133"); // WESTON RD / HIGHWAY 7
		allStops.put("6131", "6131"); // LESLIE ST / WELLINGTON ST
		allStops.put("4718", "4718"); // HIGHWAY 7 STOP # 4718
		allStops.put("3072", "3072"); // 16TH AV / BERWICK CRES
		allStops.put("6134", "6134"); // THE BRIDAL WALK / CYNTHIA JEAN ST
		allStops.put("6135", "6135"); // RIDGECREST RD / HILLWOOD ST
		allStops.put("3073", "3073"); // 16TH AV / ELM AV
		allStops.put("1880", "1880"); // KENNEDY RD / AVOCA DR
		allStops.put("9846", "9846"); // DAVIS DR / MAIN ST
		allStops.put("2958", "2958"); // MCCALLUM DR / HART ST
		allStops.put("6034", "6034"); // SHORTHILL DR / MANHATTAN DR
		allStops.put("6883", "6883"); // CORNELL ROUGE BLVD / RIVERLANDS AV
		allStops.put("3715", "3715"); // STEELES AV / CACTUS AV
		allStops.put("3714", "3714"); // STEELES AV / VILLAGE GATE
		allStops.put("3717", "3717"); // STEELES AV / HILDA AV
		allStops.put("3716", "3716"); // STEELES AV STOP # 3716
		allStops.put("6880", "6880"); // CORNELL ROUGE BLVD / WILLIAM FOSTER
		allStops.put("3713", "3713"); // STEELES AV / BATHURST ST
		allStops.put("6446", "6446"); // METRO RD / BIRCH RD
		allStops.put("6881", "6881"); // CORNELL ROUGE BLVD / WILLIAM FOSTER
		allStops.put("3719", "3719"); // STEELES AV STOP # 3719
		allStops.put("5171", "5171"); // THE QUEENSWAY / GLENWOODS AV
		allStops.put("1613", "1613"); // 14TH AV / REDKEY DR
		allStops.put("2954", "2954"); // DON HEAD VILLAGE BLVD / O'CONNOR CR
		allStops.put("6669", "6669"); // LEGACY DR / COTTONTAIL AV
		allStops.put("5170", "5170"); // THE QUEENSWAY / HOLLYWOOD DR
		allStops.put("1189", "1189"); // WELLINGTON ST / GEORGE ST
		allStops.put("4125", "4125"); // THE QUEENSWAY / RIVERGLEN DR
		allStops.put("2955", "2955"); // DON HEAD VILLAGE BLVD / HOUSEMAN CR
		allStops.put("4471", "4471"); // HARRISON DR STOP # 4471
		allStops.put("4473", "4473"); // VELLORE WOODS BLVD / SCARLETT TRL
		allStops.put("4864", "4864"); // MOUNT ALBERT RD / ROYAL OAK RD
		allStops.put("4475", "4475"); // BRISTOL RD STOP # 4475
		allStops.put("4474", "4474"); // LESLIE ST / LESLIE VALLEY DR
		allStops.put("4477", "4477"); // LANGSTAFF RD / TERECAR DR
		allStops.put("5176", "5176"); // WOODBINE AV / DUNNVILLE RD
		allStops.put("6006", "6006"); // BAYVIEW AV / BETHESDA SDRD
		allStops.put("6007", "6007"); // BAYVIEW AV / NEWMAN AV
		allStops.put("6004", "6004"); // ALLAURA BLVD / YONGE ST
		allStops.put("6002", "6002"); // BAYVIEW AV / STOUFFVILLE RD
		allStops.put("6003", "6003"); // BAYVIEW AV / BALLIOL AV
		allStops.put("6000", "6000"); // BAYVIEW AV STOP # 6000
		allStops.put("4678", "4678"); // YONGE ST / INDUSTRIAL PKWY
		allStops.put("2486", "2486"); // YONGE ST / TRAYBORN DR
		allStops.put("4676", "4676"); // YONGE ST / LEVENDALE RD
		allStops.put("4675", "4675"); // HENDERSON DR / MCCLENNY DR
		allStops.put("4674", "4674"); // RED MAPLE / HIGH TECH RD
		allStops.put("4673", "4673"); // SILVER LINDEN DR / QUETICO DR
		allStops.put("2483", "2483"); // YONGE ST / DUNLOP ST
		allStops.put("6008", "6008"); // SNIVELY ST / DRYNOCH AV
		allStops.put("6009", "6009"); // SNIVELY AV / WORTHINGTON AV
		allStops.put("2248", "2248"); // PROSPECT ST / PEARSON ST
		allStops.put("2952", "2952"); // MAJOR MACKENZIE DR / BATHURST ST
		allStops.put("9850", "9850"); // DAVIS DR / HURON HEIGHTS DR
		allStops.put("2652", "2652"); // PARKER AV / PENNY PL
		allStops.put("2244", "2244"); // ELGIN ST / HIBISCUS CRT
		allStops.put("2245", "2245"); // ELGIN ST / BAYVIEW PKWY
		allStops.put("2240", "2240"); // HURON HEIGHTS DR / DAVIS DR
		allStops.put("2241", "2241"); // HURON HEIGHTS DR / BEMAN DR
		allStops.put("2242", "2242"); // WARATAH AV / COLUMBIA CRT
		allStops.put("2243", "2243"); // WARATAH AV / ELGIN ST
		allStops.put("2464", "2464"); // MAIN ST / LONDON RD
		allStops.put("2465", "2465"); // MAIN ST / OLD MAIN ST
		allStops.put("2466", "2466"); // MAIN ST / BEXHILL RD
		allStops.put("2467", "2467"); // MAIN ST / DAVIS DR
		allStops.put("2460", "2460"); // BRISTOL RD / VANDEN BERGH BLVD
		allStops.put("2461", "2461"); // BRISTOL RD / CHESTER AV
		allStops.put("2462", "2462"); // BRISTOL RD / BURFORD ST
		allStops.put("2463", "2463"); // BRISTOL RD / MAIN ST
		allStops.put("5147", "5147"); // BATHURST ST / AUGUSTINE AV
		allStops.put("1298", "1298"); // WHITE'S HILL AV / NINTH LINE
		allStops.put("5142", "5142"); // RAYMERVILLE DR / MCCOWAN RD
		allStops.put("5346", "5346"); // LARRATT LANE / SHAFTSBURY AV
		allStops.put("5140", "5140"); // RAYMERVILLE DR / CAIRNS DR
		allStops.put("5141", "5141"); // RAYMERVILLE DR STOP # 5141
		allStops.put("3401", "3401"); // WILLOWBROOK RD / ABRAHAM AV
		allStops.put("3400", "3400"); // NAPA VALLEY AV / MARCO SGOTTO AV
		allStops.put("3403", "3403"); // WILLOWBROOK RD / CHARNWOOD PL
		allStops.put("5347", "5347"); // FORESTWOOD ST / GEMINI CRES
		allStops.put("3405", "3405"); // WILLOWBROOK RD / INNISBROOK CRES
		allStops.put("3404", "3404"); // NAPA VALLEY AV / SILVER OAKS BLVD
		allStops.put("3407", "3407"); // WILLOWBROOK RD / BRECKONWOOD CRES
		allStops.put("3406", "3406"); // NAPA VALLEY AV / ISLINGTON AV
		allStops.put("3409", "3409"); // WILLOWBROOK RD / HOLM CRES
		allStops.put("4719", "4719"); // HIGHWAY 7 / CHRISTMAN CRT
		allStops.put("2654", "2654"); // PARKER AV / ELM GROVE AV
		allStops.put("6992", "6992"); // ST URBAIN DR / TIGLIO RD
		allStops.put("9787", "9787"); // YONGE / ELGIN MILLS
		allStops.put("5341", "5341"); // CROSSLAND GATE / ALEX DONER DR
		allStops.put("4875", "4875"); // MOUNT ALBERT RD / HIGHWAY 48
		allStops.put("4874", "4874"); // KING ST / MOUNT ALBERT RD
		allStops.put("6445", "6445"); // METRO RD STOP # 6445
		allStops.put("4876", "4876"); // FOODLAND
		allStops.put("4871", "4871"); // KING ST STOP # 4871
		allStops.put("7087", "7087"); // CHILCOTT CRES / FORD WILSON BLVD
		allStops.put("4873", "4873"); // KING ST / MAIN ST
		allStops.put("4872", "4872"); // KING ST / KINGSGATE CRES
		allStops.put("5018", "5018"); // EAGLE ST / DONLIN AV
		allStops.put("5343", "5343"); // LARRATT LANE / CANYON HILL AV
		allStops.put("4879", "4879"); // MOUNT ALBERT RD / WARDEN AV
		allStops.put("4878", "4878"); // MOUNT ALBERT RD / KENNEDY RD
		allStops.put("7151", "7151"); // MURRELL BLVD / BRIARFIELD AV
		allStops.put("6312", "6312"); // WOODBINE AV / VICTORIA SQUARE BLVD
		allStops.put("1186", "1186"); // SOUTH PARK RD / POND DR
		allStops.put("2798", "2798"); // HUNTERS POINT DR / TIFFANY GATE
		allStops.put("2799", "2799"); // HUNTERS POINT DR / GARDEN AV
		allStops.put("6316", "6316"); // WOODSPRING AV / HARVEST HILLS BLVD
		allStops.put("6317", "6317"); // CHURCH ST / WOODBINE AV
		allStops.put("6314", "6314"); // WOODSPRING AV / FOUR SEASONS CRES
		allStops.put("5424", "5424"); // LONGFORD DR / NEWBURY DR
		allStops.put("2060", "2060"); // GORHAM ST / STEWART ST
		allStops.put("2061", "2061"); // GORHAM ST / ALEXANDER RD
		allStops.put("2062", "2062"); // GORHAM ST / DOAK LANE
		allStops.put("2791", "2791"); // PEARSON AV / ROOSEVELT DR
		allStops.put("2064", "2064"); // GORHAM ST / LESLIE ST
		allStops.put("2065", "2065"); // GORHAM ST / NICHOLSON RD
		allStops.put("2066", "2066"); // GORHAM ST STOP # 2066
		allStops.put("2307", "2307"); // LESLIE ST / JACARANDAH DR
		allStops.put("6442", "6442"); // METRO RD / SALVATION ARMY RD
		allStops.put("3930", "3930"); // KEELE ST / RUTHERFORD RD
		allStops.put("1167", "1167"); // MURRAY DR / GOLF LINKS DR
		allStops.put("3374", "3374"); // NEW WESTMINSTER DR / CENTRE ST
		allStops.put("4344", "4344"); // REGENT ST / BAYNARDS LANE
		allStops.put("7166", "7166"); // PORTAGE PKWY / CHRISLEA RD
		allStops.put("1849", "1849"); // WOOTTEN WAY / SIR TRISTRAM PL
		allStops.put("7167", "7167"); // CHRISLEA RD / CHRISLEA RD
		allStops.put("7229", "7229"); // KEELE ST / SCULPTORS GT
		allStops.put("5423", "5423"); // HARRISON DR / CHERRYWOOD DR
		allStops.put("7228", "7228"); // MON SHEONG COURT STOP # 7228
		allStops.put("1181", "1181"); // MURRAY DR / GLASS DR
		allStops.put("6443", "6443"); // METRO RD / SALVATION ARMY RD
		allStops.put("5098", "5098"); // BUR OAK AV STOP # 5098
		allStops.put("5099", "5099"); // BUR OAK AV STOP # 5099
		allStops.put("7243", "7243"); // MAJOR MACKENZIE / HWY 404 CARPOOL LOT
		allStops.put("7242", "7242"); // SENECA COLLEGE STOP # 7242
		allStops.put("5455", "5455"); // HOOVER PARK DR / KRIBS DR
		allStops.put("7240", "7240"); // STEELES AV / KEELE ST
		allStops.put("5090", "5090"); // NINTH LINE STOP # 5090
		allStops.put("3574", "3574"); // STEELES AV STOP # 3574
		allStops.put("3577", "3577"); // STEELES AV / BAYVIEW AV
		allStops.put("3576", "3576"); // STEELES AV / HIGHWAY 27
		allStops.put("5094", "5094"); // YONGE ST STOP # 5094
		allStops.put("5095", "5095"); // CHURCH ST / COUNTRY GLEN RD
		allStops.put("7249", "7249"); // STEELES AV / TAPSCOTT RD
		allStops.put("7248", "7248"); // MURRELL BLVD / RICHARD WALLIS CT
		allStops.put("9780", "9780"); // YONGE / 16TH-CARRVILLE
		allStops.put("4496", "4496"); // BERNARD AV / YORKLAND ST
		allStops.put("2664", "2664"); // YONGE ST / AUBREY AV
		allStops.put("9783", "9783"); // YONGE / MAJOR MACKENZIE
		allStops.put("2662", "2662"); // YONGE ST / ELM GROVE AV
		allStops.put("4492", "4492"); // MARTIN GROVE RD / LEXINGTON AV
		allStops.put("2660", "2660"); // YONGE ST / BLACKFOREST DR
		allStops.put("4490", "4490"); // FINCH AV / MARTIN GROVE RD
		allStops.put("9788", "9788"); // YONGE / ELGIN MILLS
		allStops.put("9789", "9789"); // BERNARD TERMINAL PLATFORM 2
		allStops.put("2482", "2482"); // YONGE ST / CENTRE ST
		allStops.put("6440", "6440"); // METRO RD STOP # 6440
		allStops.put("2668", "2668"); // YONGE ST / STOUFFVILLE RD
		allStops.put("6820", "6820"); // DUNNING AV STOP # 6820
		allStops.put("6821", "6821"); // KENNEDY RD / BECKETT AV
		allStops.put("6822", "6822"); // KENNEDY RD / WILFRED MURISON AV
		allStops.put("6823", "6823"); // EDWARD ST STOP # 6823
		allStops.put("6824", "6824"); // WELLINGTON ST / JOHN WEST WAY
		allStops.put("6825", "6825"); // THE QUEENSWAY / SIMCOE AV
		allStops.put("6826", "6826"); // RAVENSHOE RD / THORNLODGE DR
		allStops.put("6827", "6827"); // ANGUS GLEN BLVD / DANCERS DR
		allStops.put("6828", "6828"); // ANGUS GLEN BLVD / PROSPECTORS DR
		allStops.put("6829", "6829"); // ANGUS GLEN BLVD / POTTERS WHEEL RD
		allStops.put("2934", "2934"); // MAJOR MACKENZIE DR STOP # 2934
		allStops.put("4855", "4855"); // MOUNT ALBERT RD / WILLIAM ST
		allStops.put("2932", "2932"); // JANE ST / TIERRA AV
		allStops.put("2933", "2933"); // JANE ST / GRAND VALLEY BLVD
		allStops.put("2930", "2930"); // MELVILLE AV / MAPLE MEADOWS LANE
		allStops.put("2931", "2931"); // MELVILLE AV / BRANDON GATE DR
		allStops.put("5326", "5326"); // CHURCH ST STOP # 5326
		allStops.put("5324", "5324"); // MAIN ST UNIONVILLE / HIGHWAY 7
		allStops.put("5322", "5322"); // MCCONAGHY CENTRE STOP # 5322
		allStops.put("5321", "5321"); // ROSETOWN APARTMENTS STOP # 5321
		allStops.put("1836", "1836"); // RAYMERVILLE DR / GRAHAM CRES
		allStops.put("6441", "6441"); // METRO RD STOP # 6441
		allStops.put("5328", "5328"); // JOE DALES DR / LAURENDALE AV
		allStops.put("5329", "5329"); // DUNNING AV / CAMERON AV
		allStops.put("1645", "1645"); // ALDEN RD / BENTLEY ST
		allStops.put("1644", "1644"); // WOODBINE AV / SHIELDS CRT
		allStops.put("1647", "1647"); // ALDEN RD / ESNA PARK DR
		allStops.put("1646", "1646"); // WOODBINE AV / MILLER AV
		allStops.put("7013", "7013"); // COTTRELLE BLVD / HIGHWAY 50
		allStops.put("1640", "1640"); // WOODBINE AV / LANARK RD
		allStops.put("3264", "3264"); // WOODBINE AV / JOHN ST
		allStops.put("1642", "1642"); // WOODBINE AV / BURNCREST RD
		allStops.put("1649", "1649"); // DENISON ST / DON PARK RD
		allStops.put("1648", "1648"); // WOODBINE AV / YORKTECH DR
		allStops.put("4228", "4228"); // DON MILLS RD / AU LARGE BLVD
		allStops.put("6864", "6864"); // BATHURST ST / VERDI RD
		allStops.put("6289", "6289"); // JEFFERSON SDRD / SILVER MAPLE RD
		allStops.put("4881", "4881"); // MOUNT ALBERT RD / COLONEL WAYLING B
		allStops.put("5251", "5251"); // EDWARD ST / YONGE ST
		allStops.put("3502", "3502"); // WOODBRIDGE AV / CLARENCE ST
		allStops.put("1164", "1164"); // VALLEYMEDE DR / BLACKMORE AV
		allStops.put("3796", "3796"); // JANE ST / PEELAR RD
		allStops.put("5008", "5008_merged_3513102"); // 404 TOWN CENTRE STOP # 5008
		allStops.put("4479", "4479"); // FINCH AV / HUMBER COLLEGE BLVD
		allStops.put("1165", "1165"); // MURRAY DR / SEATON DR
		allStops.put("4229", "4229"); // DON MILLS RD / BEDLE AV
		allStops.put("1166", "1166"); // VALLEYMEDE DR / BRIGGS AV
		allStops.put("3594", "3594"); // OLD WESTON RD / STEELES AV
		allStops.put("2808", "2808"); // EDGAR AV STOP # 2808
		allStops.put("6496", "6496"); // HIGHWAY 27 / TORONTO RV RD
		allStops.put("7127", "7127"); // LESLIE ST / BROUGHTON LN
		allStops.put("6177", "6177"); // 155 MAIN ST NORTH STOP # 6177
		allStops.put("2802", "2802"); // GARDEN AV / YONGE ST
		allStops.put("2803", "2803"); // GARDEN AV / PEARSON AV
		allStops.put("5655", "5655"); // BATHURST ST / BLOOMINGTON RD
		allStops.put("2801", "2801"); // GARDEN AV / YONGE ST
		allStops.put("2806", "2806"); // PEARSON AV / SCOTT DR
		allStops.put("2807", "2807"); // PEARSON AV / EDGAR AV
		allStops.put("2804", "2804"); // PEARSON AV / ROOSEVELT DR
		allStops.put("4360", "4360"); // MAIN ST UNIONVILLE / STATION LANE
		allStops.put("5432", "5432"); // HEMLOCK DR / HAZELNUT PL
		allStops.put("2154", "2154"); // SPRINGHEAD GDNS / PLAISANCE RD
		allStops.put("7094", "7094"); // MEMORIAL CIR / HARDEN TRL
		allStops.put("5431", "5431"); // HEMLOCK DR / DEBBORAH PL
		allStops.put("5436", "5436"); // TENTH LINE / HOOVER PARK DR
		allStops.put("7093", "7093"); // MEMORIAL CIR / POPPY LN
		allStops.put("1427", "1427"); // RODICK RD / RACHEL CRES
		allStops.put("2155", "2155"); // SPRINGHEAD GDNS / PLAISANCE RD
		allStops.put("1429", "1429"); // RODICK RD / EYER DR
		allStops.put("1428", "1428"); // CLARK AV / YORKHILL BLVD
		allStops.put("5438", "5438"); // HOOVER PARK DR / THICKETWOOD BLVD
		allStops.put("6492", "6492"); // METRO RD / THIRD AV
		allStops.put("3360", "3360"); // NEW WESTMINSTER DR / CONLEY ST
		allStops.put("4983", "4983"); // SAVAGE RD / SANDFORD ST
		allStops.put("7098", "7098"); // WOODBINE AV STOP #7098
		allStops.put("7099", "7099"); // ASPENWOOD DR / YONGE ST
		allStops.put("7147", "7147"); // MURRELL BLVD / TEMPLE AV
		allStops.put("4982", "4982"); // SAVAGE RD / REVELL RD
		allStops.put("1899", "1899"); // HARVEST MOON DR / CLAYTON DR
		allStops.put("6171", "6171"); // MANHATTAN DR / FORTY SECOND ST
		allStops.put("5456", "5456"); // HOOVER PARK DR / JACOB WAY
		allStops.put("2001", "2001"); // LESLIE ST / STACKHOUSE RD
		allStops.put("4273", "4273"); // EDGELEY BLVD / LANGSTAFF RD
		allStops.put("9815", "9815"); // FINCH / SENECA HILL
		allStops.put("4271", "4271"); // MAJOR MACKENZIE DR / WARDEN AV
		allStops.put("1358", "1358"); // BUR OAK AV / STONEBRIDGE DR
		allStops.put("4277", "4277"); // ABERDEEN AV / ASHCROFT CRT
		allStops.put("4276", "4276"); // ABERDEEN AV / ALLISTON RD
		allStops.put("4275", "4275"); // EDGELEY BLVD / COURTLAND AV
		allStops.put("4274", "4274"); // ABERDEEN AV / CHANCELLOR DR
		allStops.put("1353", "1353"); // HENDERSON AV / JOHN ST
		allStops.put("1352", "1352"); // BUR OAK AV / GLENBROOK DR
		allStops.put("1351", "1351"); // JOHN ST / BAYWOOD GATE
		allStops.put("2153", "2153"); // SPRINGHEAD GDNS / BAIF BLVD
		allStops.put("1357", "1357"); // HENDERSON AV / CLARK AV
		allStops.put("1356", "1356"); // BUR OAK AV / BELGRAVE SQ
		allStops.put("6867", "6867"); // NINTH LINE / FERNGLEN CR
		allStops.put("4368", "4368"); // SILVER LINDEN DR / BANTRY AV
		allStops.put("9869", "9869"); // HIGHWAY 7 / SCIBERRAS RD
		allStops.put("6240", "6240"); // CLEARMEADOW BLVD / BATHURST
		allStops.put("6488", "6488"); // HIGHWAY 7 / TOWN CENTRE BLVD
		allStops.put("6489", "6489"); // METRO RD / MEDINA DR
		allStops.put("5550", "5550"); // ROUGE BANK DR / NINTH LINE
		allStops.put("6241", "6241"); // CLEARMEADOW BLVD / BATHURST ST
		allStops.put("6482", "6482"); // WOODBINE AV / WEXFORD DR
		allStops.put("9860", "9860"); // VAUGHAN METROPOLITAN CENTRE WESTBOUND
		allStops.put("6952", "6952"); // NAPA VALLEY AV / ISLINGTON AV
		allStops.put("6481", "6481"); // WOODBINE AV / RIVEREDGE DR
		allStops.put("9865", "9865"); // HIGHWAY 7 / WARDEN AV
		allStops.put("6487", "6487"); // METRO RD / SHEPPARD AV
		allStops.put("9867", "9867"); // HIGHWAY 7 / VILLAGE PKWY
		allStops.put("9866", "9866"); // HIGHWAY 7 / WARDEN AV
		allStops.put("4858", "4858"); // MOUNT ALBERT RD / WARDEN AV
		allStops.put("5750", "5750"); // BATHURST ST / BEVERLEY GLEN BLVD
		allStops.put("2016", "2016"); // MULOCK DR / YONGE ST
		allStops.put("6244", "6244"); // WELLINGTON ST E / VICTORIA ST
		allStops.put("4902", "4902"); // ROYAL ORCHARD BLVD / YONGE ST
		allStops.put("4885", "4885"); // GREEN LANE / KINGS COLLEGE RD
		allStops.put("4955", "4955"); // ANGUS GLEN BLVD / KENNEDY RD
		allStops.put("6774", "6774"); // ZENWAY BLVD STOP # 6774
		allStops.put("5523", "5523"); // MAIN ST MARKHAM / ROBINSON ST
		allStops.put("1519", "1519"); // CARLTON RD / MAIN ST UNIONVILLE
		allStops.put("1518", "1518"); // BOXWOOD CRES STOP # 1518
		allStops.put("6775", "6775"); // ZENWAY BLVD / NEW ENTERPRISE WAY
		allStops.put("1515", "1515"); // CARLTON RD / KENNEDY RD
		allStops.put("1514", "1514"); // ROXBURY ST / PEARMAIN CRT
		allStops.put("1517", "1517"); // CARLTON RD / OLD IVY LANE
		allStops.put("2012", "2012"); // MULOCK DR / KENT DR
		allStops.put("1511", "1511"); // CARLTON RD / FAWNBROOK CIR
		allStops.put("4752", "4752"); // WELLINGTON ST / MARY ST
		allStops.put("1513", "1513"); // CARLTON RD / LORING CRES
		allStops.put("1512", "1512"); // CHATELAINE DR / ROXBURY ST
		allStops.put("6962", "6962"); // VAUGHAN MILLS RD / THOMSON CREEK BL
		allStops.put("4753", "4753"); // CONOVER AV / SPRING FARM RD
		allStops.put("6770", "6770"); // BAYVIEW AV / SUMMIT TRAIL
		allStops.put("9708", "9708_merged_3513108"); // HWY 7 / ANSLEY GROVE
		allStops.put("4886", "4886"); // GREEN LANE / WILLOWBROOK RD
		allStops.put("6771", "6771"); // LONDON RD / ERIN TRAIL
		allStops.put("5883", "5883"); // BERNARD TERMINAL PLATFORM 4
		allStops.put("3439", "3439"); // SIMONSTON BLVD / DON MILLS RD
		allStops.put("9723", "9723"); // RICHMOND HILL CENTRE PLATFORM 4
		allStops.put("5886", "5886"); // LESLIE ST / BOGART MILL TRL
		allStops.put("5885", "5885"); // LESLIE ST / BOGARTOWN CRV
		allStops.put("1735", "1735"); // MAJOR MACKENZIE DR STOP # 1735
		allStops.put("4859", "4859"); // MOUNT ALBERT RD / KENNEDY RD
		allStops.put("5889", "5889"); // FOUR VALLEY DR STOP # 5889
		allStops.put("6773", "6773"); // ZENWAY BLVD / VAUGHAN VALLEY BLVD
		allStops.put("4478", "4478"); // FINCH AV / HALESIA DR
		allStops.put("4897", "4897"); // ROYAL ORCHARD BLVD / BLUE SPRUCE LA
		allStops.put("6554", "6554"); // COPPER CREEK DR STOP # 6554
		allStops.put("6556", "6556"); // WOODBINE AV / RAVENSHOE RD
		allStops.put("6940", "6940"); // HOOVER PARK DR / GREENFOREST GR
		allStops.put("6550", "6550"); // KENILWORTH GATE / MICHELINA TER
		allStops.put("6551", "6551"); // KENILWORTH GATE / THE BARLEY LEA ST
		allStops.put("6552", "6552"); // MARKHAM BOXGROVE PLAZA STOP # 6552
		allStops.put("6553", "6553"); // MARKHAM BOXGROVE PLAZA STOP # 6553
		allStops.put("7256", "7256"); // KEELE ST / STEELES AV
		allStops.put("1422", "1422"); // CLARK AV / ATKINSON AV
		allStops.put("7124", "7124"); // MAIN ST / MOHAWK GT
		allStops.put("6448", "6448"); // DALTON RD / BLACK RIVER RD
		allStops.put("9720", "9720"); // PROMENADE TERMINAL PLATFORM 7
		allStops.put("3183", "3183"); // MURAL ST / LEEK CRES
		allStops.put("4422", "4422"); // PROMENADE CIR / EAST PROMENADE
		allStops.put("1073", "1073"); // SHIRLEY DR / BAYFIELD DR
		allStops.put("7119", "7119"); // STOUFFVILLE RD / GORMLEY RD E
		allStops.put("2135", "2135"); // NEWKIRK RD / SHELLEY RD
		allStops.put("6321", "6321"); // UPPER YONGE PLACE
		allStops.put("3541", "3541"); // MARTIN GROVE RD / DOLORES CRES
		allStops.put("9810", "9810"); // MARKHAM STOUFFVILLE HOSPITAL
		allStops.put("3397", "3397"); // ROYAL ORCHARD BLVD / BAYVIEW AV
		allStops.put("4857", "4857"); // MOUNT ALBERT RD / WOODBINE AV
		allStops.put("6631", "6631"); // WESTON RD / MAJOR MACKENZIE DR
		allStops.put("6630", "6630"); // HOLLANDVIEW TRL / STECKLEY ST
		allStops.put("6633", "6633"); // SPRINGHEAD GDNS / RATHFON CRES
		allStops.put("6632", "6632"); // HIGH TECH RD / BAYVIEW AV
		allStops.put("6635", "6635"); // HIGHWAY 7 / LESLIE ST
		allStops.put("6634", "6634"); // HIGHWAY 7 / LESLIE ST
		allStops.put("6637", "6637"); // HIGHWAY 7 / COMMERCE VALLEY DR WEST
		allStops.put("6636", "6636"); // HIGHWAY 7 / TIMES AV
		allStops.put("7118", "7118"); // STOUFFVILLE RD / GORMLEY RD E
		allStops.put("6667", "6667"); // PUGSLEY AV / CENTRE ST
		allStops.put("4019", "4019"); // DUFFERIN ST / LANGSTAFF RD
		allStops.put("4018", "4018"); // DUFFERIN ST / RACCO PKWY
		allStops.put("6281", "6281"); // KING RD / TOSCANINI RD
		allStops.put("4661", "4661"); // KENNEDY ST / CORNER RIDGE RD
		allStops.put("1954", "1954"); // LESLIE ST STOP # 1954
		allStops.put("4013", "4013"); // DUFFERIN ST STOP # 4013
		allStops.put("4012", "4012"); // DUFFERIN ST / GLEN SHIELDS AV
		allStops.put("4011", "4011"); // DUFFERIN ST / STEELES AV
		allStops.put("4010", "4010"); // DUFFERIN ST / STEELES AV
		allStops.put("1897", "1897"); // HARVEST MOON DR / APPLEBY CRES
		allStops.put("4016", "4016"); // DUFFERIN ST / CENTRE ST
		allStops.put("4015", "4015"); // DUFFERIN ST STOP # 4015
		allStops.put("4014", "4014"); // DUFFERIN ST / CLARK AV
		allStops.put("9885", "9885"); // MAIN ST UNIONVILLE
		allStops.put("9884", "9884"); // MAIN ST UNIONVILLE
		allStops.put("3988", "3988"); // KEELE ST STOP # 3988
		allStops.put("3989", "3989"); // KEELE ST STOP # 3989
		allStops.put("3984", "3984"); // MELVILLE AV / PARKTREE DR
		allStops.put("3985", "3985"); // KEELE ST / GANTNER GATE
		allStops.put("3986", "3986"); // KEELE ST STOP # 3986
		allStops.put("3987", "3987"); // KEELE ST STOP # 3987
		allStops.put("3980", "3980"); // AMERICA AV / JOHN DEISMAN BLVD
		allStops.put("3981", "3981"); // JOHN DEISMAN BLVD / TIERRA AV
		allStops.put("3982", "3982"); // TIERRA AV / DISCOVERY TRL
		allStops.put("3983", "3983"); // TIERRA AV / JANE ST
		allStops.put("3610", "3610"); // OLD WESTON RD / STEELES AV
		allStops.put("1890", "1890"); // KENNEDY RD / CLAYTON DR
		allStops.put("9843", "9843"); // DAVIS DR / LONGFORD DR
		allStops.put("3399", "3399"); // WILLOWBROOK RD / TRIMBLE CRT
		allStops.put("5796", "5796"); // TESTON RD / QUAIL RUN BLVD
		allStops.put("6125", "6125"); // HARDING BLVD / KERSEY CRES
		allStops.put("6124", "6124"); // CASTAN AV / SABISTON DR
		allStops.put("6127", "6127"); // MCCOWAN RD STOP # 6127
		allStops.put("6126", "6126"); // MCCOWAN RD STOP # 6126
		allStops.put("6121", "6121"); // REEVES WAY BLVD STOP # 6121
		allStops.put("6120", "6120"); // NORTH LAKE RD / OLDE BAYVIEW AV
		allStops.put("6123", "6123"); // CASTAN AV / SABISTON DR
		allStops.put("6122", "6122"); // BUR OAK AV / MAYBREEZE RD
		allStops.put("6129", "6129"); // RAVENSHOE RD STOP # 6129
		allStops.put("6128", "6128"); // THE QUEENSWAY / RAVENSHOE RD
		allStops.put("1471", "1471"); // BUCHANAN DR / FENWICK CRES
		allStops.put("1447", "1447"); // JOHN BUTTON BLVD / MELCHIOR CRES
		allStops.put("4705", "4705"); // YONGE ST / BROOKSIDE RD
		allStops.put("4704", "4704"); // HIGHWAY 7 / LAIDLAW BLVD
		allStops.put("4703", "4703"); // HIGHWAY 7 / ROBINSON ST
		allStops.put("4701", "4701"); // HIGHWAY 7 / WINDRIDGE DR
		allStops.put("4700", "4700"); // HIGHWAY 7 / ALBERT ST
		allStops.put("1891", "1891"); // KENNEDY RD / STEELES AV
		allStops.put("2328", "2328"); // FINCH GO BUS TERMINAL PLATFORM 8
		allStops.put("5795", "5795"); // TESTON RD / TORAH GATE
		allStops.put("1112", "1112"); // SHIRLEY DR / BAYFIELD DR
		allStops.put("4426", "4426"); // BLOOMINGTON RD / BLOOMFIELD TRL
		allStops.put("3619", "3619"); // STEELES AV / CAPSTAN GATE
		allStops.put("1495", "1495"); // CARLTON RD / KENNEDY RD
		allStops.put("1443", "1443"); // JOHN BUTTON BLVD / MILLBROOK GATE
		allStops.put("1442", "1442"); // GLEN SHIELDS AV / CROOKED STICK RD
		allStops.put("3760", "3760"); // WESTON RD / LA ROCCA AV
		allStops.put("7254", "7254"); // BATHURST ST / HIGHWAY 7
		allStops.put("3762", "3762"); // WESTON RD / ASTONA BLVD
		allStops.put("3763", "3763"); // WESTON RD / VALERIA BLVD
		allStops.put("3764", "3764"); // WESTON RD / GREENPARK BLVD
		allStops.put("3765", "3765"); // WESTON RD / LANGSTAFF RD
		allStops.put("3766", "3766"); // WESTON RD / GREGORY GATE
		allStops.put("7255", "7255"); // GLENWOODS AV / LOWNDES AV
		allStops.put("3768", "3768"); // WESTON RD / BLUE WILLOW DR
		allStops.put("3769", "3769"); // WESTON RD / FIELDSTONE DR
		allStops.put("2607", "2607"); // DAVIS DR / MAIN ST
		allStops.put("1116", "1116"); // FARMSTEAD RD / SHELL CRT
		allStops.put("4853", "4853"); // MOUNT ALBERT RD / CHARLES ST
		allStops.put("4310", "4310"); // MAJOR MACKENZIE DR / VELLORE WOODS
		allStops.put("4427", "4427"); // ELGIN MILLS RD STOP # 4427
		allStops.put("6549", "6549"); // BAYVIEW AV / FOREST RIDGE RD
		allStops.put("1792", "1792"); // MAIN ST / PARK DR
		allStops.put("1561", "1561"); // NINTH LINE / ROSE WAY
		allStops.put("1031", "1031"); // DONCASTER AV STOP # 1031
		allStops.put("4435", "4435"); // ELGIN MILLS RD / BAYVIEW AV
		allStops.put("6019", "6019"); // BAYVIEW AV / SNIVELY ST
		allStops.put("9705", "9705_merged_3513099"); // HWY 7 / PINE VALLEY
		allStops.put("6011", "6011"); // AUTUMN HILL BLVD / REDMOND DR
		allStops.put("6010", "6010"); // AUTUMN HILL BLVD / REDMOND DR
		allStops.put("4648", "4648"); // LORNE AV / DAVIS DR
		allStops.put("1291", "1291"); // DENISON ST STOP # 1291
		allStops.put("6015", "6015"); // WRIGHT ST / YONGE ST
		allStops.put("6108", "6108"); // RAYMERVILLE DR / HIGGINSON ST
		allStops.put("6017", "6017"); // WORTHINGTON AV / BLOOMINGTON RD
		allStops.put("6016", "6016"); // WORTHINGTON AV / PARADELLE DR
		allStops.put("4642", "4642"); // SANDFORD ST / HANDLEY CRES
		allStops.put("6018", "6018"); // BLOOMINGTON AV / BAYVIEW AV
		allStops.put("4640", "4640"); // SANDFORD ST / MULOCK DR
		allStops.put("4641", "4641"); // SANDFORD ST / LLOYD ST
		allStops.put("2192", "2192"); // NEWKIRK RD / SHELLEY RD
		allStops.put("4644", "4644"); // WELLINGTON ST / BATHURST ST
		allStops.put("4645", "4645"); // LORNE AV / PARK AV
		allStops.put("4424", "4424"); // ABERDEEN AV / ANDREA LANE
		allStops.put("6891", "6891"); // MAJOR MACKENZIE DR / WOODEND PL
		allStops.put("4630", "4630"); // RICHMOND GREEN H.S. STOP # 4630
		allStops.put("1294", "1294"); // BUR OAK AV / WHITE'S HILL AV
		allStops.put("2258", "2258"); // BAYVIEW AV / STONE RD
		allStops.put("2257", "2257"); // BAYVIEW AV / WELLINGTON ST
		allStops.put("2256", "2256"); // BAYVIEW AV / RIVER RIDGE BLVD
		allStops.put("2255", "2255"); // BAYVIEW AV / PEDERSEN DR
		allStops.put("2254", "2254"); // BAYVIEW AV STOP # 2254
		allStops.put("2253", "2253"); // BAYVIEW AV / ST. JOHN'S SDRD
		allStops.put("2252", "2252"); // BAYVIEW AV / LAURELWOOD GATE
		allStops.put("2251", "2251"); // BAYVIEW AV / SILKEN LAUMANN DR
		allStops.put("2250", "2250"); // BAYVIEW AV / MCBEAN AV
		allStops.put("5159", "5159"); // REDSTONE RD / ELGIN MILLS RD
		allStops.put("5158", "5158"); // REDSTONE RD / ALVARADO AV
		allStops.put("2475", "2475"); // YONGE ST / WELDRICK RD
		allStops.put("3224", "3224"); // COCHRANE DR STOP # 3224
		allStops.put("2472", "2472"); // YONGE ST / SPRUCE AV
		allStops.put("2471", "2471"); // YONGE ST / NORTHERN HEIGHTS DR
		allStops.put("2470", "2470"); // YONGE ST / BERESFORD DR
		allStops.put("1589", "1589"); // BOXWOOD CRES / BRETTON CIR
		allStops.put("5153", "5153"); // BASALTIC RD / MOYAL CRT
		allStops.put("2197", "2197"); // NEWKIRK RD / ELGIN MILLS RD
		allStops.put("5155", "5155"); // KEELE ST STOP # 5155
		allStops.put("4852", "4852"); // WOOTTEN WAY / LINDEN LEA ST
		allStops.put("2479", "2479"); // YONGE ST / ELMWOOD AV
		allStops.put("2478", "2478"); // YONGE ST / HARDING BLVD
		allStops.put("6890", "6890"); // PINE VALLEY DR / MAJOR MACKENZIE DR
		allStops.put("1790", "1790"); // MAIN ST / EDWARD ST
		allStops.put("4090", "4090"); // WOODBINE AV / MORTON AV
		allStops.put("4536", "4536"); // KEELE ST / KIRBY RD
		allStops.put("4756", "4756"); // BUR OAK AV / COUNTRY GLEN RD
		allStops.put("2785", "2785"); // AVENUE RD / BIRCH AV
		allStops.put("3227", "3227"); // LANARK RD / WOODBINE AV
		allStops.put("4802", "4802"); // MCNAUGHTON RD / ST. JOAN OF ARC AV
		allStops.put("2786", "2786"); // AVENUE RD / DENHAM DR
		allStops.put("2781", "2781"); // KERSEY CRES / MAY AV
		allStops.put("2780", "2780"); // KERSEY CRES / DON HEAD VILLAGE BLVD
		allStops.put("2783", "2783"); // KERSEY CRES / WELDRICK RD
		allStops.put("2782", "2782"); // KERSEY CRES / YONGEHURST RD
		allStops.put("4808", "4808"); // MAJOR MACKENZIE DR / WILLIAM BERCZY
		allStops.put("4809", "4809"); // MAJOR MACKENZIE DR / RIDGECREST RD
		allStops.put("4094", "4094"); // WOODBINE AV / BISCAYNE BLVD
		allStops.put("2789", "2789"); // PEARSON AV / SCOTT DR
		allStops.put("2788", "2788"); // PEARSON AV / EDGAR AV
		allStops.put("6893", "6893"); // VIA CAMPANILE / VIA BORGHESE
		allStops.put("5289", "5289"); // WALMART STOP # 5289
		allStops.put("2079", "2079"); // EAGLE ST / ELLEN ST
		allStops.put("2078", "2078"); // EAGLE ST / CHURCH ST
		allStops.put("1331", "1331"); // JOHN ST / STEELCASE RD
		allStops.put("6308", "6308"); // ENTERPRISE DR / MAIN STREET
		allStops.put("6305", "6305"); // TONY WONG PLACE / KENNEDY RD
		allStops.put("6304", "6304"); // EDGELEY BLVD / BASS PRO MILLS DR
		allStops.put("6307", "6307"); // FINCH AV / WESTMORE DR
		allStops.put("3680", "3680"); // STEELES AV STOP # 3680
		allStops.put("6301", "6301"); // MARY ST / WELLINGTON ST
		allStops.put("2076", "2076"); // GORHAM ST / PROSPECT ST
		allStops.put("6303", "6303"); // HOOVER PARK DR / JACOB WAY
		allStops.put("6302", "6302"); // HOOVER PARK DR / BYERS POND WAY
		allStops.put("4633", "4633"); // ISLINGTON AV STOP # 4633
		allStops.put("4829", "4829"); // BAYVIEW AV STOP # 4829
		allStops.put("5027", "5027_merged_3513012"); // BAYVIEW AV / BALLYMORE DR
		allStops.put("1980", "1980"); // YONGE ST / DAWSON MANOR BLVD
		allStops.put("6892", "6892"); // MAJOR MACKENZIE DR / VIA CAMPANILE
		allStops.put("4441", "4441"); // LESLIE ST / COLONEL WAYLING BLVD
		allStops.put("3221", "3221"); // COCHRANE DR / EAST VALHALLA DR
		allStops.put("1590", "1590"); // HOLLINGHAM RD / BRANTWOOD CRT
		allStops.put("9842", "9842"); // CEDARLAND DR / WARDEN AV
		allStops.put("3509", "3509"); // STEELES AV STOP # 3509
		allStops.put("5089", "5089"); // NINTH LINE STOP # 5089
		allStops.put("5088", "5088"); // NINTH LINE / HOOVER PARK DR
		allStops.put("7276", "7276"); // MAIN ST / STOUFFER ST
		allStops.put("7277", "7277"); // BAKER HILL BLVD / MILLARD ST
		allStops.put("7274", "7274"); // TENTH LINE / KATHERINE CR
		allStops.put("7275", "7275"); // MAIN ST STOP # 7275
		allStops.put("5083", "5083"); // WALMART STOP # 5083
		allStops.put("3501", "3501"); // STEELES AV / GRANDVIEW AV
		allStops.put("5081", "5081"); // WELLINGTON ST / STRONACH BLVD
		allStops.put("5080", "5080"); // WELLINGTON ST / CONOVER AV
		allStops.put("3504", "3504"); // STEELES AV / MARKBROOK LANE
		allStops.put("1779", "1779"); // MILLARD ST / ALDERWOOD ST
		allStops.put("3506", "3506"); // STEELES AV / KIPLING AV
		allStops.put("5084", "5084"); // HIGHWAY 48 / MAIN ST
		allStops.put("9793", "9793"); // YONGE / 19TH-GAMBLE
		allStops.put("9792", "9792"); // YONGE / 19TH-GAMBLE
		allStops.put("2673", "2673"); // ROLLINGHILL RD / SKYWOOD DR
		allStops.put("2672", "2672"); // YONGE ST / OXFORD ST
		allStops.put("2675", "2675"); // TOWER HILL RD / MOCKINGBIRD DR
		allStops.put("2674", "2674"); // ROLLINGHILL RD / TOWER HILL RD
		allStops.put("2677", "2677"); // TOWER HILL RD / EDELWEISS AV
		allStops.put("2676", "2676"); // TOWER HILL RD / EDELWEISS AV
		allStops.put("2679", "2679"); // TOWER HILL RD / ROLLINGHILL RD
		allStops.put("2678", "2678"); // TOWER HILL RD / WICKER DR
		allStops.put("9799", "9799"); // YONGE / HENDERSON
		allStops.put("9798", "9798"); // YONGE / HENDERSON
		allStops.put("6833", "6833"); // ANGUS GLEN BLVD / STOLLERY POND CRE
		allStops.put("6832", "6832"); // ANGUS GLEN BLVD / STOLLERY POND CRE
		allStops.put("6831", "6831"); // ANGUS GLEN BLVD / STOLLERY POND CRE
		allStops.put("6830", "6830"); // ANGUS GLEN BLVD / POTTERS WHEEL RD
		allStops.put("6837", "6837"); // ANGUS GLEN BLVD / ROYAL COUNTY DOWN
		allStops.put("6836", "6836"); // ANGUS GLEN BLVD / GLENGORDON CRES
		allStops.put("6835", "6835"); // ANGUS GLEN BLVD / GLENGORDON CRES
		allStops.put("6834", "6834"); // ANGUS GLEN BLVD / STOLLERY POND CRE
		allStops.put("6894", "6894"); // VIA CAMPANILE / MARIA ANTONIA DR
		allStops.put("2920", "2920"); // EAST BEAVER CREEK RD / HIGHWAY 7
		allStops.put("6839", "6839"); // ANGUS GLEN BLVD / ROYAL TROON CRES
		allStops.put("6838", "6838"); // ANGUS GLEN BLVD / ROYAL COUNTY DOWN
		allStops.put("2925", "2925"); // EAST BEAVER CREEK RD / SIMS CRES
		allStops.put("2924", "2924"); // EAST BEAVER CREEK RD / WILMOT ST
		allStops.put("2927", "2927"); // MURAL ST / EAST BEAVER CREEK RD
		allStops.put("6895", "6895"); // DAVOS RD / VIA CAMPANILE
		allStops.put("5331", "5331"); // GREEN LANE / HUNTINGTON PARK DR
		allStops.put("4513", "4513"); // WOOD RIM DR / NORTH LAKE RD
		allStops.put("5333", "5333"); // SOUTHLAKE HEALTH CENTRE STOP # 5333
		allStops.put("2900", "2900"); // BAYVIEW AV STOP # 2900
		allStops.put("5334", "5334"); // NEWMARKET HEALTH CENTRE STOP # 5334
		allStops.put("5157", "5157"); // SUMMERIDGE DR / TREECREST DR
		allStops.put("6757", "6757"); // HONDA BLVD / WOODBINE AV
		allStops.put("5339", "5339"); // SENIORS' MEETING PLACE STOP # 5339
		allStops.put("3223", "3223"); // COCHRANE DR STOP # 3223
		allStops.put("6850", "6850"); // KENNEDY RD / CASTAN AV
		allStops.put("3214", "3214"); // ALLSTATE PKWY / CENTURIAN DR
		allStops.put("3215", "3215"); // EAST VALHALLA DR / HIGHWAY 7
		allStops.put("3216", "3216"); // COCHRANE DR / COCHRANE DR
		allStops.put("1633", "1633"); // 14TH AV / CROWN STEEL DR
		allStops.put("1982", "1982"); // EAGLE ST / JOHN BOWSER CRES
		allStops.put("3211", "3211"); // RENFREW DR / HOOPER RD
		allStops.put("3212", "3212"); // RENFREW DR / VALLEYWOOD DR
		allStops.put("3213", "3213"); // VALLEYWOOD DR / ALLSTATE PKWY
		allStops.put("1638", "1638"); // WOODBINE AV / HIGHWAY 7
		allStops.put("6765", "6765"); // CLEGG RD STOP # 6765
		allStops.put("2904", "2904"); // BAYVIEW AV / BLACKMORE AV
		allStops.put("3218", "3218"); // FRONTENAC DR STOP # 3218
		allStops.put("3219", "3219"); // CENTURIAN DR / FRONTENAC DR
		allStops.put("1988", "1988"); // YONGE ST / CLEARMEADOW BLVD
		allStops.put("4690", "4690"); // YONGE ST / TRAYBORN DR
		allStops.put("7221", "7221_merged_3513106"); // SMARTCENTRES PLACE BUS TERMINAL
		allStops.put("3222", "3222"); // COCHRANE DR STOP # 3222
		allStops.put("4876", "4876_merged_3513022"); // FOODLAND
		allStops.put("7097", "7097"); // AURORA PARK AND RIDE PLATFORM 2
		allStops.put("2909", "2909"); // 16TH AV / VALLEYMEDE DR
		allStops.put("5345", "5345"); // LARRATT LANE STOP # 5345
		allStops.put("2815", "2815"); // HARDING BLVD / MAJOR MACKENZIE DR
		allStops.put("2814", "2814"); // KERSEY CRES / HARDING BLVD
		allStops.put("2817", "2817"); // TRENCH ST / RICHMOND ST
		allStops.put("2816", "2816"); // TRENCH ST / MAJOR MACKENZIE DR
		allStops.put("2811", "2811"); // KERSEY CRES / YONGEHURST RD
		allStops.put("6596", "6596"); // LESLIE ST / ELGIN MILLS RD
		allStops.put("2813", "2813"); // KERSEY CRES / DON HEAD VILLAGE BLVD
		allStops.put("2812", "2812"); // KERSEY CRES / MAY AV
		allStops.put("2819", "2819"); // BAYVIEW AV / ARDWOLD GATE
		allStops.put("2818", "2818"); // TRENCH ST / MILL ST
		allStops.put("6449", "6449_merged_3513098"); // DALTON RD / BLACK RIVER RD
		allStops.put("5069", "5069"); // MOUNT ALBERT RD / 2ND CONCESSION RD
		allStops.put("3178", "3178"); // MURAL ST STOP # 3178
		allStops.put("2037", "2037"); // SYKES RD / ALEX DONER DR
		return allStops;
	}

	private static HashMap<String, String> init2(HashMap<String, String> allStops) {
		allStops.put("6987", "6987"); // LESLIE ST STOP # 6987
		allStops.put("4209", "4209"); // DON MILLS RD / FINCH AV
		allStops.put("5086", "5086"); // MAIN ST / RINGWOOD DR
		allStops.put("7081", "7081"); // BETTY ROMAN BLVD / PRINCE REGENT ST
		allStops.put("1483", "1483"); // CARLTON RD / MCKAY CRES
		allStops.put("7083", "7083"); // PEFFERLAW RD / FLORENCE DR
		allStops.put("7082", "7082"); // BETTY ROMAN BLVD / VICTORIA SQUARE
		allStops.put("5429", "5429"); // MILLARD ST / OPAL CRT
		allStops.put("5428", "5428"); // MILLARD ST / IRONWOOD CRES
		allStops.put("3379", "3379"); // RUTHERFORD RD / FOREST FOUNTAIN DR
		allStops.put("7086", "7086"); // CITYVIEW BLVD STOP #7086
		allStops.put("7089", "7089"); // BATHURST ST / SYKES RD
		allStops.put("7088", "7088"); // CARLISSA RUN / FORD WILSON BLVD
		allStops.put("5427", "5427"); // MILLARD ST / EDWARD ST
		allStops.put("1185", "1185"); // MURRAY DR / MOSAICS AV
		allStops.put("5421", "5421"); // LONDON RD / YORKSHIRE DR
		allStops.put("5420", "5420"); // LONDON RD / HAREWOOD BLVD
		allStops.put("1180", "1180"); // TIMES AV / GALLERIA PKWY
		allStops.put("5422", "5422"); // LONDON RD / OSMOND CRES
		allStops.put("1160", "1160"); // VALLEYMEDE DR / STRATHEARN AV
		allStops.put("2036", "2036"); // BATHURST ST / KEITH AV
		allStops.put("7033", "7033"); // WILFRED MURISON AV / HUBNER AV
		allStops.put("1748", "1748"); // JOHN WEST WAY / AMBERHILL WAY
		allStops.put("1749", "1749"); // JOHN WEST WAY / OCHALSKI RD
		allStops.put("9806", "9806"); // YONGE / MULOCK
		allStops.put("1744", "1744"); // YONGE ST / CHURCH ST
		allStops.put("5498", "5498"); // LESLIE ST STOP # 5498
		allStops.put("1746", "1746"); // WELLINGTON ST / INDUSTRIAL PKWY
		allStops.put("1747", "1747"); // JOHN WEST WAY / WELLINGTON ST
		allStops.put("1740", "1740"); // YONGE ST / KENNEDY ST
		allStops.put("6462", "6462"); // DALTON RD STOP # 6462
		allStops.put("1486", "1486"); // 14TH AV / KENNEDY RD
		allStops.put("6495", "6495"); // KEELE ST STOP # 6495
		allStops.put("6494", "6494"); // ROLLINGHILL RD / GREENBANK DR
		allStops.put("6497", "6497"); // HIGHWAY 27 / TORONTO RV RD
		allStops.put("6463", "6463"); // DALTON RD / GREW BLVD
		allStops.put("6491", "6491"); // METRO RD / THIRD AV
		allStops.put("6490", "6490"); // METRO RD / MEDINA DR
		allStops.put("6493", "6493"); // TOWER HILL RD / YONGE ST
		allStops.put("2429", "2429"); // ST. JOHN'S SDRD / TRENT ST
		allStops.put("5668", "5668"); // JEFFERSON SDRD / SILVER MAPLE RD
		allStops.put("6464", "6464"); // DALTON RD STOP # 6464
		allStops.put("1623", "1623"); // 14TH AV / KENNEDY RD
		allStops.put("7037", "7037"); // WILLIAM BERCZY BLVD / BECKETT AV
		allStops.put("6499", "6499"); // DONALD COUSENS PKWY / DELRAY DR
		allStops.put("6498", "6498"); // WOODSPRING AV / GREEN LN W
		allStops.put("9802", "9802"); // YONGE / WELLINGTON
		allStops.put("7038", "7038"); // WILLIAM BERCZY BLVD / CHRISTIAN RIT
		allStops.put("6948", "6948"); // TENTH LINE / HEMLOCK DR
		allStops.put("5524", "5524"); // CROWDER BLVD STOP # 5524
		allStops.put("5525", "5525"); // UPPER CANADA MALL STOP # 5525
		allStops.put("5526", "5526"); // UPPER CANADA MALL STOP # 5526
		allStops.put("7039", "7039"); // VICTORIA PARK AV / STEELES AV
		allStops.put("3372", "3372"); // NEW WESTMINSTER DR / BROWNRIDGE DR
		allStops.put("6942", "6942"); // HOOVER PARK DR / TENTH LINE
		allStops.put("6941", "6941"); // HOOVER PARK DR / TENTH LINE
		allStops.put("6467", "6467"); // METRO RD / HARDWOOD DR
		allStops.put("6947", "6947"); // RIVERWALK DR / NINTH LINE
		allStops.put("6946", "6946"); // RIVERWALK DR / BARTER ST
		allStops.put("6945", "6945"); // RIVERWALK DR / CAPRARA CR
		allStops.put("6944", "6944"); // BOX GROVE COLLECTOR RD / BOX GROVE
		allStops.put("3305", "3305"); // BATHURST ST / MAJOR MACKENZIE DR
		allStops.put("1864", "1864"); // CARRVILLE RD / AYR RD
		allStops.put("1359", "1359"); // HENDERSON AV / GLEN CAMERON RD
		allStops.put("2907", "2907"); // BAYVIEW AV / 16TH AV
		allStops.put("5156", "5156"); // KEELE ST STOP # 5156
		allStops.put("2034", "2034"); // CLEARMEADOW BLVD / PLANTATION GATE
		allStops.put("5491", "5491"); // WHITE'S HILL AV / CORNWALL DR
		allStops.put("1568", "1568"); // JOHN BUTTON BLVD / MILLBROOK GATE
		allStops.put("1569", "1569"); // RUSSELL JARVIS DR / WOOD THRUSH AV
		allStops.put("4586", "4586"); // THORNHILL WOODS DR / MINTWOOD RD
		allStops.put("5798", "5798"); // VIA ROMANO BLVD / GLENHERON CRES
		allStops.put("3300", "3300"); // BATHURST ST / LAURIER AV
		allStops.put("5998", "5998"); // CASTAN AV / AVOCA DR
		allStops.put("1516", "1516"); // ROXBURY ST / 14TH AV
		allStops.put("1560", "1560"); // APPLE CREEK BLVD / RODICK RD
		allStops.put("1293", "1293"); // DENISON ST / MALLORY AV
		allStops.put("1562", "1562"); // APPLE CREEK BLVD / JOHN BUTTON BLVD
		allStops.put("3301", "3301"); // BATHURST ST / KING RD
		allStops.put("1564", "1564"); // JOHN BUTTON BLVD / MELCHIOR CRES
		allStops.put("1565", "1565"); // NINTH LINE / DELMARK BLVD
		allStops.put("1566", "1566"); // JOHN BUTTON BLVD / JOHN STIVER CRES
		allStops.put("1567", "1567"); // ROUGE BANK DR / RUSSELL JARVIS DR
		allStops.put("3392", "3392"); // NAPA VALLEY AV / FONTESELVA AV
		allStops.put("5022", "5022"); // DAVIS DR / YONGE ST
		allStops.put("1360", "1360"); // BUR OAK AV / EMERY HILL BLVD
		allStops.put("5253", "5253"); // INDUSTRIAL PKWY STOP # 5253
		allStops.put("1850", "1850"); // WOOTTEN WAY / PARKWAY AV
		allStops.put("2033", "2033"); // CLEARMEADOW BLVD / RUSHBROOK DR
		allStops.put("6350", "6350"); // JANE ST / EDILCAN DR
		allStops.put("2425", "2425"); // MCMASTER AV / EARL STEWART DR
		allStops.put("5743", "5743"); // PETER RUPERT / MAJOR MACKENZIE DR
		allStops.put("2743", "2743"); // CROSBY AV STOP # 2743
		allStops.put("6931", "6931"); // YORK DURHAM LINE / LORETTA CRES
		allStops.put("6744", "6744"); // AUTUMN HILL BLVD / CHOPIN BLVD
		allStops.put("1789", "1789"); // MAIN ST / CLARKE ST
		allStops.put("5027", "5027"); // BAYVIEW AV STOP # 5027
		allStops.put("2551", "2551"); // YONGE ST / QUEENSVILLE SDRD
		allStops.put("2784", "2784"); // AVENUE RD / CARRVILLE RD
		allStops.put("5125", "5125"); // BUR OAK AV / FRED MCLAREN BLVD
		allStops.put("4670", "4670"); // KENNEDY ST / CREEKS MEADOW LANE
		allStops.put("4398", "4398"); // STONE MASON DR / 16TH AV
		allStops.put("4489", "4489"); // FINCH AV / SILVERSTONE DR
		allStops.put("5638", "5638"); // SAM'S WAY / HIGHWAY 48
		allStops.put("5639", "5639"); // HIGHWAY 48 / HOOVER PARK RD
		allStops.put("6541", "6541"); // TOWER HILL RD / SELWYN RD
		allStops.put("6540", "6540"); // TOWER HILL RD / SELWYN RD
		allStops.put("5634", "5634"); // HOOVER PARK RD / CABIN TRAIL CRES
		allStops.put("2032", "2032"); // DOUBLETREE LANE / CLEARMEADOW BLVD
		allStops.put("5636", "5636"); // HOOVER PARK RD / GREENHOUSE LANE
		allStops.put("5637", "5637"); // HOOVER PARK RD / NINTH LINE
		allStops.put("4394", "4394"); // HIGHWAY 7 / SWANSEA RD
		allStops.put("5631", "5631"); // 16TH AV / COUNTRY GLEN RD
		allStops.put("6975", "6975"); // RUTHERFORD RD / SPRINGSIDE RD
		allStops.put("6548", "6548"); // BAYVIEW AV / FOREST RIDGE RD
		allStops.put("1366", "1366"); // BUR OAK AV / ROY RAINEY AV
		allStops.put("5313", "5313"); // CLARK AV STOP # 5313
		allStops.put("4443", "4443"); // LESLIE ST STOP # 4443
		allStops.put("1362", "1362"); // BUR OAK AV / MCCOWAN RD
		allStops.put("3192", "3192"); // COMMERCE VALLEY DR / HIGHWAY 7
		allStops.put("3191", "3191"); // COMMERCE VALLEY DR STOP # 3191
		allStops.put("1361", "1361"); // HENDERSON AV / DONCASTER AV
		allStops.put("3728", "3728"); // PINE VALLEY DR / EMBASSY DR
		allStops.put("5853", "5853"); // NINTH LINE / MAJOR MACKENZIE DR
		allStops.put("5258", "5258"); // BATHURST ST STOP # 5258
		allStops.put("1368", "1368"); // BUR OAK AV / DOGWOOD ST
		allStops.put("4445", "4445"); // ELGIN MILLS RD / CREEKVIEW AV
		return allStops;
	}
}

