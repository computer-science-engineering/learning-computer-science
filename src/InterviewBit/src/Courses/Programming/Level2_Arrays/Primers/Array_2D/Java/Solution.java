package InterviewBit.src.Courses.Programming.Level2_Arrays.Primers.Array_2D.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }});
        input.add(new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                add(5);
                add(6);
                add(7);
                add(8);
            }});
        input.add(new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                add(9);
                add(10);
                add(11);
                add(12);
            }});
        ArrayList<ArrayList<Integer>> B = performOps(input);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                    System.out.print(B.get(i).get(j) + " ");
            }
        }
        System.out.println(B);
    }

    public static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
}