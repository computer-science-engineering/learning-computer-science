package EducativeIo.GrokkingTheCodingInterview.Ch06_CyclicSort.PC1_FindTheCorruptPair.Java;

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
        int[] nums = new int[] {3, 1, 2, 5, 2};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {2, 4};
            int[] actual = Solution.findNumbers(nums);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {3, 1, 2, 3, 6, 4};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {3, 5};
            int[] actual = Solution.findNumbers(nums);
            assertArrayEquals(expected, actual);
        });
    }
}
