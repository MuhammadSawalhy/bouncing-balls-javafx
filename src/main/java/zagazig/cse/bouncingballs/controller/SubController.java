package zagazig.cse.bouncingballs.controller;

import zagazig.cse.bouncingballs.balls.Ball;

public abstract class SubController {
    public Controller controller;

    public SubController(Controller controller) {
        this.controller = controller;
    }

    public void moveBalls() {
        for (Ball ball : controller.balls)
            moveBall(ball);
    }

    public abstract void moveBall(Ball ball);
}
