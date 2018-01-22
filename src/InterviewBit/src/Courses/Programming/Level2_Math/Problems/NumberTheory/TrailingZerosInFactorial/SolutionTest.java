package InterviewBit.src.Courses.Programming.Level2_Math.Problems.NumberTheory.TrailingZerosInFactorial;

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
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 781;
            int actual = Solution.trailingZeroes(3125);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 1151;
            int actual = Solution.trailingZeroes(4617);
            assertEquals(expected, actual);
        });
    }
}