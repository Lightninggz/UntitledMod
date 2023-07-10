package me.lightningz.untitledmod.items;

import me.lightningz.untitledmod.Untitled1;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Untitled1.MODID);

    public static final RegistryObject<Item> THUNDER_AXE = ITEMS.register("thunder_axe", () -> new ThunderAxe(ModTiers.LIGHTNING, new Item.Properties()));

    public static final RegistryObject<Item> LIGHTNING_INGOT = ITEMS.register("lightning_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
