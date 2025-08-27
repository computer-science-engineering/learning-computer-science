package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P7_BitonicArrayMaximum.Java;

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
        int[] arr = new int[] {1, 3, 8, 12, 4, 2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 12;
            int actual = Solution.findMax(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {3, 8, 3, 1};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 8;
            int actual = Solution.findMax(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {1, 3, 8, 12};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 12;
            int actual = Solution.findMax(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int[] arr = new int[] {10, 9, 8};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 10;
            int actual = Solution.findMax(arr);
            assertEquals(expected, actual);
        });
    }
}
