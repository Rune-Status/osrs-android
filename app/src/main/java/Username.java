import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Username")
public class Username implements Comparable {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -624446357
	)
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("ap")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("c")
	@Export("name")
	String name;
	@ObfuscatedName("t")
	@Export("cleanName")
	String cleanName;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lmv;)V"
	)
	public Username(String var1, LoginType var2) {
		this.name = var1;
		String var3;
		if (var1 == null) {
			var3 = null;
		} else {
			int var4 = 0;

			int var5;
			boolean var6;
			char var7;
			for (var5 = var1.length(); var4 < var5; ++var4) {
				var7 = var1.charAt(var4);
				var6 = var7 == 160 || var7 == ' ' || var7 == '_' || var7 == '-';
				if (!var6) {
					break;
				}
			}

			while (var5 > var4) {
				var7 = var1.charAt(var5 - 1);
				var6 = var7 == 160 || var7 == ' ' || var7 == '_' || var7 == '-';
				if (!var6) {
					break;
				}

				--var5;
			}

			int var8 = var5 - var4;
			if (var8 >= 1 && var8 <= TaskHandler.method3540(var2)) {
				StringBuilder var9 = new StringBuilder(var8);

				for (int var10 = var4; var10 < var5; ++var10) {
					char var11 = var1.charAt(var10);
					if (Projectile.method2160(var11)) {
						char var12 = Decimator.method2597(var11);
						if (var12 != 0) {
							var9.append(var12);
						}
					}
				}

				if (var9.length() == 0) {
					var3 = null;
				} else {
					var3 = var9.toString();
				}
			} else {
				var3 = null;
			}
		}

		this.cleanName = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "-49"
	)
	@Export("getName")
	public String getName() {
		return this.name;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "750587090"
	)
	@Export("hasCleanName")
	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljz;B)I",
		garbageValue = "-33"
	)
	@Export("compareToTyped")
	public int compareToTyped(Username var1) {
		if (this.cleanName == null) {
			return var1.cleanName == null ? 0 : 1;
		} else {
			return var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName);
		}
	}

	public boolean equals(Object var1) {
		if (var1 instanceof Username) {
			Username var2 = (Username)var1;
			if (this.cleanName == null) {
				return var2.cleanName == null;
			} else if (var2.cleanName == null) {
				return false;
			} else {
				return this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName);
			}
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.cleanName == null ? 0 : this.cleanName.hashCode();
	}

	public String toString() {
		return this.getName();
	}

	public int compareTo(Object var1) {
		return this.compareToTyped((Username)var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-22"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}
}
