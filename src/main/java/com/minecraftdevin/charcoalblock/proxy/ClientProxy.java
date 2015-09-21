package com.minecraftdevin.charcoalblock.proxy;

import com.minecraftdevin.charcoalblock.init.ModBlocks;
import com.minecraftdevin.charcoalblock.reference.Reference;
import com.minecraftdevin.charcoalblock.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements IProxy
{
    public void preInit() {

    }

    public void init() {
        registerModels();
        LogHelper.info("I did it.");
    }

    public void registerModels() {
        registerBlockModelAsItem(ModBlocks.charcoalBlock, "charcoalBlock");
    }


    public void registerBlockModelAsItem(final Block block, final String blockName)
    {
        registerBlockModelAsItem(block, 0, blockName);
    }

    public void registerBlockModelAsItem(final Block block, int meta, final String blockName)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + blockName, "inventory"));
    }

    public void registerItemModel(final Item item, int meta, final String itemName)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + itemName, "inventory"));
        ModelBakery.addVariantName(item, Reference.MOD_ID + ":" + itemName);
    }

}
