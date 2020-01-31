import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("o")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("e")
	@Export("map")
	Map map;
	@ObfuscatedName("i")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("g")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		longValue = -8646841017490334521L
	)
	long field1249;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = GrandExchangeOfferWorldComparator.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var3 = (VarcInt)VarcInt.VarcInt_cached.get((long)var2);
			VarcInt var4;
			if (var3 != null) {
				var4 = var3;
			} else {
				byte[] var5 = VarcInt.VarcInt_archive.takeFile(19, var2);
				var3 = new VarcInt();
				if (var5 != null) {
					var3.method4478(new Buffer(var5));
				}

				VarcInt.VarcInt_cached.put(var3, (long)var2);
				var4 = var3;
			}

			this.intsPersistence[var2] = var4.persist;
		}

		var2 = 0;
		if (GrandExchangeOfferWorldComparator.archive2.method4348(15)) {
			var2 = GrandExchangeOfferWorldComparator.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1547810829"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-66"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1774400510"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "104"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)V",
		garbageValue = "-92"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1676642086"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1665078788"
	)
	@Export("clearTransient")
	void clearTransient() {
		int var1;
		for (var1 = 0; var1 < this.intsPersistence.length; ++var1) {
			if (!this.intsPersistence[var1]) {
				this.map.remove(var1);
			}
		}

		for (var1 = 0; var1 < this.strings.length; ++var1) {
			this.strings[var1] = null;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ZI)Lmx;",
		garbageValue = "-6839896"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return WorldMapRectangle.getPreferencesFile("2", class14.field102.name, var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2046783551"
	)
	@Export("write")
	void write() {
		AccessFile var1 = this.getPreferencesFile(true);

		try {
			int var2 = 3;
			int var3 = 0;
			Iterator var4 = this.map.entrySet().iterator();

			while (var4.hasNext()) {
				Entry var5 = (Entry)var4.next();
				int var6 = (Integer)var5.getKey();
				if (this.intsPersistence[var6]) {
					Object var7 = var5.getValue();
					var2 += 3;
					if (var7 instanceof Integer) {
						var2 += 4;
					} else if (var7 instanceof String) {
						var2 += Buddy.stringCp1252NullTerminatedByteSize((String)var7);
					}

					++var3;
				}
			}

			Buffer var21 = new Buffer(var2);
			var21.writeByte(2);
			var21.writeShort(var3);
			Iterator var22 = this.map.entrySet().iterator();

			while (var22.hasNext()) {
				Entry var23 = (Entry)var22.next();
				int var8 = (Integer)var23.getKey();
				if (this.intsPersistence[var8]) {
					var21.writeShort(var8);
					Object var9 = var23.getValue();
					class3 var10 = class3.method51(var9.getClass());
					var21.writeByte(var10.field18);
					class3.method35(var9, var21);
				}
			}

			var1.write(var21.array, 0, var21.offset);
		} catch (Exception var19) {
		} finally {
			try {
				var1.close();
			} catch (Exception var18) {
			}

		}

		this.unwrittenChanges = false;
		this.field1249 = WorldMapIcon_0.currentTimeMillis();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1384592680"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label224: {
			try {
				byte[] var2 = new byte[(int)var1.length()];

				int var3;
				for (int var4 = 0; var4 < var2.length; var4 += var3) {
					var3 = var1.read(var2, var4, var2.length - var4);
					if (var3 == -1) {
						throw new EOFException();
					}
				}

				Buffer var26 = new Buffer(var2);
				if (var26.array.length - var26.offset >= 1) {
					int var5 = var26.readUnsignedByte();
					if (var5 >= 0 && var5 <= 2) {
						int var6;
						int var7;
						int var8;
						int var9;
						if (var5 >= 2) {
							var9 = var26.readUnsignedShort();
							var6 = 0;

							while (true) {
								if (var6 >= var9) {
									break label224;
								}

								var7 = var26.readUnsignedShort();
								var8 = var26.readUnsignedByte();
								class3[] var10 = new class3[]{class3.field15, class3.field22, class3.field16};
								class3 var11 = (class3)WorldMapSection0.findEnumerated(var10, var8);
								Object var12 = var11.method38(var26);
								if (this.intsPersistence[var7]) {
									this.map.put(var7, var12);
								}

								++var6;
							}
						} else {
							var9 = var26.readUnsignedShort();

							for (var6 = 0; var6 < var9; ++var6) {
								var7 = var26.readUnsignedShort();
								var8 = var26.readInt();
								if (this.intsPersistence[var7]) {
									this.map.put(var7, var8);
								}
							}

							var6 = var26.readUnsignedShort();
							var7 = 0;

							while (true) {
								if (var7 >= var6) {
									break label224;
								}

								var26.readUnsignedShort();
								var26.readStringCp1252NullTerminated();
								++var7;
							}
						}
					}

					return;
				}
			} catch (Exception var24) {
				break label224;
			} finally {
				try {
					var1.close();
				} catch (Exception var23) {
				}

			}

			return;
		}

		this.unwrittenChanges = false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2106283374"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1249 < WorldMapIcon_0.currentTimeMillis() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "129228614"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;I)Z",
		garbageValue = "-141032975"
	)
	public static boolean method2212(AbstractArchive var0, AbstractArchive var1) {
		WorldMapElement.WorldMapElement_archive = var1;
		if (!var0.isFullyLoaded()) {
			return false;
		} else {
			class218.WorldMapElement_count = var0.getGroupFileCount(35);
			WorldMapElement.WorldMapElement_cached = new WorldMapElement[class218.WorldMapElement_count];

			for (int var2 = 0; var2 < class218.WorldMapElement_count; ++var2) {
				byte[] var3 = var0.takeFile(35, var2);
				WorldMapElement.WorldMapElement_cached[var2] = new WorldMapElement(var2);
				if (var3 != null) {
					WorldMapElement.WorldMapElement_cached[var2].decode(new Buffer(var3));
					WorldMapElement.WorldMapElement_cached[var2].method4449();
				}
			}

			return true;
		}
	}
}
