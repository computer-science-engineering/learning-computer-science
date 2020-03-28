package LeetCode.src.Problems.P201_P300.P254_FactorCombinations.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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
        int n = 12;
        assertTimeout(Duration.ofMillis(700), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(2, 6),
                Arrays.asList(3, 4)
            );
            List<List<Integer>> actual = Solution.getFactors(n);
            assertEquals(expected, actual);
        });
    }
}