package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.MultiplyDp.UniqueBinarySearchTrees2.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int input = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 5;
            int actual_recursive = Solution.numTrees_recursive(input);
            assertEquals(expected, actual_recursive);
            int actual = Solution.numTrees(input);
            assertEquals(expected, actual);
            int actual_Editorial = Solution.numTrees_Editorial(input);
            assertEquals(expected, actual_Editorial);
        });
    }
}