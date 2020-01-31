import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2745(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2728(1, 0),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2729(2, 0),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2743(3, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2731(9, 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2732(4, 1),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2733(5, 1),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2734(6, 1),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2749(7, 1),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2736(8, 1),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2737(12, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2738(13, 2),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2742(14, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2727(15, 2),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2741(16, 2),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2750(17, 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2730(18, 2),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2744(19, 2),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2740(20, 2),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2746(21, 2),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2747(10, 2),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2748(11, 2),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2751(22, 3);

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static IndexedSprite field2739;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1956687069
	)
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	private WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "57455087"
	)
	public static boolean method4187() {
		long var0 = WorldMapIcon_0.currentTimeMillis();
		int var2 = (int)(var0 - NetCache.field3170);
		NetCache.field3170 = var0;
		if (var2 > 200) {
			var2 = 200;
		}

		NetCache.NetCache_loadTime += var2;
		if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
			return true;
		} else if (NetCache.NetCache_socket == null) {
			return false;
		} else {
			try {
				if (NetCache.NetCache_loadTime > 30000) {
					throw new IOException();
				} else {
					NetFileRequest var3;
					Buffer var4;
					while (NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
						var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
						var4 = new Buffer(4);
						var4.writeByte(1);
						var4.writeMedium((int)var3.key);
						NetCache.NetCache_socket.write(var4.array, 0, 4);
						NetCache.NetCache_pendingPriorityResponses.put(var3, var3.key);
						--NetCache.NetCache_pendingPriorityWritesCount;
						++NetCache.NetCache_pendingPriorityResponsesCount;
					}

					while (NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
						var3 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.removeLast();
						var4 = new Buffer(4);
						var4.writeByte(0);
						var4.writeMedium((int)var3.key);
						NetCache.NetCache_socket.write(var4.array, 0, 4);
						var3.removeDual();
						NetCache.NetCache_pendingResponses.put(var3, var3.key);
						--NetCache.NetCache_pendingWritesCount;
						++NetCache.NetCache_pendingResponsesCount;
					}

					for (int var5 = 0; var5 < 100; ++var5) {
						int var6 = NetCache.NetCache_socket.available();
						if (var6 < 0) {
							throw new IOException();
						}

						if (var6 == 0) {
							break;
						}

						NetCache.NetCache_loadTime = 0;
						byte var7 = 0;
						if (GrandExchangeEvent.NetCache_currentResponse == null) {
							var7 = 8;
						} else if (NetCache.field3181 == 0) {
							var7 = 1;
						}

						int var8;
						int var9;
						int var10;
						int var11;
						byte[] var12;
						int var13;
						Buffer var14;
						if (var7 > 0) {
							var8 = var7 - NetCache.NetCache_responseHeaderBuffer.offset;
							if (var8 > var6) {
								var8 = var6;
							}

							NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
							if (NetCache.field3184 != 0) {
								for (var9 = 0; var9 < var8; ++var9) {
									var12 = NetCache.NetCache_responseHeaderBuffer.array;
									var13 = var9 + NetCache.NetCache_responseHeaderBuffer.offset;
									var12[var13] ^= NetCache.field3184;
								}
							}

							var14 = NetCache.NetCache_responseHeaderBuffer;
							var14.offset += var8;
							if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
								break;
							}

							if (GrandExchangeEvent.NetCache_currentResponse == null) {
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
								var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
								int var15 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var11 = NetCache.NetCache_responseHeaderBuffer.readInt();
								long var16 = (long)(var10 + (var9 << 16));
								NetFileRequest var18 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var16);
								User.field3583 = true;
								if (var18 == null) {
									var18 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var16);
									User.field3583 = false;
								}

								if (var18 == null) {
									throw new IOException();
								}

								int var19 = var15 == 0 ? 5 : 9;
								GrandExchangeEvent.NetCache_currentResponse = var18;
								VertexNormal.NetCache_responseArchiveBuffer = new Buffer(var19 + var11 + GrandExchangeEvent.NetCache_currentResponse.padding);
								VertexNormal.NetCache_responseArchiveBuffer.writeByte(var15);
								VertexNormal.NetCache_responseArchiveBuffer.writeInt(var11);
								NetCache.field3181 = 8;
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
							} else if (NetCache.field3181 == 0) {
								if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
									NetCache.field3181 = 1;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else {
									GrandExchangeEvent.NetCache_currentResponse = null;
								}
							}
						} else {
							var8 = VertexNormal.NetCache_responseArchiveBuffer.array.length - GrandExchangeEvent.NetCache_currentResponse.padding;
							var9 = 512 - NetCache.field3181;
							if (var9 > var8 - VertexNormal.NetCache_responseArchiveBuffer.offset) {
								var9 = var8 - VertexNormal.NetCache_responseArchiveBuffer.offset;
							}

							if (var9 > var6) {
								var9 = var6;
							}

							NetCache.NetCache_socket.read(VertexNormal.NetCache_responseArchiveBuffer.array, VertexNormal.NetCache_responseArchiveBuffer.offset, var9);
							if (NetCache.field3184 != 0) {
								for (var10 = 0; var10 < var9; ++var10) {
									var12 = VertexNormal.NetCache_responseArchiveBuffer.array;
									var13 = VertexNormal.NetCache_responseArchiveBuffer.offset + var10;
									var12[var13] ^= NetCache.field3184;
								}
							}

							var14 = VertexNormal.NetCache_responseArchiveBuffer;
							var14.offset += var9;
							NetCache.field3181 += var9;
							if (var8 == VertexNormal.NetCache_responseArchiveBuffer.offset) {
								if (GrandExchangeEvent.NetCache_currentResponse.key == 16711935L) {
									class4.NetCache_reference = VertexNormal.NetCache_responseArchiveBuffer;

									for (var10 = 0; var10 < 256; ++var10) {
										Archive var23 = NetCache.NetCache_archives[var10];
										if (var23 != null) {
											class4.NetCache_reference.offset = var10 * 8 + 5;
											var11 = class4.NetCache_reference.readInt();
											int var24 = class4.NetCache_reference.readInt();
											var23.loadIndex(var11, var24);
										}
									}
								} else {
									NetCache.NetCache_crc.reset();
									NetCache.NetCache_crc.update(VertexNormal.NetCache_responseArchiveBuffer.array, 0, var8);
									var10 = (int)NetCache.NetCache_crc.getValue();
									if (var10 != GrandExchangeEvent.NetCache_currentResponse.crc) {
										try {
											NetCache.NetCache_socket.close();
										} catch (Exception var21) {
										}

										++NetCache.NetCache_crcMismatches;
										NetCache.NetCache_socket = null;
										NetCache.field3184 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									NetCache.NetCache_crcMismatches = 0;
									NetCache.NetCache_ioExceptions = 0;
									GrandExchangeEvent.NetCache_currentResponse.archive.write((int)(GrandExchangeEvent.NetCache_currentResponse.key & 65535L), VertexNormal.NetCache_responseArchiveBuffer.array, (GrandExchangeEvent.NetCache_currentResponse.key & 16711680L) == 16711680L, User.field3583);
								}

								GrandExchangeEvent.NetCache_currentResponse.remove();
								if (User.field3583) {
									--NetCache.NetCache_pendingPriorityResponsesCount;
								} else {
									--NetCache.NetCache_pendingResponsesCount;
								}

								NetCache.field3181 = 0;
								GrandExchangeEvent.NetCache_currentResponse = null;
								VertexNormal.NetCache_responseArchiveBuffer = null;
							} else {
								if (NetCache.field3181 != 512) {
									break;
								}

								NetCache.field3181 = 0;
							}
						}
					}

					return true;
				}
			} catch (IOException var22) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var20) {
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
				return false;
			}
		}
	}
}
