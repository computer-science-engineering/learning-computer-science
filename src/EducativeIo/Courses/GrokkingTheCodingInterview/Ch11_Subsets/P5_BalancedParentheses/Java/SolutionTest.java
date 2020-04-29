package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P5_BalancedParentheses.Java;

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
        int num = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<String> expected = Arrays.asList("(())", "()()");
            List<String> actual1 = Solution.generateValidParentheses(num);
            assertEquals(expected, actual1);
            List<String> actual2 = Solution.generateValidParentheses2(num);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        int num = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
            List<String> actual1 = Solution.generateValidParentheses(num);
            assertEquals(expected, actual1);
            List<String> actual2 = Solution.generateValidParentheses2(num);
            assertEquals(expected, actual2);
        });
    }
}
