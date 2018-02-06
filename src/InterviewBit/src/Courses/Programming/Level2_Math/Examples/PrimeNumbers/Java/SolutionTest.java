package InterviewBit.src.Courses.Programming.Level2_Math.Examples.PrimeNumbers.Java;

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
        int input = 6;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] actual = Solution.sieve(input);
            int[] expected = {2, 3, 5};
            assertArrayEquals(expected, actual);
        });
    }
}