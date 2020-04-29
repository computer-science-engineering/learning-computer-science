package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.P6_TripletsWithSmallerSum._Variants.P1_ReturnTripletsWithSmallerSum.Java;

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
        int[] arr = new int[] {-1, 0, 2, 3};
        int target = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(-1, 0, 3), Arrays.asList(-1, 0, 2));
            List<List<Integer>> actual = Solution.searchTriplets(arr, target);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {-1, 4, 2, 1, 3};
        int target = 5;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(-1, 1, 4), Arrays.asList(-1, 1, 3), Arrays.asList(-1, 1, 2), Arrays.asList(-1, 2, 3));
            List<List<Integer>> actual = Solution.searchTriplets(arr, target);
            assertEquals(expected, actual);
        });
    }
}
