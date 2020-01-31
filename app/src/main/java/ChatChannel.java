import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -899235317
	)
	public static int field1289;
	@ObfuscatedName("k")
	public static String[] field1291;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lbn;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -2026360781
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbn;",
		garbageValue = "0"
	)
	@Export("addMessage")
	Message addMessage(int var1, String var2, String var3, String var4) {
		Message var5 = this.messages[99];

		for (int var6 = this.count; var6 > 0; --var6) {
			if (var6 != 100) {
				this.messages[var6] = this.messages[var6 - 1];
			}
		}

		if (var5 == null) {
			var5 = new Message(var1, var2, var4, var3);
		} else {
			var5.remove();
			var5.removeDual();
			var5.set(var1, var2, var4, var3);
		}

		this.messages[0] = var5;
		if (this.count < 100) {
			++this.count;
		}

		return var5;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lbn;",
		garbageValue = "187354939"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "40"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "-1620265194"
	)
	static final void method2302(int var0, int var1, boolean var2) {
		if (!var2 || var0 != SecureRandomCallable.field530 || Language.field2359 != var1) {
			SecureRandomCallable.field530 = var0;
			Language.field2359 = var1;
			Projectile.updateGameState(25);
			class197.drawLoadingMessage("Loading - please wait.", true);
			int var3 = Messages.baseX * 64;
			int var4 = Language.baseY * 64;
			Messages.baseX = (var0 - 6) * 8;
			Language.baseY = (var1 - 6) * 8;
			int var5 = Messages.baseX * 64 - var3;
			int var6 = Language.baseY * 64 - var4;
			var3 = Messages.baseX * 64;
			var4 = Language.baseY * 64;

			int var7;
			int var8;
			int[] var9;
			for (var7 = 0; var7 < 32768; ++var7) {
				NPC var10 = Client.npcs[var7];
				if (var10 != null) {
					for (var8 = 0; var8 < 10; ++var8) {
						var9 = var10.pathX;
						var9[var8] -= var5;
						var9 = var10.pathY;
						var9[var8] -= var6;
					}

					var10.x -= var5 * 128;
					var10.y -= var6 * 128;
				}
			}

			for (var7 = 0; var7 < 2048; ++var7) {
				Player var21 = Client.players[var7];
				if (var21 != null) {
					for (var8 = 0; var8 < 10; ++var8) {
						var9 = var21.pathX;
						var9[var8] -= var5;
						var9 = var21.pathY;
						var9[var8] -= var6;
					}

					var21.x -= var5 * 128;
					var21.y -= var6 * 128;
				}
			}

			byte var22 = 0;
			byte var11 = 104;
			byte var12 = 1;
			if (var5 < 0) {
				var22 = 103;
				var11 = -1;
				var12 = -1;
			}

			byte var13 = 0;
			byte var14 = 104;
			byte var15 = 1;
			if (var6 < 0) {
				var13 = 103;
				var14 = -1;
				var15 = -1;
			}

			int var16;
			for (int var17 = var22; var11 != var17; var17 += var12) {
				for (var16 = var13; var14 != var16; var16 += var15) {
					int var18 = var17 + var5;
					int var19 = var6 + var16;

					for (int var20 = 0; var20 < 4; ++var20) {
						if (var18 >= 0 && var19 >= 0 && var18 < 104 && var19 < 104) {
							Client.groundItems[var20][var17][var16] = Client.groundItems[var20][var18][var19];
						} else {
							Client.groundItems[var20][var17][var16] = null;
						}
					}
				}
			}

			for (PendingSpawn var23 = (PendingSpawn)Client.pendingSpawns.last(); var23 != null; var23 = (PendingSpawn)Client.pendingSpawns.previous()) {
				var23.x -= var5;
				var23.y -= var6;
				if (var23.x < 0 || var23.y < 0 || var23.x >= 104 || var23.y >= 104) {
					var23.remove();
				}
			}

			if (Client.destinationX != 0) {
				Client.destinationX -= var5;
				Client.destinationY -= var6;
			}

			Client.soundEffectCount = 0;
			Client.isCameraLocked = false;
			HitSplatDefinition.cameraX -= var5 << 7;
			Actor.cameraZ -= var6 << 7;
			PendingSpawn.oculusOrbFocalPointX -= var5 << 7;
			Skeleton.oculusOrbFocalPointY -= var6 << 7;
			Client.field704 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var16 = 0; var16 < 4; ++var16) {
				Client.collisionMaps[var16].clear();
			}
		}

	}
}
