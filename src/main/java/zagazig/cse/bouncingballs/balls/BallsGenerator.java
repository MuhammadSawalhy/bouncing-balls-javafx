package zagazig.cse.bouncingballs.balls;

import java.util.ArrayList;

import zagazig.cse.bouncingballs.AppSettings;
import zagazig.cse.bouncingballs.Utils;

public class BallsGenerator {
    public static Ball generateRandomBall(AppSettings settings) {
        double radius = Utils.random(10, 30);

        // TODO: it may be beneath the controls box, so handle this later
        double x = Utils.random(radius, settings.width - radius);
        double y = Utils.random(radius, settings.height - radius);
        Vector position = new Vector(x, y);

        Ball ball = new Ball(position, radius);
        ball.shape.setFill(Utils.randomColor());

        return ball;
    }

    public static ArrayList<Ball> generateRandomBalls(int count, AppSettings settings) {
        ArrayList<Ball> balls = new ArrayList<>(count);
        for (int i = 0; i < count; i++) 
            balls.add(generateRandomBall(settings));
        return balls;
    }
}
