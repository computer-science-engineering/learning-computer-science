package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Examples.ReverseLinkedList.Java;

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
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.reverseList(a1).val;
            assertEquals(expected, actual);
        });
    }
}