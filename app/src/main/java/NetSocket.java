import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fe")
@Implements("NetSocket")
public final class NetSocket extends AbstractSocket implements Runnable {
	@ObfuscatedName("sd")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("platformInfo")
	static PlatformInfo platformInfo;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("ep")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = -1177586883
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("c")
	@Export("inputStream")
	InputStream inputStream;
	@ObfuscatedName("t")
	@Export("outputStream")
	OutputStream outputStream;
	@ObfuscatedName("o")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("e")
	@Export("isClosed")
	boolean isClosed;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lff;"
	)
	@Export("taskHandler")
	TaskHandler taskHandler;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("d")
	@Export("outBuffer")
	byte[] outBuffer;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -602302945
	)
	@Export("outLength")
	int outLength;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -578221925
	)
	@Export("outOffset")
	int outOffset;
	@ObfuscatedName("m")
	@Export("exceptionWriting")
	boolean exceptionWriting;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1215285735
	)
	@Export("bufferLength")
	final int bufferLength;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 639451829
	)
	@Export("maxPacketLength")
	final int maxPacketLength;

	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;Lff;I)V"
	)
	public NetSocket(Socket var1, TaskHandler var2, int var3) throws IOException {
		this.isClosed = false;
		this.outLength = 0;
		this.outOffset = 0;
		this.exceptionWriting = false;
		this.taskHandler = var2;
		this.socket = var1;
		this.bufferLength = var3;
		this.maxPacketLength = var3 - 100;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.socket.setReceiveBufferSize(65536);
		this.socket.setSendBufferSize(65536);
		this.inputStream = this.socket.getInputStream();
		this.outputStream = this.socket.getOutputStream();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-259367480"
	)
	@Export("close")
	public void close() {
		if (!this.isClosed) {
			synchronized(this) {
				this.isClosed = true;
				this.notifyAll();
			}

			if (this.task != null) {
				while (this.task.status == 0) {
					FriendLoginUpdate.method5325(1L);
				}

				if (this.task.status == 1) {
					try {
						((Thread)this.task.result).join();
					} catch (InterruptedException var3) {
					}
				}
			}

			this.task = null;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-108"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.isClosed ? 0 : this.inputStream.read();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2004103994"
	)
	@Export("available")
	public int available() throws IOException {
		return this.isClosed ? 0 : this.inputStream.available();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-624446357"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		if (this.isClosed) {
			return false;
		} else {
			return this.inputStream.available() >= var1;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "1847434030"
	)
	@Export("read")
	public int read(byte[] var1, int var2, int var3) throws IOException {
		if (this.isClosed) {
			return 0;
		} else {
			int var4;
			int var5;
			for (var4 = var3; var3 > 0; var3 -= var5) {
				var5 = this.inputStream.read(var1, var2, var3);
				if (var5 <= 0) {
					throw new EOFException();
				}

				var2 += var5;
			}

			return var4;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "1797414909"
	)
	@Export("write0")
	void write0(byte[] var1, int var2, int var3) throws IOException {
		if (!this.isClosed) {
			if (this.exceptionWriting) {
				this.exceptionWriting = false;
				throw new IOException();
			}

			if (this.outBuffer == null) {
				this.outBuffer = new byte[this.bufferLength];
			}

			synchronized(this) {
				for (int var5 = 0; var5 < var3; ++var5) {
					this.outBuffer[this.outOffset] = var1[var5 + var2];
					this.outOffset = (this.outOffset + 1) % this.bufferLength;
					if ((this.outLength + this.maxPacketLength) % this.bufferLength == this.outOffset) {
						throw new IOException();
					}
				}

				if (this.task == null) {
					this.task = this.taskHandler.newThreadTask(this, 3);
				}

				this.notifyAll();
			}
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "977025272"
	)
	@Export("write")
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.write0(var1, var2, var3);
	}

	protected void finalize() {
		this.close();
	}

	public void run() {
		try {
			while (true) {
				label84: {
					int var1;
					int var2;
					synchronized(this) {
						if (this.outLength == this.outOffset) {
							if (this.isClosed) {
								break label84;
							}

							try {
								this.wait();
							} catch (InterruptedException var9) {
							}
						}

						var2 = this.outLength;
						if (this.outOffset >= this.outLength) {
							var1 = this.outOffset - this.outLength;
						} else {
							var1 = this.bufferLength - this.outLength;
						}
					}

					if (var1 <= 0) {
						continue;
					}

					try {
						this.outputStream.write(this.outBuffer, var2, var1);
					} catch (IOException var8) {
						this.exceptionWriting = true;
					}

					this.outLength = (var1 + this.outLength) % this.bufferLength;

					try {
						if (this.outLength == this.outOffset) {
							this.outputStream.flush();
						}
					} catch (IOException var7) {
						this.exceptionWriting = true;
					}
					continue;
				}

				try {
					if (this.inputStream != null) {
						this.inputStream.close();
					}

					if (this.outputStream != null) {
						this.outputStream.close();
					}

					if (this.socket != null) {
						this.socket.close();
					}
				} catch (IOException var6) {
				}

				this.outBuffer = null;
				break;
			}
		} catch (Exception var11) {
			class225.RunException_sendStackTrace((String)null, var11);
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILky;Lia;I)V",
		garbageValue = "595015097"
	)
	static void method3613(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
				if (var5.key == (long)var0 && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.load(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.read(var0);
			var2.load(var1, var0, var4, true);
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1753470455"
	)
	static void method3595() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3150 == 0) {
				class218.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				class218.ArchiveDiskActionHandler_thread.setDaemon(true);
				class218.ArchiveDiskActionHandler_thread.start();
				class218.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3150 = 600;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lko;Lko;Lko;B)V",
		garbageValue = "-120"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (Username.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		class96.loginBoxCenter = Login.loginBoxX + 180;
		int var3;
		int var4;
		byte var5;
		int var6;
		int var7;
		int var8;
		int var9;
		if (Login.worldSelectOpen) {
			Archive var10;
			if (UserComparator6.worldSelectBackSprites == null) {
				var10 = UserComparator8.archive8;
				var8 = var10.getGroupId("sl_back");
				var3 = var10.getFileId(var8, "");
				Sprite[] var11;
				if (!class228.method4199(var10, var8, var3)) {
					var11 = null;
				} else {
					var11 = HorizontalAlignment.method4783();
				}

				UserComparator6.worldSelectBackSprites = var11;
			}

			if (ReflectionCheck.worldSelectFlagSprites == null) {
				ReflectionCheck.worldSelectFlagSprites = FaceNormal.method3336(UserComparator8.archive8, "sl_flags", "");
			}

			int var27;
			if (ItemContainer.worldSelectArrows == null) {
				var10 = UserComparator8.archive8;
				var8 = var10.getGroupId("sl_arrows");
				var3 = var10.getFileId(var8, "");
				IndexedSprite[] var12;
				if (!class228.method4199(var10, var8, var3)) {
					var12 = null;
				} else {
					IndexedSprite[] var13 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

					for (var27 = 0; var27 < class326.SpriteBuffer_spriteCount; ++var27) {
						IndexedSprite var14 = var13[var27] = new IndexedSprite();
						var14.width = GZipDecompressor.SpriteBuffer_spriteWidth;
						var14.height = class326.SpriteBuffer_spriteHeight;
						var14.xOffset = Huffman.SpriteBuffer_xOffsets[var27];
						var14.yOffset = NPC.SpriteBuffer_yOffsets[var27];
						var14.subWidth = class326.SpriteBuffer_spriteWidths[var27];
						var14.subHeight = class326.SpriteBuffer_spriteHeights[var27];
						var14.palette = class326.SpriteBuffer_spritePalette;
						var14.pixels = class326.SpriteBuffer_pixels[var27];
					}

					DynamicObject.method2292();
					var12 = var13;
				}

				ItemContainer.worldSelectArrows = var12;
			}

			if (DynamicObject.worldSelectStars == null) {
				DynamicObject.worldSelectStars = FaceNormal.method3336(UserComparator8.archive8, "sl_stars", "");
			}

			if (GrandExchangeEvent.worldSelectLeftSprite == null) {
				GrandExchangeEvent.worldSelectLeftSprite = class16.SpriteBuffer_getIndexedSpriteByName(UserComparator8.archive8, "leftarrow", "");
			}

			if (class32.worldSelectRightSprite == null) {
				class32.worldSelectRightSprite = class16.SpriteBuffer_getIndexedSpriteByName(UserComparator8.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (DynamicObject.worldSelectStars != null) {
				DynamicObject.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				DynamicObject.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (ItemContainer.worldSelectArrows != null) {
				var9 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var9, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var9, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var9 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var9 + 15, 4);
				}

				var0.draw("World", var9 + 32, 17, 16777215, -1);
				var6 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var6, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var6, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var6 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var6 + 15, 4);
				}

				var0.draw("Players", var6 + 32, 17, 16777215, -1);
				var8 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var8, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var8, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var8 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var8 + 15, 4);
				}

				var0.draw("Location", var8 + 32, 17, 16777215, -1);
				var3 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var3, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var3, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var3 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var3 + 15, 4);
				}

				var0.draw("Type", var3 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (UserComparator6.worldSelectBackSprites != null) {
				var5 = 88;
				byte var29 = 19;
				var8 = 765 / (var5 + 1) - 1;
				var3 = 480 / (var29 + 1);

				while (true) {
					var7 = var3;
					int var31 = var8;
					if (var3 * (var8 - 1) >= World.World_count) {
						--var8;
					}

					if (var8 * (var3 - 1) >= World.World_count) {
						--var3;
					}

					if (var8 * (var3 - 1) >= World.World_count) {
						--var3;
					}

					if (var3 == var7 && var31 == var8) {
						var7 = (765 - var5 * var8) / (var8 + 1);
						if (var7 > 5) {
							var7 = 5;
						}

						var31 = (480 - var29 * var3) / (var3 + 1);
						if (var31 > 5) {
							var31 = 5;
						}

						var4 = (765 - var8 * var5 - var7 * (var8 - 1)) / 2;
						var27 = (480 - var29 * var3 - var31 * (var3 - 1)) / 2;
						int var32 = (var3 + World.World_count - 1) / var3;
						Login.worldSelectPagesCount = var32 - var8;
						if (GrandExchangeEvent.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
							GrandExchangeEvent.worldSelectLeftSprite.drawAt(8, WorldMapData_1.canvasHeight / 2 - GrandExchangeEvent.worldSelectLeftSprite.subHeight / 2);
						}

						if (class32.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
							class32.worldSelectRightSprite.drawAt(Username.canvasWidth - class32.worldSelectRightSprite.subWidth - 8, WorldMapData_1.canvasHeight / 2 - class32.worldSelectRightSprite.subHeight / 2);
						}

						int var15 = var27 + 23;
						int var16 = var4 + Login.xPadding;
						int var17 = 0;
						boolean var18 = false;
						int var19 = Login.worldSelectPage;

						int var20;
						for (var20 = var3 * var19; var20 < World.World_count && var19 - Login.worldSelectPage < var8; ++var20) {
							World var21 = class96.World_worlds[var20];
							boolean var22 = true;
							String var23 = Integer.toString(var21.population);
							if (var21.population == -1) {
								var23 = "OFF";
								var22 = false;
							} else if (var21.population > 1980) {
								var23 = "FULL";
								var22 = false;
							}

							int var24 = 0;
							byte var25;
							if (var21.isBeta()) {
								if (var21.isMembersOnly()) {
									var25 = 7;
								} else {
									var25 = 6;
								}
							} else if (var21.isDeadman()) {
								var24 = 16711680;
								if (var21.isMembersOnly()) {
									var25 = 5;
								} else {
									var25 = 4;
								}
							} else if (var21.method1767()) {
								if (var21.isMembersOnly()) {
									var25 = 9;
								} else {
									var25 = 8;
								}
							} else if (var21.isPvp()) {
								if (var21.isMembersOnly()) {
									var25 = 3;
								} else {
									var25 = 2;
								}
							} else if (var21.isMembersOnly()) {
								var25 = 1;
							} else {
								var25 = 0;
							}

							if (MouseHandler.MouseHandler_x >= var16 && MouseHandler.MouseHandler_y >= var15 && MouseHandler.MouseHandler_x < var16 + var5 && MouseHandler.MouseHandler_y < var15 + var29 && var22) {
								Login.hoveredWorldIndex = var20;
								UserComparator6.worldSelectBackSprites[var25].drawTransOverlayAt(var16, var15, 128, 16777215);
								var18 = true;
							} else {
								UserComparator6.worldSelectBackSprites[var25].drawAt(var16, var15);
							}

							if (ReflectionCheck.worldSelectFlagSprites != null) {
								ReflectionCheck.worldSelectFlagSprites[(var21.isMembersOnly() ? 8 : 0) + var21.location].drawAt(var16 + 29, var15);
							}

							var0.drawCentered(Integer.toString(var21.id), var16 + 15, var29 / 2 + var15 + 5, var24, -1);
							var1.drawCentered(var23, var16 + 60, var29 / 2 + var15 + 5, 268435455, -1);
							var15 = var15 + var31 + var29;
							++var17;
							if (var17 >= var3) {
								var15 = var27 + 23;
								var16 = var16 + var5 + var7;
								var17 = 0;
								++var19;
							}
						}

						if (var18) {
							var20 = var1.stringWidth(class96.World_worlds[Login.hoveredWorldIndex].activity) + 6;
							int var43 = var1.ascent + 8;
							int var44 = MouseHandler.MouseHandler_y + 25;
							if (var44 + var43 > 480) {
								var44 = MouseHandler.MouseHandler_y - 25 - var43;
							}

							Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var20 / 2, var44, var20, var43, 16777120);
							Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var20 / 2, var44, var20, var43, 0);
							var1.drawCentered(class96.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var44 + var1.ascent + 4, 0, -1);
						}
						break;
					}
				}
			}

			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);
		} else {
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			class32.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			FloorDecoration.logoSprite.drawAt(Login.xPadding + 382 - FloorDecoration.logoSprite.subWidth / 2, 18);
			if (Client.gameState == 0 || Client.gameState == 5) {
				var5 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var5, 16777215, -1);
				var6 = 253 - var5;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var6, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var6 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var6 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var6 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var5, 16777215, -1);
			}

			String var26;
			String var28;
			short var30;
			short var33;
			if (Client.gameState == 20) {
				ScriptFrame.titleboxSprite.drawAt(Login.loginBoxX + 180 - ScriptFrame.titleboxSprite.subWidth / 2, 271 - ScriptFrame.titleboxSprite.subHeight / 2);
				var30 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var30, 16776960, 0);
				var9 = var30 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var9, 16776960, 0);
				var9 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var9, 16776960, 0);
				var9 += 15;
				var9 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var9, 16777215, 0);
					var33 = 200;

					for (var26 = AttackOption.method2115(); var0.stringWidth(var26) > var33; var26 = var26.substring(0, var26.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var26), Login.loginBoxX + 180 - 70, var9, 16777215, 0);
					var9 += 15;

					for (var28 = WorldMapSection2.method321(Login.Login_password); var0.stringWidth(var28) > var33; var28 = var28.substring(1)) {
					}

					var0.draw("Password: " + var28, Login.loginBoxX + 180 - 108, var9, 16777215, 0);
					var9 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				ScriptFrame.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var34;
				if (Login.loginIndex == 0) {
					var30 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var30, 16776960, 0);
					var9 = var30 + 30;
					var6 = Login.loginBoxX + 180 - 80;
					var34 = 291;
					Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
					var0.drawLines("New User", var6 - 73, var34 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var6 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
					var0.drawLines("Existing User", var6 - 73, var34 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var30 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var30, 16777215, 0);
					var9 = var30 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var9, 16777215, 0);
					var9 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var9, 16777215, 0);
					var9 += 15;
					var6 = Login.loginBoxX + 180 - 80;
					var34 = 321;
					Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
					var0.drawCentered("Continue", var6, var34 + 5, 16777215, 0);
					var6 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
					var0.drawCentered("Cancel", var6, var34 + 5, 16777215, 0);
				} else {
					short var36;
					if (Login.loginIndex == 2) {
						var30 = 201;
						var0.drawCentered(Login.Login_response1, class96.loginBoxCenter, var30, 16776960, 0);
						var9 = var30 + 15;
						var0.drawCentered(Login.Login_response2, class96.loginBoxCenter, var9, 16776960, 0);
						var9 += 15;
						var0.drawCentered(Login.Login_response3, class96.loginBoxCenter, var9, 16776960, 0);
						var9 += 15;
						var9 += 7;
						var0.draw("Login: ", class96.loginBoxCenter - 110, var9, 16777215, 0);
						var33 = 200;

						for (var26 = AttackOption.method2115(); var0.stringWidth(var26) > var33; var26 = var26.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var26) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), class96.loginBoxCenter - 70, var9, 16777215, 0);
						var9 += 15;

						for (var28 = WorldMapSection2.method321(Login.Login_password); var0.stringWidth(var28) > var33; var28 = var28.substring(1)) {
						}

						var0.draw("Password: " + var28 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), class96.loginBoxCenter - 108, var9, 16777215, 0);
						var9 += 15;
						var30 = 277;
						var7 = class96.loginBoxCenter + -117;
						IndexedSprite var37 = SecureRandomFuture.method2171(Client.Login_isUsernameRemembered, Login.field1183);
						var37.drawAt(var7, var30);
						var7 = var7 + var37.subWidth + 5;
						var1.draw("Remember username", var7, var30 + 13, 16776960, 0);
						var7 = class96.loginBoxCenter + 24;
						var37 = SecureRandomFuture.method2171(WorldMapSection2.clientPreferences.hideUsername, Login.field1184);
						var37.drawAt(var7, var30);
						var7 = var7 + var37.subWidth + 5;
						var1.draw("Hide username", var7, var30 + 13, 16776960, 0);
						var9 = var30 + 15;
						var4 = class96.loginBoxCenter - 80;
						var36 = 321;
						Login.titlebuttonSprite.drawAt(var4 - 73, var36 - 20);
						var0.drawCentered("Login", var4, var36 + 5, 16777215, 0);
						var4 = class96.loginBoxCenter + 80;
						Login.titlebuttonSprite.drawAt(var4 - 73, var36 - 20);
						var0.drawCentered("Cancel", var4, var36 + 5, 16777215, 0);
						var30 = 357;
						switch(Login.field1193) {
						case 2:
							class14.field101 = "Having trouble logging in?";
							break;
						default:
							class14.field101 = "Can't login? Click here.";
						}

						Login.field1175 = new Bounds(class96.loginBoxCenter, var30, var1.stringWidth(class14.field101), 11);
						WorldMapCacheName.field315 = new Bounds(class96.loginBoxCenter, var30, var1.stringWidth("Still having trouble logging in?"), 11);
						var1.drawCentered(class14.field101, class96.loginBoxCenter, var30, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var30 = 201;
						var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var30, 16776960, 0);
						var9 = var30 + 20;
						var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var9, 16776960, 0);
						var9 += 15;
						var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var9, 16776960, 0);
						var9 += 15;
						var6 = Login.loginBoxX + 180;
						var34 = 276;
						Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
						var2.drawCentered("Try again", var6, var34 + 5, 16777215, 0);
						var6 = Login.loginBoxX + 180;
						var34 = 326;
						Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
						var2.drawCentered("Forgotten password?", var6, var34 + 5, 16777215, 0);
					} else {
						short var35;
						if (Login.loginIndex == 4) {
							var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
							var30 = 236;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var30, 16777215, 0);
							var9 = var30 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var9, 16777215, 0);
							var9 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var9, 16777215, 0);
							var9 += 15;
							var0.draw("PIN: " + WorldMapSection2.method321(LoginScreenAnimation.otp) + (Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var9, 16777215, 0);
							var9 -= 8;
							var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var9, 16776960, 0);
							var9 += 15;
							var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var9, 16776960, 0);
							var6 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
							var8 = var9 - var0.ascent;
							IndexedSprite var42;
							if (Login.field1185) {
								var42 = DirectByteArrayCopier.options_buttons_2Sprite;
							} else {
								var42 = WorldMapSprite.options_buttons_0Sprite;
							}

							var42.drawAt(var6, var8);
							var9 += 15;
							var7 = Login.loginBoxX + 180 - 80;
							var35 = 321;
							Login.titlebuttonSprite.drawAt(var7 - 73, var35 - 20);
							var0.drawCentered("Continue", var7, var35 + 5, 16777215, 0);
							var7 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var7 - 73, var35 - 20);
							var0.drawCentered("Cancel", var7, var35 + 5, 16777215, 0);
							var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var35 + 36, 255, 0);
						} else if (Login.loginIndex != 5) {
							if (Login.loginIndex == 6) {
								var30 = 201;
								var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var30, 16776960, 0);
								var9 = var30 + 15;
								var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var6 = Login.loginBoxX + 180;
								var34 = 321;
								Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
								var0.drawCentered("Back", var6, var34 + 5, 16777215, 0);
							} else if (Login.loginIndex == 7) {
								var30 = 216;
								var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var30, 16776960, 0);
								var9 = var30 + 15;
								var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var6 = Login.loginBoxX + 180 - 80;
								var34 = 321;
								Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
								var0.drawCentered("Set Date of Birth", var6, var34 + 5, 16777215, 0);
								var6 = Login.loginBoxX + 180 + 80;
								Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
								var0.drawCentered("Back", var6, var34 + 5, 16777215, 0);
							} else if (Login.loginIndex == 8) {
								var30 = 216;
								var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var30, 16776960, 0);
								var9 = var30 + 15;
								var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var6 = Login.loginBoxX + 180 - 80;
								var34 = 321;
								Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
								var0.drawCentered("Privacy Policy", var6, var34 + 5, 16777215, 0);
								var6 = Login.loginBoxX + 180 + 80;
								Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
								var0.drawCentered("Back", var6, var34 + 5, 16777215, 0);
							} else if (Login.loginIndex == 12) {
								var30 = 201;
								String var39 = "";
								var26 = "";
								var28 = "";
								switch(Login.field1165) {
								case 0:
									var39 = "Your account has been disabled.";
									var26 = Strings.field3045;
									var28 = "";
									break;
								case 1:
									var39 = "Account locked as we suspect it has been stolen.";
									var26 = Strings.field2808;
									var28 = "";
									break;
								default:
									ViewportMouse.Login_promptCredentials(false);
								}

								var0.drawCentered(var39, Login.loginBoxX + 180, var30, 16776960, 0);
								var9 = var30 + 15;
								var2.drawCentered(var26, Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var2.drawCentered(var28, Login.loginBoxX + 180, var9, 16776960, 0);
								var9 += 15;
								var7 = Login.loginBoxX + 180;
								var35 = 276;
								Login.titlebuttonSprite.drawAt(var7 - 73, var35 - 20);
								var0.drawCentered("Support Page", var7, var35 + 5, 16777215, 0);
								var7 = Login.loginBoxX + 180;
								var35 = 326;
								Login.titlebuttonSprite.drawAt(var7 - 73, var35 - 20);
								var0.drawCentered("Back", var7, var35 + 5, 16777215, 0);
							} else if (Login.loginIndex == 24) {
								var30 = 221;
								var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var30, 16777215, 0);
								var9 = var30 + 15;
								var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var9, 16777215, 0);
								var9 += 15;
								var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var9, 16777215, 0);
								var9 += 15;
								var6 = Login.loginBoxX + 180;
								var34 = 301;
								Login.titlebuttonSprite.drawAt(var6 - 73, var34 - 20);
								var0.drawCentered("Ok", var6, var34 + 5, 16777215, 0);
							}
						} else {
							var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
							var30 = 221;
							var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var30, 16776960, 0);
							var9 = var30 + 15;
							var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var9, 16776960, 0);
							var9 += 15;
							var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var9, 16776960, 0);
							var9 += 15;
							var9 += 14;
							var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var9, 16777215, 0);
							var33 = 174;

							for (var26 = AttackOption.method2115(); var0.stringWidth(var26) > var33; var26 = var26.substring(1)) {
							}

							var0.draw(AbstractFont.escapeBrackets(var26) + (Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var9, 16777215, 0);
							var9 += 15;
							var3 = Login.loginBoxX + 180 - 80;
							var36 = 321;
							Login.titlebuttonSprite.drawAt(var3 - 73, var36 - 20);
							var0.drawCentered("Recover", var3, var36 + 5, 16777215, 0);
							var3 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var3 - 73, var36 - 20);
							var0.drawCentered("Back", var3, var36 + 5, 16777215, 0);
							var36 = 356;
							var1.drawCentered("Still having trouble logging in?", class96.loginBoxCenter, var36, 268435455, 0);
						}
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var38 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var38);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, WorldMapData_1.canvasHeight);
				WorldMapLabelSize.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				WorldMapLabelSize.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var38);
			}

			Login.title_muteSprite[WorldMapSection2.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == FriendLoginUpdate.clientLanguage) {
				if (WorldMapDecorationType.field2739 != null) {
					var9 = Login.xPadding + 5;
					var33 = 463;
					byte var40 = 100;
					byte var41 = 35;
					WorldMapDecorationType.field2739.drawAt(var9, var33);
					var0.drawCentered("World " + Client.worldId, var40 / 2 + var9, var41 / 2 + var33 - 2, 16777215, 0);
					if (World.World_request != null) {
						var1.drawCentered("Loading...", var40 / 2 + var9, var41 / 2 + var33 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var40 / 2 + var9, var41 / 2 + var33 + 12, 16777215, 0);
					}
				} else {
					WorldMapDecorationType.field2739 = class16.SpriteBuffer_getIndexedSpriteByName(UserComparator8.archive8, "sl_button", "");
				}
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1157828358"
	)
	static int method3608(int var0, Script var1, boolean var2) {
		Widget var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}
}
