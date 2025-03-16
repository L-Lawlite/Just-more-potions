package net.lawliet.jm_potions.data_generate;

import com.mojang.logging.LogUtils;
import net.lawliet.jm_potions.JustMorePotions;
import net.lawliet.jm_potions.data_generate.client.JustMorePotionsLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;


import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = JustMorePotions.MODID,bus = EventBusSubscriber.Bus.MOD)
public class DataGeneratorClient {
    private static final Logger LOGGER = LogUtils.getLogger();



    @SubscribeEvent
    public static void generate(GatherDataEvent.Client event) {
        LOGGER.info("Generating Client Files...");

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true,new JustMorePotionsLanguageProvider(packOutput,"en_us"));

    }
}
