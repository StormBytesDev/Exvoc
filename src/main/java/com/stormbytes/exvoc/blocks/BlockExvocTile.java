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

package com.stormbytes.exvoc.blocks;

import com.stormbytes.exvoc.Exvoc;
import com.stormbytes.exvoc.tileentity.interfaces.IDropInventory;
import com.stormbytes.exvoc.tileentity.TileEntityExvoc;
import com.stormbytes.exvoc.tileentity.interfaces.IHasGui;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public abstract class BlockExvocTile<T extends TileEntity> extends BlockExvoc {

    public BlockExvocTile(Material blockMaterial, String name) {
        super(blockMaterial, name);
    }

    public T getTileEntity(IBlockAccess world, BlockPos position) {
        return (T) world.getTileEntity(position);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tEntity = getTileEntity(worldIn, pos);

        if (tEntity != null && tEntity instanceof TileEntityExvoc) {
            ((TileEntityExvoc) tEntity).onBlockBroken();

            if (tEntity instanceof IDropInventory) {
                IItemHandler itemHandler = tEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

                for (int i = 0; i < itemHandler.getSlots(); i++) {
                    ItemStack stack = itemHandler.getStackInSlot(i);

                    if (!stack.isEmpty()) {

                        float spawnX = pos.getX() + worldIn.rand.nextFloat();
                        float spawnY = pos.getY() + worldIn.rand.nextFloat();
                        float spawnZ = pos.getZ() + worldIn.rand.nextFloat();

                        EntityItem droppedItem = new EntityItem(worldIn, spawnX, spawnY, spawnZ, stack.copy());

                        droppedItem.motionX = worldIn.rand.nextFloat() * 0.05F;
                        droppedItem.motionY = worldIn.rand.nextFloat() * 0.05F + 0.15F;
                        droppedItem.motionZ = worldIn.rand.nextFloat() * 0.05F;

                        worldIn.spawnEntity(droppedItem);
                    }
                }
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tEntity = worldIn.getTileEntity(pos);

        if (tEntity != null && tEntity instanceof TileEntityExvoc) {
            ((TileEntityExvoc) tEntity).onBlockActivated(playerIn, hand, facing, hitX, hitY, hitZ);

            if (tEntity instanceof IHasGui && !worldIn.isRemote) {
                playerIn.openGui(Exvoc.instance, ((IHasGui) tEntity).getGUI(), worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }

        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) { return true; }

    @Override
    public abstract T createTileEntity(World world, IBlockState state);

    public abstract void registerTileEntity();

}
