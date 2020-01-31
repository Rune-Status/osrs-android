import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("eg")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("x")
	static int[][][] field1940;
	@ObfuscatedName("c")
	@Export("url")
	final URL url;
	@ObfuscatedName("t")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("o")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "41"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)[B",
		garbageValue = "0"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "72"
	)
	static void method3375() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				class2.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				class2.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "416833363"
	)
	static int method3382(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = Clock.Client_plane;
			int var13 = Messages.baseX * 64 + (class192.localPlayer.x >> 7);
			int var16 = Language.baseY * 64 + (class192.localPlayer.y >> 7);
			GrandExchangeOfferUnitPriceComparator.getWorldMap().method6371(var3, var13, var16, true);
			return 1;
		} else {
			WorldMapArea var4;
			if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				String var14 = "";
				var4 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
				if (var4 != null) {
					var14 = var4.getExternalName();
				}

				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var14;
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				GrandExchangeOfferUnitPriceComparator.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				GrandExchangeOfferUnitPriceComparator.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var5;
				if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
					var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().setWorldMapPositionTarget(var5.x, var5.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
					var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().setWorldMapPositionTargetInstant(var5.x, var5.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
					var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().jumpToSourceCoord(var5.plane, var5.x, var5.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
					var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					GrandExchangeOfferUnitPriceComparator.getWorldMap().jumpToSourceCoordInstant(var5.plane, var5.x, var5.y);
					return 1;
				} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayX();
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var6;
					if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var6 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getOrigin().packed();
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var6 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (var6.getRegionHighX() - var6.getRegionLowX() + 1) * 64;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = (var6.getRegionHighY() - var6.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var6 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getRegionLowX() * 64;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getRegionLowY() * 64;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getRegionHighX() * 64 + 64 - 1;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
						if (var6 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var5 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayCoord();
						if (var5 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var5.x;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var5.y;
						}

						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
						var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
						var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getCurrentMapArea();
						if (var6 == null) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var15 = var6.position(var5.plane, var5.x, var5.y);
							if (var15 == null) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15[0];
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var15[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
							var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getCurrentMapArea();
							if (var6 == null) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var6.coord(var5.x, var5.y);
								if (var7 == null) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var8;
							if (var0 == 6619) {
								class320.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
								var8 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
								WorldMapData_1.method731(var3, var8, false);
								return 1;
							} else if (var0 == 6620) {
								class320.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
								var8 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
								WorldMapData_1.method731(var3, var8, true);
								return 1;
							} else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
								class320.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
								var8 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
								var4 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var3);
								if (var4 == null) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4.containsCoord(var8.plane, var8.x, var8.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayWith();
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var5 = new Coord(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								var6 = GrandExchangeOfferUnitPriceComparator.getWorldMap().mapAreaAtCoord(var5.plane, var5.x, var5.y);
								if (var6 == null) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								GrandExchangeOfferUnitPriceComparator.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var9;
								if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
									var9 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
									GrandExchangeOfferUnitPriceComparator.getWorldMap().setPerpetualFlash(var9);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
									var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
									GrandExchangeOfferUnitPriceComparator.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
									var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
									GrandExchangeOfferUnitPriceComparator.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
									GrandExchangeOfferUnitPriceComparator.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
									var9 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
									GrandExchangeOfferUnitPriceComparator.getWorldMap().setElementsDisabled(var9);
									return 1;
								} else {
									boolean var10;
									if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
										class320.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
										var10 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1] == 1;
										GrandExchangeOfferUnitPriceComparator.getWorldMap().disableElement(var3, var10);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
										class320.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
										var10 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1] == 1;
										GrandExchangeOfferUnitPriceComparator.getWorldMap().setCategoryDisabled(var3, var10);
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
										Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
										var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
										var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										class320.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
										var8 = new Coord(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
										var7 = GrandExchangeOfferUnitPriceComparator.getWorldMap().method6411(var3, var8);
										if (var7 == null) {
											Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var11;
										if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
											var11 = GrandExchangeOfferUnitPriceComparator.getWorldMap().iconStart();
											if (var11 == null) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var11.getElement();
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var11.coord2.packed();
											}

											return 1;
										} else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
											var11 = GrandExchangeOfferUnitPriceComparator.getWorldMap().iconNext();
											if (var11 == null) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var11.getElement();
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var11.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var12;
											if (var0 == ScriptOpcodes.MEC_TEXT) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var12 = PacketBufferNode.WorldMapElement_get(var3);
												if (var12.name == null) {
													Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var12.name;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var12 = PacketBufferNode.WorldMapElement_get(var3);
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var12.textSize;
												return 1;
											} else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var12 = PacketBufferNode.WorldMapElement_get(var3);
												if (var12 == null) {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var12.category;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.MEC_SPRITE) {
												var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
												var12 = PacketBufferNode.WorldMapElement_get(var3);
												if (var12 == null) {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var12.sprite1;
												}

												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENT) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapLabelSize.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapLabelSize.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == ScriptOpcodes.WORLDMAP_ELEMENTCOORD) {
												Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapLabelSize.worldMapEvent.coord2.packed();
												return 1;
											} else {
												return 2;
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

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "124"
	)
	static final boolean method3383(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}
