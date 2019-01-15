package LeetCode.src.Explore.Interview.GoogleInterview.Design.MovingAverageFromDataStream.Java;

import static org.junit.jupiter.api.Assertions.*;

public class Solution {
    public static void main(String[] args) {
        int size = 3;
        MovingAverage m = new MovingAverage(size);
        assertEquals(m.next(1), (double)1);
        assertEquals(m.next(10), (double)(1 + 10) / 2);
        assertEquals(m.next(3), (double)(1 + 10 + 3) / 3);
        assertEquals(m.next(5), (double)(10 + 3 + 5) / 3);
    }
}