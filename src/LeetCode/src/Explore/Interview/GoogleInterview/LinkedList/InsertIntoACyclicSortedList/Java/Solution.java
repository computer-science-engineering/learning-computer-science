package LeetCode.src.Explore.Interview.GoogleInterview.LinkedList.InsertIntoACyclicSortedList.Java;

public class Solution {
    public static void main(String[] args) {
        Node a1 = new Node(3);
        Node a2 = new Node(4);
        Node a3 = new Node(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a1;

        Node result = insert(a1, 2);
        printList(result);
    }

    public static Node insert(Node head, int insertVal) {
        // if start is null, create a node pointing to itself and return
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        // is start is NOT null, try to insert it into correct position
        Node cur = head;
        while (true) {
            // case 1A: has a tipping point, still climbing
            if (cur.val < cur.next.val) { 
                if (cur.val <= insertVal && insertVal <= cur.next.val) { // x in between cur and next
                    insertAfter(cur, insertVal);
                    break;
                }
            // case 1B: has a tipping point, about to return back to min node
            } else if (cur.val > cur.next.val) { 
                if (cur.val <= insertVal || insertVal <= cur.next.val) { // cur is the tipping point, x is max or min val
                    insertAfter(cur, insertVal);
                    break;
                }
            // case 2: NO tipping point, all flat
            } else {
                if (cur.next == head) {  // insert x before we traverse all nodes back to start
                    insertAfter(cur, insertVal);
                    break;
                }
            }
            // None of the above three cases met, go to next node
            cur = cur.next;
        }
        return head;
    }
    
    // insert value x after Node cur
    private static void insertAfter(Node cur, int x) {
        cur.next = new Node(x, cur.next);
    }

    private static void printList(Node head) {
        Node temp = head; 
        if (head != null) { 
            do { 
                System.out.print(temp.val + " "); 
                temp = temp.next; 
            } 
            while (temp != head); 
        } 
    }    
}