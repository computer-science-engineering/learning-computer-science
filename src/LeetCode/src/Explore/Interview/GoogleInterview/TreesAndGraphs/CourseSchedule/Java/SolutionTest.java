package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.CourseSchedule.Java;

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
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual_bfs = Solution.canFinish_bfs(numCourses, prerequisites);
            boolean actual_dfs = Solution.canFinish_dfs(numCourses, prerequisites);
            assertEquals(expected, actual_bfs);
            assertEquals(expected, actual_dfs);
        });
    }

    @Test
    public void TrivialCase2() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual_bfs = Solution.canFinish_bfs(numCourses, prerequisites);
            boolean actual_dfs = Solution.canFinish_dfs(numCourses, prerequisites);
            assertEquals(expected, actual_bfs);
            assertEquals(expected, actual_dfs);
        });
    }
}