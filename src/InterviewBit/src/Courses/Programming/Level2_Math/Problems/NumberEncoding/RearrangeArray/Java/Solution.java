package InterviewBit.src.Courses.Programming.Level2_Math.Problems.NumberEncoding.RearrangeArray.Java;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(2, 1, 0));
        arrange(input);
        for (Integer item : input) {
            System.out.print(item + " ");
        }
    }
    
    public static void arrange(ArrayList<Integer> a) {
        for (int i=0; i < a.size(); i++) {
            a.set(i, a.get(i) + (a.get(a.get(i))%a.size())*a.size()); // arr[i] = (arr[arr[i]] % n) * n
        }

        for (int i=0; i<a.size(); i++) {
            a.set(i, a.get(i) / a.size());
        }
	}
}