package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.SimulationArray.MaxNonNegativeSubArray.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {

    /** Test method for {@link InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.SimulationArray.MaxNonNegativeSubArray.Solution } */
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
    public void Test1() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, -1, 1, 2));
        ArrayList<Integer> actual = Solution.maxSet(A);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(expected, actual);
    }

    @Test
    public void Test2() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, -1, 0));
        ArrayList<Integer> actual = Solution.maxSet(A);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void Test3() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1));
        ArrayList<Integer> actual = Solution.maxSet(A);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList());
        assertEquals(expected, actual);
    }

    @Test
    public void Test4() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        ArrayList<Integer> actual = Solution.maxSet(A);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1967513926, 1540383426));
        assertEquals(expected, actual);
    }

    @Test
    public void Test5() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671));
        ArrayList<Integer> actual = Solution.maxSet(A);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(41594, 16395, 19113, 71006));
        assertEquals(expected, actual);
    }
}