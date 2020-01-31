import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class225 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
		garbageValue = "1575191798"
	)
	@Export("RunException_sendStackTrace")
	public static void RunException_sendStackTrace(String var0, Throwable var1) {
		if (var1 != null) {
			var1.printStackTrace();
		} else {
			try {
				String var2 = "";
				if (var1 != null) {
					var2 = Bounds.method6058(var1);
				}

				if (var0 != null) {
					if (var1 != null) {
						var2 = var2 + " | ";
					}

					var2 = var2 + var0;
				}

				System.out.println("Error: " + var2);
				var2 = var2.replace(':', '.');
				var2 = var2.replace('@', '_');
				var2 = var2.replace('&', '_');
				var2 = var2.replace('#', '_');
				if (RunException.RunException_applet == null) {
					return;
				}

				URL var3 = new URL(RunException.RunException_applet.getCodeBase(), "clienterror.ws?c=" + GZipDecompressor.RunException_revision + "&u=" + RunException.localPlayerName + "&v1=" + TaskHandler.javaVendor + "&v2=" + class216.javaVersion + "&ct=" + RunException.clientType + "&e=" + var2);
				DataInputStream var4 = new DataInputStream(var3.openStream());
				var4.read();
				var4.close();
			} catch (Exception var5) {
			}
		}

	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "48"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			ServerBuild.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			WorldMapRectangle.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			GrandExchangeEvent.archive0 = class51.newArchive(0, false, true, true);
			class65.archive1 = class51.newArchive(1, false, true, true);
			GrandExchangeOfferWorldComparator.archive2 = class51.newArchive(2, true, false, true);
			class267.archive3 = class51.newArchive(3, false, true, true);
			Client.archive4 = class51.newArchive(4, false, true, true);
			NetSocket.archive5 = class51.newArchive(5, true, true, true);
			MouseHandler.archive6 = class51.newArchive(6, true, true, true);
			BuddyRankComparator.archive7 = class51.newArchive(7, false, true, true);
			UserComparator8.archive8 = class51.newArchive(8, false, true, true);
			GrandExchangeOfferNameComparator.archive9 = class51.newArchive(9, false, true, true);
			HealthBar.archive10 = class51.newArchive(10, false, true, true);
			GrandExchangeOffer.archive11 = class51.newArchive(11, false, true, true);
			MilliClock.archive12 = class51.newArchive(12, false, true, true);
			MouseHandler.archive13 = class51.newArchive(13, true, false, true);
			class189.archive14 = class51.newArchive(14, false, true, true);
			WorldMapSection1.archive15 = class51.newArchive(15, false, true, true);
			Client.archive17 = class51.newArchive(17, true, true, true);
			UserComparator2.archive18 = class51.newArchive(18, false, true, true);
			Clock.archive19 = class51.newArchive(19, false, true, true);
			SecureRandomCallable.archive20 = class51.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var1 = 0;
			var0 = var1 + GrandExchangeEvent.archive0.percentage() * 4 / 100;
			var0 += class65.archive1.percentage() * 4 / 100;
			var0 += GrandExchangeOfferWorldComparator.archive2.percentage() * 2 / 100;
			var0 += class267.archive3.percentage() * 2 / 100;
			var0 += Client.archive4.percentage() * 6 / 100;
			var0 += NetSocket.archive5.percentage() * 4 / 100;
			var0 += MouseHandler.archive6.percentage() * 2 / 100;
			var0 += BuddyRankComparator.archive7.percentage() * 56 / 100;
			var0 += UserComparator8.archive8.percentage() * 2 / 100;
			var0 += GrandExchangeOfferNameComparator.archive9.percentage() * 2 / 100;
			var0 += HealthBar.archive10.percentage() * 2 / 100;
			var0 += GrandExchangeOffer.archive11.percentage() * 2 / 100;
			var0 += MilliClock.archive12.percentage() * 2 / 100;
			var0 += MouseHandler.archive13.percentage() * 2 / 100;
			var0 += class189.archive14.percentage() * 2 / 100;
			var0 += WorldMapSection1.archive15.percentage() * 2 / 100;
			var0 += Clock.archive19.percentage() / 100;
			var0 += UserComparator2.archive18.percentage() / 100;
			var0 += SecureRandomCallable.archive20.percentage() / 100;
			var0 += Client.archive17.method4372() && Client.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				WorldMapLabel.method438(GrandExchangeEvent.archive0, "Animations");
				WorldMapLabel.method438(class65.archive1, "Skeletons");
				WorldMapLabel.method438(Client.archive4, "Sound FX");
				WorldMapLabel.method438(NetSocket.archive5, "Maps");
				WorldMapLabel.method438(MouseHandler.archive6, "Music Tracks");
				WorldMapLabel.method438(BuddyRankComparator.archive7, "Models");
				WorldMapLabel.method438(UserComparator8.archive8, "Sprites");
				WorldMapLabel.method438(GrandExchangeOffer.archive11, "Music Jingles");
				WorldMapLabel.method438(class189.archive14, "Music Samples");
				WorldMapLabel.method438(WorldMapSection1.archive15, "Music Patches");
				WorldMapLabel.method438(Clock.archive19, "World Map");
				WorldMapLabel.method438(UserComparator2.archive18, "World Map Geography");
				WorldMapLabel.method438(SecureRandomCallable.archive20, "World Map Ground");
				class222.spriteIds = new GraphicsDefaults();
				class222.spriteIds.decode(Client.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			class14.method173(22050, !Client.isLowDetail, 2);
			MidiPcmStream var28 = new MidiPcmStream();
			var28.method3819(9, 128);
			WorldMapLabelSize.pcmPlayer0 = AbstractWorldMapIcon.method627(GameShell.taskHandler, 0, 22050);
			WorldMapLabelSize.pcmPlayer0.setStream(var28);
			MouseRecorder.method1208(WorldMapSection1.archive15, class189.archive14, Client.archive4, var28);
			class43.pcmPlayer1 = AbstractWorldMapIcon.method627(GameShell.taskHandler, 1, 2048);
			class2.pcmStreamMixer = new PcmStreamMixer();
			class43.pcmPlayer1.setStream(class2.pcmStreamMixer);
			WorldMapSection1.decimator = new Decimator(22050, PcmPlayer.field1398);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			NetSocket.WorldMapElement_fonts = new Fonts(UserComparator8.archive8, MouseHandler.archive13);
		} else {
			int var29;
			if (Client.titleLoadingStage == 50) {
				FontName[] var2 = new FontName[]{FontName.FontName_plain12, FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_plain11};
				var29 = var2.length;
				Fonts var3 = NetSocket.WorldMapElement_fonts;
				FontName[] var4 = new FontName[]{FontName.FontName_plain12, FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_plain11};
				Client.fontsMap = var3.createMap(var4);
				if (Client.fontsMap.size() < var29) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var29 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					WorldMapData_0.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					class13.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					class1.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					NetSocket.platformInfo = Client.platformInfoProvider.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else {
				Archive var30;
				int var31;
				Archive var32;
				if (Client.titleLoadingStage == 60) {
					var32 = HealthBar.archive10;
					var30 = UserComparator8.archive8;
					var31 = 0;
					if (var32.tryLoadFileByNames("title.jpg", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("logo", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("logo_deadman_mode", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("logo_seasonal_mode", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("titlebox", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("titlebutton", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("runes", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("title_mute", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("options_radio_buttons,0", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("options_radio_buttons,2", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("options_radio_buttons,4", "")) {
						++var31;
					}

					if (var30.tryLoadFileByNames("options_radio_buttons,6", "")) {
						++var31;
					}

					var30.tryLoadFileByNames("sl_back", "");
					var30.tryLoadFileByNames("sl_flags", "");
					var30.tryLoadFileByNames("sl_arrows", "");
					var30.tryLoadFileByNames("sl_stars", "");
					var30.tryLoadFileByNames("sl_button", "");
					byte var5 = 12;
					if (var31 < var5) {
						Login.Login_loadingText = "Loading title screen - " + var31 * 100 / var5 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						Projectile.updateGameState(5);
						Client.titleLoadingStage = 70;
					}
				} else if (Client.titleLoadingStage == 70) {
					if (!GrandExchangeOfferWorldComparator.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + GrandExchangeOfferWorldComparator.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var33 = GrandExchangeOfferWorldComparator.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var33;
						class83.method2109(GrandExchangeOfferWorldComparator.archive2);
						var32 = GrandExchangeOfferWorldComparator.archive2;
						var30 = BuddyRankComparator.archive7;
						KitDefinition.KitDefinition_archive = var32;
						KitDefinition.KitDefinition_modelsArchive = var30;
						CollisionMap.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
						Archive var6 = GrandExchangeOfferWorldComparator.archive2;
						Archive var7 = BuddyRankComparator.archive7;
						boolean var8 = Client.isLowDetail;
						ObjectDefinition.ObjectDefinition_archive = var6;
						ObjectDefinition.ObjectDefinition_modelsArchive = var7;
						ObjectDefinition.ObjectDefinition_isLowDetail = var8;
						Archive var9 = GrandExchangeOfferWorldComparator.archive2;
						Archive var10 = BuddyRankComparator.archive7;
						NPCDefinition.NpcDefinition_archive = var9;
						NPCDefinition.NpcDefinition_modelArchive = var10;
						GraphicsObject.method2063(GrandExchangeOfferWorldComparator.archive2);
						Archive var11 = GrandExchangeOfferWorldComparator.archive2;
						Archive var12 = BuddyRankComparator.archive7;
						boolean var13 = Client.isMembersWorld;
						Font var14 = WorldMapData_0.fontPlain11;
						ItemDefinition.ItemDefinition_archive = var11;
						ItemDefinition.ItemDefinition_modelArchive = var12;
						class298.ItemDefinition_inMembersWorld = var13;
						ItemDefinition.ItemDefinition_fileCount = ItemDefinition.ItemDefinition_archive.getGroupFileCount(10);
						ItemDefinition.ItemDefinition_fontPlain11 = var14;
						TilePaint.method3149(GrandExchangeOfferWorldComparator.archive2, GrandExchangeEvent.archive0, class65.archive1);
						Archive var15 = GrandExchangeOfferWorldComparator.archive2;
						Archive var16 = BuddyRankComparator.archive7;
						SpotAnimationDefinition.SpotAnimationDefinition_archive = var15;
						ArchiveDiskActionHandler.SpotAnimationDefinition_modelArchive = var16;
						Archive var17 = GrandExchangeOfferWorldComparator.archive2;
						class287.VarbitDefinition_archive = var17;
						Archive var18 = GrandExchangeOfferWorldComparator.archive2;
						VarpDefinition.VarpDefinition_archive = var18;
						VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
						SoundSystem.method2562(class267.archive3, BuddyRankComparator.archive7, UserComparator8.archive8, MouseHandler.archive13);
						Archive var19 = GrandExchangeOfferWorldComparator.archive2;
						InvDefinition.InvDefinition_archive = var19;
						Archive var20 = GrandExchangeOfferWorldComparator.archive2;
						GrandExchangeOfferAgeComparator.EnumDefinition_archive = var20;
						Archive var21 = GrandExchangeOfferWorldComparator.archive2;
						VarcInt.VarcInt_archive = var21;
						Archive var22 = GrandExchangeOfferWorldComparator.archive2;
						ParamDefinition.ParamDefinition_archive = var22;
						class197.varcs = new Varcs();
						Archive var23 = GrandExchangeOfferWorldComparator.archive2;
						Archive var24 = UserComparator8.archive8;
						Archive var25 = MouseHandler.archive13;
						class49.HitSplatDefinition_archive = var23;
						HitSplatDefinition.field3329 = var24;
						HitSplatDefinition.HitSplatDefinition_fontsArchive = var25;
						Archive var26 = GrandExchangeOfferWorldComparator.archive2;
						Archive var27 = UserComparator8.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var26;
						HealthBarDefinition.HitSplatDefinition_spritesArchive = var27;
						Varcs.method2212(GrandExchangeOfferWorldComparator.archive2, UserComparator8.archive8);
						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (Entity.compass == null) {
						Entity.compass = WorldMapSection1.SpriteBuffer_getSprite(UserComparator8.archive8, class222.spriteIds.compass, 0);
					} else {
						++var0;
					}

					if (ArchiveLoader.redHintArrowSprite == null) {
						ArchiveLoader.redHintArrowSprite = WorldMapSection1.SpriteBuffer_getSprite(UserComparator8.archive8, class222.spriteIds.field3796, 0);
					} else {
						++var0;
					}

					IndexedSprite var34;
					IndexedSprite[] var35;
					IndexedSprite[] var37;
					int var38;
					if (VertexNormal.mapSceneSprites != null) {
						++var0;
					} else {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.mapScenes;
						if (!class228.method4199(var30, var31, 0)) {
							var35 = null;
						} else {
							var37 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

							for (var38 = 0; var38 < class326.SpriteBuffer_spriteCount; ++var38) {
								var34 = var37[var38] = new IndexedSprite();
								var34.width = GZipDecompressor.SpriteBuffer_spriteWidth;
								var34.height = class326.SpriteBuffer_spriteHeight;
								var34.xOffset = Huffman.SpriteBuffer_xOffsets[var38];
								var34.yOffset = NPC.SpriteBuffer_yOffsets[var38];
								var34.subWidth = class326.SpriteBuffer_spriteWidths[var38];
								var34.subHeight = class326.SpriteBuffer_spriteHeights[var38];
								var34.palette = class326.SpriteBuffer_spritePalette;
								var34.pixels = class326.SpriteBuffer_pixels[var38];
							}

							DynamicObject.method2292();
							var35 = var37;
						}

						VertexNormal.mapSceneSprites = var35;
					}

					Sprite[] var39;
					if (Ignored.headIconPkSprites == null) {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.headIconsPk;
						if (!class228.method4199(var30, var31, 0)) {
							var39 = null;
						} else {
							var39 = HorizontalAlignment.method4783();
						}

						Ignored.headIconPkSprites = var39;
					} else {
						++var0;
					}

					if (class40.headIconPrayerSprites == null) {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3799;
						if (!class228.method4199(var30, var31, 0)) {
							var39 = null;
						} else {
							var39 = HorizontalAlignment.method4783();
						}

						class40.headIconPrayerSprites = var39;
					} else {
						++var0;
					}

					if (SecureRandomCallable.headIconHintSprites == null) {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3800;
						if (!class228.method4199(var30, var31, 0)) {
							var39 = null;
						} else {
							var39 = HorizontalAlignment.method4783();
						}

						SecureRandomCallable.headIconHintSprites = var39;
					} else {
						++var0;
					}

					if (StructDefinition.mapMarkerSprites == null) {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3803;
						if (!class228.method4199(var30, var31, 0)) {
							var39 = null;
						} else {
							var39 = HorizontalAlignment.method4783();
						}

						StructDefinition.mapMarkerSprites = var39;
					} else {
						++var0;
					}

					if (WorldMapData_0.crossSprites == null) {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3802;
						if (!class228.method4199(var30, var31, 0)) {
							var39 = null;
						} else {
							var39 = HorizontalAlignment.method4783();
						}

						WorldMapData_0.crossSprites = var39;
					} else {
						++var0;
					}

					if (AbstractWorldMapData.mapDotSprites == null) {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3805;
						if (!class228.method4199(var30, var31, 0)) {
							var39 = null;
						} else {
							var39 = HorizontalAlignment.method4783();
						}

						AbstractWorldMapData.mapDotSprites = var39;
					} else {
						++var0;
					}

					if (class192.scrollBarSprites != null) {
						++var0;
					} else {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3804;
						if (!class228.method4199(var30, var31, 0)) {
							var35 = null;
						} else {
							var37 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

							for (var38 = 0; var38 < class326.SpriteBuffer_spriteCount; ++var38) {
								var34 = var37[var38] = new IndexedSprite();
								var34.width = GZipDecompressor.SpriteBuffer_spriteWidth;
								var34.height = class326.SpriteBuffer_spriteHeight;
								var34.xOffset = Huffman.SpriteBuffer_xOffsets[var38];
								var34.yOffset = NPC.SpriteBuffer_yOffsets[var38];
								var34.subWidth = class326.SpriteBuffer_spriteWidths[var38];
								var34.subHeight = class326.SpriteBuffer_spriteHeights[var38];
								var34.palette = class326.SpriteBuffer_spritePalette;
								var34.pixels = class326.SpriteBuffer_pixels[var38];
							}

							DynamicObject.method2292();
							var35 = var37;
						}

						class192.scrollBarSprites = var35;
					}

					if (InterfaceParent.modIconSprites != null) {
						++var0;
					} else {
						var30 = UserComparator8.archive8;
						var31 = class222.spriteIds.field3795;
						if (!class228.method4199(var30, var31, 0)) {
							var35 = null;
						} else {
							var37 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

							for (var38 = 0; var38 < class326.SpriteBuffer_spriteCount; ++var38) {
								var34 = var37[var38] = new IndexedSprite();
								var34.width = GZipDecompressor.SpriteBuffer_spriteWidth;
								var34.height = class326.SpriteBuffer_spriteHeight;
								var34.xOffset = Huffman.SpriteBuffer_xOffsets[var38];
								var34.yOffset = NPC.SpriteBuffer_yOffsets[var38];
								var34.subWidth = class326.SpriteBuffer_spriteWidths[var38];
								var34.subHeight = class326.SpriteBuffer_spriteHeights[var38];
								var34.palette = class326.SpriteBuffer_spritePalette;
								var34.pixels = class326.SpriteBuffer_pixels[var38];
							}

							DynamicObject.method2292();
							var35 = var37;
						}

						InterfaceParent.modIconSprites = var35;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = InterfaceParent.modIconSprites;
						ArchiveLoader.redHintArrowSprite.normalize();
						var29 = (int)(Math.random() * 21.0D) - 10;
						int var40 = (int)(Math.random() * 21.0D) - 10;
						var31 = (int)(Math.random() * 21.0D) - 10;
						int var41 = (int)(Math.random() * 41.0D) - 20;
						VertexNormal.mapSceneSprites[0].shiftColors(var29 + var41, var41 + var40, var31 + var41);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!GrandExchangeOfferNameComparator.archive9.isFullyLoaded()) {
						Login.Login_loadingText = "Loading textures - 0%";
						Login.Login_loadingPercent = 90;
					} else {
						Language.textureProvider = new TextureProvider(GrandExchangeOfferNameComparator.archive9, UserComparator8.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.Rasterizer3D_setTextureLoader(Language.textureProvider);
						Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = Language.textureProvider.getLoadedPercentage();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					class16.mouseRecorder = new MouseRecorder();
					GameShell.taskHandler.newThreadTask(class16.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!HealthBar.archive10.tryLoadFileByNames("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - 0%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var36 = new Huffman(HealthBar.archive10.takeFileByNames("huffman", ""));
						TilePaint.method3150(var36);
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!class267.archive3.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + class267.archive3.loadPercent() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!MilliClock.archive12.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + MilliClock.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!MouseHandler.archive13.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + MouseHandler.archive13.loadPercent() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!Clock.archive19.tryLoadGroupByName(WorldMapCacheName.field313.name)) {
						Login.Login_loadingText = "Loading world map - " + Clock.archive19.groupLoadPercentByName(WorldMapCacheName.field313.name) / 10 + "%";
					} else {
						if (WorldMapIcon_0.worldMap == null) {
							WorldMapIcon_0.worldMap = new WorldMap();
							WorldMapIcon_0.worldMap.init(Clock.archive19, UserComparator2.archive18, SecureRandomCallable.archive20, class1.fontBold12, Client.fontsMap, VertexNormal.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					Projectile.updateGameState(10);
				}
			}
		}

	}
}
