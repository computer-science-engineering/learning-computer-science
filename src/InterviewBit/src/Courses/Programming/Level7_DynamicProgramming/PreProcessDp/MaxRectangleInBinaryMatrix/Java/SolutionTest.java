package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.PreProcessDp.MaxRectangleInBinaryMatrix.Java;

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
        int A[][] = { {0, 1, 1, 0},
                      {1, 1, 1, 1},
                      {1, 1, 1, 1},
                      {1, 1, 0, 0},
                    };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 8;
            int actual = Solution.maximalRectangle(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int A[][] = { {1, 1, 1},
                      {0, 1, 1},
                      {1, 0, 0},
                    };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual = Solution.maximalRectangle(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int A[][] = { {1}
                    };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.maximalRectangle(A);
            assertEquals(expected, actual);
        });
    }
}