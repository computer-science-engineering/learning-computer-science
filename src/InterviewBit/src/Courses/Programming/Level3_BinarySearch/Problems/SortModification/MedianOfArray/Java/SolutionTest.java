package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Problems.SortModification.MedianOfArray.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
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
    public void TrivialCase1() {
        List<Integer> a = Arrays.asList(1, 4, 5);
        List<Integer> b = Arrays.asList(2, 3);
        assertTimeout(Duration.ofMillis(200), () -> {
            double expected = 3.0;
            double actual = Solution.findMedianSortedArrays(a, b);
            assertEquals(expected, actual);
        });
    }
}