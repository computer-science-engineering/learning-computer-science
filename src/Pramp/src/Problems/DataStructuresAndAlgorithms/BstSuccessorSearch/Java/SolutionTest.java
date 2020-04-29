package Pramp.src.Problems.DataStructuresAndAlgorithms.BstSuccessorSearch.Java;

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
        Solution.BinarySearchTree tree = new Solution.BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        Solution.Node inputNode = tree.getNodeByKey(9);
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 11;
            int actual = tree.findInOrderSuccessor(inputNode).key;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        Solution.BinarySearchTree tree = new Solution.BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        Solution.Node inputNode = tree.getNodeByKey(14);
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 20;
            int actual = tree.findInOrderSuccessor(inputNode).key;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        Solution.BinarySearchTree tree = new Solution.BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        Solution.Node inputNode = tree.getNodeByKey(25);
        assertTimeout(Duration.ofMillis(1000), () -> {
            Solution.Node expected = null;
            Solution.Node actual = tree.findInOrderSuccessor(inputNode);
            assertEquals(expected, actual);
        });
    }
}