package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.SimpleTreeOps.BalancedBinaryTree.Java;

public class Solution {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);        
        TreeNode B1 = new TreeNode(2);        
        TreeNode B2 = new TreeNode(3);
        A.left = B1;
        A.right = B2;
        System.out.println(isBalanced(A));

        TreeNode a = new TreeNode(3);        
        TreeNode b = new TreeNode(2);        
        TreeNode c = new TreeNode(1);
        a.left = b;
        b.left = c;
        System.out.println(isBalanced(a));

        TreeNode M = new TreeNode(1);        
        TreeNode N1 = new TreeNode(2);        
        TreeNode N2 = new TreeNode(3);       
        TreeNode O = new TreeNode(4);       
        TreeNode P = new TreeNode(5);
        M.left = N1;
        M.right = N2;
        N2.left = O;
        O.right = P;
        System.out.println(isBalanced(M));
    }
    
    public static int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }

        int left = depth(A.left);
        int right = depth(A.right);

        boolean result = Math.abs(left - right) <= 1;

        int isBalancedLeft = isBalanced(A.left);
        int isBalancedRight = isBalanced(A.right);

        if (result == true && isBalancedLeft == 1 && isBalancedRight == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}