package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Problems.SimpleBinarySearch.SearchForARange.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5, 7, 7, 8, 8, 10);
        ArrayList<Integer> result = searchRange(input, 8);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }    

    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(-1);
        ret.add(-1);
        int start = 0;
        int end = a.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (a.get(mid) < b) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        int low;
        if (a.get(start) != b) {
            return ret;
        }
        else {
            low = start;
        }
        start = 0;
        end = a.size()- 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (a.get(mid) < b + 1) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        int high = a.get(start) == b ? start : start - 1;
        ret.set(0, low);
        ret.set(1, high);
        return ret;
    }
}