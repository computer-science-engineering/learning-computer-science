package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q2_CheckPermutation.Java;

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
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        assertTimeout(Duration.ofMillis(700), () -> {
            Boolean[] expected = {true, true, false};
            Boolean[] actual1 = new Boolean[3];
            Boolean[] actual2 = new Boolean[3];
            int i=0;
            for (String[] pair : pairs) {
                actual1[i] = Solution.permutation_solution1(pair[0], pair[1]);
                actual2[i] = Solution.permutation_solution2(pair[0], pair[1]);
                i++;
            }
            assertArrayEquals(expected, actual1);
            assertArrayEquals(expected, actual2);
        });
    }
}