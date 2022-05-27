package zagazig.cse.bouncingballs.controller;

import zagazig.cse.bouncingballs.balls.Ball;
import zagazig.cse.bouncingballs.balls.Vector;

public class EdgesController extends SubController {

    public EdgesController(Controller controller) {
        super(controller);
    }

    @Override
    public void moveBall(Ball ball) {
        ball.move(controller.settings.speedMulitplier);
        Vector pos = ball.getPosition();
        double radius = ball.radius;

        // TODO: handle collision between the controls box and the ball

        // right edge of the window
        if (pos.x + radius > controller.settings.width)
            ball.velocity.x = -ball.velocity.x;

        // left edge of the window
        if (pos.x - radius < 0)
            ball.velocity.x = -ball.velocity.x;

        // bottom edge of the window
        if (pos.y + radius > controller.settings.height)
            ball.velocity.y = -ball.velocity.y;

        // top edge of the window
        if (pos.y - radius < 0)
            ball.velocity.y = -ball.velocity.y;
    }
}
