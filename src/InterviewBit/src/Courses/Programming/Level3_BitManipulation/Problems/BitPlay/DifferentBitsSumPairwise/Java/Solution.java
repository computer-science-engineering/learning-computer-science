package InterviewBit.src.Courses.Programming.Level3_BitManipulation.Problems.BitPlay.DifferentBitsSumPairwise.Java;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 3, 5};
        System.out.println(cntBits(input));        
    }
    
    public static int cntBits(int[] A) {
        long result = 0;
        for (int i=0; i<32; i++) {
            int count = 0; // number of set bits in the array at the ith position
            for (int j=0; j<A.length; j++) {
                // 1<<i = 1*pow(2,i); 1>>i = 1/pow(2,i); & implies modulo
                if ((A[j] & (1<<i)) != 0) { 
                    count++;
                }
            }
            //result += (count*(A.length-count)*2);
            result = (result + (2L * count * (A.length-count))% 1000000007)% 1000000007;
        }
        return (int)result;
    }
}