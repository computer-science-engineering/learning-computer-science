# Problem Definition

## Description

Given two words _word1_ and _word2_, find the minimum number of operations required to convert _word1_ to _word2_.

You have the following 3 operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character

**Example 1:**

```plaintext
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

**Example 2:**

```plaintext
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/edit-distance/solution/)
1. [YT Video - Back To Back SWE - Edit Distance Between 2 Strings - The Levenshtein Distance ("Edit Distance" on LeetCode)](https://www.youtube.com/watch?v=MiqoA-yF-0M)
1. [YT Video - Tushar Roy - Minimum Edit Distance Dynamic Programming](https://www.youtube.com/watch?v=We3YDTzNXEk)
1. [YT Video - Sarthak Munshi - Minimum Edit Distance - Explained ! - Stanford University](https://www.youtube.com/watch?v=Xxx0b7djCrs)
1. [Stanford University class pdf on minimum edit](https://web.stanford.edu/class/cs124/lec/med.pdf)
1. [LeetCode discussion - Java DP solution - O(nm)](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/438/discuss/25849/Java-DP-solution-O(nm))

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

1. LeetCode sample submission - 5 ms

    ```java
    public int minDistance(String word1, String word2) {
        int len1 = word1.length() - 1;
        int len2 = word2.length() - 1;
        int[][] mems = new int[len1 + 1][len2 + 1];
        return dfs( word1, len1, word2, len2, mems);
    }

    private int dfs(String word1, int idx1, String word2, int idx2, int[][] mems){
        if (idx1 == -1) {
            return idx2 + 1;
        }
        if (idx2 == -1) {
            return idx1 + 1;
        }
        if (mems[idx1][idx2] > 0) {
            return mems[idx1][idx2];
        }
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            mems[idx1][idx2] = dfs(word1, idx1 - 1, word2, idx2 - 1, mems);
            return mems[idx1][idx2];
        } else {
            mems[idx1][idx2] = Math.min(dfs(word1, idx1 - 1, word2, idx2 - 1, mems), Math.min(dfs(word1, idx1, word2, idx2 - 1, mems), dfs(word1, idx1 - 1, word2, idx2, mems))) + 1;
            return mems[idx1][idx2];
        }
    }
    ```