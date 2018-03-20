package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TreeConstruction.ConstructBinaryTreeFromInorderAndPreorder.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 1, 3};
        TreeNode result = buildTree(A, B);
        System.out.println(result.val);
    }
    
    // A - pre-order; B - in-order
    public static TreeNode buildTree(int[] A, int[] B) {
        int preStart = 0;
        int preEnd = A.length-1;
        int inStart = 0;
        int inEnd = B.length-1;
 
        return construct(A, preStart, preEnd, B, inStart, inEnd);
    }

    private static TreeNode construct(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd) {
            return null;
        }
     
        // this is the root node
        int val = preOrder[preStart];
        TreeNode p = new TreeNode(val);
     
        // find parent element index from inorder
        int k=0;
        for(int i=0; i<inOrder.length; i++) {
            if(val == inOrder[i]) {
                k=i;
                break;
            }
        }
     
        p.left = construct(preOrder, preStart+1, preStart+(k-inStart), inOrder, inStart, k-1);
        p.right = construct(preOrder, preStart+(k-inStart)+1, preEnd, inOrder, k+1, inEnd);
     
        return p;
    }
}