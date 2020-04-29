package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.ContainsDuplicate.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] nums = {1,2,3,1};
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual = Solution.containsDuplicate(nums);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = {1,2,3,4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual = Solution.containsDuplicate(nums);
            assertEquals(expected, actual);
        });
    }
}