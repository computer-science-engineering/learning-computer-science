package EducativeIo.Courses.GrokkingTheCodingInterview.Ch06_CyclicSort.P4_FindTheDuplicateNumber.Java;

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
        int[] nums = new int[] {1, 4, 4, 3, 2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual1 = Solution.findNumber(nums);
            int actual2 = Solution.findDuplicate(nums);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {2, 1, 3, 3, 5, 4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual1 = Solution.findNumber(nums);
            int actual2 = Solution.findDuplicate(nums);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] nums = new int[] {2, 4, 1, 4, 4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual1 = Solution.findNumber(nums);
            int actual2 = Solution.findDuplicate(nums);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }
}
