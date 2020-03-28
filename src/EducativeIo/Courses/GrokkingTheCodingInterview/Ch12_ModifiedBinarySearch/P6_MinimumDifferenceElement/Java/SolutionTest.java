package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P6_MinimumDifferenceElement.Java;

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
        int key = 7;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 6;
            int actual = Solution.searchMinDiffElement(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {4, 6, 10};
        int key = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 4;
            int actual = Solution.searchMinDiffElement(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {1, 3, 8, 10, 15};
        int key = 12;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 10;
            int actual = Solution.searchMinDiffElement(arr, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int[] arr = new int[] {4, 6, 10};
        int key = 17;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 10;
            int actual = Solution.searchMinDiffElement(arr, key);
            assertEquals(expected, actual);
        });
    }
}
