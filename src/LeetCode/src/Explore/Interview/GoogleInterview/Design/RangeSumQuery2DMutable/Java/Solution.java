package LeetCode.src.Explore.Interview.GoogleInterview.Design.RangeSumQuery2DMutable.Java;

import static org.junit.jupiter.api.Assertions.*;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
            };
        NumMatrix obj = new NumMatrix(matrix);
        assertEquals(8, obj.sumRegion(2, 1, 4, 3));
        obj.update(3, 2, 2);
        assertEquals(10, obj.sumRegion(2, 1, 4, 3));
    }
}