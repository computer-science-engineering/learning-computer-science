# Problem Definition

## Description

Given two words `A` and `B`, find the minimum number of steps required to convert `A` to `B`. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

**Example :**

edit distance between
`"Anshuman"` and `"Antihuman"` is 2.

* Operation 1: Replace s with t.
* Operation 2: Insert i.

## Notes

1. [LeetCode discussion - Java DP solution - O(nm)](https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm))

    Let following be the function definition :-

    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

    Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

    f(i, j) = f(i - 1, j - 1)

    Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

    f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

    * f(i, j - 1) represents insert operation
    * f(i - 1, j) represents delete operation
    * f(i - 1, j - 1) represents replace operation

    Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.

    Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.

    Above equations become the recursive definitions for DP.

    Base Case:

    f(0, k) = f(k, 0) = k