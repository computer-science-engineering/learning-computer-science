package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TreeConstruction.SortedArrayToBalancedBst.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.sortedArrayToBST(a).val;
            assertEquals(expected, actual);
        });
    }
}