package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.P5_TripleSumCloseToTarget.Java;

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
        int[] arr = new int[] {-2, 0, 1, 2};
        int targetSum = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.searchTriplet(arr, targetSum);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {-3, -1, 1, 2};
        int targetSum = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.searchTriplet(arr, targetSum);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {1, 0, 1, 1};
        int targetSum = 100;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.searchTriplet(arr, targetSum);
            assertEquals(expected, actual);
        });
    }
}
