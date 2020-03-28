package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.MathsAndHashing.PointsOnTheStraightLine.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(1, 2));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.maxPoints(a, b);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(0, 1, -1));
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(0, 1, -1));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 3;
            int actual = Solution.maxPoints(a, b);
            assertEquals(expected, actual);
        });
    }
}