# Problem Definition

## Description

In this problem, a rooted tree is a **directed** graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of `edges`. Each element of `edges` is a pair `[u, v]` that represents a directed edge connecting nodes `u` and `v`, where `u` is a parent of child `v`.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

**Example 1:**

```text
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
```

**Example 2:**

```text
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
```

**Note:**

* The size of the input 2D-array will be between 3 and 1000.
* Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/redundant-connection-ii/solution/)

    ```java
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int N = edges.length;
            Map<Integer, Integer> parent = new HashMap();
            List<int[]> candidates = new ArrayList();
            for (int[] edge: edges) {
                if (parent.containsKey(edge[1])) {
                    candidates.add(new int[]{parent.get(edge[1]), edge[1]});
                    candidates.add(edge);
                } else {
                    parent.put(edge[1], edge[0]);
                }
            }

            int root = orbit(1, parent).node;
            if (candidates.isEmpty()) {
                Set<Integer> cycle = orbit(root, parent).seen;
                int[] ans = new int[]{0, 0};
                for (int[] edge: edges) {
                    if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                        ans = edge;
                    }
                }
                return ans;
            }

            Map<Integer, List<Integer>> children = new HashMap();
            for (int v: parent.keySet()) {
                int pv = parent.get(v);
                if (!children.containsKey(pv))
                    children.put(pv, new ArrayList<Integer>());
                children.get(pv).add(v);
            }

            boolean[] seen = new boolean[N+1];
            seen[0] = true;
            Stack<Integer> stack = new Stack();
            stack.add(root);
            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!seen[node]) {
                    seen[node] = true;
                    if (children.containsKey(node)) {
                        for (int c: children.get(node))
                            stack.push(c);
                    }
                }
            }
            for (boolean b: seen) if (!b)
                return candidates.get(0);
            return candidates.get(1);
        }

        public OrbitResult orbit(int node, Map<Integer, Integer> parent) {
            Set<Integer> seen = new HashSet();
            while (parent.containsKey(node) && !seen.contains(node)) {
                seen.add(node);
                node = parent.get(node);
            }
            return new OrbitResult(node, seen);
        }

    }

    class OrbitResult {
        int node;
        Set<Integer> seen;
        OrbitResult(int n, Set<Integer> s) {
            node = n;
            seen = s;
        }
    }
    ```

1. [LeetCode discussion - Share my solution, C++](https://leetcode.com/problems/redundant-connection-ii/discuss/108073/share-my-solution-c)
1. [LeetCode discussion - one pass disjoint set solution with explain](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/366/discuss/108058/one-pass-disjoint-set-solution-with-explain)