package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphHashing.CloneGraph.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(2);
        UndirectedGraphNode c = new UndirectedGraphNode(3);
        a.neighbors.add(b);
        a.neighbors.add(c);
        UndirectedGraphNode clone = cloneGraph(a);
        ArrayList<Integer> result = dfs(clone);
        System.out.println(result);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        return dfs(node, map);
    }

    private static UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        } else {
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(node.label, clone);
            for (int i = 0; i < node.neighbors.size(); i++) {
                clone.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return clone;
        }
    }

    public static ArrayList<Integer> dfs(UndirectedGraphNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        Stack<UndirectedGraphNode> s = new Stack<UndirectedGraphNode>();
        s.push(root);
        visited.put(root, true);
        result.add(root.label);
        while(!s.isEmpty()) {
            UndirectedGraphNode node = s.peek();
            ArrayList<UndirectedGraphNode> unVisited = getUnvisited(node.neighbors, visited);
            for (UndirectedGraphNode neighbor : unVisited) {
                visited.put(neighbor, true);
                result.add(neighbor.label);
                s.push(neighbor);
            }

            if (unVisited.isEmpty()) {
                s.pop();
            }
        }
        return result;
    }

    private static ArrayList<UndirectedGraphNode> getUnvisited(List<UndirectedGraphNode> neighbors, HashMap<UndirectedGraphNode, Boolean> visited) {
        ArrayList<UndirectedGraphNode> result = new ArrayList<UndirectedGraphNode>();
        for (UndirectedGraphNode neighbor : neighbors) {
            if (visited.containsKey(neighbor)) {
                if (!visited.get(neighbor)) {
                    result.add(neighbor);
                }
            }
            else {
                result.add(neighbor);
            }
        }
        return result;
    }
}