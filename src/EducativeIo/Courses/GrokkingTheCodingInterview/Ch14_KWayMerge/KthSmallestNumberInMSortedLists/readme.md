# Problem Definition

## Description

Given ‘M’ sorted arrays, find the K'th smallest number among all the arrays.

Example 1:

```plaintext
Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
Output: 4
Explanation: The 5th smallest number among all the arrays is 4, this can be verified from the merged
list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
```

Example 2:

```plaintext
Input: L1=[5, 8, 9], L2=[1, 7], K=3
Output: 7
Explanation: The 3rd smallest number among all the arrays is 7.
```

## Discussion

### Approach

This problem follows the **K-way merge** pattern and we can follow a similar approach as discussed in **Merge K Sorted Lists**.

We can start merging all the arrays, but instead of inserting numbers into a merged list, we will keep count to see how many elements have been inserted in the merged list. Once that count is equal to ‘K’, we have found our required number.

A big difference from **Merge K Sorted Lists** is that in this problem, the input is a list of arrays compared to LinkedLists. This means that when we want to push the next number in the heap we need to know what the index of the current number in the current array was. To handle this, we will create a `Node` class which will track the array and the element indices.

#### Time Complexity

Since we’ll be going through at most ‘K’ elements among all the arrays, and we will remove/add one element in the heap in each step, the time complexity of the above algorithm will be O(K*logM) where ‘M’ is the total number of input arrays.

#### Space Complexity

The space complexity will be O(M) because, at any time, our min-heap will be storing one number from all the ‘M’ input arrays.

## Notes

## References

1. [Geeks for Geeks - Find m-th smallest value in k sorted arrays](https://www.geeksforgeeks.org/find-m-th-smallest-value-in-k-sorted-arrays/)
