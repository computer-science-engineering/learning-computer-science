package LeetCode.src.Problems.P601_P700.P671_SecondMinimumNodeInABinaryTree.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            2,
            2, 5,
            -1, -1, 5, 7};
        TreeNode root = TreeNode.fromArray(values);
        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        if (root.left == null && root.right == null) {
            return -1;
        }
        
        int left = root.left.val;
        int right = root.right.val;
        
        // if value same as root value, need to find the next candidate
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}