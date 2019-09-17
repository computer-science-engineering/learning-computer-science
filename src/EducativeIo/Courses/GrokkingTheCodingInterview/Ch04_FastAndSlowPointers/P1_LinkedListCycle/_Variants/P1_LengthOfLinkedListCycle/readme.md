# Problem Definition

## Description

Given the head of a LinkedList with a cycle, find the length of the cycle.

## Notes

We can use the approach from the problem to find the cycle in a LinkedList. Once the fast and slow pointers meet, we can save the slow pointer and iterate the whole cycle with another pointer until we see the slow pointer again to find the length of the cycle.

### Time Complexity

The above algorithm runs in O(N) time .

### Space Complexity

The above algorithm has O(1) space complexity.

## References
