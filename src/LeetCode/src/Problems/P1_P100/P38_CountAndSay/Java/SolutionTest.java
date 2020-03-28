package LeetCode.src.Problems.P1_P100.P38_CountAndSay.Java;

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
        int input = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "1211";
            String actual = Solution.countAndSay(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int input = -1;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = null;
            String actual = Solution.countAndSay(input);
            assertEquals(expected, actual);
        });
    }
}