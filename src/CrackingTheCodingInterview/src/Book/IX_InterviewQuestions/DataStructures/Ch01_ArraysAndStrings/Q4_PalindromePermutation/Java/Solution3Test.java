package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q4_PalindromePermutation.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Solution3Test {
    
    Solution3 solution;
    
    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution3();
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }
    
    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution3.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String palindrome = "Rats live on no evil star";
        assertTimeout(Duration.ofMillis(700), () -> {
            Boolean expected = true;
            Boolean actual = Solution3.isPermutationOfPalindrome(palindrome);
            assertEquals(expected, actual);
        });
    }
}