import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive2")
	static Archive archive2;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ll;Ll;I)I",
		garbageValue = "250420083"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "362180230"
	)
	public static boolean method76(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lhn;IIII)V",
		garbageValue = "1571239297"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2649 == null) {
			throw new RuntimeException();
		} else {
			var0.field2649[var1] = var2;
			var0.field2560[var1] = var3;
		}
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(Lgy;I)V",
		garbageValue = "356089511"
	)
	static final void method77(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (class185.field2314 == var0) {
			var2 = var1.method5771();
			var3 = (var2 >> 4 & 7) + SecureRandomCallable.field531;
			var4 = (var2 & 7) + FontName.field3663;
			var5 = var1.method5606();
			var6 = var5 >> 2;
			var7 = var5 & 3;
			var8 = Client.field743[var6];
			if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
				Skills.updatePendingSpawn(Clock.Client_plane, var3, var4, var8, -1, var6, var7, 0, -1);
			}
		} else {
			int var9;
			int var10;
			if (class185.field2327 == var0) {
				var2 = var1.method5740();
				var3 = var1.method5606();
				var4 = var1.readUnsignedByte();
				var5 = (var4 >> 4 & 7) + SecureRandomCallable.field531;
				var6 = (var4 & 7) + FontName.field3663;
				var7 = var1.readUnsignedByte();
				var8 = var7 >> 4 & 15;
				var9 = var7 & 7;
				if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
					var10 = var8 + 1;
					if (class192.localPlayer.pathX[0] >= var5 - var10 && class192.localPlayer.pathX[0] <= var5 + var10 && class192.localPlayer.pathY[0] >= var6 - var10 && class192.localPlayer.pathY[0] <= var6 + var10 && Client.areaSoundEffectVolume != 0 && var9 > 0 && Client.soundEffectCount < 50) {
						Client.soundEffectIds[Client.soundEffectCount] = var2;
						Client.queuedSoundEffectLoops[Client.soundEffectCount] = var9;
						Client.queuedSoundEffectDelays[Client.soundEffectCount] = var3;
						Client.soundEffects[Client.soundEffectCount] = null;
						Client.soundLocations[Client.soundEffectCount] = var8 + (var6 << 8) + (var5 << 16);
						++Client.soundEffectCount;
					}
				}
			}

			TileItem var11;
			if (class185.field2322 == var0) {
				var2 = var1.method5762();
				var3 = var1.method5605();
				var4 = (var3 >> 4 & 7) + SecureRandomCallable.field531;
				var5 = (var3 & 7) + FontName.field3663;
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					NodeDeque var12 = Client.groundItems[Clock.Client_plane][var4][var5];
					if (var12 != null) {
						for (var11 = (TileItem)var12.last(); var11 != null; var11 = (TileItem)var12.previous()) {
							if ((var2 & 32767) == var11.id) {
								var11.remove();
								break;
							}
						}

						if (var12.last() == null) {
							Client.groundItems[Clock.Client_plane][var4][var5] = null;
						}

						WorldMapEvent.updateItemPile(var4, var5);
					}
				}
			} else if (class185.field2317 == var0) {
				var2 = var1.method5614();
				var3 = var1.method5605();
				var4 = (var3 >> 4 & 7) + SecureRandomCallable.field531;
				var5 = (var3 & 7) + FontName.field3663;
				var6 = var1.method5614();
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					var11 = new TileItem();
					var11.id = var2;
					var11.quantity = var6;
					if (Client.groundItems[Clock.Client_plane][var4][var5] == null) {
						Client.groundItems[Clock.Client_plane][var4][var5] = new NodeDeque();
					}

					Client.groundItems[Clock.Client_plane][var4][var5].addFirst(var11);
					WorldMapEvent.updateItemPile(var4, var5);
				}
			} else {
				int var35;
				if (class185.field2316 == var0) {
					var2 = var1.readUnsignedShort();
					var3 = var1.method5605();
					var4 = var3 >> 2;
					var5 = var3 & 3;
					var6 = Client.field743[var4];
					var7 = var1.method5606();
					var8 = (var7 >> 4 & 7) + SecureRandomCallable.field531;
					var9 = (var7 & 7) + FontName.field3663;
					if (var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
						if (var6 == 0) {
							BoundaryObject var13 = ServerBuild.scene.method3177(Clock.Client_plane, var8, var9);
							if (var13 != null) {
								var35 = GrandExchangeEvents.Entity_unpackID(var13.tag);
								if (var4 == 2) {
									var13.entity1 = new DynamicObject(var35, 2, var5 + 4, Clock.Client_plane, var8, var9, var2, false, var13.entity1);
									var13.entity2 = new DynamicObject(var35, 2, var5 + 1 & 3, Clock.Client_plane, var8, var9, var2, false, var13.entity2);
								} else {
									var13.entity1 = new DynamicObject(var35, var4, var5, Clock.Client_plane, var8, var9, var2, false, var13.entity1);
								}
							}
						}

						if (var6 == 1) {
							WallDecoration var36 = ServerBuild.scene.method3178(Clock.Client_plane, var8, var9);
							if (var36 != null) {
								var35 = GrandExchangeEvents.Entity_unpackID(var36.tag);
								if (var4 != 4 && var4 != 5) {
									if (var4 == 6) {
										var36.entity1 = new DynamicObject(var35, 4, var5 + 4, Clock.Client_plane, var8, var9, var2, false, var36.entity1);
									} else if (var4 == 7) {
										var36.entity1 = new DynamicObject(var35, 4, (var5 + 2 & 3) + 4, Clock.Client_plane, var8, var9, var2, false, var36.entity1);
									} else if (var4 == 8) {
										var36.entity1 = new DynamicObject(var35, 4, var5 + 4, Clock.Client_plane, var8, var9, var2, false, var36.entity1);
										var36.entity2 = new DynamicObject(var35, 4, (var5 + 2 & 3) + 4, Clock.Client_plane, var8, var9, var2, false, var36.entity2);
									}
								} else {
									var36.entity1 = new DynamicObject(var35, 4, var5, Clock.Client_plane, var8, var9, var2, false, var36.entity1);
								}
							}
						}

						if (var6 == 2) {
							GameObject var37 = ServerBuild.scene.method3203(Clock.Client_plane, var8, var9);
							if (var4 == 11) {
								var4 = 10;
							}

							if (var37 != null) {
								var37.entity = new DynamicObject(GrandExchangeEvents.Entity_unpackID(var37.tag), var4, var5, Clock.Client_plane, var8, var9, var2, false, var37.entity);
							}
						}

						if (var6 == 3) {
							FloorDecoration var38 = ServerBuild.scene.getFloorDecoration(Clock.Client_plane, var8, var9);
							if (var38 != null) {
								var38.entity = new DynamicObject(GrandExchangeEvents.Entity_unpackID(var38.tag), 22, var5, Clock.Client_plane, var8, var9, var2, false, var38.entity);
							}
						}
					}
				} else if (class185.field2323 == var0) {
					var2 = var1.method5605();
					var3 = var2 >> 2;
					var4 = var2 & 3;
					var5 = Client.field743[var3];
					var6 = var1.method5762();
					var7 = var1.readUnsignedByte();
					var8 = (var7 >> 4 & 7) + SecureRandomCallable.field531;
					var9 = (var7 & 7) + FontName.field3663;
					if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
						Skills.updatePendingSpawn(Clock.Client_plane, var8, var9, var5, var6, var3, var4, 0, -1);
					}
				} else {
					int var14;
					int var15;
					byte var16;
					byte var17;
					int var39;
					if (class185.field2320 == var0) {
						var2 = var1.method5605();
						var3 = (var2 >> 4 & 7) + SecureRandomCallable.field531;
						var4 = (var2 & 7) + FontName.field3663;
						var16 = var1.readByte();
						var6 = var1.method5740();
						var17 = var1.method5618();
						byte var18 = var1.method5780();
						var9 = var1.method5605();
						var10 = var9 >> 2;
						var35 = var9 & 3;
						var39 = Client.field743[var10];
						var14 = var1.method5762();
						var15 = var1.method5614();
						byte var19 = var1.method5618();
						int var20 = var1.method5740();
						Player var21;
						if (var15 == Client.localPlayerIndex) {
							var21 = class192.localPlayer;
						} else {
							var21 = Client.players[var15];
						}

						if (var21 != null) {
							ObjectDefinition var22 = Occluder.getObjectDefinition(var20);
							int var23;
							int var24;
							if (var35 != 1 && var35 != 3) {
								var23 = var22.sizeX;
								var24 = var22.sizeY;
							} else {
								var23 = var22.sizeY;
								var24 = var22.sizeX;
							}

							int var25 = var3 + (var23 >> 1);
							int var26 = var3 + (var23 + 1 >> 1);
							int var27 = var4 + (var24 >> 1);
							int var28 = var4 + (var24 + 1 >> 1);
							int[][] var29 = Tiles.Tiles_heights[Clock.Client_plane];
							int var30 = var29[var26][var28] + var29[var26][var27] + var29[var25][var27] + var29[var25][var28] >> 2;
							int var31 = (var3 << 7) + (var23 << 6);
							int var32 = (var4 << 7) + (var24 << 6);
							Model var33 = var22.getModel(var10, var35, var29, var31, var30, var32);
							if (var33 != null) {
								Skills.updatePendingSpawn(Clock.Client_plane, var3, var4, var39, -1, 0, 0, var6 + 1, var14 + 1);
								var21.animationCycleStart = var6 + Client.cycle;
								var21.animationCycleEnd = var14 + Client.cycle;
								var21.model0 = var33;
								var21.field622 = var3 * 128 + var23 * 64;
								var21.field620 = var4 * 128 + var24 * 64;
								var21.tileHeight2 = var30;
								byte var34;
								if (var16 > var18) {
									var34 = var16;
									var16 = var18;
									var18 = var34;
								}

								if (var17 > var19) {
									var34 = var17;
									var17 = var19;
									var19 = var34;
								}

								var21.field626 = var16 + var3;
								var21.field628 = var18 + var3;
								var21.field627 = var4 + var17;
								var21.field629 = var4 + var19;
							}
						}
					}

					if (class185.field2318 == var0) {
						var2 = var1.readShort();
						var3 = var1.readUnsignedByte();
						var4 = var1.method5771();
						var5 = (var4 >> 4 & 7) + SecureRandomCallable.field531;
						var6 = (var4 & 7) + FontName.field3663;
						var7 = var1.method5771() * 4;
						var8 = var1.method5762();
						var9 = var1.method5771() * 4;
						var10 = var1.readUnsignedShort();
						var35 = var1.method5606();
						var16 = var1.method5609();
						var17 = var1.method5618();
						var15 = var1.readUnsignedShort();
						var14 = var17 + var5;
						var39 = var16 + var6;
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104 && var14 >= 0 && var39 >= 0 && var14 < 104 && var39 < 104 && var15 != 65535) {
							var5 = var5 * 128 + 64;
							var6 = var6 * 128 + 64;
							var14 = var14 * 128 + 64;
							var39 = var39 * 128 + 64;
							Projectile var43 = new Projectile(var15, Clock.Client_plane, var5, var6, WorldMapSectionType.getTileHeight(var5, var6, Clock.Client_plane) - var7, var10 + Client.cycle, var8 + Client.cycle, var35, var3, var2, var9);
							var43.setDestination(var14, var39, WorldMapSectionType.getTileHeight(var14, var39, Clock.Client_plane) - var9, var10 + Client.cycle);
							Client.projectiles.addFirst(var43);
						}
					} else if (class185.field2315 != var0) {
						if (class185.field2319 == var0) {
							var2 = var1.method5762();
							var3 = var1.method5771();
							var4 = (var3 >> 4 & 7) + SecureRandomCallable.field531;
							var5 = (var3 & 7) + FontName.field3663;
							var6 = var1.readUnsignedByte();
							var7 = var1.method5614();
							if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
								var4 = var4 * 128 + 64;
								var5 = var5 * 128 + 64;
								GraphicsObject var40 = new GraphicsObject(var7, Clock.Client_plane, var4, var5, WorldMapSectionType.getTileHeight(var4, var5, Clock.Client_plane) - var6, var2, Client.cycle);
								Client.graphicsObjects.addFirst(var40);
							}
						}
					} else {
						var2 = var1.method5740();
						var3 = var1.method5762();
						var4 = var1.method5614();
						var5 = var1.method5771();
						var6 = (var5 >> 4 & 7) + SecureRandomCallable.field531;
						var7 = (var5 & 7) + FontName.field3663;
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
							NodeDeque var41 = Client.groundItems[Clock.Client_plane][var6][var7];
							if (var41 != null) {
								for (TileItem var42 = (TileItem)var41.last(); var42 != null; var42 = (TileItem)var41.previous()) {
									if ((var2 & 32767) == var42.id && var4 == var42.quantity) {
										var42.quantity = var3;
										break;
									}
								}

								WorldMapEvent.updateItemPile(var6, var7);
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-87"
	)
	static final void method74(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var6 + var13;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var15 + var7 + var1;
			Rasterizer3D.method3066(var17, var18, var19);
			Rasterizer3D.method3123(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method3066(var17, var19, var20);
			Rasterizer3D.method3123(var21, var23, var24, var17, var19, var20, var4);
		}

	}
}
