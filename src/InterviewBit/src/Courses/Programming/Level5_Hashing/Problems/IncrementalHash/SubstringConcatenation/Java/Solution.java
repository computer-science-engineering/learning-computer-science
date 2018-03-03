package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.IncrementalHash.SubstringConcatenation.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String A = "barfoothefoobarman";
        List<String> B = new ArrayList<String>(Arrays.asList("foo", "bar"));
        ArrayList<Integer> result = findSubstring(A, B);
        for (Integer item : result) {
            System.out.println(item);        
        }
    }

    public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        if(B == null || B.size() == 0 || A.length() == 0) {
            return res;
        }
        int wordLen = B.get(0).length();
        int numWord = B.size();
        int windowLen = wordLen * numWord;
        int sLen = A.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : B) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {  // Move window in step of wordLen
                // count: number of exceeded occurrences in current window
                // start: start index of current window of size windowLen
                if(start + windowLen > sLen) break;
                String word = A.substring(j, j + wordLen);
                if(!map.containsKey(word)) {
                    curMap.clear();
                    count = 0;
                    start = j + wordLen;
                }
                else {
                    if(j == start + windowLen) { // Remove previous word of current window
                        String preWord = A.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curMap.get(preWord);
                        if(val == 1) curMap.remove(preWord);
                        else curMap.put(preWord, val - 1);
                        if(val - 1 >= map.get(preWord)) count--;  // Reduce count of exceeded word
                    }
                    // Add new word
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                    if(curMap.get(word) > map.get(word)) count++;  // More than expected, increase count
                    // Check if current window valid
                    if(count == 0 && start + windowLen == j + wordLen) {
                        res.add(start);
                    }
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> findSubstring_Editorial(String A, final List<String> B) {	    
	    ArrayList<Integer> res = new ArrayList<>();	    
	    if (A == null || B == null || B.size() == 0 || A.length() == 0) {
            return res;
        }
	    
	    HashMap<String, Integer> words = new HashMap<>();
	    int len = 0;
	    
	    for (String str : B) {
	        int val = 1;
	        if (words.containsKey(str)) {
	            val = words.get(str) + 1;
	        }
	        words.put(str, val);
	        len = str.length();
	    }
	    
	    int size = B.size();
	    int index;
	    
	    for (int i = 0; i <= A.length() - len * size; i++) {	        
	        index = i;
	        int loop = size;
	        HashMap<String, Integer> hashMap = new HashMap<>(words);
	        
	        for (int j = 0; j < loop; j++) {
	            String str = A.substring(index + j * len, index + j * len + len);
	            if (hashMap.containsKey(str)) {
	                int val = hashMap.get(str);
	                if (val == 1) {
	                    hashMap.remove(str);
	                } else {
	                    hashMap.put(str, val - 1);
	                }
	            } else {
	                break;
	            }
	        }
	        
	        if (hashMap.isEmpty()) {
	            res.add(i);
	        }	        
	    }	    
	    return res;	    
	}    
}