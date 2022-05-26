package zagazig.cse.bouncingballs;

public class Utils {
    public static double random(double start, double end) {
        return start + (end - start + 1) * Math.random(); // +1 to include the end
    }
}
