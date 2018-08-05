# Problem Definition

## Description

Given an array of words and a width *maxWidth*, format the text such that each line has exactly *maxWidth* characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly *maxWidth* characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no **extra** space is inserted between words.

**Note:**

* A word is defined as a character sequence consisting of non-space characters only.
* Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
* The input array *words* contains at least one word.

**Example 1:**

```text
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

**Example 2:**

```text
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
```

**Example 3:**

```text
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
```

## Notes

1. [Code Sniper](https://codesniper.blogspot.com/2015/03/68-text-justification-leetcode.html)
1. [GitHub problem](https://github.com/leetcoders/LeetCode-Java/blob/master/TextJustification.java)
1. [post](https://siyang2leetcode.blogspot.com/2015/03/text-justification.html)
1. [Program Creek](https://www.programcreek.com/2014/05/leetcode-text-justification-java/)
1. [SO post](https://stackoverflow.com/questions/8524979/justify-text-in-java)
1. [LeetCode discussion - Simple Java Solution](https://leetcode.com/problems/text-justification/discuss/24876/Simple-Java-Solution)