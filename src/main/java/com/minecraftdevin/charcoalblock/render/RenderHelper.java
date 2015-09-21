package com.minecraftdevin.charcoalblock.render;

import com.minecraftdevin.charcoalblock.init.ModBlocks;
import com.minecraftdevin.charcoalblock.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class RenderHelper {
    public void init() {
        registerBlockModelAsItem(ModBlocks.charcoalBlock,"charcoalblock");
        System.out.println("Did I even work..?");
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
