package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.LinkedList.RemoveNthNodeFromEndOfList.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(9);
        ListNode a5 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode result = removeNthFromEnd(a1, 2);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        
        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}