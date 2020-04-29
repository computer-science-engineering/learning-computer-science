package EducativeIo.Courses.GrokkingTheCodingInterview.Ch16_01Knapsack_DynamicProgramming.P2_EqualSubsetSumPartition.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest2TopDownDpWithMemoization {

    Solution2TopDownDpWithMemoization solution;

    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution2TopDownDpWithMemoization();
    }

    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution2TopDownDpWithMemoization.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] num = {1, 2, 3, 4};
        Solution2TopDownDpWithMemoization ps = new Solution2TopDownDpWithMemoization();
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual = ps.canPartition(num);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] num = {1, 1, 3, 4, 7};
        Solution2TopDownDpWithMemoization ps = new Solution2TopDownDpWithMemoization();
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual = ps.canPartition(num);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] num = {2, 3, 4, 6};
        Solution2TopDownDpWithMemoization ps = new Solution2TopDownDpWithMemoization();
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual = ps.canPartition(num);
            assertEquals(expected, actual);
        });
    }
}
