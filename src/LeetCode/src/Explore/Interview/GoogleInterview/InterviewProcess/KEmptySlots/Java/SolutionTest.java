package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.KEmptySlots.Java;

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
        int[] flowers = {1,3,2};
        int k = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.kEmptySlots(flowers, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] flowers = {1,2,3};
        int k = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = -1;
            int actual = Solution.kEmptySlots(flowers, k);
            assertEquals(expected, actual);
        });
    }
}