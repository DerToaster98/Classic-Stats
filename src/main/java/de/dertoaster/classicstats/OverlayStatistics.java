package de.dertoaster.classicstats;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;

public class OverlayStatistics extends AbstractGui {

	private Minecraft mcClient;

	public OverlayStatistics(Minecraft minecraft) {
		super();
		this.mcClient = minecraft;
	}

	public void render(MatrixStack matrixStack) {
		if (this.mcClient.options.renderDebug) {
			return;
		}
		
		final int score = this.mcClient.player.getScore();
		final int xpNeededForNextLevel = this.mcClient.player.getXpNeededForNextLevel();
		final int xp = Math.round(this.mcClient.player.experienceProgress * xpNeededForNextLevel);
		final long day = this.mcClient.level.getDayTime() / 24000L;
		
		/*
		 * Matrix, String, X, Y, color(?)
		 */
		 this.mcClient.font.draw(matrixStack, "Day: " + day, 2.0F, (float)2, 14737632);
		 this.mcClient.font.draw(matrixStack, "Score: " + score, 2.0F, (float)20, 14737632);
		 this.mcClient.font.draw(matrixStack, "XP: " + xp + "/" + xpNeededForNextLevel, 2.0F, (float)31, 14737632);
	}

}
