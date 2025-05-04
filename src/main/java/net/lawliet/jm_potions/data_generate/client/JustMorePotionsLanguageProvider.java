package net.lawliet.jm_potions.data_generate.client;

import net.lawliet.jm_potions.JustMorePotions;
import net.lawliet.jm_potions.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.Map.entry;

public class JustMorePotionsLanguageProvider extends LanguageProvider {

    public JustMorePotionsLanguageProvider(PackOutput output, String lang) {
        super(output, JustMorePotions.MODID,lang);
    }

    protected void addPotion(DeferredHolder<Potion,Potion> potionHolder, String name) {
        String potionKey = potionHolder.getKey().location().getPath();
        Map<String,String> potionItemTypes = Map.ofEntries(
                entry("splash_potion","Splash Potion of "),
                entry("potion","Potion of "),
                entry("lingering_potion","Lingering Potion of "),
                entry("tipped_arrow","Arrow of ")
        );

        for (String potionItemType : potionItemTypes.keySet()) {
            String keyName = "item.minecraft." + potionItemType + ".effect." + potionKey;
            add(keyName,potionItemTypes.get(potionItemType) + name);
        }

    }

    protected void addPotion(Supplier<? extends MobEffect> mobEffect,DeferredHolder<Potion,Potion> potionHolder, String name) {
        addEffect(mobEffect, name);
        add("mobEffects." + JustMorePotions.MODID + "." + mobEffect.get().getDescriptionId(),name);
        addPotion(potionHolder,name);
    }

    protected Iterable<String> getAllPotionsKeys(DeferredRegister<Potion> potionRegistry) {
        return potionRegistry.getEntries().stream().map(x -> x.get().name()).collect(Collectors.toSet());
    }



    @Override
    protected void addTranslations() {
        addPotion(Registration.DETONATION,Registration.DETONATION_POTION,"Detonation");
        addPotion(Registration.DECAY_POTION,"Decay");
    }



}
