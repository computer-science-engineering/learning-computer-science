package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.EvaluateDivision.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] result = calcEquation(equations, values, queries);
        for (double item : result) {
            System.out.print(item + " ");            
        }
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            m.putIfAbsent(equations[i][0], new HashMap<>());
            m.putIfAbsent(equations[i][1], new HashMap<>());
            m.get(equations[i][0]).put(equations[i][1], values[i]);
            m.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] r = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            r[i] = dfs(queries[i][0], queries[i][1], 1, m, new HashSet<>());
        }
        return r;
    }

    private static double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        if (!m.containsKey(s) || !seen.add(s)) return -1;
        if (s.equals(t)) return r;
        Map<String, Double> next = m.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), m, seen);
            if (result != -1) return result;
        }
        return -1;
    }
}