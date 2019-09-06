# Problem Definition

## Description

You are given an array of `n` integers, `a0, a1, a2, ..., a(n-1)`, and a positive integer, `k`. Find and print the number of pairs `(i, j)` where `i < j` and `ai + aj` is divisible by `k`.

### Input Format

The first line contains `2` space-separated integers, `n` and `k`.
The second line contains `n` space-separated integers describing the values of `ar[a0, a1, a2, ..., a(n-1)]`.

### Constraints

* `2 <= n <= 100`
* `1 <= k <= 100`
* `1 <= ai <= 100`

### Output Format

Print the number of `(i, j)` pairs where `i < j` and `ai + aj` is divisible by `k`.

### Sample Input

```plaintext
6 3
1 3 2 6 1 2
```

### Sample Output

```plaintext
5
```

### Explanation

Here are the `5` valid pairs when `k=3`:

* `(0, 2) -> a0 + a2 = 1 + 2 = 3`
* `(0, 5) -> a0 + a5 = 1 + 2 = 3`
* `(1, 3) -> a1 + a3 = 3 + 6 = 9`
* `(2, 4) -> a2 + a4 = 2 + 1 = 3`
* `(4, 5) -> a4 + a5 = 1 + 2 = 3`

## Notes

1. [Martin Kysel blog](https://www.martinkysel.com/hackerrank-divisible-sum-pairs-solution/)