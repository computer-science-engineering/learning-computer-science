# Problem Definition

## Description

Given two binary strings, return their sum (also a binary string).

Example:

```plaintext
a = "100"
b = "11"
Return a + b = “111”.
```

## Notes

1. [Geeks for Geeks problem](http://www.geeksforgeeks.org/add-two-bit-strings/)

    ```plaintext
    1. Make them equal sized by adding 0s at the beginning of smaller string.
    2. Perform bit addition
    …..Boolean expression for adding 3 bits a, b, c
    …..Sum = a XOR b XOR c
    …..Carry = (a AND b) OR ( b AND c ) OR ( c AND a )
    ```

1. [Geeks for Geeks problem](http://www.geeksforgeeks.org/program-to-add-two-binary-strings/)
1. [Git gist](https://gist.github.com/anil477/10eefc4a6c686009576e042c0538c51e)