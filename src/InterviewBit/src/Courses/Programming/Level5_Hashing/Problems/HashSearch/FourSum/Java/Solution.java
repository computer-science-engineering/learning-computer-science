package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.HashSearch.FourSum.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 0, -1, 0, -2, 2));
        ArrayList<ArrayList<Integer>> result = fourSum(nums, 0);
        for (ArrayList<Integer> internalList : result) {
            for (int i=0; i<internalList.size()-1; i++) {           
                System.out.print(internalList.get(i) + ", ");
            }
            System.out.print(internalList.get(internalList.size()-1));
            System.out.println();          
        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        return kSum(A, 0, 4, B);
    }

    private static ArrayList<ArrayList<Integer>> kSum (ArrayList<Integer> nums, int start, int k, int target) {
        int len = nums.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k == 2) { //two pointers from left and right
            int left = start, right = len - 1;
            while(left < right) {
                int sum = nums.get(left) + nums.get(right);
                if(sum == target) {
                    ArrayList<Integer> path = new ArrayList<Integer>();
                    path.add(nums.get(left));
                    path.add(nums.get(right));
                    res.add(path);
                    while(left < right && nums.get(left) == nums.get(left+1)) left++;
                    while(left < right && nums.get(right) == nums.get(right-1)) right--;
                    left++;
                    right--;
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else {
            for(int i = start; i < len - (k - 1); i++) {
                if(i > start && nums.get(i) == nums.get(i - 1)) {
                    continue;
                }
                ArrayList<ArrayList<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums.get(i));
                for(List<Integer> t : temp) {
                   t.add(0, nums.get(i));
                }                    
                res.addAll(temp);
            }
        }
        return res;
    }    
}