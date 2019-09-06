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

1. [LeetCode discussion - Java Solution O(N) no swap and exactly one pass iteration](https://leetcode.com/explore/interview/card/google/59/array-and-strings/461/discuss/143642/Java-Solution-O(N)-no-swap-and-exactly-one-pass-iteration)

    ```java
    public static void moveZeroes2(int[] nums) {
        int len = nums.length;

        int start = 0;
        while(start<len && nums[start++]!=0);

        int j = start;
        start--;

        for(;j<len;j++) {
            if(nums[j]!=0) {
                nums[start++] = nums[j];
                nums[j] = 0;
            }
        }
    }
    ```

1. [LeetCode discussion - Simple O(N) Java Solution Using Insert Index](https://leetcode.com/explore/interview/card/google/59/array-and-strings/461/discuss/72011/Simple-O(N)-Java-Solution-Using-Insert-Index)