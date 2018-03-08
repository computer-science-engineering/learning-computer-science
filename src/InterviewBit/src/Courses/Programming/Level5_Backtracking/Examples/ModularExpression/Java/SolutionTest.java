package InterviewBit.src.Courses.Programming.Level5_Backtracking.Examples.ModularExpression.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.Mod(2, 3, 3);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 19;
            int actual = Solution.Mod(-1, 1, 20);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 20805472;
            int actual = Solution.Mod(71045970, 41535484, 64735492);
            assertEquals(expected, actual);
        });
    }
}