package LeetCode.src.Explore.Interview.GoogleInterview.LinkedList.InsertIntoACyclicSortedList.Java;

public class Node {
    int val;
    Node next;

    public Node() {}

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    Node(int x) { 
        val = x; 
    }
}