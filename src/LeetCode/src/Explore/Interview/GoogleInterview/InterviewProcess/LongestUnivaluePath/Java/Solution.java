package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.LongestUnivaluePath.Java;

public class Solution {

    private static int len = 0;

    public static void main(String[] args) {
        int[] values = {
            5,
            4, 5,
            1, 1, -1, 5 };
        TreeNode A = TreeNode.fromArray(values);
        System.out.println(longestUnivaluePath(A));
    }

    public static int longestUnivaluePath(TreeNode root) {
        if(root != null) {
            longestUnivaluePath(root, -1);
        }
        
        return len;
    }

    private static int longestUnivaluePath(TreeNode current, int val){
        if(current == null) return 0;
        int l = longestUnivaluePath(current.left, current.val), r = longestUnivaluePath(current.right, current.val), count = 0;
        len = Math.max(len, l+r); //l is "valid" connecting edges to me from left
        if(current.val == val) {
            count = 1+Math.max(l,r); //give it to caller max path with same number, include me
        }
        return count;
    }
}