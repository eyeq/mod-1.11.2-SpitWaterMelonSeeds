package eyeq.spitwatermelonseeds;

import eyeq.spitwatermelonseeds.event.SpitWaterMelonSeedsEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.spitwatermelonseeds.SpitWaterMelonSeeds.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class SpitWaterMelonSeeds {
    public static final String MOD_ID = "eyeq_spitwatermelonseeds";

    @Mod.Instance(MOD_ID)
    public static SpitWaterMelonSeeds instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SpitWaterMelonSeedsEventHandler());
    }
}
