package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D24_MoreLinkedLists.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //System.out.println("Hello World");
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);
        sc.close();
    }

    public static Node removeDuplicates(Node head) {
        Node current=head;
        while(current.next!=null)
        {
            Node next = current.next;
            if(current.data == next.data){
                current.next=next.next;
            }
            else{
                current = current.next;
            }
            //head.next = current;
        }
        return head;
    }

    public static Node removeDuplicates2(Node head){
        Set<Integer> set=new HashSet<>();
        Node start=head;
        set.add(start.data);
        while(start.next!=null)
        {
            int data=start.next.data;
            if(set.contains(data))
            {
                start.next=start.next.next;
            }
            else
            {
                set.add(data);
                start=start.next;
            }
        }
        return head;
    }

    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
}

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}
