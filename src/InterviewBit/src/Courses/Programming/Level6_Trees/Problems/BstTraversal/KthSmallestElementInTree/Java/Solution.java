package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.KthSmallestElementInTree.Java;

public class Solution {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(2);
        TreeNode B1 = new TreeNode(1);
        TreeNode B2 = new TreeNode(3);
        A.left = B1;
        A.right = B2;
        System.out.println(kthSmallest(A, 2));
    }
    
    public static int kthSmallest(TreeNode A, int B) {
        int count = countNodes(A.left);
        if (B <= count) {
            return kthSmallest(A.left, B);
        } else if (B > count + 1) {
            return kthSmallest(A.right, B-1-count); // 1 is counted as current node
        }        
        return A.val;
    }
    
    private static int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}