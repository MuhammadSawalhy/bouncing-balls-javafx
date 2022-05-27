package zagazig.cse.bouncingballs;

import javafx.scene.paint.Color;

public class Utils {
    public static double random(double start, double end) {
        return start + (end - start + 1) * Math.random(); // +1 to include the end
    }

    public static Color randomColor() {
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        return color.darker();
    }
}
