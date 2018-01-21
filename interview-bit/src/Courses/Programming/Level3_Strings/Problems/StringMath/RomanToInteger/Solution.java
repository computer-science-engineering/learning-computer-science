package Courses.Programming.Level3_Strings.Problems.StringMath.RomanToInteger;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));
    }

    public static int romanToInt(String A) {
        A = A.toLowerCase();
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        ht.put('i',1);
        ht.put('x',10);
        ht.put('c',100);
        ht.put('m',1000);
        ht.put('v',5);
        ht.put('l',50);
        ht.put('d',500);

        int intNum=0;
        int prev = 0;
        for(int i = A.length()-1; i>=0 ; i--) {
            int temp = ht.get(A.charAt(i));
            if(temp < prev) {
                intNum-=temp;
            }
            else {
                intNum+=temp;
            }
            prev = temp;
        }
        return intNum;
    }
}