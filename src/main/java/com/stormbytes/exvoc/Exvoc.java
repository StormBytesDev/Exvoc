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

package com.stormbytes.exvoc;

import com.stormbytes.exvoc.blocks.BlockManager;
import com.stormbytes.exvoc.client.CreativeTabExvoc;
import com.stormbytes.exvoc.items.ItemManager;
import com.stormbytes.exvoc.proxy.CommonProxy;
import com.stormbytes.exvoc.proxy.ISidedProxy;
import com.stormbytes.exvoc.world.GenerationManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Exvoc {

    @Mod.Instance(Reference.MOD_ID)
    public static Exvoc instance;

    public static final CreativeTabExvoc exvocTab = new CreativeTabExvoc();

    @SidedProxy(serverSide = "com.stormbytes.exvoc.proxy.CommonProxy", clientSide = "com.stormbytes.exvoc.proxy.ClientProxy")
    public static ISidedProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        ItemManager.regiterItems();
        BlockManager.registerBlocks();
        GenerationManager.initManager();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt) {

    }

}
