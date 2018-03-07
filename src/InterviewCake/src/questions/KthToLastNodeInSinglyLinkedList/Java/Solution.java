package InterviewCake.src.questions.KthToLastNodeInSinglyLinkedList.Java;

public class Solution {
    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode("Angel Food");
        LinkedListNode b = new LinkedListNode("Bundt");
        LinkedListNode c = new LinkedListNode("Cheese");
        LinkedListNode d = new LinkedListNode("Devil's Food");
        LinkedListNode e = new LinkedListNode("Eccles");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        LinkedListNode result = kthToLastNode(2, a);
        System.out.println(result.value);
    }
    
    public static LinkedListNode kthToLastNode(int k, LinkedListNode headNode) {
        if (k < 1) {
            throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
        }
        int length = getLength(headNode);
        LinkedListNode result = headNode;
        for(int i=0; i<length-k; i++) {
            result = result.next;
        }
        return result;
    }

    private static int getLength(LinkedListNode headNode) {
        int result = 1;
        while(headNode.next != null) {
            result++;
            headNode = headNode.next;
        }
        return result;
    }
}