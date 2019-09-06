# Problem Definition

## Description

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

**Note:**

The solution set must not contain duplicate quadruplets.

**Example:**

```plaintext
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

## Notes

1. [Geeks for Geeks - Find four elements that sum to a given value | Set 3 (Hashmap)](https://www.geeksforgeeks.org/find-four-elements-sum-given-value-set-3-hashmap/)
1. [LifeInCode - Two Sum, 3 Sum, 3 Sum closest and 4 Sum](http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/)
1. [Techie Delight - Quadruplets with given sum](http://www.techiedelight.com/4-sum-problem/)

    ```java
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    class Pair {
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Util
    {
        // Function to check if Quadruplet exists in an array with given sum
        public static boolean quadTuple(int[] A, int n, int sum)
        {
            // create an empty map
            // key -> sum of a pair of elements in the array
            // value -> list storing index of every pair having that sum
            Map<Integer, List<Pair>> map = new HashMap<>();

            // consider each element except last element
            for (int i = 0; i < n - 1; i++)
            {
                // start from i'th element till last element
                for (int j = i + 1; j < n; j++)
                {
                    // calculate remaining sum
                    int val = sum - (A[i] + A[j]);

                    // if remaining sum is found in the map, we have found a Quadruplet
                    if (map.containsKey(val))
                    {
                        // check every pair having sum equal to remaining sum
                        for (Pair pair : map.get(val))
                        {
                            int x = pair.x;
                            int y = pair.y;

                            // if Quadruplet don't overlap, print it and return true
                            if ((x != i && x != j) && (y != i && y != j))
                            {
                                System.out.print("Quadruplet Found (" + A[i] + ", " + A[j]
                                                + ", " + A[x] + ", " + A[y] + ")");
                                return true;
                            }
                        }
                    }

                    // insert current pair into the map
                    map.putIfAbsent(A[i] + A[j], new ArrayList<>());    // null check (Java 8)
                    map.get(A[i] + A[j]).add(new Pair(i, j));
                }
            }

            // return false if Quadruplet don't exist
            return false;
        }

        // main function
        public static void main(String[] args)
        {
            int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
            int sum = 20;

            if (!quadTuple(A, A.length, sum)) {
                System.out.print("Quadruplet Don't Exist");
            }
        }
    }
    ```
1. [LeetCode discussion - 7ms java code win over 100%](https://leetcode.com/problems/4sum/discuss/8547/7ms-java-code-win-over-100)

    Basic idea is using subfunctions for 3sum and 2sum, and keeping throwing all impossible cases. O(n^3) time complexity, O(1) extra space complexity.

1. [LeetCode discussion - My solution generalized for kSums in JAVA](https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA)

    General Idea: If you have already read and implement the 3sum and 4sum by using the sorting approach: reduce them into 2sum at the end, you might already got the feeling that, all ksum problem can be divided into two problems:

    2sum Problem
    Reduce K sum problem to K – 1 sum Problem
    Therefore, the ideas is simple and straightforward. We could use recursive to solve this problem. Time complexity is O(N^(K-1)).