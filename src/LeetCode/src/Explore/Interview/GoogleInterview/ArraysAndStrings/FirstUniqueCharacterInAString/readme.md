# Problem Definition

## Description

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Examples:**

```text
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```

**Note:** You may assume the string contain only lowercase letters.

## Notes

1. [LeetCode discussion - Java 7 lines solution 29ms](https://leetcode.com/explore/interview/card/google/59/array-and-strings/459/discuss/86348/Java-7-lines-solution-29ms)

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
1. LeetCode top submission

    ```java
    public int another_Amazing_solution(String s){
        if(s==null || s.length()==0) return -1;
        int index=Integer.MAX_VALUE;
        for(char ch='a';ch<='z';ch++) {
            if(s.indexOf(ch)!=-1 && s.indexOf(ch)==s.lastIndexOf(ch)) { //if char in string...and first and last indexOf same means unique
                index=Math.min(index,s.indexOf(ch));
            }
        }
        if(index!=Integer.MAX_VALUE) return index;
        return -1;
    }
    ```