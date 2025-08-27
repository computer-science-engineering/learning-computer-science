# Problem Definition

## Description

We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.

Example 1:

```plaintext
Input: [1, 4, 4, 3, 2]
Output: 4
```

Example 2:

```plaintext
Input: [2, 1, 3, 3, 5, 4]
Output: 3
```

Example 3:

```plaintext
Input: [2, 4, 1, 4, 4]
Output: 4
```

## Notes

This problem follows the **Cyclic Sort** pattern and shares similarities with **Find the Missing Number**. Following a similar approach, we will try to place each number on its correct index. Since there is only one duplicate, if while swapping the number with its index both the numbers being swapped are same, we have found our duplicate!

### Time Complexity

The time complexity of the above algorithm is O(n) as we are iterating the input array only once.

### Space Complexity

The algorithm runs in constant space O(1) but modifies the input array.

Can we solve the above problem in O(1) space and without modifying the input array?

While doing the cyclic sort, we realized that the array will have a cycle due to the duplicate number and that the start of the cycle will always point to the duplicate number. This means that we can use the fast & the slow pointer method to find the duplicate number or the start of the cycle similar to **Start of LinkedList Cycle**.

## References
