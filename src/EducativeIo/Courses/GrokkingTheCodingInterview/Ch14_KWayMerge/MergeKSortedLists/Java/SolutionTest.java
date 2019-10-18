package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_KWayMerge.MergeKSortedLists.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(1, 2, 3, 3, 4, 6, 6, 7, 8);
            List<Integer> actual = new ArrayList<>();
            ListNode result = Solution.merge(new ListNode[] {l1, l2, l3});
            while (result != null) {
                actual.add(result.value);
                result = result.next;
            }
            assertEquals(expected, actual);
        });
    }
}
