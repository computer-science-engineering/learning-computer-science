package InterviewBit.src.Courses.Programming.Level2_Math.Problems.DigitOp.PalindromeInteger;

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
        int input = 12345;
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 0;
            int actual = Solution.isPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int input = 123454321;
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 1;
            int actual = Solution.isPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void NegativeNumberCase() {
        int input = -2147447412;
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 0;
            int actual = Solution.isPalindrome(input);
            assertEquals(expected, actual);
        });
    }
}