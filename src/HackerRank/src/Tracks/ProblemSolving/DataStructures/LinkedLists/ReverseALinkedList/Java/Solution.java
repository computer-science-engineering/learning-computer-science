package HackerRank.src.Tracks.ProblemSolving.DataStructures.LinkedLists.ReverseALinkedList.Java;

public class Solution {
    Node Reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}