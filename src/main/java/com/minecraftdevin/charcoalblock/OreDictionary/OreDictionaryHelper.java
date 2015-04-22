package com.minecraftdevin.charcoalblock.OreDictionary;

import com.minecraftdevin.charcoalblock.init.ModBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHelper {
    public static void init() {
        OreDictionary.registerOre("blockCharcoal", ModBlocks.charcoalBlock);
    }
}
