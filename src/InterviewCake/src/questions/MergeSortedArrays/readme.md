# Problem Definition

## Description

In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.

Each order is represented by an "order id" (an integer).

We have our lists of orders sorted numerically already, in arrays. Write a method to merge our arrays of orders into one sorted array.

For example:

```java
int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(mergeArrays(myArray, alicesArray));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
```

### Gotchas

We can do this in O(n) time and space.

If you're running a built-in sorting method, your algorithm probably takes `O(n log(n))` time for that sort.

### Breakdown

We could simply concatenate (join together) the two arrays into one, then sort the result:

```java
public static int[] mergeSortedArrays(int[] myArray, int[] alicesArray) {
    int[] mergedArray = Arrays.copyOf(myArray, myArray.length + alicesArray.length);
    System.arraycopy(alicesArray, 0, mergedArray, myArray.length, alicesArray.length);
    Arrays.sort(mergedArray);
    return mergedArray;
}
```

What would the time cost be?

`O(n log(n))`, where n is the total length of our output array (the sum of the lengths of our inputs).

We can do better. With this algorithm, we're not really taking advantage of the fact that the input arrays are themselves already sorted. How can we save time by using this fact?

in general we could say something like:

1. We'll start at the beginnings of our input arrays, since the smallest elements will be there.
1. As we put items in our final mergedArray, we'll keep track of the fact that they're "already merged."
1. At each step, each array has a first "not-yet-merged" item.
1. At each step, the next item to put in the mergedArray is the smaller of those two "not-yet-merged" items!

## Notes

1. [SO post](https://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array)