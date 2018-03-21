package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.TwoSumBinaryTree.Java;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(10);
        TreeNode B1 = new TreeNode(9);
        TreeNode B2 = new TreeNode(20);
        A.left = B1;
        A.right = B2;
        System.out.println(t2Sum(A, 19));
        System.out.println(t2Sum(A, 40));
    }
    
    public static int t2Sum(TreeNode A, int B) {
        if(A == null) {
            return 0;
        }
    	Stack<TreeNode> l_stack = new Stack<>();
    	Stack<TreeNode> r_stack = new Stack<>();
    	stackAdd(l_stack, A, true);
    	stackAdd(r_stack, A, false);
    	while(l_stack.peek() != r_stack.peek()) {
    	    int n = l_stack.peek().val + r_stack.peek().val;
    	    if(n == B) {
    		    return 1;
    	    } else if(n > B) {
    		    stackNext(r_stack, false);
    	    } else {
		        stackNext(l_stack, true);
    	    }
    	}
    	return 0;
    }
    
    private static void stackAdd(Stack<TreeNode> stack, TreeNode node, boolean isLeft) {
    	while(node != null) {
    	    stack.push(node);
            node = (isLeft) ? node.left : node.right;
    	}
    }

    private static void stackNext(Stack<TreeNode> stack, boolean isLeft) {
    	TreeNode node = stack.pop();
    	if(isLeft) {
    	    stackAdd(stack, node.right, isLeft);
    	} else {
    	    stackAdd(stack, node.left, isLeft);
    	}
    }
}