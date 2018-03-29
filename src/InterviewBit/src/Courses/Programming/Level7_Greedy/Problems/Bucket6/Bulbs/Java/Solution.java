package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket6.Bulbs.Java;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1));
        System.out.println(bulbs(A));
    }
    
    public static int bulbs(ArrayList<Integer> A) {
        int state= 0, result = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == state) {
                result++;
                state = 1 - state;
            }
        }        
        return result;
    }
}