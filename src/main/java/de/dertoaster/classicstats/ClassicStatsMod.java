package de.dertoaster.classicstats;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ClassicStatsMod.MODID)
public class ClassicStatsMod {
	
	public static final String MODID = "classicstats";

	public ClassicStatsMod() {
		IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
		CSItems.ITEMS.register(modbus);
		MinecraftForge.EVENT_BUS.register(this);
	}

}
