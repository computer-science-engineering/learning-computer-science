package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.RedundantConnection2.Java;

import java.util.LinkedList;

public class Graph {
    int n;
    LinkedList<Integer> adj[];
    int nodeHasTwoParents = -1;
    int[] pair = {-1, -1}; //the pair in the loop whose node has two parents
    int index = 0; 
    int[][] map; // map tracking edge index
    int lastIndexSorFar = -1; // last edge in the loop
    
    Graph(int n){
        this.n = n;
        adj = new LinkedList[n+1];
        for(int i = 0; i <= n; i++){
            adj[i] = new LinkedList();
        }
        map = new int[n+1][n+1];
    }
    
    void addEdge(int v, int w){
        adj[v].add(w);
        map[v][w] = index++;
    }
    
    void setNode(int node){
        nodeHasTwoParents = node;
    }
    
    int[] isCycle(){
        boolean[] visited = new boolean[n+1];      
        boolean[] revisited = new boolean[n+1];  
        
        for(int i = 1; i <= n; i++){
            if(isCycleUntil(i, visited, revisited)){
                break;
            }
        }
        
        if(pair[0] == -1){//case 1
            return null;
        }else{//case 2 or 3
            return pair;
        }
    }
    
    boolean isCycleUntil(int i , boolean[] visited, boolean[] revisited){
        if(revisited[i]){
            return true;
        }
        
        if(visited[i]){
            return false;
        }
        
        visited[i] = true;
        revisited[i] = true;
        
        LinkedList<Integer> children = adj[i];
        for(Integer child: children){
            if(isCycleUntil(child, visited, revisited)){
                if(nodeHasTwoParents != -1 ){//case 2
                    if( child == nodeHasTwoParents && pair[0] == -1 ){
                        pair[0] = i;
                        pair[1] = child;
                    }
                }else{// case 3: return the last one in the edges that is in the cycle
                    if(map[i][child] > lastIndexSorFar && pair[0] == -1){
                        lastIndexSorFar = map[i][child];
                        pair[0] = i;
                        pair[1] = child;
                    }
                }
                return true;
            }
        }
        revisited[i] = false;
        return false;
    }
}