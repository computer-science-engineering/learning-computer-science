package LeetCode.src.Problems.P1_P100.P48_RotateImage.Java;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(input);
        for(int i=0; i<input.length; i++) {
            for (int j=0; j<input.length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int first=0, last=rows-1; first<last; first++, last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }
        for(int i = 0; i < rows; i++) {
            for(int j = i+1; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}