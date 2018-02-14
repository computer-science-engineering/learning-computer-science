package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.BruteforceBuilder.PalindromePartitioning.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String input = "aab";
        ArrayList<ArrayList<String>> result = partition(input);
        for (ArrayList<String> internalList : result) {
            for (int i=0; i<internalList.size()-1; i++) {           
                System.out.print(internalList.get(i) + ", ");
            }
            System.out.print(internalList.get(internalList.size()-1));
            System.out.println();          
        }
    }
    
    public static ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        dfs(a,0,list,res);
        return res;
    }
    
    private static void dfs(String s, int pos, ArrayList<String> list, ArrayList<ArrayList<String>> res) {
        if(pos==s.length()) {
            res.add(new ArrayList<String>(list));
        }
        else {
            for(int i=pos; i<s.length(); i++) {
                if(isPalindrome(s,pos,i)) {
                    list.add(s.substring(pos, i+1));
                    dfs(s, i+1, list, res);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    
    private static boolean isPalindrome(String s, int low, int high){
        while(low<high) {
            if(s.charAt(low++)!=s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}