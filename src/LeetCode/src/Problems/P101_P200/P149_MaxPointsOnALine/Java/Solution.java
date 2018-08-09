package LeetCode.src.Problems.P101_P200.P149_MaxPointsOnALine.Java;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Point[] points = {
            new Point(1,1),
            new Point(3,2),
            new Point(5,3),
            new Point(4,1),
            new Point(2,3),
            new Point(1,4)
        };
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        // double for loop to try all points. O(n^2)
        for (int i = 0; i < points.length; i++) {
            int max = 0, overlap = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y); // Instead of GCD we can use slope ((double)y / (double)x) as map's key directly.
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                String key = x + ":" + y;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;

    }

    private static int generateGCD(int a, int b) {    
        if (b==0) {
            return a;
        }
        else return generateGCD(b,a%b);        
    }
}