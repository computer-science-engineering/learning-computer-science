# Problem Definition

## Description

What is the time complexity of the following code :

```plaintext
int a = 0;
for (i = 0; i < N; i++) {
    for (j = N; j > i; j--) {
        a = a + i + j;
    }
}
```

### Choices

* O(N)
* O(N*log(N))
* O(N * Sqrt(N))
* O(N*N)

### Answer

O(N*N)

## Notes