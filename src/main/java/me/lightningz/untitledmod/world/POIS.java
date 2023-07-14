package me.lightningz.untitledmod.world;

import com.google.common.collect.ImmutableSet;
import me.lightningz.untitledmod.Untitled1;
import me.lightningz.untitledmod.blocks.BlockRegister;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class POIS {

    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, Untitled1.MODID);


    public static final RegistryObject<PoiType> PORTAL =
            POI.register("portal", () -> new PoiType(
                    ImmutableSet.copyOf(BlockRegister.PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1
            ));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
