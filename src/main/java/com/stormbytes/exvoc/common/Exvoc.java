package com.stormbytes.exvoc.common;

import com.stormbytes.exvoc.common.blocks.ExvocBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by edu on 20/06/17.
 */
@Mod(modid = Exvoc.MOD_ID, version = Exvoc.VERSION)
public class Exvoc {
    public static final String MOD_ID = "exvoc";
    public static final String VERSION = "1.0";

    @SidedProxy(serverSide = "com.stormbytes.exvoc.server.ServerProxy", clientSide = "com.stormbytes.exvoc.client.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        ExvocBlocks.Init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt) {

    }
}
