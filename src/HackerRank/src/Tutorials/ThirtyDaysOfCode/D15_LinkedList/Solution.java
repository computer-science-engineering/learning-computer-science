package HackerRank.src.Tutorials.ThirtyDaysOfCode.D15_LinkedList;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = Solution.insert(head,ele);
        }
        Solution.display(head);
        sc.close();
    }

    public static Node insert(Node head,int data) {
        Node newNode = new Node(data);
        if (head == null){
            return newNode;
        }
        else{
            Node existingNode = head;
            while (existingNode.next != null) {
                existingNode = existingNode.next;
            }
            existingNode.next = newNode;
            return head;
        }
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
}
