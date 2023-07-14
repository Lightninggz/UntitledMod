package me.lightningz.untitledmod.blocks;

import me.lightningz.untitledmod.Untitled1;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Untitled1.MODID);

    public static final RegistryObject<Block> PORTAL = registerBlockWithoutBlockItem("portal", () -> new EPortalBlock());

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
}
