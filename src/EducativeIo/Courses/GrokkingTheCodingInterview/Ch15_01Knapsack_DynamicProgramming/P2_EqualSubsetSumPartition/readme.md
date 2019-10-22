# Problem Definition

1. [Description](#description)
2. [Discussion](#discussion)
   1. [Basic Solution - Brute Force](#basic-solution---brute-force)
      1. [Time Complexity](#time-complexity)
      2. [Space Complexity](#space-complexity)
   2. [Top-down Dynamic Programming with Memoization](#top-down-dynamic-programming-with-memoization)
      1. [Time Complexity - Top-down Dynamic Programming with Memoization](#time-complexity---top-down-dynamic-programming-with-memoization)
      2. [Space Complexity - Top-down Dynamic Programming with Memoization](#space-complexity---top-down-dynamic-programming-with-memoization)
3. [Notes](#notes)
4. [References](#references)

## Description

Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.

Example 1:

```plaintext
Input: {1, 2, 3, 4}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
```

Example 2:

```plaintext
Input: {1, 1, 3, 4, 7}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
```

Example 3:

```plaintext
Input: {2, 3, 4, 6}
Output: False
Explanation: The given set cannot be partitioned into two subsets with equal sum.
```

## Discussion

### Basic Solution - Brute Force

This problem follows the **0/1 Knapsack pattern**. A basic brute-force solution could be to try all combinations of partitioning the given numbers into two sets to see if any pair of sets has an equal sum.

Assume that `S` represents the total sum of all the given numbers. Then the two equal subsets must have a sum equal to `S/2`. This essentially transforms our problem to: "Find a subset of the given numbers that has a total sum of `S/2`".

So our brute-force algorithm will look like:

```plaintext
for each number 'i'
  create a new set which INCLUDES number 'i' if it does not exceed 'S/2', and recursively
      process the remaining numbers
  create a new set WITHOUT number 'i', and recursively process the remaining items
return true if any of the above sets has a sum equal to 'S/2', otherwise return false
```

#### Time Complexity

The time complexity of the above algorithm is exponential O(2^n), where ‘n’ represents the total number.

#### Space Complexity

The space complexity is O(n), which will be used to store the recursion stack.

### Top-down Dynamic Programming with Memoization

We can use memoization to overcome the overlapping sub-problems. As stated in previous lessons, memoization is when we store the results of all the previously solved sub-problems so we can return the results from memory if we encounter a problem that has already been solved.

Since we need to store the results for every subset and for every possible sum, therefore we will be using a two-dimensional array to store the results of the solved sub-problems. The first dimension of the array will represent different subsets and the second dimension will represent different ‘sums’ that we can calculate from each subset. These two dimensions of the array can also be inferred from the two changing values (sum and currentIndex) in our recursive function `canPartitionRecursive()`.

#### Time Complexity - Top-down Dynamic Programming with Memoization

O(N∗S), where ‘N’ represents total numbers and ‘S’ is the total sum of all the numbers.

#### Space Complexity - Top-down Dynamic Programming with Memoization

O(N∗S), where ‘N’ represents total numbers and ‘S’ is the total sum of all the numbers.

## Notes

## References
