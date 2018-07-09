package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.DynamicProgramming.BestTimeToBuyAndSellStock.Java;

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
            int expected = 5;
            int actual = Solution.maxProfit(prices);
            assertEquals(expected, actual);
            int actual_Kadane = Solution.maxProfit_Kadane(prices);
            assertEquals(expected, actual_Kadane);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] prices = {7,6,4,3,1};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.maxProfit(prices);
            assertEquals(expected, actual);
            int actual_Kadane = Solution.maxProfit_Kadane(prices);
            assertEquals(expected, actual_Kadane);
        });
    }
}