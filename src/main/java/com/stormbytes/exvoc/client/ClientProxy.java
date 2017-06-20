package com.stormbytes.exvoc.client;

import com.stormbytes.exvoc.common.CommonProxy;
import com.stormbytes.exvoc.common.Exvoc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by edu on 20/06/17.
 */
public class ClientProxy implements CommonProxy {
    @Override
    public void RegisterItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Exvoc.MOD_ID + ":" + id, "inventory"));
    }
}
