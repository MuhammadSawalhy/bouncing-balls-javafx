package zagazig.cse.bouncingballs.balls;

public class Vector {
    public double x;
    public double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public void setMagnitude(double mag) {
        double ang = this.getAngle();
        this.x = mag * Math.cos(ang);
        this.y = mag * Math.sin(ang);
    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    public double distanceTo(Vector v) {
        double dx = this.x - v.x;
        double dy = this.y - v.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void add(Vector v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void subtract(Vector v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public void scale(double factor) {
        setMagnitude(this.getMagnitude() * factor);
    }

    public Vector copy() {
        return new Vector(x, y);
    }

    public static Vector random(double mag) {
        var vec = new Vector(Math.random() * 10, Math.random() * 10);
        vec.setMagnitude(mag);
        return vec;
    }
}
