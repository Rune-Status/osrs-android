import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("ArchiveDisk")
public final class ArchiveDisk {
	@ObfuscatedName("c")
	@Export("ArchiveDisk_buffer")
	static byte[] ArchiveDisk_buffer;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lme;"
	)
	@Export("datFile")
	BufferedFile datFile;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lme;"
	)
	@Export("idxFile")
	BufferedFile idxFile;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 92062517
	)
	@Export("archive")
	int archive;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1875566271
	)
	@Export("maxEntrySize")
	int maxEntrySize;

	@ObfuscatedSignature(
		signature = "(ILme;Lme;I)V"
	)
	public ArchiveDisk(int var1, BufferedFile var2, BufferedFile var3, int var4) {
		this.datFile = null;
		this.idxFile = null;
		this.maxEntrySize = 65000;
		this.archive = var1;
		this.datFile = var2;
		this.idxFile = var3;
		this.maxEntrySize = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "1862196910"
	)
	@Export("read")
	public byte[] read(int var1) {
		synchronized(this.datFile) {
			byte[] var10000;
			try {
				Object var3;
				if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
					var3 = null;
					var10000 = (byte[])var3;
					return var10000;
				}

				this.idxFile.seek((long)(var1 * 6));
				this.idxFile.read(ArchiveDisk_buffer, 0, 6);
				int var4 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
				int var5 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
				if (var4 < 0 || var4 > this.maxEntrySize) {
					var3 = null;
					var10000 = (byte[])var3;
					return var10000;
				}

				if (var5 > 0 && (long)var5 <= this.datFile.length() / 520L) {
					byte[] var6 = new byte[var4];
					int var7 = 0;
					int var8 = 0;

					while (var7 < var4) {
						if (var5 == 0) {
							var3 = null;
							var10000 = (byte[])var3;
							return var10000;
						}

						this.datFile.seek((long)var5 * 520L);
						int var9 = var4 - var7;
						int var10;
						int var11;
						int var12;
						int var13;
						byte var14;
						if (var1 > 65535) {
							if (var9 > 510) {
								var9 = 510;
							}

							var14 = 10;
							this.datFile.read(ArchiveDisk_buffer, 0, var14 + var9);
							var10 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
							var11 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
							var12 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
							var13 = ArchiveDisk_buffer[9] & 255;
						} else {
							if (var9 > 512) {
								var9 = 512;
							}

							var14 = 8;
							this.datFile.read(ArchiveDisk_buffer, 0, var9 + var14);
							var10 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
							var11 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
							var12 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
							var13 = ArchiveDisk_buffer[7] & 255;
						}

						if (var10 == var1 && var11 == var8 && var13 == this.archive) {
							if (var12 >= 0 && (long)var12 <= this.datFile.length() / 520L) {
								int var15 = var14 + var9;

								for (int var16 = var14; var16 < var15; ++var16) {
									var6[var7++] = ArchiveDisk_buffer[var16];
								}

								var5 = var12;
								++var8;
								continue;
							}

							var3 = null;
							var10000 = (byte[])var3;
							return var10000;
						}

						var3 = null;
						var10000 = (byte[])var3;
						return var10000;
					}

					var10000 = var6;
					return var10000;
				}

				var3 = null;
				var10000 = (byte[])var3;
			} catch (IOException var18) {
				return null;
			}

			return var10000;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I[BII)Z",
		garbageValue = "2136581865"
	)
	@Export("write")
	public boolean write(int var1, byte[] var2, int var3) {
		synchronized(this.datFile) {
			if (var3 >= 0 && var3 <= this.maxEntrySize) {
				boolean var5 = this.write0(var1, var2, var3, true);
				if (!var5) {
					var5 = this.write0(var1, var2, var3, false);
				}

				return var5;
			} else {
				throw new IllegalArgumentException("" + this.archive + ',' + var1 + ',' + var3);
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I[BIZI)Z",
		garbageValue = "-1086221243"
	)
	@Export("write0")
	boolean write0(int var1, byte[] var2, int var3, boolean var4) {
		synchronized(this.datFile) {
			try {
				int var6;
				boolean var7;
				boolean var10000;
				if (var4) {
					if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
						var7 = false;
						var10000 = var7;
						return var10000;
					}

					this.idxFile.seek((long)(var1 * 6));
					this.idxFile.read(ArchiveDisk_buffer, 0, 6);
					var6 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
					if (var6 <= 0 || (long)var6 > this.datFile.length() / 520L) {
						var7 = false;
						var10000 = var7;
						return var10000;
					}
				} else {
					var6 = (int)((this.datFile.length() + 519L) / 520L);
					if (var6 == 0) {
						var6 = 1;
					}
				}

				ArchiveDisk_buffer[0] = (byte)(var3 >> 16);
				ArchiveDisk_buffer[1] = (byte)(var3 >> 8);
				ArchiveDisk_buffer[2] = (byte)var3;
				ArchiveDisk_buffer[3] = (byte)(var6 >> 16);
				ArchiveDisk_buffer[4] = (byte)(var6 >> 8);
				ArchiveDisk_buffer[5] = (byte)var6;
				this.idxFile.seek((long)(var1 * 6));
				this.idxFile.write(ArchiveDisk_buffer, 0, 6);
				int var8 = 0;
				int var9 = 0;

				while (true) {
					if (var8 < var3) {
						label154: {
							int var10 = 0;
							int var11;
							if (var4) {
								this.datFile.seek((long)var6 * 520L);
								int var12;
								int var13;
								if (var1 > 65535) {
									try {
										this.datFile.read(ArchiveDisk_buffer, 0, 10);
									} catch (EOFException var17) {
										break label154;
									}

									var11 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
									var12 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
									var10 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
									var13 = ArchiveDisk_buffer[9] & 255;
								} else {
									try {
										this.datFile.read(ArchiveDisk_buffer, 0, 8);
									} catch (EOFException var16) {
										break label154;
									}

									var11 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
									var12 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
									var10 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
									var13 = ArchiveDisk_buffer[7] & 255;
								}

								if (var11 != var1 || var12 != var9 || var13 != this.archive) {
									var7 = false;
									var10000 = var7;
									return var10000;
								}

								if (var10 < 0 || (long)var10 > this.datFile.length() / 520L) {
									var7 = false;
									var10000 = var7;
									return var10000;
								}
							}

							if (var10 == 0) {
								var4 = false;
								var10 = (int)((this.datFile.length() + 519L) / 520L);
								if (var10 == 0) {
									++var10;
								}

								if (var10 == var6) {
									++var10;
								}
							}

							if (var1 > 65535) {
								if (var3 - var8 <= 510) {
									var10 = 0;
								}

								ArchiveDisk_buffer[0] = (byte)(var1 >> 24);
								ArchiveDisk_buffer[1] = (byte)(var1 >> 16);
								ArchiveDisk_buffer[2] = (byte)(var1 >> 8);
								ArchiveDisk_buffer[3] = (byte)var1;
								ArchiveDisk_buffer[4] = (byte)(var9 >> 8);
								ArchiveDisk_buffer[5] = (byte)var9;
								ArchiveDisk_buffer[6] = (byte)(var10 >> 16);
								ArchiveDisk_buffer[7] = (byte)(var10 >> 8);
								ArchiveDisk_buffer[8] = (byte)var10;
								ArchiveDisk_buffer[9] = (byte)this.archive;
								this.datFile.seek(520L * (long)var6);
								this.datFile.write(ArchiveDisk_buffer, 0, 10);
								var11 = var3 - var8;
								if (var11 > 510) {
									var11 = 510;
								}

								this.datFile.write(var2, var8, var11);
								var8 += var11;
							} else {
								if (var3 - var8 <= 512) {
									var10 = 0;
								}

								ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
								ArchiveDisk_buffer[1] = (byte)var1;
								ArchiveDisk_buffer[2] = (byte)(var9 >> 8);
								ArchiveDisk_buffer[3] = (byte)var9;
								ArchiveDisk_buffer[4] = (byte)(var10 >> 16);
								ArchiveDisk_buffer[5] = (byte)(var10 >> 8);
								ArchiveDisk_buffer[6] = (byte)var10;
								ArchiveDisk_buffer[7] = (byte)this.archive;
								this.datFile.seek(520L * (long)var6);
								this.datFile.write(ArchiveDisk_buffer, 0, 8);
								var11 = var3 - var8;
								if (var11 > 512) {
									var11 = 512;
								}

								this.datFile.write(var2, var8, var11);
								var8 += var11;
							}

							var6 = var10;
							++var9;
							continue;
						}
					}

					var7 = true;
					var10000 = var7;
					return var10000;
				}
			} catch (IOException var18) {
				return false;
			}
		}
	}

	public String toString() {
		return "" + this.archive;
	}

	static {
		ArchiveDisk_buffer = new byte[520];
	}
}
