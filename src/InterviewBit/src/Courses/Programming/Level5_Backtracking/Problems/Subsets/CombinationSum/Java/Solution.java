package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.Subsets.CombinationSum.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2,3,6,7));
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        int sum = 7;
        //int sum = 28;
        ArrayList<ArrayList<Integer>> result = combinationSum(A, sum);
        for (ArrayList<Integer> internalList : result) {
            for (int i=0; i<internalList.size()-1; i++) {           
                System.out.print(internalList.get(i) + ", ");
            }
            System.out.print(internalList.get(internalList.size()-1));
            System.out.println();          
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Collections.sort(A);
        backtrack(list, new ArrayList<>(), A, B, 0);
        return list;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> list, List<Integer> tempList, ArrayList<Integer> nums, int remain, int start) {
        if(remain < 0) {
            return;
        }
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else { 
            for(int i = start; i < nums.size(); i++) {
                if(remain < nums.get(i)) {
                    return;
                }
                tempList.add(nums.get(i));
                backtrack(list, tempList, nums, remain - nums.get(i), i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }    
}