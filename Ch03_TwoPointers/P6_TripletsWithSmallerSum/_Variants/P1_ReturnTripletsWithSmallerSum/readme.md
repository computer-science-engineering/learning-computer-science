# Problem Definition

## Description

Given an array `arr` of unsorted numbers and a target sum, find all triplets in it such that `arr[i] + arr[j] + arr[k] < target` where `i`, `j`, and `k` are three different indices. Write a function to return all such triplets.

Example 1:

```plaintext
Input: [-1, 0, 2, 3], target=3
Output: [[-1, 0, 3], [-1, 0, 2]]
```

Example 2:

```plaintext
Input: [-1, 4, 2, 1, 3], target=5
Output: [[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]]
```

## Notes

### Time complexity

Sorting the array will take O(N * logN)O(N∗logN). The `searchPair()`, in this case, will take O(N^2) the main `while` loop will run in O(N) but the nested `for` loop can also take O(N) - this will happen when the target sum is bigger than every triplet in the array.

So, overall `searchTriplets()` will take O(N * logN + N^3), which is asymptotically equivalent to O(N^3).

Another simpler approach could be to check every triplet of the array with three nested loops and create a list of triplets that meet the required condition.

### Space complexity

Ignoring the space required for the output array, the space complexity of the above algorithm will be O(N) which is required for sorting if we are not using an in-place sorting algorithm.

### References
