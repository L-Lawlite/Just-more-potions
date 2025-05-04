package net.lawliet.jm_potions;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = JustMorePotions.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    private static final ModConfigSpec.ConfigValue<List<? extends String>> POTION_BLACKLIST = BUILDER
            .comment("List of potions that are blacklisted from brewing")
            .comment("Only this mod potions are allowed")
                .defineListAllowEmpty("potions",
                        List.of(),
                        Config::ValidatePotions);

    public static Set<Potion> blackListedPotions;

    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean ValidatePotions(final Object obj) {
        if (obj  instanceof String potionName) {
            ResourceLocation potionResourceLocation =  ResourceLocation.parse(potionName);
            return potionResourceLocation.getNamespace().equals(JustMorePotions.MODID) && BuiltInRegistries.POTION.containsKey(potionResourceLocation) ;
        }
        else return false;
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        blackListedPotions = POTION_BLACKLIST.get().stream().map(potionName -> BuiltInRegistries.POTION.getValue(ResourceLocation.parse(potionName))).collect(Collectors.toSet());
    }
}
