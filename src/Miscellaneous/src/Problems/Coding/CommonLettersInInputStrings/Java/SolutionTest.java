package Miscellaneous.src.Problems.Coding.CommonLettersInInputStrings.Java;

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
        String word1 = "abcd", word2 = "efgh";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "";
            String actual = Solution.getCommonLetters(word1, word2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String word1 = "aeiou", word2 = "abcde";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "ae";
            String actual = Solution.getCommonLetters(word1, word2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String word1 = "aeiou", word2 = "abcabc";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "a";
            String actual = Solution.getCommonLetters(word1, word2);
            assertEquals(expected, actual);
        });
    }
}