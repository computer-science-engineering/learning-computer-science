package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.RedundantConnection2.Java;

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
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {2, 3};
            int[] actual_1 = Solution.findRedundantDirectedConnection(edges);
            int[] actual_2 = Solution.findRedundantDirectedConnection_2(edges);
            assertArrayEquals(expected, actual_1);
            assertArrayEquals(expected, actual_2);
        });
    }

    @Test
    public void TrivialCase2() {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {4, 1};
            int[] actual_1 = Solution.findRedundantDirectedConnection(edges);
            int[] actual_2 = Solution.findRedundantDirectedConnection_2(edges);
            assertArrayEquals(expected, actual_1);
            assertArrayEquals(expected, actual_2);
        });
    }
}