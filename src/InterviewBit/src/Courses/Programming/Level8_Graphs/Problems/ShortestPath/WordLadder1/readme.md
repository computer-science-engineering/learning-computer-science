# Problem Definition

## Description

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

* You must change exactly one character in every transformation
* Each intermediate word must exist in the dictionary

**Example:**

Given:

```text
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
```

As one shortest transformation is `"hit" -> "hot" -> "dot" -> "dog" -> "cog"`, return its length `5`.

Note that we account for the length of the transformation path instead of the number of transformation itself.

**Note:**

* Return 0 if there is no such transformation sequence.
* All words have the same length.
* All words contain only lowercase alphabetic characters.

## Notes

1. [LeetCode discussion - Another accepted Java solution (BFS)](https://leetcode.com/problems/word-ladder/discuss/40717/Another-accepted-Java-solution-(BFS))
1. [LeetCode discussion - Two-end BFS in Java 31ms.](https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.)
1. [GitHub - nagajyothi](https://github.com/nagajyothi/InterviewBit/blob/master/Graphs/WordLadder1.java)