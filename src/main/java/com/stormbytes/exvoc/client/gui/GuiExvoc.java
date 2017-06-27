/*
 * This file is part of Exvoc.
 *
 * Exvoc is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Exvoc is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Exvoc.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Exvoc.
 *
 * Exvoc is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Exvoc is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Exvoc.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.stormbytes.exvoc.client.gui;

import com.stormbytes.exvoc.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiExvoc extends GuiContainer {

    protected ResourceLocation texture;
    private boolean drawName, drawInventory = false;
    private String unlocalizedName;

    public GuiExvoc(Container inventorySlotsIn, String textureLocation, String unlocalizedName) {
        super(inventorySlotsIn);

        texture = new ResourceLocation(Reference.MOD_ID, textureLocation);
        this.unlocalizedName = unlocalizedName;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);

        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        if (drawName) {
            fontRenderer.drawString(I18n.format(unlocalizedName), (xSize - fontRenderer.getStringWidth(I18n.format(unlocalizedName))) / 2, 6, 0x404040);
        }

        if (drawInventory) {
            fontRenderer.drawString(I18n.format("container.inventory"), 8, ySize - 94, 0x404040);
        }
    }

    protected void setDrawName(boolean drawName) { this.drawName = drawName; }
    protected void setDrawInventory(boolean drawInventory) { this.drawInventory = drawInventory; }
}
