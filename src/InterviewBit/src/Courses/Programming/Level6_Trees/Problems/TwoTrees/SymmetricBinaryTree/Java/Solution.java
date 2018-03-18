package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TwoTrees.SymmetricBinaryTree.Java;

public class Solution {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B1 = new TreeNode(2);
        TreeNode B2 = new TreeNode(2);
        TreeNode C1 = new TreeNode(3);
        TreeNode C2 = new TreeNode(4);
        TreeNode C3 = new TreeNode(4);
        TreeNode C4 = new TreeNode(3);
        A.left = B1;
        A.right = B2;
        B1.left = C1;
        B1.right = C2;
        B2.left = C3;
        B2.right = C4;
        System.out.println(isSymmetric(A));

        TreeNode M = new TreeNode(1);
        TreeNode N1 = new TreeNode(2);
        TreeNode N2 = new TreeNode(2);
        TreeNode O1 = new TreeNode(3);
        TreeNode O2 = new TreeNode(3);
        M.left = N1;
        M.right = N2;
        N1.right = O1;
        N2.right = O2;
        System.out.println(isSymmetric(M));
    }
    
    public static int isSymmetric(TreeNode A) {
        if(A == null) {
            return 1;
        }
        if (isMirror(A.left, A.right)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}