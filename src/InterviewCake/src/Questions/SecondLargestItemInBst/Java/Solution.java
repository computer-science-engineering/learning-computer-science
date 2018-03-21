package InterviewCake.src.Questions.SecondLargestItemInBst.Java;

public class Solution {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(5);
        BinaryTreeNode b1 = new BinaryTreeNode(3);
        BinaryTreeNode b2 = new BinaryTreeNode(10);
        
        BinaryTreeNode c1 = new BinaryTreeNode(1);
        BinaryTreeNode c2 = new BinaryTreeNode(4);
        BinaryTreeNode c3 = new BinaryTreeNode(7);
        BinaryTreeNode c4 = new BinaryTreeNode(12);

        BinaryTreeNode d1 = new BinaryTreeNode(10);

        BinaryTreeNode e1 = new BinaryTreeNode(9);
        BinaryTreeNode e2 = new BinaryTreeNode(11);

        a.left = b1;
        a.right = b2;

        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;

        c4.left = d1;

        d1.left = e1;
        d1.right = e2;

        System.out.println(findSecondLargest(a));
    }
    
    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }
    
        BinaryTreeNode current = rootNode;
    
        while (true) {    
            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }
    
            // case: current is parent of largest, and largest has no children,
            // so current is 2nd largest
            if (current.right != null &&
            current.right.left == null &&
            current.right.right == null) {
                return current.value;
            }
    
            current = current.right;
        }
    }
    
    private static int findLargest(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
}