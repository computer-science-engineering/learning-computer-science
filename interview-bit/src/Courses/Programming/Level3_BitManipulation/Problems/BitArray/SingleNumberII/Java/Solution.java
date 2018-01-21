package Courses.Programming.Level3_BitManipulation.Problems.BitArray.SingleNumberII.Java;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(singleNumber(input));
    }
    
    public static int singleNumber(final int[] A) {
        int result = 0;
        int x, sum;
         
        // Iterate through every bit
        for(int i=0; i<32; i++) {
            // Find sum of set bits at ith position in all 
            // array elements
            sum = 0;
            x = (1 << i);
            for(int j=0; j<A.length; j++) {
                if((A[j] & x) == 0) {
                    sum++;
                }
            }
            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) == 0) {
                result |= x;
            }
        }
        return result;
    }
}