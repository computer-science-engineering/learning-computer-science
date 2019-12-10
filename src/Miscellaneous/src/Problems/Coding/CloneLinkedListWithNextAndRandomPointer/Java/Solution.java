package Miscellaneous.src.Problems.Coding.CloneLinkedListWithNextAndRandomPointer.Java;

public class Solution {
    public static void main(String[] args) {
        // Pushing data in the linked list. 
        LinkedList list = new LinkedList(new Node(5)); 
        list.push(4); 
        list.push(3); 
        list.push(2); 
        list.push(1); 
  
        // Setting up random references. 
        list.head.random = list.head.next.next; 
        list.head.next.random = 
            list.head.next.next.next; 
        list.head.next.next.random = 
            list.head.next.next.next.next; 
        list.head.next.next.next.random = 
            list.head.next.next.next.next.next; 
        list.head.next.next.next.next.random = 
            list.head.next; 
  
        // Making a clone of the original linked list. 
        LinkedList clone = list.clone(); 

        // Print the original and cloned linked list. 
        System.out.println("Original linked list"); 
        list.print(); 
        System.out.println("\nCloned linked list"); 
        clone.print();
    }
}