package ByteByByte.src.CodingInterviewQuestions.Array.P2_01Knapsack.Java;

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
        int val[] = {60, 100, 120}; 
        int wt[] = {10, 20, 30}; 
        int  W = 50; 
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 220;
            int actual = Solution.knapsack01(val, wt, W);
            assertEquals(expected, actual);
        });
    }
}