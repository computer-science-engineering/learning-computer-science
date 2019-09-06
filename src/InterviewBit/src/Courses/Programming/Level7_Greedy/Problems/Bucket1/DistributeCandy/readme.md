# Problem Definition

## Description

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

**Sample Input:**

```plaintext
Ratings : [1 2]
```

**Sample Output:**

```plaintext
3
```

The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. So rating 2 candidate gets 2 candies. In total, `2 + 1 = 3` candies need to be given out.

## Notes

1. [ProgramCreek](https://www.programcreek.com/2014/03/leetcode-candy-java/)

    This problem can be solved in O(n) time.
    We can always assign a neighbor with 1 more if the neighbor has higher a rating value. However, to get the minimum total number, we should always start adding 1s in the ascending order. We can solve this problem by scanning the array from both sides. First, scan the array from left to right, and assign values for all the ascending pairs. Then scan from right to left and assign values to descending pairs.

1. [LeetCode discussion -  A simple solution](https://leetcode.com/problems/candy/discuss/42769/A-simple-solution)