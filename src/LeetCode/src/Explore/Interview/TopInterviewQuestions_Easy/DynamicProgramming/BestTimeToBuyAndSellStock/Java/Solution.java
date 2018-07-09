package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.DynamicProgramming.BestTimeToBuyAndSellStock.Java;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }		
        int max = 0 ;
        int soFarMin = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > soFarMin) {
                max = Math.max(max, prices[i] - soFarMin);
            } else {
               soFarMin = prices[i];  
            }
        }	     
       return  max;
    }

    public static int maxProfit_Kadane(final int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}