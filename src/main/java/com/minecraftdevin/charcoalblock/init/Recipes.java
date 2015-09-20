package com.minecraftdevin.charcoalblock.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.charcoalBlock), "sss", "sss", "sss", 's', new ItemStack(Items.coal, 1, 1));

        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal,9,1), new ItemStack(ModBlocks.charcoalBlock));

    }
}
