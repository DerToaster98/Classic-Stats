package de.dertoaster.classicstats;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ClassicStatsMod.MODID)
public class ClassicStatsMod {
	
	public static final String MODID = "classicstats";

	public ClassicStatsMod() {
		MinecraftForge.EVENT_BUS.register(this);
	}

}
