import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	field3454(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(1, 1),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	field3451(2, 2);

	@ObfuscatedName("p")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1955816399
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -458653859
	)
	@Export("id")
	final int id;

	private HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)[Llt;",
		garbageValue = "831261948"
	)
	public static Sprite[] method4783() {
		Sprite[] var0 = new Sprite[class326.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class326.SpriteBuffer_spriteCount; ++var1) {
			Sprite var2 = var0[var1] = new Sprite();
			var2.width = GZipDecompressor.SpriteBuffer_spriteWidth;
			var2.height = class326.SpriteBuffer_spriteHeight;
			var2.xOffset = Huffman.SpriteBuffer_xOffsets[var1];
			var2.yOffset = NPC.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class326.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class326.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subHeight * var2.subWidth;
			byte[] var4 = class326.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = class326.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		DynamicObject.method2292();
		return var0;
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(Liz;IIII)V",
		garbageValue = "1310795801"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPCDefinition var0, int var1, int var2, int var3) {
		if (Client.menuOptionsCount < 400) {
			if (var0.transforms != null) {
				var0 = var0.transform();
			}

			if (var0 != null && var0.isInteractable && (!var0.isFollower || Client.followerIndex == var1)) {
				String var4 = var0.name;
				int var5;
				int var6;
				int var7;
				if (var0.combatLevel != 0) {
					var5 = var0.combatLevel;
					var6 = class192.localPlayer.combatLevel;
					var7 = var6 - var5;
					String var8;
					if (var7 < -9) {
						var8 = PacketWriter.colorStartTag(16711680);
					} else if (var7 < -6) {
						var8 = PacketWriter.colorStartTag(16723968);
					} else if (var7 < -3) {
						var8 = PacketWriter.colorStartTag(16740352);
					} else if (var7 < 0) {
						var8 = PacketWriter.colorStartTag(16756736);
					} else if (var7 > 9) {
						var8 = PacketWriter.colorStartTag(65280);
					} else if (var7 > 6) {
						var8 = PacketWriter.colorStartTag(4259584);
					} else if (var7 > 3) {
						var8 = PacketWriter.colorStartTag(8453888);
					} else if (var7 > 0) {
						var8 = PacketWriter.colorStartTag(12648192);
					} else {
						var8 = PacketWriter.colorStartTag(16776960);
					}

					var4 = var4 + var8 + "  (level-" + var0.combatLevel + ")";
				}

				if (var0.isFollower && Client.followerOpsLowPriority) {
					GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
				}

				if (Client.isItemSelected == 1) {
					GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " -> " + PacketWriter.colorStartTag(16776960) + var4, 7, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((NetSocket.selectedSpellFlags & 2) == 2) {
						GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + PacketWriter.colorStartTag(16776960) + var4, 8, var1, var2, var3);
					}
				} else {
					var7 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
					String[] var10 = var0.actions;
					if (var10 != null) {
						for (var5 = 4; var5 >= 0; --var5) {
							if (var10[var5] != null && !var10[var5].equalsIgnoreCase("Attack")) {
								var6 = 0;
								if (var5 == 0) {
									var6 = var7 + 9;
								}

								if (var5 == 1) {
									var6 = var7 + 10;
								}

								if (var5 == 2) {
									var6 = var7 + 11;
								}

								if (var5 == 3) {
									var6 = var7 + 12;
								}

								if (var5 == 4) {
									var6 = var7 + 13;
								}

								GraphicsObject.insertMenuItemNoShift(var10[var5], PacketWriter.colorStartTag(16776960) + var4, var6, var1, var2, var3);
							}
						}
					}

					if (var10 != null) {
						for (var5 = 4; var5 >= 0; --var5) {
							if (var10[var5] != null && var10[var5].equalsIgnoreCase("Attack")) {
								short var9 = 0;
								if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
									if (Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class192.localPlayer.combatLevel) {
										var9 = 2000;
									}

									var6 = 0;
									if (var5 == 0) {
										var6 = var9 + 9;
									}

									if (var5 == 1) {
										var6 = var9 + 10;
									}

									if (var5 == 2) {
										var6 = var9 + 11;
									}

									if (var5 == 3) {
										var6 = var9 + 12;
									}

									if (var5 == 4) {
										var6 = var9 + 13;
									}

									GraphicsObject.insertMenuItemNoShift(var10[var5], PacketWriter.colorStartTag(16776960) + var4, var6, var1, var2, var3);
								}
							}
						}
					}

					if (!var0.isFollower || !Client.followerOpsLowPriority) {
						GraphicsObject.insertMenuItemNoShift("Examine", PacketWriter.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
					}
				}
			}
		}

	}
}
