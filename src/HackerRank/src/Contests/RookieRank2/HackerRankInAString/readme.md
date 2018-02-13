# HackerRank In A String

## Origin

[Link](https://www.hackerrank.com/contests/rookierank-2/challenges/hackerrank-in-a-string/problem)

## Description

We say that a string, s, contains the word hackerrank if a [subsequence](https://en.wikipedia.org/wiki/Subsequence) of the characters in  spell the word hackerrank. For example, haacckkerrannkk does contain hackerrank, but haacckkerannk does not (the characters all appear in the same order, but it's missing a second r).

More formally, let  be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If  is true, then  contains hackerrank.

You must answer  queries, where each query consists of a string, . For each query, print YES on a new line if contains hackerrank; otherwise, print NO instead.

### Input Format

The first line contains an integer denoting  (the number of queries). Each line of the  subsequent lines contains a single string denoting s.

### Constraints

### Output Format

For each query, print YES on a new line if  contains hackerrank; otherwise, print NO instead.

### Sample Input 0

```text
2
hereiamstackerrank
hackerworld
```

### Sample Output 0

```text
YES
NO
```

### Explanation 0

We perform the following  queries:

s = hereiamstackerrank: The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we print YES on a new line.

s = hackerworld does not contain the last three characters of hackerrank, so we print NO on a new line.

## Companies

## Categories

1. Contests
1. RookieRank 2

## Tags

## Notes