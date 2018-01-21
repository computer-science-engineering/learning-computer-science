package Courses.Programming.Level3_BinarySearch.Problems.SortModification.RotatedSortedArraySearch;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4, 5, 6, 7, 0, 1, 2);
        System.out.println(search(input, 4));
    }
    
    public static int search(final List<Integer> a, int b) {
        int left = 0;
        int right = a.size() - 1;
       
        while (left <= right) {
          // Avoid overflow, same as mid=(left+right)/2
          int mid = left + ((right - left) / 2);
          if (a.get(mid) == b) {
              return mid;
          }
       
          // the bottom half is sorted
          if (a.get(left) <= a.get(mid)) {
            if (a.get(left) <= b && b < a.get(mid)) {
              right = mid - 1;
            }
            else {
              left = mid + 1;
            }
          }
          else { // the upper half is sorted
            if (a.get(mid) < b && b <= a.get(right)) {
              left = mid + 1;
            }
            else {
              right = mid - 1;
            }
          }
        }
        return -1;
	}
}