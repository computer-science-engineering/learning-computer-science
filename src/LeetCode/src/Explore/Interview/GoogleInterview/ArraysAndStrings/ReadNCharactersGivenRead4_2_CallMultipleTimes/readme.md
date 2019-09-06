# Problem Definition

## Description

The API: `int read4(char *buf)` reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the `read4` API, implement the function `int read(char *buf, int n)` that reads *n* characters from the file.

**Note:** The `read` function may be called multiple times.

**Example 1:**

```plaintext
Given buf = "abc"
read("abc", 1) // returns "a"
read("abc", 2); // returns "bc"
read("abc", 1); // returns ""
```

**Example 2:**

```plaintext
Given buf = "abc"
read("abc", 4) // returns "abc"
read("abc", 1); // returns ""
```

## Notes

1. [LeetCode discussion - A simple Java code](https://leetcode.com/explore/interview/card/google/59/array-and-strings/436/discuss/49598/A-simple-Java-code)