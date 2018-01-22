package ElementsOfProgrammingInterviews.src.C6_Arrays.Q0_BootCamp.Java;

import java.util.Random;

public class EvenOddArray {
    public static void evenOdd(int[] A) {
        int nextEven = 0, nextOdd = A.length - 1;
        while (nextEven < nextOdd) {
            if (A[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                int temp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] A = new int[0];
        for (int i = 0; i < 1000; i++) {
            A = new int[rnd.nextInt(20) + 1];
            for (int j = 0; j < A.length; j++) {
                A[j] = rnd.nextInt(20);
            }
        }
        evenOdd(A);
    }
}
