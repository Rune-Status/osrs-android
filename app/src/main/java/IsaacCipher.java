import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
@Implements("IsaacCipher")
public final class IsaacCipher {
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1084674035
	)
	@Export("valuesRemaining")
	int valuesRemaining;
	@ObfuscatedName("i")
	@Export("results")
	int[] results;
	@ObfuscatedName("g")
	@Export("mm")
	int[] mm;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1881052481
	)
	@Export("aa")
	int aa;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1182669169
	)
	@Export("bb")
	int bb;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1353155945
	)
	@Export("cc")
	int cc;

	public IsaacCipher(int[] var1) {
		this.mm = new int[256];
		this.results = new int[256];

		for (int var2 = 0; var2 < var1.length; ++var2) {
			this.results[var2] = var1[var2];
		}

		this.method6314();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "32137"
	)
	@Export("nextInt")
	public final int nextInt() {
		if (this.valuesRemaining == 0) {
			this.generateMoreResults();
			this.valuesRemaining = 256;
		}

		return this.results[--this.valuesRemaining];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	public final int method6307() {
		if (this.valuesRemaining == 0) {
			this.generateMoreResults();
			this.valuesRemaining = 256;
		}

		return this.results[this.valuesRemaining - 1];
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "16776960"
	)
	@Export("generateMoreResults")
	final void generateMoreResults() {
		this.bb += ++this.cc;

		for (int var1 = 0; var1 < 256; ++var1) {
			int var2 = this.mm[var1];
			if ((var1 & 2) == 0) {
				if ((var1 & 1) == 0) {
					this.aa ^= this.aa << 13;
				} else {
					this.aa ^= this.aa >>> 6;
				}
			} else if ((var1 & 1) == 0) {
				this.aa ^= this.aa << 2;
			} else {
				this.aa ^= this.aa >>> 16;
			}

			this.aa += this.mm[var1 + 128 & 255];
			int var3;
			this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.aa + this.bb;
			this.results[var1] = this.bb = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1817393668"
	)
	final void method6314() {
		int var1 = -1640531527;
		int var2 = -1640531527;
		int var3 = -1640531527;
		int var4 = -1640531527;
		int var5 = -1640531527;
		int var6 = -1640531527;
		int var7 = -1640531527;
		int var8 = -1640531527;

		int var9;
		for (var9 = 0; var9 < 4; ++var9) {
			var8 ^= var7 << 11;
			var5 += var8;
			var7 += var6;
			var7 ^= var6 >>> 2;
			var4 += var7;
			var6 += var5;
			var6 ^= var5 << 8;
			var3 += var6;
			var5 += var4;
			var5 ^= var4 >>> 16;
			var2 += var5;
			var4 += var3;
			var4 ^= var3 << 10;
			var1 += var4;
			var3 += var2;
			var3 ^= var2 >>> 4;
			var8 += var3;
			var2 += var1;
			var2 ^= var1 << 8;
			var7 += var2;
			var1 += var8;
			var1 ^= var8 >>> 9;
			var6 += var1;
			var8 += var7;
		}

		for (var9 = 0; var9 < 256; var9 += 8) {
			var8 += this.results[var9];
			var7 += this.results[var9 + 1];
			var6 += this.results[var9 + 2];
			var5 += this.results[var9 + 3];
			var4 += this.results[var9 + 4];
			var3 += this.results[var9 + 5];
			var2 += this.results[var9 + 6];
			var1 += this.results[var9 + 7];
			var8 ^= var7 << 11;
			var5 += var8;
			var7 += var6;
			var7 ^= var6 >>> 2;
			var4 += var7;
			var6 += var5;
			var6 ^= var5 << 8;
			var3 += var6;
			var5 += var4;
			var5 ^= var4 >>> 16;
			var2 += var5;
			var4 += var3;
			var4 ^= var3 << 10;
			var1 += var4;
			var3 += var2;
			var3 ^= var2 >>> 4;
			var8 += var3;
			var2 += var1;
			var2 ^= var1 << 8;
			var7 += var2;
			var1 += var8;
			var1 ^= var8 >>> 9;
			var6 += var1;
			var8 += var7;
			this.mm[var9] = var8;
			this.mm[var9 + 1] = var7;
			this.mm[var9 + 2] = var6;
			this.mm[var9 + 3] = var5;
			this.mm[var9 + 4] = var4;
			this.mm[var9 + 5] = var3;
			this.mm[var9 + 6] = var2;
			this.mm[var9 + 7] = var1;
		}

		for (var9 = 0; var9 < 256; var9 += 8) {
			var8 += this.mm[var9];
			var7 += this.mm[var9 + 1];
			var6 += this.mm[var9 + 2];
			var5 += this.mm[var9 + 3];
			var4 += this.mm[var9 + 4];
			var3 += this.mm[var9 + 5];
			var2 += this.mm[var9 + 6];
			var1 += this.mm[var9 + 7];
			var8 ^= var7 << 11;
			var5 += var8;
			var7 += var6;
			var7 ^= var6 >>> 2;
			var4 += var7;
			var6 += var5;
			var6 ^= var5 << 8;
			var3 += var6;
			var5 += var4;
			var5 ^= var4 >>> 16;
			var2 += var5;
			var4 += var3;
			var4 ^= var3 << 10;
			var1 += var4;
			var3 += var2;
			var3 ^= var2 >>> 4;
			var8 += var3;
			var2 += var1;
			var2 ^= var1 << 8;
			var7 += var2;
			var1 += var8;
			var1 ^= var8 >>> 9;
			var6 += var1;
			var8 += var7;
			this.mm[var9] = var8;
			this.mm[var9 + 1] = var7;
			this.mm[var9 + 2] = var6;
			this.mm[var9 + 3] = var5;
			this.mm[var9 + 4] = var4;
			this.mm[var9 + 5] = var3;
			this.mm[var9 + 6] = var2;
			this.mm[var9 + 7] = var1;
		}

		this.generateMoreResults();
		this.valuesRemaining = 256;
	}
}
