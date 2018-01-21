package Courses.Programming.Level3_Strings.Problems.StringSimulation.PalindromeString;

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
        String input = "A man, a plan, a canal: Panama";
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 1;
            int actual = Solution.isPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "race a car";
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 0;
            int actual = Solution.isPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String input = "1a2";
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 0;
            int actual = Solution.isPalindrome(input);
            assertEquals(expected, actual);
        });
    }
}