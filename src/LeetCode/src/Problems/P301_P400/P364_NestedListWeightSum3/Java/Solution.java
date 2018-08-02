package LeetCode.src.Problems.P301_P400.P364_NestedListWeightSum3.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        System.out.println(depthSumInverse(nestedList));
    }

    public static int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    private static int helper(List<NestedInteger> list, int prev) {
        int intSum = prev;
        List<NestedInteger> levelBreak = new ArrayList<>();
        
        for (NestedInteger e : list) {
            if (e.isInteger()) {
                intSum += e.getInteger();
            } else {
                levelBreak.addAll(e.getList());
            }
        }
        
        int listSum = levelBreak.isEmpty()? 0 : helper(levelBreak, intSum);

        return listSum + intSum;
    }
}