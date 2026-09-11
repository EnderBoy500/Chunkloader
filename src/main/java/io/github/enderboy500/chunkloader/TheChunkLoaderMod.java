package io.github.enderboy500.chunkloader;

import io.github.ciph3rj.cipherlib.Cipher;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheChunkLoaderMod implements ModInitializer {
	public static final String MOD_ID = "chunkloader";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing The Chunk Loader Mod");

		Cipher.addModId(MOD_ID);

		ModBlocks.load();

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(entries -> {
			entries.accept(ModBlocks.CHUNK_LOADER.asItem());
			entries.accept(ModBlocks.SMART_CHUNK_LOADER.asItem());
		});

		LOGGER.info("Finished Initializing The Chunk Loader Mod");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
