# Problem Definition

## Description

You need to find the largest value in each row of a binary tree.

**Example:**

```text
Input:

          1
         / \
        3   2
       / \   \  
      5   3   9

Output: [1, 3, 9]
```

## Notes

1. [LeetCode discussion - 9ms JAVA DFS solution](https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98971/9ms-JAVA-DFS-solution)
1. [LeetCode discussion - Java BFS](https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98976/Java-BFS)

      ```java
      public int[] findValueMostElement(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i=0;i<queueSize;i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largestElement);
            queueSize = queue.size();
        }
        int[] resArray = new int[res.size()];
        for (int i=0;i<res.size();i++) resArray[i] = res.get(i);
        return resArray;
    }
    ```