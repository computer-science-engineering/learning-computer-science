package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.MaximumVacationDays.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] flights = {{0,1,1},{1,0,1},{1,1,0}}, days = {{1,3,1},{6,0,3},{3,3,3}};
        System.out.println(maxVacationDays(flights, days));
    }

    public static int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }

        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
}