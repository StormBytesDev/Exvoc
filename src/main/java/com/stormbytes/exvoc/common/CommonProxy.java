package com.stormbytes.exvoc.common;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by edu on 20/06/17.
 */
public interface CommonProxy {
    public void RegisterItemRenderer(Item item, int meta, String id);

}
