import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ba")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("appearance")
	PlayerAppearance appearance;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -791182983
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -2135485127
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("g")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1334071439
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 31608153
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -595586759
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 492199091
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1158770925
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1060371069
	)
	int field622;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1973913223
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -89254999
	)
	int field620;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 94473955
	)
	int field626;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1646253599
	)
	int field627;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 18993525
	)
	int field628;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1302670611
	)
	int field629;
	@ObfuscatedName("y")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1851536029
	)
	@Export("team")
	int team;
	@ObfuscatedName("b")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 418590373
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -895014683
	)
	@Export("index")
	int index;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("ae")
	boolean field621;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 1551600703
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 212383731
	)
	@Export("tileY")
	int tileY;

	Player() {
		this.headIconPk = -1;
		this.headIconPrayer = -1;
		this.actions = new String[3];

		for (int var1 = 0; var1 < 3; ++var1) {
			this.actions[var1] = "";
		}

		this.combatLevel = 0;
		this.skillLevel = 0;
		this.animationCycleStart = 0;
		this.animationCycleEnd = 0;
		this.isUnanimated = false;
		this.team = 0;
		this.isHidden = false;
		this.isFriendTriBool = TriBool.TriBool_unknown;
		this.isInClanChat = TriBool.TriBool_unknown;
		this.field621 = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "20"
	)
	@Export("read")
	final void read(Buffer var1) {
		var1.offset = 0;
		int var2 = var1.readUnsignedByte();
		this.headIconPk = var1.readByte();
		this.headIconPrayer = var1.readByte();
		int var3 = -1;
		this.team = 0;
		int[] var4 = new int[12];

		int var5;
		int var6;
		for (int var7 = 0; var7 < 12; ++var7) {
			var5 = var1.readUnsignedByte();
			if (var5 == 0) {
				var4[var7] = 0;
			} else {
				var6 = var1.readUnsignedByte();
				var4[var7] = var6 + (var5 << 8);
				if (var7 == 0 && var4[0] == 65535) {
					var3 = var1.readUnsignedShort();
					break;
				}

				if (var4[var7] >= 512) {
					int var8 = HealthBarDefinition.ItemDefinition_get(var4[var7] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var5 = 0; var5 < 5; ++var5) {
			var6 = var1.readUnsignedByte();
			if (var6 < 0 || var6 >= PlayerAppearance.field2545[var5].length) {
				var6 = 0;
			}

			var9[var5] = var6;
		}

		super.readySequence = var1.readUnsignedShort();
		if (super.readySequence == 65535) {
			super.readySequence = -1;
		}

		super.turnLeftSequence = var1.readUnsignedShort();
		if (super.turnLeftSequence == 65535) {
			super.turnLeftSequence = -1;
		}

		super.turnRightSequence = super.turnLeftSequence;
		super.walkSequence = var1.readUnsignedShort();
		if (super.walkSequence == 65535) {
			super.walkSequence = -1;
		}

		super.walkBackSequence = var1.readUnsignedShort();
		if (super.walkBackSequence == 65535) {
			super.walkBackSequence = -1;
		}

		super.walkLeftSequence = var1.readUnsignedShort();
		if (super.walkLeftSequence == 65535) {
			super.walkLeftSequence = -1;
		}

		super.walkRightSequence = var1.readUnsignedShort();
		if (super.walkRightSequence == 65535) {
			super.walkRightSequence = -1;
		}

		super.runSequence = var1.readUnsignedShort();
		if (super.runSequence == 65535) {
			super.runSequence = -1;
		}

		this.username = new Username(var1.readStringCp1252NullTerminated(), class192.loginType);
		this.clearIsFriend();
		this.clearIsInClanChat();
		if (this == class192.localPlayer) {
			RunException.localPlayerName = this.username.getName();
		}

		this.combatLevel = var1.readUnsignedByte();
		this.skillLevel = var1.readUnsignedShort();
		this.isHidden = var1.readUnsignedByte() == 1;
		if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
			this.isHidden = false;
		}

		if (this.appearance == null) {
			this.appearance = new PlayerAppearance();
		}

		this.appearance.update(var4, var9, var2 == 1, var3);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1723343174"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-55"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-379994373"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = KeyHandler.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1808500524"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "752660623"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2107067145"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		this.isInClanChat = InterfaceParent.clanChat != null && InterfaceParent.clanChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2147227009"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? NetCache.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ldx;",
		garbageValue = "-2133076860"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? GraphicsDefaults.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.readySequence && var1 != null ? null : GraphicsDefaults.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var4 = class65.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field980, 0);
						var5 = new Model[]{var3, var4};
						var3 = new Model(var5, 2);
					}
				}

				if (!this.isUnanimated && this.model0 != null) {
					if (Client.cycle >= this.animationCycleEnd) {
						this.model0 = null;
					}

					if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
						var4 = this.model0;
						var4.offsetBy(this.field622 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field620 * 4096 - super.y);
						if (super.orientation == 512) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var4.rotateY90Ccw();
						}

						var5 = new Model[]{var3, var4};
						var3 = new Model(var5, 2);
						if (super.orientation == 512) {
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						}

						var4.offsetBy(super.x - this.field622 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field620 * 4096);
					}
				}

				var3.isSingleTile = true;
				return var3;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIBB)V",
		garbageValue = "74"
	)
	final void method1266(int var1, int var2, byte var3) {
		if (super.sequence != -1 && GraphicsDefaults.SequenceDefinition_get(super.sequence).field3524 == 1) {
			super.sequence = -1;
		}

		super.field967 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					Player var4 = this;
					int var5 = super.pathX[0];
					int var6 = super.pathY[0];
					int var7 = this.transformedSize();
					if (var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
						int var8 = this.transformedSize();
						Client.field809.approxDestinationX = var1;
						Client.field809.approxDestinationY = var2;
						Client.field809.approxDestinationSizeX = 1;
						Client.field809.approxDestinationSizeY = 1;
						class65 var9 = Client.field809;
						CollisionMap var10 = Client.collisionMaps[this.plane];
						int[] var11 = Client.field920;
						int[] var12 = Client.field921;
						int var13 = 0;

						label199:
						while (true) {
							int var14;
							if (var13 >= 128) {
								boolean var15;
								if (var8 == 1) {
									var15 = UserList.method5167(var5, var6, var9, var10);
								} else if (var8 == 2) {
									var15 = World.method1770(var5, var6, var9, var10);
								} else {
									var15 = WorldMapDecoration.method346(var5, var6, var8, var9, var10);
								}

								int var16;
								label220: {
									var14 = var5 - 64;
									int var17 = var6 - 64;
									int var18 = ChatChannel.field1289;
									int var19 = class173.field2093;
									int var20;
									int var21;
									int var22;
									byte var23;
									int var24;
									if (!var15) {
										var20 = Integer.MAX_VALUE;
										var21 = Integer.MAX_VALUE;
										var23 = 10;
										var22 = var9.approxDestinationX;
										var24 = var9.approxDestinationY;
										int var25 = var9.approxDestinationSizeX;
										int var26 = var9.approxDestinationSizeY;

										for (int var27 = var22 - var23; var27 <= var22 + var23; ++var27) {
											for (int var28 = var24 - var23; var28 <= var24 + var23; ++var28) {
												int var29 = var27 - var14;
												int var30 = var28 - var17;
												if (var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class173.distances[var29][var30] < 100) {
													int var31 = 0;
													if (var27 < var22) {
														var31 = var22 - var27;
													} else if (var27 > var22 + var25 - 1) {
														var31 = var27 - (var22 + var25 - 1);
													}

													int var32 = 0;
													if (var28 < var24) {
														var32 = var24 - var28;
													} else if (var28 > var24 + var26 - 1) {
														var32 = var28 - (var26 + var24 - 1);
													}

													int var33 = var31 * var31 + var32 * var32;
													if (var33 < var20 || var33 == var20 && class173.distances[var29][var30] < var21) {
														var20 = var33;
														var21 = class173.distances[var29][var30];
														var18 = var27;
														var19 = var28;
													}
												}
											}
										}

										if (var20 == Integer.MAX_VALUE) {
											var16 = -1;
											break label220;
										}
									}

									if (var18 == var5 && var19 == var6) {
										var16 = 0;
									} else {
										var23 = 0;
										class173.bufferX[var23] = var18;
										var20 = var23 + 1;
										class173.bufferY[var23] = var19;

										for (var21 = var24 = class173.directions[var18 - var14][var19 - var17]; var18 != var5 || var6 != var19; var21 = class173.directions[var18 - var14][var19 - var17]) {
											if (var21 != var24) {
												var24 = var21;
												class173.bufferX[var20] = var18;
												class173.bufferY[var20++] = var19;
											}

											if ((var21 & 2) != 0) {
												++var18;
											} else if ((var21 & 8) != 0) {
												--var18;
											}

											if ((var21 & 1) != 0) {
												++var19;
											} else if ((var21 & 4) != 0) {
												--var19;
											}
										}

										var22 = 0;

										while (var20-- > 0) {
											var11[var22] = class173.bufferX[var20];
											var12[var22++] = class173.bufferY[var20];
											if (var22 >= var11.length) {
												break;
											}
										}

										var16 = var22;
									}
								}

								var13 = var16;
								if (var16 < 1) {
									break;
								}

								var14 = 0;

								while (true) {
									if (var14 >= var13 - 1) {
										break label199;
									}

									var4.method1268(Client.field920[var14], Client.field921[var14], (byte)2);
									++var14;
								}
							}

							for (var14 = 0; var14 < 128; ++var14) {
								class173.directions[var13][var14] = 0;
								class173.distances[var13][var14] = 99999999;
							}

							++var13;
						}
					}
				}

				this.method1268(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1389622886"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field998 = 0;
		super.field997 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = var3 * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIBI)V",
		garbageValue = "1525296434"
	)
	final void method1268(int var1, int var2, byte var3) {
		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var4 = super.pathLength; var4 > 0; --var4) {
			super.pathX[var4] = super.pathX[var4 - 1];
			super.pathY[var4] = super.pathY[var4 - 1];
			super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
		}

		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.pathTraversed[0] = var3;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-515224238"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "348475587"
	)
	static int method1300(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		String var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var8 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var8.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var8[var7] = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
			} else {
				var8[var7] = new Integer(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
		if (var7 != -1) {
			var8[0] = new Integer(var7);
		} else {
			var8 = null;
		}

		if (var0 == ScriptOpcodes.CC_SETONCLICK) {
			var3.onClick = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONHOLD) {
			var3.onHold = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONRELEASE) {
			var3.onRelease = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEOVER) {
			var3.onMouseOver = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSELEAVE) {
			var3.onMouseLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAG) {
			var3.onDrag = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETLEAVE) {
			var3.onTargetLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONVARTRANSMIT) {
			var3.onVarTransmit = var8;
			var3.varTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTIMER) {
			var3.onTimer = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONOP) {
			var3.onOp = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAGCOMPLETE) {
			var3.onDragComplete = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLICKREPEAT) {
			var3.onClickRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEREPEAT) {
			var3.onMouseRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONINVTRANSMIT) {
			var3.onInvTransmit = var8;
			var3.invTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONSTATTRANSMIT) {
			var3.onStatTransmit = var8;
			var3.statTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETENTER) {
			var3.onTargetEnter = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSCROLLWHEEL) {
			var3.onScroll = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCHATTRANSMIT) {
			var3.onChatTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONKEY) {
			var3.onKey = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONFRIENDTRANSMIT) {
			var3.onFriendTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLANTRANSMIT) {
			var3.onClanTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMISCTRANSMIT) {
			var3.onMiscTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDIALOGABORT) {
			var3.onDialogAbort = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSUBCHANGE) {
			var3.onSubChange = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSTOCKTRANSMIT) {
			var3.onStockTransmit = var8;
		} else if (var0 == 1426) {
			var3.field2674 = var8;
		} else {
			if (var0 != ScriptOpcodes.CC_SETONRESIZE) {
				return 2;
			}

			var3.onResize = var8;
		}

		var3.hasListener = true;
		return 1;
	}
}
