package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Problems.SortModification.MedianOfArray.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 4, 5);
        List<Integer> b = Arrays.asList(2, 3);
        System.out.println(findMedianSortedArrays(a, b));
    }
    
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {        
        int m = a.size();
        int n = b.size();
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }
        if ((m + n) % 2 != 0) {
            return (double)findKth(a, b, (m + n + 1) / 2);
        } else {
            return ((double)findKth(a, b, (m + n) / 2) + findKth(a, b, (m + n) / 2 + 1)) / 2;
        }
    }    

    private static int findKth(List<Integer> a, List<Integer> b, int k) {
        int iMin = Math.max(0, k - b.size());
        int iMax = Math.min(a.size(), k);
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = k - i;
            if (i > 0 && j < b.size() && a.get(i - 1) > b.get(j)) {
                iMax = i - 1;
            } else if (j > 0 && i < a.size() && b.get(j - 1) > a.get(i)) {
                iMin = i + 1;
            } else {
                if (i == 0) {
                    return b.get(k - 1);
                }
                if (j == 0) {
                    return a.get(k - 1);
                }
                return Math.max(a.get(i - 1), b.get(k - i - 1));
            }
        }
        return 0;
    }

    public static double findMedianSortedArrays2(final List<Integer> a, final List<Integer> b) {
        int[] x = new int[a.size()];
        int[] y = new int[b.size()];
        for (int i=0; i<a.size(); i++) {
            x[i] = a.get(i);
        }
        for (int j=0; j<b.size(); j++) {
            y[j] = b.get(j);
        }
        int m = x.length;
        int n = y.length;
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }
        if ((m + n) % 2 != 0) {
            return (double)findKth2(x, y, (m + n + 1) / 2);
        } else {
            return ((double)findKth2(x, y, (m + n) / 2) + findKth2(x, y, (m + n) / 2 + 1)) / 2;
        }
    } 

    private static int findKth2(int[] a, int[] b, int k) {
        int iMin = Math.max(0, k - b.length);
        int iMax = Math.min(a.length, k);
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = k - i;
            if (i > 0 && j < b.length && a[i - 1] > b[j]) {
                iMax = i - 1;
            } else if (j > 0 && i < a.length && b[j - 1] > a[i]) {
                iMin = i + 1;
            } else {
                if (i == 0) {
                    return b[k - 1];
                }
                if (j == 0) {
                    return a[k - 1];
                }
                return Math.max(a[i - 1], b[k - i - 1]);
            }
        }
        return 0;
    }
}