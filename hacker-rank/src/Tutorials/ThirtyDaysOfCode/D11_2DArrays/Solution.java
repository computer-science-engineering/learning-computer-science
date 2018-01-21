package Tutorials.ThirtyDaysOfCode.D11_2DArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Solution {

    public static void main(String[] args) {
        //System.out.println("Hello World");
        int min = 0;
        int max = 2;
        int rowSize = 6;
        int colSize = 6;
        int[][] myArray = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {

            // print the row of space-separated values
            for (int j = 0; j < colSize; j++) {
                myArray[i][j] = ThreadLocalRandom.current().nextInt(min, max + 1);
                //System.out.print(myArray[i][j] + " ");
            }
            // end of row is reached, print newline
            //System.out.println();
        }
        //System.out.println("************");
        List<int[][]> hourGlassArrays = new ArrayList<>();
        List<Integer> sumArray = new ArrayList<>();
        int sum = 0;
        for (int r = 0; r<rowSize-2; r++){
            for (int c = 0; c<colSize-2; c++){
                hourGlassArrays.add(GetHourGlass(myArray, r, c));
            }
        }
        for (int d=0; d<hourGlassArrays.size(); d++){
            sumArray.add(GetSum(hourGlassArrays.get(d)));
        }

        System.out.println(Collections.max(sumArray));
    }

    public static int[][] GetHourGlass(int[][] fullArray, int rowStartPoint, int colStartPoint) {
        int[][] myArray = new int[3][3];
        int l=0, m=0;
        for (int i = rowStartPoint; i < rowStartPoint + 3; i++) {
            for (int j = colStartPoint; j < colStartPoint + 3; j++) {
                //System.out.print("l: " + l + " m: " + m + "|| ");
                //System.out.print(fullArray[i][j] + " ");
                myArray[l][m] = fullArray[i][j];
                m++;
            }
            m=0;
            l++;
            // end of row is reached, print newline
            //System.out.println();
        }
        //System.out.println("************");
        return myArray;
    }

    public static int GetSum(int[][] array){
        int rowSize = array.length;
        int colSize = array[rowSize - 1].length;
        int sum = 0;
        for (int r = 0; r<rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (r == 1) {
                    if (r != c) {
                        sum = sum + 0;
                    } else {
                        sum = sum + array[r][c];
                    }
                } else {
                    sum = sum + array[r][c];
                }
            }
        }
        return sum;
    }
}
