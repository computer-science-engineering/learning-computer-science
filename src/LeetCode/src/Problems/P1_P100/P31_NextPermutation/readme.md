# Problem Definition

## Description

Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be [in-place](http://en.wikipedia.org/wiki/In-place_algorithm) and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

```text
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/next-permutation/solution/)
1. LeetCode sample submission - 7 ms

    ```java
    public void nextPermutation(int[] nums) {
        // 1 2 3 4 5 6 7  => 1 2 3 4 5 7 6
        // 1 3 4 7 6 5 2 => 2 1 3 5 2 4 6 7
        if(nums == null || nums.length == 0)
            return;
        int i = nums.length - 2;
        int p1 = -1;
        int p2 = nums.length - 1;
        // System.out.println("i = " + i);

        while(i>=0) {
            //Note we compare the current value and the one before it, not the last one
            //Note: potentially the current value and the one before it can have the same value 
            if(nums[i] >= nums[i+1] && i>=0 ) {
                i--;
            } else {
                p1 = i;
                for(int j = p1+1; j<nums.length; ++j) {
                    if(nums[j] > nums[p1])
                        p2 = j;
                }
                swap(nums, p1, p2);
                break;
            }
        }
        // System.out.println("i = " + i);
        // System.out.println("p1 = " + p1 );
        // System.out.println("p2 = " + p2 );
        reverse(nums, p1+1, nums.length-1);
    }
    void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;        
    }
    void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
    ```