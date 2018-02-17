package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.Permutations.Permutations.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> result = permute(A);
        for (ArrayList<Integer> internalList : result) {
            for (int i=0; i<internalList.size()-1; i++) {           
                System.out.print(internalList.get(i) + ", ");
            }
            System.out.print(internalList.get(internalList.size()-1));
            System.out.println();          
        }
    }
    
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), A);
        return list;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> list, List<Integer> tempList, ArrayList<Integer> nums){
        if(tempList.size() == nums.size()){
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.size(); i++){ 
                if(tempList.contains(nums.get(i))) continue; // element already exists, skip
                tempList.add(nums.get(i));
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    } 
}