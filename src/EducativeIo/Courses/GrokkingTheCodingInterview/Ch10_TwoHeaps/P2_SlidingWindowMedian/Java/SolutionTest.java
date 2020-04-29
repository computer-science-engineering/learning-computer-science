package EducativeIo.Courses.GrokkingTheCodingInterview.Ch10_TwoHeaps.P2_SlidingWindowMedian.Java;

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
        int[] nums = new int[] {1, 2, -1, 3, 5};
        int k = 2;
        Solution solution = new Solution();
        assertTimeout(Duration.ofMillis(1000), () -> {
            double[] expected = new double[] {1.5, 0.5, 1.0, 4.0};
            double[] actual = solution.findSlidingWindowMedian(nums, k);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {1, 2, -1, 3, 5};
        int k = 3;
        Solution solution = new Solution();
        assertTimeout(Duration.ofMillis(1000), () -> {
            double[] expected = new double[] {1.0, 2.0, 3.0};
            double[] actual = solution.findSlidingWindowMedian(nums, k);
            assertArrayEquals(expected, actual);
        });
    }
}
