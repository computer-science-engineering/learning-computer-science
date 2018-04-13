# Problem Definition

## Description

What is the worst case time complexity of the following code:

```C++
int memo[101][101];
int findMinPath(vector<vector<int> >& V, int r, int c) {
    int R = V.size();
    int C = V[0].size();
    if (r >= R || c >= C) return 100000000; // Infinity
    if (r == R - 1 && c == C - 1) return 0;
    if (memo[r][c] != -1) return memo[r][c];
    memo[r][c] =  V[r][c] + min(findMinPath(V, r + 1, c), findMinPath(V, r, c + 1));
    return memo[r][c];
}

Callsite :
memset(memo, -1, sizeof(memo));
findMinPath(V, 0, 0);
```

Assume R = V.size() and C = V[0].size() and V has positive elements

**NOTE:** This question involves recursion which will be explained later in topic Backtracking. So, if you are not able to approach this question now, you can give it a try later.

### Choices

* O(2^(R + C))
* O(R*C)
* O(R + C)
* O(R*R + C*C)
* O(R*C*log(R*C))

### Answer

O(R*C)

Note that for a given `(r, c)`

the following code will not be executed more than once :

```text
memo[r][c] =  V[r][c] + min(findMinPath(V, r + 1, c), findMinPath(V, r, c + 1));
```

Once memo[r][c] is set, the functions will return at

```text
if (memo[r][c] != -1) return memo[r][c];
```

So, every function ends up calling other functions at most 1 time. In other words, every function ends up executing at most O(1) times (Note that you can shift the part about checking for memo[r][c] != -1 at the callsite).

`O(R * C)` possible number of combinations are possible for `(r, c)`

Hence, the time complexity of the function : O(R*C)

## Notes