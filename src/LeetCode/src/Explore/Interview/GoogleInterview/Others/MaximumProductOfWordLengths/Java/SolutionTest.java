package LeetCode.src.Explore.Interview.GoogleInterview.Others.MaximumProductOfWordLengths.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 16;
            int actual = Solution.maxProduct(words);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual = Solution.maxProduct(words);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String[] words = {"a","aa","aaa","aaaa"};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.maxProduct(words);
            assertEquals(expected, actual);
        });
    }
}