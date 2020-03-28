package LeetCode.src.Problems.P201_P300.P283_MoveZeroes.Java;

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
        int[] nums = {0,1,0,3,12};          
        int[] nums2 = {0,1,0,3,12};
        assertTimeout(Duration.ofMillis(700), () -> {
            int[] expected = {1, 3, 12, 0, 0};
            Solution.moveZeroes(nums);
            int[] actual = nums;
            assertArrayEquals(expected, actual);  
            Solution.moveZeroes2(nums2);
            int[] actual2 = nums2;
            assertArrayEquals(expected, actual2);  
        });
    }
}