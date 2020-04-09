# Problem Definition

## Description

Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible.

Example 1:

```plaintext
Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
```

Example 2:

```plaintext
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
```

Example 3:

```plaintext
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
```

## Notes

This problem follows the **Two Pointers** pattern and is quite similar to **Triplet Sum to Zero**.

We can follow a similar approach to iterate through the array, taking one number at a time. At every step, we will save the difference between the triplet and the target number, so that in the end, we can return the triplet with the closest sum.

### Time complexity

Sorting the array will take O(N* logN. Overall `searchTriplet()` will take O(N * logN + N^2), which is asymptotically equivalent to O(N^2).

### Space complexity

The space complexity of the above algorithm will be O(N) which is required for sorting.
