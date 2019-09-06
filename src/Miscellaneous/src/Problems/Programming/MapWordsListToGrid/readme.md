# Problem Definition

## Description

Write a program to find all words of length 2 characters or longer (ignore single character words) from a word list file (such as /usr/share/dict/words or /usr/dict/words) that can be found in a 4x4 grid of letters. The grid should be given as input to the program. Specify the grid as one 16-character argument  to the program.

The program interface should be of the form
% a.out /usr/share/dict/words abcdefghijklmnop

Results should be printed to standard output.   Your output should be a list of matching words separated by newlines. Don't print out anything else unless your program is reporting an error condition.

**A word cannot use a specific letter at a specific grid location more than once (the same grid location may only be used once).**

The grid represented by "abcdefghijklmnop" would be

```plaintext
a b c d
e f g h
i j k l
m n o p
```

### Problem Details

A word can be found in a grid by starting on any letter, then moving to an adjacent letter and so on.

```plaintext
Example 1.
a b a n
z q z d
r r o r
r n r r
```

The word "abandon" fits in the grid first horizontally, then diagonally down and to the left. The word "ran" does NOT fit in the grid because 'r' and 'a' are not adjacent.

```plaintext
Example 2.
z z z z
z z b z
h z e z
a z z z
```

Contains the words "be", "ha", and "ah". It should not contain "bee" or "ebb" or "he" or "hah".

### Implementation Details

Your program should not print any word more than once. Your program can assume that the word list file contains no duplicated words and that the input arguments are valid.

Your program should be tolerant of word files that contain a mixture of upper and lower case words and of words that contain punctuation. Your program can deal with such words in some reasonable way. Note that different word list files can be alphabetized differently.

If you use C++, we ask that you do not use the Standard Template Library containers and iterators; we would like to see your own data structures and algorithms. (Exception: you can use std::string.)

Please do not copy or examine any of your or other people's existing code while writing this program. Please write it from scratch. (Exception: you may use the file I/O code you wrote as part of the prerequisites mentioned previously.) We realize your program will just be a prototype. We do not expect this to be production quality software, nor is it embedded code (you need not restrict yourself to embedded programming practices.)

Work quickly, but accurately because we take into consideration how fast you're able to write the program. However, the most important thing is to make sure your program works correctly.

Strive for simplicity in your code and data structures. A simple, concise program is more impressive than a long, complicated one and also easier to write quickly.

## Notes

1. [Geeks for Geeks - Boggle (Find all possible words in a board of characters) | Set 1](https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/)
1. [GitHub - Learning Computer Science -  WordSearchBoard](https://github.com/manastalukdar/learning-computer-science/tree/master/src/InterviewBit/src/Courses/Programming/Level8_Graphs/Problems/GraphTraversal/WordSearchBoard)