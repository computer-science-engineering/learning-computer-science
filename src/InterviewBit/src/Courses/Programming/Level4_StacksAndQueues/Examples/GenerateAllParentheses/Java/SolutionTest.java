package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Examples.GenerateAllParentheses.Java;

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
        String input = "()[]{}";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 1;
            int actual = Solution.isValid(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String input = "])";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 0;
            int actual = Solution.isValid(input);
            assertEquals(expected, actual);
        });
    }
}