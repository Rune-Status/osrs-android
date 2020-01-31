import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("it")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("StructDefinition_archive")
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("StructDefinition_cached")
	static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("be")
	static String field3307;
	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("params")
	IterableNodeHashTable params;

	StructDefinition() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2114792019"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-215711258"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkp;IS)V",
		garbageValue = "-16433"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = MouseRecorder.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1540042604"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return class185.method3686(this.params, var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-32852937"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return FloorDecoration.method2914(this.params, var1, var2);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "2113754677"
	)
	static int method4627(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERTYPE) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERITEM) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERPRICE) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var4;
			if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFEREMPTY) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				var4 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERSTABLE) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				var4 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERFINISHED) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				var4 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERADDING) {
				var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				var4 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var4 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_NAME) {
					var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var5);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_PRICE) {
					var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var5);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTFILTERBY_WORLD) {
					class320.Interpreter_intStackSize -= 2;
					var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize] == 1;
					boolean var13 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var13;
						PendingSpawn.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var5);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_AGE) {
					var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var5);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_COUNT) {
					var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var5);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_GETTOTALOFFERS) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = PendingSpawn.grandExchangeEvents == null ? 0 : PendingSpawn.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var6;
					if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERWORLD) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.world;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERNAME) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var6.getOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPREVIOUSNAME) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var6.getPreviousOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERAGE) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						long var7 = WorldMapIcon_0.currentTimeMillis() - class30.field274 - var6.age;
						int var9 = (int)(var7 / 3600000L);
						int var10 = (int)((var7 - (long)(var9 * 3600000)) / 60000L);
						int var11 = (int)((var7 - (long)(var9 * 3600000) - (long)(var10 * 60000)) / 1000L);
						String var12 = var9 + ":" + var10 / 10 + var10 % 10 + ":" + var11 / 10 + var11 % 10;
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var12;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERCOUNT) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPRICE) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERITEM) {
						var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						var6 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var6.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}
}
