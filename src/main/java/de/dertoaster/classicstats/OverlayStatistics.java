package de.dertoaster.classicstats;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class OverlayStatistics {

	static final Color yellow = new Color(255, 255, 0);
	
	//@Override
	public static void render(final Minecraft minecraft, final GuiGraphics graphics) {
		if (minecraft.options.renderDebug) {
			return;
		}

		final int score = minecraft.player.getScore();
		final int xpNeededForNextLevel = minecraft.player.getXpNeededForNextLevel();
		final int xp = Math.round(minecraft.player.experienceProgress * xpNeededForNextLevel);
		final long day = 1 + (minecraft.level.getDayTime() / 24000L);

		/*
		 * Matrix, String, X, Y, color(?)
		 */
		graphics.drawString(minecraft.font, Component.translatable("gui.classicstats.stats_overlay.day", day), 2, 2, yellow.getRGB());
		graphics.drawString(minecraft.font, Component.translatable("gui.classicstats.stats_overlay.score", score), 2, 20, yellow.getRGB());
		graphics.drawString(minecraft.font, Component.translatable("gui.classicstats.stats_overlay.experience", xp, xpNeededForNextLevel), 2, 30, yellow.getRGB());
	}

}
