package ElementsOfProgrammingInterviews.src.Book.C5_PrimitiveTypes.Q5_MultiplyWithoutArithmeticalOperators.Java;

import java.util.Random;

public class MultiplyShiftAdd {
    public static long multiply(long x, long y) {
        long sum = 0;
        while (x != 0) {
            // Examines each bit of x.
            if ((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return sum;
    }

    private static long add(long a, long b) {
        long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
        while (tempA != 0 || tempB != 0) {
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= (ak ^ bk ^ carryin);
            carryin = carryout << 1;
            k <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }
        return sum | carryin;
    }

    /* http://stackoverflow.com/a/22257661/420827 */
    public static String binaryAddition(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int first = s1.length() - 1;
        int second = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = carry;
            if (first >= 0) {
                sum += s1.charAt(first) - '0';
                first--;
            }
            if (second >= 0) {
                sum += s2.charAt(second) - '0';
                second--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0)
            sb.append('1');

        sb.reverse();
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        multiply(13, 9);
        if (args.length == 2) {
            int x = Integer.parseInt(args[0]), y = Integer.parseInt(args[1]);
            long res = multiply(x, y);
            assert(res == x * y);
            System.out.println("PASS: x = " + x + ", y = " + y + "; prod = " + res);
        } else {
            Random r = new Random();
            // Random test, only works if the product is not greater than 2^32 - 1.
            for (int i = 0; i < 100000; ++i) {
                int x = r.nextInt(65535), y = r.nextInt(65535);
                long prod = multiply(x, y);
                assert(prod == (long)x * y);
                System.out.println("PASS: x = " + x + ", y = " + y + "; prod = "
                        + prod);
            }
        }
    }
}
