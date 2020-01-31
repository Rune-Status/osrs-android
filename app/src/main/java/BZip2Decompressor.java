import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("BZip2Decompressor")
public final class BZip2Decompressor {
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lki;"
	)
	@Export("BZip2Decompressor_state")
	static BZip2State BZip2Decompressor_state;

	@ObfuscatedName("c")
	@Export("BZip2Decompressor_decompress")
	public static int BZip2Decompressor_decompress(byte[] var0, int var1, byte[] var2, int var3, int var4) {
		synchronized(BZip2Decompressor_state) {
			BZip2Decompressor_state.inputArray = var2;
			BZip2Decompressor_state.nextByte = var4;
			BZip2Decompressor_state.outputArray = var0;
			BZip2Decompressor_state.next_out = 0;
			BZip2Decompressor_state.outputLength = var1;
			BZip2Decompressor_state.bsLive = 0;
			BZip2Decompressor_state.bsBuff = 0;
			BZip2Decompressor_state.nextBit_unused = 0;
			BZip2Decompressor_state.field3729 = 0;
			BZip2Decompressor_decompress(BZip2Decompressor_state);
			var1 -= BZip2Decompressor_state.outputLength;
			BZip2Decompressor_state.inputArray = null;
			BZip2Decompressor_state.outputArray = null;
			return var1;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lki;)V"
	)
	static void method5836(BZip2State var0) {
		byte var1 = var0.out_char;
		int var2 = var0.su_rNToGo;
		int var3 = var0.nblocks_used;
		int var4 = var0.su_ch2;
		int[] var5 = WorldMapManager.BZip2Decompressor_block;
		int var6 = var0.field3746;
		byte[] var7 = var0.outputArray;
		int var8 = var0.next_out;
		int var9 = var0.outputLength;
		int var10 = var0.field3754 + 1;

		label61:
		while (true) {
			if (var2 > 0) {
				while (true) {
					if (var9 == 0) {
						break label61;
					}

					if (var2 == 1) {
						if (var9 == 0) {
							var2 = 1;
							break label61;
						}

						var7[var8] = var1;
						++var8;
						--var9;
						break;
					}

					var7[var8] = var1;
					--var2;
					++var8;
					--var9;
				}
			}

			while (var3 != var10) {
				var1 = (byte)var4;
				var6 = var5[var6];
				byte var11 = (byte)var6;
				var6 >>= 8;
				++var3;
				if (var11 != var4) {
					var4 = var11;
					if (var9 == 0) {
						var2 = 1;
						break label61;
					}

					var7[var8] = var1;
					++var8;
					--var9;
				} else {
					if (var3 != var10) {
						var2 = 2;
						var6 = var5[var6];
						var11 = (byte)var6;
						var6 >>= 8;
						++var3;
						if (var3 != var10) {
							if (var11 != var4) {
								var4 = var11;
							} else {
								var2 = 3;
								var6 = var5[var6];
								var11 = (byte)var6;
								var6 >>= 8;
								++var3;
								if (var3 != var10) {
									if (var11 != var4) {
										var4 = var11;
									} else {
										var6 = var5[var6];
										var11 = (byte)var6;
										var6 >>= 8;
										++var3;
										var2 = (var11 & 255) + 4;
										var6 = var5[var6];
										var4 = (byte)var6;
										var6 >>= 8;
										++var3;
									}
								}
							}
						}
						continue label61;
					}

					if (var9 == 0) {
						var2 = 1;
						break label61;
					}

					var7[var8] = var1;
					++var8;
					--var9;
				}
			}

			var2 = 0;
			break;
		}

		int var12 = var0.field3729;
		var0.field3729 += var9 - var9;
		if (var0.field3729 < var12) {
		}

		var0.out_char = var1;
		var0.su_rNToGo = var2;
		var0.nblocks_used = var3;
		var0.su_ch2 = var4;
		WorldMapManager.BZip2Decompressor_block = var5;
		var0.field3746 = var6;
		var0.outputArray = var7;
		var0.next_out = var8;
		var0.outputLength = var9;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lki;)V"
	)
	@Export("BZip2Decompressor_decompress")
	static void BZip2Decompressor_decompress(BZip2State var0) {
		boolean var1 = false;
		boolean var2 = false;
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		boolean var8 = false;
		boolean var9 = false;
		boolean var10 = false;
		boolean var11 = false;
		boolean var12 = false;
		boolean var13 = false;
		boolean var14 = false;
		boolean var15 = false;
		boolean var16 = false;
		boolean var17 = false;
		boolean var18 = false;
		int var19 = 0;
		int[] var20 = null;
		int[] var21 = null;
		int[] var22 = null;
		var0.blockSize100k = 1410065408;
		if (WorldMapManager.BZip2Decompressor_block == null) {
			WorldMapManager.BZip2Decompressor_block = new int[var0.blockSize100k * 100000];
		}

		boolean var23 = true;

		while (true) {
			while (var23) {
				byte var24 = BZip2Decompressor_readNextByte(var0);
				if (var24 == 23) {
					return;
				}

				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextByte(var0);
				var24 = BZip2Decompressor_readNextBit(var0);
				if (var24 != 0) {
				}

				var0.originalPointer = 0;
				var24 = BZip2Decompressor_readNextByte(var0);
				var0.originalPointer = var0.originalPointer << 8 | var24 & 255;
				var24 = BZip2Decompressor_readNextByte(var0);
				var0.originalPointer = var0.originalPointer << 8 | var24 & 255;
				var24 = BZip2Decompressor_readNextByte(var0);
				var0.originalPointer = var0.originalPointer << 8 | var24 & 255;

				int var25;
				for (var25 = 0; var25 < 16; ++var25) {
					var24 = BZip2Decompressor_readNextBit(var0);
					if (var24 == 1) {
						var0.inUse16[var25] = true;
					} else {
						var0.inUse16[var25] = false;
					}
				}

				for (var25 = 0; var25 < 256; ++var25) {
					var0.inUse[var25] = false;
				}

				int var26;
				for (var25 = 0; var25 < 16; ++var25) {
					if (var0.inUse16[var25]) {
						for (var26 = 0; var26 < 16; ++var26) {
							var24 = BZip2Decompressor_readNextBit(var0);
							if (var24 == 1) {
								var0.inUse[var26 + var25 * 16] = true;
							}
						}
					}
				}

				makeMaps(var0);
				int var27 = var0.nInUse + 2;
				int var28 = BZip2Decompressor_readBits(3, var0);
				int var29 = BZip2Decompressor_readBits(15, var0);

				for (var25 = 0; var25 < var29; ++var25) {
					var26 = 0;

					while (true) {
						var24 = BZip2Decompressor_readNextBit(var0);
						if (var24 == 0) {
							var0.selectorMtf[var25] = (byte)var26;
							break;
						}

						++var26;
					}
				}

				byte[] var30 = new byte[6];

				byte var31;
				for (var31 = 0; var31 < var28; var30[var31] = var31++) {
				}

				for (var25 = 0; var25 < var29; ++var25) {
					var31 = var0.selectorMtf[var25];

					byte var32;
					for (var32 = var30[var31]; var31 > 0; --var31) {
						var30[var31] = var30[var31 - 1];
					}

					var30[0] = var32;
					var0.selector[var25] = var32;
				}

				int var33;
				int var52;
				for (var52 = 0; var52 < var28; ++var52) {
					var33 = BZip2Decompressor_readBits(5, var0);

					for (var25 = 0; var25 < var27; ++var25) {
						while (true) {
							var24 = BZip2Decompressor_readNextBit(var0);
							if (var24 == 0) {
								var0.temp_charArray2d[var52][var25] = (byte)var33;
								break;
							}

							var24 = BZip2Decompressor_readNextBit(var0);
							if (var24 == 0) {
								++var33;
							} else {
								--var33;
							}
						}
					}
				}

				for (var52 = 0; var52 < var28; ++var52) {
					byte var53 = 32;
					byte var34 = 0;

					for (var25 = 0; var25 < var27; ++var25) {
						if (var0.temp_charArray2d[var52][var25] > var34) {
							var34 = var0.temp_charArray2d[var52][var25];
						}

						if (var0.temp_charArray2d[var52][var25] < var53) {
							var53 = var0.temp_charArray2d[var52][var25];
						}
					}

					BZip2Decompressor_createHuffmanTables(var0.limit[var52], var0.base[var52], var0.perm[var52], var0.temp_charArray2d[var52], var53, var34, var27);
					var0.minLens[var52] = var53;
				}

				var33 = var0.nInUse + 1;
				int var54 = -1;
				byte var35 = 0;

				for (var25 = 0; var25 <= 255; ++var25) {
					var0.unzftab[var25] = 0;
				}

				int var36 = 4095;

				int var37;
				int var38;
				for (var37 = 15; var37 >= 0; --var37) {
					for (var38 = 15; var38 >= 0; --var38) {
						var0.ll8[var36] = (byte)(var38 + var37 * 16);
						--var36;
					}

					var0.getAndMoveToFrontDecode_yy[var37] = var36 + 1;
				}

				int var39 = 0;
				byte var40;
				if (var35 == 0) {
					++var54;
					var35 = 50;
					var40 = var0.selector[var54];
					var19 = var0.minLens[var40];
					var20 = var0.limit[var40];
					var22 = var0.perm[var40];
					var21 = var0.base[var40];
				}

				int var41 = var35 - 1;
				int var42 = var19;

				int var43;
				byte var44;
				for (var43 = BZip2Decompressor_readBits(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
					++var42;
					var44 = BZip2Decompressor_readNextBit(var0);
				}

				int var45 = var22[var43 - var21[var42]];

				while (true) {
					int[] var46;
					int var48;
					while (var45 != var33) {
						int var49;
						if (var45 != 0 && var45 != 1) {
							var48 = var45 - 1;
							int var10003;
							int var50;
							if (var48 < 16) {
								var49 = var0.getAndMoveToFrontDecode_yy[0];

								for (var24 = var0.ll8[var49 + var48]; var48 > 3; var48 -= 4) {
									var50 = var49 + var48;
									var0.ll8[var50] = var0.ll8[var50 - 1];
									var0.ll8[var50 - 1] = var0.ll8[var50 - 2];
									var0.ll8[var50 - 2] = var0.ll8[var50 - 3];
									var0.ll8[var50 - 3] = var0.ll8[var50 - 4];
								}

								while (var48 > 0) {
									var0.ll8[var49 + var48] = var0.ll8[var49 + var48 - 1];
									--var48;
								}

								var0.ll8[var49] = var24;
							} else {
								var50 = var48 / 16;
								int var51 = var48 % 16;
								var49 = var0.getAndMoveToFrontDecode_yy[var50] + var51;

								for (var24 = var0.ll8[var49]; var49 > var0.getAndMoveToFrontDecode_yy[var50]; --var49) {
									var0.ll8[var49] = var0.ll8[var49 - 1];
								}

								for (var10003 = var0.getAndMoveToFrontDecode_yy[var50]++; var50 > 0; --var50) {
									var10003 = var0.getAndMoveToFrontDecode_yy[var50]--;
									var0.ll8[var0.getAndMoveToFrontDecode_yy[var50]] = var0.ll8[var0.getAndMoveToFrontDecode_yy[var50 - 1] + 16 - 1];
								}

								var10003 = var0.getAndMoveToFrontDecode_yy[0]--;
								var0.ll8[var0.getAndMoveToFrontDecode_yy[0]] = var24;
								if (var0.getAndMoveToFrontDecode_yy[0] == 0) {
									var36 = 4095;

									for (var37 = 15; var37 >= 0; --var37) {
										for (var38 = 15; var38 >= 0; --var38) {
											var0.ll8[var36] = var0.ll8[var0.getAndMoveToFrontDecode_yy[var37] + var38];
											--var36;
										}

										var0.getAndMoveToFrontDecode_yy[var37] = var36 + 1;
									}
								}
							}

							var10003 = var0.unzftab[var0.seqToUnseq[var24 & 255] & 255]++;
							WorldMapManager.BZip2Decompressor_block[var39] = var0.seqToUnseq[var24 & 255] & 255;
							++var39;
							if (var41 == 0) {
								++var54;
								var41 = 50;
								var40 = var0.selector[var54];
								var19 = var0.minLens[var40];
								var20 = var0.limit[var40];
								var22 = var0.perm[var40];
								var21 = var0.base[var40];
							}

							--var41;
							var42 = var19;

							for (var43 = BZip2Decompressor_readBits(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
								++var42;
								var44 = BZip2Decompressor_readNextBit(var0);
							}

							var45 = var22[var43 - var21[var42]];
						} else {
							var48 = -1;
							var49 = 1;

							do {
								if (var45 == 0) {
									var48 += var49;
								} else if (var45 == 1) {
									var48 += var49 * 2;
								}

								var49 *= 2;
								if (var41 == 0) {
									++var54;
									var41 = 50;
									var40 = var0.selector[var54];
									var19 = var0.minLens[var40];
									var20 = var0.limit[var40];
									var22 = var0.perm[var40];
									var21 = var0.base[var40];
								}

								--var41;
								var42 = var19;

								for (var43 = BZip2Decompressor_readBits(var19, var0); var43 > var20[var42]; var43 = var43 << 1 | var44) {
									++var42;
									var44 = BZip2Decompressor_readNextBit(var0);
								}

								var45 = var22[var43 - var21[var42]];
							} while(var45 == 0 || var45 == 1);

							++var48;
							var24 = var0.seqToUnseq[var0.ll8[var0.getAndMoveToFrontDecode_yy[0]] & 255];
							var46 = var0.unzftab;

							for (var46[var24 & 255] += var48; var48 > 0; --var48) {
								WorldMapManager.BZip2Decompressor_block[var39] = var24 & 255;
								++var39;
							}
						}
					}

					var0.su_rNToGo = 0;
					var0.out_char = 0;
					var0.cftab[0] = 0;

					for (var25 = 1; var25 <= 256; ++var25) {
						var0.cftab[var25] = var0.unzftab[var25 - 1];
					}

					for (var25 = 1; var25 <= 256; ++var25) {
						var46 = var0.cftab;
						var46[var25] += var0.cftab[var25 - 1];
					}

					for (var25 = 0; var25 < var39; ++var25) {
						var24 = (byte)(WorldMapManager.BZip2Decompressor_block[var25] & 255);
						var46 = WorldMapManager.BZip2Decompressor_block;
						var48 = var0.cftab[var24 & 255];
						var46[var48] |= var25 << 8;
						++var0.cftab[var24 & 255];
					}

					var0.field3746 = WorldMapManager.BZip2Decompressor_block[var0.originalPointer] >> 8;
					var0.nblocks_used = 0;
					var0.field3746 = WorldMapManager.BZip2Decompressor_block[var0.field3746];
					var0.su_ch2 = (byte)(var0.field3746 & 255);
					var0.field3746 >>= 8;
					++var0.nblocks_used;
					var0.field3754 = var39;
					method5836(var0);
					if (var0.field3754 + 1 == var0.nblocks_used && var0.su_rNToGo == 0) {
						var23 = true;
						break;
					}

					var23 = false;
					break;
				}
			}

			return;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lki;)B"
	)
	@Export("BZip2Decompressor_readNextByte")
	static byte BZip2Decompressor_readNextByte(BZip2State var0) {
		return (byte)BZip2Decompressor_readBits(8, var0);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lki;)B"
	)
	@Export("BZip2Decompressor_readNextBit")
	static byte BZip2Decompressor_readNextBit(BZip2State var0) {
		return (byte)BZip2Decompressor_readBits(1, var0);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILki;)I"
	)
	@Export("BZip2Decompressor_readBits")
	static int BZip2Decompressor_readBits(int var0, BZip2State var1) {
		while (var1.bsLive < var0) {
			var1.bsBuff = var1.bsBuff << 8 | var1.inputArray[var1.nextByte] & 255;
			var1.bsLive += 8;
			++var1.nextByte;
			++var1.nextBit_unused;
			if (var1.nextBit_unused == 0) {
			}
		}

		int var2 = var1.bsBuff >> var1.bsLive - var0 & (1 << var0) - 1;
		var1.bsLive -= var0;
		return var2;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lki;)V"
	)
	@Export("makeMaps")
	static void makeMaps(BZip2State var0) {
		var0.nInUse = 0;

		for (int var1 = 0; var1 < 256; ++var1) {
			if (var0.inUse[var1]) {
				var0.seqToUnseq[var0.nInUse] = (byte)var1;
				++var0.nInUse;
			}
		}

	}

	@ObfuscatedName("l")
	@Export("BZip2Decompressor_createHuffmanTables")
	static void BZip2Decompressor_createHuffmanTables(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
		int var7 = 0;

		int var8;
		int var9;
		for (var8 = var4; var8 <= var5; ++var8) {
			for (var9 = 0; var9 < var6; ++var9) {
				if (var8 == var3[var9]) {
					var2[var7] = var9;
					++var7;
				}
			}
		}

		for (var8 = 0; var8 < 23; ++var8) {
			var1[var8] = 0;
		}

		for (var8 = 0; var8 < var6; ++var8) {
			++var1[var3[var8] + 1];
		}

		for (var8 = 1; var8 < 23; ++var8) {
			var1[var8] += var1[var8 - 1];
		}

		for (var8 = 0; var8 < 23; ++var8) {
			var0[var8] = 0;
		}

		var9 = 0;

		for (var8 = var4; var8 <= var5; ++var8) {
			var9 += var1[var8 + 1] - var1[var8];
			var0[var8] = var9 - 1;
			var9 <<= 1;
		}

		for (var8 = var4 + 1; var8 <= var5; ++var8) {
			var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
		}

	}

	static {
		BZip2Decompressor_state = new BZip2State();
	}
}
