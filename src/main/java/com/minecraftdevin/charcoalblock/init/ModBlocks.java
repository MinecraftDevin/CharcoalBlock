package com.minecraftdevin.charcoalblock.init;
import com.minecraftdevin.charcoalblock.block.BlockCharcoalBlock;
import com.minecraftdevin.charcoalblock.block.BlockHelper;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static final BlockHelper charcoalBlock = new BlockCharcoalBlock();

    public static void init()
    {
        GameRegistry.registerBlock(charcoalBlock, "charcoalblock");

    }

}
