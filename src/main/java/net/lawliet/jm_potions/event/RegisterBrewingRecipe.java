package net.lawliet.jm_potions.event;

import net.lawliet.jm_potions.JustMorePotions;
import net.lawliet.jm_potions.Registration;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = JustMorePotions.MODID)
public class RegisterBrewingRecipe {
    @SubscribeEvent
    public static void registerBrewingRecipe(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.AWKWARD,Items.CREEPER_HEAD,Registration.DETONATION_POTION);
        event.getBuilder().addMix(Registration.DETONATION_POTION,Items.GLOWSTONE_DUST,Registration.STRONG_DETONATION_POTION);
    }
}
