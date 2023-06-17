package de.dertoaster.classicstats;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
@OnlyIn(Dist.CLIENT)
public class RenderGUIHandler {

	protected static final Minecraft mc = Minecraft.getInstance();

	@SubscribeEvent
	public static void onGameOverlayRender(RenderGuiOverlayEvent event) {
		//System.out.println("GameOverlayRenderEvent");
		switch (event.getPhase()) {
		case NORMAL:
			OverlayStatistics.render(mc, event.getGuiGraphics());
			break;
		default:
			break;
		}
	}

}
