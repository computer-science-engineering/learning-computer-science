# Problem Definition

## Description

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

**Example 1:**
Given the list `[[1,1],2,[1,1]]`, return **8**. (four 1's at depth 1, one 2 at depth 2)

**Example 2:**
Given the list `[1,[4,[6]]]`, return **17**. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

## Notes

1. [LeetCode discussion - Share my 2ms intuitive-one pass-no multiplication solution](https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83649/Share-my-2ms-intuitive-one-pass-no-multiplication-solution)
1. [LeetCode discussion - ACCEPTED Super Clean and short DFS and BFS solutions](https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83651/accepted-super-clean-and-short-dfs-and-bfs-solutions)
1. [LeetCode discussion - No depth variable, no multiplication](https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83641/No-depth-variable-no-multiplication)
1. [LeetCode discussion - Java Two Pass DFS solution](https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83642/Java-Two-Pass-DFS-solution)

    ```java
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        int h = helper(nestedList);
        int res = getSum(nestedList, h);
        return res;
    }
    private int getSum(List<NestedInteger> l, int layer) {
        int sum = 0;
        if(l == null || l.size() == 0) return sum;
        for(NestedInteger n : l) {
            if(n.isInteger()) sum += n.getInteger() * layer;
            else sum += getSum(n.getList(), layer - 1);
        }
        return sum;
    }
    private int helper(List<NestedInteger> l) {
        if(l == null || l.size() == 0) return 0;
        int max = 0;
        for(NestedInteger n : l) {
            if(n.isInteger()) max = Math.max(max, 1);
            else max = Math.max(max, helper(n.getList()) + 1);
        }
        return max;
    }
    ```