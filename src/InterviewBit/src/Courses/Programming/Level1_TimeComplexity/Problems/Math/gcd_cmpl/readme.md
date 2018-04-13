# Problem Definition

## Description

In the following C++ function, let n >= m.

```C++
    int gcd(int n, int m) {
        if (n%m ==0) return m;
        if (n < m) swap(n, m);
        while (m > 0) {
            n = n%m;
            swap(n, m);
        }
        return n;
    }
```

What is the time complexity of the above function assuming `n > m`?

### Choices

* Θ(logn)
* Ω(n)
* Θ(loglogn)
* Θ(sqrt(n))

### Answer

Θ(logn)

Let us say n = fibonacci(N) and m = fibonacci(N - 1)

fibonacci(N) = fibonacci(N-1) + fibonacci(N-2)

OR n = m + k where k < m.

Therefore the step

```text
n = n % m will make n = k

swap(n, m) will result in

n = fibonacci(N-1)

m = k = fibonacci(N-2)
```

So, it will take N steps before m becomes 0.

This means, in the worst case, this algorithm can take N step if **n** is Nth fibonacci number.

**Think of whats the relation between N and n.**

## Notes

1. [StackOverflow - Complexity of recursive Fibonacci algorithm](https://cs.stackexchange.com/questions/14733/complexity-of-recursive-fibonacci-algorithm)
1. The worst case scenario of above problem happen if m, n are consecutive fibonacci numbers. Fibonacci sequence is the worst case scenario for GCD given N-digit number is two consecutive fibonacci numbers - [link](https://en.wikipedia.org/wiki/Euclidean_algorithm#Algorithmic_efficiency)