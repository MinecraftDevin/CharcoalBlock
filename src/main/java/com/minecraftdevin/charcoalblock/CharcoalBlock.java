package com.minecraftdevin.charcoalblock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="CharcoalBlock", name="Charcoal Block", version="1.7.10-0.1-Alpha")

public class CharcoalBlock {

    @Mod.Instance("CharcoalBlock")
    public static CharcoalBlock instance;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Event stage: preInit");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
