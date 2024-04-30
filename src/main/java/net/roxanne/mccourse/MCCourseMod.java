package net.roxanne.mccourse;

import net.fabricmc.api.ModInitializer;

import net.roxanne.mccourse.block.ModBlocks;
import net.roxanne.mccourse.item.ModItemGroup;
import net.roxanne.mccourse.item.ModItems;
import net.roxanne.mccourse.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
	}
}