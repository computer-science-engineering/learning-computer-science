package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.TreeDp.MaxSumPathInBinaryTree.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            2, 3};
        TreeNode A = TreeNode.fromArray(values);
        System.out.println(maxPathSum(A));
    }
    
    private static int maxValue;

    public static int maxPathSum(TreeNode A) {        
        maxValue = Integer.MIN_VALUE;
        findMaxUtil(A);
        return maxValue;
    }

    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
    private static int findMaxUtil(TreeNode node)
    {
 
        // Base Case
        if (node == null) {
            return 0;
        }
 
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left);
        int r = findMaxUtil(node.right);
 
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.val, node.val);
 
 
        // Max Top represents the sum when the Node under
        // consideration is the root of the maxSum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.val);
 
        // Store the Maximum Result.
        maxValue = Math.max(maxValue, max_top);
 
        return max_single;
    }
}