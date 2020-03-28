package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P2_KthSmallestNumber.Java;

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
        int[] nums = new int[] {1, 5, 12, 2, 11, 5};
        int k = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 5;
            int actual = Solution.findKthSmallestNumber(nums, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {1, 5, 12, 2, 11, 5};
        int k = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 5;
            int actual = Solution.findKthSmallestNumber(nums, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] nums = new int[] {5, 12, 11, -1, 12};
        int k = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 11;
            int actual = Solution.findKthSmallestNumber(nums, k);
            assertEquals(expected, actual);
        });
    }
}
