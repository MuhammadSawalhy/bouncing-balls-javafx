package zagazig.cse.bouncingballs.controller;

import java.util.Arrays;
import java.util.List;

import zagazig.cse.bouncingballs.AppSettings;
import zagazig.cse.bouncingballs.balls.Ball;
import zagazig.cse.bouncingballs.balls.BallsGenerator;

public class Controller {
    public final AppSettings settings;
    public final List<Ball> balls;
    public final List<SubController> subControllers;

    public Controller(AppSettings settings) {
        this.settings = settings;
        var edgesController = new EdgesController(this);
        subControllers = Arrays.asList(edgesController);
        balls = BallsGenerator.generateRandomBalls(10, settings);
    }

    public void moveBalls() {
        for (SubController subcont : subControllers)
            subcont.moveBalls();
    }
}
