package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.StackMath.EvaluateExpression.Java;

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
        String[] input = new String[]{"2", "1", "+", "3", "*"};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 9;
            int actual = Solution.evalRPN(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String[] input = new String[]{"4", "13", "5", "/", "+"};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 6;
            int actual = Solution.evalRPN(input);
            assertEquals(expected, actual);
        });
    }
}