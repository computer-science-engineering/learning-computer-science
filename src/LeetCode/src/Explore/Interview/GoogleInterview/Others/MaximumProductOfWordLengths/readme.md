# Problem Definition

## Description

Given a string array `words`, find the maximum value of `length(word[i]) * length(word[j])` where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

**Example 1:**

```text
Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
```

**Example 2:**

```text
Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
```

**Example 3:**

```text
Input: ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
```

## Notes

1. [LeetCode discussion - JAVA----------Easy Version To Understand](https://leetcode.com/explore/interview/card/google/66/others-4/460/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!)

    **Explanation for `value[i] |= 1 << (tmp.charAt(j) - 'a');`**

    int has 32bits,but lower case letters only has 26 .we can use the lowest 26 bit of int indicates that the word has how many kinds of lower case letters .If the lowest bit of int is 1,it indicates the word has lower case letter 'a'.......the order of lower case letter is from right to left,like zyx.....cba.so value[i] indicates the condition of the word i having how many kinds of lower case letters. [ref](https://leetcode.com/explore/interview/card/google/66/others-4/460/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!/80816)

    value[i] stores an integer equivalent of a bit representation that corresponds to the existence of chars in words[i]. To store this info. in value[i], the above code left shifts 1 by an offset of ASCII value of char - ASCII value of 'a' i.e. chars a through z could represented as 0 through 25. E.g. if a word is "ab", then in the first iteration of j's for loop, we will set value[i] = 1 i.e. (0000 0001). In the next iteration the char we are looking at is 'b', and we want to save this info while preserving what we already have and to do so we use OR operations and value becomes 0000 0011. I hope it answers your question. [ref](https://leetcode.com/explore/interview/card/google/66/others-4/460/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!/145602)

    The reason use 1<< is that let the value of 'a' to be 1? Yes, otherwise, 'a' will be missed since 'a' - 'a' = 0. [ref](https://leetcode.com/explore/interview/card/google/66/others-4/460/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!/80814)

1. LeetCode sample submission - 10 ms

    ```java
    public int maxProduct(String[] words) {
        //9:33
        int[] keys = new int[words.length];
        for (int i=0; i<words.length; i++) {
            keys[i] = getKey(words[i]);
        }

        int max = 0;
        for (int i=0; i<words.length-1; i++) {
            for (int j=i+1; j<words.length; j++) {
                if ((keys[i] & keys[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    private int getKey(String s) {
        int key = 0;
        for (int i=0; i<s.length(); i++) {
            key |= (0x1 << (s.charAt(i)-'a'));
        }
        return key;
    }
    ```