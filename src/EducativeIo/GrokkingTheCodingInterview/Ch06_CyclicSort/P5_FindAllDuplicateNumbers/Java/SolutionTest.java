package EducativeIo.GrokkingTheCodingInterview.Ch06_CyclicSort.P5_FindAllDuplicateNumbers.Java;

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
        int[] nums = new int[] {3, 4, 4, 5, 5};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(5, 4);
            List<Integer> actual = Solution.findNumbers(nums);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {5, 4, 7, 2, 3, 5, 3};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(3, 5);
            List<Integer> actual = Solution.findNumbers(nums);
            assertEquals(expected, actual);
        });
    }
}
