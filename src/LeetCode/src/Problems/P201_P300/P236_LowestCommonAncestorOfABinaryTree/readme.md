# Problem Definition

## Description

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow **a node to be a descendant of itself**).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

```text
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
```

**Example 1:**

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.

**Example 2:**

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.

**Note:**

* All of the nodes' values will be unique.
* p and q are different and both values will exist in the binary tree.

## Notes

1. [LeetCode discussion - 4 lines C++/Java/Python/Ruby](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225/4-lines-C++JavaPythonRuby)
1. [LeetCode discussion - Java/Python iterative solution](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65236/JavaPython-iterative-solution)

    ```java
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
    ```

1. [YT Video - Tushar Roy - Lowest Common Ancestor Binary Tree](https://www.youtube.com/watch?v=13m9ZCB8gjw)
1. [YT Video - Vivekanand Khyade - Lowest common ancestor of two nodes in Binary Tree Algorithm](https://www.youtube.com/watch?v=F-_1sbnPbWQ)
1. [YT Video - Geeks for Geeks - Lowest Common Ancestor in a Binary Search Tree](https://www.youtube.com/watch?v=zlTsz-apm4U)