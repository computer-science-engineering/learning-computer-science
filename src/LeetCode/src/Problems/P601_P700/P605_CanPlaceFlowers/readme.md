# Problem Definition

## Description

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number **n**, return if **n** new flowers can be planted in it without violating the no-adjacent-flowers rule.

**Example 1:**

```text
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
```

**Example 2:**

```text
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
```

**Note:**

* The input array won't violate no-adjacent-flowers rule.
* The input array size is in the range of [1, 20000].
* **n** is a non-negative integer which won't exceed the input array size.

## Notes

1. [LeetCode discussion - Java - Greedy solution - O(flowerbed) - beats 100%](https://leetcode.com/problems/can-place-flowers/discuss/103898/Java-Greedy-solution-O(flowerbed)-beats-100)

    ```java
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
               int prev = (i == 0) ? 0 : flowerbed[i - 1];
               if(next == 0 && prev == 0) {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }
        return count == n;
    }
    ```

1. [LeetCode discussion - [Java] Very easy solution](https://leetcode.com/problems/can-place-flowers/discuss/103883/Java-Very-easy-solution)

    If there are `count` zeroes in between two `1s`, then how many `1s` can we place in those zeroes without violating the given condition? Answer is `(count-1)/2`. The only cases this doesn't apply are when there are zeroes(1 or more)

        * At the beginning of the array.
        * At the end of the array.

    For these 2 cases, the number of `1s` that we can place is `count/2`. But to generalize the algorithm and to simplify code inside loop, `count` has been initialized to 1 for the first time and `result += (count-1)/2` effectively becomes `result += count/2` for the case 1. For case 2, `result` is updated outside the loop, again by `count/2` times.

    Finally, we check if the number of possible 1s that we can place is greater than or equal to n. If so, we return `true` else `false`.