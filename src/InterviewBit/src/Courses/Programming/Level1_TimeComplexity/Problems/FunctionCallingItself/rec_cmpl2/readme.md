# Problem Definition

## Description

What is the worst case time complexity of the following code:

```C++
/*
 * V is sorted
 * V.size() = N
 * The function is initially called as searchNumOccurrence(V, k, 0, N-1)
 */
int findMinPath(vector<vector<int> > &V, int r, int c) {
    int R = V.size();
    int C = V[0].size();
    if (r >= R || c >= C) return 100000000; // Infinity
    if (r == R - 1 && c == C - 1) return 0;
    return V[r][c] + min(findMinPath(V, r + 1, c), findMinPath(V, r, c + 1));
}
```

Assume R = V.size() and C = V[0].size().

**NOTE:** This question involves recursion which will be explained later in topic Backtracking. So, if you are not able to approach this question now, you can give it a try later.

### Choices

* O(2^(R + C))
* O(R*C)
* O(R + C)
* O(R*R + C*C)
* O(R*C*log(R*C))

### Answer

O(2^(R + C))

Note that in every function call, we end up making 2 calls.

So, the function calls ends up looking like a tree :

```plaintext
                   F(0,0)
                /          \
            F(0, 1)         F(1, 0)
             /    \         /       \
          F(0, 2)  F(1,1)  F(1, 1)  F(2, 0)
             ....
```

The function calls end up making a complete binary tree.

```plaintext
  Number of calls on Level 0 = 1
  Number of calls on Level 1 = 2
  Number of calls on Level 2 = 4
  ...
  Number of calls on level i = 2^i.
```

```plaintext
Total number of calls = 1 + 2 + 4 + ... 2^i + ... 2^(M + N - 2)
                      = O(2^(M + N))
```

## Notes