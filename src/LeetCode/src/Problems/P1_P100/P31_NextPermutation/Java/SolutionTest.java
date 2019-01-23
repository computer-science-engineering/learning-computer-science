package LeetCode.src.Problems.P1_P100.P31_NextPermutation.Java;

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
        int[] nums = {1,2,3};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1,3,2};
            Solution.nextPermutation(nums);
            int[] actual = nums;
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = {3,2,1};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1,2,3};
            Solution.nextPermutation(nums);
            int[] actual = nums;
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] nums = {1,1,5};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1,5,1};
            Solution.nextPermutation(nums);
            int[] actual = nums;
            assertArrayEquals(expected, actual);
        });
    }
}