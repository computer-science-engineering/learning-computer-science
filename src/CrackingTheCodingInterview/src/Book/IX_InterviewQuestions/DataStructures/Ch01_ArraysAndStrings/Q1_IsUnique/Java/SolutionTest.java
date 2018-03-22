package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q1_IsUnique.Java;

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
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        assertTimeout(Duration.ofMillis(500), () -> {
            Boolean[] expected = {true, false, false, true, true};
            Boolean[] actual1 = new Boolean[5];
            Boolean[] actual2 = new Boolean[5];
            int i=0;
            for (String word : words) {
                actual1[i] = Solution.isUniqueChars_solution1(word);
                actual2[i] = Solution.isUniqueChars_solution2(word);
                i++;
            }
            assertArrayEquals(expected, actual1);
            assertArrayEquals(expected, actual2);
        });
    }
}