package LeetCode.src.Problems.P301_P400.P387_FirstUniqueCharacterInAString.Java;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i=0; i<=ch.length-1; i++) {
            map.put(ch[i], !map.containsKey(ch[i]) ? new int[]{i, 1} : new int[]{i, map.get(ch[i])[1]+1});
        }

        List<Integer> resultList = map.values().stream().filter(x -> x[1] == 1).map(y -> y[0]).collect(Collectors.toList());
        if (resultList.isEmpty()) {
            return -1;
        }
        else {
            return Collections.min(resultList);
        }
    }

    public static int firstUniqChar_optimized(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++) {
            freq [s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i ++) {
            if(freq [s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}