import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("o")
final class class2 implements class0 {
	@ObfuscatedName("ql")
	@ObfuscatedSignature(
		signature = "Lch;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkp;B)V",
		garbageValue = "95"
	)
	public void vmethod55(Object var1, Buffer var2) {
		this.method21((Long)var1, var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Ljava/lang/Object;",
		garbageValue = "1665636232"
	)
	public Object vmethod53(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lkp;I)V",
		garbageValue = "-301024958"
	)
	void method21(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lhq;",
		garbageValue = "-1693813120"
	)
	public static ServerBuild method31(int var0) {
		ServerBuild[] var1 = WorldMapID.method572();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			ServerBuild var3 = var1[var2];
			if (var0 == var3.field3108) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "-115"
	)
	static int method34(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			var4 = Varps.getWidget(var3);
		} else {
			var4 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		if (var0 == ScriptOpcodes.CC_SETSCROLLPOS) {
			class320.Interpreter_intStackSize -= 2;
			var4.scrollX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			if (var4.scrollX > var4.scrollWidth - var4.width) {
				var4.scrollX = var4.scrollWidth - var4.width;
			}

			if (var4.scrollX < 0) {
				var4.scrollX = 0;
			}

			var4.scrollY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (var4.scrollY > var4.scrollHeight - var4.height) {
				var4.scrollY = var4.scrollHeight - var4.height;
			}

			if (var4.scrollY < 0) {
				var4.scrollY = 0;
			}

			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var4.color = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var4.fill = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var4.transparencyTop = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var4.lineWid = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var4.spriteId2 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var4.spriteAngle = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var4.spriteTiling = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var4.modelType = 1;
			var4.modelId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			class320.Interpreter_intStackSize -= 6;
			var4.modelOffsetX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4.modelOffsetY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			var4.modelAngleX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			var4.modelAngleY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			var4.modelAngleZ = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 4];
			var4.modelZoom = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 5];
			NPCDefinition.invalidateWidget(var4);
			return 1;
		} else {
			int var5;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				if (var5 != var4.sequenceId) {
					var4.sequenceId = var5;
					var4.modelFrame = 0;
					var4.modelFrameCycle = 0;
					NPCDefinition.invalidateWidget(var4);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var4.modelOrthog = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var8 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				if (!var8.equals(var4.text)) {
					var4.text = var8;
					NPCDefinition.invalidateWidget(var4);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var4.fontId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				class320.Interpreter_intStackSize -= 3;
				var4.textXAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4.textYAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				var4.textLineHeight = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var4.textShadowed = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var4.outline = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var4.spriteShadow = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var4.spriteFlipV = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var4.spriteFlipH = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				class320.Interpreter_intStackSize -= 2;
				var4.scrollWidth = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4.scrollHeight = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				NPCDefinition.invalidateWidget(var4);
				if (var3 != -1 && var4.type == 0) {
					WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var3 >> 16], var4, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				WorldMapAreaData.resumePauseWidget(var4.id, var4.childIndex);
				Client.meslayerContinueWidget = var4;
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == 1122) {
				var4.spriteId = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var4.color2 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == 1124) {
				var4.transparencyBot = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				NPCDefinition.invalidateWidget(var4);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				FillMode var7 = (FillMode)WorldMapSection0.findEnumerated(ClientPreferences.FillMode_values(), var5);
				if (var7 != null) {
					var4.fillMode = var7;
					NPCDefinition.invalidateWidget(var4);
				}

				return 1;
			} else {
				boolean var6;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var6 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					var4.field2606 = var6;
					return 1;
				} else if (var0 == ScriptOpcodes.CC_SETMODELTRANSPARENT) {
					var6 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					var4.modelTransparency = var6;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "([BB)[B",
		garbageValue = "-84"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 >= 0 && (AbstractArchive.field3148 == 0 || var3 <= AbstractArchive.field3148)) {
			if (var2 == 0) {
				byte[] var6 = new byte[var3];
				var1.readBytes(var6, 0, var3);
				return var6;
			} else {
				int var4 = var1.readInt();
				if (var4 < 0 || AbstractArchive.field3148 != 0 && var4 > AbstractArchive.field3148) {
					throw new RuntimeException();
				} else {
					byte[] var5 = new byte[var4];
					if (var2 == 1) {
						BZip2Decompressor.BZip2Decompressor_decompress(var5, var4, var0, var3, 9);
					} else {
						AbstractArchive.gzipDecompressor.decompress(var1, var5);
					}

					return var5;
				}
			}
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "26"
	)
	protected static final void method24() {
		GameShell.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.clientTickTimes[var0] = 0L;
		}

		Fonts.gameCyclesToDo = 0;
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-917024322"
	)
	static void method32() {
		Client.mouseLastLastPressedTimeMillis = -1L;
		class16.mouseRecorder.index = 0;
		GrandExchangeOfferTotalQuantityComparator.hasFocus = true;
		Client.hadFocus = true;
		Client.field702 = -1L;
		GrandExchangeOfferAgeComparator.method162();
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1309 = null;
		Client.packetWriter.field1305 = null;
		Client.packetWriter.field1307 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1299 = 0;
		Client.rebootTimer = 0;
		Client.logoutTimer = 0;
		Client.hintArrowType = 0;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		MouseHandler.MouseHandler_idleCycles = 0;
		SoundSystem.method2563();
		Client.isItemSelected = 0;
		Client.isSpellSelected = false;
		Client.soundEffectCount = 0;
		Client.camAngleY = 0;
		Client.oculusOrbState = 0;
		class218.field2716 = null;
		Client.minimapState = 0;
		Client.field704 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		GrandExchangeOfferOwnWorldComparator.method1308();

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		for (var0 = 0; var0 < 32768; ++var0) {
			Client.npcs[var0] = null;
		}

		Client.combatTargetPlayerIndex = -1;
		Client.projectiles.clear();
		Client.graphicsObjects.clear();

		for (var0 = 0; var0 < 4; ++var0) {
			for (int var1 = 0; var1 < 104; ++var1) {
				for (int var2 = 0; var2 < 104; ++var2) {
					Client.groundItems[var0][var1][var2] = null;
				}
			}
		}

		Client.pendingSpawns = new NodeDeque();
		KeyHandler.friendSystem.clear();

		for (var0 = 0; var0 < VarpDefinition.VarpDefinition_fileCount; ++var0) {
			VarpDefinition var3 = Messages.VarpDefinition_get(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		class197.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			ObjectSound.method1933(Client.rootInterface);
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			class185.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.meslayerContinueWidget = null;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		WorldMapLabelSize.method198();
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field851[var0] = true;
		}

		class238.method4415();
		InterfaceParent.clanChat = null;

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		PendingSpawn.grandExchangeEvents = null;
	}
}
