package Miscellaneous.src.Problems.Programming.NumberOfDistinctIslands.Java;

public class Solution {
    public static void main(String[] args) {
        int grid[][]=  new int[][] {{1, 1, 0, 1, 1}, 
                                 {0, 0, 0, 1, 0}, 
                                 {1, 0, 1, 0, 0}, 
                                 {1, 1, 0, 0, 1} 
                                };
        System.out.println("Number of islands is: "+ countIslands(grid)); 
    }

    // The main function that returns count of islands in a given 
    //  boolean 2D matrix 
    public static int countIslands(int grid[][]) { 
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        // Make a bool array to mark visited cells. 
        // Initially all cells are unvisited 
        boolean visited[][] = new boolean[rows][cols];  
  
        // Initialize count as 0 and traverse through the all cells 
        // of given matrix 
        int count = 0; 
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j]==1 && !visited[i][j]) { // If a cell with value 1 is not
                    // visited yet, then new island found, Visit all 
                    // cells in this island and increment island count 
                    DFS(grid, i, j, visited); 
                    ++count; 
                }
            } 
        }
        return count; 
    } 

    // A function to check if a given cell (row, col) can 
    // be included in DFS 
    private static boolean isSafe(int grid[][], int row, int col, boolean visited[][]) { 
        int rows = grid.length;
        int cols = grid[0].length;
        // row number is in range, column number is in range 
        // and value is 1 and not yet visited 
        return (row >= 0) && (row < rows) && 
               (col >= 0) && (col < cols) && 
               (grid[row][col]==1 && !visited[row][col]); 
    } 
  
    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 8 neighbors as adjacent vertices 
    private static void DFS(int grid[][], int row, int col, boolean visited[][]) { 
        // These arrays are used to get row and column numbers 
        // of 8 neighbors of a given cell 
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1}; 
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1}; 
  
        // Mark this cell as visited 
        visited[row][col] = true; 
  
        // Recur for all connected neighbors 
        for (int k = 0; k < 8; ++k) {
            if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited) ) {
                DFS(grid, row + rowNbr[k], col + colNbr[k], visited); 
            }
        }
    } 
}