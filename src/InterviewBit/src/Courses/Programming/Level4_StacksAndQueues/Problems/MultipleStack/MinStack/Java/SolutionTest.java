package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.MultipleStack.MinStack.Java;

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
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(700), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        Solution minStack = new Solution();
        assertTimeout(Duration.ofMillis(700), () -> {
            int[] expected = new int[]{-3, 0, -2};
            int[] actual = new int[3];
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            actual[0] = minStack.getMin();
            minStack.pop();
            actual[1] = minStack.top();
            actual[2] = minStack.getMin();
            assertArrayEquals(expected, actual);
        });
    }
}