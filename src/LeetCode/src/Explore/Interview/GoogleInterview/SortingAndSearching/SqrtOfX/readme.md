# Problem Definition

## Description

Implement `int sqrt(int x)`.

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```text
Input: 4
Output: 2
```

**Example 2:**

```text
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
```

## Notes

1. [StackOverflow - Binary Search to Compute Square root (Java)](https://stackoverflow.com/questions/3766020/binary-search-to-compute-square-root-java)
1. [LeetCode discussion - 3-4 short lines, Integer Newton, Every Language](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/441/discuss/25057/3-4-short-lines-Integer-Newton-Every-Language)

    ```java
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
    ```

1. [LeetCode discussion - Share my O(log n) Solution using bit manipulation](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/441/discuss/25048/Share-my-O(log-n)-Solution-using-bit-manipulation)

    Since sqrt(x) is composed of binary bits, I calculate sqrt(x) by deciding every bit from the most significant to least significant. Since an integer n can have O(log n) bits with each bit decided within constant time, this algorithm has time limit O(log n), actually, because an Integer can have at most 32 bits, I can also say this algorithm takes O(32)=O(1) time.

    ```java
    public int sqrt(int x) {
        if(x==0)
            return 0;
        int h=0;
        while((long)(1<<h)*(long)(1<<h)<=x) // firstly, find the most significant bit
            h++;
        h--;
        int b=h-1;
        int res=(1<<h);
        while(b>=0){  // find the remaining bits
            if((long)(res | (1<<b))*(long)(res |(1<<b))<=x)
                res|=(1<<b);
            b--;
        }
        return res;
    }
    ```

1. [LeetCode discussion - A Binary Search Solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/441/discuss/25047/A-Binary-Search-Solution)

    ```java
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    ```