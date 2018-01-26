package ElementsOfProgrammingInterviews.src.Book.C5_PrimitiveTypes.Q6_ComputeDivision.Java;

public class Division {

    public static long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }

            result += 1L << power;
            x -= yPower;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(11, 2));
    }
}
