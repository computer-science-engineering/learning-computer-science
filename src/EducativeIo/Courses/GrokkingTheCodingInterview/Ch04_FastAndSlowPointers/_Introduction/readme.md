# Introduction

The **Fast & Slow** pointer approach, also known as the **Hare & Tortoise** algorithm, is a pointer algorithm that uses two pointers which move through the array (or sequence/LinkedList) at different speeds. This approach is quite useful when dealing with cyclic LinkedLists or arrays.

By moving at different speeds (say, in a cyclic LinkedList), the algorithm proves that the two pointers are bound to meet. The fast pointer should catch the slow pointer once both the pointers are in a cyclic loop.

One of the famous problems solved using this technique was **Finding a cycle in a LinkedList**. Let’s jump onto this problem to understand the **Fast & Slow** pattern.
