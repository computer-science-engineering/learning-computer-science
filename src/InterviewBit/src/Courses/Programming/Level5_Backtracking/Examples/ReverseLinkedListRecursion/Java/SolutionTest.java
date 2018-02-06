package InterviewBit.src.Courses.Programming.Level5_Backtracking.Examples.ReverseLinkedListRecursion.Java;

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
    public void TrivialCase1() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {3, 5, 8, 1};
            ListNode result = Solution.reverseList(a1);
            int[] actual = new int[4];
            int i=0;
            while(result.next != null) {
                actual[i++] = result.val;
                result = result.next;
            }
            actual[i] = result.val;
            assertArrayEquals(expected, actual);
        });
    }
}