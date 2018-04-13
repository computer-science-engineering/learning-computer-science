# Problem Definition

## Description

What is the time complexity of the following code :

```text
int a = 0, i = N;
while (i > 0) {
    a += i;
    i /= 2;
}
```

### Choices

* O(N)
* O(Sqrt(N))
* O(N / 2)
* O(log N)
* O(log(log N))

### Answer

O(log N)

## Notes