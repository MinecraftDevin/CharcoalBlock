package com.minecraftdevin.charcoalblock.fuel;

import com.minecraftdevin.charcoalblock.configuration.ConfigurationHelper;
import com.minecraftdevin.charcoalblock.init.ModBlocks;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {

    public int getBurnTime(ItemStack fuel) {
        ItemStack itemStack = fuel;
        if (fuel.isItemEqual(new ItemStack(ModBlocks.charcoalBlock))) { return ConfigurationHelper.CharcoalBlockBurnTime; }
        else {
            return 0;
        }


    }
}
