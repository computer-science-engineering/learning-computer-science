package ElementsOfProgrammingInterviews.src.C5_PrimitiveTypes.Q8_ReverseDigits.Java;

public class ReverseInteger {
    public static long reverse(int x) {
        long result = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            result = result * 10 + xRemaining % 10;
            xRemaining /= 10;
        }
        return x < 0 ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1132));
    }
}
