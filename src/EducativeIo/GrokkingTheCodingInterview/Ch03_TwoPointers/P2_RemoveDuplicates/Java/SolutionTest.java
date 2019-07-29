package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.P2_RemoveDuplicates.Java;

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
        int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.remove(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {2, 2, 2, 11};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.remove(arr);
            assertEquals(expected, actual);
        });
    }
}
