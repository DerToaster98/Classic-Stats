package de.dertoaster.classicstats;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

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
		RenderSystem.pushMatrix();

		final int score = this.mcClient.player.getScore();
		final int xpNeededForNextLevel = this.mcClient.player.getXpNeededForNextLevel();
		final int xp = Math.round(this.mcClient.player.experienceProgress * xpNeededForNextLevel);
		final long day = 1 + (this.mcClient.level.getDayTime() / 24000L);

		/*
		 * Matrix, String, X, Y, color(?)
		 */
		AbstractGui.drawString(matrixStack, this.mcClient.font, new StringTextComponent("Day: " + TextFormatting.YELLOW + day), 2, 2, -1);
		AbstractGui.drawString(matrixStack, this.mcClient.font, "Score: " + TextFormatting.YELLOW + +score, 2, 20, -1);
		AbstractGui.drawString(matrixStack, this.mcClient.font, "XP: " + TextFormatting.YELLOW + +xp + "/" + xpNeededForNextLevel, 2, 31, -1);

		RenderSystem.popMatrix();
	}

}
