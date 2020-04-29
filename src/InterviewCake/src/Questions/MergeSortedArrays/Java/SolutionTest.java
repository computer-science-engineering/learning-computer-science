package InterviewCake.src.Questions.MergeSortedArrays.Java;

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
        int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = new int[]{1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19};
            int[] actual = Solution.mergeSortedArrays(myArray, alicesArray);
            assertArrayEquals(expected, actual);
        });
    }
}