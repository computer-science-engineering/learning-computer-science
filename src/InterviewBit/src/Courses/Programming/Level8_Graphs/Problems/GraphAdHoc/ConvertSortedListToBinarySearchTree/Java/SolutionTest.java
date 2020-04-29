package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphAdHoc.ConvertSortedListToBinarySearchTree.Java;

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
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 1, 3));
            TreeNode result = Solution.sortedListToBST(a);
            ArrayList<Integer> actual = Solution.levelOrder(result);
            assertEquals(expected, actual);
        });
    }
}