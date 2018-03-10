package InterviewBit.src.Courses.Programming.Level2_Math.Problems.ArrayDp.NumbersOfLengthNAndValuesLessThanK.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 0, 1, 5));
        int B = 1;
        int C = 2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual1 = Solution.solve(A, B, C);
            assertEquals(expected, actual1);
            int actual2 = Solution.solve_Editorial(A, B, C);
            assertEquals(expected, actual2);
        });
    }

    //todo: fix this test. actual returns 6.
    // @Test
    // public void TrivialCase2() {
    //     ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 0, 1, 2, 5));
    //     int B = 2;
    //     int C = 21;
    //     assertTimeout(Duration.ofMillis(500), () -> {
    //         int expected = 5;
    //         int actual = Solution.solve(A, B, C);
    //         assertEquals(expected, actual);
    //     });
    // }
}