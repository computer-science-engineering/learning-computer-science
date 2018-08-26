package LeetCode.src.Problems.P201_P300.P211_AddAndSearchWord_DataStructureDesign.Java;

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
        Solution.addWord("bad");
        Solution.addWord("dad");
        Solution.addWord("mad");
        assertTimeout(Duration.ofMillis(500), () -> {
            Boolean expected1 = false;
            Boolean actual1 = Solution.search("pad");
            assertEquals(expected1, actual1);
            Boolean expected2 = true;
            Boolean actual2 = Solution.search("bad");
            assertEquals(expected2, actual2);
            Boolean expected3 = true;
            Boolean actual3 = Solution.search(".ad");
            assertEquals(expected3, actual3);
            Boolean expected4 = true;
            Boolean actual4 = Solution.search("b..");
            assertEquals(expected4, actual4);
        });
    }
}