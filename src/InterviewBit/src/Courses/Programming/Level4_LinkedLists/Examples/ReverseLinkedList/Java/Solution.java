package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Examples.ReverseLinkedList.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode result = reverseList(a1);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);
        System.out.println();
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(8);
        ListNode b3 = new ListNode(5);
        ListNode b4 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        ListNode result_recursive = reverseList_recursive(b1);
        while(result_recursive.next != null) {
            System.out.print(result_recursive.val + "->");
            result_recursive = result_recursive.next;
        }
        System.out.print(result_recursive.val);
    }
    
    public static ListNode reverseList(ListNode A) {
        /* iterative solution */
        ListNode newHead = null;
        while (A != null) {
            ListNode next = A.next;
            A.next = newHead;
            newHead = A;
            A = next;
        }
        return newHead;
    }

    public static ListNode reverseList_recursive(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }
    
    private static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}