# Problem Definition

## Description

In a competition, four different functions are observed. All the functions use a single for loop and within the for loop, same set of statements are executed.

Consider the following for loops:

```plaintext
  A) for(i = 0; i < n; i++)

  B) for(i = 0; i < n; i += 2)

  C) for(i = 1; i < n; i *= 2)

  D) for(i = n; i > -1; i /= 2)
```

If n is the size of input(positive), which function is the most efficient? In other words, which loop completes the fastest.

### Choices

* A
* B
* C
* D

### Answer

C

The time complexity of the first for loop is O(n).

The time complexity of the second for loop is O(n/2), equivalent to O(n) in asymptotic analysis.

The time complexity of the third for loop is O(logn).

The fourth for loop doesn’t terminate.

## Notes