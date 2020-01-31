import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
	@ObfuscatedName("t")
	@Export("nextComparator")
	Comparator nextComparator;

	protected AbstractUserComparator() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;B)V",
		garbageValue = "71"
	)
	@Export("addComparator")
	final void addComparator(Comparator var1) {
		if (this.nextComparator == null) {
			this.nextComparator = var1;
		} else if (this.nextComparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.nextComparator).addComparator(var1);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljk;Ljk;I)I",
		garbageValue = "-1613196050"
	)
	@Export("compareUser")
	protected final int compareUser(User var1, User var2) {
		return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1320582539"
	)
	static int method5119(int var0, int var1) {
		FloorOverlayDefinition var2 = ArchiveLoader.FloorUnderlayDefinition_get(var0);
		if (var2 == null) {
			return var1;
		} else if (var2.secondaryRgb >= 0) {
			return var2.secondaryRgb | -16777216;
		} else {
			int var3;
			if (var2.texture >= 0) {
				var3 = class218.method4178(Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture), 96);
				return Rasterizer3D.Rasterizer3D_colorPalette[var3] | -16777216;
			} else if (var2.primaryRgb == 16711935) {
				return var1;
			} else {
				var3 = var2.hue;
				int var4 = var2.saturation;
				int var5 = var2.lightness;
				if (var5 > 179) {
					var4 /= 2;
				}

				if (var5 > 192) {
					var4 /= 2;
				}

				if (var5 > 217) {
					var4 /= 2;
				}

				if (var5 > 243) {
					var4 /= 2;
				}

				int var6 = (var4 / 32 << 7) + var5 / 2 + (var3 / 4 << 10);
				int var7 = class218.method4178(var6, 96);
				return Rasterizer3D.Rasterizer3D_colorPalette[var7] | -16777216;
			}
		}
	}
}
