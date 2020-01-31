import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2146402029
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2085039341
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 555505141
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1856751623
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2086851217
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1346820565
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1459523587
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -954702965
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1622063887
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2070491231
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1112408651
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -749966597
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1079927535
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 524547303
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.oldZ + this.newZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
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
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
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
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
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
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-127"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([Lgq;IB)Lgq;",
		garbageValue = "-32"
	)
	@Export("findEnumerated")
	public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
		Enumerated[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Enumerated var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(IIIIIIIS)V",
		garbageValue = "6328"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != Clock.Client_plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = ServerBuild.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = ServerBuild.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = ServerBuild.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = ServerBuild.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (var7 != 0L) {
				var12 = ServerBuild.scene.getObjectFlags(var0, var2, var3, var7);
				int var13 = GrandExchangeEvents.Entity_unpackID(var7);
				int var14 = var12 & 31;
				int var15 = var12 >> 6 & 3;
				ObjectDefinition var16;
				if (var1 == 0) {
					ServerBuild.scene.removeBoundaryObject(var0, var2, var3);
					var16 = Occluder.getObjectDefinition(var13);
					if (var16.interactType != 0) {
						Client.collisionMaps[var0].method3621(var2, var3, var14, var15, var16.boolean1);
					}
				}

				if (var1 == 1) {
					ServerBuild.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					ServerBuild.scene.removeGameObject(var0, var2, var3);
					var16 = Occluder.getObjectDefinition(var13);
					if (var2 + var16.sizeX > 103 || var3 + var16.sizeX > 103 || var2 + var16.sizeY > 103 || var3 + var16.sizeY > 103) {
						return;
					}

					if (var16.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var16.sizeX, var16.sizeY, var15, var16.boolean1);
					}
				}

				if (var1 == 3) {
					ServerBuild.scene.removeFloorDecoration(var0, var2, var3);
					var16 = Occluder.getObjectDefinition(var13);
					if (var16.interactType == 1) {
						Client.collisionMaps[var0].method3624(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				ArchiveLoader.method1168(var0, var12, var2, var3, var4, var5, var6, ServerBuild.scene, Client.collisionMaps[var0]);
			}
		}

	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "683461450"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			GraphicsObject.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;
		int var8 = 0;

		while (true) {
			int var9 = ViewportMouse.ViewportMouse_entityCount;
			if (var8 >= var9) {
				if (var4 != -1L) {
					var8 = GrandExchangeEvent.method96(var4);
					int var28 = class14.method169(var4);
					Player var11 = Client.players[Client.combatTargetPlayerIndex];
					class191.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var28);
				}

				return;
			}

			long var10 = VertexNormal.method3063(var8);
			if (var10 != var6) {
				label276: {
					var6 = var10;
					int var12 = GrandExchangeOffer.method128(var8);
					int var13 = class43.method816(var8);
					int var14 = Tile.method2926(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var15 = GrandExchangeEvents.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var16 = var15;
					int var19;
					if (var14 == 2 && ServerBuild.scene.getObjectFlags(Clock.Client_plane, var12, var13, var10) >= 0) {
						ObjectDefinition var17 = Occluder.getObjectDefinition(var15);
						if (var17.transforms != null) {
							var17 = var17.transform();
						}

						if (var17 == null) {
							break label276;
						}

						if (Client.isItemSelected == 1) {
							GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " -> " + PacketWriter.colorStartTag(65535) + var17.name, 1, var15, var12, var13);
						} else if (Client.isSpellSelected) {
							if ((NetSocket.selectedSpellFlags & 4) == 4) {
								GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + PacketWriter.colorStartTag(65535) + var17.name, 2, var15, var12, var13);
							}
						} else {
							String[] var18 = var17.actions;
							if (var18 != null) {
								for (var19 = 4; var19 >= 0; --var19) {
									if (var18[var19] != null) {
										short var20 = 0;
										if (var19 == 0) {
											var20 = 3;
										}

										if (var19 == 1) {
											var20 = 4;
										}

										if (var19 == 2) {
											var20 = 5;
										}

										if (var19 == 3) {
											var20 = 6;
										}

										if (var19 == 4) {
											var20 = 1001;
										}

										GraphicsObject.insertMenuItemNoShift(var18[var19], PacketWriter.colorStartTag(65535) + var17.name, var20, var16, var12, var13);
									}
								}
							}

							GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(65535) + var17.name, 1002, var17.id, var12, var13);
						}
					}

					int[] var21;
					Player var29;
					NPC var30;
					int var32;
					if (var14 == 1) {
						NPC var22 = Client.npcs[var16];
						if (var22 == null) {
							break label276;
						}

						if (var22.definition.size == 1 && (var22.x & 127) == 64 && (var22.y & 127) == 64) {
							for (var19 = 0; var19 < Client.npcCount; ++var19) {
								var30 = Client.npcs[Client.npcIndices[var19]];
								if (var30 != null && var30 != var22 && var30.definition.size == 1 && var30.x == var22.x && var22.y == var30.y) {
									HorizontalAlignment.addNpcToMenu(var30.definition, Client.npcIndices[var19], var12, var13);
								}
							}

							var19 = Players.Players_count;
							var21 = Players.Players_indices;

							for (var32 = 0; var32 < var19; ++var32) {
								var29 = Client.players[var21[var32]];
								if (var29 != null && var29.x == var22.x && var29.y == var22.y) {
									class191.addPlayerToMenu(var29, var21[var32], var12, var13);
								}
							}
						}

						HorizontalAlignment.addNpcToMenu(var22.definition, var16, var12, var13);
					}

					if (var14 == 0) {
						Player var31 = Client.players[var16];
						if (var31 == null) {
							break label276;
						}

						if ((var31.x & 127) == 64 && (var31.y & 127) == 64) {
							for (var19 = 0; var19 < Client.npcCount; ++var19) {
								var30 = Client.npcs[Client.npcIndices[var19]];
								if (var30 != null && var30.definition.size == 1 && var30.x == var31.x && var30.y == var31.y) {
									HorizontalAlignment.addNpcToMenu(var30.definition, Client.npcIndices[var19], var12, var13);
								}
							}

							var19 = Players.Players_count;
							var21 = Players.Players_indices;

							for (var32 = 0; var32 < var19; ++var32) {
								var29 = Client.players[var21[var32]];
								if (var29 != null && var31 != var29 && var29.x == var31.x && var31.y == var29.y) {
									class191.addPlayerToMenu(var29, var21[var32], var12, var13);
								}
							}
						}

						if (var16 != Client.combatTargetPlayerIndex) {
							class191.addPlayerToMenu(var31, var16, var12, var13);
						} else {
							var4 = var10;
						}
					}

					if (var14 == 3) {
						NodeDeque var33 = Client.groundItems[Clock.Client_plane][var12][var13];
						if (var33 != null) {
							for (TileItem var23 = (TileItem)var33.first(); var23 != null; var23 = (TileItem)var33.next()) {
								ItemDefinition var24 = HealthBarDefinition.ItemDefinition_get(var23.id);
								if (Client.isItemSelected == 1) {
									GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " -> " + PacketWriter.colorStartTag(16748608) + var24.name, 16, var23.id, var12, var13);
								} else if (Client.isSpellSelected) {
									if ((NetSocket.selectedSpellFlags & 1) == 1) {
										GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + PacketWriter.colorStartTag(16748608) + var24.name, 17, var23.id, var12, var13);
									}
								} else {
									String[] var25 = var24.groundActions;

									for (int var26 = 4; var26 >= 0; --var26) {
										if (var25 != null && var25[var26] != null) {
											byte var27 = 0;
											if (var26 == 0) {
												var27 = 18;
											}

											if (var26 == 1) {
												var27 = 19;
											}

											if (var26 == 2) {
												var27 = 20;
											}

											if (var26 == 3) {
												var27 = 21;
											}

											if (var26 == 4) {
												var27 = 22;
											}

											GraphicsObject.insertMenuItemNoShift(var25[var26], PacketWriter.colorStartTag(16748608) + var24.name, var27, var23.id, var12, var13);
										} else if (var26 == 2) {
											GraphicsObject.insertMenuItemNoShift("Take", PacketWriter.colorStartTag(16748608) + var24.name, 20, var23.id, var12, var13);
										}
									}

									GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(16748608) + var24.name, 1004, var23.id, var12, var13);
								}
							}
						}
					}
				}
			}

			++var8;
		}
	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "([Lhn;IB)V",
		garbageValue = "2"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						class226.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var6;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var6 = new ScriptEvent();
					var6.widget = var3;
					var6.args = var3.onDialogAbort;
					class4.runScriptEvent(var6);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var5 = Varps.getWidget(var3.id);
						if (var5 == null || var5.children == null || var3.childIndex >= var5.children.length || var3 != var5.children[var3.childIndex]) {
							continue;
						}
					}

					var6 = new ScriptEvent();
					var6.widget = var3;
					var6.args = var3.onSubChange;
					class4.runScriptEvent(var6);
				}
			}
		}

	}
}
