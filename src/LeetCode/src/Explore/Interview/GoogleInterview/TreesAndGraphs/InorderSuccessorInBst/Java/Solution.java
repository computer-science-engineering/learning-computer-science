package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.InorderSuccessorInBst.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            5,
            3, 6,
            2, 4, -1, -1,
            1, -1, -1, -1, -1, -1, -1, -1};
        TreeNode a = TreeNode.fromArray(values);
        TreeNode p = a.left.right;
        TreeNode result = inorderSuccessor(a, p);
        System.out.println(result.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.right != null) {
            TreeNode cur = p.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            TreeNode cur = root, prev = null;
            while (cur != p) {
                if (cur.val > p.val) {
                    prev = cur;
                    cur = cur.left;
                } else if (cur.val < p.val) {
                    cur = cur.right;
                }
            }
            return prev;
        }
    }
}