package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.Bucketing.NobleInteger.Java;

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
    public void Test1() {
        int[] input = {1, 2, 3, 4};
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method should run in less than specified timeout
            int actual = Solution.solve(input);            
            int expected = 1;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test2() {
        int[] input = {5, 6, 2};
        int actual = Solution.solve(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void Test3() {
        int[] input = {1, 2, 2, 3};
        int actual = Solution.solve(input);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void Test4() {
        int[] input = {-1};
        int actual = Solution.solve(input);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void Test5() {
        int[] input = {0, 1, 2};
        int actual = Solution.solve(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void Test6() {
        int[] input = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5};
        int actual = Solution.solve(input);
        int expected = -1;
        assertEquals(expected, actual);
    }
}