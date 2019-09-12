# Problem Definition

## Description

Given a binary tree, connect each node with its level order successor. The last node of each level should point to a `null` node.

Example 1:

```plantuml
[1] --> [2]
[1] --> [3]
[1] .> null1

[2] .> [3]
[3] .> null2

[2] --> [4]
[2] --> [5]
[3] --> [6]
[3] --> [7]
[4] .> [5]
[5] .> [6]
[6] .> [7]
[7] .> null3
```

Example 2:

```plantuml
[12] --> [7]
[12] --> [1]
[12] .> null1

[7] --> [9]
[7] .> [1]
[1] .> null2

[1] --> [10]
[1] --> [5]
[9] .> [10]
[10] .> [5]
[5] .> null3
```

## Discussion

This problem follows the **Binary Tree Level Order Traversal** pattern. We can follow the same **BFS** approach. The only difference is that while traversing a level we will remember the previous node to connect it with the current node.

### Time Complexity

The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

### Space Complexity

The space complexity of the above algorithm will be O(N), which is required for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.

## Notes

## References
