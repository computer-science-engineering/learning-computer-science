# Problem Definition

## Description

Predict the output of the following program:

```java
ArrayList<Integer> performOps(ArrayList<Integer> A) {
    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int i = 0; i < 2 * A.size(); i++) B.add(0);
    for (int i = 0; i < A.size(); i++) {
        B.set(i, A.get(i));
        B.set(i + A.size(), A.get((A.size() - i) % A.size()));
    }
    return B;
}
```

Lets say performOps was called with `A : [5, 10, 2, 1]`. What would be the output of the following call:

```java
ArrayList<Integer> B = performOps(A);
for (int i = 0; i < B.size(); i++) {
    System.out.print(B.get(i) + " ");
}
```

## Notes