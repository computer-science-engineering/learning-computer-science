package LeetCode.src.Problems.P101_P200.P149_MaxPointsOnALine.Java;

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
        Point[] points = {
            new Point(1,1),
            new Point(3,2),
            new Point(5,3),
            new Point(4,1),
            new Point(2,3),
            new Point(1,4)
        };
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 4;
            int actual = Solution.maxPoints(points);
            assertEquals(expected, actual);
        });
    }
}