# Problem Definition

## Description

Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

## Notes

The problem follows the **In-place Reversal of a LinkedList** pattern. We can use a similar approach as discussed in **Reverse a LinkedList**. Here are the steps we need to follow:

1. Skip the first `p-1` nodes, to reach the node at position `p`.
2. Remember the node at position `p-1` to be used later to connect with the reversed sub-list.
3. Next, reverse the nodes from `p` to `q` using the same approach discussed in **Reverse a LinkedList**.
4. Connect the `p-1` and `q+1` nodes to the reversed sub-list.

### Time Complexity

The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

### Space Complexity

We only used constant space, therefore, the space complexity of our algorithm is O(1).

## References
