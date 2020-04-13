# Problem Definition

## Description

Design a class to efficiently find the Kth largest element in a stream of numbers.

The class should have the following two things:

1. The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
2. The class should expose a function `add(int num)` which will store the given number and return the Kth largest number.

Example 1:

```plaintext
Input: [3, 1, 5, 12, 2, 11], K = 4
1. Calling add(6) should return '5'.
2. Calling add(13) should return '6'.
2. Calling add(4) should still return '6'.
```

## Discussion

This problem follows the **Top ‘K’ Elements** pattern and shares similarities with **Kth Smallest number**.

We can follow the same approach as discussed in the ‘Kth Smallest number’ problem. However, we will use a **Min Heap** (instead of a **Max Heap**) as we need to find the Kth largest number.

### Time Complexity

The time complexity of the `add()` function will be O(logK) since we are inserting the new number in the heap.

### Space Complexity

The space complexity will be O(K) for storing numbers in the heap.

## Notes

## References
