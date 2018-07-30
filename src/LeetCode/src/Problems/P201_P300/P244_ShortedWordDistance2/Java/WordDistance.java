package LeetCode.src.Problems.P201_P300.P244_ShortedWordDistance2.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {

    private Map<String, List<Integer>> map;
    private String[] wordsArray;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            if(map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(w, list);
            }
        }
        wordsArray = words;
    }
    
    public int shortest_hashMap(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if(index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }

    public int shortest(String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
    
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(word1)) {
                p1 = i;
            }

            if (wordsArray[i].equals(word2)) {
                p2 = i;
            }
                
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */