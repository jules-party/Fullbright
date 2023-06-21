package zoink.jule.fullbright.Util;

import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.text.DecimalFormat;

import static zoink.jule.fullbright.Util.Values.getToggledGamma;

public class GammaOptions {
    private static final GameSettings settings = Minecraft.getInstance().gameSettings;
    private static final DecimalFormat decimalFormat = new DecimalFormat(".#");
    public static void toggleGamma() {
        double newValue = settings.gamma == 1 ? getToggledGamma() / 100 : 1;
        settings.gamma = newValue;

        setGamma(settings.gamma);
    }

    public static void increaseGamma(double value) {
        double newValue = settings.gamma;
        newValue += value == 0 ? 0.1 : value;
        if (newValue > 15)
            newValue = 15;
        settings.gamma = Double.parseDouble(decimalFormat.format(newValue));

        setGamma(newValue);
    }

    public static void decreaseGamma(double value) {
        double newValue = settings.gamma;
        newValue -= value == 0 ? 0.1 : value;
        if (newValue < -7.5)
            newValue = -7.5;
        settings.gamma = Double.parseDouble(decimalFormat.format(newValue));

        setGamma(newValue);
    }

    private static void setGamma(double newValue) {
        double valAsPerc = newValue * 100;
        ITextComponent message = new StringTextComponent("Gamma: " + TextFormatting.GOLD +  Math.round(valAsPerc)  + TextFormatting.WHITE);
        Minecraft.getInstance().player.sendStatusMessage(message, true);

        if (valAsPerc != getToggledGamma() && valAsPerc != 100)
            Values.setToggledGamma(valAsPerc);
    }
}
