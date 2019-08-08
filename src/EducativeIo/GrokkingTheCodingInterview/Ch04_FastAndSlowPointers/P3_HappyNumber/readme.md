# Problem Definition

## Description

Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

Example 1:

```text
Input: 23
Output: true (23 is a happy number)  
Explanations: Here are the steps to find out that 23 is a happy number:

1. 2^2 + 3^2 = 4 + 9 = 13
2. 1^2 + 3^2 = 1 + 9 = 10
3. 1^2 + 0^ = 1 + 0 = 1
```

Example 2:

```text
Input: 12
Output: false (12 is not a happy number)  
Explanations: Here are the steps to find out that 12 is not a happy number:

1. 1^2 + 2^2 = 1 + 4 = 5
2. 5^2 = 25
3. 2^2 + 5^2 = 4 + 25 = 29
4. 2^2 + 9^2 = 4 + 81 = 85
5. 8^2 + 5^2 = 64 + 25 = 89
6. 8^2 + 9^2 = 64 + 81 = 145
7. 1^2 + 4^2 + 5^2 = 1 + 16 + 25 = 42
8. 4^2 + 2^2 = 16 + 4 = 20
9. 2^2 + 0^2 = 4 + 0 = 4
10. 4^2 = 16
11. 1^2 + 6^2 = 1 + 36 = 37
12. 3^2 + 7^2 = 9 + 49 = 58
13. 5^2 + 8^2 = 25 + 64 = 89

Step ‘13’ leads us back to step ‘5’ as the number becomes equal to ‘89’,
this means that we can never reach ‘1’, therefore, ‘12’ is not a happy number.
```

## Notes

The process, defined above, to find out if a number is a happy number or not, always ends in a cycle. If the number is a happy number, the process will be stuck in a cycle on number ‘1,’ and if the number is not a happy number then the process will be stuck in a cycle with a set of numbers. As we saw in Example-2 while determining if ‘12’ is a happy number or not, our process will get stuck in a cycle with the following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

We can use the Fast & Slow pointers method to find a cycle among a set of elements as in the LinkedList Cycle problem. As we have described above, each number will definitely have a cycle. Therefore, we will use the same fast & slow pointer strategy to find the cycle and once the cycle is found, we will see if the cycle is stuck on number ‘1’ to find out if the number is happy or not.

## References
