package net.lawliet.jm_potions.data_generate;

import com.mojang.logging.LogUtils;
import net.lawliet.jm_potions.JustMorePotions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@EventBusSubscriber(modid = JustMorePotions.MODID,bus = EventBusSubscriber.Bus.MOD)
public class DataGeneratorServer {
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void generate(GatherDataEvent.Server event) {
        LOGGER.info("Generating Server Files...");
    }
}
