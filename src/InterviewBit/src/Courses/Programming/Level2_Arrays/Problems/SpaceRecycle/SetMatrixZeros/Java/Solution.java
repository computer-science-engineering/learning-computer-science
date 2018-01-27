package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.SpaceRecycle.SetMatrixZeros.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{0, 0}, {1, 0}};
        int[][] result = setZeroes(input);
        for(int i=0; i<result.length; i++) {
            for (int j=0; j<result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroesDumb(ArrayList<ArrayList<Integer>> a) {
        int[][] input = new int[a.size()][a.size()];
        for(int i=0; i<a.size(); i++) {
            for (int j=0; j<a.size(); j++) {
                input[i][j] = a.get(i).get(j);
            }
        }

        setZeroes(input);
    }

    public static int[][] setZeroes(int[][] a) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
 
        // Step1: set first row and column zero or not
        for(int i=0; i<a.length; i++){
            if(a[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<a[0].length; i++){
            if(a[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        // Step2: mark zeros on first row and column
        for(int i=1; i<a.length; i++){
            for(int j=1; j<a[0].length; j++){
                if(a[i][j] == 0){
                   a[i][0] = 0;
                   a[0][j] = 0;
                }
            }
        }

        // Step3: use mark to set elements
        for(int i=1; i<a.length; i++){
            for(int j=1; j<a[0].length; j++){
                if(a[i][0] == 0 || a[0][j] == 0){
                   a[i][j] = 0;
                }
            }
        }

        // Step4: set first column and row
        if(firstColumnZero){
            for(int i=0; i<a.length; i++) {
                a[i][0] = 0;
            }
        }
 
        if(firstRowZero){
            for(int i=0; i<a[0].length; i++) {
                a[0][i] = 0;
            }
        }

        return a;
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    boolean firstRowZero = false;
        boolean firstColumnZero = false;
 
        // set first row and column zero or not
        for(int i=0; i<a.size(); i++){
            if(a.get(i).get(0) == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<a.get(0).size(); i++){
            if(a.get(0).get(i) == 0){
                firstRowZero = true;
                break;
            }
        }

        // mark zeros on first row and column
        for(int i=1; i<a.size(); i++){
            for(int j=1; j<a.get(0).size(); j++){
                if(a.get(i).get(j) == 0){
                   a.get(i).set(0, 0);
                   a.get(0).set(j, 0);
                }
            }
        }

        // use mark to set elements
        for(int i=1; i<a.size(); i++){
            for(int j=1; j<a.get(0).size(); j++){
                if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0){
                   a.get(i).set(j, 0);
                }
            }
        }

        // set first column and row
        if(firstColumnZero){
            for(int i=0; i<a.size(); i++) {
                a.get(i).set(0, 0);
            }
        }
 
        if(firstRowZero){
            for(int i=0; i<a.get(0).size(); i++) {
                a.get(0).set(i, 0);
            }
        }

	}
}