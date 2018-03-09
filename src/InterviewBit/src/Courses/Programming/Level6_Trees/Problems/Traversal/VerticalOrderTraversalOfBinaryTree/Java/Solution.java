package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Traversal.VerticalOrderTraversalOfBinaryTree.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(6);
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(7);
        a.left = b1;
        a.right = b2;
        TreeNode c1 = new TreeNode(2);
        TreeNode c2 = new TreeNode(5);
        TreeNode c3 = new TreeNode(9);
        b1.left = c1;
        b1.right = c2;
        b2.right = c3;
        ArrayList<ArrayList<Integer>> result = verticalOrderTraversal(a);
        for(int i=0; i<result.size(); i++) {
            for(int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A == null) {
            return result;
        }
    
        // level and list    
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> level = new LinkedList<Integer>();
    
        queue.offer(A);
        level.offer(0);
    
        int minLevel = 0;
        int maxLevel = 0;
    
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            int l = level.poll();
    
            //track min and max levels
            minLevel=Math.min(minLevel, l);
            maxLevel=Math.max(maxLevel, l);
    
            if(map.containsKey(l)) {
                map.get(l).add(p.val);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(p.val);
                map.put(l, list);
            }
    
            if(p.left != null) {
                queue.offer(p.left);
                level.offer(l-1);
            }
    
            if(p.right != null){
                queue.offer(p.right);
                level.offer(l+1);
            }
        }    
    
        for(int i=minLevel; i<=maxLevel; i++){
            if(map.containsKey(i)) {
                result.add(map.get(i));
            }
        }
        return result;
    }
}