package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.SuffixPrefixDp.BestTimeToBuyAndSellStocks1.Java;

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
        int[] A = {1, 2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.maxProfit(A);
            assertEquals(expected, actual);
            int actual_Kadane = Solution.maxProfit_Kadane(A);
            assertEquals(expected, actual_Kadane);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] A = {7, 1, 5, 3, 6, 4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 5;
            int actual = Solution.maxProfit(A);
            assertEquals(expected, actual);
            int actual_Kadane = Solution.maxProfit_Kadane(A);
            assertEquals(expected, actual_Kadane);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] A = {7, 6, 4, 3, 1};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.maxProfit(A);
            assertEquals(expected, actual);
            int actual_Kadane = Solution.maxProfit_Kadane(A);
            assertEquals(expected, actual_Kadane);
        });
    }
}