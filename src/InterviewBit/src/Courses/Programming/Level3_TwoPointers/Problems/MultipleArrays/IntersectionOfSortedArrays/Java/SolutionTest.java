package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.MultipleArrays.IntersectionOfSortedArrays.Java;

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
        int[] A = {1, 2, 3, 3, 4, 5, 6};
        int[] B = {3, 3, 5};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {3, 3, 5};
            int[] actual = Solution.intersect(A, B);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] A = {1, 2, 3, 3, 4, 5, 6};
        int[] B = {3, 5};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {3, 5};
            int[] actual = Solution.intersect(A, B);
            assertArrayEquals(expected, actual);
        });
    }
}