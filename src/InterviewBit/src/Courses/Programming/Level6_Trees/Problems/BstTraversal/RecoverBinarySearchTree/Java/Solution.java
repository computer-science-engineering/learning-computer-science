package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.RecoverBinarySearchTree.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);

        a.left = b1;
        a.right = b2;

        Solution solution = new Solution();
        ArrayList<Integer> result = solution.recoverTree(a);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }

    private TreeNode first;
    private TreeNode second; 
    private TreeNode pre; 
 
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
 
        inorder(root.left);
 
        if(pre == null) {
            pre = root;
        } else {
            if(root.val < pre.val) {
                if(first == null) {
                    first = pre;
                }
 
                second = root;
            }
            pre = root;
        }
 
        inorder(root.right);
    }
    
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A == null) {
            return result;
        }
 
        inorder(A);
        if(second != null && first != null) {
            result.add(second.val);
            result.add(first.val);
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }
        return result;
    }
}