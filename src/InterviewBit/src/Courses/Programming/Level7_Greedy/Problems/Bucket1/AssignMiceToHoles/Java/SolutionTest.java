package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket1.AssignMiceToHoles.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, -4, 2));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, 0, 5));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 4;
            int actual = Solution.mice(A, B);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-10, -79, -79, 67, 93, -85, -28, -94));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-2, 9, 69, 25, -31, 23, 50, 78));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 102;
            int actual = Solution.mice(A, B);
            assertEquals(expected, actual);
        });
    }
}