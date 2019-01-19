package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.CourseSchedule.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish_bfs(numCourses, prerequisites));
        System.out.println(canFinish_dfs(numCourses, prerequisites));
    }

    public static boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // size: numCourses
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph.add(i, new ArrayList<Integer>());
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph.get(course).size();i++){
                int pointer = (int)graph.get(course).get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }

    public static boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // size: numCourses
        for(int i=0;i<numCourses;i++) {
            graph.add(i, new ArrayList<Integer>());
        }
            
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!dfs(graph,visited,i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int course){
        if(visited[course]) {
            return false;
        }
        else {
            visited[course] = true;
        }

        for(int i=0; i<graph.get(course).size();i++) {
            if(!dfs(graph,visited,(int)graph.get(course).get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}