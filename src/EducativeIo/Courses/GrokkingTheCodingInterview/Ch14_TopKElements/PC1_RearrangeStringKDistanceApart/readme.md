# Problem Definition

## Description

Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.

Example 1:

```plaintext
Input: "mmpp", K=2
Output: "mpmp" or "pmpm"
Explanation: All same characters are 2 distance apart.
```

Example 2:

```plaintext
Input: "Programming", K=3
Output: "rgmPrgmiano" or "gmringmrPoa"
Explanation: All same characters are 3 distance apart.
```

Example 3:

```plaintext
Input: "aab", K=2
Output: "aba"
Explanation: All same characters are 2 distance apart.
```

Example 4:

```plaintext
Input: "aappa", K=3
Output: ""
Explanation: We cannot find an arrangement of the string where any two 'a' are 3 distance apart.
```

## Discussion

### Approach

This problem follows the **Top ‘K’ Numbers** pattern and is quite similar to **Rearrange String**. The only difference is that in the ‘Rearrange String’ the same characters need not be adjacent i.e., they should be at least ‘2’ distance apart (in other words, there should be at least one character between two same characters), while in the current problem, the same characters should be ‘K’ distance apart.

Following a similar approach, since we were inserting a character back in the heap in the next iteration, in this problem, we will re-insert the character after ‘K’ iterations. We can keep track of previous characters in a queue to insert them back in the heap after ‘K’ iterations.

#### Time Complexity

The time complexity of the above algorithm is O(N*logN) where ‘N’ is the number of characters in the input string.

#### Space Complexity

The space complexity will be O(N), as in the worst case, we need to store all the ‘N’ characters in the HashMap.

## Notes

## References
