package C5_PrimitiveTypes.Q1_ComputeParityOfWord.Java;

public class Parity1 {

    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        short y = parity(9);
        System.out.println(y);

    }
}
