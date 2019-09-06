# Problem Definition

## Description

Find the lowest common ancestor in an unordered binary tree given two values in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.

Example:

```plaintext
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
```

For the above tree, the LCA of nodes 5 and 1 is 3.

LCA = Lowest common ancestor.

Please note that LCA for nodes 5 and 4 is 5.

* You are given 2 values. Find the lowest common ancestor of the two nodes represented by `val1` and `val2`.
* No guarantee that `val1` and `val2` exist in the tree. If one value doesn’t exist in the tree then return -1.
* There are no duplicate values.
* You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.

## Notes

1. [LeetCode discussion - 4 lines C++/Java/Python/Ruby](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225/4-lines-C++JavaPythonRuby)
1. [Geeks for Geeks - Lowest Common Ancestor in a Binary Tree | Set 1](http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/)
1. [Geeks for Geeks - Lowest Common Ancestor in a Binary Search Tree.](http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/)
1. [YT video - Vivekanand Khyade - Lowest common ancestor of two nodes in Binary Tree Algorithm](https://www.youtube.com/watch?v=F-_1sbnPbWQ)
1. [YT video - Tushar Roy - Lowest Common Ancestor Binary Tree](https://www.youtube.com/watch?v=13m9ZCB8gjw)