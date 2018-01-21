package C5_PrimitiveTypes.Q1_ComputeParityOfWord.Java;

public class Parity2 {
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x &= (x - 1); // Drops the lowest set bit of x.
        }

        return result;
    }

    public static void main(String[] args) {
        short y = parity(9);
        System.out.println(y);
    }
}