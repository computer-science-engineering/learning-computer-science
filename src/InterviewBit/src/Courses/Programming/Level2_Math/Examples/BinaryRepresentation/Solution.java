package InterviewBit.src.Courses.Programming.Level2_Math.Examples.BinaryRepresentation;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findDigitsInBinary(200));
    }

    public static String findDigitsInBinary(int A) {
        if (A == 0) {
            return "0";
        }
        List<String> resultList = new ArrayList<String>();
        while(A>0) {
            int rem = A%2;
            resultList.add(String.valueOf(rem));            
            A=A/2;
        }
        Collections.reverse(resultList);
        String result = "";
        for (String item : resultList) {
            result += item;
        }
        return result;
    }
}