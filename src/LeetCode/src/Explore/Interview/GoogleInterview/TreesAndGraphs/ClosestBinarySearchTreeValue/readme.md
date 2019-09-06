# Problem Definition

## Description

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

**Note:**

* Given target value is a floating point.
* You are guaranteed to have only one unique value in the BST that is closest to the target.

**Example:**

```plaintext
Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
```

## Notes

1. [LeetCode discussion - Clean and concise java solution](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/463/discuss/70331/Clean-and-concise-java-solution)
1. [LeetCode discussion - Java iterative solution](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/463/discuss/70386/Java-iterative-solution)

    Basic idea: In a while loop, calculate min for the current root and update the closest value when necessary. Depending on whether root node is smaller or larger than the target, go to the right or the left branch.

    ```java
    public int closestValue(TreeNode root, double target) {
        double closest = Integer.MAX_VALUE;
        int value = 0;
        TreeNode current = root;
        while (current != null) {
            if (closest > Math.abs(current.val-target)) {
                closest = Math.abs(current.val-target);
                value = current.val;
            }

            if (current.val < target) {
                current = current.right;
            } else if (current.val > target) {
                current = current.left;
            } else {
                break;
            }
        }
        return value;
    }
    ```

1. [LeetCode discussion - 4-7 lines recursive/iterative Ruby/C++/Java/Python](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/463/discuss/70327/4-7-lines-recursiveiterative-RubyC++JavaPython)