package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.LinkedList.PalindromeLinkedList.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        System.out.println(isPalindrome(a1));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}