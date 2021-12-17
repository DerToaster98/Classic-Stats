package de.dertoaster.classicstats;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class OverlayStatistics extends Gui {

	private Minecraft mcClient;

	public OverlayStatistics(Minecraft minecraft) {
		super(minecraft);
		this.mcClient = minecraft;
	}

	
	@Override
	public void render(PoseStack matrixStack, float p_93032_) {
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
		Gui.drawString(matrixStack, this.mcClient.font, "Day: " + ChatFormatting.YELLOW + day, 2, 2, -1);
		Gui.drawString(matrixStack, this.mcClient.font, "Score: " + ChatFormatting.YELLOW + +score, 2, 20, -1);
		Gui.drawString(matrixStack, this.mcClient.font, "XP: " + ChatFormatting.YELLOW + +xp + "/" + xpNeededForNextLevel, 2, 31, -1);

		matrixStack.popPose();
	}

}
