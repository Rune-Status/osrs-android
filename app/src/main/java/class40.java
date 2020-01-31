import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class40 {
	@ObfuscatedName("v")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -207951793
	)
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("t")
	@Export("tileTemplates")
	byte[][][] tileTemplates;

	class40(int var1) {
		this.pixelsPerTile = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "-1008655546"
	)
	void method736(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (var7 != 0 && this.pixelsPerTile != 0 && this.tileTemplates != null) {
			var8 = this.method737(var8, var7);
			var7 = this.method740(var7);
			Rasterizer2D.Rasterizer2D_drawGradientPixels(var1, var2, var5, var6, var3, var4, this.tileTemplates[var7 - 1][var8], this.pixelsPerTile);
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-88869818"
	)
	int method737(int var1, int var2) {
		if (var2 == 9) {
			var1 = var1 + 1 & 3;
		}

		if (var2 == 10) {
			var1 = var1 + 3 & 3;
		}

		if (var2 == 11) {
			var1 = var1 + 3 & 3;
		}

		return var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-50"
	)
	int method740(int var1) {
		if (var1 != 9 && var1 != 10) {
			return var1 == 11 ? 8 : var1;
		} else {
			return 1;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1894948040"
	)
	@Export("init")
	void init() {
		if (this.tileTemplates == null) {
			this.tileTemplates = new byte[8][4][];
			this.init0();
			this.init1();
			this.init2();
			this.init3();
			this.init4();
			this.init5();
			this.init6();
			this.init7();
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-382009936"
	)
	@Export("init0")
	void init0() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[0][3] = var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1984222504"
	)
	@Export("init1")
	void init1() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[1][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var2 >= 0 && var2 < var1.length) {
					if (var4 >= var3 << 1) {
						var1[var2] = -1;
					}

					++var2;
				} else {
					++var2;
				}
			}
		}

		this.tileTemplates[1][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[1][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[1][3] = var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "728163043"
	)
	@Export("init2")
	void init2() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[2][3] = var1;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1802429738"
	)
	@Export("init3")
	void init3() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[3][3] = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-647414873"
	)
	@Export("init4")
	void init4() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = this.pixelsPerTile - 1; var3 >= 0; --var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
				if (var4 >= var3 >> 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var2 = 0;

		for (var3 = 0; var3 < this.pixelsPerTile; ++var3) {
			for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
				if (var4 <= var3 << 1) {
					var1[var2] = -1;
				}

				++var2;
			}
		}

		this.tileTemplates[4][3] = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1171855086"
	)
	@Export("init5")
	void init5() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		boolean var2 = false;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var3 = 0;

		int var4;
		int var5;
		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var5 <= this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[5][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var4 <= this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[5][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var5 >= this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[5][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var4 >= this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[5][3] = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("init6")
	void init6() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		boolean var2 = false;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var3 = 0;

		int var4;
		int var5;
		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var5 <= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[6][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var5 <= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[6][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
			for (var5 = this.pixelsPerTile - 1; var5 >= 0; --var5) {
				if (var5 <= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[6][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = this.pixelsPerTile - 1; var5 >= 0; --var5) {
				if (var5 <= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[6][3] = var1;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-106861274"
	)
	@Export("init7")
	void init7() {
		byte[] var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		boolean var2 = false;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		int var3 = 0;

		int var4;
		int var5;
		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var5 >= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[7][0] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
			for (var5 = 0; var5 < this.pixelsPerTile; ++var5) {
				if (var5 >= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[7][1] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = this.pixelsPerTile - 1; var4 >= 0; --var4) {
			for (var5 = this.pixelsPerTile - 1; var5 >= 0; --var5) {
				if (var5 >= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[7][2] = var1;
		var1 = new byte[this.pixelsPerTile * this.pixelsPerTile];
		var3 = 0;

		for (var4 = 0; var4 < this.pixelsPerTile; ++var4) {
			for (var5 = this.pixelsPerTile - 1; var5 >= 0; --var5) {
				if (var5 >= var4 - this.pixelsPerTile / 2) {
					var1[var3] = -1;
				}

				++var3;
			}
		}

		this.tileTemplates[7][3] = var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lks;II)Z",
		garbageValue = "-1391671587"
	)
	@Export("updateExternalPlayer")
	static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
		int var2 = var0.readBits(2);
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (var2 == 0) {
			if (var0.readBits(1) != 0) {
				updateExternalPlayer(var0, var1);
			}

			var3 = var0.readBits(13);
			var4 = var0.readBits(13);
			boolean var11 = var0.readBits(1) == 1;
			if (var11) {
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}

			if (Client.players[var1] != null) {
				throw new RuntimeException();
			} else {
				Player var12 = Client.players[var1] = new Player();
				var12.index = var1;
				if (Players.field1235[var1] != null) {
					var12.read(Players.field1235[var1]);
				}

				var12.orientation = Players.Players_orientations[var1];
				var12.targetIndex = Players.Players_targetIndices[var1];
				var5 = Players.Players_regions[var1];
				var6 = var5 >> 28;
				var7 = var5 >> 14 & 255;
				var8 = var5 & 255;
				var12.pathTraversed[0] = Players.field1237[var1];
				var12.plane = (byte)var6;
				var12.resetPath((var7 << 13) + var3 - Messages.baseX * 64, (var8 << 13) + var4 - Language.baseY * 64);
				var12.field621 = false;
				return true;
			}
		} else if (var2 == 1) {
			var3 = var0.readBits(2);
			var4 = Players.Players_regions[var1];
			Players.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
			return false;
		} else {
			int var9;
			int var10;
			if (var2 == 2) {
				var3 = var0.readBits(5);
				var4 = var3 >> 3;
				var9 = var3 & 7;
				var10 = Players.Players_regions[var1];
				var5 = (var10 >> 28) + var4 & 3;
				var6 = var10 >> 14 & 255;
				var7 = var10 & 255;
				if (var9 == 0) {
					--var6;
					--var7;
				}

				if (var9 == 1) {
					--var7;
				}

				if (var9 == 2) {
					++var6;
					--var7;
				}

				if (var9 == 3) {
					--var6;
				}

				if (var9 == 4) {
					++var6;
				}

				if (var9 == 5) {
					--var6;
					++var7;
				}

				if (var9 == 6) {
					++var7;
				}

				if (var9 == 7) {
					++var6;
					++var7;
				}

				Players.Players_regions[var1] = (var6 << 14) + var7 + (var5 << 28);
				return false;
			} else {
				var3 = var0.readBits(18);
				var4 = var3 >> 16;
				var9 = var3 >> 8 & 255;
				var10 = var3 & 255;
				var5 = Players.Players_regions[var1];
				var6 = (var5 >> 28) + var4 & 3;
				var7 = var9 + (var5 >> 14) & 255;
				var8 = var10 + var5 & 255;
				Players.Players_regions[var1] = (var7 << 14) + var8 + (var6 << 28);
				return false;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-56"
	)
	public static String method735(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				char var6;
				if (var5 != 181 && var5 != 402) {
					var6 = Character.toTitleCase(var5);
				} else {
					var6 = var5;
				}

				var5 = var6;
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}
}
