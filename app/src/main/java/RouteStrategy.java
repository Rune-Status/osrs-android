import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -1462817165
	)
	public static int field2102;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1839542313
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1525294437
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -860662491
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1587561283
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIILfv;B)Z",
		garbageValue = "50"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-47058796"
	)
	static final void method3662(int var0, int var1, int var2, int var3) {
		TileItemPile.method2835();
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "67"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = ServerBuild.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		IndexedSprite var15;
		if (var5 != 0L) {
			var7 = ServerBuild.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (KeyHandler.method850(var5)) {
				var10 = var4;
			}

			int[] var13 = WorldMapRectangle.sceneMinimapSprite.pixels;
			var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var12 = GrandExchangeEvents.Entity_unpackID(var5);
			ObjectDefinition var14 = Occluder.getObjectDefinition(var12);
			if (var14.mapSceneId != -1) {
				var15 = VertexNormal.mapSceneSprites[var14.mapSceneId];
				if (var15 != null) {
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2;
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var16 + var1 * 4 + 48, (104 - var2 - var14.sizeY) * 4 + var17 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var13[var11] = var10;
						var13[var11 + 512] = var10;
						var13[var11 + 1024] = var10;
						var13[var11 + 1536] = var10;
					} else if (var8 == 1) {
						var13[var11] = var10;
						var13[var11 + 1] = var10;
						var13[var11 + 2] = var10;
						var13[var11 + 3] = var10;
					} else if (var8 == 2) {
						var13[var11 + 3] = var10;
						var13[var11 + 512 + 3] = var10;
						var13[var11 + 1024 + 3] = var10;
						var13[var11 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var13[var11 + 1536] = var10;
						var13[var11 + 1536 + 1] = var10;
						var13[var11 + 1536 + 2] = var10;
						var13[var11 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var13[var11] = var10;
					} else if (var8 == 1) {
						var13[var11 + 3] = var10;
					} else if (var8 == 2) {
						var13[var11 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var13[var11 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var13[var11] = var10;
						var13[var11 + 512] = var10;
						var13[var11 + 1024] = var10;
						var13[var11 + 1536] = var10;
					} else if (var8 == 0) {
						var13[var11] = var10;
						var13[var11 + 1] = var10;
						var13[var11 + 2] = var10;
						var13[var11 + 3] = var10;
					} else if (var8 == 1) {
						var13[var11 + 3] = var10;
						var13[var11 + 512 + 3] = var10;
						var13[var11 + 1024 + 3] = var10;
						var13[var11 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var13[var11 + 1536] = var10;
						var13[var11 + 1536 + 1] = var10;
						var13[var11 + 1536 + 2] = var10;
						var13[var11 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = ServerBuild.scene.getGameObjectTag(var0, var1, var2);
		ObjectDefinition var18;
		if (0L != var5) {
			var7 = ServerBuild.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = GrandExchangeEvents.Entity_unpackID(var5);
			var18 = Occluder.getObjectDefinition(var10);
			int var19;
			if (var18.mapSceneId != -1) {
				var15 = VertexNormal.mapSceneSprites[var18.mapSceneId];
				if (var15 != null) {
					var12 = (var18.sizeX * 4 - var15.subWidth) / 2;
					var19 = (var18.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var12 + var1 * 4 + 48, var19 + (104 - var2 - var18.sizeY) * 4 + 48);
				}
			} else if (var9 == 9) {
				var11 = 15658734;
				if (KeyHandler.method850(var5)) {
					var11 = 15597568;
				}

				int[] var21 = WorldMapRectangle.sceneMinimapSprite.pixels;
				var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var21[var19] = var11;
					var21[var19 + 1 + 512] = var11;
					var21[var19 + 1024 + 2] = var11;
					var21[var19 + 1536 + 3] = var11;
				} else {
					var21[var19 + 1536] = var11;
					var21[var19 + 1 + 1024] = var11;
					var21[var19 + 512 + 2] = var11;
					var21[var19 + 3] = var11;
				}
			}
		}

		var5 = ServerBuild.scene.getFloorDecorationTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = GrandExchangeEvents.Entity_unpackID(var5);
			var18 = Occluder.getObjectDefinition(var7);
			if (var18.mapSceneId != -1) {
				IndexedSprite var20 = VertexNormal.mapSceneSprites[var18.mapSceneId];
				if (var20 != null) {
					var10 = (var18.sizeX * 4 - var20.subWidth) / 2;
					int var22 = (var18.sizeY * 4 - var20.subHeight) / 2;
					var20.drawAt(var10 + var1 * 4 + 48, var22 + (104 - var2 - var18.sizeY) * 4 + 48);
				}
			}
		}

	}
}
