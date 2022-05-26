package zagazig.cse.bouncingballs.balls;

import javafx.scene.shape.Circle;
import zagazig.cse.bouncingballs.Utils;

public class Ball {
    private double radius;
    private Vector position;
    private Vector initialVelocity;
    public Vector velocity;
    public Vector acceleration;
    public Circle shape;

    public Ball() {
        velocity = Vector.random(Utils.random(1, 8));
        velocity.add(new Vector(2, 2)); // to make sure it is moving
        acceleration = new Vector(0, 0);
        radius = Utils.random(10, 30);
        shape = new Circle(position.x, position.y, radius);
        initialVelocity = velocity.copy();
    }

    public double getRadius() {
        return radius;
    }

    /*
     * return a copy of the position
     */
    public Vector getPosition() {
        return position.copy();
    }

    public void move() {
        position.add(velocity);
        velocity.add(acceleration);
    }

    public void move(Vector vec) {
        position.add(vec);
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
    }

    public void move(double speedMultiplier) {
        var newAcceleration = acceleration.copy();
        var newVelocity = velocity.copy();
        newVelocity.scale(speedMultiplier);
        newAcceleration.scale(speedMultiplier);
        position.add(newVelocity);
        velocity.add(newAcceleration);
    }

    public void resetVelocity() {
        velocity.setMagnitude(initialVelocity.getMagnitude());
    }
}
