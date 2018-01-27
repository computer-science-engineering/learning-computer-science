package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringMath.RomanToInteger.Java;

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
        String input = "XIV";
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 14;
            int actual = Solution.romanToInt(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "XX";
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 20;
            int actual = Solution.romanToInt(input);
            assertEquals(expected, actual);
        });
    }
}