package com.minecraftdevin.charcoalblock;

import com.minecraftdevin.charcoalblock.OreDictionary.OreDictionaryHelper;
import com.minecraftdevin.charcoalblock.block.BlockHelper;
import com.minecraftdevin.charcoalblock.configuration.ConfigurationHelper;
import com.minecraftdevin.charcoalblock.fuel.FuelHandler;
import com.minecraftdevin.charcoalblock.init.ModBlocks;
import com.minecraftdevin.charcoalblock.init.Recipes;
import com.minecraftdevin.charcoalblock.proxy.ClientProxy;
import com.minecraftdevin.charcoalblock.proxy.IProxy;
import com.minecraftdevin.charcoalblock.reference.Reference;
import com.minecraftdevin.charcoalblock.render.RenderHelper;
import com.minecraftdevin.charcoalblock.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;



@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class CharcoalBlock {

    @Mod.Instance("CharcoalBlock")
    public static CharcoalBlock instance;

    /*@SidedProxy(clientSide ="com.minecraftdevin.charcoalblock.proxy.ClientProxy", serverSide = "com.minecraftdevin.charcoalblock.proxy.ServerProxy")
    public static IProxy proxy;
    */

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
        //proxy.preInit();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        GameRegistry.registerFuelHandler(new FuelHandler());
        OreDictionaryHelper.init();
        //proxy.init();
        if(event.getSide() == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.charcoalBlock), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "charcoalblock:charcoalblock", "inventory"));
            ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.charcoalBlock), "charcoalblock:charcoalblock");
            new ModelResourceLocation("charcoalblock");
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.charcoalBlock), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockHelper) ModBlocks.charcoalBlock).getName(), "inventory"));
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

        LogHelper.info("You're running version " + Reference.VERSION + " of " + Reference.MOD_NAME);
    }
}
