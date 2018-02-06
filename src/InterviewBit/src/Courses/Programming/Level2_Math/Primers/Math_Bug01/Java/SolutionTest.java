package InterviewBit.src.Courses.Programming.Level2_Math.Primers.Math_Bug01.Java;

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
        int input = 10;
        assertTimeout(Duration.ofMillis(500), () -> {
            int actual = Solution.isPrime(input);
            int expected = 0;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int input = 5;
        assertTimeout(Duration.ofMillis(500), () -> {
            int actual = Solution.isPrime(input);
            int expected = 1;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int input = 1;
        assertTimeout(Duration.ofMillis(500), () -> {
            int actual = Solution.isPrime(input);
            int expected = 0;
            assertEquals(expected, actual);
        });
    }
}