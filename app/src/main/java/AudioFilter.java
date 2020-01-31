import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("AudioFilter")
public class AudioFilter {
	@ObfuscatedName("g")
	static float[][] field1474;
	@ObfuscatedName("d")
	@Export("coefficients")
	static int[][] coefficients;
	@ObfuscatedName("l")
	static float field1472;
	@ObfuscatedName("j")
	@Export("forwardMultiplier")
	static int forwardMultiplier;
	@ObfuscatedName("c")
	@Export("pairs")
	int[] pairs;
	@ObfuscatedName("o")
	int[][][] field1467;
	@ObfuscatedName("e")
	int[][][] field1476;
	@ObfuscatedName("i")
	int[] field1469;

	AudioFilter() {
		this.pairs = new int[2];
		this.field1467 = new int[2][2][4];
		this.field1476 = new int[2][2][4];
		this.field1469 = new int[2];
	}

	@ObfuscatedName("c")
	float method2758(int var1, int var2, float var3) {
		float var4 = (float)this.field1476[var1][0][var2] + var3 * (float)(this.field1476[var1][1][var2] - this.field1476[var1][0][var2]);
		var4 *= 0.0015258789F;
		return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
	}

	@ObfuscatedName("o")
	float method2770(int var1, int var2, float var3) {
		float var4 = (float)this.field1467[var1][0][var2] + var3 * (float)(this.field1467[var1][1][var2] - this.field1467[var1][0][var2]);
		var4 *= 1.2207031E-4F;
		return normalize(var4);
	}

	@ObfuscatedName("e")
	@Export("compute")
	int compute(int var1, float var2) {
		float var3;
		if (var1 == 0) {
			var3 = (float)this.field1469[0] + (float)(this.field1469[1] - this.field1469[0]) * var2;
			var3 *= 0.0030517578F;
			field1472 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
			forwardMultiplier = (int)(field1472 * 65536.0F);
		}

		if (this.pairs[var1] == 0) {
			return 0;
		} else {
			var3 = this.method2758(var1, 0, var2);
			field1474[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method2770(var1, 0, var2));
			field1474[var1][1] = var3 * var3;

			float[] var4;
			int var5;
			for (var5 = 1; var5 < this.pairs[var1]; ++var5) {
				var3 = this.method2758(var1, var5, var2);
				float var6 = -2.0F * var3 * (float)Math.cos((double)this.method2770(var1, var5, var2));
				float var7 = var3 * var3;
				field1474[var1][var5 * 2 + 1] = field1474[var1][var5 * 2 - 1] * var7;
				field1474[var1][var5 * 2] = field1474[var1][var5 * 2 - 1] * var6 + field1474[var1][var5 * 2 - 2] * var7;

				for (int var8 = var5 * 2 - 1; var8 >= 2; --var8) {
					var4 = field1474[var1];
					var4[var8] += field1474[var1][var8 - 1] * var6 + field1474[var1][var8 - 2] * var7;
				}

				var4 = field1474[var1];
				var4[1] += field1474[var1][0] * var6 + var7;
				var4 = field1474[var1];
				var4[0] += var6;
			}

			if (var1 == 0) {
				for (var5 = 0; var5 < this.pairs[0] * 2; ++var5) {
					var4 = field1474[0];
					var4[var5] *= field1472;
				}
			}

			for (var5 = 0; var5 < this.pairs[var1] * 2; ++var5) {
				coefficients[var1][var5] = (int)(field1474[var1][var5] * 65536.0F);
			}

			return this.pairs[var1] * 2;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkp;Lds;)V"
	)
	final void method2769(Buffer var1, SoundEnvelope var2) {
		int var3 = var1.readUnsignedByte();
		this.pairs[0] = var3 >> 4;
		this.pairs[1] = var3 & 15;
		if (var3 != 0) {
			this.field1469[0] = var1.readUnsignedShort();
			this.field1469[1] = var1.readUnsignedShort();
			int var4 = var1.readUnsignedByte();

			int var5;
			int var6;
			for (var5 = 0; var5 < 2; ++var5) {
				for (var6 = 0; var6 < this.pairs[var5]; ++var6) {
					this.field1467[var5][0][var6] = var1.readUnsignedShort();
					this.field1476[var5][0][var6] = var1.readUnsignedShort();
				}
			}

			for (var5 = 0; var5 < 2; ++var5) {
				for (var6 = 0; var6 < this.pairs[var5]; ++var6) {
					if ((var4 & 1 << var5 * 4 << var6) != 0) {
						this.field1467[var5][1][var6] = var1.readUnsignedShort();
						this.field1476[var5][1][var6] = var1.readUnsignedShort();
					} else {
						this.field1467[var5][1][var6] = this.field1467[var5][0][var6];
						this.field1476[var5][1][var6] = this.field1476[var5][0][var6];
					}
				}
			}

			if (var4 != 0 || this.field1469[1] != this.field1469[0]) {
				var2.decodeSegments(var1);
			}
		} else {
			int[] var7 = this.field1469;
			this.field1469[1] = 0;
			var7[0] = 0;
		}

	}

	@ObfuscatedName("t")
	@Export("normalize")
	static float normalize(float var0) {
		float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
		return var1 * 3.1415927F / 11025.0F;
	}

	static {
		field1474 = new float[2][8];
		coefficients = new int[2][8];
	}
}
