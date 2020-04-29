package InterviewBit.src.Courses.Programming.Level2_Math.Problems.DigitOp.ReverseInteger.Java;

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
        int input = 9876;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 6789;
            int actual = Solution.reverse(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int input = -1146467285;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.reverse(input);
            assertEquals(expected, actual);
        });
    }
}