import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1677646269
	)
	@Export("x")
	int x;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 531566341
	)
	@Export("y")
	int y;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1439819501
	)
	@Export("z")
	int z;

	FaceNormal() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;III)Lko;",
		garbageValue = "1973799897"
	)
	public static Font method3335(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		if (!class228.method4199(var0, var2, var3)) {
			return null;
		} else {
			byte[] var4 = var1.takeFile(var2, var3);
			Font var5;
			if (var4 == null) {
				var5 = null;
			} else {
				Font var6 = new Font(var4, Huffman.SpriteBuffer_xOffsets, NPC.SpriteBuffer_yOffsets, class326.SpriteBuffer_spriteWidths, class326.SpriteBuffer_spriteHeights, class326.SpriteBuffer_spritePalette, class326.SpriteBuffer_pixels);
				DynamicObject.method2292();
				var5 = var6;
			}

			return var5;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2042389443"
	)
	public static boolean method3334() {
		ReflectionCheck var0 = (ReflectionCheck)class96.reflectionChecks.last();
		return var0 != null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lii;Ljava/lang/String;Ljava/lang/String;I)[Lli;",
		garbageValue = "326479912"
	)
	public static IndexedSprite[] method3336(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite[] var5;
		if (!class228.method4199(var0, var3, var4)) {
			var5 = null;
		} else {
			IndexedSprite[] var6 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

			for (int var7 = 0; var7 < class326.SpriteBuffer_spriteCount; ++var7) {
				IndexedSprite var8 = var6[var7] = new IndexedSprite();
				var8.width = GZipDecompressor.SpriteBuffer_spriteWidth;
				var8.height = class326.SpriteBuffer_spriteHeight;
				var8.xOffset = Huffman.SpriteBuffer_xOffsets[var7];
				var8.yOffset = NPC.SpriteBuffer_yOffsets[var7];
				var8.subWidth = class326.SpriteBuffer_spriteWidths[var7];
				var8.subHeight = class326.SpriteBuffer_spriteHeights[var7];
				var8.palette = class326.SpriteBuffer_spritePalette;
				var8.pixels = class326.SpriteBuffer_pixels[var7];
			}

			DynamicObject.method2292();
			var5 = var6;
		}

		return var5;
	}
}
