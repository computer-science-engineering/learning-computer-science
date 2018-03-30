package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket1.AssignMiceToHoles.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, -4, 2));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, 0, 5));
        System.out.println(mice(A, B));
    }
    
    // A - mice; B - holes
    public static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() != B.size()) {
           return -1;
        }
 
        /* Sort the lists */
        Collections.sort(A);
        Collections.sort(B);
 
        int size = A.size();
 
        /* finding max difference between ith mice and hole */
        int max = 0;
        for (int i=0; i<size; i++) {
            if (max < Math.abs(A.get(i)-B.get(i))) {
                max = Math.abs(A.get(i)-B.get(i));
            }
        }
 
        return Math.abs(max);
    }
}