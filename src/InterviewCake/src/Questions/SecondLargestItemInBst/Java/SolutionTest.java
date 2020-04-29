package InterviewCake.src.Questions.SecondLargestItemInBst.Java;

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
        BinaryTreeNode a = new BinaryTreeNode(5);
        BinaryTreeNode b1 = new BinaryTreeNode(3);
        BinaryTreeNode b2 = new BinaryTreeNode(10);
        
        BinaryTreeNode c1 = new BinaryTreeNode(1);
        BinaryTreeNode c2 = new BinaryTreeNode(4);
        BinaryTreeNode c3 = new BinaryTreeNode(7);
        BinaryTreeNode c4 = new BinaryTreeNode(12);

        BinaryTreeNode d1 = new BinaryTreeNode(10);

        BinaryTreeNode e1 = new BinaryTreeNode(9);
        BinaryTreeNode e2 = new BinaryTreeNode(11);

        a.left = b1;
        a.right = b2;

        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;

        c4.left = d1;

        d1.left = e1;
        d1.right = e2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 11;
            int actual = Solution.findSecondLargest(a);
            assertEquals(expected, actual);
        });
    }
}