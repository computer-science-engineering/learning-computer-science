package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.PC3_SmallestWindowContainingSubstring.Java;

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
        String str = "aabdec";
        String pattern = "abc";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "abdec";
            String actual = Solution.findPermutation(str, pattern);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "abdabca";
        String pattern = "abc";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "abc";
            String actual = Solution.findPermutation(str, pattern);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String str = "adcad";
        String pattern = "abc";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "";
            String actual = Solution.findPermutation(str, pattern);
            assertEquals(expected, actual);
        });
    }
}