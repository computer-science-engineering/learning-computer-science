# Problem Definition

## Description

Write a function that takes a string as input and returns the string reversed.

**Example:**

Given s = "hello", return "olleh".

## Notes

1. [LeetCode discussion - [JAVA] Simple and Clean with Explanations [6 Solutions]](https://leetcode.com/problems/reverse-string/discuss/80937/JAVA-Simple-and-Clean-with-Explanations-6-Solutions)
1. LeetCode sample submission - 1 ms

    ```java
    public String reverseString(String s) {
        int n = s.length();
        char[] reversed = s.toCharArray();
        for (int i = 0; i < reversed.length / 2; i++){
            char c = reversed[i];
            reversed[i] = reversed[n-i-1];
            reversed[n-i-1] = c;
        }
        return String.valueOf(reversed);
    }
    ```