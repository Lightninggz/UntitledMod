package me.lightningz.untitledmod.world.dimension;

import me.lightningz.untitledmod.Untitled1;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.core.Registry;
import net.minecraft.world.level.dimension.DimensionType;

public class ExampleDimension {
    public static final ResourceKey<Level> EDIM_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Untitled1.MODID, "edim"));
    public static final ResourceKey<DimensionType> EDIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, Untitled1.prefix("example_dimension_type"));

    public static void register() {
        System.out.println("Loading Dimensions for " + Untitled1.MODID);
    }
}
