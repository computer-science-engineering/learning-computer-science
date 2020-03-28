package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.PC3_CountOfStructurallyUniqueBinarySearchTrees.Java;

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
        int n = 2;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.countTrees(n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int n = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 5;
            int actual = Solution.countTrees(n);
            assertEquals(expected, actual);
        });
    }
}
