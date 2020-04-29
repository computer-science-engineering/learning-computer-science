package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.DpTricky.BestTimeToBuyAndSellStocks3.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        int[] A = {1, 2, 1, 2};
        List<Integer> a = Arrays.stream(A).boxed().collect(Collectors.toList());
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.maxProfit(A);
            assertEquals(expected, actual);
            int actual_Editorial = Solution.maxProfit_Editorial(a);
            assertEquals(expected, actual_Editorial);
        });
    }
}