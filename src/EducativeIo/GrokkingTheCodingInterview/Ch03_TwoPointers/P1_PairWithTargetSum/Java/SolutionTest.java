package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.P1_PairWithTargetSum.Java;

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
        int[] arr = new int[] {1, 2, 3, 4, 6};
        int targetSum = 6;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {1, 3};
            int[] actual_TwoPointers = Solution.search_TwoPointers(arr, targetSum);
            int[] actual_TwoPointers_IntOverflowFix =
                    Solution.search_TwoPointers_IntOverflowFix(arr, targetSum);
            int[] actual_HashMap = Solution.search_HashMap(arr, targetSum);
            assertArrayEquals(expected, actual_TwoPointers);
            assertArrayEquals(expected, actual_TwoPointers_IntOverflowFix);
            assertArrayEquals(expected, actual_HashMap);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {2, 5, 9, 11};
        int targetSum = 11;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {0, 2};
            int[] actual_TwoPointers = Solution.search_TwoPointers(arr, targetSum);
            int[] actual_TwoPointers_IntOverflowFix =
                    Solution.search_TwoPointers_IntOverflowFix(arr, targetSum);
            int[] actual_HashMap = Solution.search_HashMap(arr, targetSum);
            assertArrayEquals(expected, actual_TwoPointers);
            assertArrayEquals(expected, actual_TwoPointers_IntOverflowFix);
            assertArrayEquals(expected, actual_HashMap);
        });
    }
}
