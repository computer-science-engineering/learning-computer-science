package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P8_KClosestNumbers.Java;

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
        int[] arr = new int[] {5, 6, 7, 8, 9};
        int K = 3;
        int X = 7;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(6, 7, 8);
            List<Integer> actual = Solution.findClosestElements(arr, K, X);
            assertEquals(expected, actual);
            List<Integer> actual_twoPointers = Solution.findClosestElements_twoPointers(arr, K, X);
            assertEquals(expected, actual_twoPointers);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {2, 4, 5, 6, 9};
        int K = 3;
        int X = 6;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(4, 5, 6);
            List<Integer> actual = Solution.findClosestElements(arr, K, X);
            assertEquals(expected, actual);
            List<Integer> actual_twoPointers = Solution.findClosestElements_twoPointers(arr, K, X);
            assertEquals(expected, actual_twoPointers);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {2, 4, 5, 6, 9};
        int K = 3;
        int X = 10;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(5, 6, 9);
            List<Integer> actual = Solution.findClosestElements(arr, K, X);
            assertEquals(expected, actual);
            List<Integer> actual_twoPointers = Solution.findClosestElements_twoPointers(arr, K, X);
            assertEquals(expected, actual_twoPointers);
        });
    }
}
