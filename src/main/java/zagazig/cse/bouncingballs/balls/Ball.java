package zagazig.cse.bouncingballs.balls;

import javafx.scene.shape.Circle;
import zagazig.cse.bouncingballs.Utils;

public class Ball {
    public final double radius;
    private Vector position;
    private Vector initialVelocity;
    public Vector velocity;
    public Vector acceleration;
    public Circle shape;

    public Ball(Vector position, double radius) {
        this.position = position;
        this.radius = radius;
        velocity = Vector.random(Utils.random(2, 5));
        acceleration = new Vector(0, 0);
        initialVelocity = velocity.copy();
        shape = new Circle(position.x, position.y, radius);
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
        updateShapePosition();
    }

    public void move(Vector vec) {
        position.add(vec);
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
        updateShapePosition();
    }

    public void move(double speedMultiplier) {
        var newAcceleration = acceleration.copy();
        var newVelocity = velocity.copy();
        newVelocity.scale(speedMultiplier);
        newAcceleration.scale(speedMultiplier);
        position.add(newVelocity);
        velocity.add(newAcceleration);
        updateShapePosition();
    }

    public void resetVelocity() {
        velocity.setMagnitude(initialVelocity.getMagnitude());
    }

    private void updateShapePosition() {
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
    }
}
