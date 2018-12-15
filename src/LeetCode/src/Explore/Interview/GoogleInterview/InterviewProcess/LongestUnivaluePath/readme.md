# Problem Definition

## Description

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

**Example 1:**

```text
Input:

              5
             / \
            4   5
           / \   \
          1   1   5

Output: 2
```

**Example 2:**

```text
Input:

              1
             / \
            4   5
           / \   \
          4   4   5

Output: 2
```

**Note:** The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

## Notes

1. [LeetCode discussion - [Java/C++] Clean Code](https://leetcode.com/explore/interview/card/google/67/sql-2/473/discuss/108136/JavaC++-Clean-Code)
1. [LeetCode solution](https://leetcode.com/problems/longest-univalue-path/solution/)
1. [LeetCode discussion - Java Solution With Explanation](https://leetcode.com/explore/interview/card/google/67/sql-2/473/discuss/130315/Java-Solution-With-Explanation)

    **Idea**
    What we need is a longest path with same number and this path could pass through any node. So we must visit each node and workout a logic to know the longest path at that node, while we are at the given node, we keep updating max known path so far.

    **Visiting each node**
    this is just tree traversal

    **Logic for longest path at the given node**
    Two parts here
    One is to update maxLength at this node. There are three possibilities:

        1. longest path is in the left subtree but doesn't connect to me
        1. longest path is in the right subtree but doesn't connect to me
        1. longest path goes through me

    All of these are captured by **l+r** in the code.

    **Second part is what we need to return to our caller/parent node**
    Since this is a simple path problem, for the caller we must tell which path we are choosing from 1 & 2 above. Why? Because path cannot be in Y shape. So we choose the max in left and right paths. But remember the whole path has to carry the same value - so now make use of the parent value to compare our value, if yes add 1 to the max chosen in the previous statement or return 0 (why? As this node cut the streak of longest path with same value)

1. [LeetCode discussion - java solution with global variable](https://leetcode.com/explore/interview/card/google/67/sql-2/473/discuss/108175/java-solution-with-global-variable)

    ```java
    int len = 0; // global variable
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int val) {
        if (node == null) return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (val == node.val)  return Math.max(left, right) + 1;
        return 0;
    }
    ```