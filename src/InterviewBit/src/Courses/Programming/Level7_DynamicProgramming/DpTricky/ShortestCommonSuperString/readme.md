# Problem Definition

## Description

Given a set of strings. Find the length of smallest string which has all the strings in the set as substring

**Constraints:**

1. 1 <= Number of strings <= 18
1. Length of any string in the set will not exceed 100.

**Example:**

Input: [“abcd”, “cdef”, “fgh”, “de”]

Output: 8 (Shortest string: “abcdefgh”)

## Notes

1. [Geeks for Geeks - Shortest Common SuperSequence](https://www.geeksforgeeks.org/shortest-common-supersequence/)
1. [YT Video - Tushar Roy - Longest Common Subsequence](https://www.youtube.com/watch?v=NnD96abizww)
1. [YT Video - Vivekanand Khyade - Longest Common Subsequence Dynamic Programming : Interview question](https://www.youtube.com/watch?v=43P0xZp3FU4)

### Solution approach

#### Brute force

Let’s say we have only two strings say s1 and s2, the possible cases are:

* They do not overlap [ans = len(s1) + len(s2) ]
* They overlap partially [ans = len(s1)+len(s2)-len(max. overlapping part)]
* They overlap completely [ans = max(len(s1), len(s2)]

What we can see here is we can easily combine two strings. In the brute force, we could take all the permutations of numbers [1 .. N], then combine the strings in that order.

e.g: strings = [s1, s2, s3], order = [2,3,1]

Steps are: [s1, s2,s3] –> [s2+s3, s1] –> [s1+s2+s3].

(Here addition of strings is according to the method described above.)

I would advice you to completely digest that this will give the optimal solution whatever the case may be. Considering all the permutations is optimal but time consuming.

#### Dynamic programming

We have dynamic programming to our rescue in this case. You can see that there is a optimal substructure and overlapping sub-problems in the brute force algorithm described above. Well if you can’t already see, let me help you out.

Example:

Input = [s1, s2, s3, s4]

Order 1 = [2,3,1,4] , Steps: [s2+s3, s1, s4] –> [s2+s3+s1, s4] –> [s1+s2+s3+s4]

Order 2 = [1,3,2,4] , Steps: [s1+s3, s2, s4] –> [s1+s2+s3, s4] –> [s1+s2+s3+s4]

Do you see here that Order1 and Order2 both calculated the optimal solution for set of strings [s1, s2, s3]

(Intermediate string s1+s2+s3 is the optimal solution for this set)

Hurrah! Time to think Dynamically.

#### Bitmasking in DP

Well, this kind of DP formulations require a specific technique called Bitmasking. It is not the conventional type and in this case T(N) = C CNN + CN*(2^N) (Still better than O(N!) right).

Formulation:

dp[i][mask] = Optimal solution for set of strings corresponding to 1’s in the mask where the last added string to our solution is i-th string.

Recurrence:

dp[i][mask] = min(dp[x][mask ^ (1«i)] where {mask | (1«x) = 1} )

I recommend you reading about the Bitmask in DP if you still have the doubt.