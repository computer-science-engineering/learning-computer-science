package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringTricks.LongestPalindromicSubstring;

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
        String input = "aaaabaaa";
        assertTimeout(Duration.ofMillis(200), () -> {
            String expected = "aaabaaa";
            String actual = Solution.longestPalindrome(input);
            assertEquals(expected, actual);
        });
    }
}