package LeetCode.src.Problems.P301_P400.P339_NestedListWeightSum.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        System.out.println(depthSum(nestedList));
    }

    public static int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private static int helper(List<NestedInteger> list, int depth) {
        int ret = 0;
        for (NestedInteger e: list) {
            ret += e.isInteger()? e.getInteger() * depth: helper(e.getList(), depth + 1);
        }
        return ret;
    }
}