package de.dertoaster.classicstats;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
@OnlyIn(Dist.CLIENT)
public class RenderGUIHandler {

	protected static final Minecraft mc = Minecraft.getInstance();
	protected static final OverlayStatistics overlay = new OverlayStatistics(mc);

	@SubscribeEvent
	public static void onGameOverlayRender(RenderGameOverlayEvent event) {
		//System.out.println("GameOverlayRenderEvent");
		switch (event.getType()) {
		case ALL:
			overlay.render(event.getPoseStack());
			break;
		default:
			break;
		}
	}

}
