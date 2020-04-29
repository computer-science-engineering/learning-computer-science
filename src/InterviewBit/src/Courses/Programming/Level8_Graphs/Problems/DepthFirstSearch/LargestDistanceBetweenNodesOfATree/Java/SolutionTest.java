package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.DepthFirstSearch.LargestDistanceBetweenNodesOfATree.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 0, 0, 0, 3));
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.solve(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 0, 0, 1, 2, 1, 5));
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 5;
            int actual = Solution.solve(A);
            assertEquals(expected, actual);
        });
    }
}