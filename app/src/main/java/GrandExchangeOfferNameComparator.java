import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("GrandExchangeOfferNameComparator")
final class GrandExchangeOfferNameComparator implements Comparator {
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive9")
	static Archive archive9;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ll;Ll;B)I",
		garbageValue = "48"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lem;[Lfv;I)V",
		garbageValue = "1041712074"
	)
	static final void method152(Scene var0, CollisionMap[] var1) {
		int var2;
		int var3;
		int var4;
		int var5;
		for (var2 = 0; var2 < 4; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				for (var4 = 0; var4 < 104; ++var4) {
					if ((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
						var5 = var2;
						if ((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
							var5 = var2 - 1;
						}

						if (var5 >= 0) {
							var1[var5].setBlockedByFloor(var3, var4);
						}
					}
				}
			}
		}

		Tiles.field512 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field512 < -8) {
			Tiles.field512 = -8;
		}

		if (Tiles.field512 > 8) {
			Tiles.field512 = 8;
		}

		Tiles.field519 += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.field519 < -16) {
			Tiles.field519 = -16;
		}

		if (Tiles.field519 > 16) {
			Tiles.field519 = 16;
		}

		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int[] var14;
		int var15;
		int var16;
		int var18;
		int var19;
		for (var2 = 0; var2 < 4; ++var2) {
			byte[][] var17 = InterfaceParent.field565[var2];
			var6 = (int)Math.sqrt(5100.0D);
			var7 = var6 * 768 >> 8;

			for (var8 = 1; var8 < 103; ++var8) {
				for (var9 = 1; var9 < 103; ++var9) {
					var10 = Tiles.Tiles_heights[var2][var9 + 1][var8] - Tiles.Tiles_heights[var2][var9 - 1][var8];
					var11 = Tiles.Tiles_heights[var2][var9][var8 + 1] - Tiles.Tiles_heights[var2][var9][var8 - 1];
					var12 = (int)Math.sqrt((double)(var11 * var11 + var10 * var10 + 65536));
					var13 = (var10 << 8) / var12;
					var15 = 65536 / var12;
					var16 = (var11 << 8) / var12;
					var18 = (var13 * -50 + var16 * -50 + var15 * -10) / var7 + 96;
					var19 = (var17[var9][var8 + 1] >> 3) + (var17[var9 - 1][var8] >> 2) + (var17[var9][var8 - 1] >> 2) + (var17[var9 + 1][var8] >> 3) + (var17[var9][var8] >> 1);
					Tiles.field509[var9][var8] = var18 - var19;
				}
			}

			for (var8 = 0; var8 < 104; ++var8) {
				class268.Tiles_hue[var8] = 0;
				HorizontalAlignment.Tiles_saturation[var8] = 0;
				class30.Tiles_lightness[var8] = 0;
				class40.Tiles_hueMultiplier[var8] = 0;
				TileItemPile.field1529[var8] = 0;
			}

			for (var8 = -5; var8 < 109; ++var8) {
				for (var9 = 0; var9 < 104; ++var9) {
					var10 = var8 + 5;
					int var10003;
					FloorUnderlayDefinition var21;
					if (var10 >= 0 && var10 < 104) {
						var11 = Tiles.field502[var2][var10][var9] & 255;
						if (var11 > 0) {
							var21 = GraphicsObject.method2055(var11 - 1);
							var14 = class268.Tiles_hue;
							var14[var9] += var21.hue;
							var14 = HorizontalAlignment.Tiles_saturation;
							var14[var9] += var21.saturation;
							var14 = class30.Tiles_lightness;
							var14[var9] += var21.lightness;
							var14 = class40.Tiles_hueMultiplier;
							var14[var9] += var21.hueMultiplier;
							var10003 = TileItemPile.field1529[var9]++;
						}
					}

					var11 = var8 - 5;
					if (var11 >= 0 && var11 < 104) {
						var12 = Tiles.field502[var2][var11][var9] & 255;
						if (var12 > 0) {
							var21 = GraphicsObject.method2055(var12 - 1);
							var14 = class268.Tiles_hue;
							var14[var9] -= var21.hue;
							var14 = HorizontalAlignment.Tiles_saturation;
							var14[var9] -= var21.saturation;
							var14 = class30.Tiles_lightness;
							var14[var9] -= var21.lightness;
							var14 = class40.Tiles_hueMultiplier;
							var14[var9] -= var21.hueMultiplier;
							var10003 = TileItemPile.field1529[var9]--;
						}
					}
				}

				if (var8 >= 1 && var8 < 103) {
					var9 = 0;
					var10 = 0;
					var11 = 0;
					var12 = 0;
					var13 = 0;

					for (var15 = -5; var15 < 109; ++var15) {
						var16 = var15 + 5;
						if (var16 >= 0 && var16 < 104) {
							var9 += class268.Tiles_hue[var16];
							var10 += HorizontalAlignment.Tiles_saturation[var16];
							var11 += class30.Tiles_lightness[var16];
							var12 += class40.Tiles_hueMultiplier[var16];
							var13 += TileItemPile.field1529[var16];
						}

						var18 = var15 - 5;
						if (var18 >= 0 && var18 < 104) {
							var9 -= class268.Tiles_hue[var18];
							var10 -= HorizontalAlignment.Tiles_saturation[var18];
							var11 -= class30.Tiles_lightness[var18];
							var12 -= class40.Tiles_hueMultiplier[var18];
							var13 -= TileItemPile.field1529[var18];
						}

						if (var15 >= 1 && var15 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var8][var15] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var8][var15] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var19 = Tiles.field502[var2][var8][var15] & 255;
							int var20 = Tiles.field514[var2][var8][var15] & 255;
							if (var19 > 0 || var20 > 0) {
								int var43 = Tiles.Tiles_heights[var2][var8][var15];
								int var22 = Tiles.Tiles_heights[var2][var8 + 1][var15];
								int var23 = Tiles.Tiles_heights[var2][var8 + 1][var15 + 1];
								int var24 = Tiles.Tiles_heights[var2][var8][var15 + 1];
								int var25 = Tiles.field509[var8][var15];
								int var26 = Tiles.field509[var8 + 1][var15];
								int var27 = Tiles.field509[var8 + 1][var15 + 1];
								int var28 = Tiles.field509[var8][var15 + 1];
								int var29 = -1;
								int var30 = -1;
								int var31;
								int var32;
								if (var19 > 0) {
									var31 = var9 * 256 / var12;
									var32 = var10 / var13;
									int var33 = var11 / var13;
									var29 = class192.hslToRgb(var31, var32, var33);
									var31 = var31 + Tiles.field512 & 255;
									var33 += Tiles.field519;
									if (var33 < 0) {
										var33 = 0;
									} else if (var33 > 255) {
										var33 = 255;
									}

									var30 = class192.hslToRgb(var31, var32, var33);
								}

								if (var2 > 0) {
									boolean var44 = true;
									if (var19 == 0 && Tiles.field507[var2][var8][var15] != 0) {
										var44 = false;
									}

									if (var20 > 0 && !ArchiveLoader.FloorUnderlayDefinition_get(var20 - 1).hideUnderlay) {
										var44 = false;
									}

									if (var44 && var22 == var43 && var43 == var23 && var24 == var43) {
										var14 = UrlRequest.field1940[var2][var8];
										var14[var15] |= 2340;
									}
								}

								var31 = 0;
								if (var30 != -1) {
									var31 = Rasterizer3D.Rasterizer3D_colorPalette[DynamicObject.method2286(var30, 96)];
								}

								if (var20 == 0) {
									var0.addTile(var2, var8, var15, 0, 0, -1, var43, var22, var23, var24, DynamicObject.method2286(var29, var25), DynamicObject.method2286(var29, var26), DynamicObject.method2286(var29, var27), DynamicObject.method2286(var29, var28), 0, 0, 0, 0, var31, 0);
								} else {
									var32 = Tiles.field507[var2][var8][var15] + 1;
									byte var45 = Tiles.field518[var2][var8][var15];
									FloorOverlayDefinition var34 = ArchiveLoader.FloorUnderlayDefinition_get(var20 - 1);
									int var35 = var34.texture;
									int var36;
									int var37;
									int var38;
									int var39;
									if (var35 >= 0) {
										var37 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var35);
										var36 = -1;
									} else if (var34.primaryRgb == 16711935) {
										var36 = -2;
										var35 = -1;
										var37 = -2;
									} else {
										var36 = class192.hslToRgb(var34.hue, var34.saturation, var34.lightness);
										var38 = var34.hue + Tiles.field512 & 255;
										var39 = var34.lightness + Tiles.field519;
										if (var39 < 0) {
											var39 = 0;
										} else if (var39 > 255) {
											var39 = 255;
										}

										var37 = class192.hslToRgb(var38, var34.saturation, var39);
									}

									var38 = 0;
									if (var37 != -2) {
										var38 = Rasterizer3D.Rasterizer3D_colorPalette[WorldMapRegion.method564(var37, 96)];
									}

									if (var34.secondaryRgb != -1) {
										var39 = var34.secondaryHue + Tiles.field512 & 255;
										int var40 = var34.secondaryLightness + Tiles.field519;
										if (var40 < 0) {
											var40 = 0;
										} else if (var40 > 255) {
											var40 = 255;
										}

										var37 = class192.hslToRgb(var39, var34.secondarySaturation, var40);
										var38 = Rasterizer3D.Rasterizer3D_colorPalette[WorldMapRegion.method564(var37, 96)];
									}

									var0.addTile(var2, var8, var15, var32, var45, var35, var43, var22, var23, var24, DynamicObject.method2286(var29, var25), DynamicObject.method2286(var29, var26), DynamicObject.method2286(var29, var27), DynamicObject.method2286(var29, var28), WorldMapRegion.method564(var36, var25), WorldMapRegion.method564(var36, var26), WorldMapRegion.method564(var36, var27), WorldMapRegion.method564(var36, var28), var31, var38);
								}
							}
						}
					}
				}
			}

			for (var8 = 1; var8 < 103; ++var8) {
				for (var9 = 1; var9 < 103; ++var9) {
					if ((Tiles.Tiles_renderFlags[var2][var9][var8] & 8) != 0) {
						var15 = 0;
					} else if (var2 > 0 && (Tiles.Tiles_renderFlags[1][var9][var8] & 2) != 0) {
						var15 = var2 - 1;
					} else {
						var15 = var2;
					}

					var0.setTileMinPlane(var2, var9, var8, var15);
				}
			}

			Tiles.field502[var2] = null;
			Tiles.field514[var2] = null;
			Tiles.field507[var2] = null;
			Tiles.field518[var2] = null;
			InterfaceParent.field565[var2] = null;
		}

		var0.method3186(-50, -10, -50);

		for (var2 = 0; var2 < 104; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				if ((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var0.setLinkBelow(var2, var3);
				}
			}
		}

		var2 = 1;
		var3 = 2;
		var4 = 4;

		for (var5 = 0; var5 < 4; ++var5) {
			if (var5 > 0) {
				var2 <<= 3;
				var3 <<= 3;
				var4 <<= 3;
			}

			for (int var41 = 0; var41 <= var5; ++var41) {
				for (var18 = 0; var18 <= 104; ++var18) {
					for (var19 = 0; var19 <= 104; ++var19) {
						short var42;
						if ((UrlRequest.field1940[var41][var19][var18] & var2) != 0) {
							var6 = var18;
							var7 = var18;
							var8 = var41;

							for (var9 = var41; var6 > 0 && (UrlRequest.field1940[var41][var19][var6 - 1] & var2) != 0; --var6) {
							}

							while (var7 < 104 && (UrlRequest.field1940[var41][var19][var7 + 1] & var2) != 0) {
								++var7;
							}

							label342:
							while (var8 > 0) {
								for (var10 = var6; var10 <= var7; ++var10) {
									if ((UrlRequest.field1940[var8 - 1][var19][var10] & var2) == 0) {
										break label342;
									}
								}

								--var8;
							}

							label331:
							while (var9 < var5) {
								for (var10 = var6; var10 <= var7; ++var10) {
									if ((UrlRequest.field1940[var9 + 1][var19][var10] & var2) == 0) {
										break label331;
									}
								}

								++var9;
							}

							var10 = (var7 - var6 + 1) * (var9 + 1 - var8);
							if (var10 >= 8) {
								var42 = 240;
								var12 = Tiles.Tiles_heights[var9][var19][var6] - var42;
								var13 = Tiles.Tiles_heights[var8][var19][var6];
								Scene.Scene_addOccluder(var5, 1, var19 * 128, var19 * 128, var6 * 128, var7 * 128 + 128, var12, var13);

								for (var15 = var8; var15 <= var9; ++var15) {
									for (var16 = var6; var16 <= var7; ++var16) {
										var14 = UrlRequest.field1940[var15][var19];
										var14[var16] &= ~var2;
									}
								}
							}
						}

						if ((UrlRequest.field1940[var41][var19][var18] & var3) != 0) {
							var6 = var19;
							var7 = var19;
							var8 = var41;

							for (var9 = var41; var6 > 0 && (UrlRequest.field1940[var41][var6 - 1][var18] & var3) != 0; --var6) {
							}

							while (var7 < 104 && (UrlRequest.field1940[var41][var7 + 1][var18] & var3) != 0) {
								++var7;
							}

							label395:
							while (var8 > 0) {
								for (var10 = var6; var10 <= var7; ++var10) {
									if ((UrlRequest.field1940[var8 - 1][var10][var18] & var3) == 0) {
										break label395;
									}
								}

								--var8;
							}

							label384:
							while (var9 < var5) {
								for (var10 = var6; var10 <= var7; ++var10) {
									if ((UrlRequest.field1940[var9 + 1][var10][var18] & var3) == 0) {
										break label384;
									}
								}

								++var9;
							}

							var10 = (var7 - var6 + 1) * (var9 + 1 - var8);
							if (var10 >= 8) {
								var42 = 240;
								var12 = Tiles.Tiles_heights[var9][var6][var18] - var42;
								var13 = Tiles.Tiles_heights[var8][var6][var18];
								Scene.Scene_addOccluder(var5, 2, var6 * 128, var7 * 128 + 128, var18 * 128, var18 * 128, var12, var13);

								for (var15 = var8; var15 <= var9; ++var15) {
									for (var16 = var6; var16 <= var7; ++var16) {
										var14 = UrlRequest.field1940[var15][var16];
										var14[var18] &= ~var3;
									}
								}
							}
						}

						if ((UrlRequest.field1940[var41][var19][var18] & var4) != 0) {
							var6 = var19;
							var7 = var19;
							var8 = var18;

							for (var9 = var18; var8 > 0 && (UrlRequest.field1940[var41][var19][var8 - 1] & var4) != 0; --var8) {
							}

							while (var9 < 104 && (UrlRequest.field1940[var41][var19][var9 + 1] & var4) != 0) {
								++var9;
							}

							label448:
							while (var6 > 0) {
								for (var10 = var8; var10 <= var9; ++var10) {
									if ((UrlRequest.field1940[var41][var6 - 1][var10] & var4) == 0) {
										break label448;
									}
								}

								--var6;
							}

							label437:
							while (var7 < 104) {
								for (var10 = var8; var10 <= var9; ++var10) {
									if ((UrlRequest.field1940[var41][var7 + 1][var10] & var4) == 0) {
										break label437;
									}
								}

								++var7;
							}

							if ((var9 - var8 + 1) * (var7 - var6 + 1) >= 4) {
								var10 = Tiles.Tiles_heights[var41][var6][var8];
								Scene.Scene_addOccluder(var5, 4, var6 * 128, var7 * 128 + 128, var8 * 128, var9 * 128 + 128, var10, var10);

								for (var11 = var6; var11 <= var7; ++var11) {
									for (var12 = var8; var12 <= var9; ++var12) {
										var14 = UrlRequest.field1940[var41][var11];
										var14[var12] &= ~var4;
									}
								}
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1818346399"
	)
	static final void method150(int var0) {
		if (ScriptFrame.loadInterface(var0)) {
			WorldMapEvent.drawModelComponents(WorldMapLabel.Widget_interfaceComponents[var0], -1);
		}

	}
}
