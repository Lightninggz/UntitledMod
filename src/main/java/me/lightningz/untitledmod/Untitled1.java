package me.lightningz.untitledmod;

import com.mojang.logging.LogUtils;
import me.lightningz.untitledmod.commands.testguicmd;
import me.lightningz.untitledmod.world.dimension.ExampleDimension;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import me.lightningz.untitledmod.items.Items;
import org.slf4j.Logger;

import java.util.Locale;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Untitled1.MODID)
public class Untitled1 {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "untitledmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Untitled1() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ExampleDimension.register();

        Items.register(modEventBus);

    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterClientCommandsEvent e) {

        testguicmd.register(e.getDispatcher());

    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }
}
