/**
 * https://www.interviewbit.com/problems/rotate-matrix/
 */
package Courses.Programming.Level2_Arrays.Problems.Arrangement.RotateMatrix.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) { 
        int[][] input = {{1, 2}, {3, 4}};
        int[][] result = rotate(input);
        for(int i=0; i<result.length; i++) {
            for (int j=0; j<result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        ArrayList<ArrayList<Integer>> input2 = new ArrayList<ArrayList<Integer>>();
        input2.add(new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                add(1);
                add(2);
            }});
        input2.add(new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                add(3);
                add(4);
            }});
        ArrayList<ArrayList<Integer>> result2 = rotate3(input2);
        for(int i=0; i<result2.size(); i++) {
            for (int j=0; j<result2.get(0).size(); j++) {
                System.out.print(result2.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }    

    public static int[][] rotate(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = a[i][j];
                a[i][j] = a[n-1-j][i];
                a[n-1-j][i] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[j][n-1-i];
                a[j][n-1-i] = temp;
            }
        }
        return a;
    }
    
    public static ArrayList<ArrayList<Integer>> rotate2(ArrayList<ArrayList<Integer>> a) {
	    int n = a.size();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(n-1-j).get(i));
                a.get(n-1-j).set(i, a.get(n-1-i).get(n-1-j));
                a.get(n-1-i).set(n-1-j, a.get(j).get(n-1-i));
                a.get(j).set(n-1-i, temp);
            }
        }
        return a;
    }
    
    public static ArrayList<ArrayList<Integer>> rotate3(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int s = a.size() - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < s-i; ++j) {
                int temp1 = a.get(s-j).get(i);
                int temp2 = a.get(s-i).get(s-j);
                int temp3 = a.get(j).get(s-i);
                int temp4 = a.get(i).get(j);
                
                // swap
                a.get(i).set(j,temp1);
                a.get(s-j).set(i,temp2);
                a.get(s-i).set(s-j,temp3);
                a.get(j).set(s-i,temp4);
            }
        }
        return a;
	}
}