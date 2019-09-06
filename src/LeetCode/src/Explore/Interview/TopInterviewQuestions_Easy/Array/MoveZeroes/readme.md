# Problem Definition

## Description

Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Example:**

```plaintext
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Note:**

1. You must do this **in-place** without making a copy of the array.
2. Minimize the total number of operations.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/move-zeroes/solution/)
1. [LeetCode discussion - Java Solution O(N) no swap and exactly one pass iteration](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/discuss/143642/Java-Solution-O(N)-no-swap-and-exactly-one-pass-iteration)
1. [LeetCode discussion - Simple O(N) Java Solution Using Insert Index](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/discuss/72011/Simple-O(N)-Java-Solution-Using-Insert-Index)

    ```java
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
    ```