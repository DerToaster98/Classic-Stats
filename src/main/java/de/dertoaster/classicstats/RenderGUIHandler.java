package de.dertoaster.classicstats;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
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

	protected static Set<Item> DEVICES = null;

	protected static void fillDevices() {
		DEVICES = new HashSet<Item>();
		DEVICES.add(CSItems.ITEM_STAT_DEVICE.get());
	}

	/*@SubscribeEvent
	public static void onRenderTick(RenderGameOverlayEvent.Post event) {
		if (DEVICES == null) { fillDevices(); }
		 
		ClientPlayerEntity clientPlayer = mc.player;
		 
	 	boolean hasDevice = clientPlayer.inventory.hasAnyOf(DEVICES);
		 
	 	if (hasDevice) { overlay.render(event.getMatrixStack()); }
		 
	}*/

	@SubscribeEvent
	public static void onGameOverlayRender(RenderGameOverlayEvent event) {
		//System.out.println("GameOverlayRenderEvent");
		switch (event.getType()) {
		case ALL:
			overlay.render(event.getMatrixStack());
			break;
		case AIR:
			break;
		case ARMOR:
			break;
		case BOSSHEALTH:
			break;
		case BOSSINFO:
			break;
		case CHAT:
			break;
		case CROSSHAIRS:
			break;
		case DEBUG:
			break;
		case EXPERIENCE:
			break;
		case FOOD:
			break;
		case FPS_GRAPH:
			break;
		case HEALTH:
			break;
		case HEALTHMOUNT:
			break;
		case HELMET:
			break;
		case HOTBAR:
			break;
		case JUMPBAR:
			break;
		case PLAYER_LIST:
			break;
		case PORTAL:
			break;
		case POTION_ICONS:
			break;
		case SUBTITLES:
			break;
		case TEXT:
			break;
		case VIGNETTE:
			break;
		default:
			break;
		}
	}

}
