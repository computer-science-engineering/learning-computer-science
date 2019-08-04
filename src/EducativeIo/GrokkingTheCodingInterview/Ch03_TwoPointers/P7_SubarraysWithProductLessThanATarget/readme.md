# Problem Definition

## Description

Given an array with positive numbers and a target number, find all subarrays in it whose **product is less than the target number**.

Example 1:

```text
Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six subarrays whose product is less than the target.
```

Example 2:

```text
Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven subarrays whose product is less than the target.
```

## Notes

This problem follows the **Sliding Window** and the **Two Pointers** pattern and shares similarities with **Triplets with Smaller Sum** with two differences:

1. In this problem, the input array is not sorted.
2. Instead of finding triplets with sum less than a target, we need to find all subarrays having a product less than the target.

The implementation will be quite similar to **Triplets with Smaller Sum**.

### Time complexity

The main `for-loop` managing the sliding window takes O(N) but creating subarrays can take up to O(N^2) in the worst case. Therefore overall, our algorithm will take O(N^3).

### Space complexity

Ignoring the space required for the output list, the algorithm runs in constant space O(1).

## References
