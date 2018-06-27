package InterviewBit.src.Courses.Programming.Level2_Math.Examples.AllFactors.Java;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int input = 38808;
        ArrayList<Integer> result = allFactors(input);
        for(int i=0; i<result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
    
    public static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=1; i<=(int)Math.sqrt(a); i++) {
            if (a%i == 0) {
                result.add(i);
                if (i != Math.sqrt(a)) { // if(i != a/i)
                    result.add(a/i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}