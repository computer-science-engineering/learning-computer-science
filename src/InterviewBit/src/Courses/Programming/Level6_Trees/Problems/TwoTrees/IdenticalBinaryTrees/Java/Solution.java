package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TwoTrees.IdenticalBinaryTrees.Java;

public class Solution {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);        
        TreeNode B1 = new TreeNode(2);        
        TreeNode B2 = new TreeNode(3);
        A.left = B1;
        A.right = B2;

        TreeNode a = new TreeNode(3);        
        TreeNode b = new TreeNode(2);        
        TreeNode c = new TreeNode(1);
        a.left = b;
        b.left = c;

        System.out.println(isSameTree(A, A));
        System.out.println(isSameTree(A, a));
    }
    
    public static int isSameTree(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return 1;
        }
        if(A == null || B == null) {
            return 0;
        }
        if(A.val == B.val) {
            if ((isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right) == 1)) {
                return 1;
            }
        }
        return 0;
    }
}