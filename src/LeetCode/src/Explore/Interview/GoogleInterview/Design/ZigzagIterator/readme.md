# Problem Definition

## Description

Given two 1d vectors, implement an iterator to return their elements alternately.

**Example:**

```text
Input:
v1 = [1,2]
v2 = [3,4,5,6]

Output: [1,3,2,4,5,6]

Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,3,2,4,5,6].
```

**Follow up:** What if you are given `k` 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question:
The "Zigzag" order is not clearly defined and is ambiguous for `k > 2` cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:

```text
Input:
[1,2,3]
[4,5,6,7]
[8,9]

Output: [1,4,8,2,5,9,3,6,7].
```

## Notes

1. [LeetCode discussion - Simple Java solution for K-vector](https://leetcode.com/explore/interview/card/google/65/design-4/479/discuss/71779/Simple-Java-solution-for-K-vector)
1. LeetCode sample submission - 3 ms

    ```java
    public class ZigzagIterator {
        int p1 = 0;
        int p2 = 0;
        boolean first = true;
        List<Integer> v1;
        List<Integer> v2;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            if (p1 == v1.size()) {
                return v2.get(p2++);
            } else if (p2 == v2.size()) {
                return v1.get(p1++);
            } else {
                if (first) {
                    first = !first;
                    return v1.get(p1++);
                } else {
                    first = !first;
                    return v2.get(p2++);
                }
            }
        }

        public boolean hasNext() {
            return p1 < v1.size() || p2 < v2.size();
        }
    }
    ```