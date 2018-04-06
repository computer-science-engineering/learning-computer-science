package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.AdHoc.BestTimeToBuyAndSellStock2.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(maxProfit(A));
    }
    
    public static int maxProfit(final int[] A) {
        int total = 0;
        for (int i=0; i<A.length-1; i++) {
            if (A[i+1]>A[i]) {
                total += A[i+1]-A[i];
            }
        }        
        return total;
    }
}