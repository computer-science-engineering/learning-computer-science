package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.HashSearch.TwoSum.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int[] result = twoSum(input, -3);
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        sb.append(" ");
        sb.append(result[1]);
        System.out.println(sb.toString());
    }

    public static int[] twoSumEditorial(final int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++) {            
            int value = B - A[i];            
            if(map.containsKey(value)) {
                int[] result = new int[2];
                result[0] = map.get(value) + 1;
                result[1] = i + 1;
                return result;
            }
            else {                
                if(!map.containsKey(A[i])) {
                    map.put(A[i], i);
                }
            }
        }        
        return new int[0];
    }
    
    public static int[] twoSum(final int[] A, int B) {
        ArrayList<Point> points = new ArrayList<>();
        int[] result = new int[2];
        int num, diff, index;
        if(A==null || A.length<2) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=A.length-1; i>=0; i--) {
            num = A[i];
            diff = B-num;
            if(map.containsKey(diff)) {
                index = map.get(diff);
                points.add(new Point(i+1, index+1));
            }

            map.put(num, i);
        }
        
        if (points.size() > 0) {
            Collections.sort(points);
            result[0] = points.get(0).left;
            result[1] = points.get(0).right;
            return result;
        }

        return new int[]{};
    }

    static class Point implements Comparable<Point> {
        
        int left;
        int right;
        
        public Point(int left, int right) {
            this.left = left;
            this.right  = right;
        }
        
        public int compareTo(Point o) {
            if (this.right < o.right) {
                return -1;
            }
            if (this.right > o.right) {
                return 1;
            }
                
            return Integer.compare(this.left, o.left);
        }        
    }
}