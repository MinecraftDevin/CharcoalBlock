package com.minecraftdevin.charcoalblock.client.gui;

import com.minecraftdevin.charcoalblock.configuration.ConfigurationHelper;
import com.minecraftdevin.charcoalblock.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;


public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfigurationHelper.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                true,
                GuiConfig.getAbridgedConfigPath(ConfigurationHelper.configuration.toString()));
    }
}