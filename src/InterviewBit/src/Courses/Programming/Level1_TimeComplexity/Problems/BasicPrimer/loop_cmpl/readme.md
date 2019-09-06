# Problem Definition

## Description

What is the time, space complexity of following code :

```plaintext
        int a = 0, b = 0;
        for (i = 0; i < N; i++) {
            a = a + rand();
        }
        for (j = 0; j < M; j++) {
            b = b + rand();
        }
```

Assume that rand() is O(1) time, O(1) space function.

### Choices

* O(N * M) time, O(1) space
* O(N + M) time, O(N + M) space
* O(N + M) time, O(1) space
* O(N * M) time, O(N + M) space
* O(N * M) time, O(N * M) space

### Answer

O(N + M) time, O(1) space

## Notes