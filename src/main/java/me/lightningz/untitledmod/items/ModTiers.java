package me.lightningz.untitledmod.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier LIGHTNING = new ForgeTier(10, 9999, 30.5f, 20f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.LIGHTNING_INGOT.get()));
}
