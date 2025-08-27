# Problem Definition

## Description

Given a binary tree, return an array containing nodes in its left view. The left view of a binary tree is the set of nodes visible when the tree is seen from the left side.

Example 1:

```dot
digraph example1 {
    12 -> {7, 1};
    7 -> 9 -> 3;
    1 -> {10, 5}
    12[style=filled;color=lightblue];
    7[style=filled;color=lightblue];
    9[style=filled;color=lightblue];
    3[style=filled;color=lightblue];
}
```

```plaintext
Right View: [12, 7, 9, 3]
```

## Discussion

This problem follows the **Binary Tree Level Order Traversal** pattern. We can follow the same **BFS** approach. The only additional thing we will be do is to append the first node of each level to the result array.

### Time Complexity

The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

### Space Complexity

The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal. We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.

## Notes

## References
