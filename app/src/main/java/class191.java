import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class191 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	static final class191 field2370;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	static final class191 field2368;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	static final class191 field2373;

	class191() {
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		signature = "(Lba;IIII)V",
		garbageValue = "-390194357"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (class192.localPlayer != var0 && Client.menuOptionsCount < 400) {
			String var4;
			int var5;
			if (var0.skillLevel == 0) {
				String var6 = var0.actions[0] + var0.username + var0.actions[1];
				var5 = var0.combatLevel;
				int var7 = class192.localPlayer.combatLevel;
				int var8 = var7 - var5;
				String var9;
				if (var8 < -9) {
					var9 = PacketWriter.colorStartTag(16711680);
				} else if (var8 < -6) {
					var9 = PacketWriter.colorStartTag(16723968);
				} else if (var8 < -3) {
					var9 = PacketWriter.colorStartTag(16740352);
				} else if (var8 < 0) {
					var9 = PacketWriter.colorStartTag(16756736);
				} else if (var8 > 9) {
					var9 = PacketWriter.colorStartTag(65280);
				} else if (var8 > 6) {
					var9 = PacketWriter.colorStartTag(4259584);
				} else if (var8 > 3) {
					var9 = PacketWriter.colorStartTag(8453888);
				} else if (var8 > 0) {
					var9 = PacketWriter.colorStartTag(12648192);
				} else {
					var9 = PacketWriter.colorStartTag(16776960);
				}

				var4 = var6 + var9 + "  (level-" + var0.combatLevel + ")" + var0.actions[2];
			} else {
				var4 = var0.actions[0] + var0.username + var0.actions[1] + "  (skill-" + var0.skillLevel + ")" + var0.actions[2];
			}

			int var10;
			if (Client.isItemSelected == 1) {
				GraphicsObject.insertMenuItemNoShift("Use", Client.selectedItemName + " -> " + PacketWriter.colorStartTag(16777215) + var4, 14, var1, var2, var3);
			} else if (Client.isSpellSelected) {
				if ((NetSocket.selectedSpellFlags & 8) == 8) {
					GraphicsObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + PacketWriter.colorStartTag(16777215) + var4, 15, var1, var2, var3);
				}
			} else {
				for (var10 = 7; var10 >= 0; --var10) {
					if (Client.playerMenuActions[var10] != null) {
						short var11 = 0;
						if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
							if (Client.playerAttackOption == AttackOption.AttackOption_hidden) {
								continue;
							}

							if (Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class192.localPlayer.combatLevel) {
								var11 = 2000;
							}

							if (class192.localPlayer.team != 0 && var0.team != 0) {
								if (var0.team == class192.localPlayer.team) {
									var11 = 2000;
								} else {
									var11 = 0;
								}
							}
						} else if (Client.playerOptionsPriorities[var10]) {
							var11 = 2000;
						}

						boolean var12 = false;
						var5 = Client.playerMenuOpcodes[var10] + var11;
						GraphicsObject.insertMenuItemNoShift(Client.playerMenuActions[var10], PacketWriter.colorStartTag(16777215) + var4, var5, var1, var2, var3);
					}
				}
			}

			for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
				if (Client.menuOpcodes[var10] == 23) {
					Client.menuTargets[var10] = PacketWriter.colorStartTag(16777215) + var4;
					break;
				}
			}
		}

	}

	static {
		field2370 = new class191();
		field2368 = new class191();
		field2373 = new class191();
	}
}
