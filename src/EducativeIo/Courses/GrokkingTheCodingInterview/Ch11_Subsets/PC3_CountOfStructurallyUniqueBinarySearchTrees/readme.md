# Problem Definition

## Description

Given a number ‘n’, write a function to return the count of structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.

Example 1:

```plaintext
Input: 2
Output: 2
Explanation: As we saw in the previous problem, there are 2 unique BSTs storing numbers from 1-2.
```

Example 2:

```plaintext
Input: 3
Output: 5
Explanation: There will be 5 unique BSTs that can store numbers from 1 to 5.
```

## Discussion

This problem is similar to **Structurally Unique Binary Search Trees**. Following a similar approach, we can iterate from 1 to ‘n’ and consider each number as the root of a tree and make two recursive calls to count the number of left and right sub-trees.

### Time Complexity

The time complexity of this algorithm will be exponential and will be similar to **Balanced Parentheses**. Estimated time complexity will be O(n*2^n) but the actual time complexity ( O(4^n/\sqrt{n}) is bounded by the [Catalan number](https://en.wikipedia.org/wiki/Catalan_number) and is beyond the scope of a coding interview. More details [here](https://en.wikipedia.org/wiki/Central_binomial_coefficient).

### Space Complexity

The space complexity of this algorithm will be exponential too, estimated at O(2^n), but the actual will be ( O(4^n/\sqrt{n}).

### Memoized version

Since our algorithm has overlapping sub-problems, can we use memoization to improve it? We could, but every time we return the result of a subproblem from the cache, we have to clone the result list because these trees will be used as the left or right child of a tree. This cloning is equivalent to reconstructing the trees, therefore, the overall time complexity of the memoized algorithm will also be the same.

```java
Map<Integer, Integer> map = new HashMap<>();

public int countTrees(int n) {
    if (map.containsKey(n))
        return map.get(n);

    if (n <= 1)
        return 1;
    int count = 0;
    for (int i = 1; i <= n; i++) {
        // making 'i' root of the tree
        int countOfLeftSubtrees = countTrees(i - 1);
        int countOfRightSubtrees = countTrees(n - i);
        count += (countOfLeftSubtrees * countOfRightSubtrees);
    }
    map.put(n, count);
    return count;
}
```

The time complexity of the memoized algorithm will be O(n^2), since we are iterating from ‘1’ to ‘n’ and ensuring that each sub-problem is evaluated only once. The space complexity will be O(n) for the memoization map.

## Notes

## References
