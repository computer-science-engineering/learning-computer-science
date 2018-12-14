# Problem Definition

## Description

Remove duplicates and return list based on a passed weight. Input list is unsorted. Solve for optimal time complexity.

The weight indicates the number of occurrences. So the output list would have to be sorted based on this weight, i.e., the number of times a number occurs.

```text
Example1:

Input: [1, 2, 1, 3, 2, 1]
Output:
n=1 [1, 2, 3]
n=2 [1, 3, 2]
n=3 [3, 2, 1]
```

```text
Example2:

Input: [1, 2, 1, 3, 2, 1, 2]
Output:
n=3 [1, 3, 2]
```

## Notes