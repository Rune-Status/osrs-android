import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("x")
public class class14 {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1417647521
	)
	@Export("clientTickTimeIdx")
	static int clientTickTimeIdx;
	@ObfuscatedName("aa")
	static String field101;
	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	static StudioGame field102;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BB)Llt;",
		garbageValue = "-30"
	)
	@Export("convertJpgToSprite")
	public static final Sprite convertJpgToSprite(byte[] var0) {
		BufferedImage var1 = null;

		try {
			var1 = ImageIO.read(new ByteArrayInputStream(var0));
			int var2 = var1.getWidth();
			int var3 = var1.getHeight();
			int[] var4 = new int[var2 * var3];
			PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
			var5.grabPixels();
			return new Sprite(var4, var2, var3);
		} catch (IOException var6) {
		} catch (InterruptedException var7) {
		}

		return new Sprite(0, 0);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
		garbageValue = "-1466465553"
	)
	static boolean method174(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class51.field431.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var12 = 0; var12 < var0.length(); ++var12) {
						if (var11.indexOf(var0.charAt(var12)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var6) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Applet var3 = class51.applet;
				Object[] var4 = new Object[]{(new URL(class51.applet.getCodeBase(), var0)).toString()};
				Object var5 = JSObject.getWindow(var3).call(var2, var4);
				return var5 != null;
			} catch (Throwable var7) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var8) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				class47.method857(class51.applet, "loggedout");
			} catch (Throwable var10) {
			}

			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var9) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("d")
	public static int method169(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "1"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(IZIB)V",
		garbageValue = "14"
	)
	public static final void method173(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			PcmPlayer.field1398 = var0;
			PcmPlayer.PcmPlayer_stereo = var1;
			GrandExchangeEvent.field45 = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "970365805"
	)
	static int method170() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field813;
		} else {
			return 10000;
		}
	}
}
