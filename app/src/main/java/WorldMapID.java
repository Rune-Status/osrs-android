import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("au")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	static final WorldMapID field277;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	static final WorldMapID field278;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -632156307
	)
	@Export("value")
	final int value;

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lhq;",
		garbageValue = "1911999829"
	)
	static ServerBuild[] method572() {
		return new ServerBuild[]{ServerBuild.RC, ServerBuild.BUILDLIVE, ServerBuild.WIP, ServerBuild.LIVE};
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lbw;IB)V",
		garbageValue = "0"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var4;
		if (Username.isWorldMapEvent(var0.type)) {
			WorldMapLabelSize.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var5 = PacketBufferNode.WorldMapElement_get(WorldMapLabelSize.worldMapEvent.mapElement);
			var3 = class197.getWorldMapScript(var0.type, var5.objectId, var5.category);
		} else {
			var4 = (Integer)var2[0];
			var3 = UserComparator9.getScript(var4);
		}

		if (var3 != null) {
			class320.Interpreter_intStackSize = 0;
			Message.Interpreter_stringStackSize = 0;
			var4 = -1;
			int[] var25 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1094 = false;

			try {
				int var8;
				try {
					Interpreter.Interpreter_intLocals = new int[var3.localIntCount];
					int var9 = 0;
					Interpreter.Interpreter_stringLocals = new String[var3.localStringCount];
					int var26 = 0;

					int var11;
					String var12;
					for (var8 = 1; var8 < var2.length; ++var8) {
						if (var2[var8] instanceof Integer) {
							var11 = (Integer)var2[var8];
							if (var11 == -2147483647) {
								var11 = var0.mouseX;
							}

							if (var11 == -2147483646) {
								var11 = var0.mouseY;
							}

							if (var11 == -2147483645) {
								var11 = var0.widget != null ? var0.widget.id : -1;
							}

							if (var11 == -2147483644) {
								var11 = var0.opIndex;
							}

							if (var11 == -2147483643) {
								var11 = var0.widget != null ? var0.widget.childIndex : -1;
							}

							if (var11 == -2147483642) {
								var11 = var0.dragTarget != null ? var0.dragTarget.id : -1;
							}

							if (var11 == -2147483641) {
								var11 = var0.dragTarget != null ? var0.dragTarget.childIndex : -1;
							}

							if (var11 == -2147483640) {
								var11 = var0.keyTyped;
							}

							if (var11 == -2147483639) {
								var11 = var0.keyPressed;
							}

							Interpreter.Interpreter_intLocals[var9++] = var11;
						} else if (var2[var8] instanceof String) {
							var12 = (String)var2[var8];
							if (var12.equals("event_opbase")) {
								var12 = var0.targetName;
							}

							Interpreter.Interpreter_stringLocals[var26++] = var12;
						}
					}

					var8 = 0;
					Interpreter.field1088 = var0.field582;

					while (true) {
						++var8;
						if (var8 > var1) {
							throw new RuntimeException();
						}

						++var4;
						int var13 = var25[var4];
						int var14;
						if (var13 >= 100) {
							boolean var32;
							if (var3.intOperands[var4] == 1) {
								var32 = true;
							} else {
								var32 = false;
							}

							var14 = LoginScreenAnimation.method1835(var13, var3, var32);
							switch(var14) {
							case 0:
								return;
							case 1:
							default:
								break;
							case 2:
								throw new IllegalStateException();
							}
						} else if (var13 == 0) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6[var4];
						} else if (var13 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var4];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var13 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var4];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							ServerPacket.changeGameOptions(var11);
						} else if (var13 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.stringOperands[var4];
						} else if (var13 == ScriptOpcodes.JUMP) {
							var4 += var6[var4];
						} else if (var13 == ScriptOpcodes.IF_ICMPNE) {
							class320.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]) {
								var4 += var6[var4];
							}
						} else if (var13 == ScriptOpcodes.IF_ICMPEQ) {
							class320.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]) {
								var4 += var6[var4];
							}
						} else if (var13 == ScriptOpcodes.IF_ICMPLT) {
							class320.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]) {
								var4 += var6[var4];
							}
						} else if (var13 == ScriptOpcodes.IF_ICMPGT) {
							class320.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]) {
								var4 += var6[var4];
							}
						} else if (var13 == ScriptOpcodes.RETURN) {
							if (Interpreter.Interpreter_frameDepth == 0) {
								return;
							}

							ScriptFrame var30 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
							var3 = var30.script;
							var25 = var3.opcodes;
							var6 = var3.intOperands;
							var4 = var30.pc;
							Interpreter.Interpreter_intLocals = var30.intLocals;
							Interpreter.Interpreter_stringLocals = var30.stringLocals;
						} else if (var13 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var4];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.getVarbit(var11);
						} else if (var13 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var4];
							DirectByteArrayCopier.method4006(var11, Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
						} else if (var13 == ScriptOpcodes.IF_ICMPLE) {
							class320.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]) {
								var4 += var6[var4];
							}
						} else if (var13 == ScriptOpcodes.IF_ICMPGE) {
							class320.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]) {
								var4 += var6[var4];
							}
						} else if (var13 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var6[var4]];
						} else if (var13 == ScriptOpcodes.ISTORE) {
							Interpreter.Interpreter_intLocals[var6[var4]] = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						} else if (var13 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var6[var4]];
						} else if (var13 == ScriptOpcodes.SSTORE) {
							Interpreter.Interpreter_stringLocals[var6[var4]] = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
						} else if (var13 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var4];
							Message.Interpreter_stringStackSize -= var11;
							String var29 = class290.method5360(Interpreter.Interpreter_stringStack, Message.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var29;
						} else if (var13 == ScriptOpcodes.POP_INT) {
							--class320.Interpreter_intStackSize;
						} else if (var13 == ScriptOpcodes.POP_STRING) {
							--Message.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var13 != ScriptOpcodes.INVOKE) {
								if (var13 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class197.varcs.getInt(var6[var4]);
								} else if (var13 == ScriptOpcodes.SET_VARC_INT) {
									class197.varcs.setInt(var6[var4], Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
								} else if (var13 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var4] >> 16;
									var14 = var6[var4] & 65535;
									int var28 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
									if (var28 < 0 || var28 > 5000) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrayLengths[var11] = var28;
									byte var33 = -1;
									if (var14 == 105) {
										var33 = 0;
									}

									for (var15 = 0; var15 < var28; ++var15) {
										Interpreter.Interpreter_arrays[var11][var15] = var33;
									}
								} else if (var13 == ScriptOpcodes.GET_ARRAY_INT) {
									var11 = var6[var4];
									var14 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
									if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var14];
								} else if (var13 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var4];
									class320.Interpreter_intStackSize -= 2;
									var14 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
									if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var14] = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
								} else if (var13 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var12 = class197.varcs.getStringOld(var6[var4]);
									if (var12 == null) {
										var12 = "null";
									}

									Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var12;
								} else if (var13 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									class197.varcs.setStringOld(var6[var4], Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize]);
								} else if (var13 == ScriptOpcodes.GET_VARC_STRING) {
									var12 = class197.varcs.getString(var6[var4]);
									Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var12;
								} else if (var13 == ScriptOpcodes.SET_VARC_STRING) {
									class197.varcs.setString(var6[var4], Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize]);
								} else {
									if (var13 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var27 = var3.switches[var6[var4]];
									IntegerNode var31 = (IntegerNode)var27.get((long)Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
									if (var31 != null) {
										var4 += var31.integer;
									}
								}
							} else {
								var11 = var6[var4];
								Script var16 = UserComparator9.getScript(var11);
								int[] var17 = new int[var16.localIntCount];
								String[] var18 = new String[var16.localStringCount];

								for (var15 = 0; var15 < var16.intArgumentCount; ++var15) {
									var17[var15] = Interpreter.Interpreter_intStack[var15 + (class320.Interpreter_intStackSize - var16.intArgumentCount)];
								}

								for (var15 = 0; var15 < var16.stringArgumentCount; ++var15) {
									var18[var15] = Interpreter.Interpreter_stringStack[var15 + (Message.Interpreter_stringStackSize - var16.stringArgumentCount)];
								}

								class320.Interpreter_intStackSize -= var16.intArgumentCount;
								Message.Interpreter_stringStackSize -= var16.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var4;
								var19.intLocals = Interpreter.Interpreter_intLocals;
								var19.stringLocals = Interpreter.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var16;
								var25 = var16.opcodes;
								var6 = var16.intOperands;
								var4 = -1;
								Interpreter.Interpreter_intLocals = var17;
								Interpreter.Interpreter_stringLocals = var18;
							}
						}
					}
				} catch (Exception var23) {
					StringBuilder var10 = new StringBuilder(30);
					var10.append("").append(var3.key).append(" ");

					for (var8 = Interpreter.Interpreter_frameDepth - 1; var8 >= 0; --var8) {
						var10.append("").append(Interpreter.Interpreter_frames[var8].script.key).append(" ");
					}

					var10.append("").append(var7);
					class225.RunException_sendStackTrace(var10.toString(), var23);
				}
			} finally {
				if (Interpreter.field1094) {
					Interpreter.field1095 = true;
					KeyHandler.method848();
					Interpreter.field1095 = false;
					Interpreter.field1094 = false;
				}

			}
		}
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1853943165"
	)
	static final String method570(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1218090205"
	)
	@Export("FriendSystem_invalidateFriends")
	static final void FriendSystem_invalidateFriends() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		Message.method1228();
		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.clearFriends();
		}

	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1990682337"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (InterfaceParent.clanChat != null) {
			PacketBufferNode var1 = TilePaint.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}

	}

	static {
		field277 = new WorldMapID(0);
		field278 = new WorldMapID(1);
	}
}
