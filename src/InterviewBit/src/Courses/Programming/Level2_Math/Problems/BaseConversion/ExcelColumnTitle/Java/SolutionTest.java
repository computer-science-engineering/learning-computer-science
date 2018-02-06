package InterviewBit.src.Courses.Programming.Level2_Math.Problems.BaseConversion.ExcelColumnTitle.Java;

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
    public void TrivialCase1() {
        int input = 10;
        assertTimeout(Duration.ofMillis(500), () -> {
            String actual = Solution.convertToTitle(input);
            String expected = "J";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int input = 260;
        assertTimeout(Duration.ofMillis(500), () -> {
            String actual = Solution.convertToTitle(input);
            String expected = "IZ";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int input = 943566;
        assertTimeout(Duration.ofMillis(500), () -> {
            String actual = Solution.convertToTitle(input);
            String expected = "BAQTZ";
            assertEquals(expected, actual);
        });
    }
}