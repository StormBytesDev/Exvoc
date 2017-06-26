package com.stormbytes.exvoc.proxy;

import net.minecraft.item.Item;

public interface ISidedProxy {

    public void registerItemRenderer(Item item, int meta, String id);

}
