package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.RangeModule.Java;

import org.junit.Assert;

public class Solution {
    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        int left = 10, right = 20;
        rangeModule.addRange(left,right);
        Assert.assertTrue(rangeModule.queryRange(left,right));
        rangeModule.removeRange(14,16);
        Assert.assertTrue(rangeModule.queryRange(10, 14));
        Assert.assertFalse(rangeModule.queryRange(13, 15));
        Assert.assertTrue(rangeModule.queryRange(16, 17));
    }
}