package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.GreedyOrDp.MinJumpsArray.Java;

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
        int[] A = {2,3,1,1,4};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.jump(A);
            assertEquals(expected, actual);
            int actual_optimized = Solution.jump_optimized(A);
            assertEquals(expected, actual_optimized);
            int actual_Editorial = Solution.jump(A);
            assertEquals(expected, actual_Editorial);
        });
    }

    @Test
    public void SpecialCase1() {
        int[] A = {0};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 0;
            int actual = Solution.jump(A);
            assertEquals(expected, actual);
            int actual_optimized = Solution.jump_optimized(A);
            assertEquals(expected, actual_optimized);
            int actual_Editorial = Solution.jump(A);
            assertEquals(expected, actual_Editorial);
        });
    }

    @Test
    public void SpecialCase2() {
        int[] A = { 0, 46, 46, 0, 2, 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0, 49, 42, 13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35, 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0, 25, 12, 0, 38, 28, 37, 5, 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30, 26, 37, 0, 26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27, 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12, 3, 44, 44, 39, 2, 26, 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47, 49 };
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = -1;
            int actual = Solution.jump(A);
            assertEquals(expected, actual);
            int actual_optimized = Solution.jump_optimized(A);
            assertEquals(expected, actual_optimized);
            int actual_Editorial = Solution.jump(A);
            assertEquals(expected, actual_Editorial);
        });
    }
}