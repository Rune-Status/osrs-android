import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1410510983
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("o")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 925396111
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1226828671
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -371722199
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 604865057
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 274624123
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1237300351
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("p")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("h")
	@Export("sections")
	LinkedList sections;

	public WorldMapArea() {
		this.id = -1;
		this.backGroundColor = -1;
		this.zoom = -1;
		this.origin = null;
		this.regionLowX = Integer.MAX_VALUE;
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE;
		this.regionHighY = 0;
		this.isMain = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;II)V",
		garbageValue = "-1829168908"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Lac;",
		garbageValue = "933484364"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType var3 = (WorldMapSectionType)WorldMapSection0.findEnumerated(WorldMapSectionType.method249(), var2);
		Object var4 = null;
		switch(var3.type) {
		case 0:
			var4 = new WorldMapSection2();
			break;
		case 1:
			var4 = new class42();
			break;
		case 2:
			var4 = new WorldMapSection1();
			break;
		case 3:
			var4 = new WorldMapSection0();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var4).read(var1);
		return (WorldMapSection)var4;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "1328516343"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		while (var4.hasNext()) {
			WorldMapSection var5 = (WorldMapSection)var4.next();
			if (var5.containsCoord(var1, var2, var3)) {
				return true;
			}
		}

		return false;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2019435161"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				while (var5.hasNext()) {
					WorldMapSection var6 = (WorldMapSection)var5.next();
					if (var6.containsPosition(var1, var2)) {
						return true;
					}
				}

				return false;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "371604426"
	)
	@Export("position")
	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		while (var4.hasNext()) {
			WorldMapSection var5 = (WorldMapSection)var4.next();
			if (var5.containsCoord(var1, var2, var3)) {
				return var5.getBorderTileLengths(var1, var2, var3);
			}
		}

		return null;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-2147059798"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		while (var3.hasNext()) {
			WorldMapSection var4 = (WorldMapSection)var3.next();
			if (var4.containsPosition(var1, var2)) {
				return var4.coord(var1, var2);
			}
		}

		return null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-263455981"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-650960366"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2024226786"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "1"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "2136692647"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "4"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "293375977"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2073176457"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-617672869"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "501195938"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "536883045"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1345983642"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "12"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "622743388"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Lhj;",
		garbageValue = "-2050948360"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("t")
	@Export("base37DecodeLong")
	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; 0L != var3; var3 /= 37L) {
					++var2;
				}

				char var4;
				StringBuilder var8;
				for (var8 = new StringBuilder(var2); 0L != var0; var8.append(var4)) {
					long var5 = var0;
					var0 /= 37L;
					var4 = class289.base37Table[(int)(var5 - 37L * var0)];
					if (var4 == '_') {
						int var7 = var8.length() - 1;
						var8.setCharAt(var7, Character.toUpperCase(var8.charAt(var7)));
						var4 = 160;
					}
				}

				var8.reverse();
				var8.setCharAt(0, Character.toUpperCase(var8.charAt(0)));
				return var8.toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;IIIIIIS)V",
		garbageValue = "4210"
	)
	@Export("loadTerrain")
	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						int[] var12 = Tiles.Tiles_heights[0][var2];
						int var9 = var2 + var4 + 932731;
						int var10 = var3 + var5 + 556238;
						int var11 = class3.method49(45365 + var9, 91923 + var10, 4) - 128 + (class3.method49(10294 + var9, var10 + 37821, 2) - 128 >> 1) + (class3.method49(var9, var10, 1) - 128 >> 2);
						var11 = (int)((double)var11 * 0.3D) + 35;
						if (var11 < 10) {
							var11 = 10;
						} else if (var11 > 60) {
							var11 = 60;
						}

						var12[var3] = -var11 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var8 = var0.readUnsignedByte();
					if (var8 == 1) {
						var8 = 0;
					}

					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -var8 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var8 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					Tiles.field514[var1][var2][var3] = var0.readByte();
					Tiles.field507[var1][var2][var3] = (byte)((var7 - 2) / 4);
					Tiles.field518[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
				} else {
					Tiles.field502[var1][var2][var3] = (byte)(var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "20"
	)
	static final void method425() {
		class60.method1188("Your friend list is full. Max of 200 for free users, and 400 for members");
	}
}
