import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class288 {
	@ObfuscatedName("c")
	@Export("cp1252AsciiExtension")
	public static final char[] cp1252AsciiExtension;

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(Lbx;IIIIIB)V",
		garbageValue = "1"
	)
	@Export("drawActor2d")
	static final void drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5) {
		if (var0 != null && var0.isVisible()) {
			if (var0 instanceof NPC) {
				NPCDefinition var6 = ((NPC)var0).definition;
				if (var6.transforms != null) {
					var6 = var6.transform();
				}

				if (var6 == null) {
					return;
				}
			}

			int var79 = Players.Players_count;
			int[] var7 = Players.Players_indices;
			byte var8 = 0;
			int var9;
			if (var1 < var79 && var0.playerCycle == Client.cycle && ClientPreferences.method1840((Player)var0)) {
				Player var10 = (Player)var0;
				if (var1 < var79) {
					var9 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var9);
					AbstractFont var11 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
					byte var12 = 9;
					var11.drawCentered(var10.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var12, 16777215, 0);
					var8 = 18;
				}
			}

			int var80 = -2;
			int var13;
			int var14;
			int var20;
			int var81;
			int var82;
			if (!var0.healthBars.method4886()) {
				var9 = var0.defaultHeight + 15;
				MouseRecorder.worldToScreen(var0.x, var0.y, var9);

				for (HealthBar var15 = (HealthBar)var0.healthBars.last(); var15 != null; var15 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var16 = var15.get(Client.cycle);
					if (var16 == null) {
						if (var15.isEmpty()) {
							var15.remove();
						}
					} else {
						HealthBarDefinition var17 = var15.definition;
						Sprite var18 = var17.getBackSprite();
						Sprite var19 = var17.getFrontSprite();
						var82 = 0;
						if (var18 != null && var19 != null) {
							if (var17.widthPadding * 2 < var19.subWidth) {
								var82 = var17.widthPadding;
							}

							var81 = var19.subWidth - var82 * 2;
						} else {
							var81 = var17.width;
						}

						var20 = 255;
						boolean var21 = true;
						int var22 = Client.cycle - var16.cycle;
						int var23 = var81 * var16.health2 / var17.width;
						int var24;
						int var25;
						if (var16.cycleOffset > var22) {
							var24 = var17.field3283 == 0 ? 0 : var17.field3283 * (var22 / var17.field3283);
							var13 = var81 * var16.health / var17.width;
							var25 = var24 * (var23 - var13) / var16.cycleOffset + var13;
						} else {
							var25 = var23;
							var24 = var16.cycleOffset + var17.int5 - var22;
							if (var17.int3 >= 0) {
								var20 = (var24 << 8) / (var17.int5 - var17.int3);
							}
						}

						if (var16.health2 > 0 && var25 < 1) {
							var25 = 1;
						}

						if (var18 != null && var19 != null) {
							if (var81 == var25) {
								var25 += var82 * 2;
							} else {
								var25 += var82;
							}

							var24 = var18.subHeight;
							var80 += var24;
							var13 = var2 + Client.viewportTempX - (var81 >> 1);
							var14 = var3 + Client.viewportTempY - var80;
							var13 -= var82;
							if (var20 >= 0 && var20 < 255) {
								var18.drawTransAt(var13, var14, var20);
								Rasterizer2D.Rasterizer2D_expandClip(var13, var14, var13 + var25, var24 + var14);
								var19.drawTransAt(var13, var14, var20);
							} else {
								var18.drawTransBgAt(var13, var14);
								Rasterizer2D.Rasterizer2D_expandClip(var13, var14, var13 + var25, var24 + var14);
								var19.drawTransBgAt(var13, var14);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var80 += 2;
						} else {
							var80 += 5;
							if (Client.viewportTempX > -1) {
								var24 = var2 + Client.viewportTempX - (var81 >> 1);
								var13 = var3 + Client.viewportTempY - var80;
								Rasterizer2D.Rasterizer2D_fillRectangle(var24, var13, var25, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var25 + var24, var13, var81 - var25, 5, 16711680);
							}

							var80 += 2;
						}
					}
				}
			}

			if (var80 == -2) {
				var80 += 7;
			}

			var80 += var8;
			int var83;
			if (var1 < var79) {
				Player var85 = (Player)var0;
				if (var85.isHidden) {
					return;
				}

				if (var85.headIconPk != -1 || var85.headIconPrayer != -1) {
					var83 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var83);
					if (Client.viewportTempX > -1) {
						if (var85.headIconPk != -1) {
							var80 += 25;
							Ignored.headIconPkSprites[var85.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var80);
						}

						if (var85.headIconPrayer != -1) {
							var80 += 25;
							class40.headIconPrayerSprites[var85.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var80);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					var83 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var83);
					if (Client.viewportTempX > -1) {
						var80 += SecureRandomCallable.headIconHintSprites[1].subHeight;
						SecureRandomCallable.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var80);
					}
				}
			} else {
				NPCDefinition var84 = ((NPC)var0).definition;
				if (var84.transforms != null) {
					var84 = var84.transform();
				}

				if (var84.headIconPrayer >= 0 && var84.headIconPrayer < class40.headIconPrayerSprites.length) {
					var83 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var83);
					if (Client.viewportTempX > -1) {
						class40.headIconPrayerSprites[var84.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var79] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					var83 = var0.defaultHeight + 15;
					MouseRecorder.worldToScreen(var0.x, var0.y, var83);
					if (Client.viewportTempX > -1) {
						SecureRandomCallable.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			if (var0.overheadText != null && (var1 >= var79 || !var0.field954 && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				var9 = var0.defaultHeight;
				MouseRecorder.worldToScreen(var0.x, var0.y, var9);
				if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
					Client.overheadTextXOffsets[Client.overheadTextCount] = class1.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextCount] = class1.fontBold12.ascent;
					Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
					Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
					Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
					Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
					Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
					Client.overheadText[Client.overheadTextCount] = var0.overheadText;
					++Client.overheadTextCount;
				}
			}

			for (var9 = 0; var9 < 4; ++var9) {
				var83 = var0.hitSplatCycles[var9];
				int var87 = var0.hitSplatTypes[var9];
				HitSplatDefinition var86 = null;
				int var88 = 0;
				HitSplatDefinition var89;
				if (var87 >= 0) {
					if (var83 <= Client.cycle) {
						continue;
					}

					var81 = var0.hitSplatTypes[var9];
					var89 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var81);
					HitSplatDefinition var90;
					if (var89 != null) {
						var90 = var89;
					} else {
						byte[] var91 = class49.HitSplatDefinition_archive.takeFile(32, var81);
						var89 = new HitSplatDefinition();
						if (var91 != null) {
							var89.decode(new Buffer(var91));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var89, (long)var81);
						var90 = var89;
					}

					var86 = var90;
					var88 = var90.field3328;
					if (var90 != null && var90.transforms != null) {
						var86 = var90.transform();
						if (var86 == null) {
							var0.hitSplatCycles[var9] = -1;
							continue;
						}
					}
				} else if (var83 < 0) {
					continue;
				}

				var20 = var0.hitSplatTypes2[var9];
				HitSplatDefinition var92 = null;
				HitSplatDefinition var93;
				if (var20 >= 0) {
					var93 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var20);
					if (var93 != null) {
						var89 = var93;
					} else {
						byte[] var94 = class49.HitSplatDefinition_archive.takeFile(32, var20);
						var93 = new HitSplatDefinition();
						if (var94 != null) {
							var93.decode(new Buffer(var94));
						}

						HitSplatDefinition.HitSplatDefinition_cached.put(var93, (long)var20);
						var89 = var93;
					}

					var92 = var89;
					if (var89 != null && var89.transforms != null) {
						var92 = var89.transform();
					}
				}

				if (var83 - var88 <= Client.cycle) {
					if (var86 == null) {
						var0.hitSplatCycles[var9] = -1;
					} else {
						var82 = var0.defaultHeight / 2;
						MouseRecorder.worldToScreen(var0.x, var0.y, var82);
						if (Client.viewportTempX > -1) {
							if (var9 == 1) {
								Client.viewportTempY -= 20;
							}

							if (var9 == 2) {
								Client.viewportTempX -= 15;
								Client.viewportTempY -= 10;
							}

							if (var9 == 3) {
								Client.viewportTempX += 15;
								Client.viewportTempY -= 10;
							}

							var93 = null;
							Sprite var96 = null;
							Sprite var97 = null;
							Sprite var98 = null;
							var13 = 0;
							var14 = 0;
							int var26 = 0;
							int var27 = 0;
							int var28 = 0;
							int var29 = 0;
							int var30 = 0;
							int var31 = 0;
							Sprite var32 = null;
							Sprite var33 = null;
							Sprite var34 = null;
							Sprite var35 = null;
							int var36 = 0;
							int var37 = 0;
							int var38 = 0;
							int var39 = 0;
							int var40 = 0;
							int var41 = 0;
							int var42 = 0;
							int var43 = 0;
							int var44 = 0;
							Sprite var95 = var86.method4649();
							int var45;
							if (var95 != null) {
								var13 = var95.subWidth;
								var45 = var95.subHeight;
								if (var45 > var44) {
									var44 = var45;
								}

								var28 = var95.xOffset;
							}

							var96 = var86.method4650();
							if (var96 != null) {
								var14 = var96.subWidth;
								var45 = var96.subHeight;
								if (var45 > var44) {
									var44 = var45;
								}

								var29 = var96.xOffset;
							}

							var97 = var86.method4651();
							if (var97 != null) {
								var26 = var97.subWidth;
								var45 = var97.subHeight;
								if (var45 > var44) {
									var44 = var45;
								}

								var30 = var97.xOffset;
							}

							var98 = var86.method4652();
							if (var98 != null) {
								var27 = var98.subWidth;
								var45 = var98.subHeight;
								if (var45 > var44) {
									var44 = var45;
								}

								var31 = var98.xOffset;
							}

							if (var92 != null) {
								var32 = var92.method4649();
								if (var32 != null) {
									var36 = var32.subWidth;
									var45 = var32.subHeight;
									if (var45 > var44) {
										var44 = var45;
									}

									var40 = var32.xOffset;
								}

								var33 = var92.method4650();
								if (var33 != null) {
									var37 = var33.subWidth;
									var45 = var33.subHeight;
									if (var45 > var44) {
										var44 = var45;
									}

									var41 = var33.xOffset;
								}

								var34 = var92.method4651();
								if (var34 != null) {
									var38 = var34.subWidth;
									var45 = var34.subHeight;
									if (var45 > var44) {
										var44 = var45;
									}

									var42 = var34.xOffset;
								}

								var35 = var92.method4652();
								if (var35 != null) {
									var39 = var35.subWidth;
									var45 = var35.subHeight;
									if (var45 > var44) {
										var44 = var45;
									}

									var43 = var35.xOffset;
								}
							}

							Font var46 = var86.getFont();
							if (var46 == null) {
								var46 = WorldMapData_0.fontPlain11;
							}

							Font var47;
							if (var92 != null) {
								var47 = var92.getFont();
								if (var47 == null) {
									var47 = WorldMapData_0.fontPlain11;
								}
							} else {
								var47 = WorldMapData_0.fontPlain11;
							}

							String var48 = null;
							String var49 = null;
							boolean var50 = false;
							int var51 = 0;
							var48 = var86.getString(var0.hitSplatValues[var9]);
							int var52 = var46.stringWidth(var48);
							if (var92 != null) {
								var49 = var92.getString(var0.hitSplatValues2[var9]);
								var51 = var47.stringWidth(var49);
							}

							int var53 = 0;
							int var54 = 0;
							if (var14 > 0) {
								if (var97 == null && var98 == null) {
									var53 = 1;
								} else {
									var53 = var52 / var14 + 1;
								}
							}

							if (var92 != null && var37 > 0) {
								if (var34 == null && var35 == null) {
									var54 = 1;
								} else {
									var54 = var51 / var37 + 1;
								}
							}

							int var55 = 0;
							int var56 = var55;
							if (var13 > 0) {
								var55 += var13;
							}

							var55 += 2;
							int var57 = var55;
							if (var26 > 0) {
								var55 += var26;
							}

							int var58 = var55;
							int var59 = var55;
							int var60;
							if (var14 > 0) {
								var60 = var14 * var53;
								var55 += var60;
								var59 += (var60 - var52) / 2;
							} else {
								var55 += var52;
							}

							var60 = var55;
							if (var27 > 0) {
								var55 += var27;
							}

							int var61 = 0;
							int var62 = 0;
							int var63 = 0;
							int var64 = 0;
							int var65 = 0;
							int var66;
							if (var92 != null) {
								var55 += 2;
								var61 = var55;
								if (var36 > 0) {
									var55 += var36;
								}

								var55 += 2;
								var62 = var55;
								if (var38 > 0) {
									var55 += var38;
								}

								var63 = var55;
								var65 = var55;
								if (var37 > 0) {
									var66 = var37 * var54;
									var55 += var66;
									var65 += (var66 - var51) / 2;
								} else {
									var55 += var51;
								}

								var64 = var55;
								if (var39 > 0) {
									var55 += var39;
								}
							}

							var66 = var0.hitSplatCycles[var9] - Client.cycle;
							int var67 = var86.field3323 - var66 * var86.field3323 / var86.field3328;
							int var68 = var66 * var86.field3334 / var86.field3328 + -var86.field3334;
							int var69 = var67 + (var2 + Client.viewportTempX - (var55 >> 1));
							int var70 = var3 + Client.viewportTempY - 12 + var68;
							int var71 = var70;
							int var72 = var70 + var44;
							int var73 = var70 + var86.field3338 + 15;
							int var74 = var73 - var46.maxAscent;
							int var75 = var73 + var46.maxDescent;
							if (var74 < var70) {
								var71 = var74;
							}

							if (var75 > var72) {
								var72 = var75;
							}

							int var76 = 0;
							int var77;
							int var78;
							if (var92 != null) {
								var76 = var70 + var92.field3338 + 15;
								var77 = var76 - var47.maxAscent;
								var78 = var76 + var47.maxDescent;
								if (var77 < var71) {
								}

								if (var78 > var72) {
								}
							}

							var77 = 255;
							if (var86.field3335 >= 0) {
								var77 = (var66 << 8) / (var86.field3328 - var86.field3335);
							}

							if (var77 >= 0 && var77 < 255) {
								if (var95 != null) {
									var95.drawTransAt(var56 + var69 - var28, var70, var77);
								}

								if (var97 != null) {
									var97.drawTransAt(var57 + var69 - var30, var70, var77);
								}

								if (var96 != null) {
									for (var78 = 0; var78 < var53; ++var78) {
										var96.drawTransAt(var14 * var78 + (var58 + var69 - var29), var70, var77);
									}
								}

								if (var98 != null) {
									var98.drawTransAt(var69 + var60 - var31, var70, var77);
								}

								var46.drawAlpha(var48, var69 + var59, var73, var86.textColor, 0, var77);
								if (var92 != null) {
									if (var32 != null) {
										var32.drawTransAt(var61 + var69 - var40, var70, var77);
									}

									if (var34 != null) {
										var34.drawTransAt(var69 + var62 - var42, var70, var77);
									}

									if (var33 != null) {
										for (var78 = 0; var78 < var54; ++var78) {
											var33.drawTransAt(var37 * var78 + (var63 + var69 - var41), var70, var77);
										}
									}

									if (var35 != null) {
										var35.drawTransAt(var69 + var64 - var43, var70, var77);
									}

									var47.drawAlpha(var49, var65 + var69, var76, var92.textColor, 0, var77);
								}
							} else {
								if (var95 != null) {
									var95.drawTransBgAt(var69 + var56 - var28, var70);
								}

								if (var97 != null) {
									var97.drawTransBgAt(var57 + var69 - var30, var70);
								}

								if (var96 != null) {
									for (var78 = 0; var78 < var53; ++var78) {
										var96.drawTransBgAt(var78 * var14 + (var69 + var58 - var29), var70);
									}
								}

								if (var98 != null) {
									var98.drawTransBgAt(var60 + var69 - var31, var70);
								}

								var46.draw(var48, var59 + var69, var73, var86.textColor | -16777216, 0);
								if (var92 != null) {
									if (var32 != null) {
										var32.drawTransBgAt(var61 + var69 - var40, var70);
									}

									if (var34 != null) {
										var34.drawTransBgAt(var62 + var69 - var42, var70);
									}

									if (var33 != null) {
										for (var78 = 0; var78 < var54; ++var78) {
											var33.drawTransBgAt(var37 * var78 + (var63 + var69 - var41), var70);
										}
									}

									if (var35 != null) {
										var35.drawTransBgAt(var64 + var69 - var43, var70);
									}

									var47.draw(var49, var65 + var69, var76, var92.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}
		}

	}

	static {
		cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
	}
}
