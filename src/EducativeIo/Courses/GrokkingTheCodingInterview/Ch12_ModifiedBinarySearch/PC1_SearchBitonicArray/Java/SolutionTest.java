package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.PC1_SearchBitonicArray.Java;

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
        int[] arr = new int[] {1, 3, 8, 4, 3};
        int key = 4;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {3, 8, 3, 1};
        int key = 8;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 1;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {1, 3, 8, 12};
        int key = 12;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int[] arr = new int[] {10, 9, 8};
        int key = 10;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }
}
