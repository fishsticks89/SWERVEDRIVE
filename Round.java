public class Round {
    public static String round(double roundable) {
        String str = String.format("%f\n", roundable);
        return str.substring(0, str.length() - 5);
    }
}
