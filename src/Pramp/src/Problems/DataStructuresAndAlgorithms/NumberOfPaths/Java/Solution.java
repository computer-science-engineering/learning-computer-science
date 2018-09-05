package Pramp.src.Problems.DataStructuresAndAlgorithms.NumberOfPaths.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numOfPathsToDest(4));
    }

    public static int numOfPathsToDest(int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                // handle diagonal
                if (i>j) {          
                    dp[i] = dp[i] + dp[i-1];
                }
            }
        }        
        return dp[n-1];
      }
}