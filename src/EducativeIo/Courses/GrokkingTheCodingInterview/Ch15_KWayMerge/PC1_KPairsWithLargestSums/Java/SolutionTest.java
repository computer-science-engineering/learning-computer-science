package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_KWayMerge.PC1_KPairsWithLargestSums.Java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int[] nums1 = new int[] {9, 8, 2};
        int[] nums2 = new int[] {6, 3, 1};
        int k = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            List<int[]> expected =
                    Arrays.asList(new int[] {9, 3}, new int[] {9, 6}, new int[] {8, 6});
            List<int[]> actual = Solution.findKLargestPairs(nums1, nums2, k);
            assertArrayEquals(expected.get(0), actual.get(0));
            assertArrayEquals(expected.get(1), actual.get(1));
            assertArrayEquals(expected.get(2), actual.get(2));
        });
    }
}
