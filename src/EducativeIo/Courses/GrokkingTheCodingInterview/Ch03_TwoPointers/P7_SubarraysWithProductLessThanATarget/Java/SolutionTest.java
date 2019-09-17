package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.P7_SubarraysWithProductLessThanATarget.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] arr = new int[] {2, 5, 3, 10};
        int target = 30;
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(2), Arrays.asList(5),
                    Arrays.asList(2, 5), Arrays.asList(3), Arrays.asList(5, 3), Arrays.asList(10));
            List<List<Integer>> actual = Solution.findSubarrays(arr, target);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {8, 2, 6, 5};
        int target = 50;
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(8), Arrays.asList(2),
                    Arrays.asList(8, 2), Arrays.asList(6), Arrays.asList(2, 6), Arrays.asList(5),
                    Arrays.asList(6, 5));
            List<List<Integer>> actual = Solution.findSubarrays(arr, target);
            assertEquals(expected, actual);
        });
    }
}
