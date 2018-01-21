package Courses.Programming.Level2_Arrays.Examples.SpiralOrderMatrix1.Java;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/spiral-order-matrix-i
*/
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<Integer>() { 
            private static final long serialVersionUID = 1L;
            {
                add(1);
                add(2);
            }});
        input.add(new ArrayList<Integer>() { 
            private static final long serialVersionUID = 1L;
            {
                add(3);
                add(4);
            }});
        input.add(new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;
            {
                add(5);
                add(6);
            }});
        ArrayList<Integer> result = spiralOrder(input);
        scan.close();
        System.out.println(result);
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rows = a.size();
        int cols = a.get(0).size();
        int top = 0, bottom = rows-1, left = 0, right = cols-1;
        int dir = 0; // 0:left to right;1:top to bottom;2: right to left;3: bottom to top
        while(top<=bottom && left<=right){
            if (dir==0){
                for (int i=left; i<=right; i++){
                    result.add(a.get(top).get(i));
                }
                top++;
                dir = 1;
            }
            else if(dir==1){
                for (int i=top; i<=bottom; i++){
                    result.add(a.get(i).get(right));
                }
                right--;
                dir = 2;
            }
            else if(dir==2){
                for (int i=right; i>=left; i--){
                    result.add(a.get(bottom).get(i));
                }
                bottom--;
                dir = 3;
            }
            else if(dir==3){
                for (int i=bottom; i>=top; i--){
                    result.add(a.get(i).get(left));
                }
                left++;
                dir = 0;
            }
        }

        return result;
    }
}
