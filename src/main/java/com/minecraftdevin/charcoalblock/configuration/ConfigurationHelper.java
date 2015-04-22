package com.minecraftdevin.charcoalblock.configuration;

import com.minecraftdevin.charcoalblock.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHelper
{
    public static Configuration configuration;
    public static int CharcoalBlockBurnTime = 16000;
    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        CharcoalBlockBurnTime = configuration.getInt("Burn Time", Configuration.CATEGORY_GENERAL, 16000, 1, 160000, "Configure the burn time of Charcoal Blocks");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }
}