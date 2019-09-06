# Problem Definition

## Description

A message containing letters from `A-Z` is being encoded to numbers using the following mapping:

```plaintext
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given a **non-empty** string containing only digits, determine the total number of ways to decode it.

**Example 1:**

```plaintext
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
```

**Example 2:**

```plaintext
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```

## Notes

1. [YT Video - Making Algorithms Simpler -MAS - Decode Ways | Dynamic Programming | Python | LeetCode](https://www.youtube.com/watch?v=Q12LpfsUweU)
1. [LeetCode discussion - DP Solution (Java) for reference](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/334/discuss/30357/DP-Solution-(Java)-for-reference)
1. [LeetCode discussion - Java clean DP solution with explanation](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/334/discuss/30358/Java-clean-DP-solution-with-explanation)
1. [LeetCode discussion - A concise dp solution](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/334/discuss/30384/A-concise-dp-solution)
1. [LeetCode discussion - Evolve from recursion to dp](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/334/discuss/30451/Evolve-from-recursion-to-dp)

    **Recursion O(2^n)**

    ```c++
    int numDecodings(string s) {
        return s.empty() ? 0: numDecodings(0,s);
    }
    int numDecodings(int p, string& s) {
        int n = s.size();
        if(p == n) return 1;
        if(s[p] == '0') return 0;
        int res = numDecodings(p+1,s);
        if( p < n-1 && (s[p]=='1'|| (s[p]=='2'&& s[p+1]<'7'))) res += numDecodings(p+2,s);
        return res;
    }
    ```

    **Memoization O(n)**

    ```c++
    int numDecodings(string s) {
        int n = s.size();
        vector<int> mem(n+1,-1);
        mem[n]=1;
        return s.empty()? 0 : num(0,s,mem);
    }
    int num(int i, string &s, vector<int> &mem) {
        if(mem[i]>-1) return mem[i];
        if(s[i]=='0') return mem[i] = 0;
        int res = num(i+1,s,mem);
        if(i<s.size()-1 && (s[i]=='1'||s[i]=='2'&&s[i+1]<'7')) res+=num(i+2,s,mem);
        return mem[i] = res;
    }
     ```

    **dp O(n) time and space, this can be converted from #2 with copy and paste.**

    ```c++
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n+1);
        dp[n] = 1;
        for(int i=n-1;i>=0;i--) {
            if(s[i]=='0') dp[i]=0;
            else {
                dp[i] = dp[i+1];
                if(i<n-1 && (s[i]=='1'||s[i]=='2'&&s[i+1]<'7')) dp[i]+=dp[i+2];
            }
        }
        return s.empty()? 0 : dp[0];
    }
    ```

    **dp constant space**

    ```c++
    int numDecodings(string s) {
        int p = 1, pp, n = s.size();
        for(int i=n-1;i>=0;i--) {
            int cur = s[i]=='0' ? 0 : p;
            if(i<n-1 && (s[i]=='1'||s[i]=='2'&&s[i+1]<'7')) cur+=pp;
            pp = p;
            p = cur;
        }
        return s.empty()? 0 : p;
    }
    ```

1. [LeetCode discussion - Java 2ms DP solution with detailed explanation and inline comments](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/334/discuss/30522/Java-2ms-DP-solution-with-detailed-explanation-and-inline-comments)

    The basic concept is to build up the number of ways to get to state `i` from all the previous states less than `i`. We can do this by initializing a cache with a size of `s.length() + 1`. We always set `waysToDecode[0]` to 1 because there is only 1 way to decode an empty string. We can then build up the number of ways to decode starting from the first value and work our way to the end.

    We only ever need to look at the character at `i - 1` because we can't have values greater than 26, so three digits is never possible. There are four possibilities to consider:

    1. The previous value is 0 and the current value is 0, we can't make progress, return 0.
    2. The current value is 0, we have to use the previous value, if it is greater than 2, we can't make progress, return 0, otherwise we have to transition to this state from `waysToDecode[i - 1]`.
    3. The previous value is 0, we can't use the previous, so the only way to transition to the current state is from the previous, so use `waysToDecode[i]`.
    4. Lastly, both previous and `curr` can be used so there are two ways to transition to the current state, thus at `waysToDecode[i + 1]` we can get here by using all the ways we can get to `waysToDecode[i]` + all the ways to get to `waysToDecode[i - 1]`.

    Keep in mind that the indices are adjusted for the cache because its size differs from the string size.

    ```java
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) - '0' == 0) {
            return 0;
        }

        int[] waysToDecode = new int[s.length() + 1];
        waysToDecode[0] = 1;
        waysToDecode[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';

            // can't make progress, return 0
            if (prev == 0 && curr == 0 || (curr == 0 && (prev * 10 + curr > 26))) {
                return 0;
            }
            // can't use the previous value, so can only get to this state from the previous
            else if (prev == 0 || (prev * 10 + curr) > 26) {
                waysToDecode[i + 1] = waysToDecode[i];
            }
            // can't use current state, can only get to this state from i - 1 state
            else if (curr == 0) {
                waysToDecode[i + 1] = waysToDecode[i - 1];
            }
            // can get to this state from the previous two states
            else {
                waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
            }
        }
        return waysToDecode[waysToDecode.length - 1];
    }
    ```