package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P3_LongestSubstringWithKDistinctCharacters.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String str = "araaci";
        int k = 2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.findLength(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "araaci";
        int k = 1;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.findLength(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String str = "cbbebi";
        int k = 3;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 5;
            int actual = Solution.findLength(str, k);
            assertEquals(expected, actual);
        });
    }
}