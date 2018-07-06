package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.LinkedList.DeleteNodeInALinkedList.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        deleteNode(a3);
        while(a1.next != null) {
            System.out.print(a1.val + "->");
            a1 = a1.next;
        }
        System.out.print(a1.val);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}