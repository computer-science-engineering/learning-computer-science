package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.Arrangement.RotateMatrix.Java;

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
    public void Test1() {
        int[][] input = {{1, 2}, {3, 4}};
        assertTimeout(Duration.ofMillis(200), () -> {
            // This method should run in less than specified timeout
            int[][] actual = Solution.rotate(input);            
            int[][] expected = {{3, 1}, {4, 2}};
            assertArrayEquals(expected, actual);
        });
    }
}