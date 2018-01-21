/**
 * https://www.interviewbit.com/problems/arraybug/
 * rotate the array A by B positions.
 * So, for example,
 * A : [1 2 3 4 5 6]
 * B : 1
 * The output : [2 3 4 5 6 1]
*/
package Courses.Programming.Level2_Arrays.Primers.ArrayBug.Java;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(7);
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(8);
        ArrayList<Integer> result = rotateArray(input, 10);
        scan.close();
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
