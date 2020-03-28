package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.ShortestPath.WordLadder2.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String start = "hit";
        String end = "cog";
        ArrayList<String> dict = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"));
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
            expected.add(new ArrayList<String>(Arrays.asList("hit", "hot", "dot", "dog", "cog")));
            expected.add(new ArrayList<String>(Arrays.asList("hit", "hot", "lot", "log", "cog")));
            ArrayList<ArrayList<String>> actual = Solution.findLadders(start, end, dict);
            assertEquals(expected, actual);
        });
    }
}