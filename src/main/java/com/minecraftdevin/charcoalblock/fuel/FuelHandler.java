package com.minecraftdevin.charcoalblock.fuel;

import com.minecraftdevin.charcoalblock.init.ModBlocks;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {

    public int getBurnTime(ItemStack fuel) {
        ItemStack itemStack = fuel;
        Item fuelItem = itemStack.getItem();
        if (fuelItem.equals(ModBlocks.charcoalBlock)) {
            return 16000;
        }
        else {
            return 0;
        }


    }
}
