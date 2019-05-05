package ByteByByte.src.CodingInterviewQuestions.Array.P2_01Knapsack.Java;

public class Solution {
    public static void main(String[] args) {
        int val[] = {60, 100, 120}; 
        int wt[] = {10, 20, 30}; 
        int  W = 50; 
        System.out.println(knapsack01(val, wt, W));
    }

    // bottomUpDP - using DP
    public static int knapsack01(int val[], int wt[], int W) {
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++) {
                if(i == 0 || j == 0) {
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0) {
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                } else {
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }
}