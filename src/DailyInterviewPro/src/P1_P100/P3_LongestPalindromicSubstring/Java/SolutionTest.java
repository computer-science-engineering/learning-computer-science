package DailyInterviewPro.src.P1_P100.P3_LongestPalindromicSubstring.Java;

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
        String input = "aaaabaaa";
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "aaabaaa";
            String actual = Solution.longestPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "tracecars";
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "racecar";
            String actual = Solution.longestPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String input = "";
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "";
            String actual = Solution.longestPalindrome(input);
            assertEquals(expected, actual);
        });
    }
}
