import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("qx")
	@ObfuscatedSignature(
		signature = "Ldj;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive15")
	static Archive archive15;
	@ObfuscatedName("ek")
	static int[] field295;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1032814753
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 161851669
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1056408349
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1194427309
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -27645919
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -290110331
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "37"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-96920779"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "911083222"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1927273541"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;IIB)Llt;",
		garbageValue = "-81"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		return !class228.method4199(var0, var1, var2) ? null : PendingSpawn.method1738();
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-301044323"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		GrandExchangeOfferUnitPriceComparator.method141();
		if (Client.renderSelf) {
			class51.addPlayerToScene(class192.localPlayer, false);
		}

		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class51.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		ItemContainer.addNpcsToScene(true);
		WorldMapData_1.method733();
		ItemContainer.addNpcsToScene(false);

		int var4;
		for (Projectile var5 = (Projectile)Client.projectiles.last(); var5 != null; var5 = (Projectile)Client.projectiles.previous()) {
			if (var5.plane == Clock.Client_plane && Client.cycle <= var5.cycleEnd) {
				if (Client.cycle >= var5.cycleStart) {
					if (var5.targetIndex > 0) {
						NPC var6 = Client.npcs[var5.targetIndex - 1];
						if (var6 != null && var6.x >= 0 && var6.x < 13312 && var6.y >= 0 && var6.y < 13312) {
							var5.setDestination(var6.x, var6.y, WorldMapSectionType.getTileHeight(var6.x, var6.y, var5.plane) - var5.endHeight, Client.cycle);
						}
					}

					if (var5.targetIndex < 0) {
						var4 = -var5.targetIndex - 1;
						Player var20;
						if (var4 == Client.localPlayerIndex) {
							var20 = class192.localPlayer;
						} else {
							var20 = Client.players[var4];
						}

						if (var20 != null && var20.x >= 0 && var20.x < 13312 && var20.y >= 0 && var20.y < 13312) {
							var5.setDestination(var20.x, var20.y, WorldMapSectionType.getTileHeight(var20.x, var20.y, var5.plane) - var5.endHeight, Client.cycle);
						}
					}

					var5.advance(Client.field707);
					ServerBuild.scene.drawEntity(Clock.Client_plane, (int)var5.x, (int)var5.y, (int)var5.z, 60, var5, var5.yaw, -1L, false);
				}
			} else {
				var5.remove();
			}
		}

		Tiles.method1156();
		GrandExchangeOfferUnitPriceComparator.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var19;
		int var21;
		if (!Client.isCameraLocked) {
			var13 = Client.camAngleX;
			if (Client.field818 / 256 > var13) {
				var13 = Client.field818 / 256;
			}

			if (Client.field775[4] && Client.field699[4] + 128 > var13) {
				var13 = Client.field699[4] + 128;
			}

			var19 = Client.camAngleY & 2047;
			var4 = PendingSpawn.oculusOrbFocalPointX;
			var21 = WorldMapSectionType.field166;
			var7 = Skeleton.oculusOrbFocalPointY;
			var8 = var13 * 3 + 600;
			var9 = Canvas.method864(var8, var3);
			var10 = 2048 - var13 & 2047;
			var11 = 2048 - var19 & 2047;
			int var14 = 0;
			var12 = 0;
			int var15 = var9;
			int var16;
			int var17;
			int var18;
			if (var10 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var10];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var10];
				var18 = var17 * var12 - var9 * var16 >> 16;
				var15 = var16 * var12 + var17 * var9 >> 16;
				var12 = var18;
			}

			if (var11 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var11];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var18 = var17 * var14 + var15 * var16 >> 16;
				var15 = var15 * var17 - var14 * var16 >> 16;
				var14 = var18;
			}

			HitSplatDefinition.cameraX = var4 - var14;
			class51.cameraY = var21 - var12;
			Actor.cameraZ = var7 - var15;
			GrandExchangeOffer.cameraPitch = var13;
			FriendSystem.cameraYaw = var19;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (PendingSpawn.oculusOrbFocalPointX >> 7 != class192.localPlayer.x >> 7 || Skeleton.oculusOrbFocalPointY >> 7 != class192.localPlayer.y >> 7)) {
				var16 = class192.localPlayer.plane;
				var17 = Messages.baseX * 64 + (PendingSpawn.oculusOrbFocalPointX >> 7);
				var18 = Language.baseY * 64 + (Skeleton.oculusOrbFocalPointY >> 7);
				WorldMapRegion.method563(var17, var18, var16, true);
			}
		}

		if (!Client.isCameraLocked) {
			var13 = class96.method2346();
		} else {
			if (WorldMapSection2.clientPreferences.roofsHidden) {
				var19 = Clock.Client_plane;
			} else {
				var4 = WorldMapSectionType.getTileHeight(HitSplatDefinition.cameraX, Actor.cameraZ, Clock.Client_plane);
				if (var4 - class51.cameraY < 800 && (Tiles.Tiles_renderFlags[Clock.Client_plane][HitSplatDefinition.cameraX >> 7][Actor.cameraZ >> 7] & 4) != 0) {
					var19 = Clock.Client_plane;
				} else {
					var19 = 3;
				}
			}

			var13 = var19;
		}

		var19 = HitSplatDefinition.cameraX;
		var4 = class51.cameraY;
		var21 = Actor.cameraZ;
		var7 = GrandExchangeOffer.cameraPitch;
		var8 = FriendSystem.cameraYaw;

		for (var9 = 0; var9 < 5; ++var9) {
			if (Client.field775[var9]) {
				var10 = (int)(Math.random() * (double)(Client.field892[var9] * 2 + 1) - (double)Client.field892[var9] + Math.sin((double)Client.field895[var9] * ((double)Client.field894[var9] / 100.0D)) * (double)Client.field699[var9]);
				if (var9 == 0) {
					HitSplatDefinition.cameraX += var10;
				}

				if (var9 == 1) {
					class51.cameraY += var10;
				}

				if (var9 == 2) {
					Actor.cameraZ += var10;
				}

				if (var9 == 3) {
					FriendSystem.cameraYaw = var10 + FriendSystem.cameraYaw & 2047;
				}

				if (var9 == 4) {
					GrandExchangeOffer.cameraPitch += var10;
					if (GrandExchangeOffer.cameraPitch < 128) {
						GrandExchangeOffer.cameraPitch = 128;
					}

					if (GrandExchangeOffer.cameraPitch > 383) {
						GrandExchangeOffer.cameraPitch = 383;
					}
				}
			}
		}

		var9 = MouseHandler.MouseHandler_x;
		var10 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var9 = MouseHandler.MouseHandler_lastPressedX;
			var10 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var9 >= var0 && var9 < var0 + var2 && var10 >= var1 && var10 < var3 + var1) {
			Message.method1246(var9 - var0, var10 - var1);
		} else {
			ViewportMouse.ViewportMouse_isInViewport = false;
			ViewportMouse.ViewportMouse_entityCount = 0;
		}

		UserComparator3.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		UserComparator3.playPcmPlayers();
		var11 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		ServerBuild.scene.draw(HitSplatDefinition.cameraX, class51.cameraY, Actor.cameraZ, GrandExchangeOffer.cameraPitch, FriendSystem.cameraYaw, var13);
		Rasterizer3D.Rasterizer3D_zoom = var11;
		UserComparator3.playPcmPlayers();
		ServerBuild.scene.clearTempGameObjects();
		class208.method4017(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			MouseRecorder.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - Messages.baseX * 64 << 7), (Client.hintArrowY - Language.baseY * 64 << 7) + Client.hintArrowSubY * 4096, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				SecureRandomCallable.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field707);
		RouteStrategy.method3662(var0, var1, var2, var3);
		HitSplatDefinition.cameraX = var19;
		class51.cameraY = var4;
		Actor.cameraZ = var21;
		GrandExchangeOffer.cameraPitch = var7;
		FriendSystem.cameraYaw = var8;
		if (Client.isLoading) {
			byte var22 = 0;
			var12 = var22 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
			if (var12 == 0) {
				Client.isLoading = false;
			}
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			class197.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
