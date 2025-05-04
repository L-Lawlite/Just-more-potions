package net.lawliet.jm_potions;

import net.lawliet.jm_potions.entity.effects.DenationMobEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registration {

    //Registries
    public static final DeferredRegister<MobEffect> MOB_EFFECT;
    public static final DeferredRegister<Potion> POTIONS;

    //Potion
    public static final DeferredHolder<MobEffect,MobEffect> DETONATION;
    public static final DeferredHolder<Potion,Potion> DETONATION_POTION;
    public static final DeferredHolder<Potion,Potion> STRONG_DETONATION_POTION;
    public static final DeferredHolder<Potion,Potion> DECAY_POTION;
    public static final DeferredHolder<Potion,Potion> STRONG_DECAY_POTION;


    //Registries
    static {
        POTIONS = DeferredRegister.create(Registries.POTION,JustMorePotions.MODID);
        MOB_EFFECT = DeferredRegister.create(Registries.MOB_EFFECT,JustMorePotions.MODID);
    }

    //Potion
    static {
        DETONATION = MOB_EFFECT.register("detonation", () -> new DenationMobEffect(MobEffectCategory.HARMFUL,16753920));
        DETONATION_POTION = POTIONS.register("detonation", () -> new Potion("detonation",
                new MobEffectInstance[]{
                        new MobEffectInstance(DETONATION,3600)
        }));
        STRONG_DETONATION_POTION = POTIONS.register("strong_detonation", () -> new Potion("detonation",
                new MobEffectInstance[]{
                        new MobEffectInstance(DETONATION,1800, 1)
                }));
        DECAY_POTION = POTIONS.register("decay", () -> new Potion("wither",
                new MobEffectInstance[] {
                        new MobEffectInstance(MobEffects.WITHER, 3600)
                }
                ));
        STRONG_DECAY_POTION = POTIONS.register("strong_decay", () -> new Potion("wither",
                new MobEffectInstance[] {
                        new MobEffectInstance(MobEffects.WITHER, 1800, 1)
                }
                ));
    }

    public static void init(IEventBus modEventBus) {
        MOB_EFFECT.register(modEventBus);
        POTIONS.register(modEventBus);
    }


    // Add the example block item to the building blocks tab
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    public static void addCapabilities(RegisterCapabilitiesEvent event) {
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
    }
}
