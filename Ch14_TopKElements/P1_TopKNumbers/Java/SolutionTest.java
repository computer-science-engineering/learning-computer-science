package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P1_TopKNumbers.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
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
        int[] nums = new int[] {3, 1, 5, 12, 2, 11};
        int k = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(5, 12, 11);
            List<Integer> actual = Solution.findKLargestNumbers(nums, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {5, 12, 11, -1, 12};
        int k = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(11, 12, 12);
            List<Integer> actual = Solution.findKLargestNumbers(nums, k);
            assertEquals(expected, actual);
        });
    }
}
