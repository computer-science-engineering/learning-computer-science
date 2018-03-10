# Problem Definition

## Description

Given a non negative integer A, following code tries to find all pair of integers (a, b) such that

* a and b are positive integers.
* a <= b, and
* a^2 + b^2 = A.
* 0 <= A <= 100000

```Java
public class Solution {
    public ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a * a < A; a++) {
            for (int b = 0; b * b < A; b++) {
                if (a * a + b * b == A) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }
}
```

However, the code has a small bug. Correct the bug and submit the code.

## Notes