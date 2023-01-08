public class TickMovementVector {
    Vector2 frontRightWheel;
    Vector2 frontLeftWheel;
    Vector2 rearLeftWheel;
    Vector2 rearRightWheel;

    public TickMovementVector(Vector2 frontRightWheel, Vector2 frontLeftWheel, Vector2 rearLeftWheel,
            Vector2 rearRightWheel) {
        this.frontRightWheel = frontRightWheel;
        this.frontLeftWheel = frontLeftWheel;
        this.rearLeftWheel = rearLeftWheel;
        this.rearRightWheel = rearRightWheel;
    }

    public Vector2 getFrontRightWheel() {
        return frontRightWheel;
    }

    public void setFrontRightWheel(Vector2 frontRightWheel) {
        this.frontRightWheel = frontRightWheel;
    }

    public Vector2 getFrontLeftWheel() {
        return frontLeftWheel;
    }

    public void setFrontLeftWheel(Vector2 frontLeftWheel) {
        this.frontLeftWheel = frontLeftWheel;
    }

    public Vector2 getRearLeftWheel() {
        return rearLeftWheel;
    }

    public void setRearLeftWheel(Vector2 rearLeftWheel) {
        this.rearLeftWheel = rearLeftWheel;
    }

    public Vector2 getRearRightWheel() {
        return rearRightWheel;
    }

    public void setRearRightWheel(Vector2 rearRightWheel) {
        this.rearRightWheel = rearRightWheel;
    }

    @Override
    public String toString() {
        return "[" +
                Round.round(frontRightWheel.getDirection()) + "," +
                Round.round(frontLeftWheel.getDirection()) + "," +
                Round.round(rearLeftWheel.getDirection()) + "," +
                Round.round(rearRightWheel.getDirection()) + "]";
    }
}
