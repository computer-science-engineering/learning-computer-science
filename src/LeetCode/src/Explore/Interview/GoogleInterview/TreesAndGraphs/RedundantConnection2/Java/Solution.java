package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.RedundantConnection2.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[] result = findRedundantDirectedConnection(edges);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        //construct graph
        Graph g = new Graph(n);
        int[] count = new int[n+1];
        int nodeHas2Parents = -1;
        int nodeLastParent = -1;
        for(int[] edge: edges){
            g.addEdge(edge[0],  edge[1]);
            count[edge[1]]++;
            if(count[edge[1]] > 1){
                nodeHas2Parents = edge[1];
                nodeLastParent = edge[0];
                g.setNode(nodeHas2Parents);
            }
        }
        
        //find result
        if(g.isCycle() == null){//case 1
            return new int[]{nodeLastParent, nodeHas2Parents};
        } else { //case 2 or 3
            return g.isCycle();
        }
    }

    public static int[] findRedundantDirectedConnection_2(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1], ds = new int[n+1];
        Arrays.fill(parent, -1);
        int first = -1, second = -1, last = -1;
        for(int i = 0; i < n; i++) {
            int p = edges[i][0], c = edges[i][1];
            if (parent[c] != -1) {
                first = parent[c];
                second = i;
                continue;
            }
            parent[c] = i;
            
            int p1 = find(ds, p);
            if (p1 == c) last = i;
            else ds[c] = p1;
        }

        if (last == -1) return edges[second]; // no cycle found by removing second
        if (second == -1) return edges[last]; // no edge removed
        return edges[first];
    }
    
    private static int find(int[] ds, int i) {
        return ds[i] == 0 ? i : (ds[i] = find(ds, ds[i]));
    }
}