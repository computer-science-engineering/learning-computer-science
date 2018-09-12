package LeetCode.src.Problems.P101_P200.P122_BestTimeToBuySellStock2.Java;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                total += prices[i+1]-prices[i];
            }
        }
        
        return total;
    }
}