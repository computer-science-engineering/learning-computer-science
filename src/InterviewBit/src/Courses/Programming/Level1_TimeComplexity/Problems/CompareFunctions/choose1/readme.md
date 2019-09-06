# Problem Definition

## Description

Which of the following is not bounded by O(n^2)?

### Choices

* (15^10) * n + 12099
* n^1.98
* n^3 / (sqrt(n))
* (2^20) * n

### Answer

n^3 / (sqrt(n))

The order of growth of option (C) is n^2.5 which is higher than n^2.

Lets look at it with a different approach :

```plaintext
f(n) = O(n^2) if
f(n) <= C * n^2 for n > n0.
```

Lets look at every option one by one.

* Option 1 :

    ```plaintext
    (15^10) * n + 12099
    Lets say C = 16^10
        15^10 * n + 12099 < 16^10 * n^2 for n > 1.
    So, it is O(n^2).
    ```

* Option 2 : n^1.98

    ```plaintext
    C = 1.
        n^1.98 < n^2 for n > 1.
    So, its O(n^2)
    ```

* Option 3 : n^3 / (sqrt(n)) or n^2.5

    ```plaintext
    There is no possible combination of C and n0 possible
    ```

* Option 4 : 2^20 * n

    ```plaintext
    C = 2^20, n0 = 1
        2^20 * n <= 2^20 * n^2 for n > 1
    ```

## Notes