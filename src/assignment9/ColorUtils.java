package assignment9;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {

    /**
     * Generates a solid random color (fully opaque).
     * @return a new Color with random RGB values
     */
    public static Color solidColor() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    /**
     * Generates a semi-transparent version of a random color.
     * @return a transparent Color
     */
    public static Color transparentColor() {
        Color c = solidColor();
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), 64);
    }
}
