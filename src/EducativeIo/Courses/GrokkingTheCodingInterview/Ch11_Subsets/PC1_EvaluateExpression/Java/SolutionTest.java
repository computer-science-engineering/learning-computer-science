package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.PC1_EvaluateExpression.Java;

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
        String input = "1+2*3";
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(7, 9);
            List<Integer> actual = Solution.diffWaysToEvaluateExpression(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "2*3-4-5";
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(8, -12, 7, -7, -3);
            List<Integer> actual = Solution.diffWaysToEvaluateExpression(input);
            assertEquals(expected, actual);
        });
    }
}
