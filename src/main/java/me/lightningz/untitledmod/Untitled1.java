package me.lightningz.untitledmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Untitled1.MODID)
public class Untitled1 {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "untitledmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
}
