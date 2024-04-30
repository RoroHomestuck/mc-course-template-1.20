package net.roxanne.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.roxanne.mccourse.MCCourseMod;
import net.roxanne.mccourse.block.ModBlocks;
import net.roxanne.mccourse.item.custom.MetalDetectorItem;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new FabricItemSettings()));

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem((new FabricItemSettings().maxDamage(256))));
    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item((new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER))));
    public static final Item PEAT_BRICK = registerItem("peat_brick",
            new Item((new FabricItemSettings())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }


    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        // Adds entries to the item group 'Ingredients'.
        entries.add(PINK_GARNET);
        entries.add(RAW_PINK_GARNET);
    }

    private static void itemGroupBuildingBlocks(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.PINK_GARNET_BLOCK);
    }

    private static void itemGroupNaturalBlocks(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        entries.add(ModBlocks.END_STONE_PINK_GARNET_ORE);
        entries.add(ModBlocks.PINK_GARNET_ORE);
        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);
        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
    }





    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::itemGroupBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::itemGroupNaturalBlocks);
    }

}
