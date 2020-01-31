import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gr")
@Implements("MusicPatch")
public class MusicPatch extends Node {
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = -185966491
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1990358497
	)
	int field2488;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lcv;"
	)
	@Export("rawSounds")
	RawSound[] rawSounds;
	@ObfuscatedName("o")
	short[] field2483;
	@ObfuscatedName("e")
	byte[] field2486;
	@ObfuscatedName("i")
	byte[] field2482;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "[Lgf;"
	)
	MusicPatchNode2[] field2487;
	@ObfuscatedName("d")
	byte[] field2485;
	@ObfuscatedName("l")
	int[] field2489;

	MusicPatch(byte[] var1) {
		this.rawSounds = new RawSound[128];
		this.field2483 = new short[128];
		this.field2486 = new byte[128];
		this.field2482 = new byte[128];
		this.field2487 = new MusicPatchNode2[128];
		this.field2485 = new byte[128];
		this.field2489 = new int[128];
		Buffer var2 = new Buffer(var1);

		int var3;
		for (var3 = 0; var2.array[var3 + var2.offset] != 0; ++var3) {
		}

		byte[] var4 = new byte[var3];

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			var4[var5] = var2.readByte();
		}

		++var2.offset;
		++var3;
		var5 = var2.offset;
		var2.offset += var3;

		int var6;
		for (var6 = 0; var2.array[var6 + var2.offset] != 0; ++var6) {
		}

		byte[] var7 = new byte[var6];

		int var8;
		for (var8 = 0; var8 < var6; ++var8) {
			var7[var8] = var2.readByte();
		}

		++var2.offset;
		++var6;
		var8 = var2.offset;
		var2.offset += var6;

		int var9;
		for (var9 = 0; var2.array[var9 + var2.offset] != 0; ++var9) {
		}

		byte[] var10 = new byte[var9];

		for (int var11 = 0; var11 < var9; ++var11) {
			var10[var11] = var2.readByte();
		}

		++var2.offset;
		++var9;
		byte[] var41 = new byte[var9];
		int var12;
		int var13;
		if (var9 > 1) {
			var41[1] = 1;
			int var14 = 1;
			var12 = 2;

			for (var13 = 2; var13 < var9; ++var13) {
				int var15 = var2.readUnsignedByte();
				if (var15 == 0) {
					var14 = var12++;
				} else {
					if (var15 <= var14) {
						--var15;
					}

					var14 = var15;
				}

				var41[var13] = (byte)var14;
			}
		} else {
			var12 = var9;
		}

		MusicPatchNode2[] var42 = new MusicPatchNode2[var12];

		MusicPatchNode2 var43;
		for (var13 = 0; var13 < var42.length; ++var13) {
			var43 = var42[var13] = new MusicPatchNode2();
			int var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var43.field2402 = new byte[var16 * 2];
			}

			var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var43.field2399 = new byte[var16 * 2 + 2];
				var43.field2399[1] = 64;
			}
		}

		var13 = var2.readUnsignedByte();
		byte[] var44 = var13 > 0 ? new byte[var13 * 2] : null;
		var13 = var2.readUnsignedByte();
		byte[] var17 = var13 > 0 ? new byte[var13 * 2] : null;

		int var18;
		for (var18 = 0; var2.array[var18 + var2.offset] != 0; ++var18) {
		}

		byte[] var19 = new byte[var18];

		int var20;
		for (var20 = 0; var20 < var18; ++var20) {
			var19[var20] = var2.readByte();
		}

		++var2.offset;
		++var18;
		var20 = 0;

		int var21;
		for (var21 = 0; var21 < 128; ++var21) {
			var20 += var2.readUnsignedByte();
			this.field2483[var21] = (short)var20;
		}

		var20 = 0;

		short[] var22;
		for (var21 = 0; var21 < 128; ++var21) {
			var20 += var2.readUnsignedByte();
			var22 = this.field2483;
			var22[var21] = (short)(var22[var21] + (var20 << 8));
		}

		var21 = 0;
		int var23 = 0;
		int var24 = 0;

		int var25;
		for (var25 = 0; var25 < 128; ++var25) {
			if (var21 == 0) {
				if (var23 < var19.length) {
					var21 = var19[var23++];
				} else {
					var21 = -1;
				}

				var24 = var2.readVarInt();
			}

			var22 = this.field2483;
			var22[var25] = (short)(var22[var25] + ((var24 - 1 & 2) << 14));
			this.field2489[var25] = var24;
			--var21;
		}

		var21 = 0;
		var23 = 0;
		var25 = 0;

		int var26;
		for (var26 = 0; var26 < 128; ++var26) {
			if (this.field2489[var26] != 0) {
				if (var21 == 0) {
					if (var23 < var4.length) {
						var21 = var4[var23++];
					} else {
						var21 = -1;
					}

					var25 = var2.array[var5++] - 1;
				}

				this.field2485[var26] = (byte)var25;
				--var21;
			}
		}

		var21 = 0;
		var23 = 0;
		var26 = 0;

		for (int var27 = 0; var27 < 128; ++var27) {
			if (this.field2489[var27] != 0) {
				if (var21 == 0) {
					if (var23 < var7.length) {
						var21 = var7[var23++];
					} else {
						var21 = -1;
					}

					var26 = var2.array[var8++] + 16 << 2;
				}

				this.field2482[var27] = (byte)var26;
				--var21;
			}
		}

		var21 = 0;
		var23 = 0;
		MusicPatchNode2 var45 = null;

		int var28;
		for (var28 = 0; var28 < 128; ++var28) {
			if (this.field2489[var28] != 0) {
				if (var21 == 0) {
					var45 = var42[var41[var23]];
					if (var23 < var10.length) {
						var21 = var10[var23++];
					} else {
						var21 = -1;
					}
				}

				this.field2487[var28] = var45;
				--var21;
			}
		}

		var21 = 0;
		var23 = 0;
		var28 = 0;

		int var29;
		for (var29 = 0; var29 < 128; ++var29) {
			if (var21 == 0) {
				if (var23 < var19.length) {
					var21 = var19[var23++];
				} else {
					var21 = -1;
				}

				if (this.field2489[var29] > 0) {
					var28 = var2.readUnsignedByte() + 1;
				}
			}

			this.field2486[var29] = (byte)var28;
			--var21;
		}

		this.field2488 = var2.readUnsignedByte() + 1;

		MusicPatchNode2 var30;
		int var31;
		for (var29 = 0; var29 < var12; ++var29) {
			var30 = var42[var29];
			if (var30.field2402 != null) {
				for (var31 = 1; var31 < var30.field2402.length; var31 += 2) {
					var30.field2402[var31] = var2.readByte();
				}
			}

			if (var30.field2399 != null) {
				for (var31 = 3; var31 < var30.field2399.length - 2; var31 += 2) {
					var30.field2399[var31] = var2.readByte();
				}
			}
		}

		if (var44 != null) {
			for (var29 = 1; var29 < var44.length; var29 += 2) {
				var44[var29] = var2.readByte();
			}
		}

		if (var17 != null) {
			for (var29 = 1; var29 < var17.length; var29 += 2) {
				var17[var29] = var2.readByte();
			}
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var30 = var42[var29];
			if (var30.field2399 != null) {
				var20 = 0;

				for (var31 = 2; var31 < var30.field2399.length; var31 += 2) {
					var20 = var20 + 1 + var2.readUnsignedByte();
					var30.field2399[var31] = (byte)var20;
				}
			}
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var30 = var42[var29];
			if (var30.field2402 != null) {
				var20 = 0;

				for (var31 = 2; var31 < var30.field2402.length; var31 += 2) {
					var20 = var20 + 1 + var2.readUnsignedByte();
					var30.field2402[var31] = (byte)var20;
				}
			}
		}

		byte var32;
		int var33;
		int var34;
		int var35;
		int var36;
		byte var37;
		if (var44 != null) {
			var20 = var2.readUnsignedByte();
			var44[0] = (byte)var20;

			for (var29 = 2; var29 < var44.length; var29 += 2) {
				var20 = 1 + var20 + var2.readUnsignedByte();
				var44[var29] = (byte)var20;
			}

			var37 = var44[0];
			byte var38 = var44[1];

			for (var31 = 0; var31 < var37; ++var31) {
				this.field2486[var31] = (byte)(var38 * this.field2486[var31] + 32 >> 6);
			}

			for (var31 = 2; var31 < var44.length; var31 += 2) {
				var32 = var44[var31];
				byte var39 = var44[var31 + 1];
				var33 = var38 * (var32 - var37) + (var32 - var37) / 2;

				for (var34 = var37; var34 < var32; ++var34) {
					var35 = WorldMapLabel.method440(var33, var32 - var37);
					this.field2486[var34] = (byte)(var35 * this.field2486[var34] + 32 >> 6);
					var33 += var39 - var38;
				}

				var37 = var32;
				var38 = var39;
			}

			for (var36 = var37; var36 < 128; ++var36) {
				this.field2486[var36] = (byte)(var38 * this.field2486[var36] + 32 >> 6);
			}

			var43 = null;
		}

		if (var17 != null) {
			var20 = var2.readUnsignedByte();
			var17[0] = (byte)var20;

			for (var29 = 2; var29 < var17.length; var29 += 2) {
				var20 = var20 + 1 + var2.readUnsignedByte();
				var17[var29] = (byte)var20;
			}

			var37 = var17[0];
			int var46 = var17[1] << 1;

			for (var31 = 0; var31 < var37; ++var31) {
				var36 = var46 + (this.field2482[var31] & 255);
				if (var36 < 0) {
					var36 = 0;
				}

				if (var36 > 128) {
					var36 = 128;
				}

				this.field2482[var31] = (byte)var36;
			}

			int var47;
			for (var31 = 2; var31 < var17.length; var31 += 2) {
				var32 = var17[var31];
				var47 = var17[var31 + 1] << 1;
				var33 = var46 * (var32 - var37) + (var32 - var37) / 2;

				for (var34 = var37; var34 < var32; ++var34) {
					var35 = WorldMapLabel.method440(var33, var32 - var37);
					int var40 = var35 + (this.field2482[var34] & 255);
					if (var40 < 0) {
						var40 = 0;
					}

					if (var40 > 128) {
						var40 = 128;
					}

					this.field2482[var34] = (byte)var40;
					var33 += var47 - var46;
				}

				var37 = var32;
				var46 = var47;
			}

			for (var36 = var37; var36 < 128; ++var36) {
				var47 = var46 + (this.field2482[var36] & 255);
				if (var47 < 0) {
					var47 = 0;
				}

				if (var47 > 128) {
					var47 = 128;
				}

				this.field2482[var36] = (byte)var47;
			}

			Object var48 = null;
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var42[var29].field2404 = var2.readUnsignedByte();
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var30 = var42[var29];
			if (var30.field2402 != null) {
				var30.field2401 = var2.readUnsignedByte();
			}

			if (var30.field2399 != null) {
				var30.field2400 = var2.readUnsignedByte();
			}

			if (var30.field2404 > 0) {
				var30.field2403 = var2.readUnsignedByte();
			}
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var42[var29].field2405 = var2.readUnsignedByte();
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var30 = var42[var29];
			if (var30.field2405 > 0) {
				var30.field2398 = var2.readUnsignedByte();
			}
		}

		for (var29 = 0; var29 < var12; ++var29) {
			var30 = var42[var29];
			if (var30.field2398 > 0) {
				var30.field2406 = var2.readUnsignedByte();
			}
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ldv;[B[IB)Z",
		garbageValue = "83"
	)
	boolean method3952(SoundCache var1, byte[] var2, int[] var3) {
		boolean var4 = true;
		int var5 = 0;
		RawSound var6 = null;

		for (int var7 = 0; var7 < 128; ++var7) {
			if (var2 == null || var2[var7] != 0) {
				int var8 = this.field2489[var7];
				if (var8 != 0) {
					if (var5 != var8) {
						var5 = var8--;
						if ((var8 & 1) == 0) {
							var6 = var1.getSoundEffect(var8 >> 2, var3);
						} else {
							var6 = var1.getMusicSample(var8 >> 2, var3);
						}

						if (var6 == null) {
							var4 = false;
						}
					}

					if (var6 != null) {
						this.rawSounds[var7] = var6;
						this.field2489[var7] = 0;
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-979915375"
	)
	@Export("clear")
	void clear() {
		this.field2489 = null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-1621076022"
	)
	static int method3962(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.FRIEND_COUNT) {
			if (KeyHandler.friendSystem.field1063 == 0) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -2;
			} else if (KeyHandler.friendSystem.field1063 == 1) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.FRIEND_GETNAME) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.friendsList.getSize()) {
					Friend var6 = (Friend)KeyHandler.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var6.getName();
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var6.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETWORLD) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)KeyHandler.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETRANK) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)KeyHandler.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var4;
				if (var0 == ScriptOpcodes.FRIEND_SETRANK) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					int var8 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					BZip2State.method5833(var4, var8);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_ADD) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.addFriend(var4);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_DEL) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.removeFriend(var4);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_ADD) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.addIgnore(var4);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_DEL) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					KeyHandler.friendSystem.removeIgnore(var4);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_TEST) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var4 = MouseRecorder.method1207(var4);
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.isFriended(new Username(var4, class192.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
					if (InterfaceParent.clanChat != null) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
					if (InterfaceParent.clanChat != null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = InterfaceParent.clanChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize()) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)InterfaceParent.clanChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ((Buddy)InterfaceParent.clanChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = InterfaceParent.clanChat != null ? InterfaceParent.clanChat.minKick : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_KICKUSER) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					WorldMapID.clanKickUser(var4);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATRANK) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = InterfaceParent.clanChat != null ? InterfaceParent.clanChat.rank : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_JOINCHAT) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					GrandExchangeOfferAgeComparator.Clan_joinChat(var4);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_LEAVECHAT) {
					MenuAction.Clan_leaveChat();
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_COUNT) {
					if (!KeyHandler.friendSystem.method1857()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_GETNAME) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (KeyHandler.friendSystem.method1857() && var3 >= 0 && var3 < KeyHandler.friendSystem.ignoreList.getSize()) {
						Ignored var7 = (Ignored)KeyHandler.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var7.getName();
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var7.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_TEST) {
					var4 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
					var4 = MouseRecorder.method1207(var4);
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = KeyHandler.friendSystem.isIgnored(new Username(var4, class192.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISSELF) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize() && InterfaceParent.clanChat.get(var3).getUsername().equals(class192.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
					if (InterfaceParent.clanChat != null && InterfaceParent.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = InterfaceParent.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISFRIEND) {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize() && ((ClanMate)InterfaceParent.clanChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != ScriptOpcodes.CLAN_ISIGNORE) {
					if (var0 == 3628) {
						KeyHandler.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var5;
						if (var0 == 3629) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator1(var5));
							return 1;
						} else if (var0 == 3630) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator2(var5));
							return 1;
						} else if (var0 == 3631) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator3(var5));
							return 1;
						} else if (var0 == 3632) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator4(var5));
							return 1;
						} else if (var0 == 3633) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator5(var5));
							return 1;
						} else if (var0 == 3634) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator6(var5));
							return 1;
						} else if (var0 == 3635) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator7(var5));
							return 1;
						} else if (var0 == 3636) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator8(var5));
							return 1;
						} else if (var0 == 3637) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator9(var5));
							return 1;
						} else if (var0 == 3638) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new UserComparator10(var5));
							return 1;
						} else if (var0 == 3639) {
							KeyHandler.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							KeyHandler.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.ignoreList.addComparator(new UserComparator1(var5));
							return 1;
						} else if (var0 == 3642) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.ignoreList.addComparator(new UserComparator2(var5));
							return 1;
						} else if (var0 == 3643) {
							KeyHandler.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator1(var5));
							}

							return 1;
						} else if (var0 == 3646) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator2(var5));
							}

							return 1;
						} else if (var0 == 3647) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator3(var5));
							}

							return 1;
						} else if (var0 == 3648) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator4(var5));
							}

							return 1;
						} else if (var0 == 3649) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator5(var5));
							}

							return 1;
						} else if (var0 == 3650) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator6(var5));
							}

							return 1;
						} else if (var0 == 3651) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator7(var5));
							}

							return 1;
						} else if (var0 == 3652) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator8(var5));
							}

							return 1;
						} else if (var0 == 3653) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator9(var5));
							}

							return 1;
						} else if (var0 == 3654) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new UserComparator10(var5));
							}

							return 1;
						} else if (var0 == 3655) {
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							KeyHandler.friendSystem.friendsList.addComparator(new BuddyRankComparator(var5));
							return 1;
						} else if (var0 == 3657) {
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
							if (InterfaceParent.clanChat != null) {
								InterfaceParent.clanChat.addComparator(new BuddyRankComparator(var5));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					if (InterfaceParent.clanChat != null && var3 < InterfaceParent.clanChat.getSize() && ((ClanMate)InterfaceParent.clanChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}
}
