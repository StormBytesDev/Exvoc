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

import com.stormbytes.exvoc.world.GenerationManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;

import java.util.ArrayList;
import java.util.Random;

public abstract class GenerationPack {

    public GenerationPack() { GenerationManager.registerPack(this); }

    public void generatePack(Random random, int chunkX, int chunkZ, World world) {
        if (world.getWorldInfo().getTerrainType() == WorldType.FLAT) {
            return;
        }

        if (getDimensionBlacklist().contains(world.provider.getDimension())) {
            return;
        }

        createPack(random, chunkX, chunkZ, world);
    }

    protected abstract void createPack(Random random, int chunkX, int chunkZ, World world);
    protected abstract ArrayList<Integer> getDimensionBlacklist();

}
