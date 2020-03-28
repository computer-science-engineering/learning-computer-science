package DailyInterviewPro.src.P1_P100.P1_AddTwoNumbersAsALinkedList.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        assertTimeout(Duration.ofMillis(700), () -> {
            List<Integer> expected = Arrays.asList(7, 0, 8);
            ListNode result = Solution.addTwoNumbers(l1, l2);
            List<Integer> actual = new ArrayList<>();
            while (result != null) {
                actual.add(result.value);
                result = result.next;
            }
            assertEquals(expected, actual);
        });
    }
}
