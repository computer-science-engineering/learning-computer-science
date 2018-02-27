package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.HashingTwoPointer.WindowString.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    
    public static String minWindow(String A, String B) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : A.toCharArray()) {
            map.put(c,0);
        }
        for(char c : B.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                return "";
            }
        }
        
        int start=0, end=0, minStart=0, minLen=Integer.MAX_VALUE, counter=B.length();
        while(end < A.length()) {
            char c1 = A.charAt(end);
            if(map.get(c1) > 0) {
                counter--;
            }
            map.put(c1,map.get(c1)-1);            
            end++;
            
            while(counter == 0) {
                if(minLen > end-start) {
                    minLen = end-start;
                    minStart = start;
                }
                
                char c2 = A.charAt(start);
                map.put(c2, map.get(c2)+1);
                
                if(map.get(c2) > 0) {
                    counter++;
                }
                
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : A.substring(minStart,minStart+minLen);
    }
}