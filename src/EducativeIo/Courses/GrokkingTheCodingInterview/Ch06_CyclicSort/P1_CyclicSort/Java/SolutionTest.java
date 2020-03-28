package EducativeIo.Courses.GrokkingTheCodingInterview.Ch06_CyclicSort.P1_CyclicSort.Java;

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
        int[] nums = new int[] {3, 1, 5, 4, 2};
        assertTimeout(Duration.ofMillis(700), () -> {
            int[] expected = new int[] {1, 2, 3, 4, 5};
            Solution.sort(nums);;
            assertArrayEquals(expected, nums);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {2, 6, 4, 3, 1, 5};
        assertTimeout(Duration.ofMillis(700), () -> {
            int[] expected = new int[] {1, 2, 3, 4, 5, 6};
            Solution.sort(nums);;
            assertArrayEquals(expected, nums);
        });
    }
}
