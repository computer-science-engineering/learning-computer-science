package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.HashingTwoPointer.WindowString.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "BANC";
            String actual1 = Solution.minWindow("ADOBECODEBANC", "ABC");
            assertEquals(expected, actual1);
            String actual2 = Solution.minWindow2("ADOBECODEBANC", "ABC");
            assertEquals(expected, actual2);
        });
    }
}