package InterviewBit.src.Courses.Programming.Level2_Arrays.Primers.Array_impl1.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(5);
        input.add(10);
        input.add(2);
        input.add(1);
        ArrayList<Integer> result = performOps(input);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println(result);
    }	

    public static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) {
            B.add(0);
        }
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }
}
