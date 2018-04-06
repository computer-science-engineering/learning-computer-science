package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.SuffixPrefixDp.BestTimeToBuyAndSellStocks1.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2};
        System.out.println(maxProfit(A));
        System.out.println(maxProfit_Kadane(A));
    }
    
    public static int maxProfit(final int[] A) {
        if (A.length == 0) {
            return 0;
        }		
        int max = 0 ;
        int soFarMin = A[0] ;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] > soFarMin) {
                max = Math.max(max, A[i] - soFarMin);
            } else{
               soFarMin = A[i];  
            }
        }	     
       return  max;
    }

    public static int maxProfit_Kadane(final int[] A) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < A.length; i++) {
            maxCur = Math.max(0, maxCur += A[i] - A[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}