# Ways To Form Max Heap

## Origin

[Link](https://www.interviewbit.com/problems/ways-to-form-max-heap/)

## Description

Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this [link](https://en.wikipedia.org/wiki/Heap_%28data_structure%29).

So now the problem statement for this question is:

How many distinct Max Heap can be made from n distinct integers?

In short, you have to ensure the following properties for the max heap:

* Heap has to be a complete binary tree (A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible).
* Every node is greater than all its children.

Let us take an example of 4 distinct integers. Without loss of generality let us take `1 2 3 4` as our 4 distinct integers. Following are the possible max heaps from these 4 numbers:

```text
         4
       /  \
      3   2
     /
    1
```

```text
         4
       /  \
      2   3
     /
    1
```

```text
        4
       /  \
      3   1
     /
    2
```

These are the only possible 3 distinct max heaps possible for 4 distinct elements.

Implement the below function to return the number of distinct Max Heaps that is possible from `n` distinct elements.

As the final answer can be very large, output your answer modulo `1000000007`.

Input Constraints : n <= 100

NOTE: Note that even though constraints are mentioned for this problem, for most problems on InterviewBit, constraints are intentionally left out. In real interviews, the interviewer might not disclose constraints and ask you to do the best you can do.

## Companies

1. Directi

## Categories

1. Courses
1. Programming

## Tags

1. Heaps and Maps

## Notes

1. [SO post](https://cs.stackexchange.com/questions/6456/how-many-max-heaps-are-there)
1. [Geeks for Geeks post](https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/)
1. [YouTube video - Yusuf Shakeel](https://www.youtube.com/watch?v=ixdWTKWSz7s)
1. [techie delight blog - min and max heap in Java](http://www.techiedelight.com/min-heap-max-heap-implementation-in-java/)
1. [GitHub - Ilya Ismagilov's solution](https://github.com/ismagilov/interviewbit/blob/84a7b463554b8351db4a6772753b781319cbcc1c/src/heaps_and_maps/WaysToFormMaxHeap.java)
1. [Find permutation and combination - blog](http://www.codevscolor.com/2017/11/java-program-find-permutation-combination-npr-ncr/)
1. [GitHub - DP approach](https://github.com/AndriyLytvynskyy/BrainFuck/blob/ac451a7f09dd2b57049a19634f8c39162ba04ca0/src/main/java/com/booking/interviewbit/heap/WaysToFormMaxHeap.java)
1. [GitHub - semaserg's solution](https://github.com/Semaserg/LeetCodeProblems/blob/master/heap/WaysToFormMaxHeap_intbit/Solution.java)
1. [GitHub -another DP approach](https://github.com/nazarmubeen/ProgramminInJava/blob/093c7de7fb59b629b106dbeff82a53c91fe93536/src/heaps/WaystoformMaxHeap.java)
1. [Quora post](https://www.quora.com/How-many-Binary-heaps-can-be-made-from-N-distinct-elements)

### Solution Approach

* Suppose there are n distinct elements to be used in Max heap. Now it is for sure that the maximum element among this n distinct element will surely be placed on the root of the heap.
* Now there will be remaining (n-1) elements to be arranged.
* Now point to be remembered here is that the structure of the heap will remain the same. That is only the values within the node will change however the overall structure remaining the same.
* As structure of the heap remains the same, the number of elements that are present in the left sub-tree of the root (L) will be fixed. And similarly the number of the elements on the right sub-tree (R) of the root. And also following equality holds.

    ```text
    L + R = (n-1)
    ```

* Now as all the remaining (n-1) elements are less than the element present at the root(The Max Element), whichever L elements among `n-1` elements we put in the left sub-tree, it doesn’t matter because it will satisfy the Max Heap property.
* So now there are `(n-1)CL` ways to pickup L elements from (n-1) elements. And then recurse the solution.
* So final equation will be as follows :

    ```text
    (n-1)CL * getNumberOfMaxHeaps(L) * getNumberOfMaxHeaps(R)
    ```

* So now the question remains only of finding L for given n. It can be found as follows:

  * Find the height of the heap `h = log2(n)`
  * Find the max number of elements that can be present in the hth level of any heap . Lets call it m. `m = 2^h`
  * Find the number of elements that are actually present in last level(hth level) in heap of size n. Lets call it p. `p = n - (2^h - 1)`
  * Now if the last level of the heap is more than or equal to exactly half filled, then L would be `2^h - 1`
  * However if it is half filled then it will reduced by the number of elements in last level left to fill exactly half of the last level.
  * So final equation for L will be as follows :

        ```text
        L   = 2h - 1 if p >= m/2
            = 2h - 1 - (m/2 - p) if p<(m/2)
        ```