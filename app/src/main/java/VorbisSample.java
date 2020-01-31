import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("VorbisSample")
public class VorbisSample extends Node {
	@ObfuscatedName("d")
	@Export("VorbisSample_bytes")
	static byte[] VorbisSample_bytes;
	@ObfuscatedName("l")
	@Export("VorbisSample_byteOffset")
	static int VorbisSample_byteOffset;
	@ObfuscatedName("j")
	@Export("VorbisSample_bitOffset")
	static int VorbisSample_bitOffset;
	@ObfuscatedName("m")
	@Export("VorbisSample_blockSize0")
	static int VorbisSample_blockSize0;
	@ObfuscatedName("p")
	@Export("VorbisSample_blockSize1")
	static int VorbisSample_blockSize1;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Lcl;"
	)
	@Export("VorbisSample_codebooks")
	static VorbisCodebook[] VorbisSample_codebooks;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Ldm;"
	)
	@Export("VorbisSample_floors")
	static VorbisFloor[] VorbisSample_floors;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[Ldc;"
	)
	@Export("VorbisSample_residues")
	static VorbisResidue[] VorbisSample_residues;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Ldy;"
	)
	@Export("VorbisSample_mappings")
	static VorbisMapping[] VorbisSample_mappings;
	@ObfuscatedName("w")
	@Export("VorbisSample_blockFlags")
	static boolean[] VorbisSample_blockFlags;
	@ObfuscatedName("k")
	@Export("VorbisSample_mapping")
	static int[] VorbisSample_mapping;
	@ObfuscatedName("q")
	static boolean field1362;
	@ObfuscatedName("r")
	static float[] field1363;
	@ObfuscatedName("s")
	static float[] field1364;
	@ObfuscatedName("a")
	static float[] field1341;
	@ObfuscatedName("u")
	static float[] field1357;
	@ObfuscatedName("ae")
	static float[] field1367;
	@ObfuscatedName("af")
	static float[] field1368;
	@ObfuscatedName("az")
	static float[] field1369;
	@ObfuscatedName("ax")
	static int[] field1370;
	@ObfuscatedName("aj")
	static int[] field1371;
	@ObfuscatedName("c")
	byte[][] field1359;
	@ObfuscatedName("t")
	@Export("sampleRate")
	int sampleRate;
	@ObfuscatedName("o")
	@Export("sampleCount")
	int sampleCount;
	@ObfuscatedName("e")
	@Export("start")
	int start;
	@ObfuscatedName("i")
	@Export("end")
	int end;
	@ObfuscatedName("g")
	boolean field1346;
	@ObfuscatedName("z")
	float[] field1374;
	@ObfuscatedName("y")
	int field1353;
	@ObfuscatedName("f")
	int field1365;
	@ObfuscatedName("b")
	boolean field1355;
	@ObfuscatedName("au")
	@Export("samples")
	byte[] samples;
	@ObfuscatedName("ay")
	int field1373;
	@ObfuscatedName("aa")
	int field1344;

	VorbisSample(byte[] var1) {
		this.read(var1);
	}

	@ObfuscatedName("i")
	@Export("read")
	void read(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		this.sampleRate = var2.readInt();
		this.sampleCount = var2.readInt();
		this.start = var2.readInt();
		this.end = var2.readInt();
		if (this.end < 0) {
			this.end = ~this.end;
			this.field1346 = true;
		}

		int var3 = var2.readInt();
		this.field1359 = new byte[var3][];

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = 0;

			int var6;
			do {
				var6 = var2.readUnsignedByte();
				var5 += var6;
			} while(var6 >= 255);

			byte[] var7 = new byte[var5];
			var2.readBytes(var7, 0, var5);
			this.field1359[var4] = var7;
		}

	}

	@ObfuscatedName("d")
	float[] method2425(int var1) {
		VorbisSample_setData(this.field1359[var1], 0);
		readBit();
		int var2 = readBits(CollisionMap.iLog(VorbisSample_mapping.length - 1));
		boolean var3 = VorbisSample_blockFlags[var2];
		int var4 = var3 ? VorbisSample_blockSize1 : VorbisSample_blockSize0;
		boolean var5 = false;
		boolean var6 = false;
		if (var3) {
			var5 = readBit() != 0;
			var6 = readBit() != 0;
		}

		int var7 = var4 >> 1;
		int var8;
		int var9;
		int var10;
		if (var3 && !var5) {
			var8 = (var4 >> 2) - (VorbisSample_blockSize0 >> 2);
			var9 = (VorbisSample_blockSize0 >> 2) + (var4 >> 2);
			var10 = VorbisSample_blockSize0 >> 1;
		} else {
			var8 = 0;
			var9 = var7;
			var10 = var4 >> 1;
		}

		int var11;
		int var12;
		int var13;
		if (var3 && !var6) {
			var11 = var4 - (var4 >> 2) - (VorbisSample_blockSize0 >> 2);
			var12 = (VorbisSample_blockSize0 >> 2) + (var4 - (var4 >> 2));
			var13 = VorbisSample_blockSize0 >> 1;
		} else {
			var11 = var7;
			var12 = var4;
			var13 = var4 >> 1;
		}

		VorbisMapping var14 = VorbisSample_mappings[VorbisSample_mapping[var2]];
		int var15 = var14.mappingMux;
		int var16 = var14.submapFloor[var15];
		boolean var17 = !VorbisSample_floors[var16].readSubmapFloor();
		boolean var18 = var17;

		for (var16 = 0; var16 < var14.submaps; ++var16) {
			VorbisResidue var19 = VorbisSample_residues[var14.submapResidue[var16]];
			float[] var20 = field1363;
			var19.method2587(var20, var4 >> 1, var18);
		}

		int var48;
		if (!var17) {
			var16 = var14.mappingMux;
			var48 = var14.submapFloor[var16];
			VorbisSample_floors[var48].method2464(field1363, var4 >> 1);
		}

		float[] var21;
		int var22;
		int var49;
		if (var17) {
			for (var16 = var4 >> 1; var16 < var4; ++var16) {
				field1363[var16] = 0.0F;
			}
		} else {
			var16 = var4 >> 1;
			var48 = var4 >> 2;
			var49 = var4 >> 3;
			var21 = field1363;

			for (var22 = 0; var22 < var16; ++var22) {
				var21[var22] *= 0.5F;
			}

			for (var22 = var16; var22 < var4; ++var22) {
				var21[var22] = -var21[var4 - var22 - 1];
			}

			float[] var23 = var3 ? field1367 : field1364;
			float[] var24 = var3 ? field1368 : field1341;
			float[] var25 = var3 ? field1369 : field1357;
			int[] var26 = var3 ? field1371 : field1370;

			int var27;
			float var28;
			float var29;
			float var30;
			float var31;
			for (var27 = 0; var27 < var48; ++var27) {
				var28 = var21[var27 * 4] - var21[var4 - var27 * 4 - 1];
				var29 = var21[var27 * 4 + 2] - var21[var4 - var27 * 4 - 3];
				var30 = var23[var27 * 2];
				var31 = var23[var27 * 2 + 1];
				var21[var4 - var27 * 4 - 1] = var28 * var30 - var29 * var31;
				var21[var4 - var27 * 4 - 3] = var28 * var31 + var29 * var30;
			}

			float var32;
			float var33;
			for (var27 = 0; var27 < var49; ++var27) {
				var28 = var21[var16 + var27 * 4 + 3];
				var29 = var21[var16 + var27 * 4 + 1];
				var30 = var21[var27 * 4 + 3];
				var31 = var21[var27 * 4 + 1];
				var21[var16 + var27 * 4 + 3] = var28 + var30;
				var21[var16 + var27 * 4 + 1] = var29 + var31;
				var32 = var23[var16 - 4 - var27 * 4];
				var33 = var23[var16 - 3 - var27 * 4];
				var21[var27 * 4 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
				var21[var27 * 4 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
			}

			var27 = CollisionMap.iLog(var4 - 1);

			int var34;
			int var35;
			int var36;
			int var37;
			for (var34 = 0; var34 < var27 - 3; ++var34) {
				var35 = var4 >> var34 + 2;
				var36 = 8 << var34;

				for (var37 = 0; var37 < 2 << var34; ++var37) {
					int var38 = var4 - var35 * var37 * 2;
					int var39 = var4 - var35 * (var37 * 2 + 1);

					for (int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
						int var41 = var40 * 4;
						float var42 = var21[var38 - 1 - var41];
						float var43 = var21[var38 - 3 - var41];
						float var44 = var21[var39 - 1 - var41];
						float var45 = var21[var39 - 3 - var41];
						var21[var38 - 1 - var41] = var42 + var44;
						var21[var38 - 3 - var41] = var43 + var45;
						float var46 = var23[var40 * var36];
						float var47 = var23[var40 * var36 + 1];
						var21[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
						var21[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
					}
				}
			}

			for (var34 = 1; var34 < var49 - 1; ++var34) {
				var35 = var26[var34];
				if (var34 < var35) {
					var36 = var34 * 8;
					var37 = var35 * 8;
					var32 = var21[var36 + 1];
					var21[var36 + 1] = var21[var37 + 1];
					var21[var37 + 1] = var32;
					var32 = var21[var36 + 3];
					var21[var36 + 3] = var21[var37 + 3];
					var21[var37 + 3] = var32;
					var32 = var21[var36 + 5];
					var21[var36 + 5] = var21[var37 + 5];
					var21[var37 + 5] = var32;
					var32 = var21[var36 + 7];
					var21[var36 + 7] = var21[var37 + 7];
					var21[var37 + 7] = var32;
				}
			}

			for (var34 = 0; var34 < var16; ++var34) {
				var21[var34] = var21[var34 * 2 + 1];
			}

			for (var34 = 0; var34 < var49; ++var34) {
				var21[var4 - 1 - var34 * 2] = var21[var34 * 4];
				var21[var4 - 2 - var34 * 2] = var21[var34 * 4 + 1];
				var21[var4 - var48 - 1 - var34 * 2] = var21[var34 * 4 + 2];
				var21[var4 - var48 - 2 - var34 * 2] = var21[var34 * 4 + 3];
			}

			for (var34 = 0; var34 < var49; ++var34) {
				var29 = var25[var34 * 2];
				var30 = var25[var34 * 2 + 1];
				var31 = var21[var16 + var34 * 2];
				var32 = var21[var16 + var34 * 2 + 1];
				var33 = var21[var4 - 2 - var34 * 2];
				float var51 = var21[var4 - 1 - var34 * 2];
				float var53 = var30 * (var31 - var33) + var29 * (var32 + var51);
				var21[var16 + var34 * 2] = (var31 + var33 + var53) * 0.5F;
				var21[var4 - 2 - var34 * 2] = (var31 + var33 - var53) * 0.5F;
				var53 = var30 * (var32 + var51) - var29 * (var31 - var33);
				var21[var16 + var34 * 2 + 1] = (var32 - var51 + var53) * 0.5F;
				var21[var4 - 1 - var34 * 2] = (-var32 + var51 + var53) * 0.5F;
			}

			for (var34 = 0; var34 < var48; ++var34) {
				var21[var34] = var21[var16 + var34 * 2] * var24[var34 * 2] + var21[var16 + var34 * 2 + 1] * var24[var34 * 2 + 1];
				var21[var16 - 1 - var34] = var21[var16 + var34 * 2] * var24[var34 * 2 + 1] - var21[var16 + var34 * 2 + 1] * var24[var34 * 2];
			}

			for (var34 = 0; var34 < var48; ++var34) {
				var21[var34 + (var4 - var48)] = -var21[var34];
			}

			for (var34 = 0; var34 < var48; ++var34) {
				var21[var34] = var21[var48 + var34];
			}

			for (var34 = 0; var34 < var48; ++var34) {
				var21[var48 + var34] = -var21[var48 - var34 - 1];
			}

			for (var34 = 0; var34 < var48; ++var34) {
				var21[var16 + var34] = var21[var4 - var34 - 1];
			}

			float[] var52;
			for (var34 = var8; var34 < var9; ++var34) {
				var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
				var52 = field1363;
				var52[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
			}

			for (var34 = var11; var34 < var12; ++var34) {
				var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				var52 = field1363;
				var52[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
			}
		}

		var21 = null;
		if (this.field1353 > 0) {
			var48 = var4 + this.field1353 >> 2;
			var21 = new float[var48];
			if (!this.field1355) {
				for (var49 = 0; var49 < this.field1365; ++var49) {
					var22 = var49 + (this.field1353 >> 1);
					var21[var49] += this.field1374[var22];
				}
			}

			if (!var17) {
				for (var49 = var8; var49 < var4 >> 1; ++var49) {
					var22 = var21.length - (var4 >> 1) + var49;
					var21[var22] += field1363[var49];
				}
			}
		}

		float[] var50 = this.field1374;
		this.field1374 = field1363;
		field1363 = var50;
		this.field1353 = var4;
		this.field1365 = var12 - (var4 >> 1);
		this.field1355 = var17;
		return var21;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "([I)Lcv;"
	)
	@Export("toRawSound")
	RawSound toRawSound(int[] var1) {
		if (var1 != null && var1[0] <= 0) {
			return null;
		} else {
			if (this.samples == null) {
				this.field1353 = 0;
				this.field1374 = new float[VorbisSample_blockSize1];
				this.samples = new byte[this.sampleCount];
				this.field1373 = 0;
				this.field1344 = 0;
			}

			for (; this.field1344 < this.field1359.length; ++this.field1344) {
				if (var1 != null && var1[0] <= 0) {
					return null;
				}

				float[] var2 = this.method2425(this.field1344);
				if (var2 != null) {
					int var3 = this.field1373;
					int var4 = var2.length;
					if (var4 > this.sampleCount - var3) {
						var4 = this.sampleCount - var3;
					}

					for (int var5 = 0; var5 < var4; ++var5) {
						int var6 = (int)(128.0F + var2[var5] * 128.0F);
						if ((var6 & -256) != 0) {
							var6 = ~var6 >> 31;
						}

						this.samples[var3++] = (byte)(var6 - 128);
					}

					if (var1 != null) {
						var1[0] -= var3 - this.field1373;
					}

					this.field1373 = var3;
				}
			}

			this.field1374 = null;
			byte[] var7 = this.samples;
			this.samples = null;
			return new RawSound(this.sampleRate, var7, this.start, this.end, this.field1346);
		}
	}

	@ObfuscatedName("c")
	@Export("float32Unpack")
	static float float32Unpack(int var0) {
		int var1 = var0 & 2097151;
		int var2 = var0 & Integer.MIN_VALUE;
		int var3 = (var0 & 2145386496) >> 21;
		if (var2 != 0) {
			var1 = -var1;
		}

		return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
	}

	@ObfuscatedName("t")
	@Export("VorbisSample_setData")
	static void VorbisSample_setData(byte[] var0, int var1) {
		VorbisSample_bytes = var0;
		VorbisSample_byteOffset = var1;
		VorbisSample_bitOffset = 0;
	}

	@ObfuscatedName("o")
	@Export("readBit")
	static int readBit() {
		int var0 = VorbisSample_bytes[VorbisSample_byteOffset] >> VorbisSample_bitOffset & 1;
		++VorbisSample_bitOffset;
		VorbisSample_byteOffset += VorbisSample_bitOffset >> 3;
		VorbisSample_bitOffset &= 7;
		return var0;
	}

	@ObfuscatedName("e")
	@Export("readBits")
	static int readBits(int var0) {
		int var1 = 0;

		int var2;
		int var3;
		for (var2 = 0; var0 >= 8 - VorbisSample_bitOffset; var0 -= var3) {
			var3 = 8 - VorbisSample_bitOffset;
			int var4 = (1 << var3) - 1;
			var1 += (VorbisSample_bytes[VorbisSample_byteOffset] >> VorbisSample_bitOffset & var4) << var2;
			VorbisSample_bitOffset = 0;
			++VorbisSample_byteOffset;
			var2 += var3;
		}

		if (var0 > 0) {
			var3 = (1 << var0) - 1;
			var1 += (VorbisSample_bytes[VorbisSample_byteOffset] >> VorbisSample_bitOffset & var3) << var2;
			VorbisSample_bitOffset += var0;
		}

		return var1;
	}

	@ObfuscatedName("g")
	static void method2424(byte[] var0) {
		VorbisSample_setData(var0, 0);
		VorbisSample_blockSize0 = 1 << readBits(4);
		VorbisSample_blockSize1 = 1 << readBits(4);
		field1363 = new float[VorbisSample_blockSize1];

		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		for (var1 = 0; var1 < 2; ++var1) {
			var2 = var1 != 0 ? VorbisSample_blockSize1 : VorbisSample_blockSize0;
			var3 = var2 >> 1;
			var4 = var2 >> 2;
			var5 = var2 >> 3;
			float[] var6 = new float[var3];

			for (int var7 = 0; var7 < var4; ++var7) {
				var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
				var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
			}

			float[] var13 = new float[var3];

			for (int var8 = 0; var8 < var4; ++var8) {
				var13[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
				var13[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
			}

			float[] var14 = new float[var4];

			for (int var9 = 0; var9 < var5; ++var9) {
				var14[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
				var14[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
			}

			int[] var15 = new int[var5];
			int var10 = CollisionMap.iLog(var5 - 1);

			for (int var11 = 0; var11 < var5; ++var11) {
				var15[var11] = Widget.method4119(var11, var10);
			}

			if (var1 != 0) {
				field1367 = var6;
				field1368 = var13;
				field1369 = var14;
				field1371 = var15;
			} else {
				field1364 = var6;
				field1341 = var13;
				field1357 = var14;
				field1370 = var15;
			}
		}

		var1 = readBits(8) + 1;
		VorbisSample_codebooks = new VorbisCodebook[var1];

		for (var2 = 0; var2 < var1; ++var2) {
			VorbisSample_codebooks[var2] = new VorbisCodebook();
		}

		var2 = readBits(6) + 1;

		for (var3 = 0; var3 < var2; ++var3) {
			readBits(16);
		}

		var2 = readBits(6) + 1;
		VorbisSample_floors = new VorbisFloor[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			VorbisSample_floors[var3] = new VorbisFloor();
		}

		var3 = readBits(6) + 1;
		VorbisSample_residues = new VorbisResidue[var3];

		for (var4 = 0; var4 < var3; ++var4) {
			VorbisSample_residues[var4] = new VorbisResidue();
		}

		var4 = readBits(6) + 1;
		VorbisSample_mappings = new VorbisMapping[var4];

		for (var5 = 0; var5 < var4; ++var5) {
			VorbisSample_mappings[var5] = new VorbisMapping();
		}

		var5 = readBits(6) + 1;
		VorbisSample_blockFlags = new boolean[var5];
		VorbisSample_mapping = new int[var5];

		for (int var12 = 0; var12 < var5; ++var12) {
			VorbisSample_blockFlags[var12] = readBit() != 0;
			readBits(16);
			readBits(16);
			VorbisSample_mapping[var12] = readBits(8);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lii;)Z"
	)
	static boolean method2450(AbstractArchive var0) {
		if (!field1362) {
			byte[] var1 = var0.takeFile(0, 0);
			if (var1 == null) {
				return false;
			}

			method2424(var1);
			field1362 = true;
		}

		return true;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lii;II)Lcj;"
	)
	@Export("readMusicSample")
	static VorbisSample readMusicSample(AbstractArchive var0, int var1, int var2) {
		if (!method2450(var0)) {
			var0.tryLoadFile(var1, var2);
			return null;
		} else {
			byte[] var3 = var0.takeFile(var1, var2);
			return var3 == null ? null : new VorbisSample(var3);
		}
	}

	static {
		field1362 = false;
	}
}
