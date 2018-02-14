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
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(A == null || A.size() == 0) {
            return results;
        }
        Collections.sort(A);
        HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
        backtrack(results, new ArrayList<>(), A, B, 0, set);
        return results;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> results, List<Integer> combination, ArrayList<Integer> nums, int target, int startIndex, HashSet<ArrayList<Integer>> set) {
        if(target < 0) {
            return;
        }
        else if(target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(combination);
            if(!set.contains(temp)){
                set.add(temp);
                results.add(temp);
            }
            return;
        }
        else { 
            for(int i = startIndex; i < nums.size(); i++) {
                if(target < nums.get(i)) {
                    break;
                }
                combination.add(nums.get(i));
                backtrack(results, combination, nums, target - nums.get(i), i, set); // not i + 1 because we can reuse same elements
                combination.remove(combination.size() - 1);
            }
        }
    }    
}