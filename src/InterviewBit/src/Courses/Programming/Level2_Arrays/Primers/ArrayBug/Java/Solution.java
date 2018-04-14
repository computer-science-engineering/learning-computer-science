package InterviewBit.src.Courses.Programming.Level2_Arrays.Primers.ArrayBug.Java;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(7);
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(8);
        ArrayList<Integer> result = rotateArray(input, 1);
        System.out.println(result);
	}	
	
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		int rot = B%A.size();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>(rot);
		for (int i = 0; i < A.size(); i++) {
		    if (i < rot) {		    
		        temp.add(A.get(i));
		    }
		    if (i + rot < A.size()) {
			    ret.add(A.get(i + rot));
		    }
		}
		for (int j=0; j<temp.size(); j++) {
		    ret.add(temp.get(j));
		}
		return ret;
	}
}
