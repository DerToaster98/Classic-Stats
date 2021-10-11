package de.dertoaster.classicstats;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
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

	@SubscribeEvent
	public static void onRenderTick(RenderGameOverlayEvent.Post event) {
		if (DEVICES == null) {
			fillDevices();
		}

		ClientPlayerEntity clientPlayer = mc.player;

		boolean hasDevice = clientPlayer.inventory.hasAnyOf(DEVICES);

		if (hasDevice) {
			overlay.render(event.getMatrixStack());
		}
	}

}
