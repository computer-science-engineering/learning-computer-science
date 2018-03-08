package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.HashSearch.TwoSum.Java;

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
        int[] input = {2, 7, 11, 15};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1, 2};
            int[] actual1 = Solution.twoSum(input, 9);
            assertArrayEquals(expected, actual1);
            int[] actual2 = Solution.twoSumEditorial(input, 9);
            assertArrayEquals(expected, actual2);
        });
    }

    @Test
    public void SpecialCase1() {
        int[] input = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {4, 8};
            int[] actual1 = Solution.twoSum(input, -3);
            assertArrayEquals(expected, actual1);
            int[] actual2 = Solution.twoSumEditorial(input, -3);
            assertArrayEquals(expected, actual2);
        });
    }
}