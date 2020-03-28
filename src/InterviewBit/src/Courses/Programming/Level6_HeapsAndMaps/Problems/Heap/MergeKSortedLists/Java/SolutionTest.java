package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Heap.MergeKSortedLists.Java;

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
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(10);
        ListNode a3 = new ListNode(20);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(11);
        ListNode b3 = new ListNode(13);
        b1.next = b2;
        b2.next = b3;
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(8);
        ListNode c3 = new ListNode(9);
        c1.next = c2;
        c2.next = c3;
        ArrayList<ListNode> input = new ArrayList<ListNode>(Arrays.asList(a1, b1, c1));
        assertTimeout(Duration.ofMillis(700), () ->  {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 8, 9, 10, 11, 13, 20));
            ListNode result = Solution.mergeKLists(input);
            ArrayList<Integer> actual = new ArrayList<Integer>();
            while(result.next != null) {
                actual.add(result.val);
                result = result.next;
            }
            actual.add(result.val);     
            assertEquals(expected, actual);
        });
    }
}