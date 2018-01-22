package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.SimulationArray.SpiralOrderMatrix2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SolutionTest {

    /** Test method for {@link InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.SimulationArray.SpiralOrderMatrix2.Solution } */
    Solution solution;

    @Rule
    public Timeout globalTimeout = Timeout.millis(200);

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void Test1() {
        int n = 3;
        int[][] actual = Solution.generateMatrix(n);
        int[][] expected = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertArrayEquals(expected, actual);
    }
}