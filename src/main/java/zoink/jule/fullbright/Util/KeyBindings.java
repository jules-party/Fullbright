package zoink.jule.fullbright.Util;

import net.minecraft.client.GameSettings;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {
    public static final String CATEGORY = "key.category.fullbright";
    public static final String TOGGLE_FB = "key.fullbright.togglekey";
    public static final String INCREASE_GAMMA = "key.fullbright.increasekey";
    public static final String DECREASE_GAMMA = "key.fullbright.decreasekey";

    public static final KeyBinding TOGGLE_KEY = new KeyBinding(TOGGLE_FB, GLFW.GLFW_KEY_M, CATEGORY);
    public static final KeyBinding INCREASE_KEY = new KeyBinding(INCREASE_GAMMA, GLFW.GLFW_KEY_UP, CATEGORY);
    public static final KeyBinding DECREASE_KEY = new KeyBinding(DECREASE_GAMMA, GLFW.GLFW_KEY_DOWN, CATEGORY);

    public static void init(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(TOGGLE_KEY);
        ClientRegistry.registerKeyBinding(INCREASE_KEY);
        ClientRegistry.registerKeyBinding(DECREASE_KEY);
    }
}