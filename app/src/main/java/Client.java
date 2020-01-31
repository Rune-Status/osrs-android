import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameShell implements Usernamed {
	@ObfuscatedName("mg")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("clickedWidget")
	static Widget clickedWidget;
	@ObfuscatedName("oh")
	@ObfuscatedGetter(
		intValue = -2146709593
	)
	@Export("rootWidgetCount")
	static int rootWidgetCount;
	@ObfuscatedName("of")
	@ObfuscatedGetter(
		intValue = -1865852327
	)
	static int field850;
	@ObfuscatedName("od")
	@ObfuscatedGetter(
		longValue = 3639588590521619509L
	)
	static long field859;
	@ObfuscatedName("qa")
	static boolean field881;
	@ObfuscatedName("ov")
	static boolean[] field851;
	@ObfuscatedName("oo")
	static boolean[] field853;
	@ObfuscatedName("ni")
	static boolean field827;
	@ObfuscatedName("oc")
	static boolean[] field852;
	@ObfuscatedName("nd")
	static boolean field824;
	@ObfuscatedName("nh")
	@ObfuscatedGetter(
		intValue = 1483646797
	)
	@Export("cycleCntr")
	static int cycleCntr;
	@ObfuscatedName("oz")
	@Export("isResizable")
	static boolean isResizable;
	@ObfuscatedName("nu")
	@ObfuscatedGetter(
		intValue = 1169531803
	)
	static int field839;
	@ObfuscatedName("sa")
	@ObfuscatedGetter(
		intValue = 1909140369
	)
	public static int field888;
	@ObfuscatedName("mi")
	@ObfuscatedGetter(
		intValue = 1522690023
	)
	@Export("widgetClickX")
	static int widgetClickX;
	@ObfuscatedName("mr")
	@ObfuscatedGetter(
		intValue = 708609409
	)
	@Export("widgetClickY")
	static int widgetClickY;
	@ObfuscatedName("nz")
	@ObfuscatedGetter(
		intValue = 1648334173
	)
	static int field919;
	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("clickedWidgetParent")
	static Widget clickedWidgetParent;
	@ObfuscatedName("on")
	@ObfuscatedGetter(
		intValue = 1447905711
	)
	@Export("gameDrawingMode")
	static int gameDrawingMode;
	@ObfuscatedName("nf")
	@ObfuscatedGetter(
		intValue = -393886603
	)
	static int field826;
	@ObfuscatedName("oi")
	@Export("rootWidgetXs")
	static int[] rootWidgetXs;
	@ObfuscatedName("oj")
	@Export("rootWidgetWidths")
	static int[] rootWidgetWidths;
	@ObfuscatedName("mq")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("viewportWidget")
	static Widget viewportWidget;
	@ObfuscatedName("os")
	@Export("rootWidgetYs")
	static int[] rootWidgetYs;
	@ObfuscatedName("mk")
	@ObfuscatedGetter(
		intValue = -1785096625
	)
	@Export("staffModLevel")
	static int staffModLevel;
	@ObfuscatedName("ox")
	@Export("rootWidgetHeights")
	static int[] rootWidgetHeights;
	@ObfuscatedName("tc")
	@ObfuscatedSignature(
		signature = "Lbm;"
	)
	static final class65 field809;
	@ObfuscatedName("oq")
	@ObfuscatedGetter(
		intValue = 1929690709
	)
	@Export("mouseWheelRotation")
	static int mouseWheelRotation;
	@ObfuscatedName("oe")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("widgetClickMasks")
	static NodeHashTable widgetClickMasks;
	@ObfuscatedName("nw")
	@ObfuscatedGetter(
		intValue = 1341246229
	)
	static int field864;
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = 1361957455
	)
	static int field829;
	@ObfuscatedName("ot")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("scriptEvents")
	static NodeDeque scriptEvents;
	@ObfuscatedName("px")
	@ObfuscatedGetter(
		intValue = 1776210233
	)
	@Export("destinationX")
	static int destinationX;
	@ObfuscatedName("pl")
	@ObfuscatedGetter(
		intValue = 1779344353
	)
	@Export("destinationY")
	static int destinationY;
	@ObfuscatedName("tk")
	static int[] field920;
	@ObfuscatedName("tn")
	static int[] field921;
	@ObfuscatedName("pn")
	@ObfuscatedGetter(
		intValue = -391943327
	)
	@Export("publicChatMode")
	static int publicChatMode;
	@ObfuscatedName("na")
	@Export("isDraggingWidget")
	static boolean isDraggingWidget;
	@ObfuscatedName("py")
	@ObfuscatedGetter(
		intValue = -1040328597
	)
	@Export("tradeChatMode")
	static int tradeChatMode;
	@ObfuscatedName("sl")
	@ObfuscatedSignature(
		signature = "[Lm;"
	)
	@Export("grandExchangeOffers")
	static GrandExchangeOffer[] grandExchangeOffers;
	@ObfuscatedName("st")
	@Export("archiveLoaders")
	static ArrayList archiveLoaders;
	@ObfuscatedName("ss")
	@ObfuscatedGetter(
		intValue = 2033282957
	)
	@Export("archiveLoadersDone")
	static int archiveLoadersDone;
	@ObfuscatedName("mf")
	@ObfuscatedGetter(
		intValue = -89243397
	)
	@Export("runEnergy")
	static int runEnergy;
	@ObfuscatedName("qg")
	@ObfuscatedGetter(
		intValue = -1907233593
	)
	@Export("currentTrackGroupId")
	static int currentTrackGroupId;
	@ObfuscatedName("ma")
	@ObfuscatedGetter(
		intValue = 1843511131
	)
	@Export("weight")
	static int weight;
	@ObfuscatedName("qu")
	@ObfuscatedGetter(
		intValue = -1100066023
	)
	@Export("musicVolume")
	static int musicVolume;
	@ObfuscatedName("nt")
	@ObfuscatedGetter(
		intValue = -1399282537
	)
	static int field841;
	@ObfuscatedName("rk")
	static boolean[] field775;
	@ObfuscatedName("qb")
	@ObfuscatedGetter(
		intValue = 569870541
	)
	@Export("areaSoundEffectVolume")
	static int areaSoundEffectVolume;
	@ObfuscatedName("ry")
	static int[] field892;
	@ObfuscatedName("ru")
	static int[] field699;
	@ObfuscatedName("sh")
	@ObfuscatedGetter(
		intValue = 1166836543
	)
	static int field910;
	@ObfuscatedName("rx")
	static int[] field894;
	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("draggedOnWidget")
	static Widget draggedOnWidget;
	@ObfuscatedName("rl")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("playerAppearance")
	static PlayerAppearance playerAppearance;
	@ObfuscatedName("ro")
	static int[] field895;
	@ObfuscatedName("mb")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("meslayerContinueWidget")
	static Widget meslayerContinueWidget;
	@ObfuscatedName("sw")
	@ObfuscatedGetter(
		intValue = -1075965475
	)
	static int field911;
	@ObfuscatedName("nk")
	static int[] field832;
	@ObfuscatedName("ng")
	@Export("changedItemContainers")
	static int[] changedItemContainers;
	@ObfuscatedName("nm")
	@ObfuscatedGetter(
		intValue = 584378815
	)
	static int field823;
	@ObfuscatedName("nv")
	@ObfuscatedGetter(
		intValue = 1832354705
	)
	static int field833;
	@ObfuscatedName("nr")
	@ObfuscatedGetter(
		intValue = 1067328579
	)
	static int field835;
	@ObfuscatedName("qh")
	@ObfuscatedGetter(
		intValue = 1605243509
	)
	@Export("soundEffectCount")
	static int soundEffectCount;
	@ObfuscatedName("qi")
	@Export("soundEffectIds")
	static int[] soundEffectIds;
	@ObfuscatedName("qc")
	@Export("queuedSoundEffectLoops")
	static int[] queuedSoundEffectLoops;
	@ObfuscatedName("qd")
	@Export("queuedSoundEffectDelays")
	static int[] queuedSoundEffectDelays;
	@ObfuscatedName("si")
	@ObfuscatedSignature(
		signature = "Llz;"
	)
	@Export("platformInfoProvider")
	static PlatformInfoProvider platformInfoProvider;
	@ObfuscatedName("qy")
	@ObfuscatedSignature(
		signature = "[Lcs;"
	)
	@Export("soundEffects")
	static SoundEffect[] soundEffects;
	@ObfuscatedName("qe")
	@ObfuscatedGetter(
		intValue = -1155592801
	)
	@Export("minimapState")
	static int minimapState;
	@ObfuscatedName("qf")
	@Export("soundLocations")
	static int[] soundLocations;
	@ObfuscatedName("qs")
	@Export("isCameraLocked")
	static boolean isCameraLocked;
	@ObfuscatedName("pj")
	@ObfuscatedGetter(
		intValue = 1175842115
	)
	static int field704;
	@ObfuscatedName("pp")
	@ObfuscatedGetter(
		longValue = -1084323639285145485L
	)
	static long field702;
	@ObfuscatedName("qt")
	@ObfuscatedGetter(
		intValue = 1226020911
	)
	@Export("soundEffectVolume")
	static int soundEffectVolume;
	@ObfuscatedName("pu")
	@ObfuscatedGetter(
		intValue = -1024835233
	)
	@Export("mapIconCount")
	static int mapIconCount;
	@ObfuscatedName("pw")
	@Export("mapIconXs")
	static int[] mapIconXs;
	@ObfuscatedName("pt")
	@Export("mapIconYs")
	static int[] mapIconYs;
	@ObfuscatedName("sm")
	@ObfuscatedGetter(
		intValue = -1315339885
	)
	static int field813;
	@ObfuscatedName("pg")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("mapIcons")
	static Sprite[] mapIcons;
	@ObfuscatedName("my")
	@ObfuscatedGetter(
		intValue = 712982519
	)
	@Export("chatEffects")
	static int chatEffects;
	@ObfuscatedName("nb")
	@Export("changedSkills")
	static int[] changedSkills;
	@ObfuscatedName("rd")
	static short field908;
	@ObfuscatedName("np")
	@ObfuscatedGetter(
		intValue = 539828499
	)
	@Export("changedSkillsCount")
	static int changedSkillsCount;
	@ObfuscatedName("re")
	static short field897;
	@ObfuscatedName("rv")
	static short field819;
	@ObfuscatedName("mp")
	@ObfuscatedGetter(
		intValue = 1687250363
	)
	static int field811;
	@ObfuscatedName("rr")
	static short field903;
	@ObfuscatedName("rj")
	static short field673;
	@ObfuscatedName("ri")
	@ObfuscatedGetter(
		intValue = -589414587
	)
	@Export("viewportZoom")
	static int viewportZoom;
	@ObfuscatedName("rf")
	static short field900;
	@ObfuscatedName("rz")
	@ObfuscatedGetter(
		intValue = 1429063259
	)
	@Export("viewportWidth")
	static int viewportWidth;
	@ObfuscatedName("ra")
	@ObfuscatedGetter(
		intValue = 846238467
	)
	@Export("viewportHeight")
	static int viewportHeight;
	@ObfuscatedName("ne")
	@ObfuscatedGetter(
		intValue = -114993345
	)
	static int field842;
	@ObfuscatedName("mz")
	@ObfuscatedGetter(
		intValue = 1973962691
	)
	@Export("followerIndex")
	static int followerIndex;
	@ObfuscatedName("rt")
	@ObfuscatedGetter(
		intValue = -1457697577
	)
	@Export("viewportOffsetX")
	static int viewportOffsetX;
	@ObfuscatedName("rw")
	@ObfuscatedGetter(
		intValue = 1641050699
	)
	@Export("viewportOffsetY")
	static int viewportOffsetY;
	@ObfuscatedName("pz")
	@ObfuscatedGetter(
		intValue = 1835135495
	)
	static int field762;
	@ObfuscatedName("pf")
	static long[] field865;
	@ObfuscatedName("ml")
	@Export("playerMod")
	static boolean playerMod;
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -2044772591
	)
	static int field795;
	@ObfuscatedName("pm")
	static int[] field869;
	@ObfuscatedName("pr")
	static int[] field868;
	@ObfuscatedName("om")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	static NodeDeque field846;
	@ObfuscatedName("ol")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	static NodeDeque field847;
	@ObfuscatedName("pi")
	@ObfuscatedGetter(
		intValue = -1435172975
	)
	static int field715;
	@ObfuscatedName("rq")
	@Export("zoomHeight")
	static short zoomHeight;
	@ObfuscatedName("rs")
	@Export("zoomWidth")
	static short zoomWidth;
	@ObfuscatedName("mu")
	@ObfuscatedGetter(
		intValue = 206170513
	)
	static int field808;
	@ObfuscatedName("ms")
	@ObfuscatedGetter(
		intValue = 1466636235
	)
	static int field664;
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = -2045672721
	)
	@Export("chatCycle")
	static int chatCycle;
	@ObfuscatedName("pd")
	static int[] field861;
	@ObfuscatedName("pa")
	static String field780;
	@ObfuscatedName("sb")
	@ObfuscatedSignature(
		signature = "Lbd;"
	)
	@Export("GrandExchangeEvents_worldComparator")
	static GrandExchangeOfferOwnWorldComparator GrandExchangeEvents_worldComparator;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lfv;"
	)
	@Export("collisionMaps")
	static CollisionMap[] collisionMaps;
	@ObfuscatedName("ah")
	static boolean field922;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 1070916763
	)
	@Export("worldId")
	public static int worldId;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = -1124780897
	)
	@Export("worldProperties")
	static int worldProperties;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 762805581
	)
	@Export("gameBuild")
	static int gameBuild;
	@ObfuscatedName("bp")
	@Export("isMembersWorld")
	public static boolean isMembersWorld;
	@ObfuscatedName("bl")
	@Export("isLowDetail")
	static boolean isLowDetail;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 2121027027
	)
	static int field672;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1947983405
	)
	@Export("clientType")
	static int clientType;
	@ObfuscatedName("bm")
	@Export("onMobile")
	static boolean onMobile;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -873301681
	)
	@Export("gameState")
	static int gameState;
	@ObfuscatedName("cd")
	@Export("isLoading")
	static boolean isLoading;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 996993213
	)
	@Export("cycle")
	static int cycle;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		longValue = -3748954884429607225L
	)
	@Export("mouseLastLastPressedTimeMillis")
	static long mouseLastLastPressedTimeMillis;
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -241635753
	)
	static int field657;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 235164627
	)
	static int field912;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		longValue = -8326458938814166675L
	)
	static long field745;
	@ObfuscatedName("cy")
	@Export("hadFocus")
	static boolean hadFocus;
	@ObfuscatedName("ce")
	@Export("displayFps")
	static boolean displayFps;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -1706106531
	)
	@Export("rebootTimer")
	static int rebootTimer;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 2120122053
	)
	@Export("hintArrowType")
	static int hintArrowType;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = -1436156017
	)
	@Export("hintArrowNpcIndex")
	static int hintArrowNpcIndex;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 1200698835
	)
	@Export("hintArrowPlayerIndex")
	static int hintArrowPlayerIndex;
	@ObfuscatedName("cc")
	@ObfuscatedGetter(
		intValue = -59894547
	)
	@Export("hintArrowX")
	static int hintArrowX;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 228888197
	)
	@Export("hintArrowY")
	static int hintArrowY;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -1687993100
	)
	@Export("hintArrowHeight")
	static int hintArrowHeight;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 1422789440
	)
	@Export("hintArrowSubX")
	static int hintArrowSubX;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = -1150277369
	)
	@Export("hintArrowSubY")
	static int hintArrowSubY;
	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		signature = "Lcd;"
	)
	@Export("playerAttackOption")
	static AttackOption playerAttackOption;
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "Lcd;"
	)
	@Export("npcAttackOption")
	static AttackOption npcAttackOption;
	@ObfuscatedName("ds")
	@ObfuscatedGetter(
		intValue = 544123225
	)
	@Export("titleLoadingStage")
	static int titleLoadingStage;
	@ObfuscatedName("do")
	@ObfuscatedGetter(
		intValue = 802630795
	)
	@Export("js5ConnectState")
	static int js5ConnectState;
	@ObfuscatedName("di")
	@ObfuscatedGetter(
		intValue = 679409999
	)
	static int field675;
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive17")
	static Archive archive17;
	@ObfuscatedName("ec")
	@ObfuscatedGetter(
		intValue = 788466911
	)
	@Export("js5Errors")
	static int js5Errors;
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = 598488389
	)
	@Export("loginState")
	static int loginState;
	@ObfuscatedName("eq")
	@ObfuscatedGetter(
		intValue = 1283349071
	)
	static int field679;
	@ObfuscatedName("eu")
	@ObfuscatedGetter(
		intValue = -1801662641
	)
	static int field680;
	@ObfuscatedName("et")
	@ObfuscatedGetter(
		intValue = -1956928739
	)
	static int field681;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	static class160 field682;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -1694065133
	)
	@Export("port2")
	static int port2;
	@ObfuscatedName("ev")
	@Export("Login_isUsernameRemembered")
	static boolean Login_isUsernameRemembered;
	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "Lcm;"
	)
	@Export("secureRandomFuture")
	static SecureRandomFuture secureRandomFuture;
	@ObfuscatedName("ej")
	@Export("randomDatData")
	static byte[] randomDatData;
	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "[Lcg;"
	)
	@Export("npcs")
	static NPC[] npcs;
	@ObfuscatedName("ed")
	@ObfuscatedGetter(
		intValue = 1706473169
	)
	@Export("npcCount")
	static int npcCount;
	@ObfuscatedName("fl")
	@Export("npcIndices")
	static int[] npcIndices;
	@ObfuscatedName("fp")
	@ObfuscatedGetter(
		intValue = 1670938007
	)
	static int field690;
	@ObfuscatedName("fx")
	static int[] field867;
	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "Lci;"
	)
	@Export("packetWriter")
	public static final PacketWriter packetWriter;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = -446741929
	)
	@Export("logoutTimer")
	static int logoutTimer;
	@ObfuscatedName("fj")
	static boolean field800;
	@ObfuscatedName("fw")
	@Export("useBufferedSocket")
	static boolean useBufferedSocket;
	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "Ljn;"
	)
	@Export("timer")
	static Timer timer;
	@ObfuscatedName("fv")
	@Export("fontsMap")
	static HashMap fontsMap;
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		intValue = 1167098885
	)
	static int field791;
	@ObfuscatedName("ft")
	@ObfuscatedGetter(
		intValue = 1435781107
	)
	static int field884;
	@ObfuscatedName("fr")
	@ObfuscatedGetter(
		intValue = 1220114723
	)
	static int field700;
	@ObfuscatedName("gb")
	@ObfuscatedGetter(
		intValue = -920973165
	)
	static int field733;
	@ObfuscatedName("gi")
	@ObfuscatedGetter(
		intValue = 1525628521
	)
	static int field695;
	@ObfuscatedName("gx")
	@Export("isInInstance")
	static boolean isInInstance;
	@ObfuscatedName("gp")
	@Export("instanceChunkTemplates")
	static int[][][] instanceChunkTemplates;
	@ObfuscatedName("go")
	static final int[] field743;
	@ObfuscatedName("gf")
	@ObfuscatedGetter(
		intValue = -115001383
	)
	static int field707;
	@ObfuscatedName("ht")
	@ObfuscatedGetter(
		intValue = 1088390909
	)
	static int field870;
	@ObfuscatedName("hc")
	@ObfuscatedGetter(
		intValue = -1687869927
	)
	static int field709;
	@ObfuscatedName("hi")
	@ObfuscatedGetter(
		intValue = -2107893215
	)
	static int field710;
	@ObfuscatedName("hf")
	@ObfuscatedGetter(
		intValue = 404388609
	)
	static int field711;
	@ObfuscatedName("hb")
	static boolean field712;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = -922297079
	)
	@Export("alternativeScrollbarWidth")
	static int alternativeScrollbarWidth;
	@ObfuscatedName("hm")
	@ObfuscatedGetter(
		intValue = 2017298607
	)
	@Export("camAngleX")
	static int camAngleX;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = 715685771
	)
	@Export("camAngleY")
	static int camAngleY;
	@ObfuscatedName("hy")
	@ObfuscatedGetter(
		intValue = -1271117347
	)
	@Export("camAngleDY")
	static int camAngleDY;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = -502249305
	)
	@Export("camAngleDX")
	static int camAngleDX;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = 1265592985
	)
	@Export("mouseCamClickedX")
	static int mouseCamClickedX;
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = -229935521
	)
	@Export("mouseCamClickedY")
	static int mouseCamClickedY;
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = 573387673
	)
	@Export("oculusOrbState")
	static int oculusOrbState;
	@ObfuscatedName("hh")
	@ObfuscatedGetter(
		intValue = -758522723
	)
	@Export("camFollowHeight")
	static int camFollowHeight;
	@ObfuscatedName("hr")
	@ObfuscatedGetter(
		intValue = -654913029
	)
	static int field647;
	@ObfuscatedName("he")
	@ObfuscatedGetter(
		intValue = 1993254297
	)
	static int field723;
	@ObfuscatedName("ii")
	@ObfuscatedGetter(
		intValue = 955066829
	)
	static int field724;
	@ObfuscatedName("ia")
	@ObfuscatedGetter(
		intValue = -1010817559
	)
	@Export("oculusOrbNormalSpeed")
	static int oculusOrbNormalSpeed;
	@ObfuscatedName("ib")
	@ObfuscatedGetter(
		intValue = 2046982327
	)
	@Export("oculusOrbSlowedSpeed")
	static int oculusOrbSlowedSpeed;
	@ObfuscatedName("in")
	@ObfuscatedGetter(
		intValue = 631186879
	)
	static int field727;
	@ObfuscatedName("ic")
	static boolean field728;
	@ObfuscatedName("id")
	@ObfuscatedGetter(
		intValue = 1899106867
	)
	static int field729;
	@ObfuscatedName("ij")
	static boolean field730;
	@ObfuscatedName("im")
	@ObfuscatedGetter(
		intValue = 1534235447
	)
	static int field818;
	@ObfuscatedName("ie")
	@ObfuscatedGetter(
		intValue = 489065879
	)
	@Export("overheadTextCount")
	static int overheadTextCount;
	@ObfuscatedName("iu")
	@ObfuscatedGetter(
		intValue = 546122341
	)
	@Export("overheadTextLimit")
	static int overheadTextLimit;
	@ObfuscatedName("io")
	@Export("overheadTextXs")
	static int[] overheadTextXs;
	@ObfuscatedName("iy")
	@Export("overheadTextYs")
	static int[] overheadTextYs;
	@ObfuscatedName("iv")
	@Export("overheadTextAscents")
	static int[] overheadTextAscents;
	@ObfuscatedName("iq")
	@Export("overheadTextXOffsets")
	static int[] overheadTextXOffsets;
	@ObfuscatedName("is")
	@Export("overheadTextColors")
	static int[] overheadTextColors;
	@ObfuscatedName("it")
	@Export("selectedItemName")
	static String selectedItemName;
	@ObfuscatedName("iw")
	@Export("overheadTextEffects")
	static int[] overheadTextEffects;
	@ObfuscatedName("il")
	@Export("overheadTextCyclesRemaining")
	static int[] overheadTextCyclesRemaining;
	@ObfuscatedName("ir")
	@Export("overheadText")
	static String[] overheadText;
	@ObfuscatedName("if")
	@Export("tileLastDrawnActor")
	static int[][] tileLastDrawnActor;
	@ObfuscatedName("ih")
	@ObfuscatedGetter(
		intValue = 2113059389
	)
	@Export("viewportDrawCount")
	static int viewportDrawCount;
	@ObfuscatedName("ig")
	@ObfuscatedGetter(
		intValue = 770836743
	)
	@Export("viewportTempX")
	static int viewportTempX;
	@ObfuscatedName("ip")
	@ObfuscatedGetter(
		intValue = 1799484349
	)
	@Export("viewportTempY")
	static int viewportTempY;
	@ObfuscatedName("jq")
	@ObfuscatedGetter(
		intValue = -247632533
	)
	@Export("mouseCrossX")
	static int mouseCrossX;
	@ObfuscatedName("jj")
	@ObfuscatedGetter(
		intValue = 217544107
	)
	@Export("mouseCrossY")
	static int mouseCrossY;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = 250308260
	)
	@Export("mouseCrossState")
	static int mouseCrossState;
	@ObfuscatedName("jr")
	@ObfuscatedGetter(
		intValue = 14031919
	)
	@Export("mouseCrossColor")
	static int mouseCrossColor;
	@ObfuscatedName("jg")
	@Export("showMouseCross")
	static boolean showMouseCross;
	@ObfuscatedName("jb")
	@ObfuscatedGetter(
		intValue = -1559592119
	)
	static int field751;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = -769809143
	)
	static int field752;
	@ObfuscatedName("ji")
	@ObfuscatedGetter(
		intValue = 680963965
	)
	@Export("dragItemSlotSource")
	static int dragItemSlotSource;
	@ObfuscatedName("jc")
	@ObfuscatedGetter(
		intValue = -509412397
	)
	@Export("draggedWidgetX")
	static int draggedWidgetX;
	@ObfuscatedName("jn")
	@ObfuscatedGetter(
		intValue = 24720215
	)
	@Export("draggedWidgetY")
	static int draggedWidgetY;
	@ObfuscatedName("jt")
	@ObfuscatedGetter(
		intValue = -200424637
	)
	@Export("dragItemSlotDestination")
	static int dragItemSlotDestination;
	@ObfuscatedName("jk")
	static boolean field757;
	@ObfuscatedName("jx")
	@ObfuscatedGetter(
		intValue = 1665305383
	)
	@Export("itemDragDuration")
	static int itemDragDuration;
	@ObfuscatedName("jf")
	@ObfuscatedGetter(
		intValue = 1608164289
	)
	static int field759;
	@ObfuscatedName("jp")
	@Export("showLoadingMessages")
	static boolean showLoadingMessages;
	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "[Lba;"
	)
	@Export("players")
	static Player[] players;
	@ObfuscatedName("jd")
	@ObfuscatedGetter(
		intValue = 356089511
	)
	@Export("localPlayerIndex")
	static int localPlayerIndex;
	@ObfuscatedName("jz")
	@ObfuscatedGetter(
		intValue = -2132889429
	)
	static int field763;
	@ObfuscatedName("jl")
	@Export("renderSelf")
	static boolean renderSelf;
	@ObfuscatedName("kh")
	@ObfuscatedGetter(
		intValue = 1701089391
	)
	@Export("drawPlayerNames")
	static int drawPlayerNames;
	@ObfuscatedName("kj")
	@ObfuscatedGetter(
		intValue = -425837641
	)
	static int field766;
	@ObfuscatedName("kq")
	static int[] field828;
	@ObfuscatedName("kb")
	@Export("playerMenuOpcodes")
	static final int[] playerMenuOpcodes;
	@ObfuscatedName("ko")
	@Export("playerMenuActions")
	static String[] playerMenuActions;
	@ObfuscatedName("kc")
	@Export("playerOptionsPriorities")
	static boolean[] playerOptionsPriorities;
	@ObfuscatedName("kg")
	@Export("defaultRotations")
	static int[] defaultRotations;
	@ObfuscatedName("kt")
	@ObfuscatedGetter(
		intValue = -1908938957
	)
	@Export("combatTargetPlayerIndex")
	static int combatTargetPlayerIndex;
	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "[[[Ljw;"
	)
	@Export("groundItems")
	static NodeDeque[][][] groundItems;
	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("pendingSpawns")
	static NodeDeque pendingSpawns;
	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("projectiles")
	static NodeDeque projectiles;
	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("graphicsObjects")
	static NodeDeque graphicsObjects;
	@ObfuscatedName("ki")
	@Export("currentLevels")
	static int[] currentLevels;
	@ObfuscatedName("kf")
	@Export("levels")
	static int[] levels;
	@ObfuscatedName("kr")
	@Export("experience")
	static int[] experience;
	@ObfuscatedName("kw")
	@ObfuscatedGetter(
		intValue = 1989694785
	)
	@Export("leftClickOpensMenu")
	static int leftClickOpensMenu;
	@ObfuscatedName("kv")
	@Export("isMenuOpen")
	static boolean isMenuOpen;
	@ObfuscatedName("ld")
	@ObfuscatedGetter(
		intValue = -1335676379
	)
	@Export("menuOptionsCount")
	static int menuOptionsCount;
	@ObfuscatedName("lr")
	@Export("menuArguments1")
	static int[] menuArguments1;
	@ObfuscatedName("lh")
	@Export("menuArguments2")
	static int[] menuArguments2;
	@ObfuscatedName("lp")
	@Export("menuOpcodes")
	static int[] menuOpcodes;
	@ObfuscatedName("lu")
	@Export("menuIdentifiers")
	static int[] menuIdentifiers;
	@ObfuscatedName("ln")
	@Export("menuActions")
	static String[] menuActions;
	@ObfuscatedName("ll")
	@Export("menuTargets")
	static String[] menuTargets;
	@ObfuscatedName("lq")
	@Export("menuShiftClick")
	static boolean[] menuShiftClick;
	@ObfuscatedName("lb")
	@Export("followerOpsLowPriority")
	static boolean followerOpsLowPriority;
	@ObfuscatedName("lf")
	@Export("shiftClickDrop")
	static boolean shiftClickDrop;
	@ObfuscatedName("li")
	@Export("tapToDrop")
	static boolean tapToDrop;
	@ObfuscatedName("lt")
	@Export("showMouseOverText")
	static boolean showMouseOverText;
	@ObfuscatedName("lx")
	@ObfuscatedGetter(
		intValue = -1770752135
	)
	@Export("viewportX")
	static int viewportX;
	@ObfuscatedName("lm")
	@ObfuscatedGetter(
		intValue = 1940696691
	)
	@Export("viewportY")
	static int viewportY;
	@ObfuscatedName("lv")
	@ObfuscatedGetter(
		intValue = 1680914597
	)
	static int field796;
	@ObfuscatedName("le")
	@ObfuscatedGetter(
		intValue = 1451138947
	)
	static int field797;
	@ObfuscatedName("ly")
	@ObfuscatedGetter(
		intValue = 353529783
	)
	@Export("isItemSelected")
	static int isItemSelected;
	@ObfuscatedName("lk")
	@Export("isSpellSelected")
	static boolean isSpellSelected;
	@ObfuscatedName("ls")
	@ObfuscatedGetter(
		intValue = -678517667
	)
	@Export("selectedSpellChildIndex")
	static int selectedSpellChildIndex;
	@ObfuscatedName("mv")
	@ObfuscatedGetter(
		intValue = 259223343
	)
	static int field802;
	@ObfuscatedName("mn")
	@Export("selectedSpellActionName")
	static String selectedSpellActionName;
	@ObfuscatedName("mo")
	@Export("selectedSpellName")
	static String selectedSpellName;
	@ObfuscatedName("me")
	@ObfuscatedGetter(
		intValue = 1383553915
	)
	@Export("rootInterface")
	static int rootInterface;
	@ObfuscatedName("mx")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("interfaceParents")
	static NodeHashTable interfaceParents;

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1781530375"
	)
	@Export("resizeGame")
	protected final void resizeGame() {
		field859 = WorldMapIcon_0.currentTimeMillis() + 500L;
		this.resizeJS();
		if (rootInterface != -1) {
			this.resizeRoot(true);
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "159835862"
	)
	@Export("setUp")
	protected final void setUp() {
		NetFileRequest.method4217(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
		WorldMapLabelSize.port1 = gameBuild == 0 ? 43594 : worldId + 40000;
		port2 = gameBuild == 0 ? 443 : worldId + 50000;
		WorldMapSection2.port3 = WorldMapLabelSize.port1;
		WorldMapLabelSize.field128 = class215.field2552;
		PlayerAppearance.field2545 = class215.field2553;
		PlayerAppearance.field2547 = class215.field2551;
		class208.field2514 = class215.field2550;
		WorldMapData_0.urlRequester = new UrlRequester();
		this.setUpKeyboard();
		this.setUpMouse();
		PacketWriter.mouseWheel = this.mouseWheel();
		TileItem.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		AccessFile var1 = null;
		ClientPreferences var2 = new ClientPreferences();

		try {
			var1 = WorldMapRectangle.getPreferencesFile("", class14.field102.name, false);
			byte[] var3 = new byte[(int)var1.length()];

			int var4;
			for (int var5 = 0; var5 < var3.length; var5 += var4) {
				var4 = var1.read(var3, var5, var3.length - var5);
				if (var4 == -1) {
					throw new IOException();
				}
			}

			var2 = new ClientPreferences(new Buffer(var3));
		} catch (Exception var7) {
		}

		try {
			if (var1 != null) {
				var1.close();
			}
		} catch (Exception var6) {
		}

		WorldMapSection2.clientPreferences = var2;
		this.setUpClipboard();
		String var8 = GrandExchangeOfferUnitPriceComparator.null_string;
		class51.applet = this;
		if (var8 != null) {
			class51.field431 = var8;
		}

		if (gameBuild != 0) {
			displayFps = true;
		}

		VertexNormal.setWindowedMode(WorldMapSection2.clientPreferences.windowMode);
		KeyHandler.friendSystem = new FriendSystem(class192.loginType);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1684911639"
	)
	@Export("doCycle")
	protected final void doCycle() {
		++cycle;
		this.doCycleJs5();
		ClientPreferences.method1854();

		int var1;
		try {
			if (class197.field2414 == 1) {
				var1 = class197.midiPcmStream.method3764();
				if (var1 > 0 && class197.midiPcmStream.isReady()) {
					var1 -= class197.field2412;
					if (var1 < 0) {
						var1 = 0;
					}

					class197.midiPcmStream.setPcmStreamVolume(var1);
				} else {
					class197.midiPcmStream.clear();
					class197.midiPcmStream.removeAll();
					if (UserComparator5.musicTrackArchive != null) {
						class197.field2414 = 2;
					} else {
						class197.field2414 = 0;
					}

					FileSystem.musicTrack = null;
					class197.soundCache = null;
				}
			}
		} catch (Exception var44) {
			var44.printStackTrace();
			class197.midiPcmStream.clear();
			class197.field2414 = 0;
			FileSystem.musicTrack = null;
			class197.soundCache = null;
			UserComparator5.musicTrackArchive = null;
		}

		UserComparator3.playPcmPlayers();
		BoundaryObject.method3333();
		UserComparator10.method3476();
		if (PacketWriter.mouseWheel != null) {
			var1 = PacketWriter.mouseWheel.useRotation();
			mouseWheelRotation = var1;
		}

		if (gameState == 0) {
			class225.load();
			class2.method24();
		} else if (gameState == 5) {
			GrandExchangeEvents.doCycleTitle(this);
			class225.load();
			class2.method24();
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				GrandExchangeEvents.doCycleTitle(this);
				this.doCycleLoggedOut();
			} else if (gameState == 25) {
				UserComparator4.method3442(false);
				field791 = 0;
				boolean var2 = true;

				int var3;
				for (var3 = 0; var3 < Tiles.regionLandArchives.length; ++var3) {
					if (class30.regionMapArchiveIds[var3] != -1 && Tiles.regionLandArchives[var3] == null) {
						Tiles.regionLandArchives[var3] = NetSocket.archive5.takeFile(class30.regionMapArchiveIds[var3], 0);
						if (Tiles.regionLandArchives[var3] == null) {
							var2 = false;
							++field791;
						}
					}

					if (class65.regionLandArchiveIds[var3] != -1 && class226.regionMapArchives[var3] == null) {
						class226.regionMapArchives[var3] = NetSocket.archive5.takeFileEncrypted(class65.regionLandArchiveIds[var3], 0, JagexCache.xteaKeys[var3]);
						if (class226.regionMapArchives[var3] == null) {
							var2 = false;
							++field791;
						}
					}
				}

				if (!var2) {
					field695 = 1;
				} else {
					field700 = 0;
					var2 = true;

					int var4;
					int var5;
					for (var3 = 0; var3 < Tiles.regionLandArchives.length; ++var3) {
						byte[] var6 = class226.regionMapArchives[var3];
						if (var6 != null) {
							var4 = (FriendsList.regions[var3] >> 8) * 64 - Messages.baseX * 64;
							var5 = (FriendsList.regions[var3] & 255) * 64 - Language.baseY * 64;
							if (isInInstance) {
								var4 = 10;
								var5 = 10;
							}

							var2 &= BufferedSink.method5913(var6, var4, var5);
						}
					}

					if (!var2) {
						field695 = 2;
					} else {
						if (field695 != 0) {
							class197.drawLoadingMessage("Loading - please wait.<br> (100%)", true);
						}

						UserComparator3.playPcmPlayers();
						ServerBuild.scene.clear();

						for (var3 = 0; var3 < 4; ++var3) {
							collisionMaps[var3].clear();
						}

						int var45;
						for (var3 = 0; var3 < 4; ++var3) {
							for (var45 = 0; var45 < 104; ++var45) {
								for (var4 = 0; var4 < 104; ++var4) {
									Tiles.Tiles_renderFlags[var3][var45][var4] = 0;
								}
							}
						}

						UserComparator3.playPcmPlayers();
						Tiles.Tiles_minPlane = 99;
						Tiles.field502 = new byte[4][104][104];
						Tiles.field514 = new byte[4][104][104];
						Tiles.field507 = new byte[4][104][104];
						Tiles.field518 = new byte[4][104][104];
						UrlRequest.field1940 = new int[4][105][105];
						InterfaceParent.field565 = new byte[4][105][105];
						Tiles.field509 = new int[105][105];
						class268.Tiles_hue = new int[104];
						HorizontalAlignment.Tiles_saturation = new int[104];
						class30.Tiles_lightness = new int[104];
						class40.Tiles_hueMultiplier = new int[104];
						TileItemPile.field1529 = new int[104];
						var3 = Tiles.regionLandArchives.length;
						UrlRequest.method3375();
						UserComparator4.method3442(true);
						int var7;
						int var8;
						int var9;
						int var10;
						int var11;
						int var12;
						int var13;
						byte[] var47;
						if (!isInInstance) {
							var45 = 0;

							label516:
							while (true) {
								byte[] var14;
								if (var45 >= var3) {
									for (var45 = 0; var45 < var3; ++var45) {
										var4 = (FriendsList.regions[var45] >> 8) * 64 - Messages.baseX * 64;
										var5 = (FriendsList.regions[var45] & 255) * 64 - Language.baseY * 64;
										var14 = Tiles.regionLandArchives[var45];
										if (var14 == null && Language.field2359 < 800) {
											UserComparator3.playPcmPlayers();
											KitDefinition.method4532(var4, var5, 64, 64);
										}
									}

									UserComparator4.method3442(true);
									var45 = 0;

									while (true) {
										if (var45 >= var3) {
											break label516;
										}

										var47 = class226.regionMapArchives[var45];
										if (var47 != null) {
											var5 = (FriendsList.regions[var45] >> 8) * 64 - Messages.baseX * 64;
											var13 = (FriendsList.regions[var45] & 255) * 64 - Language.baseY * 64;
											UserComparator3.playPcmPlayers();
											class160.method3518(var47, var5, var13, ServerBuild.scene, collisionMaps);
										}

										++var45;
									}
								}

								var4 = (FriendsList.regions[var45] >> 8) * 64 - Messages.baseX * 64;
								var5 = (FriendsList.regions[var45] & 255) * 64 - Language.baseY * 64;
								var14 = Tiles.regionLandArchives[var45];
								if (var14 != null) {
									UserComparator3.playPcmPlayers();
									var7 = SecureRandomCallable.field530 * 8 - 48;
									var8 = Language.field2359 * 8 - 48;
									CollisionMap[] var15 = collisionMaps;
									var9 = 0;

									label513:
									while (true) {
										if (var9 >= 4) {
											Buffer var49 = new Buffer(var14);
											var10 = 0;

											while (true) {
												if (var10 >= 4) {
													break label513;
												}

												for (var11 = 0; var11 < 64; ++var11) {
													for (var12 = 0; var12 < 64; ++var12) {
														WorldMapArea.loadTerrain(var49, var10, var4 + var11, var5 + var12, var7, var8, 0);
													}
												}

												++var10;
											}
										}

										for (var10 = 0; var10 < 64; ++var10) {
											for (var11 = 0; var11 < 64; ++var11) {
												if (var10 + var4 > 0 && var10 + var4 < 103 && var11 + var5 > 0 && var5 + var11 < 103) {
													int[] var16 = var15[var9].flags[var10 + var4];
													var16[var11 + var5] &= -16777217;
												}
											}
										}

										++var9;
									}
								}

								++var45;
							}
						}

						int var46;
						if (isInInstance) {
							var45 = 0;

							label462:
							while (true) {
								if (var45 >= 4) {
									for (var45 = 0; var45 < 13; ++var45) {
										for (var4 = 0; var4 < 13; ++var4) {
											var5 = instanceChunkTemplates[0][var45][var4];
											if (var5 == -1) {
												KitDefinition.method4532(var45 * 8, var4 * 8, 8, 8);
											}
										}
									}

									UserComparator4.method3442(true);
									var45 = 0;

									while (true) {
										if (var45 >= 4) {
											break label462;
										}

										UserComparator3.playPcmPlayers();

										for (var4 = 0; var4 < 13; ++var4) {
											label385:
											for (var5 = 0; var5 < 13; ++var5) {
												var13 = instanceChunkTemplates[var45][var4][var5];
												if (var13 != -1) {
													var7 = var13 >> 24 & 3;
													var8 = var13 >> 1 & 3;
													var46 = var13 >> 14 & 1023;
													var9 = var13 >> 3 & 2047;
													var10 = (var46 / 8 << 8) + var9 / 8;

													for (var11 = 0; var11 < FriendsList.regions.length; ++var11) {
														if (FriendsList.regions[var11] == var10 && class226.regionMapArchives[var11] != null) {
															var47 = class226.regionMapArchives[var11];
															int var50 = var4 * 8;
															int var17 = var5 * 8;
															int var18 = (var46 & 7) * 8;
															int var19 = (var9 & 7) * 8;
															Scene var20 = ServerBuild.scene;
															CollisionMap[] var21 = collisionMaps;
															Buffer var22 = new Buffer(var47);
															int var23 = -1;

															while (true) {
																int var24 = var22.method5589();
																if (var24 == 0) {
																	continue label385;
																}

																var23 += var24;
																int var25 = 0;

																while (true) {
																	int var26 = var22.readUShortSmart();
																	if (var26 == 0) {
																		break;
																	}

																	var25 += var26 - 1;
																	int var27 = var25 & 63;
																	int var28 = var25 >> 6 & 63;
																	int var29 = var25 >> 12;
																	int var30 = var22.readUnsignedByte();
																	int var31 = var30 >> 2;
																	int var32 = var30 & 3;
																	if (var7 == var29 && var28 >= var18 && var28 < var18 + 8 && var27 >= var19 && var27 < var19 + 8) {
																		ObjectDefinition var33 = Occluder.getObjectDefinition(var23);
																		int var34 = var50 + FloorDecoration.method2913(var28 & 7, var27 & 7, var8, var33.sizeX, var33.sizeY, var32);
																		int var35 = var28 & 7;
																		int var36 = var27 & 7;
																		int var37 = var33.sizeX;
																		int var38 = var33.sizeY;
																		int var39;
																		if ((var32 & 1) == 1) {
																			var39 = var37;
																			var37 = var38;
																			var38 = var39;
																		}

																		int var40 = var8 & 3;
																		int var41;
																		if (var40 == 0) {
																			var41 = var36;
																		} else if (var40 == 1) {
																			var41 = 7 - var35 - (var37 - 1);
																		} else if (var40 == 2) {
																			var41 = 7 - var36 - (var38 - 1);
																		} else {
																			var41 = var35;
																		}

																		var39 = var17 + var41;
																		if (var34 > 0 && var39 > 0 && var34 < 103 && var39 < 103) {
																			int var42 = var45;
																			if ((Tiles.Tiles_renderFlags[1][var34][var39] & 2) == 2) {
																				var42 = var45 - 1;
																			}

																			CollisionMap var43 = null;
																			if (var42 >= 0) {
																				var43 = var21[var42];
																			}

																			ArchiveDiskActionHandler.method4336(var45, var34, var39, var23, var32 + var8 & 3, var31, var20, var43);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}

										++var45;
									}
								}

								UserComparator3.playPcmPlayers();

								for (var4 = 0; var4 < 13; ++var4) {
									for (var5 = 0; var5 < 13; ++var5) {
										boolean var48 = false;
										var7 = instanceChunkTemplates[var45][var4][var5];
										if (var7 != -1) {
											var8 = var7 >> 24 & 3;
											var46 = var7 >> 1 & 3;
											var9 = var7 >> 14 & 1023;
											var10 = var7 >> 3 & 2047;
											var11 = (var9 / 8 << 8) + var10 / 8;

											for (var12 = 0; var12 < FriendsList.regions.length; ++var12) {
												if (FriendsList.regions[var12] == var11 && Tiles.regionLandArchives[var12] != null) {
													ClientPreferences.method1853(Tiles.regionLandArchives[var12], var45, var4 * 8, var5 * 8, var8, (var9 & 7) * 8, (var10 & 7) * 8, var46, collisionMaps);
													var48 = true;
													break;
												}
											}
										}

										if (!var48) {
											var8 = var45;
											var46 = var4 * 8;
											var9 = var5 * 8;

											for (var10 = 0; var10 < 8; ++var10) {
												for (var11 = 0; var11 < 8; ++var11) {
													Tiles.Tiles_heights[var8][var46 + var10][var11 + var9] = 0;
												}
											}

											if (var46 > 0) {
												for (var10 = 1; var10 < 8; ++var10) {
													Tiles.Tiles_heights[var8][var46][var9 + var10] = Tiles.Tiles_heights[var8][var46 - 1][var9 + var10];
												}
											}

											if (var9 > 0) {
												for (var10 = 1; var10 < 8; ++var10) {
													Tiles.Tiles_heights[var8][var46 + var10][var9] = Tiles.Tiles_heights[var8][var10 + var46][var9 - 1];
												}
											}

											if (var46 > 0 && Tiles.Tiles_heights[var8][var46 - 1][var9] != 0) {
												Tiles.Tiles_heights[var8][var46][var9] = Tiles.Tiles_heights[var8][var46 - 1][var9];
											} else if (var9 > 0 && Tiles.Tiles_heights[var8][var46][var9 - 1] != 0) {
												Tiles.Tiles_heights[var8][var46][var9] = Tiles.Tiles_heights[var8][var46][var9 - 1];
											} else if (var46 > 0 && var9 > 0 && Tiles.Tiles_heights[var8][var46 - 1][var9 - 1] != 0) {
												Tiles.Tiles_heights[var8][var46][var9] = Tiles.Tiles_heights[var8][var46 - 1][var9 - 1];
											}
										}
									}
								}

								++var45;
							}
						}

						UserComparator4.method3442(true);
						UserComparator3.playPcmPlayers();
						GrandExchangeOfferNameComparator.method152(ServerBuild.scene, collisionMaps);
						UserComparator4.method3442(true);
						var45 = Tiles.Tiles_minPlane;
						if (var45 > Clock.Client_plane) {
							var45 = Clock.Client_plane;
						}

						if (var45 < Clock.Client_plane - 1) {
							var45 = Clock.Client_plane - 1;
						}

						if (isLowDetail) {
							ServerBuild.scene.init(Tiles.Tiles_minPlane);
						} else {
							ServerBuild.scene.init(0);
						}

						for (var4 = 0; var4 < 104; ++var4) {
							for (var5 = 0; var5 < 104; ++var5) {
								WorldMapEvent.updateItemPile(var4, var5);
							}
						}

						UserComparator3.playPcmPlayers();

						for (PendingSpawn var51 = (PendingSpawn)pendingSpawns.last(); var51 != null; var51 = (PendingSpawn)pendingSpawns.previous()) {
							if (var51.hitpoints == -1) {
								var51.delay = 0;
								WorldMapDecoration.method347(var51);
							} else {
								var51.remove();
							}
						}

						ObjectDefinition.ObjectDefinition_cachedModelData.clear();
						PacketBufferNode var52;
						if (Username.client.hasFrame()) {
							var52 = TilePaint.getPacketBufferNode(ClientPacket.field2249, packetWriter.isaacCipher);
							var52.packetBuffer.writeInt(1057001181);
							packetWriter.addNode(var52);
						}

						if (!isInInstance) {
							var4 = (SecureRandomCallable.field530 - 6) / 8;
							var5 = (SecureRandomCallable.field530 + 6) / 8;
							var13 = (Language.field2359 - 6) / 8;
							var7 = (Language.field2359 + 6) / 8;

							for (var8 = var4 - 1; var8 <= var5 + 1; ++var8) {
								for (var46 = var13 - 1; var46 <= var7 + 1; ++var46) {
									if (var8 < var4 || var8 > var5 || var46 < var13 || var46 > var7) {
										NetSocket.archive5.loadRegionFromName("m" + var8 + "_" + var46);
										NetSocket.archive5.loadRegionFromName("l" + var8 + "_" + var46);
									}
								}
							}
						}

						Projectile.updateGameState(30);
						UserComparator3.playPcmPlayers();
						Players.method2179();
						var52 = TilePaint.getPacketBufferNode(ClientPacket.field2218, packetWriter.isaacCipher);
						packetWriter.addNode(var52);
						class2.method24();
					}
				}
			}
		} else {
			GrandExchangeEvents.doCycleTitle(this);
		}

		if (gameState == 30) {
			this.doCycleLoggedIn();
		} else if (gameState == 40 || gameState == 45) {
			this.doCycleLoggedOut();
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1486807503"
	)
	@Export("draw")
	protected final void draw(boolean var1) {
		boolean var2 = GrandExchangeOffer.method129();
		if (var2 && field881 && WorldMapLabelSize.pcmPlayer0 != null) {
			WorldMapLabelSize.pcmPlayer0.tryDiscard();
		}

		if ((gameState == 10 || gameState == 20 || gameState == 30) && field859 != 0L && WorldMapIcon_0.currentTimeMillis() > field859) {
			VertexNormal.setWindowedMode(Friend.getWindowedMode());
		}

		int var3;
		if (var1) {
			for (var3 = 0; var3 < 100; ++var3) {
				field851[var3] = true;
			}
		}

		if (gameState == 0) {
			this.drawInitial(Login.Login_loadingPercent, Login.Login_loadingText, var1);
		} else if (gameState == 5) {
			NetSocket.drawTitle(class1.fontBold12, WorldMapData_0.fontPlain11, class13.fontPlain12);
		} else if (gameState != 10 && gameState != 11) {
			if (gameState == 20) {
				NetSocket.drawTitle(class1.fontBold12, WorldMapData_0.fontPlain11, class13.fontPlain12);
			} else if (gameState == 25) {
				if (field695 == 1) {
					if (field791 > field884) {
						field884 = field791;
					}

					var3 = (field884 * 50 - field791 * 50) / field884;
					class197.drawLoadingMessage("Loading - please wait.<br> (" + var3 + "%)", false);
				} else if (field695 == 2) {
					if (field700 > field733) {
						field733 = field700;
					}

					var3 = (field733 * 50 - field700 * 50) / field733 + 50;
					class197.drawLoadingMessage("Loading - please wait.<br> (" + var3 + "%)", false);
				} else {
					class197.drawLoadingMessage("Loading - please wait.", false);
				}
			} else if (gameState == 30) {
				this.drawLoggedIn();
			} else if (gameState == 40) {
				class197.drawLoadingMessage("Connection lost<br>Please wait - attempting to reestablish", false);
			} else if (gameState == 45) {
				class197.drawLoadingMessage("Please wait...", false);
			}
		} else {
			NetSocket.drawTitle(class1.fontBold12, WorldMapData_0.fontPlain11, class13.fontPlain12);
		}

		if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResizable) {
			for (var3 = 0; var3 < rootWidgetCount; ++var3) {
				if (field852[var3]) {
					DevicePcmPlayerProvider.rasterProvider.draw(rootWidgetXs[var3], rootWidgetYs[var3], rootWidgetWidths[var3], rootWidgetHeights[var3]);
					field852[var3] = false;
				}
			}
		} else if (gameState > 0) {
			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);

			for (var3 = 0; var3 < rootWidgetCount; ++var3) {
				field852[var3] = false;
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2144356516"
	)
	@Export("kill0")
	protected final void kill0() {
		if (class197.varcs.hasUnwrittenChanges()) {
			class197.varcs.write();
		}

		if (class16.mouseRecorder != null) {
			class16.mouseRecorder.isRunning = false;
		}

		class16.mouseRecorder = null;
		packetWriter.close();
		DevicePcmPlayerProvider.method855();
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

		PacketWriter.mouseWheel = null;
		if (WorldMapLabelSize.pcmPlayer0 != null) {
			WorldMapLabelSize.pcmPlayer0.shutdown();
		}

		if (class43.pcmPlayer1 != null) {
			class43.pcmPlayer1.shutdown();
		}

		WorldMapElement.method4470();
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3150 != 0) {
				ArchiveDiskActionHandler.field3150 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var4) {
				}
			}
		}

		if (WorldMapData_0.urlRequester != null) {
			WorldMapData_0.urlRequester.close();
			WorldMapData_0.urlRequester = null;
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var1 = 0; var1 < JagexCache.idxCount; ++var1) {
				MilliClock.JagexCache_idxFiles[var1].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var6) {
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-2"
	)
	protected final void vmethod1478() {
	}

	public final void init() {
		try {
			if (this.checkHost()) {
				for (int var1 = 0; var1 <= 19; ++var1) {
					String var2 = this.getParameter(Integer.toString(var1));
					if (var2 != null) {
						switch(var1) {
						case 1:
							useBufferedSocket = Integer.parseInt(var2) != 0;
						case 2:
						case 11:
						case 13:
						case 16:
						default:
							break;
						case 3:
							if (var2.equalsIgnoreCase("true")) {
								isMembersWorld = true;
							} else {
								isMembersWorld = false;
							}
							break;
						case 4:
							if (clientType == -1) {
								clientType = Integer.parseInt(var2);
							}
							break;
						case 5:
							worldProperties = Integer.parseInt(var2);
							break;
						case 6:
							FriendLoginUpdate.clientLanguage = Language.method3711(Integer.parseInt(var2));
							break;
						case 7:
							BuddyRankComparator.field1987 = class2.method31(Integer.parseInt(var2));
							break;
						case 8:
							if (var2.equalsIgnoreCase("true")) {
							}
							break;
						case 9:
							GameShell.field477 = var2;
							break;
						case 10:
							class14.field102 = (StudioGame)WorldMapSection0.findEnumerated(MusicPatchNode.method3898(), Integer.parseInt(var2));
							if (StudioGame.oldscape == class14.field102) {
								class192.loginType = LoginType.oldscape;
							} else {
								class192.loginType = LoginType.field4029;
							}
							break;
						case 12:
							worldId = Integer.parseInt(var2);
							break;
						case 14:
							field672 = Integer.parseInt(var2);
							break;
						case 15:
							gameBuild = Integer.parseInt(var2);
							break;
						case 17:
							StructDefinition.field3307 = var2;
						}
					}
				}

				Scene.Scene_isLowDetail = false;
				isLowDetail = false;
				NetSocket.worldHost = this.getCodeBase().getHost();
				String var17 = BuddyRankComparator.field1987.name;
				byte var18 = 0;

				try {
					JagexCache.idxCount = 21;
					GrandExchangeOfferOwnWorldComparator.cacheGamebuild = var18;

					try {
						MilliClock.field2015 = System.getProperty("os.name");
					} catch (Exception var14) {
						MilliClock.field2015 = "Unknown";
					}

					class160.field1998 = MilliClock.field2015.toLowerCase();

					try {
						UserComparator4.userHomeDirectory = System.getProperty("user.home");
						if (UserComparator4.userHomeDirectory != null) {
							UserComparator4.userHomeDirectory = UserComparator4.userHomeDirectory + "/";
						}
					} catch (Exception var13) {
					}

					try {
						if (class160.field1998.startsWith("win")) {
							if (UserComparator4.userHomeDirectory == null) {
								UserComparator4.userHomeDirectory = System.getenv("USERPROFILE");
							}
						} else if (UserComparator4.userHomeDirectory == null) {
							UserComparator4.userHomeDirectory = System.getenv("HOME");
						}

						if (UserComparator4.userHomeDirectory != null) {
							UserComparator4.userHomeDirectory = UserComparator4.userHomeDirectory + "/";
						}
					} catch (Exception var12) {
					}

					if (UserComparator4.userHomeDirectory == null) {
						UserComparator4.userHomeDirectory = "~/";
					}

					ChatChannel.field1291 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", UserComparator4.userHomeDirectory, "/tmp/", ""};
					class42.field373 = new String[]{".jagex_cache_" + GrandExchangeOfferOwnWorldComparator.cacheGamebuild, ".file_store_" + GrandExchangeOfferOwnWorldComparator.cacheGamebuild};

					int var3;
					label132:
					for (var3 = 0; var3 < 4; ++var3) {
						JagexCache.cacheDir = GrandExchangeOfferOwnWorldComparator.method1311("oldschool", var17, var3);
						if (!JagexCache.cacheDir.exists()) {
							JagexCache.cacheDir.mkdirs();
						}

						File[] var4 = JagexCache.cacheDir.listFiles();
						if (var4 == null) {
							break;
						}

						File[] var5 = var4;
						int var6 = 0;

						while (true) {
							if (var6 >= var5.length) {
								break label132;
							}

							File var7 = var5[var6];

							boolean var8;
							try {
								RandomAccessFile var9 = new RandomAccessFile(var7, "rw");
								int var10 = var9.read();
								var9.seek(0L);
								var9.write(var10);
								var9.seek(0L);
								var9.close();
								var8 = true;
							} catch (Exception var11) {
								var8 = false;
							}

							if (!var8) {
								break;
							}

							++var6;
						}
					}

					class208.method4016(JagexCache.cacheDir);
					class3.method52();
					JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(UserComparator3.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
					JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(UserComparator3.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
					MilliClock.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

					for (var3 = 0; var3 < JagexCache.idxCount; ++var3) {
						MilliClock.JagexCache_idxFiles[var3] = new BufferedFile(new AccessFile(UserComparator3.getFile("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
					}
				} catch (Exception var15) {
					class225.RunException_sendStackTrace((String)null, var15);
				}

				Username.client = this;
				RunException.clientType = clientType;
				this.startThread(765, 503, 188);
			}

		} catch (RuntimeException var16) {
			throw class218.newRunException(var16, "client.init()");
		}
	}

	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1362908208"
	)
	@Export("doCycleJs5")
	void doCycleJs5() {
		if (gameState != 1000) {
			boolean var1 = WorldMapDecorationType.method4187();
			if (!var1) {
				this.doCycleJs5Connect();
			}
		}

	}

	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "59"
	)
	@Export("doCycleJs5Connect")
	void doCycleJs5Connect() {
		if (NetCache.NetCache_crcMismatches >= 4) {
			this.error("js5crc");
			gameState = 1000;
		} else {
			if (NetCache.NetCache_ioExceptions >= 4) {
				if (gameState <= 5) {
					this.error("js5io");
					gameState = 1000;
					return;
				}

				field675 = 3000;
				NetCache.NetCache_ioExceptions = 3;
			}

			if (--field675 + 1 <= 0) {
				try {
					if (js5ConnectState == 0) {
						TileItemPile.js5SocketTask = GameShell.taskHandler.newSocketTask(NetSocket.worldHost, WorldMapSection2.port3);
						++js5ConnectState;
					}

					if (js5ConnectState == 1) {
						if (TileItemPile.js5SocketTask.status == 2) {
							this.js5Error(-1);
							return;
						}

						if (TileItemPile.js5SocketTask.status == 1) {
							++js5ConnectState;
						}
					}

					if (js5ConnectState == 2) {
						if (useBufferedSocket) {
							WorldMapIcon_0.js5Socket = Bounds.method6040((Socket)TileItemPile.js5SocketTask.result, 40000, 5000);
						} else {
							WorldMapIcon_0.js5Socket = new NetSocket((Socket)TileItemPile.js5SocketTask.result, GameShell.taskHandler, 5000);
						}

						Buffer var1 = new Buffer(5);
						var1.writeByte(15);
						var1.writeInt(188);
						WorldMapIcon_0.js5Socket.write(var1.array, 0, 5);
						++js5ConnectState;
						ServerBuild.field3111 = WorldMapIcon_0.currentTimeMillis();
					}

					if (js5ConnectState == 3) {
						if (WorldMapIcon_0.js5Socket.available() > 0 || !useBufferedSocket && gameState <= 5) {
							int var10 = WorldMapIcon_0.js5Socket.readUnsignedByte();
							if (var10 != 0) {
								this.js5Error(var10);
								return;
							}

							++js5ConnectState;
						} else if (WorldMapIcon_0.currentTimeMillis() - ServerBuild.field3111 > 30000L) {
							this.js5Error(-2);
							return;
						}
					}

					if (js5ConnectState == 4) {
						AbstractSocket var11 = WorldMapIcon_0.js5Socket;
						boolean var2 = gameState > 20;
						if (NetCache.NetCache_socket != null) {
							try {
								NetCache.NetCache_socket.close();
							} catch (Exception var8) {
							}

							NetCache.NetCache_socket = null;
						}

						NetCache.NetCache_socket = var11;
						TextureProvider.method2833(var2);
						NetCache.NetCache_responseHeaderBuffer.offset = 0;
						GrandExchangeEvent.NetCache_currentResponse = null;
						VertexNormal.NetCache_responseArchiveBuffer = null;
						NetCache.field3181 = 0;

						while (true) {
							NetFileRequest var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
							if (var3 == null) {
								while (true) {
									var3 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
									if (var3 == null) {
										if (NetCache.field3184 != 0) {
											try {
												Buffer var4 = new Buffer(4);
												var4.writeByte(4);
												var4.writeByte(NetCache.field3184);
												var4.writeShort(0);
												NetCache.NetCache_socket.write(var4.array, 0, 4);
											} catch (IOException var7) {
												try {
													NetCache.NetCache_socket.close();
												} catch (Exception var6) {
												}

												++NetCache.NetCache_ioExceptions;
												NetCache.NetCache_socket = null;
											}
										}

										NetCache.NetCache_loadTime = 0;
										NetCache.field3170 = WorldMapIcon_0.currentTimeMillis();
										TileItemPile.js5SocketTask = null;
										WorldMapIcon_0.js5Socket = null;
										js5ConnectState = 0;
										js5Errors = 0;
										return;
									}

									NetCache.NetCache_pendingWritesQueue.addLast(var3);
									NetCache.NetCache_pendingWrites.put(var3, var3.key);
									++NetCache.NetCache_pendingWritesCount;
									--NetCache.NetCache_pendingResponsesCount;
								}
							}

							NetCache.NetCache_pendingPriorityWrites.put(var3, var3.key);
							++NetCache.NetCache_pendingPriorityWritesCount;
							--NetCache.NetCache_pendingPriorityResponsesCount;
						}
					}
				} catch (IOException var9) {
					this.js5Error(-3);
				}
			}
		}

	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-52"
	)
	@Export("js5Error")
	void js5Error(int var1) {
		TileItemPile.js5SocketTask = null;
		WorldMapIcon_0.js5Socket = null;
		js5ConnectState = 0;
		if (WorldMapSection2.port3 == WorldMapLabelSize.port1) {
			WorldMapSection2.port3 = port2;
		} else {
			WorldMapSection2.port3 = WorldMapLabelSize.port1;
		}

		++js5Errors;
		if (js5Errors < 2 || var1 != 7 && var1 != 9) {
			if (js5Errors >= 2 && var1 == 6) {
				this.error("js5connect_outofdate");
				gameState = 1000;
			} else if (js5Errors >= 4) {
				if (gameState <= 5) {
					this.error("js5connect");
					gameState = 1000;
				} else {
					field675 = 3000;
				}
			}
		} else if (gameState <= 5) {
			this.error("js5connect_full");
			gameState = 1000;
		} else {
			field675 = 3000;
		}

	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1666234502"
	)
	@Export("doCycleLoggedOut")
	final void doCycleLoggedOut() {
		Object var1 = packetWriter.getSocket();
		PacketBuffer var2 = packetWriter.packetBuffer;

		try {
			if (loginState == 0) {
				if (ScriptEvent.secureRandom == null && (secureRandomFuture.isDone() || field679 > 250)) {
					ScriptEvent.secureRandom = secureRandomFuture.get();
					secureRandomFuture.shutdown();
					secureRandomFuture = null;
				}

				if (ScriptEvent.secureRandom != null) {
					if (var1 != null) {
						((AbstractSocket)var1).close();
						var1 = null;
					}

					NetFileRequest.socketTask = null;
					field800 = false;
					field679 = 0;
					loginState = 1;
				}
			}

			if (loginState == 1) {
				if (NetFileRequest.socketTask == null) {
					NetFileRequest.socketTask = GameShell.taskHandler.newSocketTask(NetSocket.worldHost, WorldMapSection2.port3);
				}

				if (NetFileRequest.socketTask.status == 2) {
					throw new IOException();
				}

				if (NetFileRequest.socketTask.status == 1) {
					if (useBufferedSocket) {
						var1 = Bounds.method6040((Socket)NetFileRequest.socketTask.result, 40000, 5000);
					} else {
						var1 = new NetSocket((Socket)NetFileRequest.socketTask.result, GameShell.taskHandler, 5000);
					}

					packetWriter.setSocket((AbstractSocket)var1);
					NetFileRequest.socketTask = null;
					loginState = 2;
				}
			}

			if (loginState == 2) {
				packetWriter.clearBuffer();
				PacketBufferNode var3 = UserComparator5.method3488();
				var3.clientPacket = null;
				var3.clientPacketLength = 0;
				var3.packetBuffer = new PacketBuffer(5000);
				var3.packetBuffer.writeByte(LoginPacket.field2310.id);
				packetWriter.addNode(var3);
				packetWriter.flush();
				var2.offset = 0;
				loginState = 3;
			}

			int var4;
			boolean var19;
			if (loginState == 3) {
				if (WorldMapLabelSize.pcmPlayer0 != null) {
					WorldMapLabelSize.pcmPlayer0.method2489();
				}

				if (class43.pcmPlayer1 != null) {
					class43.pcmPlayer1.method2489();
				}

				var19 = true;
				if (useBufferedSocket && !((AbstractSocket)var1).isAvailable(1)) {
					var19 = false;
				}

				if (var19) {
					var4 = ((AbstractSocket)var1).readUnsignedByte();
					if (WorldMapLabelSize.pcmPlayer0 != null) {
						WorldMapLabelSize.pcmPlayer0.method2489();
					}

					if (class43.pcmPlayer1 != null) {
						class43.pcmPlayer1.method2489();
					}

					if (var4 != 0) {
						GameShell.getLoginError(var4);
						return;
					}

					var2.offset = 0;
					loginState = 4;
				}
			}

			int var5;
			if (loginState == 4) {
				if (var2.offset < 8) {
					var5 = ((AbstractSocket)var1).available();
					if (var5 > 8 - var2.offset) {
						var5 = 8 - var2.offset;
					}

					if (var5 > 0) {
						((AbstractSocket)var1).read(var2.array, var2.offset, var5);
						var2.offset += var5;
					}
				}

				if (var2.offset == 8) {
					var2.offset = 0;
					WorldMapLabel.field250 = var2.readLong();
					loginState = 5;
				}
			}

			if (loginState == 5) {
				packetWriter.packetBuffer.offset = 0;
				packetWriter.clearBuffer();
				PacketBuffer var6 = new PacketBuffer(500);
				int[] var7 = new int[]{ScriptEvent.secureRandom.nextInt(), ScriptEvent.secureRandom.nextInt(), ScriptEvent.secureRandom.nextInt(), ScriptEvent.secureRandom.nextInt()};
				var6.offset = 0;
				var6.writeByte(1);
				var6.writeInt(var7[0]);
				var6.writeInt(var7[1]);
				var6.writeInt(var7[2]);
				var6.writeInt(var7[3]);
				var6.writeLong(WorldMapLabel.field250);
				int var10;
				int var12;
				if (gameState == 40) {
					var6.writeInt(WorldMapSection1.field295[0]);
					var6.writeInt(WorldMapSection1.field295[1]);
					var6.writeInt(WorldMapSection1.field295[2]);
					var6.writeInt(WorldMapSection1.field295[3]);
				} else {
					var6.writeByte(field682.rsOrdinal());
					switch(field682.field1992) {
					case 0:
					case 3:
						var6.writeMedium(Frames.field1885);
						++var6.offset;
						break;
					case 1:
						LinkedHashMap var8 = WorldMapSection2.clientPreferences.parameters;
						String var9 = Login.Login_username;
						var10 = var9.length();
						int var11 = 0;

						for (var12 = 0; var12 < var10; ++var12) {
							var11 = (var11 << 5) - var11 + var9.charAt(var12);
						}

						var6.writeInt((Integer)var8.get(var11));
						break;
					case 2:
						var6.offset += 4;
					}

					var6.writeByte(class313.field3815.rsOrdinal());
					var6.writeStringCp1252NullTerminated(Login.Login_password);
				}

				var6.encryptRsa(class83.field1151, class83.field1150);
				WorldMapSection1.field295 = var7;
				PacketBufferNode var25 = UserComparator5.method3488();
				var25.clientPacket = null;
				var25.clientPacketLength = 0;
				var25.packetBuffer = new PacketBuffer(5000);
				var25.packetBuffer.offset = 0;
				if (gameState == 40) {
					var25.packetBuffer.writeByte(LoginPacket.field2313.id);
				} else {
					var25.packetBuffer.writeByte(LoginPacket.field2308.id);
				}

				var25.packetBuffer.writeShort(0);
				int var28 = var25.packetBuffer.offset;
				var25.packetBuffer.writeInt(188);
				var25.packetBuffer.writeInt(1);
				var25.packetBuffer.writeByte(clientType);
				var25.packetBuffer.writeBytes(var6.array, 0, var6.offset);
				var10 = var25.packetBuffer.offset;
				var25.packetBuffer.writeStringCp1252NullTerminated(Login.Login_username);
				var25.packetBuffer.writeByte((isResizable ? 1 : 0) << 1 | (isLowDetail ? 1 : 0));
				var25.packetBuffer.writeShort(Username.canvasWidth);
				var25.packetBuffer.writeShort(WorldMapData_1.canvasHeight);
				PacketBuffer var30 = var25.packetBuffer;
				if (randomDatData != null) {
					var30.writeBytes(randomDatData, 0, randomDatData.length);
				} else {
					byte[] var13 = new byte[24];

					try {
						JagexCache.JagexCache_randomDat.seek(0L);
						JagexCache.JagexCache_randomDat.readFully(var13);

						for (var12 = 0; var12 < 24 && var13[var12] == 0; ++var12) {
						}

						if (var12 >= 24) {
							throw new IOException();
						}
					} catch (Exception var17) {
						for (int var15 = 0; var15 < 24; ++var15) {
							var13[var15] = -1;
						}
					}

					var30.writeBytes(var13, 0, var13.length);
				}

				var25.packetBuffer.writeStringCp1252NullTerminated(GameShell.field477);
				var25.packetBuffer.writeInt(field672);
				Buffer var31 = new Buffer(NetSocket.platformInfo.size());
				NetSocket.platformInfo.write(var31);
				var25.packetBuffer.writeBytes(var31.array, 0, var31.array.length);
				var25.packetBuffer.writeByte(clientType);
				var25.packetBuffer.writeInt(0);
				var25.packetBuffer.writeInt(GrandExchangeEvent.archive0.hash);
				var25.packetBuffer.writeInt(class65.archive1.hash);
				var25.packetBuffer.writeInt(GrandExchangeOfferWorldComparator.archive2.hash);
				var25.packetBuffer.writeInt(class267.archive3.hash);
				var25.packetBuffer.writeInt(archive4.hash);
				var25.packetBuffer.writeInt(NetSocket.archive5.hash);
				var25.packetBuffer.writeInt(MouseHandler.archive6.hash);
				var25.packetBuffer.writeInt(BuddyRankComparator.archive7.hash);
				var25.packetBuffer.writeInt(UserComparator8.archive8.hash);
				var25.packetBuffer.writeInt(GrandExchangeOfferNameComparator.archive9.hash);
				var25.packetBuffer.writeInt(HealthBar.archive10.hash);
				var25.packetBuffer.writeInt(GrandExchangeOffer.archive11.hash);
				var25.packetBuffer.writeInt(MilliClock.archive12.hash);
				var25.packetBuffer.writeInt(MouseHandler.archive13.hash);
				var25.packetBuffer.writeInt(class189.archive14.hash);
				var25.packetBuffer.writeInt(WorldMapSection1.archive15.hash);
				var25.packetBuffer.writeInt(0);
				var25.packetBuffer.writeInt(archive17.hash);
				var25.packetBuffer.writeInt(UserComparator2.archive18.hash);
				var25.packetBuffer.writeInt(Clock.archive19.hash);
				var25.packetBuffer.writeInt(SecureRandomCallable.archive20.hash);
				var25.packetBuffer.xteaEncrypt(var7, var10, var25.packetBuffer.offset);
				var25.packetBuffer.writeLengthShort(var25.packetBuffer.offset - var28);
				packetWriter.addNode(var25);
				packetWriter.flush();
				packetWriter.isaacCipher = new IsaacCipher(var7);
				int[] var14 = new int[4];

				for (var12 = 0; var12 < 4; ++var12) {
					var14[var12] = var7[var12] + 50;
				}

				var2.newIsaacCipher(var14);
				loginState = 6;
			}

			if (loginState == 6 && ((AbstractSocket)var1).available() > 0) {
				var5 = ((AbstractSocket)var1).readUnsignedByte();
				if (var5 == 21 && gameState == 20) {
					loginState = 9;
				} else if (var5 == 2) {
					loginState = 11;
				} else if (var5 == 15 && gameState == 40) {
					packetWriter.serverPacketLength = -1;
					loginState = 16;
				} else if (var5 == 64) {
					loginState = 7;
				} else if (var5 == 23 && field680 < 1) {
					++field680;
					loginState = 0;
				} else {
					if (var5 != 29) {
						GameShell.getLoginError(var5);
						return;
					}

					loginState = 14;
				}
			}

			if (loginState == 7 && ((AbstractSocket)var1).available() > 0) {
				WorldMapIcon_0.field148 = ((AbstractSocket)var1).readUnsignedByte();
				loginState = 8;
			}

			if (loginState == 8 && ((AbstractSocket)var1).available() >= WorldMapIcon_0.field148) {
				((AbstractSocket)var1).read(var2.array, 0, WorldMapIcon_0.field148);
				var2.offset = 0;
				loginState = 6;
			}

			if (loginState == 9 && ((AbstractSocket)var1).available() > 0) {
				field681 = (((AbstractSocket)var1).readUnsignedByte() + 3) * 60;
				loginState = 10;
			}

			if (loginState == 10) {
				field679 = 0;
				Tiles.setLoginResponseString("You have only just left another world.", "Your profile will be transferred in:", field681 / 60 + " seconds.");
				if (--field681 <= 0) {
					loginState = 0;
				}
			} else {
				if (loginState == 11 && ((AbstractSocket)var1).available() >= 1) {
					class189.field2353 = ((AbstractSocket)var1).readUnsignedByte();
					loginState = 12;
				}

				if (loginState == 12 && ((AbstractSocket)var1).available() >= class189.field2353) {
					var19 = ((AbstractSocket)var1).readUnsignedByte() == 1;
					((AbstractSocket)var1).read(var2.array, 0, 4);
					var2.offset = 0;
					boolean var20 = false;
					if (var19) {
						var4 = var2.readByteIsaac() << 24;
						var4 |= var2.readByteIsaac() << 16;
						var4 |= var2.readByteIsaac() << 8;
						var4 |= var2.readByteIsaac();
						int var22 = Buddy.method5234(Login.Login_username);
						if (WorldMapSection2.clientPreferences.parameters.size() >= 10 && !WorldMapSection2.clientPreferences.parameters.containsKey(var22)) {
							Iterator var26 = WorldMapSection2.clientPreferences.parameters.entrySet().iterator();
							var26.next();
							var26.remove();
						}

						WorldMapSection2.clientPreferences.parameters.put(var22, var4);
					}

					if (Login_isUsernameRemembered) {
						WorldMapSection2.clientPreferences.rememberedUsername = Login.Login_username;
					} else {
						WorldMapSection2.clientPreferences.rememberedUsername = null;
					}

					WorldMapData_1.savePreferences();
					staffModLevel = ((AbstractSocket)var1).readUnsignedByte();
					playerMod = ((AbstractSocket)var1).readUnsignedByte() == 1;
					localPlayerIndex = ((AbstractSocket)var1).readUnsignedByte();
					localPlayerIndex <<= 8;
					localPlayerIndex += ((AbstractSocket)var1).readUnsignedByte();
					field763 = ((AbstractSocket)var1).readUnsignedByte();
					((AbstractSocket)var1).read(var2.array, 0, 1);
					var2.offset = 0;
					ServerPacket[] var23 = Occluder.ServerPacket_values();
					int var27 = var2.readSmartByteShortIsaac();
					if (var27 < 0 || var27 >= var23.length) {
						throw new IOException(var27 + " " + var2.offset);
					}

					packetWriter.serverPacket = var23[var27];
					packetWriter.serverPacketLength = packetWriter.serverPacket.length;
					((AbstractSocket)var1).read(var2.array, 0, 2);
					var2.offset = 0;
					packetWriter.serverPacketLength = var2.readUnsignedShort();

					try {
						class47.method857(Username.client, "zap");
					} catch (Throwable var16) {
					}

					loginState = 13;
				}

				if (loginState == 13) {
					if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
						timer.method5047();
						class2.method32();
						MenuAction.updatePlayer(var2);
						SecureRandomCallable.field530 = -1;
						WorldMapLabel.loadRegions(false, var2);
						packetWriter.serverPacket = null;
					}
				} else {
					if (loginState == 14 && ((AbstractSocket)var1).available() >= 2) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, 2);
						var2.offset = 0;
						FontName.field3650 = var2.readUnsignedShort();
						loginState = 15;
					}

					if (loginState == 15 && ((AbstractSocket)var1).available() >= FontName.field3650) {
						var2.offset = 0;
						((AbstractSocket)var1).read(var2.array, 0, FontName.field3650);
						var2.offset = 0;
						String var21 = var2.readStringCp1252NullTerminated();
						String var24 = var2.readStringCp1252NullTerminated();
						String var29 = var2.readStringCp1252NullTerminated();
						Tiles.setLoginResponseString(var21, var24, var29);
						Projectile.updateGameState(10);
					}

					if (loginState == 16) {
						if (packetWriter.serverPacketLength == -1) {
							if (((AbstractSocket)var1).available() < 2) {
								return;
							}

							((AbstractSocket)var1).read(var2.array, 0, 2);
							var2.offset = 0;
							packetWriter.serverPacketLength = var2.readUnsignedShort();
						}

						if (((AbstractSocket)var1).available() >= packetWriter.serverPacketLength) {
							((AbstractSocket)var1).read(var2.array, 0, packetWriter.serverPacketLength);
							var2.offset = 0;
							var5 = packetWriter.serverPacketLength;
							timer.method5046();
							MouseHandler.method1110();
							MenuAction.updatePlayer(var2);
							if (var5 != var2.offset) {
								throw new RuntimeException();
							}
						}
					} else {
						++field679;
						if (field679 > 2000) {
							if (field680 < 1) {
								if (WorldMapSection2.port3 == WorldMapLabelSize.port1) {
									WorldMapSection2.port3 = port2;
								} else {
									WorldMapSection2.port3 = WorldMapLabelSize.port1;
								}

								++field680;
								loginState = 0;
							} else {
								GameShell.getLoginError(-3);
							}
						}
					}
				}
			}
		} catch (IOException var18) {
			if (field680 < 1) {
				if (WorldMapSection2.port3 == WorldMapLabelSize.port1) {
					WorldMapSection2.port3 = port2;
				} else {
					WorldMapSection2.port3 = WorldMapLabelSize.port1;
				}

				++field680;
				loginState = 0;
			} else {
				GameShell.getLoginError(-2);
			}
		}

	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "14"
	)
	@Export("doCycleLoggedIn")
	final void doCycleLoggedIn() {
		if (rebootTimer > 1) {
			--rebootTimer;
		}

		if (logoutTimer > 0) {
			--logoutTimer;
		}

		if (field800) {
			field800 = false;
			WorldMapIcon_1.method308();
		} else {
			if (!isMenuOpen) {
				class96.addCancelMenuEntry();
			}

			int var1;
			for (var1 = 0; var1 < 100 && this.method1363(packetWriter); ++var1) {
			}

			if (gameState == 30) {
				int var2;
				PacketBufferNode var3;
				while (FaceNormal.method3334()) {
					var3 = TilePaint.getPacketBufferNode(ClientPacket.field2235, packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(0);
					var2 = var3.packetBuffer.offset;
					Messages.performReflectionCheck(var3.packetBuffer);
					var3.packetBuffer.writeLengthByte(var3.packetBuffer.offset - var2);
					packetWriter.addNode(var3);
				}

				if (timer.field3569) {
					var3 = TilePaint.getPacketBufferNode(ClientPacket.field2293, packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(0);
					var2 = var3.packetBuffer.offset;
					timer.write(var3.packetBuffer);
					var3.packetBuffer.writeLengthByte(var3.packetBuffer.offset - var2);
					packetWriter.addNode(var3);
					timer.method5057();
				}

				int var4;
				int var5;
				int var6;
				int var7;
				int var8;
				int var9;
				int var10;
				int var11;
				int var12;
				int var13;
				synchronized(class16.mouseRecorder.lock) {
					if (!field922) {
						class16.mouseRecorder.index = 0;
					} else if (MouseHandler.MouseHandler_lastButton != 0 || class16.mouseRecorder.index >= 40) {
						PacketBufferNode var15 = null;
						var4 = 0;
						var5 = 0;
						var6 = 0;
						var7 = 0;

						for (var8 = 0; var8 < class16.mouseRecorder.index && (var15 == null || var15.packetBuffer.offset - var4 < 246); ++var8) {
							var5 = var8;
							var9 = class16.mouseRecorder.ys[var8];
							if (var9 < -1) {
								var9 = -1;
							} else if (var9 > 65534) {
								var9 = 65534;
							}

							var10 = class16.mouseRecorder.xs[var8];
							if (var10 < -1) {
								var10 = -1;
							} else if (var10 > 65534) {
								var10 = 65534;
							}

							if (var10 != field657 || var9 != field912) {
								if (var15 == null) {
									var15 = TilePaint.getPacketBufferNode(ClientPacket.field2222, packetWriter.isaacCipher);
									var15.packetBuffer.writeByte(0);
									var4 = var15.packetBuffer.offset;
									PacketBuffer var16 = var15.packetBuffer;
									var16.offset += 2;
									var6 = 0;
									var7 = 0;
								}

								if (-1L != field745) {
									var11 = var10 - field657;
									var12 = var9 - field912;
									var13 = (int)((class16.mouseRecorder.millis[var8] - field745) / 20L);
									var6 = (int)((long)var6 + (class16.mouseRecorder.millis[var8] - field745) % 20L);
								} else {
									var11 = var10;
									var12 = var9;
									var13 = Integer.MAX_VALUE;
								}

								field657 = var10;
								field912 = var9;
								if (var13 < 8 && var11 >= -32 && var11 <= 31 && var12 >= -32 && var12 <= 31) {
									var11 += 32;
									var12 += 32;
									var15.packetBuffer.writeShort((var13 << 12) + var12 + (var11 << 6));
								} else if (var13 < 32 && var11 >= -128 && var11 <= 127 && var12 >= -128 && var12 <= 127) {
									var11 += 128;
									var12 += 128;
									var15.packetBuffer.writeByte(var13 + 128);
									var15.packetBuffer.writeShort(var12 + (var11 << 8));
								} else if (var13 < 32) {
									var15.packetBuffer.writeByte(var13 + 192);
									if (var10 != -1 && var9 != -1) {
										var15.packetBuffer.writeInt(var10 | var9 << 16);
									} else {
										var15.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								} else {
									var15.packetBuffer.writeShort((var13 & 8191) + 57344);
									if (var10 != -1 && var9 != -1) {
										var15.packetBuffer.writeInt(var10 | var9 << 16);
									} else {
										var15.packetBuffer.writeInt(Integer.MIN_VALUE);
									}
								}

								++var7;
								field745 = class16.mouseRecorder.millis[var8];
							}
						}

						if (var15 != null) {
							var15.packetBuffer.writeLengthByte(var15.packetBuffer.offset - var4);
							var8 = var15.packetBuffer.offset;
							var15.packetBuffer.offset = var4;
							var15.packetBuffer.writeByte(var6 / var7);
							var15.packetBuffer.writeByte(var6 % var7);
							var15.packetBuffer.offset = var8;
							packetWriter.addNode(var15);
						}

						if (var5 >= class16.mouseRecorder.index) {
							class16.mouseRecorder.index = 0;
						} else {
							MouseRecorder var27 = class16.mouseRecorder;
							var27.index -= var5;
							System.arraycopy(class16.mouseRecorder.xs, var5, class16.mouseRecorder.xs, 0, class16.mouseRecorder.index);
							System.arraycopy(class16.mouseRecorder.ys, var5, class16.mouseRecorder.ys, 0, class16.mouseRecorder.index);
							System.arraycopy(class16.mouseRecorder.millis, var5, class16.mouseRecorder.millis, 0, class16.mouseRecorder.index);
						}
					}
				}

				long var14;
				if (MouseHandler.MouseHandler_lastButton == 1 || !ArchiveLoader.mouseCam && MouseHandler.MouseHandler_lastButton == 4 || MouseHandler.MouseHandler_lastButton == 2) {
					var14 = MouseHandler.MouseHandler_lastPressedTimeMillis - mouseLastLastPressedTimeMillis;
					if (var14 > 32767L) {
						var14 = 32767L;
					}

					mouseLastLastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillis;
					var4 = MouseHandler.MouseHandler_lastPressedY;
					if (var4 < 0) {
						var4 = 0;
					} else if (var4 > WorldMapData_1.canvasHeight) {
						var4 = WorldMapData_1.canvasHeight;
					}

					var5 = MouseHandler.MouseHandler_lastPressedX;
					if (var5 < 0) {
						var5 = 0;
					} else if (var5 > Username.canvasWidth) {
						var5 = Username.canvasWidth;
					}

					var6 = (int)var14;
					PacketBufferNode var28 = TilePaint.getPacketBufferNode(ClientPacket.field2275, packetWriter.isaacCipher);
					var28.packetBuffer.writeShort((MouseHandler.MouseHandler_lastButton == 2 ? 1 : 0) + (var6 << 1));
					var28.packetBuffer.writeShort(var5);
					var28.packetBuffer.writeShort(var4);
					packetWriter.addNode(var28);
				}

				if (KeyHandler.field405 > 0) {
					var3 = TilePaint.getPacketBufferNode(ClientPacket.field2286, packetWriter.isaacCipher);
					var3.packetBuffer.writeShort(0);
					var2 = var3.packetBuffer.offset;
					var14 = WorldMapIcon_0.currentTimeMillis();

					for (var6 = 0; var6 < KeyHandler.field405; ++var6) {
						long var29 = var14 - field702;
						if (var29 > 16777215L) {
							var29 = 16777215L;
						}

						field702 = var14;
						var3.packetBuffer.writeByte(KeyHandler.field404[var6]);
						var3.packetBuffer.method5619((int)var29);
					}

					var3.packetBuffer.writeLengthShort(var3.packetBuffer.offset - var2);
					packetWriter.addNode(var3);
				}

				if (field729 > 0) {
					--field729;
				}

				if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
					field730 = true;
				}

				if (field730 && field729 <= 0) {
					field729 = 20;
					field730 = false;
					var3 = TilePaint.getPacketBufferNode(ClientPacket.field2208, packetWriter.isaacCipher);
					var3.packetBuffer.method5787(camAngleY);
					var3.packetBuffer.writeShortLE(camAngleX);
					packetWriter.addNode(var3);
				}

				if (GrandExchangeOfferTotalQuantityComparator.hasFocus && !hadFocus) {
					hadFocus = true;
					var3 = TilePaint.getPacketBufferNode(ClientPacket.field2210, packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(1);
					packetWriter.addNode(var3);
				}

				if (!GrandExchangeOfferTotalQuantityComparator.hasFocus && hadFocus) {
					hadFocus = false;
					var3 = TilePaint.getPacketBufferNode(ClientPacket.field2210, packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(0);
					packetWriter.addNode(var3);
				}

				if (WorldMapIcon_0.worldMap != null) {
					WorldMapIcon_0.worldMap.method6499();
				}

				Canvas.method861();
				int[] var25;
				if (Clock.Client_plane != field704) {
					field704 = Clock.Client_plane;
					var1 = Clock.Client_plane;
					var25 = WorldMapRectangle.sceneMinimapSprite.pixels;
					var4 = var25.length;

					for (var5 = 0; var5 < var4; ++var5) {
						var25[var5] = 0;
					}

					var5 = 1;

					while (true) {
						if (var5 >= 103) {
							var5 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
							var6 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
							WorldMapRectangle.sceneMinimapSprite.setRaster();

							for (var7 = 1; var7 < 103; ++var7) {
								for (var8 = 1; var8 < 103; ++var8) {
									if ((Tiles.Tiles_renderFlags[var1][var8][var7] & 24) == 0) {
										RouteStrategy.drawObject(var1, var8, var7, var5, var6);
									}

									if (var1 < 3 && (Tiles.Tiles_renderFlags[var1 + 1][var8][var7] & 8) != 0) {
										RouteStrategy.drawObject(var1 + 1, var8, var7, var5, var6);
									}
								}
							}

							mapIconCount = 0;

							for (var7 = 0; var7 < 104; ++var7) {
								for (var8 = 0; var8 < 104; ++var8) {
									long var30 = ServerBuild.scene.getFloorDecorationTag(Clock.Client_plane, var7, var8);
									if (0L != var30) {
										var11 = GrandExchangeEvents.Entity_unpackID(var30);
										var12 = Occluder.getObjectDefinition(var11).mapIconId;
										if (var12 >= 0) {
											mapIcons[mapIconCount] = PacketBufferNode.WorldMapElement_get(var12).getSpriteBool(false);
											mapIconXs[mapIconCount] = var7;
											mapIconYs[mapIconCount] = var8;
											++mapIconCount;
										}
									}
								}
							}

							DevicePcmPlayerProvider.rasterProvider.apply();
							break;
						}

						var6 = (103 - var5) * 2048 + 24628;

						for (var7 = 1; var7 < 103; ++var7) {
							if ((Tiles.Tiles_renderFlags[var1][var7][var5] & 24) == 0) {
								ServerBuild.scene.drawTileMinimap(var25, var6, 512, var1, var7, var5);
							}

							if (var1 < 3 && (Tiles.Tiles_renderFlags[var1 + 1][var7][var5] & 8) != 0) {
								ServerBuild.scene.drawTileMinimap(var25, var6, 512, var1 + 1, var7, var5);
							}

							var6 += 4;
						}

						++var5;
					}
				}

				if (gameState == 30) {
					for (PendingSpawn var26 = (PendingSpawn)pendingSpawns.last(); var26 != null; var26 = (PendingSpawn)pendingSpawns.previous()) {
						if (var26.hitpoints > 0) {
							--var26.hitpoints;
						}

						if (var26.hitpoints == 0) {
							if (var26.objectId < 0 || WorldMapData_0.method187(var26.objectId, var26.field924)) {
								WorldMapSection0.addPendingSpawnToScene(var26.plane, var26.type, var26.x, var26.y, var26.objectId, var26.field935, var26.field924);
								var26.remove();
							}
						} else {
							if (var26.delay > 0) {
								--var26.delay;
							}

							if (var26.delay == 0 && var26.x >= 1 && var26.y >= 1 && var26.x <= 102 && var26.y <= 102 && (var26.id < 0 || WorldMapData_0.method187(var26.id, var26.field933))) {
								WorldMapSection0.addPendingSpawnToScene(var26.plane, var26.type, var26.x, var26.y, var26.id, var26.orientation, var26.field933);
								var26.delay = -1;
								if (var26.id == var26.objectId && var26.objectId == -1) {
									var26.remove();
								} else if (var26.id == var26.objectId && var26.field935 == var26.orientation && var26.field924 == var26.field933) {
									var26.remove();
								}
							}
						}
					}

					class222.method4192();
					++packetWriter.field1299;
					if (packetWriter.field1299 <= 750) {
						Entity.method3332();
						WorldMapSprite.method434();
						var25 = Players.Players_indices;

						for (var2 = 0; var2 < Players.Players_count; ++var2) {
							Player var31 = players[var25[var2]];
							if (var31 != null && var31.overheadTextCyclesRemaining > 0) {
								--var31.overheadTextCyclesRemaining;
								if (var31.overheadTextCyclesRemaining == 0) {
									var31.overheadText = null;
								}
							}
						}

						for (var2 = 0; var2 < npcCount; ++var2) {
							var4 = npcIndices[var2];
							NPC var33 = npcs[var4];
							if (var33 != null && var33.overheadTextCyclesRemaining > 0) {
								--var33.overheadTextCyclesRemaining;
								if (var33.overheadTextCyclesRemaining == 0) {
									var33.overheadText = null;
								}
							}
						}

						++field707;
						if (mouseCrossColor != 0) {
							mouseCrossState = mouseCrossState * 400 + 400;
							if (mouseCrossState * 20 >= 400) {
								mouseCrossColor = 0;
							}
						}

						if (Skeleton.field1793 != null) {
							++field751;
							if (field751 >= 15) {
								NPCDefinition.invalidateWidget(Skeleton.field1793);
								Skeleton.field1793 = null;
							}
						}

						Widget var34 = GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1;
						Widget var35 = VarbitDefinition.field3296;
						GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 = null;
						VarbitDefinition.field3296 = null;
						draggedOnWidget = null;
						field827 = false;
						field824 = false;
						field762 = 0;

						while (SoundSystem.isKeyDown() && field762 < 128) {
							if (staffModLevel >= 2 && KeyHandler.KeyHandler_pressedKeys[82] && RouteStrategy.field2102 == 66) {
								String var17 = Skeleton.method3153();
								Username.client.clipboardSetString(var17);
							} else if (oculusOrbState != 1 || class51.field432 <= 0) {
								field869[field762] = RouteStrategy.field2102;
								field868[field762] = class51.field432;
								++field762;
							}
						}

						if (FloorOverlayDefinition.method4835() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81] && mouseWheelRotation != 0) {
							var4 = class192.localPlayer.plane - mouseWheelRotation;
							if (var4 < 0) {
								var4 = 0;
							} else if (var4 > 3) {
								var4 = 3;
							}

							if (var4 != class192.localPlayer.plane) {
								WorldMapRegion.method563(class192.localPlayer.pathX[0] + Messages.baseX * 64, class192.localPlayer.pathY[0] + Language.baseY * 64, var4, false);
							}

							mouseWheelRotation = 0;
						}

						if (rootInterface != -1) {
							WorldMapDecoration.updateRootInterface(rootInterface, 0, 0, Username.canvasWidth, WorldMapData_1.canvasHeight, 0, 0);
						}

						++cycleCntr;

						while (true) {
							ScriptEvent var18;
							Widget var19;
							Widget var32;
							do {
								var18 = (ScriptEvent)field846.removeLast();
								if (var18 == null) {
									while (true) {
										do {
											var18 = (ScriptEvent)field847.removeLast();
											if (var18 == null) {
												while (true) {
													do {
														var18 = (ScriptEvent)scriptEvents.removeLast();
														if (var18 == null) {
															this.menu();
															if (WorldMapIcon_0.worldMap != null) {
																WorldMapIcon_0.worldMap.method6371(Clock.Client_plane, Messages.baseX * 64 + (class192.localPlayer.x >> 7), Language.baseY * 64 + (class192.localPlayer.y >> 7), false);
																WorldMapIcon_0.worldMap.loadCache();
															}

															if (clickedWidget != null) {
																this.method1541();
															}

															PacketBufferNode var20;
															if (class185.dragInventoryWidget != null) {
																NPCDefinition.invalidateWidget(class185.dragInventoryWidget);
																++itemDragDuration;
																if (MouseHandler.MouseHandler_currentButton == 0) {
																	if (field757) {
																		if (FloorDecoration.field1604 == class185.dragInventoryWidget && dragItemSlotDestination != dragItemSlotSource) {
																			Widget var21 = class185.dragInventoryWidget;
																			byte var22 = 0;
																			if (field811 == 1 && var21.contentType == 206) {
																				var22 = 1;
																			}

																			if (var21.itemIds[dragItemSlotDestination] <= 0) {
																				var22 = 0;
																			}

																			if (FriendLoginUpdate.method5326(WorldMapIcon_0.getWidgetClickMask(var21))) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;
																				var21.itemIds[var7] = var21.itemIds[var6];
																				var21.itemQuantities[var7] = var21.itemQuantities[var6];
																				var21.itemIds[var6] = -1;
																				var21.itemQuantities[var6] = 0;
																			} else if (var22 == 1) {
																				var6 = dragItemSlotSource;
																				var7 = dragItemSlotDestination;

																				while (var7 != var6) {
																					if (var6 > var7) {
																						var21.swapItems(var6 - 1, var6);
																						--var6;
																					} else if (var6 < var7) {
																						var21.swapItems(var6 + 1, var6);
																						++var6;
																					}
																				}
																			} else {
																				var21.swapItems(dragItemSlotDestination, dragItemSlotSource);
																			}

																			var20 = TilePaint.getPacketBufferNode(ClientPacket.field2219, packetWriter.isaacCipher);
																			var20.packetBuffer.method5787(dragItemSlotSource);
																			var20.packetBuffer.method5604(var22);
																			var20.packetBuffer.method5787(dragItemSlotDestination);
																			var20.packetBuffer.method5624(class185.dragInventoryWidget.id);
																			packetWriter.addNode(var20);
																		}
																	} else if (this.shouldLeftClickOpenMenu()) {
																		this.openMenu(draggedWidgetX, draggedWidgetY);
																	} else if (menuOptionsCount > 0) {
																		GrandExchangeOfferTotalQuantityComparator.method105(draggedWidgetX, draggedWidgetY);
																	}

																	field751 = 10;
																	MouseHandler.MouseHandler_lastButton = 0;
																	class185.dragInventoryWidget = null;
																} else if (itemDragDuration >= 5 && (MouseHandler.MouseHandler_x > draggedWidgetX + 5 || MouseHandler.MouseHandler_x < draggedWidgetX - 5 || MouseHandler.MouseHandler_y > draggedWidgetY + 5 || MouseHandler.MouseHandler_y < draggedWidgetY - 5)) {
																	field757 = true;
																}
															}

															if (Scene.method3321()) {
																var4 = Scene.Scene_selectedX;
																var5 = Scene.Scene_selectedY;
																var20 = TilePaint.getPacketBufferNode(ClientPacket.field2207, packetWriter.isaacCipher);
																var20.packetBuffer.writeByte(5);
																var20.packetBuffer.writeShort(Language.baseY * 64 + var5);
																var20.packetBuffer.method5787(Messages.baseX * 64 + var4);
																var20.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
																packetWriter.addNode(var20);
																Scene.method3279();
																mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
																mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
																mouseCrossColor = 1;
																mouseCrossState = 0;
																destinationX = var4;
																destinationY = var5;
															}

															if (var34 != GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1) {
																if (var34 != null) {
																	NPCDefinition.invalidateWidget(var34);
																}

																if (GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 != null) {
																	NPCDefinition.invalidateWidget(GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1);
																}
															}

															if (var35 != VarbitDefinition.field3296 && field796 == field797) {
																if (var35 != null) {
																	NPCDefinition.invalidateWidget(var35);
																}

																if (VarbitDefinition.field3296 != null) {
																	NPCDefinition.invalidateWidget(VarbitDefinition.field3296);
																}
															}

															if (VarbitDefinition.field3296 != null) {
																if (field796 < field797) {
																	++field796;
																	if (field796 == field797) {
																		NPCDefinition.invalidateWidget(VarbitDefinition.field3296);
																	}
																}
															} else if (field796 > 0) {
																--field796;
															}

															if (oculusOrbState == 0) {
																var4 = class192.localPlayer.x;
																var5 = class192.localPlayer.y;
																if (PendingSpawn.oculusOrbFocalPointX - var4 < -500 || PendingSpawn.oculusOrbFocalPointX - var4 > 500 || Skeleton.oculusOrbFocalPointY - var5 < -500 || Skeleton.oculusOrbFocalPointY - var5 > 500) {
																	PendingSpawn.oculusOrbFocalPointX = var4;
																	Skeleton.oculusOrbFocalPointY = var5;
																}

																if (var4 != PendingSpawn.oculusOrbFocalPointX) {
																	PendingSpawn.oculusOrbFocalPointX += (var4 - PendingSpawn.oculusOrbFocalPointX) / 16;
																}

																if (var5 != Skeleton.oculusOrbFocalPointY) {
																	Skeleton.oculusOrbFocalPointY += (var5 - Skeleton.oculusOrbFocalPointY) / 16;
																}

																var6 = PendingSpawn.oculusOrbFocalPointX >> 7;
																var7 = Skeleton.oculusOrbFocalPointY >> 7;
																var8 = WorldMapSectionType.getTileHeight(PendingSpawn.oculusOrbFocalPointX, Skeleton.oculusOrbFocalPointY, Clock.Client_plane);
																var9 = 0;
																if (var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
																	for (var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
																		for (var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
																			var12 = Clock.Client_plane;
																			if (var12 < 3 && (Tiles.Tiles_renderFlags[1][var10][var11] & 2) == 2) {
																				++var12;
																			}

																			var13 = var8 - Tiles.Tiles_heights[var12][var10][var11];
																			if (var13 > var9) {
																				var9 = var13;
																			}
																		}
																	}
																}

																var10 = var9 * 192;
																if (var10 > 98048) {
																	var10 = 98048;
																}

																if (var10 < 32768) {
																	var10 = 32768;
																}

																if (var10 > field818) {
																	field818 += (var10 - field818) / 24;
																} else if (var10 < field818) {
																	field818 += (var10 - field818) / 80;
																}

																WorldMapSectionType.field166 = WorldMapSectionType.getTileHeight(class192.localPlayer.x, class192.localPlayer.y, Clock.Client_plane) - camFollowHeight;
															} else if (oculusOrbState == 1) {
																PrivateChatMode.method5952();
																short var36 = -1;
																if (KeyHandler.KeyHandler_pressedKeys[33]) {
																	var36 = 0;
																} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
																	var36 = 1024;
																}

																if (KeyHandler.KeyHandler_pressedKeys[48]) {
																	if (var36 == 0) {
																		var36 = 1792;
																	} else if (var36 == 1024) {
																		var36 = 1280;
																	} else {
																		var36 = 1536;
																	}
																} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
																	if (var36 == 0) {
																		var36 = 256;
																	} else if (var36 == 1024) {
																		var36 = 768;
																	} else {
																		var36 = 512;
																	}
																}

																byte var37 = 0;
																if (KeyHandler.KeyHandler_pressedKeys[35]) {
																	var37 = -1;
																} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
																	var37 = 1;
																}

																var6 = 0;
																if (var36 >= 0 || var37 != 0) {
																	var6 = KeyHandler.KeyHandler_pressedKeys[81] ? oculusOrbSlowedSpeed : oculusOrbNormalSpeed;
																	var6 *= 16;
																	field723 = var36;
																	field724 = var37;
																}

																if (field647 < var6) {
																	field647 += var6 / 8;
																	if (field647 > var6) {
																		field647 = var6;
																	}
																} else if (field647 > var6) {
																	field647 = field647 * 9 / 10;
																}

																if (field647 > 0) {
																	var7 = field647 / 16;
																	if (field723 >= 0) {
																		var4 = field723 - FriendSystem.cameraYaw & 2047;
																		var8 = Rasterizer3D.Rasterizer3D_sine[var4];
																		var9 = Rasterizer3D.Rasterizer3D_cosine[var4];
																		PendingSpawn.oculusOrbFocalPointX += var8 * var7 / 65536;
																		Skeleton.oculusOrbFocalPointY += var9 * var7 / 65536;
																	}

																	if (field724 != 0) {
																		WorldMapSectionType.field166 += var7 * field724;
																		if (WorldMapSectionType.field166 > 0) {
																			WorldMapSectionType.field166 = 0;
																		}
																	}
																} else {
																	field723 = -1;
																	field724 = -1;
																}

																if (KeyHandler.KeyHandler_pressedKeys[13]) {
																	packetWriter.addNode(TilePaint.getPacketBufferNode(ClientPacket.field2274, packetWriter.isaacCipher));
																	oculusOrbState = 0;
																}
															}

															if (MouseHandler.MouseHandler_currentButton == 4 && ArchiveLoader.mouseCam) {
																var4 = MouseHandler.MouseHandler_y - mouseCamClickedY;
																camAngleDX = var4 * 2;
																mouseCamClickedY = var4 != -1 && var4 != 1 ? (mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y;
																var5 = mouseCamClickedX - MouseHandler.MouseHandler_x;
																camAngleDY = var5 * 2;
																mouseCamClickedX = var5 != -1 && var5 != 1 ? (mouseCamClickedX + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x;
															} else {
																if (KeyHandler.KeyHandler_pressedKeys[96]) {
																	camAngleDY += (-24 - camAngleDY) / 2;
																} else if (KeyHandler.KeyHandler_pressedKeys[97]) {
																	camAngleDY += (24 - camAngleDY) / 2;
																} else {
																	camAngleDY /= 2;
																}

																if (KeyHandler.KeyHandler_pressedKeys[98]) {
																	camAngleDX += (12 - camAngleDX) / 2;
																} else if (KeyHandler.KeyHandler_pressedKeys[99]) {
																	camAngleDX += (-12 - camAngleDX) / 2;
																} else {
																	camAngleDX /= 2;
																}

																mouseCamClickedY = MouseHandler.MouseHandler_y;
																mouseCamClickedX = MouseHandler.MouseHandler_x;
															}

															camAngleY = camAngleDY / 2 + camAngleY & 2047;
															camAngleX += camAngleDX / 2;
															if (camAngleX < 128) {
																camAngleX = 128;
															}

															if (camAngleX > 383) {
																camAngleX = 383;
															}

															if (isCameraLocked) {
																var4 = GrandExchangeOfferOwnWorldComparator.field640 * 16384 + 64;
																var5 = ReflectionCheck.field1319 * 16384 + 64;
																var6 = WorldMapSectionType.getTileHeight(var4, var5, Clock.Client_plane) - AbstractWorldMapIcon.field306;
																if (HitSplatDefinition.cameraX < var4) {
																	HitSplatDefinition.cameraX = (var4 - HitSplatDefinition.cameraX) * WorldMapElement.field3230 / 1000 + HitSplatDefinition.cameraX + FontName.field3660;
																	if (HitSplatDefinition.cameraX > var4) {
																		HitSplatDefinition.cameraX = var4;
																	}
																}

																if (HitSplatDefinition.cameraX > var4) {
																	HitSplatDefinition.cameraX -= WorldMapElement.field3230 * (HitSplatDefinition.cameraX - var4) / 1000 + FontName.field3660;
																	if (HitSplatDefinition.cameraX < var4) {
																		HitSplatDefinition.cameraX = var4;
																	}
																}

																if (class51.cameraY < var6) {
																	class51.cameraY = (var6 - class51.cameraY) * WorldMapElement.field3230 / 1000 + class51.cameraY + FontName.field3660;
																	if (class51.cameraY > var6) {
																		class51.cameraY = var6;
																	}
																}

																if (class51.cameraY > var6) {
																	class51.cameraY -= WorldMapElement.field3230 * (class51.cameraY - var6) / 1000 + FontName.field3660;
																	if (class51.cameraY < var6) {
																		class51.cameraY = var6;
																	}
																}

																if (Actor.cameraZ < var5) {
																	Actor.cameraZ = (var5 - Actor.cameraZ) * WorldMapElement.field3230 / 1000 + Actor.cameraZ + FontName.field3660;
																	if (Actor.cameraZ > var5) {
																		Actor.cameraZ = var5;
																	}
																}

																if (Actor.cameraZ > var5) {
																	Actor.cameraZ -= WorldMapElement.field3230 * (Actor.cameraZ - var5) / 1000 + FontName.field3660;
																	if (Actor.cameraZ < var5) {
																		Actor.cameraZ = var5;
																	}
																}

																var4 = class188.field2346 * 16384 + 64;
																var5 = WorldMapLabelSize.field139 * 128 + 64;
																var6 = WorldMapSectionType.getTileHeight(var4, var5, Clock.Client_plane) - PlayerAppearance.field2549;
																var7 = var4 - HitSplatDefinition.cameraX;
																var8 = var6 - class51.cameraY;
																var9 = var5 - Actor.cameraZ;
																var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
																var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
																var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
																if (var11 < 128) {
																	var11 = 128;
																}

																if (var11 > 383) {
																	var11 = 383;
																}

																if (GrandExchangeOffer.cameraPitch < var11) {
																	GrandExchangeOffer.cameraPitch = (var11 - GrandExchangeOffer.cameraPitch) * class51.field435 / 1000 + GrandExchangeOffer.cameraPitch + WorldMapSprite.field240;
																	if (GrandExchangeOffer.cameraPitch > var11) {
																		GrandExchangeOffer.cameraPitch = var11;
																	}
																}

																if (GrandExchangeOffer.cameraPitch > var11) {
																	GrandExchangeOffer.cameraPitch -= class51.field435 * (GrandExchangeOffer.cameraPitch - var11) / 1000 + WorldMapSprite.field240;
																	if (GrandExchangeOffer.cameraPitch < var11) {
																		GrandExchangeOffer.cameraPitch = var11;
																	}
																}

																var13 = var12 - FriendSystem.cameraYaw;
																if (var13 > 1024) {
																	var13 -= 2048;
																}

																if (var13 < -1024) {
																	var13 += 2048;
																}

																if (var13 > 0) {
																	FriendSystem.cameraYaw = FriendSystem.cameraYaw + WorldMapSprite.field240 + var13 * class51.field435 / 1000;
																	FriendSystem.cameraYaw &= 2047;
																}

																if (var13 < 0) {
																	FriendSystem.cameraYaw -= -var13 * class51.field435 / 1000 + WorldMapSprite.field240;
																	FriendSystem.cameraYaw &= 2047;
																}

																int var38 = var12 - FriendSystem.cameraYaw;
																if (var38 > 1024) {
																	var38 -= 2048;
																}

																if (var38 < -1024) {
																	var38 += 2048;
																}

																if (var38 < 0 && var13 > 0 || var38 > 0 && var13 < 0) {
																	FriendSystem.cameraYaw = var12;
																}
															}

															for (var4 = 0; var4 < 5; ++var4) {
																int var10003 = field895[var4]++;
															}

															class197.varcs.tryWrite();
															var4 = SpriteMask.method4038();
															var5 = FontName.method5401();
															if (var4 > 15000 && var5 > 15000) {
																logoutTimer = 250;
																MouseHandler.MouseHandler_idleCycles = 14500;
																var20 = TilePaint.getPacketBufferNode(ClientPacket.field2287, packetWriter.isaacCipher);
																packetWriter.addNode(var20);
															}

															KeyHandler.friendSystem.processFriendUpdates();
															++packetWriter.pendingWrites;
															if (packetWriter.pendingWrites > 50) {
																var20 = TilePaint.getPacketBufferNode(ClientPacket.field2247, packetWriter.isaacCipher);
																packetWriter.addNode(var20);
															}

															try {
																packetWriter.flush();
															} catch (IOException var23) {
																WorldMapIcon_1.method308();
															}

															return;
														}

														var19 = var18.widget;
														if (var19.childIndex < 0) {
															break;
														}

														var32 = Varps.getWidget(var19.parentId);
													} while(var32 == null || var32.children == null || var19.childIndex >= var32.children.length || var19 != var32.children[var19.childIndex]);

													class4.runScriptEvent(var18);
												}
											}

											var19 = var18.widget;
											if (var19.childIndex < 0) {
												break;
											}

											var32 = Varps.getWidget(var19.parentId);
										} while(var32 == null || var32.children == null || var19.childIndex >= var32.children.length || var19 != var32.children[var19.childIndex]);

										class4.runScriptEvent(var18);
									}
								}

								var19 = var18.widget;
								if (var19.childIndex < 0) {
									break;
								}

								var32 = Varps.getWidget(var19.parentId);
							} while(var32 == null || var32.children == null || var19.childIndex >= var32.children.length || var19 != var32.children[var19.childIndex]);

							class4.runScriptEvent(var18);
						}
					}

					WorldMapIcon_1.method308();
				}
			}
		}

	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	@Export("resizeJS")
	void resizeJS() {
		int var1 = Username.canvasWidth;
		int var2 = WorldMapData_1.canvasHeight;
		if (super.contentWidth < var1) {
			var1 = super.contentWidth;
		}

		if (super.contentHeight < var2) {
			var2 = super.contentHeight;
		}

		if (WorldMapSection2.clientPreferences != null) {
			try {
				Client var3 = Username.client;
				Object[] var4 = new Object[]{Friend.getWindowedMode()};
				JSObject.getWindow(var3).call("resize", var4);
			} catch (Throwable var5) {
			}
		}

	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1323665648"
	)
	@Export("drawLoggedIn")
	final void drawLoggedIn() {
		if (rootInterface != -1) {
			GrandExchangeOfferNameComparator.method150(rootInterface);
		}

		int var1;
		for (var1 = 0; var1 < rootWidgetCount; ++var1) {
			if (field851[var1]) {
				field852[var1] = true;
			}

			field853[var1] = field851[var1];
			field851[var1] = false;
		}

		field850 = cycle;
		viewportX = -1;
		viewportY = -1;
		FloorDecoration.field1604 = null;
		if (rootInterface != -1) {
			rootWidgetCount = 0;
			ServerPacket.drawWidgets(rootInterface, 0, 0, Username.canvasWidth, WorldMapData_1.canvasHeight, 0, 0, -1);
		}

		Rasterizer2D.Rasterizer2D_resetClip();
		if (showMouseCross) {
			if (mouseCrossColor == 1) {
				WorldMapData_0.crossSprites[mouseCrossState * 20 / 100].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}

			if (mouseCrossColor == 2) {
				WorldMapData_0.crossSprites[mouseCrossState * 20 / 100 + 4].drawTransBgAt(mouseCrossX - 8, mouseCrossY - 8);
			}
		}

		if (!isMenuOpen) {
			if (viewportX != -1) {
				Ignored.method5213(viewportX, viewportY);
			}
		} else {
			class4.method64();
		}

		if (gameDrawingMode == 3) {
			for (var1 = 0; var1 < rootWidgetCount; ++var1) {
				if (field853[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711935, 128);
				} else if (field852[var1]) {
					Rasterizer2D.Rasterizer2D_fillRectangleAlpha(rootWidgetXs[var1], rootWidgetYs[var1], rootWidgetWidths[var1], rootWidgetHeights[var1], 16711680, 128);
				}
			}
		}

		var1 = Clock.Client_plane;
		int var2 = class192.localPlayer.x;
		int var3 = class192.localPlayer.y;
		int var4 = field707;

		for (ObjectSound var5 = (ObjectSound)ObjectSound.objectSounds.last(); var5 != null; var5 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var5.soundEffectId != -1 || var5.soundEffectIds != null) {
				int var6 = 0;
				if (var2 > var5.field1069 * 16384) {
					var6 += var2 - var5.field1069 * 16384;
				} else if (var2 < var5.x * 16384) {
					var6 += var5.x * 16384 - var2;
				}

				if (var3 > var5.field1080 * 128) {
					var6 += var3 - var5.field1080 * 128;
				} else if (var3 < var5.y * 128) {
					var6 += var5.y * 128 - var3;
				}

				if (var6 - 64 <= var5.field1070 && areaSoundEffectVolume != 0 && var1 == var5.plane) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					int var7 = (var5.field1070 - var6) * areaSoundEffectVolume / var5.field1070;
					Object var8;
					if (var5.stream1 == null) {
						if (var5.soundEffectId >= 0) {
							var8 = null;
							SoundEffect var9 = SoundEffect.readSoundEffect(archive4, var5.soundEffectId, 0);
							if (var9 != null) {
								RawSound var10 = var9.toRawSound().resample(WorldMapSection1.decimator);
								RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var7);
								var11.setNumLoops(-1);
								class2.pcmStreamMixer.addSubStream(var11);
								var5.stream1 = var11;
							}
						}
					} else {
						var5.stream1.method2665(var7);
					}

					if (var5.stream2 == null) {
						if (var5.soundEffectIds != null && (var5.field1077 -= var4) <= 0) {
							int var13 = (int)(Math.random() * (double)var5.soundEffectIds.length);
							var8 = null;
							SoundEffect var14 = SoundEffect.readSoundEffect(archive4, var5.soundEffectIds[var13], 0);
							if (var14 != null) {
								RawSound var15 = var14.toRawSound().resample(WorldMapSection1.decimator);
								RawPcmStream var12 = RawPcmStream.createRawPcmStream(var15, 100, var7);
								var12.setNumLoops(0);
								class2.pcmStreamMixer.addSubStream(var12);
								var5.stream2 = var12;
								var5.field1077 = var5.field1074 + (int)(Math.random() * (double)(var5.field1075 - var5.field1074));
							}
						}
					} else {
						var5.stream2.method2665(var7);
						if (!var5.stream2.hasNext()) {
							var5.stream2 = null;
						}
					}
				} else {
					if (var5.stream1 != null) {
						class2.pcmStreamMixer.removeSubStream(var5.stream1);
						var5.stream1 = null;
					}

					if (var5.stream2 != null) {
						class2.pcmStreamMixer.removeSubStream(var5.stream2);
						var5.stream2 = null;
					}
				}
			}
		}

		field707 = 0;
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(Lci;I)Z",
		garbageValue = "1768904673"
	)
	final boolean method1363(PacketWriter var1) {
		AbstractSocket var2 = var1.getSocket();
		PacketBuffer var3 = var1.packetBuffer;
		if (var2 == null) {
			return false;
		} else {
			int var4;
			String var5;
			try {
				int var6;
				if (var1.serverPacket == null) {
					if (var1.field1301) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 0, 1);
						var1.field1299 = 0;
						var1.field1301 = false;
					}

					var3.offset = 0;
					if (var3.method5539()) {
						if (!var2.isAvailable(1)) {
							return false;
						}

						var2.read(var1.packetBuffer.array, 1, 1);
						var1.field1299 = 0;
					}

					var1.field1301 = true;
					ServerPacket[] var7 = Occluder.ServerPacket_values();
					var6 = var3.readSmartByteShortIsaac();
					if (var6 < 0 || var6 >= var7.length) {
						throw new IOException(var6 + " " + var3.offset);
					}

					var1.serverPacket = var7[var6];
					var1.serverPacketLength = var1.serverPacket.length;
				}

				if (var1.serverPacketLength == -1) {
					if (!var2.isAvailable(1)) {
						return false;
					}

					var1.getSocket().read(var3.array, 0, 1);
					var1.serverPacketLength = var3.array[0] & 255;
				}

				if (var1.serverPacketLength == -2) {
					if (!var2.isAvailable(2)) {
						return false;
					}

					var1.getSocket().read(var3.array, 0, 2);
					var3.offset = 0;
					var1.serverPacketLength = var3.readUnsignedShort();
				}

				if (!var2.isAvailable(var1.serverPacketLength)) {
					return false;
				}

				var3.offset = 0;
				var2.read(var3.array, 0, var1.serverPacketLength);
				var1.field1299 = 0;
				timer.method5044();
				var1.field1307 = var1.field1305;
				var1.field1305 = var1.field1309;
				var1.field1309 = var1.serverPacket;
				if (ServerPacket.field2116 == var1.serverPacket) {
					WorldMapLabel.loadRegions(false, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2118 == var1.serverPacket) {
					class30.logOut();
					var1.serverPacket = null;
					return false;
				}

				String var34;
				if (ServerPacket.field2200 == var1.serverPacket) {
					var34 = var3.readStringCp1252NullTerminated();
					var5 = AbstractFont.escapeBrackets(class40.method735(WallDecoration.method3356(var3)));
					ClientPreferences.addGameMessage(6, var34, var5);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2172 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2322);
					var1.serverPacket = null;
					return true;
				}

				int var8;
				if (ServerPacket.field2181 == var1.serverPacket) {
					for (var8 = 0; var8 < players.length; ++var8) {
						if (players[var8] != null) {
							players[var8].sequence = -1;
						}
					}

					for (var8 = 0; var8 < npcs.length; ++var8) {
						if (npcs[var8] != null) {
							npcs[var8].sequence = -1;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2185 == var1.serverPacket) {
					KeyHandler.friendSystem.ignoreList.read(var3, var1.serverPacketLength);
					class96.FriendSystem_invalidateIgnoreds();
					field839 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2145 == var1.serverPacket) {
					publicChatMode = var3.readUnsignedByte();
					tradeChatMode = var3.method5606();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2180 == var1.serverPacket) {
					var8 = var3.readUnsignedByte();
					if (var3.readUnsignedByte() == 0) {
						grandExchangeOffers[var8] = new GrandExchangeOffer();
						var3.offset += 18;
					} else {
						--var3.offset;
						grandExchangeOffers[var8] = new GrandExchangeOffer(var3, false);
					}

					field841 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2171 == var1.serverPacket) {
					var8 = var3.readInt();
					if (var8 != field727) {
						field727 = var8;
						WorldMapCacheName.method636();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2129 == var1.serverPacket) {
					var8 = var3.readUnsignedShort();
					if (var8 == 65535) {
						var8 = -1;
					}

					BufferedSink.playSong(var8);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2198 == var1.serverPacket) {
					var8 = var3.method5762();
					if (var8 == 65535) {
						var8 = -1;
					}

					var6 = var3.method5620();
					class49.playSoundJingle(var8, var6);
					var1.serverPacket = null;
					return true;
				}

				int var9;
				if (ServerPacket.field2166 == var1.serverPacket) {
					var8 = var3.readUnsignedByte();
					var6 = var3.readUnsignedByte();
					var4 = var3.readUnsignedByte();
					var9 = var3.readUnsignedByte();
					field775[var8] = true;
					field892[var8] = var6;
					field699[var8] = var4;
					field894[var8] = var9;
					field895[var8] = 0;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2125 == var1.serverPacket) {
					var8 = var3.method5614();
					var6 = var3.method5665();
					Varps.Varps_temp[var8] = var6;
					if (Varps.Varps_main[var8] != var6) {
						Varps.Varps_main[var8] = var6;
					}

					ServerPacket.changeGameOptions(var8);
					field832[++field833 - 1 & 31] = var8;
					var1.serverPacket = null;
					return true;
				}

				int var10;
				int var11;
				Widget var12;
				if (ServerPacket.field2150 == var1.serverPacket) {
					var8 = var3.readInt();
					var6 = var3.readUnsignedShort();
					if (var8 < -70000) {
						var6 += 32768;
					}

					if (var8 >= 0) {
						var12 = Varps.getWidget(var8);
					} else {
						var12 = null;
					}

					for (; var3.offset < var1.serverPacketLength; PlayerAppearance.itemContainerSetItem(var6, var9, var10 - 1, var11)) {
						var9 = var3.readUShortSmart();
						var10 = var3.readUnsignedShort();
						var11 = 0;
						if (var10 != 0) {
							var11 = var3.readUnsignedByte();
							if (var11 == 255) {
								var11 = var3.readInt();
							}
						}

						if (var12 != null && var9 >= 0 && var9 < var12.itemIds.length) {
							var12.itemIds[var9] = var10;
							var12.itemQuantities[var9] = var11;
						}
					}

					if (var12 != null) {
						NPCDefinition.invalidateWidget(var12);
					}

					BufferedSource.method5934();
					changedItemContainers[++field835 - 1 & 31] = var6 & 32767;
					var1.serverPacket = null;
					return true;
				}

				boolean var13;
				if (ServerPacket.field2173 == var1.serverPacket) {
					var8 = var3.readInt();
					var13 = var3.readUnsignedByte() == 1;
					var12 = Varps.getWidget(var8);
					if (var13 != var12.isHidden) {
						var12.isHidden = var13;
						NPCDefinition.invalidateWidget(var12);
					}

					var1.serverPacket = null;
					return true;
				}

				Widget var14;
				if (ServerPacket.field2161 == var1.serverPacket) {
					var8 = var3.method5626();
					var14 = Varps.getWidget(var8);

					for (var4 = 0; var4 < var14.itemIds.length; ++var4) {
						var14.itemIds[var4] = -1;
						var14.itemIds[var4] = 0;
					}

					NPCDefinition.invalidateWidget(var14);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2157 == var1.serverPacket) {
					KeyHandler.updateNpcs(false, var3);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2135 == var1.serverPacket) {
					if (InterfaceParent.clanChat != null) {
						InterfaceParent.clanChat.method5296(var3);
					}

					Players.method2189();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2159 == var1.serverPacket) {
					var8 = var3.method5625();
					var14 = Varps.getWidget(var8);
					var14.modelType = 3;
					var14.modelId = class192.localPlayer.appearance.getChatHeadId();
					NPCDefinition.invalidateWidget(var14);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2183 == var1.serverPacket) {
					FontName.field3663 = var3.readUnsignedByte();
					SecureRandomCallable.field531 = var3.method5605();

					for (var8 = SecureRandomCallable.field531; var8 < SecureRandomCallable.field531 + 8; ++var8) {
						for (var6 = FontName.field3663; var6 < FontName.field3663 + 8; ++var6) {
							if (groundItems[Clock.Client_plane][var8][var6] != null) {
								groundItems[Clock.Client_plane][var8][var6] = null;
								WorldMapEvent.updateItemPile(var8, var6);
							}
						}
					}

					for (PendingSpawn var39 = (PendingSpawn)pendingSpawns.last(); var39 != null; var39 = (PendingSpawn)pendingSpawns.previous()) {
						if (var39.x >= SecureRandomCallable.field531 && var39.x < SecureRandomCallable.field531 + 8 && var39.y >= FontName.field3663 && var39.y < FontName.field3663 + 8 && var39.plane == Clock.Client_plane) {
							var39.hitpoints = 0;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2139 == var1.serverPacket) {
					InterfaceParent.method1192(var3.readStringCp1252NullTerminated());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2178 == var1.serverPacket) {
					var8 = var3.method5740();
					rootInterface = var8;
					this.resizeRoot(false);
					class51.Widget_resetModelFrames(var8);
					WorldMapLabelSize.runWidgetOnLoadListener(rootInterface);

					for (var6 = 0; var6 < 100; ++var6) {
						field851[var6] = true;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2137 == var1.serverPacket) {
					for (var8 = 0; var8 < VarpDefinition.VarpDefinition_fileCount; ++var8) {
						VarpDefinition var37 = Messages.VarpDefinition_get(var8);
						if (var37 != null) {
							Varps.Varps_temp[var8] = 0;
							Varps.Varps_main[var8] = 0;
						}
					}

					BufferedSource.method5934();
					field833 += 32;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2123 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2319);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2144 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2327);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2153 == var1.serverPacket) {
					byte var36 = var3.method5609();
					var6 = var3.method5740();
					Varps.Varps_temp[var6] = var36;
					if (Varps.Varps_main[var6] != var36) {
						Varps.Varps_main[var6] = var36;
					}

					ServerPacket.changeGameOptions(var6);
					field832[++field833 - 1 & 31] = var6;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2192 == var1.serverPacket) {
					isCameraLocked = false;

					for (var8 = 0; var8 < 5; ++var8) {
						field775[var8] = false;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2146 == var1.serverPacket) {
					var34 = var3.readStringCp1252NullTerminated();
					Object[] var35 = new Object[var34.length() + 1];

					for (var4 = var34.length() - 1; var4 >= 0; --var4) {
						if (var34.charAt(var4) == 's') {
							var35[var4 + 1] = var3.readStringCp1252NullTerminated();
						} else {
							var35[var4 + 1] = new Integer(var3.readInt());
						}
					}

					var35[0] = new Integer(var3.readInt());
					ScriptEvent var38 = new ScriptEvent();
					var38.args = var35;
					class4.runScriptEvent(var38);
					var1.serverPacket = null;
					return true;
				}

				Widget var15;
				if (ServerPacket.field2133 == var1.serverPacket) {
					var8 = var3.readUnsignedShort();
					var6 = var3.method5740();
					var4 = var3.method5665();
					var15 = Varps.getWidget(var4);
					var15.field2696 = var8 + (var6 << 16);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2156 == var1.serverPacket) {
					var8 = var3.method5610();
					var6 = var3.method5722();
					var4 = var3.readInt();
					var15 = Varps.getWidget(var4);
					if (var8 != var15.rawX || var6 != var15.rawY || var15.xAlignment != 0 || var15.yAlignment != 0) {
						var15.rawX = var8;
						var15.rawY = var6;
						var15.xAlignment = 0;
						var15.yAlignment = 0;
						NPCDefinition.invalidateWidget(var15);
						this.alignWidget(var15);
						if (var15.type == 0) {
							WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var4 >> 16], var15, false);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				long var16;
				if (ServerPacket.field2121 == var1.serverPacket) {
					var8 = var3.method5625();
					var6 = var3.method5665();
					var4 = var3.method5762();
					if (var4 == 65535) {
						var4 = -1;
					}

					var9 = var3.method5740();
					if (var9 == 65535) {
						var9 = -1;
					}

					for (var10 = var4; var10 <= var9; ++var10) {
						var16 = ((long)var6 << 32) + (long)var10;
						Node var40 = widgetClickMasks.get(var16);
						if (var40 != null) {
							var40.remove();
						}

						widgetClickMasks.put(new IntegerNode(var8), var16);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2148 == var1.serverPacket) {
					KeyHandler.updateNpcs(true, var3);
					var1.serverPacket = null;
					return true;
				}

				int var18;
				if (ServerPacket.field2182 == var1.serverPacket) {
					var8 = var3.readInt();
					var6 = var3.readUnsignedShort();
					if (var8 < -70000) {
						var6 += 32768;
					}

					if (var8 >= 0) {
						var12 = Varps.getWidget(var8);
					} else {
						var12 = null;
					}

					if (var12 != null) {
						for (var9 = 0; var9 < var12.itemIds.length; ++var9) {
							var12.itemIds[var9] = 0;
							var12.itemQuantities[var9] = 0;
						}
					}

					WorldMapRectangle.clearItemContainer(var6);
					var9 = var3.readUnsignedShort();

					for (var10 = 0; var10 < var9; ++var10) {
						var11 = var3.method5740();
						var18 = var3.readUnsignedByte();
						if (var18 == 255) {
							var18 = var3.readInt();
						}

						if (var12 != null && var10 < var12.itemIds.length) {
							var12.itemIds[var10] = var11;
							var12.itemQuantities[var10] = var18;
						}

						PlayerAppearance.itemContainerSetItem(var6, var10, var11 - 1, var18);
					}

					if (var12 != null) {
						NPCDefinition.invalidateWidget(var12);
					}

					BufferedSource.method5934();
					changedItemContainers[++field835 - 1 & 31] = var6 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2147 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2315);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2175 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2316);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2154 == var1.serverPacket) {
					var8 = var3.method5740();
					var6 = var3.readInt();
					var4 = var8 >> 10 & 31;
					var9 = var8 >> 5 & 31;
					var10 = var8 & 31;
					var11 = (var9 << 11) + (var4 << 19) + (var10 << 3);
					Widget var43 = Varps.getWidget(var6);
					if (var11 != var43.color) {
						var43.color = var11;
						NPCDefinition.invalidateWidget(var43);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2170 == var1.serverPacket) {
					if (rootInterface != -1) {
						class226.runIntfCloseListeners(rootInterface, 0);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2169 == var1.serverPacket) {
					SecureRandomCallable.field531 = var3.method5771();
					FontName.field3663 = var3.method5605();

					while (var3.offset < var1.serverPacketLength) {
						var8 = var3.readUnsignedByte();
						class185 var42 = class83.method2107()[var8];
						GrandExchangeOfferWorldComparator.method77(var42);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2130 == var1.serverPacket) {
					isCameraLocked = true;
					class188.field2346 = var3.readUnsignedByte() * 128;
					WorldMapLabelSize.field139 = var3.readUnsignedByte() * 16384;
					PlayerAppearance.field2549 = var3.readUnsignedShort();
					WorldMapSprite.field240 = var3.readUnsignedByte();
					class51.field435 = var3.readUnsignedByte();
					if (class51.field435 >= 100) {
						var8 = class188.field2346 * 16384 + 64;
						var6 = WorldMapLabelSize.field139 * 128 + 64;
						var4 = WorldMapSectionType.getTileHeight(var8, var6, Clock.Client_plane) - PlayerAppearance.field2549;
						var9 = var8 - HitSplatDefinition.cameraX;
						var10 = var4 - class51.cameraY;
						var11 = var6 - Actor.cameraZ;
						var18 = (int)Math.sqrt((double)(var11 * var11 + var9 * var9));
						GrandExchangeOffer.cameraPitch = (int)(Math.atan2((double)var10, (double)var18) * 325.949D) & 2047;
						FriendSystem.cameraYaw = (int)(Math.atan2((double)var9, (double)var11) * -325.949D) & 2047;
						if (GrandExchangeOffer.cameraPitch < 128) {
							GrandExchangeOffer.cameraPitch = 128;
						}

						if (GrandExchangeOffer.cameraPitch > 383) {
							GrandExchangeOffer.cameraPitch = 383;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2199 == var1.serverPacket) {
					BufferedSource.method5934();
					var8 = var3.method5626();
					var6 = var3.readUnsignedByte();
					var4 = var3.method5605();
					experience[var6] = var8;
					currentLevels[var6] = var4;
					levels[var6] = 1;

					for (var9 = 0; var9 < 98; ++var9) {
						if (var8 >= Skills.Skills_experienceTable[var9]) {
							levels[var6] = var9 + 2;
						}
					}

					changedSkills[++changedSkillsCount - 1 & 31] = var6;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2167 == var1.serverPacket) {
					class13.readReflectionCheck(var3, var1.serverPacketLength);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2132 == var1.serverPacket) {
					if (var1.serverPacketLength == 0) {
						InterfaceParent.clanChat = null;
					} else {
						if (InterfaceParent.clanChat == null) {
							InterfaceParent.clanChat = new ClanChat(class192.loginType, Username.client);
						}

						InterfaceParent.clanChat.readUpdate(var3);
					}

					Players.method2189();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2138 == var1.serverPacket) {
					var8 = var3.method5762();
					class215.method4101(var8);
					changedItemContainers[++field835 - 1 & 31] = var8 & 32767;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2141 == var1.serverPacket) {
					var8 = var3.readInt();
					var6 = var3.readInt();
					var4 = GrandExchangeEvent.getGcDuration();
					PacketBufferNode var41 = TilePaint.getPacketBufferNode(ClientPacket.field2214, packetWriter.isaacCipher);
					var41.packetBuffer.method5602(GameShell.fps);
					var41.packetBuffer.writeByte(var4);
					var41.packetBuffer.method5624(var8);
					var41.packetBuffer.writeInt(var6);
					packetWriter.addNode(var41);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2128 == var1.serverPacket) {
					var8 = var3.method5614();
					var6 = var3.method5665();
					var12 = Varps.getWidget(var6);
					if (var12 != null && var12.type == 0) {
						if (var8 > var12.scrollHeight - var12.height) {
							var8 = var12.scrollHeight - var12.height;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						if (var8 != var12.scrollY) {
							var12.scrollY = var8;
							NPCDefinition.invalidateWidget(var12);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2158 == var1.serverPacket) {
					var8 = var3.method5610();
					var6 = var3.readInt();
					var12 = Varps.getWidget(var6);
					if (var8 != var12.sequenceId || var8 == -1) {
						var12.sequenceId = var8;
						var12.modelFrame = 0;
						var12.modelFrameCycle = 0;
						NPCDefinition.invalidateWidget(var12);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2195 == var1.serverPacket) {
					var8 = var3.readUnsignedShort();
					var6 = var3.readUnsignedByte();
					var4 = var3.readUnsignedShort();
					AbstractWorldMapIcon.queueSoundEffect(var8, var6, var4);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2163 == var1.serverPacket) {
					var8 = var3.readUnsignedByte();
					GrandExchangeOffer.method127(var8);
					var1.serverPacket = null;
					return true;
				}

				InterfaceParent var19;
				Widget var20;
				if (ServerPacket.field2174 == var1.serverPacket) {
					var8 = var3.method5625();
					var6 = var3.method5665();
					InterfaceParent var44 = (InterfaceParent)interfaceParents.get((long)var6);
					var19 = (InterfaceParent)interfaceParents.get((long)var8);
					if (var19 != null) {
						class185.closeInterface(var19, var44 == null || var44.group != var19.group);
					}

					if (var44 != null) {
						var44.remove();
						interfaceParents.put(var44, (long)var8);
					}

					var20 = Varps.getWidget(var6);
					if (var20 != null) {
						NPCDefinition.invalidateWidget(var20);
					}

					var20 = Varps.getWidget(var8);
					if (var20 != null) {
						NPCDefinition.invalidateWidget(var20);
						WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var20.id >>> 16], var20, true);
					}

					if (rootInterface != -1) {
						class226.runIntfCloseListeners(rootInterface, 1);
					}

					var1.serverPacket = null;
					return true;
				}

				boolean var21;
				if (ServerPacket.field2149 == var1.serverPacket) {
					var21 = var3.readUnsignedByte() == 1;
					if (var21) {
						class30.field274 = WorldMapIcon_0.currentTimeMillis() - var3.readLong();
						PendingSpawn.grandExchangeEvents = new GrandExchangeEvents(var3, true);
					} else {
						PendingSpawn.grandExchangeEvents = null;
					}

					field842 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2187 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2320);
					var1.serverPacket = null;
					return true;
				}

				long var22;
				long var24;
				int var30;
				boolean var50;
				String var51;
				if (ServerPacket.field2151 == var1.serverPacket) {
					var34 = var3.readStringCp1252NullTerminated();
					var22 = (long)var3.readUnsignedShort();
					var24 = (long)var3.readMedium();
					PlayerType var45 = (PlayerType)WorldMapSection0.findEnumerated(SecureRandomFuture.PlayerType_values(), var3.readUnsignedByte());
					long var27 = (var22 << 32) + var24;
					var50 = false;

					for (var30 = 0; var30 < 100; ++var30) {
						if (var27 == field865[var30]) {
							var50 = true;
							break;
						}
					}

					if (KeyHandler.friendSystem.isIgnored(new Username(var34, class192.loginType))) {
						var50 = true;
					}

					if (!var50 && field759 == 0) {
						field865[field715] = var27;
						field715 = (field715 + 1) % 100;
						var51 = AbstractFont.escapeBrackets(class40.method735(WallDecoration.method3356(var3)));
						byte var31;
						if (var45.isPrivileged) {
							var31 = 7;
						} else {
							var31 = 3;
						}

						if (var45.modIcon != -1) {
							ClientPreferences.addGameMessage(var31, Language.method3728(var45.modIcon) + var34, var51);
						} else {
							ClientPreferences.addGameMessage(var31, var34, var51);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2184 == var1.serverPacket) {
					isCameraLocked = true;
					GrandExchangeOfferOwnWorldComparator.field640 = var3.readUnsignedByte() * 128;
					ReflectionCheck.field1319 = var3.readUnsignedByte() * 128;
					AbstractWorldMapIcon.field306 = var3.readUnsignedShort();
					FontName.field3660 = var3.readUnsignedByte();
					WorldMapElement.field3230 = var3.readUnsignedByte();
					if (WorldMapElement.field3230 >= 100) {
						HitSplatDefinition.cameraX = GrandExchangeOfferOwnWorldComparator.field640 * 16384 + 64;
						Actor.cameraZ = ReflectionCheck.field1319 * 16384 + 64;
						class51.cameraY = WorldMapSectionType.getTileHeight(HitSplatDefinition.cameraX, Actor.cameraZ, Clock.Client_plane) - AbstractWorldMapIcon.field306;
					}

					var1.serverPacket = null;
					return true;
				}

				long var26;
				if (ServerPacket.field2142 == var1.serverPacket) {
					var34 = var3.readStringCp1252NullTerminated();
					var22 = var3.readLong();
					var24 = (long)var3.readUnsignedShort();
					var16 = (long)var3.readMedium();
					PlayerType var49 = (PlayerType)WorldMapSection0.findEnumerated(SecureRandomFuture.PlayerType_values(), var3.readUnsignedByte());
					var26 = var16 + (var24 << 32);
					var50 = false;

					for (var30 = 0; var30 < 100; ++var30) {
						if (field865[var30] == var26) {
							var50 = true;
							break;
						}
					}

					if (var49.isUser && KeyHandler.friendSystem.isIgnored(new Username(var34, class192.loginType))) {
						var50 = true;
					}

					if (!var50 && field759 == 0) {
						field865[field715] = var26;
						field715 = (field715 + 1) % 100;
						var51 = AbstractFont.escapeBrackets(class40.method735(WallDecoration.method3356(var3)));
						if (var49.modIcon != -1) {
							class173.addChatMessage(9, Language.method3728(var49.modIcon) + var34, var51, WorldMapArea.base37DecodeLong(var22));
						} else {
							class173.addChatMessage(9, var34, var51, WorldMapArea.base37DecodeLong(var22));
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2162 == var1.serverPacket) {
					var8 = var3.readInt();
					InterfaceParent var48 = (InterfaceParent)interfaceParents.get((long)var8);
					if (var48 != null) {
						class185.closeInterface(var48, true);
					}

					if (meslayerContinueWidget != null) {
						NPCDefinition.invalidateWidget(meslayerContinueWidget);
						meslayerContinueWidget = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2160 == var1.serverPacket) {
					WorldMapSectionType.privateChatMode = UserComparator9.method3461(var3.readUnsignedByte());
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2189 == var1.serverPacket) {
					FontName.field3663 = var3.method5606();
					SecureRandomCallable.field531 = var3.method5771();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2117 == var1.serverPacket) {
					World var47 = new World();
					var47.host = var3.readStringCp1252NullTerminated();
					var47.id = var3.readUnsignedShort();
					var6 = var3.readInt();
					var47.properties = var6;
					Projectile.updateGameState(45);
					var2.close();
					var2 = null;
					GrandExchangeEvents.changeWorld(var47);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2179 == var1.serverPacket) {
					var8 = var3.method5626();
					var6 = var3.method5762();
					var12 = Varps.getWidget(var8);
					if (var12.modelType != 1 || var6 != var12.modelId) {
						var12.modelType = 1;
						var12.modelId = var6;
						NPCDefinition.invalidateWidget(var12);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2165 == var1.serverPacket) {
					var8 = var3.method5625();
					var6 = var3.method5614();
					if (var6 == 65535) {
						var6 = -1;
					}

					var4 = var3.method5665();
					var15 = Varps.getWidget(var4);
					ItemDefinition var46;
					if (!var15.isIf3) {
						if (var6 == -1) {
							var15.modelType = 0;
							var1.serverPacket = null;
							return true;
						}

						var46 = HealthBarDefinition.ItemDefinition_get(var6);
						var15.modelType = 4;
						var15.modelId = var6;
						var15.modelAngleX = var46.xan2d;
						var15.modelAngleY = var46.yan2d;
						var15.modelZoom = var46.zoom2d * 100 / var8;
						NPCDefinition.invalidateWidget(var15);
					} else {
						var15.itemId = var6;
						var15.itemQuantity = var8;
						var46 = HealthBarDefinition.ItemDefinition_get(var6);
						var15.modelAngleX = var46.xan2d;
						var15.modelAngleY = var46.yan2d;
						var15.modelAngleZ = var46.zan2d;
						var15.modelOffsetX = var46.offsetX2d;
						var15.modelOffsetY = var46.offsetY2d;
						var15.modelZoom = var46.zoom2d;
						if (var46.isStackable == 1) {
							var15.itemQuantityMode = 1;
						} else {
							var15.itemQuantityMode = 2;
						}

						if (var15.field2627 > 0) {
							var15.modelZoom = var15.modelZoom * 32 / var15.field2627;
						} else if (var15.rawWidth > 0) {
							var15.modelZoom = var15.modelZoom * 32 / var15.rawWidth;
						}

						NPCDefinition.invalidateWidget(var15);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2186 == var1.serverPacket) {
					destinationX = var3.readUnsignedByte();
					if (destinationX == 255) {
						destinationX = 0;
					}

					destinationY = var3.readUnsignedByte();
					if (destinationY == 255) {
						destinationY = 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2152 == var1.serverPacket) {
					var21 = var3.readBoolean();
					if (var21) {
						if (class218.field2716 == null) {
							class218.field2716 = new class238();
						}
					} else {
						class218.field2716 = null;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2143 == var1.serverPacket) {
					var8 = var3.method5614();
					var6 = var3.method5606();
					var4 = var3.method5625();
					var19 = (InterfaceParent)interfaceParents.get((long)var4);
					if (var19 != null) {
						class185.closeInterface(var19, var8 != var19.group);
					}

					class287.method5327(var4, var8, var6);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2119 == var1.serverPacket) {
					rebootTimer = var3.method5762() * 30;
					field795 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2134 == var1.serverPacket) {
					BufferedSource.method5934();
					runEnergy = var3.readUnsignedByte();
					field795 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2115 == var1.serverPacket) {
					AttackOption.updatePlayers(var3, var1.serverPacketLength);
					ObjectSound.method1934();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2188 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2323);
					var1.serverPacket = null;
					return true;
				}

				String var28;
				if (ServerPacket.field2140 == var1.serverPacket) {
					byte[] var53 = new byte[var1.serverPacketLength];
					var3.method5525(var53, 0, var53.length);
					Buffer var52 = new Buffer(var53);
					var28 = var52.readStringCp1252NullTerminated();
					class215.openURL(var28, true, false);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2155 == var1.serverPacket) {
					var8 = var3.readUShortSmart();
					var13 = var3.readUnsignedByte() == 1;
					var28 = "";
					var50 = false;
					if (var13) {
						var28 = var3.readStringCp1252NullTerminated();
						if (KeyHandler.friendSystem.isIgnored(new Username(var28, class192.loginType))) {
							var50 = true;
						}
					}

					var51 = var3.readStringCp1252NullTerminated();
					if (!var50) {
						ClientPreferences.addGameMessage(var8, var28, var51);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2168 == var1.serverPacket) {
					var8 = var3.readUnsignedByte();
					class13.forceDisconnect(var8);
					var1.serverPacket = null;
					return false;
				}

				if (ServerPacket.field2197 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2317);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2190 == var1.serverPacket) {
					minimapState = var3.readUnsignedByte();
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2194 == var1.serverPacket) {
					var8 = var3.method5740();
					var6 = var3.method5740();
					var4 = var3.method5625();
					var9 = var3.method5614();
					var20 = Varps.getWidget(var4);
					if (var6 != var20.modelAngleX || var9 != var20.modelAngleY || var8 != var20.modelZoom) {
						var20.modelAngleX = var6;
						var20.modelAngleY = var9;
						var20.modelZoom = var8;
						NPCDefinition.invalidateWidget(var20);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2193 == var1.serverPacket) {
					KeyHandler.friendSystem.method1858();
					field839 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2176 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2314);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2124 == var1.serverPacket) {
					KeyHandler.friendSystem.readUpdate(var3, var1.serverPacketLength);
					field839 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2127 == var1.serverPacket) {
					hintArrowType = var3.readUnsignedByte();
					if (hintArrowType == 1) {
						hintArrowNpcIndex = var3.readUnsignedShort();
					}

					if (hintArrowType >= 2 && hintArrowType <= 6) {
						if (hintArrowType == 2) {
							hintArrowSubX = 4096;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 3) {
							hintArrowSubX = 0;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 4) {
							hintArrowSubX = 8192;
							hintArrowSubY = 64;
						}

						if (hintArrowType == 5) {
							hintArrowSubX = 4096;
							hintArrowSubY = 0;
						}

						if (hintArrowType == 6) {
							hintArrowSubX = 4096;
							hintArrowSubY = 128;
						}

						hintArrowType = 2;
						hintArrowX = var3.readUnsignedShort();
						hintArrowY = var3.readUnsignedShort();
						hintArrowHeight = var3.readUnsignedByte() * 4;
					}

					if (hintArrowType == 10) {
						hintArrowPlayerIndex = var3.readUnsignedShort();
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2122 == var1.serverPacket) {
					var34 = var3.readStringCp1252NullTerminated();
					var6 = var3.method5606();
					var4 = var3.method5605();
					if (var4 >= 1 && var4 <= 8) {
						if (var34.equalsIgnoreCase("null")) {
							var34 = null;
						}

						playerMenuActions[var4 - 1] = var34;
						playerOptionsPriorities[var4 - 1] = var6 == 0;
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2136 == var1.serverPacket) {
					var3.offset += 28;
					if (var3.checkCrc()) {
						UrlRequester.method3373(var3, var3.offset - 28);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2164 == var1.serverPacket) {
					GrandExchangeOfferWorldComparator.method77(class185.field2318);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2191 == var1.serverPacket) {
					var8 = var3.method5740();
					var6 = var3.method5665();
					var12 = Varps.getWidget(var6);
					if (var12.modelType != 2 || var8 != var12.modelId) {
						var12.modelType = 2;
						var12.modelId = var8;
						NPCDefinition.invalidateWidget(var12);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2177 == var1.serverPacket) {
					var34 = var3.readStringCp1252NullTerminated();
					var6 = var3.method5665();
					var12 = Varps.getWidget(var6);
					if (!var34.equals(var12.text)) {
						var12.text = var34;
						NPCDefinition.invalidateWidget(var12);
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2126 == var1.serverPacket) {
					var8 = var3.offset + var1.serverPacketLength;
					var6 = var3.readUnsignedShort();
					var4 = var3.readUnsignedShort();
					if (var6 != rootInterface) {
						rootInterface = var6;
						this.resizeRoot(false);
						class51.Widget_resetModelFrames(rootInterface);
						WorldMapLabelSize.runWidgetOnLoadListener(rootInterface);

						for (var9 = 0; var9 < 100; ++var9) {
							field851[var9] = true;
						}
					}

					InterfaceParent var29;
					for (; var4-- > 0; var29.field568 = true) {
						var9 = var3.readInt();
						var10 = var3.readUnsignedShort();
						var11 = var3.readUnsignedByte();
						var29 = (InterfaceParent)interfaceParents.get((long)var9);
						if (var29 != null && var10 != var29.group) {
							class185.closeInterface(var29, true);
							var29 = null;
						}

						if (var29 == null) {
							var29 = class287.method5327(var9, var10, var11);
						}
					}

					for (var19 = (InterfaceParent)interfaceParents.first(); var19 != null; var19 = (InterfaceParent)interfaceParents.next()) {
						if (var19.field568) {
							var19.field568 = false;
						} else {
							class185.closeInterface(var19, true);
						}
					}

					widgetClickMasks = new NodeHashTable(512);

					while (var3.offset < var8) {
						var9 = var3.readInt();
						var10 = var3.readUnsignedShort();
						var11 = var3.readUnsignedShort();
						var18 = var3.readInt();

						for (var30 = var10; var30 <= var11; ++var30) {
							var26 = ((long)var9 << 32) + (long)var30;
							widgetClickMasks.put(new IntegerNode(var18), var26);
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2131 == var1.serverPacket) {
					WorldMapLabel.loadRegions(true, var1.packetBuffer);
					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2196 == var1.serverPacket) {
					for (var8 = 0; var8 < Varps.Varps_main.length; ++var8) {
						if (Varps.Varps_main[var8] != Varps.Varps_temp[var8]) {
							Varps.Varps_main[var8] = Varps.Varps_temp[var8];
							ServerPacket.changeGameOptions(var8);
							field832[++field833 - 1 & 31] = var8;
						}
					}

					var1.serverPacket = null;
					return true;
				}

				if (ServerPacket.field2120 == var1.serverPacket) {
					BufferedSource.method5934();
					weight = var3.readShort();
					field795 = cycleCntr;
					var1.serverPacket = null;
					return true;
				}

				class225.RunException_sendStackTrace("" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1305 != null ? var1.field1305.id : -1) + "," + (var1.field1307 != null ? var1.field1307.id : -1) + "," + var1.serverPacketLength, (Throwable)null);
				class30.logOut();
			} catch (IOException var32) {
				WorldMapIcon_1.method308();
			} catch (Exception var33) {
				var5 = "" + (var1.serverPacket != null ? var1.serverPacket.id : -1) + "," + (var1.field1305 != null ? var1.field1305.id : -1) + "," + (var1.field1307 != null ? var1.field1307.id : -1) + "," + var1.serverPacketLength + "," + (class192.localPlayer.pathX[0] + Messages.baseX * 64) + "," + (class192.localPlayer.pathY[0] + Language.baseY * 64) + ",";

				for (var4 = 0; var4 < var1.serverPacketLength && var4 < 50; ++var4) {
					var5 = var5 + var3.array[var4] + ",";
				}

				class225.RunException_sendStackTrace(var5, var33);
				class30.logOut();
			}

			return true;
		}
	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1020734975"
	)
	@Export("menu")
	final void menu() {
		class60.method1186();
		if (class185.dragInventoryWidget == null && clickedWidget == null) {
			int var1;
			int var2;
			int var3;
			label229: {
				int var4 = MouseHandler.MouseHandler_lastButton;
				int var5;
				int var6;
				int var7;
				if (isMenuOpen) {
					int var15;
					int var17;
					if (var4 != 1 && (ArchiveLoader.mouseCam || var4 != 4)) {
						var1 = MouseHandler.MouseHandler_x;
						var15 = MouseHandler.MouseHandler_y;
						if (var1 < ArchiveDiskAction.menuX - 10 || var1 > ArchiveDiskAction.menuX + InterfaceParent.menuWidth + 10 || var15 < SecureRandomCallable.menuY - 10 || var15 > Message.menuHeight + SecureRandomCallable.menuY + 10) {
							isMenuOpen = false;
							var5 = ArchiveDiskAction.menuX;
							var2 = SecureRandomCallable.menuY;
							var3 = InterfaceParent.menuWidth;
							var6 = Message.menuHeight;

							for (var17 = 0; var17 < rootWidgetCount; ++var17) {
								if (rootWidgetXs[var17] + rootWidgetWidths[var17] > var5 && rootWidgetXs[var17] < var3 + var5 && rootWidgetHeights[var17] + rootWidgetYs[var17] > var2 && rootWidgetYs[var17] < var2 + var6) {
									field851[var17] = true;
								}
							}
						}
					}

					if (var4 == 1 || !ArchiveLoader.mouseCam && var4 == 4) {
						var1 = ArchiveDiskAction.menuX;
						var15 = SecureRandomCallable.menuY;
						var5 = InterfaceParent.menuWidth;
						var2 = MouseHandler.MouseHandler_lastPressedX;
						var3 = MouseHandler.MouseHandler_lastPressedY;
						var6 = -1;

						for (var17 = 0; var17 < menuOptionsCount; ++var17) {
							var7 = var15 + (menuOptionsCount - 1 - var17) * 15 + 31;
							if (var2 > var1 && var2 < var5 + var1 && var3 > var7 - 13 && var3 < var7 + 3) {
								var6 = var17;
							}
						}

						int var11;
						int var18;
						if (var6 != -1 && var6 >= 0) {
							var17 = menuArguments1[var6];
							var7 = menuArguments2[var6];
							var18 = menuOpcodes[var6];
							var11 = menuIdentifiers[var6];
							String var12 = menuActions[var6];
							String var13 = menuTargets[var6];
							UserComparator10.menuAction(var17, var7, var18, var11, var12, var13, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
						}

						isMenuOpen = false;
						var17 = ArchiveDiskAction.menuX;
						var7 = SecureRandomCallable.menuY;
						var18 = InterfaceParent.menuWidth;
						var11 = Message.menuHeight;

						for (int var19 = 0; var19 < rootWidgetCount; ++var19) {
							if (rootWidgetXs[var19] + rootWidgetWidths[var19] > var17 && rootWidgetXs[var19] < var18 + var17 && rootWidgetHeights[var19] + rootWidgetYs[var19] > var7 && rootWidgetYs[var19] < var11 + var7) {
								field851[var19] = true;
							}
						}
					}
				} else {
					var1 = menuOptionsCount - 1;
					if ((var4 == 1 || !ArchiveLoader.mouseCam && var4 == 4) && var1 >= 0) {
						var5 = menuOpcodes[var1];
						if (var5 == 39 || var5 == 40 || var5 == 41 || var5 == 42 || var5 == 43 || var5 == 33 || var5 == 34 || var5 == 35 || var5 == 36 || var5 == 37 || var5 == 38 || var5 == 1005) {
							var2 = menuArguments1[var1];
							var3 = menuArguments2[var1];
							Widget var8 = Varps.getWidget(var3);
							var7 = WorldMapIcon_0.getWidgetClickMask(var8);
							boolean var9 = (var7 >> 28 & 1) != 0;
							if (var9) {
								break label229;
							}

							Object var10 = null;
							if (FriendLoginUpdate.method5326(WorldMapIcon_0.getWidgetClickMask(var8))) {
								break label229;
							}
						}
					}

					if ((var4 == 1 || !ArchiveLoader.mouseCam && var4 == 4) && this.shouldLeftClickOpenMenu()) {
						var4 = 2;
					}

					if ((var4 == 1 || !ArchiveLoader.mouseCam && var4 == 4) && menuOptionsCount > 0 && var1 >= 0) {
						var5 = menuArguments1[var1];
						var2 = menuArguments2[var1];
						var3 = menuOpcodes[var1];
						var6 = menuIdentifiers[var1];
						String var14 = menuActions[var1];
						String var16 = menuTargets[var1];
						UserComparator10.menuAction(var5, var2, var3, var6, var14, var16, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}

					if (var4 == 2 && menuOptionsCount > 0) {
						this.openMenu(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
					}
				}

				return;
			}

			if (class185.dragInventoryWidget != null && !field757 && menuOptionsCount > 0 && !this.shouldLeftClickOpenMenu()) {
				GrandExchangeOfferTotalQuantityComparator.method105(draggedWidgetX, draggedWidgetY);
			}

			field757 = false;
			itemDragDuration = 0;
			if (class185.dragInventoryWidget != null) {
				NPCDefinition.invalidateWidget(class185.dragInventoryWidget);
			}

			class185.dragInventoryWidget = Varps.getWidget(var3);
			dragItemSlotSource = var2;
			draggedWidgetX = MouseHandler.MouseHandler_lastPressedX;
			draggedWidgetY = MouseHandler.MouseHandler_lastPressedY;
			if (var1 >= 0) {
				WorldMapRegion.tempMenuAction = new MenuAction();
				WorldMapRegion.tempMenuAction.param0 = menuArguments1[var1];
				WorldMapRegion.tempMenuAction.param1 = menuArguments2[var1];
				WorldMapRegion.tempMenuAction.opcode = menuOpcodes[var1];
				WorldMapRegion.tempMenuAction.identifier = menuIdentifiers[var1];
				WorldMapRegion.tempMenuAction.action = menuActions[var1];
			}

			NPCDefinition.invalidateWidget(class185.dragInventoryWidget);
		}

	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2097265219"
	)
	@Export("shouldLeftClickOpenMenu")
	final boolean shouldLeftClickOpenMenu() {
		int var1 = menuOptionsCount - 1;
		return (leftClickOpensMenu == 1 && menuOptionsCount > 2 || UrlRequest.method3383(var1)) && !menuShiftClick[var1];
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-53"
	)
	@Export("openMenu")
	final void openMenu(int var1, int var2) {
		int var3 = class1.fontBold12.stringWidth("Choose Option");

		int var4;
		int var5;
		for (var4 = 0; var4 < menuOptionsCount; ++var4) {
			var5 = class1.fontBold12.stringWidth(VerticalAlignment.method4426(var4));
			if (var5 > var3) {
				var3 = var5;
			}
		}

		var3 += 8;
		var4 = menuOptionsCount * 15 + 22;
		var5 = var1 - var3 / 2;
		if (var5 + var3 > Username.canvasWidth) {
			var5 = Username.canvasWidth - var3;
		}

		if (var5 < 0) {
			var5 = 0;
		}

		int var6 = var2;
		if (var4 + var2 > WorldMapData_1.canvasHeight) {
			var6 = WorldMapData_1.canvasHeight - var4;
		}

		if (var6 < 0) {
			var6 = 0;
		}

		ArchiveDiskAction.menuX = var5;
		SecureRandomCallable.menuY = var6;
		InterfaceParent.menuWidth = var3;
		Message.menuHeight = menuOptionsCount * 15 + 22;
		ServerBuild.scene.menuOpen(Clock.Client_plane, var1, var2, false);
		isMenuOpen = true;
	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(ZS)V",
		garbageValue = "32113"
	)
	@Export("resizeRoot")
	final void resizeRoot(boolean var1) {
		GrandExchangeOfferUnitPriceComparator.method135(rootInterface, Username.canvasWidth, WorldMapData_1.canvasHeight, var1);
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(Lhn;I)V",
		garbageValue = "-1172183202"
	)
	@Export("alignWidget")
	void alignWidget(Widget var1) {
		Widget var2 = var1.parentId == -1 ? null : Varps.getWidget(var1.parentId);
		int var3;
		int var4;
		if (var2 == null) {
			var3 = Username.canvasWidth;
			var4 = WorldMapData_1.canvasHeight;
		} else {
			var3 = var2.width;
			var4 = var2.height;
		}

		UrlRequester.alignWidgetSize(var1, var3, var4, false);
		InterfaceParent.alignWidgetPosition(var1, var3, var4);
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "75"
	)
	final void method1541() {
		NPCDefinition.invalidateWidget(clickedWidget);
		++SequenceDefinition.widgetDragDuration;
		if (field827 && field824) {
			int var1 = MouseHandler.MouseHandler_x;
			int var2 = MouseHandler.MouseHandler_y;
			var1 -= widgetClickX;
			var2 -= widgetClickY;
			if (var1 < field919) {
				var1 = field919;
			}

			if (var1 + clickedWidget.width > field919 + clickedWidgetParent.width) {
				var1 = field919 + clickedWidgetParent.width - clickedWidget.width;
			}

			if (var2 < field826) {
				var2 = field826;
			}

			if (var2 + clickedWidget.height > field826 + clickedWidgetParent.height) {
				var2 = field826 + clickedWidgetParent.height - clickedWidget.height;
			}

			int var3 = var1 - field864;
			int var4 = var2 - field829;
			int var5 = clickedWidget.dragZoneSize;
			if (SequenceDefinition.widgetDragDuration > clickedWidget.dragThreshold && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
				isDraggingWidget = true;
			}

			int var6 = var1 - field919 + clickedWidgetParent.scrollX;
			int var7 = var2 - field826 + clickedWidgetParent.scrollY;
			ScriptEvent var8;
			if (clickedWidget.onDrag != null && isDraggingWidget) {
				var8 = new ScriptEvent();
				var8.widget = clickedWidget;
				var8.mouseX = var6;
				var8.mouseY = var7;
				var8.args = clickedWidget.onDrag;
				class4.runScriptEvent(var8);
			}

			if (MouseHandler.MouseHandler_currentButton == 0) {
				if (isDraggingWidget) {
					if (clickedWidget.onDragComplete != null) {
						var8 = new ScriptEvent();
						var8.widget = clickedWidget;
						var8.mouseX = var6;
						var8.mouseY = var7;
						var8.dragTarget = draggedOnWidget;
						var8.args = clickedWidget.onDragComplete;
						class4.runScriptEvent(var8);
					}

					if (draggedOnWidget != null && ItemContainer.method1184(clickedWidget) != null) {
						PacketBufferNode var9 = TilePaint.getPacketBufferNode(ClientPacket.field2242, packetWriter.isaacCipher);
						var9.packetBuffer.writeIntME(draggedOnWidget.childIndex);
						var9.packetBuffer.method5787(clickedWidget.itemId);
						var9.packetBuffer.method5622(clickedWidget.id);
						var9.packetBuffer.method5622(draggedOnWidget.id);
						var9.packetBuffer.writeShortLE(draggedOnWidget.itemId);
						var9.packetBuffer.writeShortLE(clickedWidget.childIndex);
						packetWriter.addNode(var9);
					}
				} else if (this.shouldLeftClickOpenMenu()) {
					this.openMenu(field864 + widgetClickX, widgetClickY + field829);
				} else if (menuOptionsCount > 0) {
					GrandExchangeOfferTotalQuantityComparator.method105(widgetClickX + field864, field829 + widgetClickY);
				}

				clickedWidget = null;
			}
		} else if (SequenceDefinition.widgetDragDuration > 1) {
			clickedWidget = null;
		}

	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(I)Ljz;",
		garbageValue = "2135870107"
	)
	@Export("username")
	public Username username() {
		return class192.localPlayer != null ? class192.localPlayer.username : null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lgl;I)I",
		garbageValue = "505977953"
	)
	@Export("compareStrings")
	public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
		int var3 = var0.length();
		int var4 = var1.length();
		int var5 = 0;
		int var6 = 0;
		byte var7 = 0;
		byte var8 = 0;

		while (var5 - var7 < var3 || var6 - var8 < var4) {
			if (var5 - var7 >= var3) {
				return -1;
			}

			if (var6 - var8 >= var4) {
				return 1;
			}

			char var9;
			if (var7 != 0) {
				var9 = (char)var7;
				boolean var10 = false;
			} else {
				var9 = var0.charAt(var5++);
			}

			char var14;
			if (var8 != 0) {
				var14 = (char)var8;
				boolean var11 = false;
			} else {
				var14 = var1.charAt(var6++);
			}

			byte var16;
			if (var9 == 198) {
				var16 = 69;
			} else if (var9 == 230) {
				var16 = 101;
			} else if (var9 == 223) {
				var16 = 115;
			} else if (var9 == 338) {
				var16 = 69;
			} else if (var9 == 339) {
				var16 = 101;
			} else {
				var16 = 0;
			}

			var7 = var16;
			byte var12;
			if (var14 == 198) {
				var12 = 69;
			} else if (var14 == 230) {
				var12 = 101;
			} else if (var14 == 223) {
				var12 = 115;
			} else if (var14 == 338) {
				var12 = 69;
			} else if (var14 == 339) {
				var12 = 101;
			} else {
				var12 = 0;
			}

			var8 = var12;
			var9 = FloorUnderlayDefinition.standardizeChar(var9, var2);
			var14 = FloorUnderlayDefinition.standardizeChar(var14, var2);
			if (var9 != var14 && Character.toUpperCase(var9) != Character.toUpperCase(var14)) {
				var9 = Character.toLowerCase(var9);
				var14 = Character.toLowerCase(var14);
				if (var9 != var14) {
					return class42.lowercaseChar(var9, var2) - class42.lowercaseChar(var14, var2);
				}
			}
		}

		int var15 = Math.min(var3, var4);

		int var17;
		char var18;
		for (var17 = 0; var17 < var15; ++var17) {
			if (var2 == Language.Language_FR) {
				var5 = var3 - 1 - var17;
				var6 = var4 - 1 - var17;
			} else {
				var6 = var17;
				var5 = var17;
			}

			char var19 = var0.charAt(var5);
			var18 = var1.charAt(var6);
			if (var18 != var19 && Character.toUpperCase(var19) != Character.toUpperCase(var18)) {
				var19 = Character.toLowerCase(var19);
				var18 = Character.toLowerCase(var18);
				if (var19 != var18) {
					return class42.lowercaseChar(var19, var2) - class42.lowercaseChar(var18, var2);
				}
			}
		}

		var17 = var3 - var4;
		if (var17 != 0) {
			return var17;
		} else {
			for (int var20 = 0; var20 < var15; ++var20) {
				var18 = var0.charAt(var20);
				char var13 = var1.charAt(var20);
				if (var13 != var18) {
					return class42.lowercaseChar(var18, var2) - class42.lowercaseChar(var13, var2);
				}
			}

			return 0;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)Lfu;",
		garbageValue = "4"
	)
	public static Clock method1432() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}

	static {
		field922 = true;
		worldId = 1;
		worldProperties = 0;
		gameBuild = 0;
		isMembersWorld = false;
		isLowDetail = false;
		clientType = -1;
		onMobile = false;
		gameState = 0;
		isLoading = true;
		cycle = 0;
		mouseLastLastPressedTimeMillis = -1L;
		field657 = -1;
		field912 = -1;
		field745 = -1L;
		hadFocus = true;
		displayFps = false;
		rebootTimer = 0;
		hintArrowType = 0;
		hintArrowNpcIndex = 0;
		hintArrowPlayerIndex = 0;
		hintArrowX = 0;
		hintArrowY = 0;
		hintArrowHeight = 0;
		hintArrowSubX = 0;
		hintArrowSubY = 0;
		playerAttackOption = AttackOption.AttackOption_hidden;
		npcAttackOption = AttackOption.AttackOption_hidden;
		titleLoadingStage = 0;
		js5ConnectState = 0;
		field675 = 0;
		js5Errors = 0;
		loginState = 0;
		field679 = 0;
		field680 = 0;
		field681 = 0;
		field682 = class160.field1993;
		Login_isUsernameRemembered = false;
		secureRandomFuture = new SecureRandomFuture();
		randomDatData = null;
		npcs = new NPC[32768];
		npcCount = 0;
		npcIndices = new int[32768];
		field690 = 0;
		field867 = new int[250];
		packetWriter = new PacketWriter();
		logoutTimer = 0;
		field800 = false;
		useBufferedSocket = true;
		timer = new Timer();
		fontsMap = new HashMap();
		field791 = 0;
		field884 = 1;
		field700 = 0;
		field733 = 1;
		field695 = 0;
		collisionMaps = new CollisionMap[4];
		isInInstance = false;
		instanceChunkTemplates = new int[4][13][13];
		field743 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
		field707 = 0;
		field870 = 2301979;
		field709 = 5063219;
		field710 = 3353893;
		field711 = 7759444;
		field712 = false;
		alternativeScrollbarWidth = 0;
		camAngleX = 128;
		camAngleY = 0;
		camAngleDY = 0;
		camAngleDX = 0;
		mouseCamClickedX = 0;
		mouseCamClickedY = 0;
		oculusOrbState = 0;
		camFollowHeight = 50;
		field647 = 0;
		field723 = 0;
		field724 = 0;
		oculusOrbNormalSpeed = 12;
		oculusOrbSlowedSpeed = 6;
		field727 = 0;
		field728 = false;
		field729 = 0;
		field730 = false;
		field818 = 0;
		overheadTextCount = 0;
		overheadTextLimit = 50;
		overheadTextXs = new int[overheadTextLimit];
		overheadTextYs = new int[overheadTextLimit];
		overheadTextAscents = new int[overheadTextLimit];
		overheadTextXOffsets = new int[overheadTextLimit];
		overheadTextColors = new int[overheadTextLimit];
		overheadTextEffects = new int[overheadTextLimit];
		overheadTextCyclesRemaining = new int[overheadTextLimit];
		overheadText = new String[overheadTextLimit];
		tileLastDrawnActor = new int[104][104];
		viewportDrawCount = 0;
		viewportTempX = -1;
		viewportTempY = -1;
		mouseCrossX = 0;
		mouseCrossY = 0;
		mouseCrossState = 0;
		mouseCrossColor = 0;
		showMouseCross = true;
		field751 = 0;
		field752 = 0;
		dragItemSlotSource = 0;
		draggedWidgetX = 0;
		draggedWidgetY = 0;
		dragItemSlotDestination = 0;
		field757 = false;
		itemDragDuration = 0;
		field759 = 0;
		showLoadingMessages = true;
		players = new Player[2048];
		localPlayerIndex = -1;
		field763 = 0;
		renderSelf = true;
		drawPlayerNames = 0;
		field766 = 0;
		field828 = new int[1000];
		playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
		playerMenuActions = new String[8];
		playerOptionsPriorities = new boolean[8];
		defaultRotations = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
		combatTargetPlayerIndex = -1;
		groundItems = new NodeDeque[4][104][104];
		pendingSpawns = new NodeDeque();
		projectiles = new NodeDeque();
		graphicsObjects = new NodeDeque();
		currentLevels = new int[25];
		levels = new int[25];
		experience = new int[25];
		leftClickOpensMenu = 0;
		isMenuOpen = false;
		menuOptionsCount = 0;
		menuArguments1 = new int[500];
		menuArguments2 = new int[500];
		menuOpcodes = new int[500];
		menuIdentifiers = new int[500];
		menuActions = new String[500];
		menuTargets = new String[500];
		menuShiftClick = new boolean[500];
		followerOpsLowPriority = false;
		shiftClickDrop = false;
		tapToDrop = false;
		showMouseOverText = true;
		viewportX = -1;
		viewportY = -1;
		field796 = 0;
		field797 = 50;
		isItemSelected = 0;
		selectedItemName = null;
		isSpellSelected = false;
		selectedSpellChildIndex = -1;
		field802 = -1;
		selectedSpellActionName = null;
		selectedSpellName = null;
		rootInterface = -1;
		interfaceParents = new NodeHashTable(8);
		field808 = 0;
		field664 = -1;
		chatEffects = 0;
		field811 = 0;
		meslayerContinueWidget = null;
		runEnergy = 0;
		weight = 0;
		staffModLevel = 0;
		followerIndex = -1;
		playerMod = false;
		viewportWidget = null;
		clickedWidget = null;
		clickedWidgetParent = null;
		widgetClickX = 0;
		widgetClickY = 0;
		draggedOnWidget = null;
		field824 = false;
		field919 = -1;
		field826 = -1;
		field827 = false;
		field864 = -1;
		field829 = -1;
		isDraggingWidget = false;
		cycleCntr = 1;
		field832 = new int[32];
		field833 = 0;
		changedItemContainers = new int[32];
		field835 = 0;
		changedSkills = new int[32];
		changedSkillsCount = 0;
		chatCycle = 0;
		field839 = 0;
		field823 = 0;
		field841 = 0;
		field842 = 0;
		field795 = 0;
		mouseWheelRotation = 0;
		scriptEvents = new NodeDeque();
		field846 = new NodeDeque();
		field847 = new NodeDeque();
		widgetClickMasks = new NodeHashTable(512);
		rootWidgetCount = 0;
		field850 = -2;
		field851 = new boolean[100];
		field852 = new boolean[100];
		field853 = new boolean[100];
		rootWidgetXs = new int[100];
		rootWidgetYs = new int[100];
		rootWidgetWidths = new int[100];
		rootWidgetHeights = new int[100];
		gameDrawingMode = 0;
		field859 = 0L;
		isResizable = true;
		field861 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
		publicChatMode = 0;
		tradeChatMode = 0;
		field780 = "";
		field865 = new long[100];
		field715 = 0;
		field762 = 0;
		field868 = new int[128];
		field869 = new int[128];
		field702 = -1L;
		field704 = -1;
		mapIconCount = 0;
		mapIconXs = new int[1000];
		mapIconYs = new int[1000];
		mapIcons = new Sprite[1000];
		destinationX = 0;
		destinationY = 0;
		minimapState = 0;
		musicVolume = 255;
		currentTrackGroupId = -1;
		field881 = false;
		soundEffectVolume = 127;
		areaSoundEffectVolume = 127;
		soundEffectCount = 0;
		soundEffectIds = new int[50];
		queuedSoundEffectLoops = new int[50];
		queuedSoundEffectDelays = new int[50];
		soundLocations = new int[50];
		soundEffects = new SoundEffect[50];
		isCameraLocked = false;
		field775 = new boolean[5];
		field892 = new int[5];
		field699 = new int[5];
		field894 = new int[5];
		field895 = new int[5];
		field908 = 256;
		field897 = 205;
		zoomHeight = 256;
		zoomWidth = 320;
		field900 = 1;
		field673 = 32767;
		field819 = 1;
		field903 = 32767;
		viewportOffsetX = 0;
		viewportOffsetY = 0;
		viewportWidth = 0;
		viewportHeight = 0;
		viewportZoom = 0;
		playerAppearance = new PlayerAppearance();
		field910 = -1;
		field911 = -1;
		platformInfoProvider = new DesktopPlatformInfoProvider();
		grandExchangeOffers = new GrandExchangeOffer[8];
		GrandExchangeEvents_worldComparator = new GrandExchangeOfferOwnWorldComparator();
		field888 = -1;
		archiveLoaders = new ArrayList(10);
		archiveLoadersDone = 0;
		field813 = 0;
		field809 = new class65();
		field920 = new int[50];
		field921 = new int[50];
	}
}
