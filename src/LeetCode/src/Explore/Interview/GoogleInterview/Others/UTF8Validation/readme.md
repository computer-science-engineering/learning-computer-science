# Problem Definition

## Description

A character in UTF8 can be from **1 to 4 bytes** long, subjected to the following rules:

1. For 1-byte character, the first bit is a 0, followed by its unicode code.
2. For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.

This is how the UTF-8 encoding would work:

```text
   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
```

Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

**Note:** The input is an array of integers. Only the **least significant 8 bits** of each integer is used to store the data. This means each integer represents only 1 byte of data.

**Example 1:**

```text
data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
```

**Example 2:**

```text
data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/utf-8-validation/solution/)
1. [Geeks for Geeks - Understanding Character Encoding](https://www.geeksforgeeks.org/understanding-character-encoding/)
1. [The Fake Geek's blog - UTF-8 Validation](http://shirleyisnotageek.blogspot.com/2016/10/utf-8-validation.html)
1. [LeetCode discussion - Bit Manipulation, Java, 6ms](https://leetcode.com/problems/utf-8-validation/discuss/87464/Bit-Manipulation-Java-6ms/92375)

   ```text
   Rule 2:
   Record the count of consecutive of 1.
   Move the number 5 bit right, if it equals "110" means there is one '1'.
   Move the number 4 bit right, if it equals "1110" means there are two '1'.
   ...
   Move the number 7 bit right, if it equals "1" means it is "10000000" which has no meaning, return false.

   Rule 1:
   If it is not started with "10", return false;
   ```