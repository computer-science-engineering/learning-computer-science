package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.SentenceScreenFitting.Java;

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
        String[] sentence = {"a", "bcd", "e"};
        int rows = 3, cols = 6;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.wordsTyping(sentence, rows, cols);
            int actual_opt = Solution.wordsTyping_opt(sentence, rows, cols);
            assertEquals(expected, actual);
            assertEquals(expected, actual_opt);
        });
    }
}