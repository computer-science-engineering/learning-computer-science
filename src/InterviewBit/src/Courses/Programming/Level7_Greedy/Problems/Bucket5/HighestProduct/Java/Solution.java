package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket5.HighestProduct.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, -1, 3, 100, 70, 50));
        System.out.println(maxp3(A));
    }
    
    public static int maxp3(ArrayList<Integer> A) {
        if(A == null || A.size() < 3) {
            return 0;
        }
        Collections.sort(A);
        int l = A.size();
        return Math.max(A.get(l-1)*A.get(l-2)*A.get(l-3), A.get(l-1)*A.get(0)*A.get(1));    
    }
}