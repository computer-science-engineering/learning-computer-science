package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TreeSearch.LeastCommonAncestor.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            3,
            5, 1,
            6, 2, 0, 8 ,
            -1, -1, 7, 4, -1, -1, -1, -1};
        TreeNode A = TreeNode.fromArray(values);
        System.out.println(lca(A, 5, 50));
        System.out.println(lca(A, 5, 4));
    }

    public static int lca(TreeNode A, int B, int C) {
        boolean v1 = checkIfValueExist(A, B);
        boolean v2 = checkIfValueExist(A, C);
        if (v1 & v2) {
            TreeNode result = findLca(A, B, C);
            if(result == null) {
                return -1;
            }
            return result.val;
        }
        return -1;        
    }

    private static TreeNode findLca(TreeNode node, int val1, int val2) {
        if(node == null || node.val == val1 || node.val == val2) {            
            return node;
        }
        
        TreeNode leftLca = findLca(node.left, val1, val2);
        TreeNode rightLca = findLca(node.right, val1, val2);
        
        if(leftLca != null && rightLca != null) {
            return node;
        }

        return (leftLca != null) ? leftLca: rightLca;          
    }

    private static boolean checkIfValueExist(TreeNode a, int val) {
	    if (a != null && a.val == val) {
	        return true;
	    }
	    if (a == null) {
	        return false;
	    }
	    boolean left = checkIfValueExist(a.left, val);
	    boolean right = checkIfValueExist(a.right, val);
	    return left | right;
	}
}