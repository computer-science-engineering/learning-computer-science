package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Traversal.PostOrderTraversal.Java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.right = b;
        b.left = c;

        ArrayList<Integer> result = postorderTraversal(a);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }    

    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode current = A;
        Deque<TreeNode> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.addFirst(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    result.add(temp.val);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        result.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return result;
    }
}