package HackerRank.src.Tracks.CoreCS.DataStructures.LinkedLists.ReverseALinkedList.Java;

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