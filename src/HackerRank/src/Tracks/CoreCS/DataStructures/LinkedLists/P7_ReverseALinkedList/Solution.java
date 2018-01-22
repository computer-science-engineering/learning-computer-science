package HackerRank.src.Tracks.CoreCS.DataStructures.LinkedLists.P7_ReverseALinkedList;

// https://www.hackerrank.com/challenges/reverse-a-linked-list

/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method.


import HackerRank.src.Tutorials.ThirtyDaysOfCode.D15_LinkedList.Node;

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