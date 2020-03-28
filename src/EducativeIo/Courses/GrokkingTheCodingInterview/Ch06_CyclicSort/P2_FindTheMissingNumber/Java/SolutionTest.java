package EducativeIo.Courses.GrokkingTheCodingInterview.Ch06_CyclicSort.P2_FindTheMissingNumber.Java;

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
        int[] nums = new int[] {4, 0, 3, 1};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.findMissingNumber(nums);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {8, 3, 5, 2, 4, 6, 0, 1};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 7;
            int actual = Solution.findMissingNumber(nums);
            assertEquals(expected, actual);
        });
    }
}
