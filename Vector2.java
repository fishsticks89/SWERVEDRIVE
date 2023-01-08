public class Vector2 {
    double x;
    double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double xVec) {
        this.x = xVec;
    }

    public double getY() {
        return y;
    }

    public void setY(double yVec) {
        this.y = yVec;
    }

    /**
     * gets the wheel direction in degrees
     * 
     * @return
     */
    public double getDirection() {
        if (x == 0)
            return (y > 0) ? 90 : -90;
        return (x >= 0) ? MMath.darctan(y / x) : ((y > 0) ? 180 + MMath.darctan(y / x) : -180 + MMath.darctan(y / x));
    }

    public double getMagnitude() {
        double magnitude = Math.sqrt((x * x) + (y * y));
        return magnitude;
    }

    /**
     * 
     * @param magnitude
     * @param direction degrees
     * @return
     */
    static Vector2 vec2FromDir(double magnitude, double direction) {
        double x = Math.cos(Math.toRadians(direction));
        double y = Math.sin(Math.toRadians(direction));
        return new Vector2(x * magnitude, y * magnitude);
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(this.getX() + other.getX(), this.getY() + other.getY());
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}