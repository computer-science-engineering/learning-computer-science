package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Examples.RotatedArray.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
        List<Integer> input = Arrays.asList(4, 5, 6, 7, 0, 1, 2);
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 0;
            int actual = Solution.findMin(input);
            assertEquals(expected, actual);
        });
    }
}