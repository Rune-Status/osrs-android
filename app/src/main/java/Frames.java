import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("l")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -1849974283
	)
	static int field1885;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Ldh;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Lii;Lii;IZ)V",
		garbageValue = "0"
	)
	public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13 = var2.getFile(var11, 0);
				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1402532864"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BS)Ljava/lang/String;",
		garbageValue = "255"
	)
	public static String method3340(byte[] var0) {
		int var1 = var0.length;
		StringBuilder var2 = new StringBuilder();

		for (int var3 = 0; var3 < var1 + 0; var3 += 3) {
			int var4 = var0[var3] & 255;
			var2.append(class290.field3646[var4 >>> 2]);
			if (var3 < var1 - 1) {
				int var5 = var0[var3 + 1] & 255;
				var2.append(class290.field3646[(var4 & 3) << 4 | var5 >>> 4]);
				if (var3 < var1 - 2) {
					int var6 = var0[var3 + 2] & 255;
					var2.append(class290.field3646[(var5 & 15) << 2 | var6 >>> 6]).append(class290.field3646[var6 & 63]);
				} else {
					var2.append(class290.field3646[(var5 & 15) << 2]).append("=");
				}
			} else {
				var2.append(class290.field3646[(var4 & 3) << 4]).append("==");
			}
		}

		String var7 = var2.toString();
		return var7;
	}
}
