package Miscellaneous.src.Problems.Coding.LevelOrderTraversalBinaryTreeSingleLine.Java;

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
        TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70); 
		rootNode.left = node20;
		rootNode.right = node60; 
		node20.left = node10;
		node20.right = node30; 
		node60.left = node50;
        node60.right = node70;
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(40, 20, 60, 10, 30, 50, 70));
            ArrayList<Integer> actual = Solution.levelOrder(rootNode);
            assertEquals(expected, actual);
        });
    }
}