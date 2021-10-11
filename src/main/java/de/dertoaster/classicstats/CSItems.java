package de.dertoaster.classicstats;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CSItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClassicStatsMod.MODID);
	
	public static final RegistryObject<Item> ITEM_STAT_DEVICE = ITEMS.register("stat_device", () -> new Item(new Properties().tab(ItemGroup.TAB_MISC).stacksTo(1).setNoRepair().rarity(Rarity.COMMON)));
}
