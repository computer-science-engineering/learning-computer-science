# Problem Definition

## Description

The API: `int read4(char *buf)` reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the `read4` API, implement the function `int read(char *buf, int n)` that reads n characters from the file.

**Example 1:**

```plaintext
Input: buf = "abc", n = 4
Output: "abc"
Explanation: The actual number of characters read is 3, which is "abc".
```

**Example 2:**

```plaintext
Input: buf = "abcde", n = 5
Output: "abcde"
```

**Note:** The `read` function will only be called once for each test case.

## Notes

1. [LeetCode discussion - Accepted clean java solution](https://leetcode.com/explore/interview/card/google/59/array-and-strings/396/discuss/49557/Accepted-clean-java-solution)
1. LeetCode 0 ms top solution

    ```java
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int total = 0;
        while (n > 0) {

            int x =  read4(tmp);

            int itr = 0;
            if (n >=x) {
                itr = x;
                n -= x;
            } else {
                itr = n;
                n = 0;
            }
            for (int i =0; i < itr; i++) {
                buf[total++] = tmp[i];
            }
            if (x < 4) {
                break;
            }
        }
        return  total;
    }
    ```