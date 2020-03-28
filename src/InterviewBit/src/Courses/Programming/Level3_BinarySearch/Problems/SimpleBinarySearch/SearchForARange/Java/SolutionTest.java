package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Problems.SimpleBinarySearch.SearchForARange.Java;

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
        List<Integer> input = Arrays.asList(5, 7, 7, 8, 8, 10);        
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 4));
            ArrayList<Integer> actual = Solution.searchRange(input, 8);
            assertEquals(expected, actual);
        });
    }
}