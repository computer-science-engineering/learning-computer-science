package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q4_PalindromePermutation.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Solution2Test {
    
    Solution2 solution;
    
    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution2();
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }
    
    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution2.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String palindrome = "Rats live on no evil star";
        assertTimeout(Duration.ofMillis(1000), () -> {
            Boolean expected = true;
            Boolean actual = Solution2.isPermutationOfPalindrome(palindrome);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String palindrome = "Zeus was deified, saw Suez";
        assertTimeout(Duration.ofMillis(1000), () -> {
            Boolean expected = true;
            Boolean actual = Solution2.isPermutationOfPalindrome(palindrome);
            assertEquals(expected, actual);
        });
    }
}