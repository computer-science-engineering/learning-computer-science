# Problem Definition

## Description

There are a total of n courses you have to take, labeled from `0` to `n-1`.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`

Given the total number of courses and a list of prerequisite **pairs**, is it possible for you to finish all courses?

**Example 1:**

```plaintext
Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**

```plaintext
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
```

**Note:**

1. The input prerequisites is a graph represented by **a list of edges**, not adjacency matrices. Read more about [how a graph is represented](https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs).
2. You may assume that there are no duplicate edges in the input prerequisites.

## Notes

1. [LeetCode discussion - Java DFS and BFS solution](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/369/discuss/58524/Java-DFS-and-BFS-solution)
1. [YT Video - Professor Sheep - LeetCode 207. Course Schedule](https://www.youtube.com/watch?v=VvKwqfXri0I)
1. LeetCode Top submission -  3 ms

    ```java
    public boolean canFinish(int n, int[][] prerequisites) {
        if (n <= 1 || prerequisites == null || prerequisites.length <= 1) {
            return true;
        }

        int[] root1 = new int[n];
        int[] root2 = new int[n];
        for (int i = 0; i < n; ++i) {
            root1[i] = root2[i] = i;
        }

        int[][] reverse = new int[prerequisites.length][2];
        for (int i = 0; i < prerequisites.length; ++i) {
            reverse[i][0] = prerequisites[i][1];
            reverse[i][1] = prerequisites[i][0];
        }

        return noCycle(prerequisites, root1) && noCycle(reverse, root2);
    }

    private boolean noCycle(int[][] edges, int[] root) {
        for (int[] edge: edges) {
            int before = edge[1], after = edge[0];
            while (root[before] != before) {
                before = root[before];
                if (before == after) {
                    return false;
                }
            }
            root[after] = before;
        }
        return true;
    }
    ```

1. LeetCode Top submission -  4 ms

    ```java
    private static class Vertex {
        int label;
        List<Integer> nexts;
        Boolean hasCycle;

        public Vertex(int label){
            this.label = label;
            nexts = new ArrayList<>();
            hasCycle = null;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null) return true;

        Vertex[] arr = constructGraph(numCourses,prerequisites);

        for(int i = 0; i < numCourses; i++){
            if(hasCycle(arr[i],arr)){
                return false;
            }
        }

        return true;
    }

    private Vertex[] constructGraph(int num, int[][] prerequisites){
        Vertex[] arr = new Vertex[num];

        for(int i = 0; i < num; i++){
            arr[i] = new Vertex(i);
        }

        for(int i = 0; i < prerequisites.length; i++){
            int prev = prerequisites[i][1];
            int next = prerequisites[i][0];

            arr[prev].nexts.add(next);
        }

        return arr;
    }

    private boolean hasCycle(Vertex v, Vertex[] arr){
        if(v.hasCycle != null){
            return v.hasCycle;
        }

        v.hasCycle = true;

        for(Integer i : v.nexts){
            if(hasCycle(arr[i],arr)){
                return true;
            }
        }

        v.hasCycle = false;

        return false;

    }
    ```