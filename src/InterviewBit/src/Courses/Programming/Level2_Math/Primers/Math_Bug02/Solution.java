package InterviewBit.src.Courses.Programming.Level2_Math.Primers.Math_Bug02;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = squareSum(20);
        for(int i=0; i<result.size(); i++) {
            for (int j=0; j<result.get(0).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A<0) {
            return ans;
        }
        for (int a = 0; a * a < A; a++) {
            for (int b = 0; b * b < A; b++) {
                if ((a <= b) && (a * a + b * b == A)) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }
    
}