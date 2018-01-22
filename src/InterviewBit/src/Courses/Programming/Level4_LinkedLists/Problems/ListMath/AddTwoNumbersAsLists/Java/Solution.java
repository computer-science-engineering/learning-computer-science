package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Problems.ListMath.AddTwoNumbersAsLists.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        ListNode result = addTwoNumbers(a1, b1);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);        
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry =0;
  
        ListNode newHead = new ListNode(0);
        ListNode p1 = A, p2 = B, p3=newHead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if(carry==1) {
            p3.next=new ListNode(1);
        }

        return newHead.next;
     }

    public static ListNode addTwoNumbers_unoptimized(ListNode A, ListNode B) {
        long a = getNumber(reverseList(A));
        long b = getNumber(reverseList(B));
        long sum = a + b;
        ListNode node = getListNode(sum);
        ListNode result = reverseList(node);
        return result;
    }

    public static ListNode reverseList(ListNode A) {
        ListNode newHead = null;
        while (A != null) {
            ListNode next = A.next;
            A.next = newHead;
            newHead = A;
            A = next;
        }
        return newHead;
    }

    public static long getNumber(ListNode A) {
        StringBuilder sb = new StringBuilder();
        while(A.next != null) {
            sb.append(A.val);
            A = A.next;
        }
        sb.append(A.val);
        return Long.valueOf(sb.toString());
    }
    
    public static ListNode getListNode(long A) {
        ListNode result = null;
        ListNode ret = null;
        String s = String.valueOf(A);
        for (char c : s.toCharArray()) {
            ListNode temp = new ListNode(Character.getNumericValue(c));
            if (result == null) {
                result = temp;
                ret = result;
            }
            else {
                while (result.next != null) {
                    result = result.next;
                }
                result.next = temp;
            }            
        }
        return ret;
    }
}