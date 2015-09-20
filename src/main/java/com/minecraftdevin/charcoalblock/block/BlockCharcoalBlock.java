package com.minecraftdevin.charcoalblock.block;

import net.minecraft.creativetab.CreativeTabs;

public class BlockCharcoalBlock extends BlockHelper
{
    public BlockCharcoalBlock()
    {
        super();
        this.setUnlocalizedName("charcoalBlock");
        setHardness(2.0F);
        setResistance(5.0F);
        this.setCreativeTab(CreativeTabs.tabBlock);

    }
}
