
/**
 * I have neither given nor received unauthorized aid on this assignment.
 * Thank you to Eric Yoon.
 * Michael Barr
 */
public class FuckingEric {
    public static void main(String[] args) {
        DriveData data = new DriveData(1, 1, 1);
        final double rotationRate = -90; // deg/s counterclockwise
        final double goRate = 1; // m/s
        for (int i = 0; i < 5000; i++) {
            double time = i / 1000.0;
            double rotation = time * rotationRate;
            Vector2 direction = Vector2.vec2FromDir(goRate, -rotation);
            TickMovementIntent moveIntent = new TickMovementIntent(data, direction.getX(), direction.getY(), rotationRate);
            TickMovementVector move = moveIntent.compute();
            System.out.print(move + " ");
        }
        
        // TickMovementIntent moveIntent = new TickMovementIntent(data, 0, -1, -57.2958);
        // TickMovementVector move = moveIntent.compute();
        // System.out.print(move + ", ");
    }
}