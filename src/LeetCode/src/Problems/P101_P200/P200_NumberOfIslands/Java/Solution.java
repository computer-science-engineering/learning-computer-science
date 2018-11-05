package LeetCode.src.Problems.P101_P200.P200_NumberOfIslands.Java;

public class Solution {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
            new char[] {'1', '1', '0', '0', '0'},
            new char[] {'1', '1', '0', '0', '0'},
            new char[] {'0', '0', '1', '0', '0'},
            new char[] {'0', '0', '0', '1', '1'},
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }

    private static void DFSMarking(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}