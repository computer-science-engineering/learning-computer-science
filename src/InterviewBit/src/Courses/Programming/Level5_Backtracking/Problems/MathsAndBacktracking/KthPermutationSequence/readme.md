# Problem Definition

## Description

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

```text
1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
```

Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

Good questions to ask the interviewer:

* What if n is greater than 10. How should multiple digit numbers be represented in string? --> In this case, just concatenate the number to the answer. So if n = 11, k = 1, ans = "1234567891011"
* Whats the maximum value of n and k? --> In this case, k will be a positive integer thats less than INT_MAX. n is reasonable enough to make sure the answer does not bloat up a lot.

## Notes

1. [LeetCode discussion](https://leetcode.com/problems/permutation-sequence/discuss/22507/"Explain-like-I'm-five"-Java-Solution-in-O(n))
1. [ProgramCreek](https://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/)
1. [SO - BigInteger based factorial](https://stackoverflow.com/questions/891031/is-there-a-method-that-calculates-a-factorial-in-java/29550283#29550283)