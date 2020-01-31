import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("qo")
	@ObfuscatedGetter(
		intValue = -1780442240
	)
	static int field640;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -153755923
	)
	@Export("cacheGamebuild")
	public static int cacheGamebuild;
	@ObfuscatedName("c")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ll;Ll;I)I",
		garbageValue = "231872829"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
		garbageValue = "295022584"
	)
	public static File method1311(String var0, String var1, int var2) {
		String var3 = var2 == 0 ? "" : "" + var2;
		JagexCache.JagexCache_locationFile = new File(UserComparator4.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		Buffer var7;
		int var8;
		File var9;
		int var11;
		if (JagexCache.JagexCache_locationFile.exists()) {
			try {
				AccessFile var10 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

				for (var7 = new Buffer((int)var10.length()); var7.offset < var7.array.length; var7.offset += var11) {
					var11 = var10.read(var7.array, var7.offset, var7.array.length - var7.offset);
					if (var11 == -1) {
						throw new IOException();
					}
				}

				var7.offset = 0;
				var11 = var7.readUnsignedByte();
				if (var11 < 1 || var11 > 3) {
					throw new IOException("" + var11);
				}

				int var12 = 0;
				if (var11 > 1) {
					var12 = var7.readUnsignedByte();
				}

				if (var11 <= 2) {
					var4 = var7.readStringCp1252NullCircumfixed();
					if (var12 == 1) {
						var5 = var7.readStringCp1252NullCircumfixed();
					}
				} else {
					var4 = var7.readCESU8();
					if (var12 == 1) {
						var5 = var7.readCESU8();
					}
				}

				var10.close();
			} catch (IOException var21) {
				var21.printStackTrace();
			}

			if (var4 != null) {
				var9 = new File(var4);
				if (!var9.exists()) {
					var4 = null;
				}
			}

			if (var4 != null) {
				var9 = new File(var4, "test.dat");

				boolean var22;
				try {
					RandomAccessFile var24 = new RandomAccessFile(var9, "rw");
					var8 = var24.read();
					var24.seek(0L);
					var24.write(var8);
					var24.seek(0L);
					var24.close();
					var9.delete();
					var22 = true;
				} catch (Exception var19) {
					var22 = false;
				}

				if (!var22) {
					var4 = null;
				}
			}
		}

		File var13;
		if (var4 == null && var2 == 0) {
			label134:
			for (int var23 = 0; var23 < class42.field373.length; ++var23) {
				for (var11 = 0; var11 < ChatChannel.field1291.length; ++var11) {
					File var28 = new File(ChatChannel.field1291[var11] + class42.field373[var23] + File.separatorChar + var0 + File.separatorChar);
					if (var28.exists()) {
						var13 = new File(var28, "test.dat");

						boolean var14;
						try {
							RandomAccessFile var15 = new RandomAccessFile(var13, "rw");
							int var16 = var15.read();
							var15.seek(0L);
							var15.write(var16);
							var15.seek(0L);
							var15.close();
							var13.delete();
							var14 = true;
						} catch (Exception var18) {
							var14 = false;
						}

						if (var14) {
							var4 = var28.toString();
							var6 = true;
							break label134;
						}
					}
				}
			}
		}

		if (var4 == null) {
			var4 = UserComparator4.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var6 = true;
		}

		File var25;
		if (var5 != null) {
			var25 = new File(var5);
			var9 = new File(var4);

			try {
				File[] var26 = var25.listFiles();
				File[] var29 = var26;

				for (var8 = 0; var8 < var29.length; ++var8) {
					var13 = var29[var8];
					File var31 = new File(var9, var13.getName());
					boolean var32 = var13.renameTo(var31);
					if (!var32) {
						throw new IOException();
					}
				}
			} catch (Exception var20) {
				var20.printStackTrace();
			}

			var6 = true;
		}

		if (var6) {
			var25 = new File(var4);
			var7 = null;

			try {
				AccessFile var27 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
				Buffer var30 = new Buffer(500);
				var30.writeByte(3);
				var30.writeByte(var7 != null ? 1 : 0);
				var30.writeCESU8(var25.getPath());
				if (var7 != null) {
					var30.writeCESU8("");
				}

				var27.write(var30.array, 0, var30.offset);
				var27.close();
			} catch (IOException var17) {
				var17.printStackTrace();
			}
		}

		return new File(var4);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "110"
	)
	static void method1308() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1235[var0] = null;
			Players.field1237[var0] = 1;
		}

	}
}
