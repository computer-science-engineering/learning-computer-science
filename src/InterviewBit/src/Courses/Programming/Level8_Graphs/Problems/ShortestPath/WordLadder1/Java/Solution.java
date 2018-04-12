package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.ShortestPath.WordLadder1.Java;

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
        ArrayList<String> dictV = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladderLength(start, end, dictV));
    }

    public static int ladderLength(String start, String end, ArrayList<String> dictV) {
        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.offer(new WordNode(start, 1));
        dictV.add(end);
        Set<String> set = new HashSet<String>(dictV);
        while(!queue.isEmpty()){
            WordNode top = queue.poll();
            String word = top.word;
            
            //if reached end word return number of steps till then
            if(word.equals(end)) {
                return top.numSteps;
            }
            
            char[] arr = word.toCharArray();
            for(int i =0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c) {
                        arr[i] = c;
                    }
                    //For each character change compare the new word in dictionary
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        queue.offer(new WordNode(newWord, top.numSteps + 1));
                        set.remove(newWord);
                    }
                    arr[i] = temp;
                    
                }
            }
            
        }
                  
        return 0;
	}
}