package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P2_SubsetsWithDuplicates.Java;

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
        int[] nums = new int[] {1, 3, 3};
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(), Arrays.asList(1), Arrays.asList(3),
                            Arrays.asList(1, 3), Arrays.asList(3, 3), Arrays.asList(1, 3, 3));
            List<List<Integer>> actual = Solution.findSubsets(nums);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = new int[] {1, 5, 3, 3};
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(), Arrays.asList(1),
                    Arrays.asList(3), Arrays.asList(1, 3), Arrays.asList(3, 3),
                    Arrays.asList(1, 3, 3), Arrays.asList(5), Arrays.asList(1, 5),
                    Arrays.asList(3, 5), Arrays.asList(1, 3, 5), Arrays.asList(3, 3, 5),
                    Arrays.asList(1, 3, 3, 5));
            List<List<Integer>> actual = Solution.findSubsets(nums);
            assertEquals(expected, actual);
        });
    }
}
