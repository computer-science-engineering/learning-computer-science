package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.InplaceUpdate.RemoveDuplicatesFromSortedArray.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        //ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5000, 5000, 5000));
        System.out.println(removeDuplicates(input));
    }    

    public static int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() < 2) {
            return a.size();
        }

        int j = 0;
        int i = 1;
    
        while (i < a.size()) {
            if (a.get(i).equals(a.get(j))) {
                i++;
            } else {
                j++;
                a.set(j, a.get(i));
                i++;
            }
        }
    
        return j + 1;
	}
}