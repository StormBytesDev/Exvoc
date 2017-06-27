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

package com.stormbytes.exvoc.client.gui.container;

import com.stormbytes.exvoc.client.gui.slot.SlotInventory;
import com.stormbytes.exvoc.client.gui.slot.SlotRemoveOnly;
import com.stormbytes.exvoc.tileentity.steamworks.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class ContainerGrinder extends ContainerExvoc {

    public ContainerGrinder(InventoryPlayer inventoryPlayer, final TileEntityGrinder tEntity) {
        IItemHandler inventory = tEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        addSlotToContainer(new SlotInventory(inventory, 0, 80, 35));
        addSlotToContainer(new SlotRemoveOnly(inventory, 1,100, 35));
        addPlayerInventory(inventoryPlayer, 8, 140);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

}
