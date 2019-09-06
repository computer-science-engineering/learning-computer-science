# Problem Definition

## Description

Equations are given in the format `A / B = k`, where `A` and `B` are variables represented as strings, and `k` is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return `-1.0`.

**Example:**

Given `a / b = 2.0, b / c = 3.0.`

queries are: `a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .`

return `[6.0, 0.5, -1.0, 1.0, -1.0 ].`

The input is: `vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries`, where `equations.size() == values.size()`, and the values are positive. This represents the equations. Return `vector<double>`.

According to the example above:

```plaintext
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
```

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

## Notes

1. [LeetCode discussion - Easy understand Java solution, 3ms](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/discuss/88287/Esay-understand-Java-solution-3ms)
1. [LeetCode discussion - 1ms DFS with Explanations](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/discuss/171649/1ms-DFS-with-Explanations)
1. [LeetCode discussion - Java Union-find solution with detailed explanation - beat 100%](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/discuss/147281/Java-Union-find-solution-with-detailed-explanation-beat-100)

    ```java
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String r1 = find(root, dist, equations[i][0]);
            String r2 = find(root, dist, equations[i][1]);
            root.put(r1, r2);
            dist.put(r1, dist.get(equations[i][1]) * values[i] / dist.get(equations[i][0]));
        }
        for (int i = 0; i < queries.length; i++) {
            if (!root.containsKey(queries[i][0]) || !root.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, queries[i][0]);
            String r2 = find(root, dist, queries[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(queries[i][0]) / dist.get(queries[i][1]);
        }
        return res;
    }

    private static String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;
    }
    ```
1. [LeetCode discussion - Java AC Solution using graph](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/discuss/88169/Java-AC-Solution-using-graph)

    ```java
    public double[] calcEquation(String[][] eq, double[] values, String[][] q) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            m.putIfAbsent(eq[i][0], new HashMap<>());
            m.putIfAbsent(eq[i][1], new HashMap<>());
            m.get(eq[i][0]).put(eq[i][1], values[i]);
            m.get(eq[i][1]).put(eq[i][0], 1 / values[i]);
        }
        double[] r = new double[q.length];
        for (int i = 0; i < q.length; i++)
            r[i] = dfs(q[i][0], q[i][1], 1, m, new HashSet<>());
        return r;
    }

    double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        if (!m.containsKey(s) || !seen.add(s)) return -1;
        if (s.equals(t)) return r;
        Map<String, Double> next = m.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), m, seen);
            if (result != -1) return result;
        }
        return -1;
    }
    ```

1. [LeetCode discussion - 9 lines "Floyd–Warshall" in Python](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/discuss/88175/9-lines-"FloydWarshall"-in-Python)
1. [LeetCode discussion - Graph walking in python - detailed explanation with video](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/discuss/88262/graph-walking-in-python-detailed-explanation-with-video)
1. LeetCode Top submission -  1ms submission

    ```java
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || equations.length == 0 || queries == null || queries.length == 0) {
            return new double[0];
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<Double>> weight = new HashMap<>();
        buildGraph(equations, values, graph, weight);

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Set<String> visited = new HashSet<>();
            res[i] = dfs(graph, weight, queries[i][0], queries[i][1], visited);
        }
        return res;
    }

    private void buildGraph(String[][] equations, double[] values, Map<String, List<String>> graph, Map<String, List<Double>> weight) {
        for (int i = 0; i < equations.length; i++) {
            addEdge(graph, weight, equations[i][0], equations[i][1], values[i]);
            addEdge(graph, weight, equations[i][1], equations[i][0], 1 / values[i]);
        }
    }

    private void addEdge(Map<String, List<String>> graph, Map<String, List<Double>> weight, String node1, String node2, double val) {
        List<String> list = graph.getOrDefault(node1, new ArrayList<String>());
        list.add(node2);
        graph.put(node1, list);
        List<Double> valList = weight.getOrDefault(node1, new ArrayList<Double>());
        valList.add(val);
        weight.put(node1, valList);
    }

    private double dfs(Map<String, List<String>> graph, Map<String, List<Double>> weight, String node1, String node2, Set<String> visited) {
        if (!graph.containsKey(node1) || !graph.containsKey(node2)) {
            return -1.0;
        }

        if (node1.equals(node2)) {
            return 1.0;
        }

        visited.add(node1);
        for (int i = 0; i < graph.get(node1).size(); i++) {
            String nei = graph.get(node1).get(i);
            if (!visited.contains(nei)) {
                double retVal = dfs(graph, weight, nei, node2, visited);
                if (retVal > 0) {
                    return weight.get(node1).get(i) * retVal;
                }
            }
        }
        return -1.0;
    }
    ```

1. [YT Video - Scott - Evaluate Division](https://www.youtube.com/watch?v=pfQoqxP-6DE)