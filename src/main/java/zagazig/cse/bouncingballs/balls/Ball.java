package zagazig.cse.bouncingballs.balls;

import javafx.scene.shape.Circle;
import zagazig.cse.bouncingballs.Utils;

public class Ball {
    private Vector position;
    private Vector initialVelocity;
    public Vector velocity;
    public Vector acceleration;
    public Circle shape;

    public Ball() {
        velocity = Vector.random(Utils.random(1, 8));
        velocity.add(new Vector(2, 2)); // to make sure it is moving
        acceleration = new Vector(0, 0);
        shape = new Circle(position.x, position.y, Utils.random(10, 30));
        initialVelocity = velocity.copy();
    }

    public void move() {
        position.add(velocity);
    }

    public void move(Vector vec) {
        position.add(vec);
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
    }

    public void move(double velocityMultiplier) {
        var newVelocity = velocity.copy();
        newVelocity.scale(velocityMultiplier);
        position.add(newVelocity);
    }

    public void resetVelocity() {
        velocity.setMagnitude(initialVelocity.getMagnitude());
    }
}
