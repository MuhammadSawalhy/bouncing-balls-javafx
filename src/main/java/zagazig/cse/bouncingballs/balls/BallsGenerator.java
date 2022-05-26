package zagazig.cse.bouncingballs.balls;

import java.util.ArrayList;

import zagazig.cse.bouncingballs.Utils;

public class BallsGenerator {
    public static Ball generateRandomBall() {
        Ball ball = new Ball();
        ball.shape.setFill(Utils.randomColor());
        return ball;
    }

    public static ArrayList<Ball> generateRandomBalls(int count) {
        ArrayList<Ball> balls = new ArrayList<>(count);
        for (int i = 0; i < count; i++) 
            balls.add(generateRandomBall());
        return balls;
    }
}
