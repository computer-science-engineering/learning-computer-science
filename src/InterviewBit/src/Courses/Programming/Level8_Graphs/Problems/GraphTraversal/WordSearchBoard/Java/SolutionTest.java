package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphTraversal.WordSearchBoard.Java;

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
        String[] A = {"ABCE", "SFCS", "ADEE"};
        String B = "ABCCED";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.exist(A, B);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String[] A = {"ABCE", "SFCS", "ADEE"};
        String B = "ABCD";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.exist(A, B);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String[] A = {"FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF"};
        String B = "BCDCB";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.exist(A, B);
            assertEquals(expected, actual);
        });
    }
}