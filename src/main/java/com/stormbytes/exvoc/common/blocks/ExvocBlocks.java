package com.stormbytes.exvoc.common.blocks;

import com.stormbytes.exvoc.common.Exvoc;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by edu on 20/06/17.
 */
public class ExvocBlocks {
    public static Block cinnabarOre;

    private static <T extends Block> T Register(String name, T blk) {
        ItemBlock iblk = new ItemBlock(blk);
        iblk.setRegistryName(name);

        GameRegistry.register(blk);
        GameRegistry.register(iblk);

        Exvoc.proxy.RegisterItemRenderer(iblk, 0, name);

        return blk;
    }

    public static void Init() {
        cinnabarOre = Register("ore_cinnabar", new BlockOreCinnabar());
    }
}
