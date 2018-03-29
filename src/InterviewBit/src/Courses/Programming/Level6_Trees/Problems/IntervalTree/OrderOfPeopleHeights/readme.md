# Problem Definition

## Description

You are given the following :

* A positive number `N`.
* `Heights` : A list of `heights of N persons` standing in a `queue`.
* `Infronts` : A list of numbers corresponding to each person `(P)` that gives the **number of persons** who are **taller** than `P` and standing in front of `P`.

You need to `return` list of actual order of persons' height.

Consider that heights will be unique.

Example:

```text
Input :
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
```

```text
Output :
actual order is: 5 3 2 1 6 4
```

So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence `Infronts` has 0 for him.

For person with height 3, there is 1 person (Height : 5) in front of him who is taller than him.

You can do similar inference for other people in the list.

## Notes

1. [CodeVillage](https://codevillage.wordpress.com/2016/08/22/order-of-people-heights/)
1. [Geeks for Geeks - Determine the actual order heights [Google]](http://qa.geeksforgeeks.org/3974/qa.geeksforgeeks.org/3974/qa.geeksforgeeks.org/3974/determine-the-actual-order-heights-google)
1. [Amortized Minds](https://amortizedminds.wordpress.com/2016/08/25/order-of-people-height-interviewbit/)
1. [LeetCode discussion - Line reconstruction by height](https://discuss.leetcode.com/topic/24320/line-reconstruction-by-height/2)
1. [LeetCode discussion - Queue Reconstruction by Height - Easy concept with Python/C++/Java Solution](https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC++Java-Solution)
    * Pick out tallest group of people and sort them in a subarray (S). Since there’s no other groups of people taller than them, therefore each guy’s index will be just as same as his k value.
    * For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.

    E.g.
    input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    subarray after step 1: [[7,0], [7,1]]
    subarray after step 2: [[7,0], [6,1], [7,1]]
    …