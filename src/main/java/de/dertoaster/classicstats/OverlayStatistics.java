package de.dertoaster.classicstats;

import java.awt.Color;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;

public class OverlayStatistics extends GuiComponent {

	private Minecraft mcClient;

	public OverlayStatistics(Minecraft minecraft) {
		super();
		this.mcClient = minecraft;
	}

	static final Color yellow = new Color(0, 255, 255);
	
	//@Override
	public void render(PoseStack matrixStack) {
		if (this.mcClient.options.renderDebug) {
			return;
		}
		matrixStack.pushPose();

		final int score = this.mcClient.player.getScore();
		final int xpNeededForNextLevel = this.mcClient.player.getXpNeededForNextLevel();
		final int xp = Math.round(this.mcClient.player.experienceProgress * xpNeededForNextLevel);
		final long day = 1 + (this.mcClient.level.getDayTime() / 24000L);

		/*
		 * Matrix, String, X, Y, color(?)
		 */
		Gui.drawString(matrixStack, this.mcClient.font, Component.translatable("gui.classicstats.stats_overlay.day", day), 2, 2, yellow.getRGB());
		Gui.drawString(matrixStack, this.mcClient.font, Component.translatable("gui.classicstats.stats_overlay.score", score), 2, 20, yellow.getRGB());
		Gui.drawString(matrixStack, this.mcClient.font, Component.translatable("gui.classicstats.stats_overlay.experience", xp, xpNeededForNextLevel), 2, 31, yellow.getRGB());

		matrixStack.popPose();
	}

}
