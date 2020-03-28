package LeetCode.src.Problems.P201_P300.P297_SerializeAndDeserializeBinaryTree.Java;

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
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        assertTimeout(Duration.ofMillis(700), () -> {
            String expectedString = "5,4,11,7,X,X,2,X,X,X,8,13,X,X,4,5,X,X,1,X,X,";            
            String actual = Solution.serialize(TreeNode.fromArray(values));
            TreeNode deserializedNode = Solution.deserialize(actual);
            String actualAgain = Solution.serialize(deserializedNode);
            assertEquals(expectedString, actual);
            assertEquals(expectedString, actualAgain);
        });
    }
}