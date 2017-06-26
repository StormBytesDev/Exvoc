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

package com.stormbytes.exvoc.world;

import com.stormbytes.exvoc.blocks.BlockManager;
import com.stormbytes.exvoc.world.pack.GenerationPack;
import com.stormbytes.exvoc.world.pack.GenerationPackOre;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

public class GenerationManager {

    private static ArrayList<GenerationPack> generationPacks = new ArrayList<>();
    private static WorldGenerationPack generator = new WorldGenerationPack();

    private static GenerationPack packCassiterite;
    private static GenerationPack packCalcosite;

    public static void initManager() {
        packCassiterite = new GenerationPackOre(4, 5, 40, BlockManager.oreCassiterite.getDefaultState());
        packCalcosite = new GenerationPackOre(5, 5, 50, BlockManager.oreCalcosite.getDefaultState());

        GameRegistry.registerWorldGenerator(generator, generationPacks.size());
    }

    public static ArrayList<GenerationPack> getPacks() { return generationPacks; }
    public static void registerPack(GenerationPack pack) { generationPacks.add(pack); }

}
