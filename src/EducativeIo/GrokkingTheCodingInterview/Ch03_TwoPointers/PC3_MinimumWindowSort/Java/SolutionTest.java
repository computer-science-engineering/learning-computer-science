package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.PC3_MinimumWindowSort.Java;

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
        int[] arr = new int[] {1, 2, 5, 3, 7, 10, 9, 12};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 5;
            int actual = Solution.sort(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {1, 3, 2, 0, -1, 7, 10};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 5;
            int actual = Solution.sort(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {1, 2, 3};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.sort(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int[] arr = new int[] {3, 2, 1};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.sort(arr);
            assertEquals(expected, actual);
        });
    }
}
