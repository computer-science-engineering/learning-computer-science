# Problem Definition

1. [Description](#description)
   1. [Introduction](#introduction)
   2. [Problem Statement](#problem-statement)
2. [Discussion](#discussion)
   1. [Basic Solution - Brute Force](#basic-solution---brute-force)
      1. [Time Complexity](#time-complexity)
      2. [Space Complexity](#space-complexity)
   2. [Top-down Dynamic Programming with Memoization](#top-down-dynamic-programming-with-memoization)
      1. [Time Complexity - Top-down Dynamic Programming with Memoization](#time-complexity---top-down-dynamic-programming-with-memoization)
      2. [Space Complexity - Top-down Dynamic Programming with Memoization](#space-complexity---top-down-dynamic-programming-with-memoization)
   3. [Bottom-up Dynamic Programming](#bottom-up-dynamic-programming)
      1. [Time Complexity - Bottom-up Dynamic Programming](#time-complexity---bottom-up-dynamic-programming)
      2. [Space Complexity - Bottom-up Dynamic Programming](#space-complexity---bottom-up-dynamic-programming)
3. [Notes](#notes)
4. [References](#references)

## Description

### Introduction

Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit out of the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

```plaintext
Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5
```

Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:

```plaintext
Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit
```

This shows that Banana + Melon is the best combination as it gives us the maximum profit and the total weight does not exceed the capacity.

### Problem Statement

Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Each item can only be selected once, which means either we put an item in the knapsack or we skip it.

## Discussion

### Basic Solution - Brute Force

A basic brute-force solution could be to try all combinations of the given items (as we did above), allowing us to choose the one with maximum profit and a weight that doesn’t exceed ‘C’. Take the example of four items (A, B, C, and D), as shown in the diagram below. To try all the combinations, our algorithm will look like:

```plaintext
for each item 'i'
  create a new set which INCLUDES item 'i' if the total weight does not exceed the capacity, and
     recursively process the remaining capacity and items
  create a new set WITHOUT item 'i', and recursively process the remaining items
return the set from the above two sets with higher profit
```

#### Time Complexity

The time complexity of the above algorithm is exponential O(2^n), where ‘n’ represents the total number of items. This can also be confirmed from the above recursion tree. As we can see, we will have a total of ‘31’ recursive calls – calculated through (2^n) + (2^n) - 1, which is asymptotically equivalent to O(2^n).

#### Space Complexity

The space complexity is O(n). This space will be used to store the recursion stack. Since the recursive algorithm works in a depth-first fashion, which means that we can’t have more than ‘n’ recursive calls on the call stack at any time.

### Top-down Dynamic Programming with Memoization

Memoization is when we store the results of all the previously solved sub-problems and return the results from memory if we encounter a problem that has already been solved.

Since we have two changing values (`capacity` and `currentIndex`) in our recursive function `knapsackRecursive()`, we can use a two-dimensional array to store the results of all the solved sub-problems. As mentioned above, we need to store results for every sub-array (i.e. for every possible index ‘i’) and for every possible capacity ‘c’.

#### Time Complexity - Top-down Dynamic Programming with Memoization

Since our memoization array `dp[profits.length][capacity+1]` stores the results for all sub-problems, we can conclude that we will not have more than N\*C sub-problems (where ‘N’ is the number of items and ‘C’ is the knapsack capacity). This means that our time complexity will be O(N\*C).

#### Space Complexity - Top-down Dynamic Programming with Memoization

The above algorithm will use O(N\*C) space for the memoization array. Other than that we will use O(N) space for the recursion call-stack. So the total space complexity will be O(N\*C + N), which is asymptotically equivalent to O(N\*C).

### Bottom-up Dynamic Programming

Let’s try to populate our `dp[][]` array from the above solution by working in a bottom-up fashion. Essentially, we want to find the maximum profit for every sub-array and for every possible capacity. **This means that** `dp[i][c]` **will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items**.

So, for each item at index ‘i’ (0 <= i < items.length) and capacity ‘c’ (0 <= c <= capacity), we have two options:

1. Exclude the item at index ‘i’. In this case, we will take whatever profit we get from the sub-array excluding this item => `dp[i-1][c]`
2. Include the item at index ‘i’ if its weight is not more than the capacity. In this case, we include its profit plus whatever profit we get from the remaining capacity and from remaining items => `profit[i] + dp[i-1][c-weight[i]]`

Finally, our optimal solution will be maximum of the above two values:

```plaintext
    dp[i][c] = max (dp[i-1][c], profit[i] + dp[i-1][c-weight[i]])
```

#### Time Complexity - Bottom-up Dynamic Programming

O(N∗C), where ‘N’ represents total items and ‘C’ is the maximum capacity.

#### Space Complexity - Bottom-up Dynamic Programming

O(N∗C), where ‘N’ represents total items and ‘C’ is the maximum capacity.

## Notes

## References
