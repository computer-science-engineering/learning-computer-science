package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P9_MaximumDistinctEKements.Java;

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
        int[] nums = new int[] {7, 3, 5, 8, 5, 3, 3};
        int k = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.findMaximumDistinctElements(nums, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {3, 5, 12, 11, 12};
        int k = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.findMaximumDistinctElements(nums, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] nums = new int[] {1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5};
        int k = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.findMaximumDistinctElements(nums, k);
            assertEquals(expected, actual);
        });
    }
}
