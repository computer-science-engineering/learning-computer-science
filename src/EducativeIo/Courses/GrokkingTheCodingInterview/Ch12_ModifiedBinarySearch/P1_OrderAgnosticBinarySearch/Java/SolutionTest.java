package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P1_OrderAgnosticBinarySearch.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] arr = new int[] {4, 6, 10};
        int key = 10;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int key = 5;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 4;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {10, 6, 4};
        int key = 10;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 0;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int[] arr = new int[] {10, 6, 4};
        int key = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.search(arr, key);
            assertEquals(expected, actual);
        });
    }
}
