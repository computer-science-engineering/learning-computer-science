package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.PrettyPrint.JustifiedText.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] expected = {"This    is    an",  "example  of text", "justification.  "};
            String[] actual = Solution.fullJustify(input, 16);;
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String[] input = {"What", "must", "be", "shall", "be."};
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] expected = {"What must be", "shall be.   "};
            String[] actual = Solution.fullJustify(input, 12);;
            assertArrayEquals(expected, actual);
        });
    }
}