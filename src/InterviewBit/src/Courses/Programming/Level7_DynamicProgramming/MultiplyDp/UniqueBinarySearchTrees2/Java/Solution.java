package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.MultiplyDp.UniqueBinarySearchTrees2.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numTrees_recursive(3));
        System.out.println(numTrees(3));
    }

    public static int numTrees(int A) {
        int[] solutions = new int[A];
        for (int i=0; i<A; i++) {
            solutions[i] = -1;
        }
        return getTreesCount(A, solutions);
    }

    private static int getTreesCount(int n, int[] solutions) {
        if (n<0) {
            return 0;
        }
        else if (n==1 || n==0) {
            return 1;
        }

        int possibilities = 0;

        for (int i=0; i<n; i++) { // for each root
            if (solutions[i] == -1) {
                solutions[i] = getTreesCount(i, solutions); // compute all possible BST-s in left sub-tree
            }

            if (solutions[n-1-i] == -1) {
                solutions[n-1-i] = getTreesCount(n-1-i, solutions); // compute all possible BST-s in right sub-tree
            }

            possibilities += solutions[i] * solutions[n-1-i];
        }

        return possibilities;
    }

    public static int numTrees_Editorial(int limit) {
        int[] dp = new int[limit + 1];
        dp[0] = dp[1] = 1;
        for (int n = 2; n <= limit; n++) {
            for (int root = 1; root <= n; root++) {
                dp[n] += dp[root - 1] * dp[n - root];
            }
        }
        return dp[limit];
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