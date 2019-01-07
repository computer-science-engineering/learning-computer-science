# Problem Definition

## Description

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example 1:**

```text
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

**Example 2:**

```text
Input: "cbbd"
Output: "bb"
```

## Notes

1. [Geeks for Geeks - Longest Palindromic Substring | Set 1](http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/)
1. [Geeks for Geeks - Longest Palindromic Substring | Set 2](http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/)
1. [YT Video - Vivekanand Khyade - Longest Palindromic Subsequence and it's Length (ALGORITHM -DYNAMIC PROGRAMMING)](https://www.youtube.com/watch?v=yZWmS6CXbQc)
1. [YT Video - Tushar Roy - Longest Palindromic Substring Manacher's Algorithm](https://www.youtube.com/watch?v=V-sEwsca1ak)
1. [YT Video - Tushar Roy - Longest Palindromic Subsequence](https://www.youtube.com/watch?v=_nCsPn7_OgI)
1. [LeetCode discussion - Java easy-understanding solution. Beats 97%](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/451/discuss/3003/Java-easy-understanding-solution.-Beats-97)

    ```java
    public String longestPalindrome(String s) {
        char[] ca = s.toCharArray();
        int rs = 0, re = 0;
        int max = 0;
        for(int i = 0; i < ca.length; i++) {
            if(isPalindrome(ca, i - max - 1, i)) {
                rs = i - max - 1; re = i;
                max += 2;
            } else if(isPalindrome(ca, i - max, i)) {
                rs = i - max; re = i;
                max += 1;
            }
        }
        return s.substring(rs, re + 1);
    }

    private boolean isPalindrome(char[] ca, int s, int e) {
        if(s < 0) return false;

        while(s < e) {
            if(ca[s++] != ca[e--]) return false;
        }
        return true;
    }
    ```

1. [LeetCode discussion - (AC) relatively short and very clear Java solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/451/discuss/3060/(AC)-relatively-short-and-very-clear-Java-solution)

    Key idea, every time we move to right, we only need to consider whether using this new character as tail could produce new palindrome string of length (current length +1) or (current length +2)

    ```java
    public class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            int currentLength = 0;
            for(int i=0;i<s.length();i++){
                if(isPalindrome(s,i-currentLength-1,i)){
                    res = s.substring(i-currentLength-1,i+1);
                    currentLength = currentLength+2;
                }
                else if(isPalindrome(s,i-currentLength,i)){
                    res = s.substring(i-currentLength,i+1);
                    currentLength = currentLength+1;
                }
            }
            return res;
        }

        public boolean isPalindrome(String s, int begin, int end){
            if(begin<0) return false;
            while(begin<end){
                if(s.charAt(begin++)!=s.charAt(end--)) return false;
            }
            return true;
        }
    }
    ```

    For friends who are confused about the key idea to check only new palindrome with length = current length +2 or +1, I add some more explanation here.

    ```text
    Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we 
            are dealing with the last character 'a'. The current longest palindrome
            is "bcb" with length 3.
    1. check "xxxxa" so if it is palindrome we could get a new palindrome of length 5.
    2. check "xxxa" so if it is palindrome we could get a new palindrome of length 4.
    3. do NOT check "xxa" or any shorter string since the length of the new string is 
    no bigger than current longest length.
    4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome 
    then "xxxx" got  from cutting off the head and tail is also palindrom. It has 
    length > 3 which is impossible.'
    ```

1. [LeetCode discussion - Share my Java solution using dynamic programming](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/451/discuss/2921/Share-my-Java-solution-using-dynamic-programming)

    `dp(i, j)` represents whether `s(i ... j)` can form a palindromic substring, `dp(i, j)` is true when `s(i)` equals to `s(j)` and `s(i+1 ... j-1)` is a palindromic substring. When we found a palindrome, check if it's the longest one. Time complexity `O(n^2)`.

    ```java
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        int palindromeStartsAt = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

        for(int i = n-1; i >= 0; i--) { // keep increasing the possible palindrome string
            for(int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

                //check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                           &&
                           ( j-i < 3  // if window is less than or equal to 3, just end chars should match
                             || dp[i+1][j-1]  ); // if window is > 3, substring (i+1, j-1) should be palindrome too

                //update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
    }
    ```
1. [LeetCode solution](https://leetcode.com/problems/longest-palindromic-substring/solution/)
1. LeetCode sample submission - 4 ms

    ```java
    int max = 0;
    int low = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;

        char[] array = s.toCharArray();
        int n = array.length;

        for(int mid = 0; mid < n; mid++) {
            mid = longestPalindrome(mid, array, n);
        }

        return s.substring(low, low+max);
    }

    // Finds longest palindrome where mid index is at mid.
    private int longestPalindrome(int mid, char[] array, int n) {
        int left = mid-1;
        while (mid < n-1 && array[mid] == array[mid+1]) mid++; // All same chars are part of mid
        int right = mid+1;

        while (left >= 0 && right < n && array[left] == array[right]) {
            left--;
            right++;
        }

        int len = right-left-1;
        if (len > max) {
            max = len;
            low = left+1;
        }
        return mid;
    }
    ```