package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.ArrayMath.MinStepsInInfiniteGrid.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;

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
        ArrayList<Integer> X = new ArrayList<Integer>();
        X.add(7);
        X.add(2);
        X.add(4);
        X.add(1);
        ArrayList<Integer> Y = new ArrayList<Integer>();
        Y.add(1);
        Y.add(5);
        Y.add(3);
        Y.add(8);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 12;
            int actual = Solution.coverPoints(X, Y);
            assertEquals(expected, actual);
        });
    }
}