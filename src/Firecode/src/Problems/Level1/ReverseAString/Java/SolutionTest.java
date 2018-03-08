package Firecode.src.Problems.Level1.ReverseAString.Java;

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
        String input = "abcd";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "dcba";
            String actual = Solution.reverseString(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String input = "a";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "a";
            String actual = Solution.reverseString(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        String input = "";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "";
            String actual = Solution.reverseString(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase3() {
        String input = null;
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = null;
            String actual = Solution.reverseString(input);
            assertEquals(expected, actual);
        });
    }
}