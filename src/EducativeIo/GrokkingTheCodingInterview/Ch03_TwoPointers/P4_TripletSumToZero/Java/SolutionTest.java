package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.P4_TripletSumToZero.Java;

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
        int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(-3, 1, 2),
                    Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1), Arrays.asList(-1, 0, 1));
            List<List<Integer>> actual = Solution.searchTriplets(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {-5, 2, -1, -2, 3};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(-5, 2, 3), Arrays.asList(-2, -1, 3));
            List<List<Integer>> actual = Solution.searchTriplets(arr);
            assertEquals(expected, actual);
        });
    }
}
