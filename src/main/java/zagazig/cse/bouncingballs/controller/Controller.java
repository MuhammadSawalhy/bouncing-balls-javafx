package zagazig.cse.bouncingballs.controller;

import java.util.Arrays;
import java.util.List;

import zagazig.cse.bouncingballs.AppSettings;
import zagazig.cse.bouncingballs.balls.Ball;
import zagazig.cse.bouncingballs.balls.BallsGenerator;

public class Controller {
    AppSettings settings = new AppSettings();
    List<Ball> balls;
    List<SubController> subControllers;

    public Controller() {
        var edgesController = new EdgesController(this);
        subControllers = Arrays.asList(edgesController);
        balls = BallsGenerator.generateRandomBalls(10);
    }

    public void moveBalls() {
        for (SubController subcont : subControllers)
            subcont.moveBalls();
    }
}
