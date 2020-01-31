import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("GrandExchangeOfferAgeComparator")
final class GrandExchangeOfferAgeComparator implements Comparator {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("EnumDefinition_archive")
	public static AbstractArchive EnumDefinition_archive;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ll;Ll;I)I",
		garbageValue = "1533624032"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.age < var2.age ? -1 : (var2.age == var1.age ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-370455307"
	)
	public static void method162() {
		class96.reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "([Lhn;IIIIIIII)V",
		garbageValue = "-442172669"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || WorldMapIcon_0.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
				if (var9.isIf3) {
					if (VarcInt.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 && VarcInt.isComponentHidden(var9)) {
					continue;
				}

				int var10 = var9.x + var6;
				int var11 = var7 + var9.y;
				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				if (var9.type == 2) {
					var12 = var2;
					var13 = var3;
					var14 = var4;
					var15 = var5;
				} else {
					int var18;
					if (var9.type == 9) {
						var18 = var10;
						var16 = var11;
						var17 = var10 + var9.width;
						int var19 = var11 + var9.height;
						if (var17 < var10) {
							var18 = var17;
							var17 = var10;
						}

						if (var19 < var11) {
							var16 = var19;
							var19 = var11;
						}

						++var17;
						++var19;
						var12 = var18 > var2 ? var18 : var2;
						var13 = var16 > var3 ? var16 : var3;
						var14 = var17 < var4 ? var17 : var4;
						var15 = var19 < var5 ? var19 : var5;
					} else {
						var18 = var10 + var9.width;
						var16 = var11 + var9.height;
						var12 = var10 > var2 ? var10 : var2;
						var13 = var11 > var3 ? var11 : var3;
						var14 = var18 < var4 ? var18 : var4;
						var15 = var16 < var5 ? var16 : var5;
					}
				}

				if (var9 == Client.clickedWidget) {
					Client.field827 = true;
					Client.field864 = var10;
					Client.field829 = var11;
				}

				boolean var28 = false;
				if (var9.field2646) {
					switch(Client.field808) {
					case 0:
						var28 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field664 == var9.id >>> 16) {
							var28 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field664) {
							var28 = true;
						}
					}
				}

				if (var28 || !var9.isIf3 || var12 < var14 && var13 < var15) {
					if (var9.isIf3) {
						ScriptEvent var29;
						if (var9.noClickThrough) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								for (var29 = (ScriptEvent)Client.scriptEvents.last(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.previous()) {
									if (var29.isMouseInputEvent) {
										var29.remove();
										var29.widget.containsMouse = false;
									}
								}

								if (SequenceDefinition.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									class96.addCancelMenuEntry();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var29 = (ScriptEvent)Client.scriptEvents.last(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.previous()) {
								if (var29.isMouseInputEvent && var29.widget.onScroll == var29.args) {
									var29.remove();
								}
							}
						}
					}

					var16 = MouseHandler.MouseHandler_x;
					var17 = MouseHandler.MouseHandler_y;
					if (MouseHandler.MouseHandler_lastButton != 0) {
						var16 = MouseHandler.MouseHandler_lastPressedX;
						var17 = MouseHandler.MouseHandler_lastPressedY;
					}

					boolean var30 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
					if (var9.contentType == 1337) {
						if (!Client.isLoading && !Client.isMenuOpen && var30) {
							WorldMapSection0.addSceneMenuOptions(var16, var17, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						class267.checkIfMinimapClicked(var9, var10, var11);
					} else {
						if (var9.contentType == 1400) {
							WorldMapIcon_0.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var30, var10, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var30) {
							if (var9.contentType == 1400) {
								WorldMapIcon_0.worldMap.addElementMenuOptions(var10, var11, var9.width, var9.height, var16, var17);
							} else {
								ViewportMouse.method3060(var9, var16 - var10, var17 - var11);
							}
						}

						boolean var20;
						int var21;
						if (var28) {
							for (int var22 = 0; var22 < var9.field2702.length; ++var22) {
								var20 = false;
								boolean var23 = false;
								if (!var20 && var9.field2702[var22] != null) {
									for (var21 = 0; var21 < var9.field2702[var22].length; ++var21) {
										boolean var24 = false;
										if (var9.field2711 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field2702[var22][var21]];
										}

										if (MusicPatchNode.method3902(var9.field2702[var22][var21]) || var24) {
											var20 = true;
											if (var9.field2711 != null && var9.field2711[var22] > Client.cycle) {
												break;
											}

											byte var25 = var9.field2648[var22][var21];
											if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var23 = true;
												break;
											}
										}
									}
								}

								if (var23) {
									if (var22 < 10) {
										NPC.widgetDefaultMenuAction(var22 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var22 == 10) {
										WorldMapManager.Widget_runOnTargetLeave();
										MusicPatchNode.selectSpell(var9.id, var9.childIndex, class83.method2108(WorldMapIcon_0.getWidgetClickMask(var9)), var9.itemId);
										Client.selectedSpellActionName = PcmPlayer.method2542(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + PacketWriter.colorStartTag(16777215);
									}

									var21 = var9.field2649[var22];
									if (var9.field2711 == null) {
										var9.field2711 = new int[var9.field2702.length];
									}

									if (var9.field2560 == null) {
										var9.field2560 = new int[var9.field2702.length];
									}

									if (var21 != 0) {
										if (var9.field2711[var22] == 0) {
											var9.field2711[var22] = var21 + Client.cycle + var9.field2560[var22];
										} else {
											var9.field2711[var22] = var21 + Client.cycle;
										}
									} else {
										var9.field2711[var22] = Integer.MAX_VALUE;
									}
								}

								if (!var20 && var9.field2711 != null) {
									var9.field2711[var22] = 0;
								}
							}
						}

						ScriptEvent var32;
						if (var9.isIf3) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								var30 = true;
							} else {
								var30 = false;
							}

							boolean var31 = false;
							if ((MouseHandler.MouseHandler_currentButton == 1 || !ArchiveLoader.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var30) {
								var31 = true;
							}

							var20 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !ArchiveLoader.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var20 = true;
							}

							if (var20) {
								Strings.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.contentType == 1400) {
								WorldMapIcon_0.worldMap.method6363(var16, var17, var30 & var31, var30 & var20);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var30 && GrandExchangeOfferWorldComparator.method76(WorldMapIcon_0.getWidgetClickMask(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field824 = true;
								Client.field919 = var10;
								Client.field826 = var11;
							}

							if (var9.hasListener) {
								if (var30 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var32 = new ScriptEvent();
									var32.isMouseInputEvent = true;
									var32.widget = var9;
									var32.mouseY = Client.mouseWheelRotation;
									var32.args = var9.onScroll;
									Client.scriptEvents.addFirst(var32);
								}

								if (Client.clickedWidget != null || class185.dragInventoryWidget != null || Client.isMenuOpen) {
									var20 = false;
									var31 = false;
									var30 = false;
								}

								if (!var9.isClicked && var20) {
									var9.isClicked = true;
									if (var9.onClick != null) {
										var32 = new ScriptEvent();
										var32.isMouseInputEvent = true;
										var32.widget = var9;
										var32.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
										var32.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var32.args = var9.onClick;
										Client.scriptEvents.addFirst(var32);
									}
								}

								if (var9.isClicked && var31 && var9.onClickRepeat != null) {
									var32 = new ScriptEvent();
									var32.isMouseInputEvent = true;
									var32.widget = var9;
									var32.mouseX = MouseHandler.MouseHandler_x - var10;
									var32.mouseY = MouseHandler.MouseHandler_y - var11;
									var32.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var32);
								}

								if (var9.isClicked && !var31) {
									var9.isClicked = false;
									if (var9.onRelease != null) {
										var32 = new ScriptEvent();
										var32.isMouseInputEvent = true;
										var32.widget = var9;
										var32.mouseX = MouseHandler.MouseHandler_x - var10;
										var32.mouseY = MouseHandler.MouseHandler_y - var11;
										var32.args = var9.onRelease;
										Client.field847.addFirst(var32);
									}
								}

								if (var31 && var9.onHold != null) {
									var32 = new ScriptEvent();
									var32.isMouseInputEvent = true;
									var32.widget = var9;
									var32.mouseX = MouseHandler.MouseHandler_x - var10;
									var32.mouseY = MouseHandler.MouseHandler_y - var11;
									var32.args = var9.onHold;
									Client.scriptEvents.addFirst(var32);
								}

								if (!var9.containsMouse && var30) {
									var9.containsMouse = true;
									if (var9.onMouseOver != null) {
										var32 = new ScriptEvent();
										var32.isMouseInputEvent = true;
										var32.widget = var9;
										var32.mouseX = MouseHandler.MouseHandler_x - var10;
										var32.mouseY = MouseHandler.MouseHandler_y - var11;
										var32.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var32);
									}
								}

								if (var9.containsMouse && var30 && var9.onMouseRepeat != null) {
									var32 = new ScriptEvent();
									var32.isMouseInputEvent = true;
									var32.widget = var9;
									var32.mouseX = MouseHandler.MouseHandler_x - var10;
									var32.mouseY = MouseHandler.MouseHandler_y - var11;
									var32.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var32);
								}

								if (var9.containsMouse && !var30) {
									var9.containsMouse = false;
									if (var9.onMouseLeave != null) {
										var32 = new ScriptEvent();
										var32.isMouseInputEvent = true;
										var32.widget = var9;
										var32.mouseX = MouseHandler.MouseHandler_x - var10;
										var32.mouseY = MouseHandler.MouseHandler_y - var11;
										var32.args = var9.onMouseLeave;
										Client.field847.addFirst(var32);
									}
								}

								if (var9.onTimer != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.onTimer;
									Client.field846.addFirst(var32);
								}

								int var26;
								ScriptEvent var34;
								int var35;
								if (var9.onVarTransmit != null && Client.field833 > var9.field2706) {
									if (var9.varTransmitTriggers != null && Client.field833 - var9.field2706 <= 32) {
										label590:
										for (var35 = var9.field2706; var35 < Client.field833; ++var35) {
											var21 = Client.field832[var35 & 31];

											for (var26 = 0; var26 < var9.varTransmitTriggers.length; ++var26) {
												if (var21 == var9.varTransmitTriggers[var26]) {
													var34 = new ScriptEvent();
													var34.widget = var9;
													var34.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var34);
													break label590;
												}
											}
										}
									} else {
										var32 = new ScriptEvent();
										var32.widget = var9;
										var32.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var32);
									}

									var9.field2706 = Client.field833;
								}

								if (var9.onInvTransmit != null && Client.field835 > var9.field2570) {
									if (var9.invTransmitTriggers != null && Client.field835 - var9.field2570 <= 32) {
										label566:
										for (var35 = var9.field2570; var35 < Client.field835; ++var35) {
											var21 = Client.changedItemContainers[var35 & 31];

											for (var26 = 0; var26 < var9.invTransmitTriggers.length; ++var26) {
												if (var21 == var9.invTransmitTriggers[var26]) {
													var34 = new ScriptEvent();
													var34.widget = var9;
													var34.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var34);
													break label566;
												}
											}
										}
									} else {
										var32 = new ScriptEvent();
										var32.widget = var9;
										var32.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var32);
									}

									var9.field2570 = Client.field835;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2708) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2708 <= 32) {
										label542:
										for (var35 = var9.field2708; var35 < Client.changedSkillsCount; ++var35) {
											var21 = Client.changedSkills[var35 & 31];

											for (var26 = 0; var26 < var9.statTransmitTriggers.length; ++var26) {
												if (var21 == var9.statTransmitTriggers[var26]) {
													var34 = new ScriptEvent();
													var34.widget = var9;
													var34.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var34);
													break label542;
												}
											}
										}
									} else {
										var32 = new ScriptEvent();
										var32.widget = var9;
										var32.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var32);
									}

									var9.field2708 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field2705 && var9.onChatTransmit != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var32);
								}

								if (Client.field839 > var9.field2705 && var9.onFriendTransmit != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var32);
								}

								if (Client.field823 > var9.field2705 && var9.onClanTransmit != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var32);
								}

								if (Client.field841 > var9.field2705 && var9.onStockTransmit != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var32);
								}

								if (Client.field842 > var9.field2705 && var9.field2674 != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.field2674;
									Client.scriptEvents.addFirst(var32);
								}

								if (Client.field795 > var9.field2705 && var9.onMiscTransmit != null) {
									var32 = new ScriptEvent();
									var32.widget = var9;
									var32.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var32);
								}

								var9.field2705 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var35 = 0; var35 < Client.field762; ++var35) {
										ScriptEvent var27 = new ScriptEvent();
										var27.widget = var9;
										var27.keyTyped = Client.field869[var35];
										var27.keyPressed = Client.field868[var35];
										var27.args = var9.onKey;
										Client.scriptEvents.addFirst(var27);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || class185.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									GrandExchangeOfferUnitPriceComparator.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								VarbitDefinition.field3296 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								VarcInt.method4485(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var33 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var33 != null) {
								if (var33.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (var32 = (ScriptEvent)Client.scriptEvents.last(); var32 != null; var32 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var32.isMouseInputEvent) {
											var32.remove();
											var32.widget.containsMouse = false;
										}
									}

									if (SequenceDefinition.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										class96.addCancelMenuEntry();
									}
								}

								WorldMapDecoration.updateRootInterface(var33.group, var12, var13, var14, var15, var10, var11);
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1093482480"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = TilePaint.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}

	}
}
