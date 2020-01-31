import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class222 {
	@ObfuscatedName("em")
	@ObfuscatedSignature(
		signature = "Llj;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1128427150"
	)
	static final void method4192() {
		int var0;
		int var1;
		for (int var2 = 0; var2 < Client.soundEffectCount; ++var2) {
			int var10003 = Client.queuedSoundEffectDelays[var2]--;
			if (Client.queuedSoundEffectDelays[var2] >= -10) {
				SoundEffect var11 = Client.soundEffects[var2];
				RawSound var5;
				if (var11 == null) {
					var5 = null;
					var11 = SoundEffect.readSoundEffect(Client.archive4, Client.soundEffectIds[var2], 0);
					if (var11 == null) {
						continue;
					}

					int[] var6 = Client.queuedSoundEffectDelays;
					var6[var2] += var11.calculateDelay();
					Client.soundEffects[var2] = var11;
				}

				if (Client.queuedSoundEffectDelays[var2] < 0) {
					if (Client.soundLocations[var2] != 0) {
						var1 = (Client.soundLocations[var2] & 255) * 128;
						int var12 = Client.soundLocations[var2] >> 16 & 255;
						int var13 = var12 * 128 + 64 - class192.localPlayer.x;
						if (var13 < 0) {
							var13 = -var13;
						}

						int var7 = Client.soundLocations[var2] >> 8 & 255;
						int var8 = var7 * 128 + 64 - class192.localPlayer.y;
						if (var8 < 0) {
							var8 = -var8;
						}

						int var9 = var13 + var8 - 128;
						if (var9 > var1) {
							Client.queuedSoundEffectDelays[var2] = -100;
							continue;
						}

						if (var9 < 0) {
							var9 = 0;
						}

						var0 = (var1 - var9) * Client.areaSoundEffectVolume / var1;
					} else {
						var0 = Client.soundEffectVolume;
					}

					if (var0 > 0) {
						var5 = var11.toRawSound().resample(WorldMapSection1.decimator);
						RawPcmStream var14 = RawPcmStream.createRawPcmStream(var5, 100, var0);
						var14.setNumLoops(Client.queuedSoundEffectLoops[var2] - 1);
						class2.pcmStreamMixer.addSubStream(var14);
					}

					Client.queuedSoundEffectDelays[var2] = -100;
				}
			} else {
				--Client.soundEffectCount;

				for (int var4 = var2; var4 < Client.soundEffectCount; ++var4) {
					Client.soundEffectIds[var4] = Client.soundEffectIds[var4 + 1];
					Client.soundEffects[var4] = Client.soundEffects[var4 + 1];
					Client.queuedSoundEffectLoops[var4] = Client.queuedSoundEffectLoops[var4 + 1];
					Client.queuedSoundEffectDelays[var4] = Client.queuedSoundEffectDelays[var4 + 1];
					Client.soundLocations[var4] = Client.soundLocations[var4 + 1];
				}

				--var2;
			}
		}

		if (Client.field881) {
			boolean var10;
			if (class197.field2414 != 0) {
				var10 = true;
			} else {
				var10 = class197.midiPcmStream.isReady();
			}

			if (!var10) {
				if (Client.musicVolume != 0 && Client.currentTrackGroupId != -1) {
					Archive var3 = MouseHandler.archive6;
					var0 = Client.currentTrackGroupId;
					var1 = Client.musicVolume;
					class197.field2414 = 1;
					UserComparator5.musicTrackArchive = var3;
					class197.musicTrackGroupId = var0;
					class83.musicTrackFileId = 0;
					AttackOption.musicTrackVolume = var1;
					KeyHandler.musicTrackBoolean = false;
					class197.field2412 = 10000;
				}

				Client.field881 = false;
			}
		}

	}
}
