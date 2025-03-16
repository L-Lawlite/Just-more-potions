package net.lawliet.jm_potions.data_generate.client;

import net.lawliet.jm_potions.JustMorePotions;
import net.lawliet.jm_potions.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.Map.entry;

public class JustMorePotionsLanguageProvider extends LanguageProvider {

    public JustMorePotionsLanguageProvider(PackOutput output, String lang) {
        super(output, JustMorePotions.MODID,lang);
    }
    protected void addPotion(DeferredRegister<Potion> key, Supplier<? extends MobEffect> mobEffect, String name) {
        addEffect(mobEffect, name);
        add("mobEffects." + JustMorePotions.MODID + "." + mobEffect.get().getDescriptionId(),name);
        Map<String,String> potionItemTypes = Map.ofEntries(
                entry("splash_potion","Splash Potion of "),
                entry("potion","Potion of "),
                entry("lingering_potion","Lingering Potion of "),
                entry("tipped_arrow","Arrow of ")
        );
        Iterable<String> potions = getAllPotionsKeys(key);

        for (String potion: potions) {
            for (String potionItemType : potionItemTypes.keySet()) {
                String keyName = "item.minecraft." + potionItemType + ".effect." + potion;
                add(keyName,potionItemTypes.get(potionItemType) + name);
            }}

    }

    protected Iterable<String> getAllPotionsKeys(DeferredRegister<Potion> potionRegistry) {
        return potionRegistry.getEntries().stream().map(x -> x.get().name()).collect(Collectors.toSet());
    }



    @Override
    protected void addTranslations() {
        addPotion(Registration.POTIONS,Registration.DETONATION,"Detonation");
    }



}
