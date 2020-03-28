package InterviewBit.src.Courses.Programming.Level2_Math.Examples.BinaryRepresentation.Java;

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
        int input = 200;
        assertTimeout(Duration.ofMillis(700), () -> {
            String actual = Solution.findDigitsInBinary(input);
            String expected = "11001000";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int input = 0;
        assertTimeout(Duration.ofMillis(700), () -> {
            String actual = Solution.findDigitsInBinary(input);
            String expected = "0";
            assertEquals(expected, actual);
        });
    }
}