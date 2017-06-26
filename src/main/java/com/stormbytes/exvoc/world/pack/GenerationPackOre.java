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

package com.stormbytes.exvoc.world.pack;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.ArrayList;
import java.util.Random;

public class GenerationPackOre extends GenerationPack {

    private int oreVeinSize, minY, maxY;
    private IBlockState block;

    public GenerationPackOre(int oreVeinSize, int minY, int maxY, IBlockState block) {
        this.oreVeinSize = oreVeinSize;
        this.minY = minY;
        this.maxY = maxY;
        this.block = block;
    }

    @Override
    protected void createPack(Random random, int chunkX, int chunkZ, World world) {
        for (int i = 0; i < oreVeinSize; i++) {
            BlockPos position = new BlockPos(chunkX * 16 + random.nextInt(16), minY + random.nextInt(maxY - minY), chunkZ * 16 + random.nextInt(16));

            System.out.println("Position: " + position.toString());

            WorldGenMinable generator = new WorldGenMinable(block, oreVeinSize + random.nextInt(2));
            generator.generate(world, random, position);
        }
    }

    @Override
    protected ArrayList<Integer> getDimensionBlacklist() {
        return new ArrayList<>();
    }

}
