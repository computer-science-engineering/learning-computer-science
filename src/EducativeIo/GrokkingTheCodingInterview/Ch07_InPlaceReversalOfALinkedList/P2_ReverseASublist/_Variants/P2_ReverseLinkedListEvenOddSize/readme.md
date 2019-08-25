# Problem Definition

## Description

Given a LinkedList with ‘n’ nodes, reverse it based on its size in the following way:

1. If ‘n’ is even, reverse the list in a group of n/2 nodes.
2. If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes and reverse the last ‘n/2’ nodes.

## Notes

When ‘n’ is even we can perform the following steps:

1. Reverse first ‘n/2’ nodes: `head = reverse(head, 1, n/2)`
2. Reverse last ‘n/2’ nodes: `head = reverse(head, n/2 + 1, n)`

When ‘n’ is odd, our algorithm will look like:

1. `head = reverse(head, 1, n/2)`
2. `head = reverse(head, n/2 + 2, n)`

Please note the function call in the second step. We’re skipping two elements as we will be skipping the middle element.

### Time Complexity

### Space Complexity

## References
