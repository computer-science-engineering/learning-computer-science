package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.DpOptimizedBacktrack.WordBreak2.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String A = "catsanddog";
        ArrayList<String> B = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        ArrayList<String> result = wordBreak(A, B);
        System.out.println(result);
    }
    
    public static ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        ArrayList<String> returnResult = new ArrayList<String>();
        Set<String> wordDict = new HashSet<String>(B);
        List<String> result = DFS(A, wordDict, new HashMap<String, LinkedList<String>>());
        returnResult.addAll(result);
        Collections.sort(returnResult);
        return returnResult;
    }

    private static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
            
        LinkedList<String> res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>subList = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : subList) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
}