package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Traversal.PreOrderTraversal.Java;

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

        ArrayList<Integer> result = preorderTraversal(a);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }
    
    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.addFirst(A);
        while(!stack.isEmpty()){
            A = stack.pollFirst();
            result.add(A.val);
            if(A.right != null){
                stack.addFirst(A.right);
            }
            if(A.left!= null){
                stack.addFirst(A.left);
            }
        }

        return result;
    }
}