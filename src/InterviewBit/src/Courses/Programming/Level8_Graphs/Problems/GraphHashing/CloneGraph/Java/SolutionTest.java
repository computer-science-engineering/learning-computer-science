package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphHashing.CloneGraph.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(2);
        UndirectedGraphNode c = new UndirectedGraphNode(3);
        a.neighbors.add(b);
        a.neighbors.add(c);
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
            UndirectedGraphNode clone = Solution.cloneGraph(a);
            ArrayList<Integer> actual = Solution.dfs(clone);
            assertEquals(expected, actual);
        });
    }
}