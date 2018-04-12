package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.ShortestPath.WordLadder1.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

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
        String start = "hit";
        String end = "cog";
        ArrayList<String> dictV = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"));
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 5;
            int actual = Solution.ladderLength(start, end, dictV);
            assertEquals(expected, actual);
        });
    }
}