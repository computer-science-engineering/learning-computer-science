package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.CleverStack.LargestRectangleInHistogram.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {
    
    Solution solution;
    
    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution();
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }
    
    @Test
    public void TrivialCase1() {
        int[] input = new int[]{2,1,5,6,2,3};
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 10;
            int actual = Solution.largestRectangleArea(input);
            assertEquals(expected, actual);
        });
    }
}