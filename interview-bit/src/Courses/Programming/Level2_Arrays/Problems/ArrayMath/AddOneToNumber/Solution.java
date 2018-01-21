package Courses.Programming.Level2_Arrays.Problems.ArrayMath.AddOneToNumber;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class Solution{
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(0);
        System.out.println(plusOne(a));
    }    

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if (a.size() > 1) {
            while(a.get(0) == 0){
                if(a.get(0) > 0 || a.size() == 1) {
                    break;
                }
                a.remove(0);
            }
        }
        for (int i = a.size()- 1; i >= 0; --i) {
            int temp = a.get(i);
            a.set(i, temp+1);
            if (a.get(i) < 10) {
                return a;
            }
            a.set(i, 0);
        }
        ArrayList<Integer> result = new ArrayList<Integer>(a.size() + 1);        
        result.add(1);
        for(int j=0; j<a.size(); j++) {
            result.add(j+1, a.get(j));
        }
        result.set(0, 1);
        return result;
    }
}