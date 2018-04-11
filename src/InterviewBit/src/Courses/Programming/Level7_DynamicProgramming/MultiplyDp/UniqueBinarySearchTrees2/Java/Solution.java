package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.MultiplyDp.UniqueBinarySearchTrees2.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numTrees_recursive(3));
    }
    
    public static int numTrees_recursive(int A) {
        if(A==0) {
            return 0;
        }
     
        List<TreeNode> result = getTrees(1, A);
        return result.size();
    }
     
    // m - start; n - end
    private static List<TreeNode> getTrees(int m, int n){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(m>n) {
            result.add(null);
            return result;
        }
     
        for(int i=m; i<=n; i++) {
            List<TreeNode> ls = getTrees(m, i-1);
            List<TreeNode> rs = getTrees(i+1, n);
            for(TreeNode l: ls) {
                for(TreeNode r: rs) {
                    TreeNode current = new TreeNode(i);
                    current.left=l;
                    current.right=r;
                    result.add(current);
                }
            }
        }
     
        return result;
    }
}