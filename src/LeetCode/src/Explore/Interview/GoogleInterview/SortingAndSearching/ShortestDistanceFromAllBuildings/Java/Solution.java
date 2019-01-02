package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.ShortestDistanceFromAllBuildings.Java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {
            {1,0,2,0,1},
            {0,0,0,0,0},
            {0,0,1,0,0}
        };
        System.out.println(shortestDistance(grid));
    }

    //count sum of distance from 0 to all building
    private static int[][] distance;
    //count how many building each '0' can be reached
    private static int[][] reach ;
    private static int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int m  = grid.length, n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        int buildingNum = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    buildingNum++;
                    bfs(grid,i,j);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    
    private static void bfs(int[][] grid,int x, int y) {
        int m  = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x,y});
        boolean[][] visited = new boolean[m][n];
        int level=1;
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i=0;i<size;i++) {
                int[] current=q.poll();
                for (int[] dir:dirs) {
                    int x1 = dir[0] + current[0];
                    int y1 = dir[1] + current[1];
                    if(x1<0 || x1>=m || y1<0 || y1>=n) continue;
                    if(grid[x1][y1]!=0 || visited[x1][y1]) continue;
                    //find next 0: level++;
                    distance[x1][y1] += level;
                    reach[x1][y1]++;
                    visited[x1][y1]=true;
                    q.offer(new int[]{x1,y1});
                }
            }
            level++;
        }  
    }
}