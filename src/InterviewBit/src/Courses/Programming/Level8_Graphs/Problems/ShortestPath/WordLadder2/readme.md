# Problem Definition

## Description

Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:

* Only one letter can be changed at a time
* Each intermediate word must exist in the dictionary

If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

**Example:**

Given:

```plaintext
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
```

Return

```plaintext
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
```

**Note:**

* All words have the same length.
* All words contain only lowercase alphabetic characters.

## Notes

1. [GitHub - ismagilov](https://github.com/ismagilov/interviewbit/blob/f70118970261234c2c7932513094fff481c6856a/src/graphs/WordLadderII.java)
1. [GitHub - fakemonk1](https://github.com/fakemonk1/DataStructures-And-Algorithms-IB/blob/c94d48fc99282825ffb78144baddeeb990243145/src/graphs/WordLadder2.java)
1. [GitHub - nagajyothi](https://github.com/nagajyothi/InterviewBit/blob/master/Graphs/WordLadder2.java)
1. [LeetCode discussion - My concise JAVA solution based on BFS and DFS](https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS)