package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.InplaceUpdate.RemoveDuplicatesFromSortedArray.Java;

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
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.removeDuplicates(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5000, 5000, 5000));
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 1;
            int actual = Solution.removeDuplicates(input);
            assertEquals(expected, actual);
        });
    }
}