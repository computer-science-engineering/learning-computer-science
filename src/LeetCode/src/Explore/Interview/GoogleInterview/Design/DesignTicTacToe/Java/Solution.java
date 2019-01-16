package LeetCode.src.Explore.Interview.GoogleInterview.Design.DesignTicTacToe.Java;

import static org.junit.jupiter.api.Assertions.*;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        TicTacToe obj = new TicTacToe(n);
        assertEquals(0, obj.move(0, 0, 1));
        assertEquals(0, obj.move(0, 2, 2));
        assertEquals(0, obj.move(2, 2, 1));
        assertEquals(0, obj.move(1, 1, 2));
        assertEquals(0, obj.move(2, 0, 1));
        assertEquals(0, obj.move(1, 0, 2));
        assertEquals(1, obj.move(2, 1, 1));
    }
}