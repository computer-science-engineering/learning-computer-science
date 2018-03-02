package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.MathsAndHashing.PointsOnTheStraightLine.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(0, 1, -1));
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(0, 1, -1));
        System.out.println(maxPoints(a, b));
    }
    
    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null || b == null) {
            return 0;
        }
        int n = a.size();
        int result = 0;
        if (n <= 2) {
            return n;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for(int j=i+1 ; j<n ; j++) {
                int x = a.get(j) - a.get(i);
                int y = b.get(j) - b.get(i);
                if (x==0 && y==0) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(x,y); // gcd will never be zero.
                x/=gcd;
                y/=gcd;
                String key = x + ":" + y;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key)+1);
                }
                else {
                    map.put(key, 1);
                }
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max+overlap+1);
        }
        return result;
    }

    private static int gcd(int a,int b){    
        if (b==0) { 
            return a;
        }
        else return gcd(b,a%b);        
    }
    
    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
        
    }
}