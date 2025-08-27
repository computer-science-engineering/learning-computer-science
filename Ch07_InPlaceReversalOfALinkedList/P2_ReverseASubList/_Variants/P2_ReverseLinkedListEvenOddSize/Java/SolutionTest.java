package EducativeIo.Courses.GrokkingTheCodingInterview.Ch07_InPlaceReversalOfALinkedList.P2_ReverseASubList._Variants.P2_ReverseLinkedListEvenOddSize.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(2, 1, 3, 5, 4);
            ListNode result = Solution.reverse(head);
            List<Integer> actual = new ArrayList<>();
            while (result != null) {
                actual.add(result.value);
                result = result.next;
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(3, 2, 1, 6, 5, 4);
            ListNode result = Solution.reverse(head);
            List<Integer> actual = new ArrayList<>();
            while (result != null) {
                actual.add(result.value);
                result = result.next;
            }
            assertEquals(expected, actual);
        });
    }
}
