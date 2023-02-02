package display.blob;

import java.awt.*;

public class ColorModifier {
    public static Color multiply(Color color, double num){
        int r = (int) (color.getRed()*num);
        int g = (int) (color.getGreen()*num);
        int b = (int) (color.getBlue()*num);
        return new Color(r,g,b);
    }
}
