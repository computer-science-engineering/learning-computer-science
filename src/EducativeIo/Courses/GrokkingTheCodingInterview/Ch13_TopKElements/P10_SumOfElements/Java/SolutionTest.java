package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P10_SumOfElements.Java;

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
        int[] nums = new int[] {1, 3, 12, 5, 15, 11};
        int k1 = 3;
        int k2 = 6;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 23;
            int actual1 = Solution.findSumOfElements(nums, k1, k2);
            assertEquals(expected, actual1);
            int actual2 = Solution.findSumOfElements2(nums, k1, k2);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {3, 5, 8, 7};
        int k1 = 1;
        int k2 = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 12;
            int actual1 = Solution.findSumOfElements(nums, k1, k2);
            assertEquals(expected, actual1);
            int actual2 = Solution.findSumOfElements2(nums, k1, k2);
            assertEquals(expected, actual2);
        });
    }
}
