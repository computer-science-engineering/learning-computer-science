package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.SpiralMatrix.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows-1, left = 0, right = cols-1;
        int dir = 0; // 0:left to right;1:top to bottom;2: right to left;3: bottom to top
        while(top<=bottom && left<=right){
            if (dir==0){
                for (int i=left; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
                dir = 1;
            }
            else if(dir==1){
                for (int i=top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                dir = 2;
            }
            else if(dir==2){
                for (int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                dir = 3;
            }
            else if(dir==3){
                for (int i=bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }
        }
        return result;
    }
}