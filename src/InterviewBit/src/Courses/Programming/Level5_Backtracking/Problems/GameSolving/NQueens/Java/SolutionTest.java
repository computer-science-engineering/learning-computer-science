package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.GameSolving.NQueens.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
            expected.add(new ArrayList<String>(Arrays.asList("..Q.", "Q...", "...Q", ".Q..")));
            expected.add(new ArrayList<String>(Arrays.asList(".Q..", "...Q", "Q...", "..Q.")));
            ArrayList<ArrayList<String>> actual = Solution.solveNQueens(4);
            assertEquals(expected, actual);
        });
    }
}