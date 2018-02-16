package Firecode.src.Problems.Level1.PalindromeTester.Java;

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
        String input = "madam";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isStringPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "not a palindrome";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.isStringPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String input = "a";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isStringPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        String input = "";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isStringPalindrome(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase3() {
        String input = null;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isStringPalindrome(input);
            assertEquals(expected, actual);
        });
    }
}