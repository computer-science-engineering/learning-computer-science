package C5_PrimitiveTypes.Q9_DecimalIntegerPalindromeCheck.Java;

public class PalindromeNumber {
    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        final int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
        int msdMask = (int) Math.pow(10, numDigits - 1);
        for (int i = 0; i < (numDigits / 2); ++i) {
            if (x / msdMask != x % 10) {
                return false;
            }
            x %= msdMask; // Remove the most significant digit of x.
            x /= 10; // Remove the least significant digit of x.
            msdMask /= 100;
        }
        return true;
    }

    private static boolean checkAns(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(157751));
    }
}
