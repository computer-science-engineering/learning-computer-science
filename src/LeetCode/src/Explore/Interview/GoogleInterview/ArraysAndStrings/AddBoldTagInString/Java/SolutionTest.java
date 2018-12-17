package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.AddBoldTagInString.Java;

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
        String s = "abcxyz123";
        String[] dict = {"abc","123"};
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "<b>abc</b>xyz<b>123</b>";
            String actual = Solution.addBoldTag(s, dict);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "<b>aaabbc</b>c";
            String actual = Solution.addBoldTag(s, dict);
            assertEquals(expected, actual);
        });
    }
}