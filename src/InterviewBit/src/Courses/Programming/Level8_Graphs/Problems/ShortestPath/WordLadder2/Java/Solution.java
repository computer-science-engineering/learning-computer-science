package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.ShortestPath.WordLadder2.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        ArrayList<String> dict = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(findLadders(start, end, dict));
    }

    public static ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Queue<WordNode> queue  = new LinkedList<WordNode>();
        queue.offer(new WordNode(start, 1, null));                
        
        Set<String> dictSet = new HashSet<String>(dict);
        dictSet.add(end);
        int minStep  = 0;
        
        Set<String> visited = new HashSet<String>();
        Set<String> unvisited  = new HashSet<String>();
        unvisited.addAll(dictSet);
        
        int preNumSteps = 0;
        
        while(!queue.isEmpty()) {   
            //System.out.println("Queue : " + queue);
            WordNode top = queue.poll();
            //System.out.println("For Word : " + top.word);
            String word = top.word;
            int currentNumSteps = top.numSteps;
            
            if(word.equals(end)) {
                if(minStep == 0) {
                    minStep = top.numSteps;
                }
                if(top.numSteps == minStep && minStep != 0) { // Why do we even need this line? Should be an else.
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre != null) {
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }
            
            if(preNumSteps < currentNumSteps) {
                unvisited.removeAll(visited);
            }
            
            preNumSteps = currentNumSteps;
            
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if(arr[i] != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)) {                       
                        queue.offer(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }            
        }
        return result;
	}
}