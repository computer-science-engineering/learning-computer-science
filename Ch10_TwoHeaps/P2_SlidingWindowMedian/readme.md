# Problem Definition

## Description

Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.

Example 1:

```plaintext
Input: nums=[1, 2, -1, 3, 5], k = 2
Output: [1.5, 0.5, 1.0, 4.0]
```

Explanation: Lets consider all windows of size ‘2’:

- [`1, 2`, -1, 3, 5] -> median is 1.5
- [1, `2, -1`, 3, 5] -> median is 0.5
- [1, 2, `-1, 3`, 5] -> median is 1.0
- [1, 2, -1, `3, 5`] -> median is 4.0

Example 2:

```plaintext
Input: nums=[1, 2, -1, 3, 5], k = 3
Output: [1.0, 2.0, 3.0]
```

Explanation: Lets consider all windows of size ‘3’:

- [`1, 2, -1`, 3, 5] -> median is 1.0
- [1, `2, -1, 3`, 5] -> median is 2.0
- [1, 2, `-1, 3, 5`] -> median is 3.0

## Discussion

This problem follows the **Two Heaps** pattern and share similarities with **Find the Median of a Number Stream**. We can follow a similar approach of maintaining a max-heap and a min-heap for the list of numbers to find their median.

The only difference is that we need to keep track of a sliding window of ‘k’ numbers. Which means, in each iteration, when we insert a new number in the heaps, we need to remove one number from the heaps which goes out of the sliding window. After the removal, we need to rebalance the heaps in the same way that we did while inserting.

### Time Complexity

The time complexity of our algorithm is O(N*K) where ‘N’ is the total number of elements in the input array and ‘K’ is the size of the sliding window. This is due to the fact that we are going through all the ‘N’ numbers and, while doing so, we are doing two things:

1. Inserting/removing numbers from heaps of size ‘K’. This will take O(logK).
2. Removing the element going out of the sliding window. This will take O(K) as we will be searching this element in an array of size ‘K’ (i.e., a heap).

### Space Complexity

The space complexity will be O(K) because, at any time, we will be storing all the numbers within the sliding window.

## Notes

## References
