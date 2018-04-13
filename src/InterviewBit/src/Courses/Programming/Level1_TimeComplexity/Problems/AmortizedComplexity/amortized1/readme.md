# Problem Definition

## Description

What is the time complexity of the following code :

```C++
int j = 0;
for(int i = 0; i < n; ++i) {
    while(j < n && arr[i] < arr[j]) {
        j++;
    }
}
```

### Choices

* O(n)
* O(n^2)
* O(nlogn)
* O(n(logn)^2)
* Can't say. Depends on the value of arr.

### Answer

O(n)

Note that the variable j is not initialized for each value of variable i. Hence, the inner j++ will be executed at most n times. The i loop also runs n times. So, the whole thing runs for O(n) times.

Still not convinced ?

Lets assume the array passed has its element in decreasing order. We will just dry run through the code :

```text
Iteration 1 : i = 0, j = 0. arr[0] < arr[0] is false. So, the inner while loop breaks.
Iteration 2 : i =1, j = 0. arr[1] < arr[0] is true. j becomes 1.
Iteration 3 : i = 1, j = 1. Condition false. We break. Note that j will remain 1 and is not reset back to 0.
Iteration 4 : i = 2, j = 1. arr[2] < arr[1]. True. j = 2.
Iteration 5 : i = 2, j = 2. Condition false. Break.
Iteration 6 : i = 3, j = 2. arr[3] < arr[2]. True. j = 3.
Iteration 7 : i = 3, j = 3. Condition false. Break.
```

As you can see, the inner while loop only runs once in this case. So, total iterations is **2 * N.**

## Notes