# Problem Definition

## Description

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

**Sample Input:**

```text
Ratings : [1 2]
```

**Sample Output:**

```text
3
```

The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. So rating 2 candidate gets 2 candies. In total, `2 + 1 = 3` candies need to be given out.

## Notes

1. [ProgramCreek](https://www.programcreek.com/2014/03/leetcode-candy-java/)
1. [LeetCode discussion -  A simple solution](https://leetcode.com/problems/candy/discuss/42769/A-simple-solution)