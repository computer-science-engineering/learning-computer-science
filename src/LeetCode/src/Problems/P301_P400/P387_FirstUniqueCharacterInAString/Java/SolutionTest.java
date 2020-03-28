package LeetCode.src.Problems.P301_P400.P387_FirstUniqueCharacterInAString.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String s = "loveleetcode";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual1 = Solution.firstUniqChar(s);
            assertEquals(expected, actual1);
            int actual2 = Solution.firstUniqChar_optimized(s);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = "dogdog";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = -1;
            int actual = Solution.firstUniqChar(s);
            assertEquals(expected, actual);
            int actual2 = Solution.firstUniqChar(s);
            assertEquals(expected, actual2);
        });
    }
}