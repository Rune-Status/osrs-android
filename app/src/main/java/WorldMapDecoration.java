import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2038989741
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1678601373
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1725461175
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIILfk;Lfv;I)Z",
		garbageValue = "-802024285"
	)
	public static final boolean method346(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4) {
		int var5 = var0;
		int var6 = var1;
		byte var7 = 64;
		byte var8 = 64;
		int var9 = var0 - var7;
		int var10 = var1 - var8;
		class173.directions[var7][var8] = 99;
		class173.distances[var7][var8] = 0;
		byte var11 = 0;
		int var12 = 0;
		class173.bufferX[var11] = var0;
		int var13 = var11 + 1;
		class173.bufferY[var11] = var1;
		int[][] var14 = var4.flags;

		label204:
		while (var12 != var13) {
			var5 = class173.bufferX[var12];
			var6 = class173.bufferY[var12];
			var12 = var12 + 1 & 4095;
			int var19 = var5 - var9;
			int var20 = var6 - var10;
			int var15 = var5 - var4.xInset;
			int var16 = var6 - var4.yInset;
			if (var3.hasArrived(var2, var5, var6, var4)) {
				ChatChannel.field1289 = var5;
				class173.field2093 = var6;
				return true;
			}

			int var17 = class173.distances[var19][var20] + 1;
			int var18;
			if (var19 > 0 && class173.directions[var19 - 1][var20] == 0 && (var14[var15 - 1][var16] & 19136782) == 0 && (var14[var15 - 1][var16 + var2 - 1] & 19136824) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2 - 1) {
						class173.bufferX[var13] = var5 - 1;
						class173.bufferY[var13] = var6;
						var13 = var13 + 1 & 4095;
						class173.directions[var19 - 1][var20] = 2;
						class173.distances[var19 - 1][var20] = var17;
						break;
					}

					if ((var14[var15 - 1][var18 + var16] & 19136830) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var19 < 128 - var2 && class173.directions[var19 + 1][var20] == 0 && (var14[var15 + var2][var16] & 19136899) == 0 && (var14[var15 + var2][var16 + var2 - 1] & 19136992) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2 - 1) {
						class173.bufferX[var13] = var5 + 1;
						class173.bufferY[var13] = var6;
						var13 = var13 + 1 & 4095;
						class173.directions[var19 + 1][var20] = 8;
						class173.distances[var19 + 1][var20] = var17;
						break;
					}

					if ((var14[var15 + var2][var18 + var16] & 19136995) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var20 > 0 && class173.directions[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && (var14[var15 + var2 - 1][var16 - 1] & 19136899) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2 - 1) {
						class173.bufferX[var13] = var5;
						class173.bufferY[var13] = var6 - 1;
						var13 = var13 + 1 & 4095;
						class173.directions[var19][var20 - 1] = 1;
						class173.distances[var19][var20 - 1] = var17;
						break;
					}

					if ((var14[var18 + var15][var16 - 1] & 19136911) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var20 < 128 - var2 && class173.directions[var19][var20 + 1] == 0 && (var14[var15][var16 + var2] & 19136824) == 0 && (var14[var15 + var2 - 1][var16 + var2] & 19136992) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2 - 1) {
						class173.bufferX[var13] = var5;
						class173.bufferY[var13] = var6 + 1;
						var13 = var13 + 1 & 4095;
						class173.directions[var19][var20 + 1] = 4;
						class173.distances[var19][var20 + 1] = var17;
						break;
					}

					if ((var14[var18 + var15][var16 + var2] & 19137016) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var19 > 0 && var20 > 0 && class173.directions[var19 - 1][var20 - 1] == 0 && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2) {
						class173.bufferX[var13] = var5 - 1;
						class173.bufferY[var13] = var6 - 1;
						var13 = var13 + 1 & 4095;
						class173.directions[var19 - 1][var20 - 1] = 3;
						class173.distances[var19 - 1][var20 - 1] = var17;
						break;
					}

					if ((var14[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 - 1] & 19136911) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var19 < 128 - var2 && var20 > 0 && class173.directions[var19 + 1][var20 - 1] == 0 && (var14[var15 + var2][var16 - 1] & 19136899) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2) {
						class173.bufferX[var13] = var5 + 1;
						class173.bufferY[var13] = var6 - 1;
						var13 = var13 + 1 & 4095;
						class173.directions[var19 + 1][var20 - 1] = 9;
						class173.distances[var19 + 1][var20 - 1] = var17;
						break;
					}

					if ((var14[var15 + var2][var18 + (var16 - 1)] & 19136995) != 0 || (var14[var15 + var18][var16 - 1] & 19136911) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var19 > 0 && var20 < 128 - var2 && class173.directions[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var16 + var2] & 19136824) == 0) {
				var18 = 1;

				while (true) {
					if (var18 >= var2) {
						class173.bufferX[var13] = var5 - 1;
						class173.bufferY[var13] = var6 + 1;
						var13 = var13 + 1 & 4095;
						class173.directions[var19 - 1][var20 + 1] = 6;
						class173.distances[var19 - 1][var20 + 1] = var17;
						break;
					}

					if ((var14[var15 - 1][var18 + var16] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 + var2] & 19137016) != 0) {
						break;
					}

					++var18;
				}
			}

			if (var19 < 128 - var2 && var20 < 128 - var2 && class173.directions[var19 + 1][var20 + 1] == 0 && (var14[var15 + var2][var16 + var2] & 19136992) == 0) {
				for (var18 = 1; var18 < var2; ++var18) {
					if ((var14[var15 + var18][var16 + var2] & 19137016) != 0 || (var14[var15 + var2][var18 + var16] & 19136995) != 0) {
						continue label204;
					}
				}

				class173.bufferX[var13] = var5 + 1;
				class173.bufferY[var13] = var6 + 1;
				var13 = var13 + 1 & 4095;
				class173.directions[var19 + 1][var20 + 1] = 12;
				class173.distances[var19 + 1][var20 + 1] = var17;
			}
		}

		ChatChannel.field1289 = var5;
		class173.field2093 = var6;
		return false;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IZIZB)V",
		garbageValue = "58"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (class96.World_worlds != null) {
			InterfaceParent.doWorldSorting(0, class96.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(Lbs;I)V",
		garbageValue = "447315853"
	)
	static final void method347(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = ServerBuild.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = ServerBuild.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = ServerBuild.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = ServerBuild.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var1 != 0L) {
			int var6 = ServerBuild.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = GrandExchangeEvents.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field924 = var4;
		var0.field935 = var5;
	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "-22"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (ScriptFrame.loadInterface(var0)) {
			GrandExchangeOfferAgeComparator.updateInterface(WorldMapLabel.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}

	}
}
