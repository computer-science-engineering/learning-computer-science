package LeetCode.src.Problems.P1_P100.P14_LongestCommonPrefix.Java;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}