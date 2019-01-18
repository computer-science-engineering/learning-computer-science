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
1. [LeetCode discussion - Bit Manipulation, Java, 6ms](https://leetcode.com/explore/interview/card/google/66/others-4/458/87464/Bit-Manipulation-Java-6ms/92375)

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

1. [LeetCode discussion - Simple one pass concise Java solution beating 99%](https://leetcode.com/explore/interview/card/google/66/others-4/458/discuss/87496/Simple-one-pass-concise-Java-solution-beating-99)

   ```java
   public boolean validUtf8(int[] data) {
      int varCharLeft = 0;
      for (int b: data) {
         if (varCharLeft == 0) {
            if ((b & 0b010000000) == 0)  varCharLeft = 0;
            else if ((b & 0b011100000) == 0b11000000)  varCharLeft = 1;
            else if ((b & 0b011110000) == 0b11100000)  varCharLeft = 2;
            else if ((b & 0b011111000) == 0b11110000)  varCharLeft = 3;
            else return false;
         } else {
            if ((b & 0b011000000) != 0b10000000)  return false;
            varCharLeft--;
         }
      }
      return varCharLeft==0;
   }
   ```

1. [LeetCode discussion - O(n) JAVA solution, with detailed explaination](https://leetcode.com/explore/interview/card/google/66/others-4/458/discuss/87485/O(n)-JAVA-solution-with-detailed-explaination)

   ```java
   public class Solution {
      /*
      * Thought-way:
      * As long as every byte in the array is of right type, it is a valid UTF-8 encoding.
      * 
      * Method:
      * Start from index 0, determine each byte's type and check its validity.
      *
      * There are five kinds of valid byte type: 0**, 10**, 110**,1110** and 11110**
      * Give them type numbers, 0, 1, 2, 3, 4 which are the index of the first 0 from left.
      * So, the index of the first 0 determines the byte type.
      *
      * if a byte belongs to one of them:
         1 : if it is type 0, continue
         2 : if it is type 2 or 3 or 4, check whether the following 1, 2, and 3 byte(s) are of type 1 or not
                  if not, return false;
      * else if a byte is type 1 or not of valid type, return false
      *
      * Analysis :
      * The faster you can determine the type, the quicker you can get.
      * Time O(n), space O(1)
      * real performance: 7ms
      */

      // Hard code "masks" array to find the index of the first appearance of 0 in the lower 8 bits of each integer.
      private int[] masks = {128, 64, 32, 16, 8};
      public boolean validUtf8(int[] data) {
         int len = data.length;
         for (int i = 0; i < len; i ++) {
               int curr = data[i];
               int type = getType(curr);
               if (type == 0) {
                  continue;
               } else if (type > 1 && i + type <= len) {
                  while (type-- > 1) {
                     if (getType(data[++i]) != 1) {
                           return false;
                     }
                  }
               } else {
                  return false;
               }
         }
         return true;
      }

      public int getType(int num) {
         for (int i = 0; i < 5; i ++) {
               if ((masks[i] & num) == 0) {
                  return i;
               }
         }
         return -1;
      }
   }
   ```