# Problem Definition

## Description

**Find largest distance:**

Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

**Example:**

If given P is `[-1, 0, 0, 0, 3]`, then node `0` is the root and the whole tree looks like this:

```text
          0
       /  |  \
      1   2   3
               \
                4
```

**Note:** One of the longest path is `1 -> 0 -> 3 -> 4` and its length is `3`, thus the answer is `3`. Note that there are other paths with maximal distance.

## Notes

1. [Geeks for Geeks - Longest path in an undirected tree](https://www.geeksforgeeks.org/longest-path-undirected-tree/)
1. [GitHub - lazyverve](https://github.com/lazyverve/CodingPratice/blob/9929fa42392d1904755b52a938d83ee57c0030fb/src/main/java/com/interviewbit/graphs/LargestDistanceBetweenNodesofATree.java)
1. [GitHub - esarella](https://github.com/esarella/Graphs/blob/d5014e492d102de23763ff8a50b1c5cdf707aa61/src/Graphs/LargestDistanceBetweenNodesOfATree.java)
1. [GitHub - fakemonk1](https://github.com/fakemonk1/DataStructures-And-Algorithms-IB/blob/27dc5443c14e212d2101f9c83797a214aafe2b0c/src/graphs/LargestDistanceBetweenNodesOfATree.java)
1. [LeetCode discussion - Diameter of Binary Tree - Java Solution, MaxDepth](https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth)

### Solution Approach

1. pick any node u
1. find the node which is farthest from u, call it x (calculate using the same approach as in Solution 1)
1. find the node which is farthest from x, call it q (calculate using the same approach as in Solution 1)

The answer will be the length of a path from x to q.

Proof of correctness:

The crucial step is to prove that x will be one of the endpoints of the path with maximal length (note that there might be more than one such path). If it is, then the longest path from x will be the longest path in the tree.

Let d(v1, v2) be length of path between v1 and v2

Let’s prove it by contradiction: assume there is a strictly longer path between s and t, neither of which is x. Let h be a node which is closest to u among the nodes on a path between s and t. Then there are two cases:

1. h is on path between u and x

    ```text
        u
        |
        |
        |
        h   x
       / \ /
      /   *
     /     \
    s       t
    ```

    then d(s, t) = d(s, h) + d(h, t) <= d(s, h) + d(h, x) = d(s, x), which contradicts assumption.

1. h is not on path between u and x

    ```text
        u
        |
        *---x
        |
        h
       / \
      /   \
     /     \
    s       t
    ```

    then

    d(u, s) <= d(u, x) <= d(u, h) + d(h, x)
    d(u, t) <= d(u, x) <= d(u, h) + d(h, x)

    d(s, t) = d(s, h) + d(h, t)
    = d(u, s) + d(u, t) - 2 d(u, h)
    <= 2 d(h, x)

    2 d(s, t) <= d(s, t) + 2 d(h, x)
    = d(s, h) + d(h, x) + d(x, h) + d(h, t)
    = d(x, s) + d(x, t)

    This means that max(d(v, s), d(v, t)) >= d(s, t), which also contradicts assumption.

Thus, we proved that farthest node of a node will be one of the endpoints of the longest path.