package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Traversal.InOrderTraversal.Java;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.right = b;
        b.left = c;

        ArrayList<Integer> result = inorderTraversal(a);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }
    
    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = A;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }

        while(stack.size() > 0) {
            current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                current = current.right;
                while(current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }            
        }

        return result;
    }
}