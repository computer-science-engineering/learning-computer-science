# Problem Definition

## Description

Given the head of a **Singly LinkedList** that contains a cycle, write a function to find the **starting node of the cycle**.

## Notes

If we know the length of the **LinkedList** cycle, we can find the start of the cycle through the following steps:

1. Take two pointers. Let’s call them `pointer1` and `pointer2`.
2. Initialize both pointers to point to the start of the LinkedList.
3. We can find the length of the LinkedList cycle using the approach discussed in **LinkedList Cycle**. Let’s assume that the length of the cycle is ‘K’ nodes.
4. Move `pointer2` ahead by ‘K’ nodes.
5. Now, keep incrementing `pointer1` and `pointer2` until they both meet.
6. As `pointer2` is ‘K’ nodes ahead of `pointer1`, which means, `pointer2` must have completed one loop in the cycle when both pointers meet. Their meeting point will be the start of the cycle.

### Time Complexity

As we know, finding the cycle in a LinkedList with ‘N’ nodes and also finding the length of the cycle requires O(N). Also, as we saw in the above algorithm, we will need O(N) to find the start of the cycle. Therefore, the overall time complexity of our algorithm will be O(N).

### Space Complexity

The algorithm runs in constant space O(1).

## References
