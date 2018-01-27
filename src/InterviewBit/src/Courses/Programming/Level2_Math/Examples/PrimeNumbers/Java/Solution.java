package InterviewBit.src.Courses.Programming.Level2_Math.Examples.PrimeNumbers.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] result = sieve(6);
        for (int i=0; i<result.length; i++) {               
            System.out.print(result[i] + " ");
        }
    }    

    public static int[] sieve(int A) {
        int[] result = new int[A+1];
        for (int i=0; i<=A; i++) {
            result[i] = 1;
        }
        result[0] = 0;
        result[1] = 0;
        for (int i=2; i<=Math.sqrt(A); i++) {
            if (result[i] == 1) {
                for (int j=2; i*j<=A; j++) {
                    result[i*j] = 0;
                }
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for (int i=0; i<result.length; i++) {
            if (result[i] == 1) {                            
                primes.add(i);
            }
        }
        int k=0;
        result = new int[primes.size()];
        for (Integer item : primes) {
            result[k] = (int)item;
            k++;
        }
        return result;
    }
}