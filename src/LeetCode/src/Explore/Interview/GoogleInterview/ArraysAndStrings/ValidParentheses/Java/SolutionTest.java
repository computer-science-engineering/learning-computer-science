package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.ValidParentheses.Java;

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
        String s = "()";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isValid(s);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = "()[]{}";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isValid(s);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String s = "(]";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.isValid(s);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        String s = "([)]";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.isValid(s);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase5() {
        String s = "{[]}";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isValid(s);
            assertEquals(expected, actual);
        });
    }
}