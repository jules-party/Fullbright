package zoink.jule.fullbright;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zoink.jule.fullbright.Util.KeyBindings;

import java.util.stream.Collectors;

import static zoink.jule.fullbright.Util.GammaOptions.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fullbright.MODID)

public class Fullbright {
    public static final String MODID = "fullbright";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public Fullbright() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this :: setup);
    }

    private void setup(final FMLClientSetupEvent event) {
        LOGGER.debug("hiiii :3");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInputEvent(InputEvent.KeyInputEvent event) {
        if (KeyBindings.TOGGLE_KEY.isPressed())
            toggleGamma();

        if (KeyBindings.INCREASE_KEY.isPressed())
            increaseGamma(0);

        if (KeyBindings.DECREASE_KEY.isPressed()) {
            decreaseGamma(0);
        }
    }
}
