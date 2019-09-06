# Problem Definition

## Description

**N** light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.

**Note:** 0 represents the bulb is off and 1 represents the bulb is on.

**Example:**

```plaintext
Input : [0 1 0 1]
Return : 4

Explanation :
    press switch 0 : [1 0 1 0]
    press switch 1 : [1 1 0 1]
    press switch 2 : [1 1 1 0]
    press switch 3 : [1 1 1 1]
```

## Notes

1. [Geeks for Geeks - Find the minimum number of switches you have to press to turn on all the bulbs](http://qa.geeksforgeeks.org/4118/find-the-minimum-number-switches-you-have-press-turn-all-bulbs)
    * Order of check does not matter - left to right or right to left. For simplicity we choose left to right.
    * At the current position if the bulb is on we move to the right, else we switch it on. This works because changing any switch to the right of it will not affect it anymore.