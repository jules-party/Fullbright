package zoink.jule.fullbright.Util;

import net.minecraft.client.Minecraft;

public class Values {
    private static final double gamma = Minecraft.getInstance().gameSettings.gamma;
    private static int toggledGamma = 1500;

    public static int getGammaPercent() {
        return (int)Math.round(gamma * 100);
    }
    public static double getToggledGamma() {
        return toggledGamma / 100.0;
    }

    public static void setToggledGamma(double gamma) {
        toggledGamma = (int)Math.round(gamma * 100);
    }
}
