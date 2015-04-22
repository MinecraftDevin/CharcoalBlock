package com.minecraftdevin.charcoalblock;

import com.minecraftdevin.charcoalblock.OreDictionary.OreDictionaryHelper;
import com.minecraftdevin.charcoalblock.configuration.ConfigurationHelper;
import com.minecraftdevin.charcoalblock.fuel.FuelHandler;
import com.minecraftdevin.charcoalblock.init.ModBlocks;
import com.minecraftdevin.charcoalblock.init.Recipes;
import com.minecraftdevin.charcoalblock.proxy.IProxy;
import com.minecraftdevin.charcoalblock.reference.Reference;
import com.minecraftdevin.charcoalblock.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Level;



@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class CharcoalBlock {

    @Mod.Instance("CharcoalBlock")
    public static CharcoalBlock instance;

    @SidedProxy(clientSide ="com.minecraftdevin.charcoalblock.proxy.ClientProxy", serverSide = "com.minecraftdevin.charcoalblock.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHelper.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHelper());
        FMLLog.log(Reference.MOD_ID, Level.INFO, "Loaded configuration...");
        if (ConfigurationHelper.CharcoalBlockBurnTime != 16000) {
            FMLLog.log(Reference.MOD_ID, Level.INFO, "Custom configuration: true. Custom burn time: " + ConfigurationHelper.CharcoalBlockBurnTime);
        }
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
