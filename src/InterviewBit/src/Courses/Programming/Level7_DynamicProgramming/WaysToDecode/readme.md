# Problem Definition

## Description

A message containing letters from `A-Z` is being encoded to numbers using the following mapping:

```text
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given an encoded message containing digits, determine the total number of ways to decode it.

**Example:**

Given encoded message `"12"`, it could be decoded as `"AB"` `(1 2)` or `"L"` `(12)`.

The number of ways decoding `"12"` is `2`.

## Notes

1. [LeetCode discussion - DP Solution (Java) for reference]("https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference")
    ```java
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
    ```
    **Explanation 1:**

     Assigning `memo[n] = 1;` means when the string is empty, there is only one answer. `memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;` means when there is only one character in the string, if this character is not 0, there will be an answer, or there will be no answer. Then it starts the dp portion. When we add a letter from the end of the string, if the first two letters <=26, we can get `memo[n]=memo[n+1]+memo[n+2]`. For example, the String now is “123xxxx” and we know all the result from 2. Because 12<26, we can make this string either"12"+“3xxxx” or 1+23xxxx which is exactly `memo[n]=memo[n-1]+memo[n-2]`. if the String is"32xxxx" `memo[n]=memo[n+1]`. if there are 0s in the string, we should skip it and look at the next character because there is no answer when the string begins with 0.

    **Explanation 2:**
    ```text
    s = 123

    build up from right =>

    num_ways ("") => 1 (empty string can be represented by empty string) (i.e. num_ways[n] = 1) NOTE: only for build up with a valid string. Empty string on it's own doesn't need to be decoded.
    num_ways ("3") => 1 (only one way), i.e. num_ways[n-1] = 1
    num_ways ("23") => "23" or "2"-"3",
    num_ways ("33") => "3""3"
    num_ways ("123") => "12"(num_ways("3")) + "1"("num_ways("23")) (i.e. num_ways[i+2] + num_ways[i+1])
    num_ways ("323") => "3"(num_ways("23")) (i.e. num_ways[i+1])

    so basically if s[i:i+1] (both included) <= 26, 
    num_ways[i+2] + num_ways[i+1]
    else:
    num_ways[i+1]

    case with 0:

    num_ways ("103")
    num_ways ("3") => 1 (only one way)
    num_ways ("03") => 0 (can't decode 0)
    num_ways ("003") => "00"(num_ways("3")) + "0"(num_ways("03")) => no way to decode "00" = 0 + 0
    num_ways ("103") => "10"(num_ways("3")) + "1"(num_ways("03")) => num_ways[i+2] + num_ways[i+1](= 0 in this case)
    num_ways ("1003") => "10"(num_ways("03")) + "1"(num_ways("003")) => same eq = 0(no way to decode "03") + 0(no way to decode 003)

    Therefore, if i = '0', let memo[i] = 0, also implements for a string where the ith character == '0', string[i:end] can be decoded in 0 ways.
    ```
1. [LeetCode discussion - Java clean DP solution with explanation](https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation)

    I used a dp array of size n + 1 to save sub-problem solutions. dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1. I then check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.