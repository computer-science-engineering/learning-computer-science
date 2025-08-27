# Problem Definition

## Description

Given a binary tree, find its maximum depth (or height).

Example 1:

```dot
digraph example1 {
    1 -> 2 -> { 4, 5 }[color=red];
    1 -> 3;
    1[style=filled;color=lightblue];
    2[style=filled;color=lightblue];
    4[style=filled;color=lightblue];
    5[style=filled;color=lightblue];
}
```

```plaintext
Maximum Depth: 3
```

Example 2:

```dot
digraph example1 {
    12 -> 7;
    12 -> 1 -> {10, 5}[color=red];
    12[style=filled;color=lightblue];
    1[style=filled;color=lightblue];
    10[style=filled;color=lightblue];
    5[style=filled;color=lightblue];
}
```

```plaintext
Maximum Depth: 3
```

Example 3:

```dot
digraph example1 {
    12 -> 7 -> 9;
    12 -> 1[color=red];
    1 -> 10[color=red];
    10 -> 5[color=red];
    10 -> 11[color=red]
    12[style=filled;color=lightblue];
    1[style=filled;color=lightblue];
    10[style=filled;color=lightblue];
    5[style=filled;color=lightblue];
    11[style=filled;color=lightblue];
}
```

```plaintext
Maximum Depth: 4
```

## Discussion

We will follow a similar approach. Instead of returning as soon as we find a leaf node, we will keep traversing for all the levels, incrementing `maximumDepth` each time we complete a level.

### Time Complexity

The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

### Space Complexity

The space complexity of the above algorithm will be O(N) which is required for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.

## Notes

## References
