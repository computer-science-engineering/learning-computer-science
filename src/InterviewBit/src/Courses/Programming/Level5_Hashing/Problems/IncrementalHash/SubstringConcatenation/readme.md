# Problem Definition

## Description

You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

```plaintext
S: "barfoothefoobarman"
L: ["foo", "bar"]
```

You should return the indices: [0,9]. Order does not matter.

## Notes

1. [LeetCode discussion - easy but sub-optimal solution](https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C++Java))
1. [LeetCode discussion - 12ms solution](https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13691/Java-12ms-beats-100#)
1. [LeetCode discussion - O(n) solution](https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13699/92-JAVA-O(N)-with-explaination)