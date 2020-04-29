package ByteByByte.src.CodingInterviewQuestions.Array.P1_MedianOfArrays.Java;

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
        int[] input1 = {1, 3, 8, 9, 15};
        int[] input2 = {7, 11, 19, 21, 18, 25};
        assertTimeout(Duration.ofMillis(1000), () -> {
            double expected = 11.0;
            double actual = Solution.findMedianSortedArrays(input1, input2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] input1 = {1, 3, 5};
        int[] input2 = {2, 4, 6};
        assertTimeout(Duration.ofMillis(1000), () -> {
            double expected = 3.5;
            double actual = Solution.findMedianSortedArrays(input1, input2);
            assertEquals(expected, actual);
        });
    }
}