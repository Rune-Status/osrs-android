import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("FloorOverlayDefinition_archive")
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("FloorOverlayDefinition_cached")
	static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 935951655
	)
	@Export("primaryRgb")
	public int primaryRgb;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1095526673
	)
	@Export("texture")
	public int texture;
	@ObfuscatedName("i")
	@Export("hideUnderlay")
	public boolean hideUnderlay;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1729092423
	)
	@Export("secondaryRgb")
	public int secondaryRgb;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -29355705
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1250783645
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1922537883
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 291644117
	)
	@Export("secondaryHue")
	public int secondaryHue;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1538627711
	)
	@Export("secondarySaturation")
	public int secondarySaturation;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1197825263
	)
	@Export("secondaryLightness")
	public int secondaryLightness;

	FloorOverlayDefinition() {
		this.primaryRgb = 0;
		this.texture = -1;
		this.hideUnderlay = true;
		this.secondaryRgb = -1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "342799854"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.secondaryRgb != -1) {
			this.setHsl(this.secondaryRgb);
			this.secondaryHue = this.hue;
			this.secondarySaturation = this.saturation;
			this.secondaryLightness = this.lightness;
		}

		this.setHsl(this.primaryRgb);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;IB)V",
		garbageValue = "-45"
	)
	@Export("decode")
	void decode(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.decodeNext(var1, var3, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;IIB)V",
		garbageValue = "16"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.primaryRgb = var1.readMedium();
		} else if (var2 == 2) {
			this.texture = var1.readUnsignedByte();
		} else if (var2 == 5) {
			this.hideUnderlay = false;
		} else if (var2 == 7) {
			this.secondaryRgb = var1.readMedium();
		} else if (var2 == 8) {
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1731410531"
	)
	@Export("setHsl")
	void setHsl(int var1) {
		double var2 = (double)(var1 >> 16 & 255) / 256.0D;
		double var4 = (double)(var1 >> 8 & 255) / 256.0D;
		double var6 = (double)(var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}

		if (var6 < var8) {
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}

		if (var6 > var10) {
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var2 == var10) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var10 == var4) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var6 == var10) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.hue = (int)(var12 * 256.0D);
		this.saturation = (int)(256.0D * var14);
		this.lightness = (int)(var16 * 256.0D);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "([Lhn;IIIIIIIIB)V",
		garbageValue = "40"
	)
	@Export("drawInterface")
	static final void drawInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();

		for (int var9 = 0; var9 < var0.length; ++var9) {
			Widget var10 = var0[var9];
			if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
				int var11;
				if (var8 == -1) {
					Client.rootWidgetXs[Client.rootWidgetCount] = var10.x + var6;
					Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.y;
					Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
					Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
					var11 = ++Client.rootWidgetCount - 1;
				} else {
					var11 = var8;
				}

				var10.rootIndex = var11;
				var10.cycle = Client.cycle;
				if (!var10.isIf3 || !VarcInt.isComponentHidden(var10)) {
					if (var10.contentType > 0) {
						GrandExchangeEvent.method93(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							Entity.field1866 = var0;
							WorldMapIcon_0.field142 = var6;
							UserComparator9.field1965 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field824) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field919) {
								var15 = Client.field919;
							}

							if (var15 + var10.width > Client.field919 + Client.clickedWidgetParent.width) {
								var15 = Client.field919 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field826) {
								var16 = Client.field826;
							}

							if (var16 + var10.height > Client.field826 + Client.clickedWidgetParent.height) {
								var16 = Client.field826 + Client.clickedWidgetParent.height - var10.height;
							}

							var12 = var15;
							var13 = var16;
						}

						if (!var10.isScrollBar) {
							var14 = 128;
						}
					}

					int var17;
					int var18;
					int var19;
					int var20;
					int var21;
					int var22;
					if (var10.type == 2) {
						var15 = var2;
						var16 = var3;
						var17 = var4;
						var18 = var5;
					} else if (var10.type == 9) {
						var22 = var12;
						var19 = var13;
						var20 = var12 + var10.width;
						var21 = var13 + var10.height;
						if (var20 < var12) {
							var22 = var20;
							var20 = var12;
						}

						if (var21 < var13) {
							var19 = var21;
							var21 = var13;
						}

						++var20;
						++var21;
						var15 = var22 > var2 ? var22 : var2;
						var16 = var19 > var3 ? var19 : var3;
						var17 = var20 < var4 ? var20 : var4;
						var18 = var21 < var5 ? var21 : var5;
					} else {
						var22 = var12 + var10.width;
						var19 = var13 + var10.height;
						var15 = var12 > var2 ? var12 : var2;
						var16 = var13 > var3 ? var13 : var3;
						var17 = var22 < var4 ? var22 : var4;
						var18 = var19 < var5 ? var19 : var5;
					}

					if (!var10.isIf3 || var15 < var17 && var16 < var18) {
						if (var10.contentType != 0) {
							if (var10.contentType == 1336) {
								if (Client.displayFps) {
									var13 += 15;
									class13.fontPlain12.drawRightAligned("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var34 = Runtime.getRuntime();
									var19 = (int)((var34.totalMemory() - var34.freeMemory()) / 1024L);
									var20 = 16776960;
									if (var19 > 327680 && !Client.isLowDetail) {
										var20 = 16711680;
									}

									class13.fontPlain12.drawRightAligned("Mem:" + var19 + "k", var12 + var10.width, var13, var20, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								WorldMapSection1.drawEntities(var12, var13, var10.width, var10.height);
								Client.field851[var10.rootIndex] = true;
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								WorldMapRegion.drawMinimap(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								UserComparator8.drawCompass(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								WorldMapIcon_0.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								WorldMapIcon_0.worldMap.drawOverview(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								WorldMapLabelSize.loginScreenRunesAnimation.draw(var12, Client.cycle);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && VarcInt.isComponentHidden(var10) && var10 != GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1) {
								continue;
							}

							if (!var10.isIf3) {
								if (var10.scrollY > var10.scrollHeight - var10.height) {
									var10.scrollY = var10.scrollHeight - var10.height;
								}

								if (var10.scrollY < 0) {
									var10.scrollY = 0;
								}
							}

							drawInterface(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							if (var10.children != null) {
								drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							}

							InterfaceParent var23 = (InterfaceParent)Client.interfaceParents.get((long)var10.id);
							if (var23 != null) {
								ServerPacket.drawWidgets(var23.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
						}

						if (Client.isResizable || Client.field853[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								WorldMapRectangle.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
							}

							if (var10.type != 1) {
								int var24;
								int var25;
								int var26;
								int var33;
								if (var10.type == 2) {
									var22 = 0;

									for (var19 = 0; var19 < var10.rawHeight; ++var19) {
										for (var20 = 0; var20 < var10.rawWidth; ++var20) {
											var21 = var20 * (var10.paddingX + 32) + var12;
											var33 = var19 * (var10.paddingY + 32) + var13;
											if (var22 < 20) {
												var21 += var10.inventoryXOffsets[var22];
												var33 += var10.inventoryYOffsets[var22];
											}

											if (var10.itemIds[var22] <= 0) {
												if (var10.inventorySprites != null && var22 < 20) {
													Sprite var36 = var10.getInventorySprite(var22);
													if (var36 != null) {
														var36.drawTransBgAt(var21, var33);
													} else if (Widget.field2697) {
														NPCDefinition.invalidateWidget(var10);
													}
												}
											} else {
												boolean var35 = false;
												boolean var46 = false;
												var26 = var10.itemIds[var22] - 1;
												if (var21 + 32 > var2 && var21 < var4 && var33 + 32 > var3 && var33 < var5 || var10 == class185.dragInventoryWidget && var22 == Client.dragItemSlotSource) {
													Sprite var42;
													if (Client.isItemSelected == 1 && var22 == class65.selectedItemSlot && var10.id == FriendSystem.selectedItemWidget) {
														var42 = AttackOption.getItemSprite(var26, var10.itemQuantities[var22], 2, 0, 2, false);
													} else {
														var42 = AttackOption.getItemSprite(var26, var10.itemQuantities[var22], 1, 3153952, 2, false);
													}

													if (var42 != null) {
														if (var10 == class185.dragInventoryWidget && var22 == Client.dragItemSlotSource) {
															var24 = MouseHandler.MouseHandler_x - Client.draggedWidgetX;
															var25 = MouseHandler.MouseHandler_y - Client.draggedWidgetY;
															if (var24 < 5 && var24 > -5) {
																var24 = 0;
															}

															if (var25 < 5 && var25 > -5) {
																var25 = 0;
															}

															if (Client.itemDragDuration < 5) {
																var24 = 0;
																var25 = 0;
															}

															var42.drawTransAt(var21 + var24, var25 + var33, 128);
															if (var1 != -1) {
																Widget var47 = var0[var1 & 65535];
																int var45;
																if (var25 + var33 < Rasterizer2D.Rasterizer2D_yClipStart && var47.scrollY > 0) {
																	var45 = (Rasterizer2D.Rasterizer2D_yClipStart - var33 - var25) * Client.field707 / 3;
																	if (var45 > Client.field707 * 10) {
																		var45 = Client.field707 * 10;
																	}

																	if (var45 > var47.scrollY) {
																		var45 = var47.scrollY;
																	}

																	var47.scrollY -= var45;
																	Client.draggedWidgetY += var45;
																	NPCDefinition.invalidateWidget(var47);
																}

																if (var25 + var33 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var47.scrollY < var47.scrollHeight - var47.height) {
																	var45 = (var33 + var25 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field707 / 3;
																	if (var45 > Client.field707 * 10) {
																		var45 = Client.field707 * 10;
																	}

																	if (var45 > var47.scrollHeight - var47.height - var47.scrollY) {
																		var45 = var47.scrollHeight - var47.height - var47.scrollY;
																	}

																	var47.scrollY += var45;
																	Client.draggedWidgetY -= var45;
																	NPCDefinition.invalidateWidget(var47);
																}
															}
														} else if (var10 == Skeleton.field1793 && var22 == Client.field752) {
															var42.drawTransAt(var21, var33, 128);
														} else {
															var42.drawTransBgAt(var21, var33);
														}
													} else {
														NPCDefinition.invalidateWidget(var10);
													}
												}
											}

											++var22;
										}
									}
								} else if (var10.type == 3) {
									if (ScriptFrame.runCs1(var10)) {
										var22 = var10.color2;
										if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var22 = var10.mouseOverColor2;
										}
									} else {
										var22 = var10.color;
										if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
											var22 = var10.mouseOverColor;
										}
									}

									if (var10.fill) {
										switch(var10.fillMode.value) {
										case 1:
											Rasterizer2D.Rasterizer2D_fillRectangleGradient(var12, var13, var10.width, var10.height, var10.color, var10.color2);
											break;
										case 2:
											Rasterizer2D.Rasterizer2D_fillRectangleGradientAlpha(var12, var13, var10.width, var10.height, var10.color, var10.color2, 255 - (var10.transparencyTop & 255), 255 - (var10.transparencyBot & 255));
											break;
										default:
											if (var14 == 0) {
												Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var22);
											} else {
												Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var12, var13, var10.width, var10.height, var22, 256 - (var14 & 255));
											}
										}
									} else if (var14 == 0) {
										Rasterizer2D.Rasterizer2D_drawRectangle(var12, var13, var10.width, var10.height, var22);
									} else {
										Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var22, 256 - (var14 & 255));
									}
								} else {
									Font var27;
									if (var10.type == 4) {
										var27 = var10.getFont();
										if (var27 == null) {
											if (Widget.field2697) {
												NPCDefinition.invalidateWidget(var10);
											}
										} else {
											String var38 = var10.text;
											if (ScriptFrame.runCs1(var10)) {
												var19 = var10.color2;
												if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
													var19 = var10.mouseOverColor2;
												}

												if (var10.text2.length() > 0) {
													var38 = var10.text2;
												}
											} else {
												var19 = var10.color;
												if (var10 == GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
													var19 = var10.mouseOverColor;
												}
											}

											if (var10.isIf3 && var10.itemId != -1) {
												ItemDefinition var41 = HealthBarDefinition.ItemDefinition_get(var10.itemId);
												var38 = var41.name;
												if (var38 == null) {
													var38 = "null";
												}

												if ((var41.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
													var38 = PacketWriter.colorStartTag(16748608) + var38 + "</col> " + 'x' + WorldMapCacheName.formatItemStacks(var10.itemQuantity);
												}
											}

											if (var10 == Client.meslayerContinueWidget) {
												var38 = "Please wait...";
												var19 = var10.color;
											}

											if (!var10.isIf3) {
												var38 = MouseHandler.method1096(var38, var10);
											}

											var27.drawLines(var38, var12, var13, var10.width, var10.height, var19, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
										}
									} else if (var10.type == 5) {
										Sprite var37;
										if (!var10.isIf3) {
											var37 = var10.getSprite(ScriptFrame.runCs1(var10));
											if (var37 != null) {
												var37.drawTransBgAt(var12, var13);
											} else if (Widget.field2697) {
												NPCDefinition.invalidateWidget(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var37 = AttackOption.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var37 = var10.getSprite(false);
											}

											if (var37 == null) {
												if (Widget.field2697) {
													NPCDefinition.invalidateWidget(var10);
												}
											} else {
												var19 = var37.width;
												var20 = var37.height;
												if (!var10.spriteTiling) {
													var21 = var10.width * 4096 / var19;
													if (var10.spriteAngle != 0) {
														var37.method6210(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var21);
													} else if (var14 != 0) {
														var37.drawTransScaledAt(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
													} else if (var19 == var10.width && var20 == var10.height) {
														var37.drawTransBgAt(var12, var13);
													} else {
														var37.drawScaledAt(var12, var13, var10.width, var10.height);
													}
												} else {
													Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
													var21 = (var19 - 1 + var10.width) / var19;
													var33 = (var20 - 1 + var10.height) / var20;

													for (var24 = 0; var24 < var21; ++var24) {
														for (var25 = 0; var25 < var33; ++var25) {
															if (var10.spriteAngle != 0) {
																var37.method6210(var19 / 2 + var12 + var24 * var19, var20 / 2 + var13 + var20 * var25, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var37.drawTransAt(var12 + var24 * var19, var13 + var20 * var25, 256 - (var14 & 255));
															} else {
																var37.drawTransBgAt(var12 + var24 * var19, var13 + var25 * var20);
															}
														}
													}

													Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
												}
											}
										}
									} else {
										ItemDefinition var28;
										if (var10.type == 6) {
											boolean var40 = ScriptFrame.runCs1(var10);
											if (var40) {
												var19 = var10.sequenceId2;
											} else {
												var19 = var10.sequenceId;
											}

											Model var43 = null;
											var21 = 0;
											if (var10.itemId != -1) {
												var28 = HealthBarDefinition.ItemDefinition_get(var10.itemId);
												if (var28 != null) {
													var28 = var28.getCountObj(var10.itemQuantity);
													var43 = var28.getModel(1);
													if (var43 != null) {
														var43.calculateBoundsCylinder();
														var21 = var43.height / 2;
													} else {
														NPCDefinition.invalidateWidget(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var43 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var43 = class192.localPlayer.getModel();
												}
											} else if (var19 == -1) {
												var43 = var10.getModel((SequenceDefinition)null, -1, var40, class192.localPlayer.appearance);
												if (var43 == null && Widget.field2697) {
													NPCDefinition.invalidateWidget(var10);
												}
											} else {
												SequenceDefinition var44 = GraphicsDefaults.SequenceDefinition_get(var19);
												var43 = var10.getModel(var44, var10.modelFrame, var40, class192.localPlayer.appearance);
												if (var43 == null && Widget.field2697) {
													NPCDefinition.invalidateWidget(var10);
												}
											}

											Rasterizer3D.method3101(var10.width / 2 + var12, var10.height / 2 + var13);
											var33 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var43 != null) {
												if (!var10.isIf3) {
													var43.method2946(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var33, var24);
												} else {
													var43.calculateBoundsCylinder();
													if (var10.modelOrthog) {
														var43.method2938(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var21 + var33 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var43.method2946(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var33 + var21 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.Rasterizer3D_method3();
										} else {
											if (var10.type == 7) {
												var27 = var10.getFont();
												if (var27 == null) {
													if (Widget.field2697) {
														NPCDefinition.invalidateWidget(var10);
													}
													continue;
												}

												var19 = 0;

												for (var20 = 0; var20 < var10.rawHeight; ++var20) {
													for (var21 = 0; var21 < var10.rawWidth; ++var21) {
														if (var10.itemIds[var19] > 0) {
															var28 = HealthBarDefinition.ItemDefinition_get(var10.itemIds[var19] - 1);
															String var29;
															if (var28.isStackable != 1 && var10.itemQuantities[var19] == 1) {
																var29 = PacketWriter.colorStartTag(16748608) + var28.name + "</col>";
															} else {
																var29 = PacketWriter.colorStartTag(16748608) + var28.name + "</col> " + 'x' + WorldMapCacheName.formatItemStacks(var10.itemQuantities[var19]);
															}

															var25 = var12 + var21 * (var10.paddingX + 115);
															var26 = (var10.paddingY + 12) * var20 + var13;
															if (var10.textXAlignment == 0) {
																var27.draw(var29, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else if (var10.textXAlignment == 1) {
																var27.drawCentered(var29, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
															} else {
																var27.drawRightAligned(var29, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
															}
														}

														++var19;
													}
												}
											}

											if (var10.type == 8 && var10 == VarbitDefinition.field3296 && Client.field796 == Client.field797) {
												var22 = 0;
												var19 = 0;
												Font var39 = class13.fontPlain12;
												String var30 = var10.text;

												String var31;
												for (var30 = MouseHandler.method1096(var30, var10); var30.length() > 0; var19 = var19 + var39.ascent + 1) {
													var24 = var30.indexOf("<br>");
													if (var24 != -1) {
														var31 = var30.substring(0, var24);
														var30 = var30.substring(var24 + 4);
													} else {
														var31 = var30;
														var30 = "";
													}

													var25 = var39.stringWidth(var31);
													if (var25 > var22) {
														var22 = var25;
													}
												}

												var22 += 6;
												var19 += 7;
												var24 = var12 + var10.width - 5 - var22;
												var25 = var13 + var10.height + 5;
												if (var24 < var12 + 5) {
													var24 = var12 + 5;
												}

												if (var24 + var22 > var4) {
													var24 = var4 - var22;
												}

												if (var19 + var25 > var5) {
													var25 = var5 - var19;
												}

												Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var22, var19, 16777120);
												Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var22, var19, 0);
												var30 = var10.text;
												var26 = var25 + var39.ascent + 2;

												for (var30 = MouseHandler.method1096(var30, var10); var30.length() > 0; var26 = var26 + var39.ascent + 1) {
													int var32 = var30.indexOf("<br>");
													if (var32 != -1) {
														var31 = var30.substring(0, var32);
														var30 = var30.substring(var32 + 4);
													} else {
														var31 = var30;
														var30 = "";
													}

													var39.draw(var31, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2606) {
													var22 = var12;
													var19 = var13 + var10.height;
													var20 = var12 + var10.width;
													var21 = var13;
												} else {
													var22 = var12;
													var19 = var13;
													var20 = var12 + var10.width;
													var21 = var13 + var10.height;
												}

												if (var10.lineWid == 1) {
													Rasterizer2D.Rasterizer2D_drawLine(var22, var19, var20, var21, var10.color);
												} else {
													GrandExchangeOfferWorldComparator.method74(var22, var19, var20, var21, var10.color, var10.lineWid);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-825352084"
	)
	public static boolean method4835() {
		return Client.staffModLevel >= 2;
	}

	static {
		FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}
}
