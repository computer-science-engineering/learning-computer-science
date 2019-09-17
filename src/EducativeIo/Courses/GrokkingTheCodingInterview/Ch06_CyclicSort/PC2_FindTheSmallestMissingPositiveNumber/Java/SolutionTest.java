package EducativeIo.Courses.GrokkingTheCodingInterview.Ch06_CyclicSort.PC2_FindTheSmallestMissingPositiveNumber.Java;

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
    public void TrivialCase1() {
        int[] nums = new int[] {-3, 1, 5, 4, 2};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.findNumber(nums);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {3, -2, 0, 1, 2};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.findNumber(nums);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] nums = new int[] {3, 2, 5, 1};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.findNumber(nums);
            assertEquals(expected, actual);
        });
    }
}
