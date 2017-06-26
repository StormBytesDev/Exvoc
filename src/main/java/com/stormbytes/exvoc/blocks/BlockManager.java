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
import com.stormbytes.exvoc.blocks.world.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockManager {

    public static BlockOre oreCalcosite;
    public static BlockOre oreCassiterite;

    private static <T extends Block> T register(String name, T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(name);

        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        Exvoc.proxy.registerItemRenderer(itemBlock, 0, name);

        return block;
    }

    public static void registerBlocks() {
        oreCalcosite = register("ore_calcosite", new BlockOre("ore_calcosite", 2, 4));
        oreCassiterite = register("ore_cassiterite", new BlockOre("ore_cassiterite", 2, 4));
    }

}
