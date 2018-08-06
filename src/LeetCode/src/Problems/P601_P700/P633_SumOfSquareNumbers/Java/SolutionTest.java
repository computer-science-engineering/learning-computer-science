package LeetCode.src.Problems.P601_P700.P633_SumOfSquareNumbers.Java;

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
        int c = 5;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.judgeSquareSum(c);
            assertEquals(expected, actual);
            boolean actual_opt = Solution.judgeSquareSum_opt(c);
            assertEquals(expected, actual_opt);
        });
    }

    @Test
    public void TrivialCase2() {
        int c = 3;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.judgeSquareSum(c);
            assertEquals(expected, actual);
            boolean actual_opt = Solution.judgeSquareSum_opt(c);
            assertEquals(expected, actual_opt);
        });
    }
}