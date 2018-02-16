package Firecode.src.Problems.Level1.FlipIt.Java;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        flipItVerticalAxis(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i=0; i<rows; i++) {
            System.out.println();
            for (int j=0; j<cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    public static void flipItVerticalAxis(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i=0; i<rows; i++) {
            int endPtr = cols-1;
            for (int j=0; j<cols/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][endPtr];
                matrix[i][endPtr--] = temp;
            }
        }
    }    
}