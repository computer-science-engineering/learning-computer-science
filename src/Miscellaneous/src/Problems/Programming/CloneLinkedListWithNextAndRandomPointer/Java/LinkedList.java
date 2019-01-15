package Miscellaneous.src.Problems.Programming.CloneLinkedListWithNextAndRandomPointer.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class LinkedList {
    Node head;//Linked list head reference 
  
    // Linked list constructor 
    public LinkedList(Node head) { 
        this.head = head; 
    } 
  
    // push method to put data always at the head 
    // in the linked list. 
    public void push(int data) { 
        Node node = new Node(data); 
        node.next = this.head; 
        this.head = node; 
    } 
  
    // Method to print the list. 
    void print() { 
        Node temp = head; 
        while (temp != null) { 
            Node random = temp.random; 
            int randomData = (random != null)? random.data: -1; 
            System.out.println("Data = " + temp.data + 
                               ", Random data = "+ randomData); 
            temp = temp.next; 
        } 
    } 

    ArrayList<Integer> getDataArray() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node temp = head; 
        while (temp != null) { 
            result.add(temp.data);
            temp = temp.next; 
        } 
        return result;
    }

    ArrayList<Integer> getRandomDataArray() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node temp = head; 
        while (temp != null) { 
            Node random = temp.random; 
            int randomData = (random != null)? random.data: -1; 
            result.add(randomData);
            temp = temp.next; 
        } 
        return result;
    }
  
    // Actual clone method which returns head 
    // reference of cloned linked list. 
    public LinkedList clone() { 
        // Initialize two references, one with original 
        // list's head. 
        Node origCurrent = this.head, cloneCurrent = null; 
  
        // Hash map which contains node to node mapping of 
        // original and clone linked list. 
        Map<Node, Node> map = new HashMap<Node, Node>(); 
  
        // Traverse the original list and make a copy of that 
        // in the clone linked list. 
        while (origCurrent != null) { 
            cloneCurrent = new Node(origCurrent.data); 
            map.put(origCurrent, cloneCurrent); 
            origCurrent = origCurrent.next; 
        } 
  
        // Adjusting the original list reference again. 
        origCurrent = this.head; 
  
        // Traversal of original list again to adjust the next 
        // and random references of clone list using hash map. 
        while (origCurrent != null) { 
            cloneCurrent = map.get(origCurrent); 
            cloneCurrent.next = map.get(origCurrent.next); 
            cloneCurrent.random = map.get(origCurrent.random); 
            origCurrent = origCurrent.next; 
        } 
  
        //return the head reference of the clone list. 
        return new LinkedList(map.get(this.head)); 
    } 
}