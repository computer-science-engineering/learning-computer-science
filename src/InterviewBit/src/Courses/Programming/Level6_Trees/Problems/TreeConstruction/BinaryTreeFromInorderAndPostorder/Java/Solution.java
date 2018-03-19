package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TreeConstruction.BinaryTreeFromInorderAndPostorder.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] A = {2, 1, 3};
        int[] B = {2, 3, 1};
        TreeNode result = buildTree(A, B);
        System.out.println(result.val);
    }
    
    // A - inorder; B- postorder
    public static TreeNode buildTree(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0; i<A.length; ++i) {
            hm.put(A[i], i);
        }
        return buildTreePostIn(A, 0, A.length-1, B, 0, B.length-1, hm);
    }

    private static TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm) {
        if (ps>pe || is>ie) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftChild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightChild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}