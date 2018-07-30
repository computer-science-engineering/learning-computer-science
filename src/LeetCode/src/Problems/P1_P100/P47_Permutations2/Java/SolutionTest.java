package LeetCode.src.Problems.P1_P100.P47_Permutations2.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] nums = {1,1,2};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,1,2),
                Arrays.asList(1,2,1),
                Arrays.asList(2,1,1)
            );
            List<List<Integer>> actual = Solution.permuteUnique(nums);
            assertEquals(expected, actual);
        });
    }
}