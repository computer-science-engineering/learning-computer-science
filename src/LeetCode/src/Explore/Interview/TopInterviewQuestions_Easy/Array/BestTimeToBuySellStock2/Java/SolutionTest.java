package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.BestTimeToBuySellStock2.Java;

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
        int[] prices = {7,1,5,3,6,4};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 7;
            int actual = Solution.maxProfit(prices);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] prices = {1,2,3,4,5};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.maxProfit(prices);
            assertEquals(expected, actual);
        });
    }
}