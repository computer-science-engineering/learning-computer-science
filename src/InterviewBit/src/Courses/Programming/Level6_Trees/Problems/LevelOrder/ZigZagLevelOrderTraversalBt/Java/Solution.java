package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.LevelOrder.ZigZagLevelOrderTraversalBt.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b1 = new TreeNode(9);
        TreeNode b2 = new TreeNode(20);
        TreeNode c1 = new TreeNode(15);
        TreeNode c2 = new TreeNode(7);

        a.left = b1;
        a.right = b2;
        b2.left = c1;
        b2.right = c2;

        ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(a);
        for(int i=0; i<result.size(); i++) {
            for (int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> result_editorial = zigzagLevelOrder_editorial(a);
        for(int i=0; i<result_editorial.size(); i++) {
            for (int j=0; j<result_editorial.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        queue.add(null);
        boolean reverse = false;
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                result.add(new ArrayList<Integer>(tempResult));
                if (queue.isEmpty()) {
                    break;
                }
                tempResult.clear();
                queue.add(null);
                reverse = !reverse;
            }
            else {
                if (reverse) {
                    tempResult.add(0, tempNode.val);
                }
                else {  
                    tempResult.add(tempNode.val);
                }    

                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }			
        }
        return result;
    }    

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder_editorial(TreeNode a) {
	    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	    if(a==null){
	        return al;
	    }
	    Queue<TreeNode> qe = new LinkedList<>();
	    qe.add(a);
	    int j=0;
	    while(!qe.isEmpty()){
	        int size = qe.size();
	        int i=0;
	        ArrayList<Integer> al1=new ArrayList<>();
	        while(i<size){
	           TreeNode tr = qe.poll();
	           if(j%2!=0){
	               al1.add(0,tr.val);
	           }else{
	               al1.add(tr.val);
	           }
	           if(tr.left!=null){
	               qe.add(tr.left);
	           }
	           if(tr.right!=null){
	               qe.add(tr.right);
	           }
	           i++;
	        }
	        al.add(al1);
	        j++;
	    }
	    return al;
	}
}