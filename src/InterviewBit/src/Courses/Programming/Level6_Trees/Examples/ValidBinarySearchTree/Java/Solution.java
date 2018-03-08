package InterviewBit.src.Courses.Programming.Level6_Trees.Examples.ValidBinarySearchTree.Java;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        a.left = b1;
        a.right = b2;
        System.out.println(isValidBST(a));
    }
    
    public static int isValidBST(TreeNode A) {
        boolean result = isBstUtil(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result == true ? 1 : 0;
    }

    private static boolean isBstUtil(TreeNode node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        if (node.val > minValue 
        && node.val < maxValue
        && isBstUtil(node.left, minValue, node.val)
        && isBstUtil(node.right, node.val, maxValue)) {
            return true;
        }
        else {
            return false;
        }
    }
}