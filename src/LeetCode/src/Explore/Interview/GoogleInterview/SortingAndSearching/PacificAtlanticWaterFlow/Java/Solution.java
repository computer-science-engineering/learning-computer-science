package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.PacificAtlanticWaterFlow.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        List<int[]> result = pacificAtlantic(matrix);
        for (int[] intArray : result) {
            for (int item : intArray) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    private static int[] dx = {-1,0,0,1}; // cols - left, bottom, top, right
    private static int[] dy = {0,1,-1,0}; // rows - left, bottom, top, right

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        /*for (int i = 0; i < matrix.length; i++) {
            pacific[i][0] = true;
            atlantic[i][matrix[0].length-1] = true;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            pacific[0][j] = true;
            atlantic[matrix.length-1][j] = true;
        }*/

        // explore row wise starting from beaches - so first column for pacific and last column for atlantic
        for (int i = 0; i < matrix.length; i++) {
            explore(pacific, matrix, i, 0);
            explore(atlantic, matrix, i, matrix[0].length-1);
        }

        // explore column wise starting from beaches - so first row for pacific and last row for atlantic
        for (int j = 0; j < matrix[0].length; j++) {
            explore(pacific, matrix, 0, j);
            explore(atlantic, matrix, matrix.length-1, j);
        }

        // reconcile
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j] == true)
                    res.add(new int[]{i,j});
            }
        }
        return res;
        
    }

    private static void explore(boolean[][] grid, int[][] matrix, int i, int j){
        grid[i][j] = true;
        for (int d = 0; d < dx.length; d++) {
            if (i+dy[d] < grid.length && i+dy[d] >= 0 && // row index
                j + dx[d] < grid[0].length && j + dx[d] >= 0 && // col index
                grid[i+dy[d]][j+dx[d]] == false && matrix[i+dy[d]][j+dx[d]] >= matrix[i][j]) {
                    explore(grid, matrix, i+dy[d], j+dx[d]);
                }
        }
    }
}