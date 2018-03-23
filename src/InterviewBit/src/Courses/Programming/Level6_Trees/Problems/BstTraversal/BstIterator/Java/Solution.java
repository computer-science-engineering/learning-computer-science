package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.BstIterator.Java;

import java.util.Stack;

/*
.        ( 5 )
        /     \
      (3)     (8)
     /  \     /  \
   (1)  (4) (7)  (12)
                 /
               (10)
               /  \
             (9)  (11)
*/

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(10);
        
        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(4);
        TreeNode c3 = new TreeNode(7);
        TreeNode c4 = new TreeNode(12);

        TreeNode d1 = new TreeNode(10);

        TreeNode e1 = new TreeNode(9);
        TreeNode e2 = new TreeNode(11);

        a.left = b1;
        a.right = b2;

        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;

        c4.left = d1;

        d1.left = e1;
        d1.right = e2;
        Solution i = new Solution(a);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }

    private Stack<TreeNode> stack;
    
    public Solution(TreeNode root) {
        stack = new Stack<>();
        fillStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curNode = stack.pop();
        fillStack(curNode.right);
        return curNode.val;
    }

    private void fillStack(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }    
}