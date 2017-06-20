package com.stormbytes.exvoc.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by edu on 20/06/17.
 */
public class BlockOreCinnabar extends Block {
    public BlockOreCinnabar() {
        super(Material.ROCK);
        this.setUnlocalizedName("ore_cinnabar");
        this.setRegistryName("ore_cinnabar");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
