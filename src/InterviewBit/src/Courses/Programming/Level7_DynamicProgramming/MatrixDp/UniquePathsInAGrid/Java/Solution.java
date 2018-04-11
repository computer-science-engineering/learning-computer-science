package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.MatrixDp.UniquePathsInAGrid.Java;

public class Solution {
    public static void main(String[] args) {
        int[][] A = {
            {0,0,0},
            {0,1,0},
            {0,0,0}};
        System.out.println(uniquePathsWithObstacles(A));
    }
    
    public static int uniquePathsWithObstacles(int[][] A) {
        int width = A[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : A) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}