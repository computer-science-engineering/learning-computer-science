package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.MinimumPathSum.Java;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}