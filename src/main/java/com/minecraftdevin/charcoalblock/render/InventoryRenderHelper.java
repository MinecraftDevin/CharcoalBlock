package com.minecraftdevin.charcoalblock.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

    /**
     * @author <a href="https://github.com/TehNut">TehNut</a>
     *
     * The goal of this class is to make registering the inventory renders
     * for your Items/Blocks a much simpler and easier process.
     *
     * You must call this at the post initialization stage on
     * the clientside only.
     *
     * If you pass a Block through here that uses the default
     * ItemBlock, you should specify a custom name.
     */
    public class InventoryRenderHelper {

        /**
         * This is the base string for your resources. It will usually be
         * your modid in all lowercase with a colon at the end.
         */
        private static final String resourceBase = "charcoalblock:";

        /**
         * Registers a Model for the given Item and meta.
         *
         * @param item - Item to register Model for
         * @param meta - Meta of Item
         * @param name - Name of the model JSON
         */
        public static void itemRender(Item item, int meta, String name) {
            if (item instanceof ItemBlock && name.startsWith("ItemBlock"))
                name = name.replace("Item", "");

            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            String resName = resourceBase + name;

            ModelBakery.addVariantName(item, resName);
            renderItem.getItemModelMesher().register(item, meta, new ModelResourceLocation(resName, "inventory"));
        }

        /**
         * Shorthand of {@code itemRender(Item, int, String)}
         *
         * @param item - Item to register Model for
         * @param meta - Meta of Item
         */
        public static void itemRender(Item item, int meta) {
            itemRender(item, meta, item.getClass().getSimpleName() + meta);
        }

        /**
         * Shorthand of {@code itemRender(Item, int)}
         *
         * @param item - Item to register Model for
         */
        public static void itemRender(Item item) {
            itemRender(item, 0, item.getClass().getSimpleName());
        }

        /**
         * Registers a model for the item across all Meta's that get used for the item
         *
         * @param item - Item to register Model for
         */
        public static void itemRenderAll(Item item) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            final Item toRender = item;

            renderItem.getItemModelMesher().register(item, new ItemMeshDefinition() {
                @Override
                public ModelResourceLocation getModelLocation(ItemStack stack) {
                    return new ModelResourceLocation(resourceBase + toRender.getClass().getSimpleName(), "inventory");
                }
            });
        }

        /**
         *
         * @param block - Block to get Item of
         * @return      - The ItemBlock that corresponds to the Block.
         */
        public static Item getItemFromBlock(Block block) {
            return Item.getItemFromBlock(block);
        }
    }