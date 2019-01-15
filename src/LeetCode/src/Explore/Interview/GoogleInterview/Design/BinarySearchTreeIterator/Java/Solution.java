package LeetCode.src.Explore.Interview.GoogleInterview.Design.BinarySearchTreeIterator.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode root = TreeNode.fromArray(values);
        BstIterator i = new BstIterator(root);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }

    public static boolean hasNext(BstIterator bstIterator) {
        return bstIterator.hasNext();
    }

    public static int next(BstIterator bstIterator) {
        return bstIterator.next();
    }
}