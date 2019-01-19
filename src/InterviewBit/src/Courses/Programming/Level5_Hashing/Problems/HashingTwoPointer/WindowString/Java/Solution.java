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
            int val = map.get(c1);
            if(val > 0) {
                counter--;
            }
            map.put(c1,val-1);            
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

    public static String minWindow2(String A, String B) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : B.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        int left = 0, minLeft=0, minLen =A.length()+1, count = 0;
        for(int right = 0; right<A.length(); right++){
            char r = A.charAt(right);
            if(map.containsKey(r)){//the goal of this part is to get the first window that contains whole t
                map.put(r, map.get(r)-1);
                if(map.get(r)>=0) count++;//identify if the first window is found by counting frequency of the characters of t showing up in S
            }
            while(count == B.length()){//if the count is equal to the length of t, then we find such window
                if(right-left+1 < minLen){//just update the minleft and minlen value
                    minLeft = left;
                    minLen = right-left+1;
                }
                char l = A.charAt(left);
                if(map.containsKey(l)){//starting from the leftmost index of the window, we want to check if s[left] is in t. If so, we will remove it from the window, and increase 1 time on its counter in hashmap which means we will expect the same character later by shifting right index. At the same time, we need to reduce the size of the window due to the removal.
                    map.put(l, map.get(l)+1);
                    if(map.get(l)>0) count--;
                }
                left++;//if it doesn't exist in t, it is not supposed to be in the window, left++. If it does exist in t, the reason is stated as above. left++.
            }
        }
        return minLen==A.length()+1?"":A.substring(minLeft, minLeft+minLen);
    }
}