package com.minecraftdevin.charcoalblock;

import com.minecraftdevin.charcoalblock.OreDictionary.OreDictionaryHelper;
import com.minecraftdevin.charcoalblock.block.BlockCharcoalBlock;
import com.minecraftdevin.charcoalblock.fuel.FuelHandler;
import com.minecraftdevin.charcoalblock.init.ModBlocks;
import com.minecraftdevin.charcoalblock.init.Recipes;
import com.minecraftdevin.charcoalblock.proxy.IProxy;
import com.minecraftdevin.charcoalblock.reference.Reference;
import com.minecraftdevin.charcoalblock.util.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)

public class CharcoalBlock {

    @Mod.Instance("CharcoalBlock")
    public static CharcoalBlock instance;

    @SidedProxy(clientSide ="com.minecraftdevin.charcoalblock.proxy.ClientProxy", serverSide = "com.minecraftdevin.charcoalblock.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ModBlocks.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        GameRegistry.registerFuelHandler(new FuelHandler());
        OreDictionaryHelper.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

        LogHelper.info("You're running version " + Reference.VERSION + " of " + Reference.MOD_NAME);
    }
}
