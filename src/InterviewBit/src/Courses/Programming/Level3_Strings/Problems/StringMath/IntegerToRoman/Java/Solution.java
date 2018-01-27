package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringMath.IntegerToRoman.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(14));
    }
    
    public static String intToRoman(int A) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM"); // special case
        map.put(500, "D");
        map.put(400, "CD"); // special case
        map.put(100, "C");
        map.put(90, "XC"); // special case
        map.put(50, "L");
        map.put(40, "XL"); // special case
        map.put(10, "X");
        map.put(9, "IX"); // special case
        map.put(5, "V");
        map.put(4, "IV"); // special case
        map.put(1, "I");

        int l =  map.floorKey(A);
        if (A == l) {
            return map.get(A);
        }
        return map.get(l) + intToRoman(A-l);
    }
}