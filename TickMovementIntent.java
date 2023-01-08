public class TickMovementIntent {
    double x; // speed going right m/s
    double y; // speed going forward m/s
    double rotation; // rotational speed deg/s counterclockwise
    DriveData drive;

    public TickMovementIntent(DriveData drive, double x, double y, double rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.drive = drive;
    }

    /**
     * Takes two coordinates and outputs a vector for a wheel at that position
     * 
     * @param xCoord the x coordinate of the wheel assuming the y axis points where
     *               we are going
     * @param yCoord the y coordinate of the wheel assuming the y axis points where
     *               we are going
     * @return hehe
     */
    private Vector2 computeWheel(Vector2 wheelPosition) {
        Vector2 moveVector = new Vector2(x, y);
        // this is the direction the wheel will point for the turn
        double wheelTurn = wheelPosition.getDirection() + 90; // we add 90 to turn the wheel from outward to counterclockwise
        double speed = 
        // diameter * pi
        (Math.PI * Math.sqrt(Math.pow(drive.getChassis_width(), 2) + Math.pow(drive.getChassis_length(), 2))) 
        *
        // deg/s * turns/deg = turns/s 
        (-rotation * 1 / 360); // the speed we turn at is the circumference of the robot * turns of the robot per second
        Vector2 turnVector = Vector2.vec2FromDir(speed, wheelTurn);
        return moveVector.add(turnVector);
    }

    /**
     * Gets the wheel position if the y axis is where you are going
     * 
     * @param wheel
     * @return
     */
    private Vector2 getWheelPosition(int wheel) {
        // -- raw wheelpos
        if (!(1 <= wheel && wheel <= 4))
            throw new Error("not a wheel");
        Vector2 wheelpos = new Vector2(
                drive.getChassis_width() / 2 * ((wheel == 1 || wheel == 4) ? 1 : -1),
                drive.getChassis_length() / 2 * ((wheel == 1 || wheel == 2) ? 1 : -1));

        return wheelpos;
    }

    public TickMovementVector compute() {
        return new TickMovementVector(
                computeWheel(getWheelPosition(1)),
                computeWheel(getWheelPosition(2)),
                computeWheel(getWheelPosition(3)),
                computeWheel(getWheelPosition(4)));
    }
}