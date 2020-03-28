package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.PrunedBuilder.GenerateAllParentheses2.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.*;
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
        int input = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<String> expected = new ArrayList<String>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
            ArrayList<String> actual = Solution.generateParenthesis(input);
            assertEquals(expected, actual);
        });
    }
}