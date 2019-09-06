# Problem Definition

## Description

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Examples:**

```plaintext
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```

**Note:** You may assume the string contain only lowercase letters.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/first-unique-character-in-a-string/solution/)
1. [LeetCode discussion - Java 7 lines solution 29ms](https://leetcode.com/problems/first-unique-character-in-a-string/discuss/86348/Java-7-lines-solution-29ms)

    Hey guys. My solution is pretty straightforward. It takes O(n) and goes through the string twice:

    Get the frequency of each character.
    Get the first character that has a frequency of one.
    Actually the code below passes all the cases. However, according to @xietao0221, we could change the size of the frequency array to 256 to store other kinds of characters. Thanks for all the other comments and suggestions. Fight on!

    ```java
    public class Solution {
        public int firstUniqChar(String s) {
            int freq [] = new int[26];
            for(int i = 0; i < s.length(); i ++)
                freq [s.charAt(i) - 'a'] ++;
            for(int i = 0; i < s.length(); i ++)
                if(freq [s.charAt(i) - 'a'] == 1)
                    return i;
            return -1;
        }
    }
    ```