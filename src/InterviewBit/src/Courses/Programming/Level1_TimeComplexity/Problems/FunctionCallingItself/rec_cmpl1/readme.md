# Problem Definition

## Description

What is the worst case time complexity of the following code:

```C++
/*
 * V is sorted
 * V.size() = N
 * The function is initially called as searchNumOccurrence(V, k, 0, N-1)
 */
int searchNumOccurrence(vector<int> &V, int k, int start, int end) {
    if (start > end) return 0;
    int mid = (start + end) / 2;
    if (V[mid] < k) return searchNumOccurrence(V, k, mid + 1, end);
    if (V[mid] > k) return searchNumOccurrence(V, k, start, mid - 1);
    return searchNumOccurrence(V, k, start, mid - 1) + 1 + searchNumOccurrence(V, k, mid + 1, end);
}
```

**NOTE:** This question involves recursion which will be explained later in topic Backtracking. So, if you are not able to approach this question now, you can give it a try later.

### Choices

* O(sqrt N)
* O(log N)
* O(log^2 N )
* O(N)
* O(N * log N)
* O(N * sqrt N)

### Answer

O(N)

It might seem at the first look that the program is O(log N).
However, the last case

```plaintext
return searchNumOccurrence(V, k, start, mid - 1) + 1 + searchNumOccurrence(V, k, mid + 1, end);
```

is the bottleneck step.
Assuming all the values in the array are the same, we get the following relation :

```plaintext
T(N) = 2 * T(N/2) + constant
     = 4 * T(N/4) + constant     ( 2 * constant = another constant )
     = 8 * T(N/8) + constant
     ...
     = N * T(N/N) + constant
     = N + constant
     = O(N)
```

## Notes