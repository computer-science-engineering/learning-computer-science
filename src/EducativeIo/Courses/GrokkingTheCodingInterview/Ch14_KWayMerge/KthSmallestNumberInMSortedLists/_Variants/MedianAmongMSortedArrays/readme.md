# Problem Definition

## Description

Given ‘M’ sorted arrays, find the median number among all arrays.

## Discussion

### Approach

This problem is similar to the problem, **Kth Smallest Number in M Sorted Lists**, with K=Median. So if there are ‘N’ total numbers in all the arrays we need to find the K'th minimum number where K=N/2.

#### Time Complexity

Since we’ll be going through at most ‘K’ (k = n/2; where n = total elements in all arrays) elements among all the arrays, and we will remove/add one element in the heap in each step, the time complexity of the above algorithm will be O(K*logM) where ‘M’ is the total number of input arrays.

#### Space Complexity

The space complexity will be O(M) because, at any time, our min-heap will be storing one number from all the ‘M’ input arrays.

## Notes

## References
