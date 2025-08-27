# Problem Definition

## Description

Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

```plaintext
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
```

Example 2:

```plaintext
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
```

## Notes

This problem follows the **Two Pointers** pattern and shares similarities with **Pair with Target Sum**. A couple of differences are that the input array is not sorted and instead of a pair we need to find triplets with a target sum of zero.

To follow a similar approach, first, we will sort the array and then iterate through it taking one number at a time. Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that `X + Y + Z == 0`. At this stage, our problem translates into finding a pair whose sum is equal to “-X” (as from the above equation `Y + Z == -X`).

Another difference from **Pair with Target Sum** is that we need to find all the unique triplets. To handle this, we have to skip any duplicate number. Since we will be sorting the array, so all the duplicate numbers will be next to each other and are easier to skip.

### Time complexity

Sorting the array will take O(N * logN). The `searchPair()` function will take O(N). As we are calling `searchPair()`for every number in the input array, this means that overall `searchTriplets()` will take O(N * logN + N^2), which is asymptotically equivalent to O(N^2).

### Space complexity

Ignoring the space required for the output array, the space complexity of the above algorithm will be O(N) which is required for sorting.
