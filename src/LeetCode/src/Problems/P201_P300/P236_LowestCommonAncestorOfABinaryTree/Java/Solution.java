package LeetCode.src.Problems.P201_P300.P236_LowestCommonAncestorOfABinaryTree.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            5, 1,
            6, 2, 0, 8
            -1, -1, 7, 4, -1, -1};
        TreeNode root = TreeNode.fromArray(values);
        int p = 5;        
        int q = 4;
        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    /*public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }*/

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}