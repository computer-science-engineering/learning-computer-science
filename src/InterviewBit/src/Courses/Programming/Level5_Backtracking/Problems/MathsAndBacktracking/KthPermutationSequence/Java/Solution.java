package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.MathsAndBacktracking.KthPermutationSequence.Java;

import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPermutation(2, 1)); //2147483647, 101
    }
    
    public static String getPermutation(int A, int B) {
        List<Integer> numbers = new ArrayList<>();
        //int[] factorial = new int[A+1];
        StringBuilder sb = new StringBuilder();
        
        // create an array of factorial lookup
        // int sum = 1;
        // factorial[0] = 1;
        // for(int i=1; i<=A; i++) {            
        //     sum *= i;
        //     factorial[i] = sum;
        // }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        
        // create a list of numbers to get indices
        for(int i=1; i<=A; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        
        B--;
        
        for(int i = 1; i <= A; i++) {
            //int index = B/factorial[A-i];
            int fact = factorial(A-i).intValue();
            // int index = 0;
            // if (fact > 0) {
            //     index= B/fact;
            // }
            int index= B/fact;
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            B-=index*fact;
        }
        
        return String.valueOf(sb);
    }

    private static BigInteger factorial(int value){
        if(value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
    
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
    
        return result;
    }
}