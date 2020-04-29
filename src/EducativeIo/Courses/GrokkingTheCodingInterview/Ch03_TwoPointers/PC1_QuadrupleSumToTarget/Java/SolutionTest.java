package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.PC1_QuadrupleSumToTarget.Java;

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
        int[] arr = new int[] {4, 1, 2, -1, 1, -3};
        int target = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(-3, -1, 1, 4), Arrays.asList(-3, 1, 1, 2));
            List<List<Integer>> actual = Solution.searchQuadruplets(arr, target);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {2, 0, -1, 1, -2, 2};
        int target = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(-2, 0, 2, 2), Arrays.asList(-1, 0, 1, 2));
            List<List<Integer>> actual = Solution.searchQuadruplets(arr, target);
            assertEquals(expected, actual);
        });
    }
}
