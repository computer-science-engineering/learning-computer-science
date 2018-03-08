package InterviewBit.src.Courses.Programming.Level6_Trees.Examples.NextGreaterNumberBst.Java;

public class Solution {
    public static void main(String[] args) {
        //root level 0
        TreeNode a = new TreeNode(100);
        //Level 1
        TreeNode b1 = new TreeNode(98);
        TreeNode b2 = new TreeNode(102);
        a.left = b1;
        a.right = b2;        
        //Level 2
        TreeNode c1 = new TreeNode(96);
        TreeNode c2 = new TreeNode(99);
        b1.left = c1;
        b1.right = c2;
        //Level 3
        TreeNode d = new TreeNode(97);
        c1.right = d;
        TreeNode result = getSuccessor_Editorial(a, 96);
        System.out.println(result.val);
    }
    
    public static TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode successor = null;
        TreeNode current = Find(a, b);
        if(current == null) {
            return null;
        }
        if (current.right != null) {
            return findMin(current.right);
        }
        else {
            TreeNode ancestor = a;
            while(ancestor != current) {
                if (current.val <= ancestor.val) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                }
                else {
                    ancestor = ancestor.right;
                }
            }
        }
        return successor;
    }

    public static TreeNode getSuccessor_Editorial(TreeNode a, int b) {
	    TreeNode min = new TreeNode(Integer.MAX_VALUE);
	    
	    if(a == null) {
            return null;
        }
	    
	    while(a.val != b) {
	        if(a.val > b) {
	            if(min.val > a.val) {
                    min = a;
                }
	            a = a.left;
	        }
	        else {
                a = a.right;
            }	        
	    }
	    
	    if(a.right == null) {
	        if(min.val == Integer.MAX_VALUE) {
                return null;
            }	            
	        return min;
	    }
	        
	    a = a.right;
        while(a.left != null) {
            a = a.left;
        }
	    return a;
	}

    private static TreeNode findMin(TreeNode root){
		if(root==null) {
            return null;
        }
		while(root.left!=null){
			root = root.left;
		}
		return root;		
	}

    private static TreeNode Find(TreeNode root, int data) {
        if(root == null) {
            return null;
        }
        else if(root.val == data) {
            return root;
        }
        else if(root.val > data) {
            return Find(root.left, data);
        }
        else return Find(root.right, data);
    }
}