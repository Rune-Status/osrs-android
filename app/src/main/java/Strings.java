import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("bk")
	public static String field3045;
	@ObfuscatedName("cq")
	public static String field2808;
	@ObfuscatedName("ji")
	public static String field3036;
	@ObfuscatedName("jc")
	public static String field3037;
	@ObfuscatedName("jn")
	public static String field2933;

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(Lhn;III)V",
		garbageValue = "-1274264316"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen && var0 != null) {
			Widget var3 = var0;
			int var4 = WorldMapIcon_0.getWidgetClickMask(var0);
			int var5 = var4 >> 17 & 7;
			int var6 = var5;
			Widget var7;
			if (var5 == 0) {
				var7 = null;
			} else {
				label51: {
					for (int var8 = 0; var8 < var6; ++var8) {
						var3 = Varps.getWidget(var3.parentId);
						if (var3 == null) {
							var7 = null;
							break label51;
						}
					}

					var7 = var3;
				}
			}

			Widget var10 = var7;
			if (var7 == null) {
				var10 = var0.parent;
			}

			if (var10 != null) {
				Client.clickedWidget = var0;
				var7 = ItemContainer.method1184(var0);
				if (var7 == null) {
					var7 = var0.parent;
				}

				Client.clickedWidgetParent = var7;
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				SequenceDefinition.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				int var9 = Client.menuOptionsCount - 1;
				if (var9 != -1) {
					WorldMapRegion.tempMenuAction = new MenuAction();
					WorldMapRegion.tempMenuAction.param0 = Client.menuArguments1[var9];
					WorldMapRegion.tempMenuAction.param1 = Client.menuArguments2[var9];
					WorldMapRegion.tempMenuAction.opcode = Client.menuOpcodes[var9];
					WorldMapRegion.tempMenuAction.identifier = Client.menuIdentifiers[var9];
					WorldMapRegion.tempMenuAction.action = Client.menuActions[var9];
				}

				return;
			}
		}

	}

	static {
		field3045 = "Please visit the support page for assistance.";
		field2808 = "Please visit the support page for assistance.";
		field3036 = "";
		field3037 = "Page has opened in a new window.";
		field2933 = "(Please check your popup blocker.)";
	}
}
