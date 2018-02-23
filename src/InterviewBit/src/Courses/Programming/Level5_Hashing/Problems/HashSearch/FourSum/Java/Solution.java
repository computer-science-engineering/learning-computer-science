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

    public static int[][] fourSumEditorial(int[] A, int B) {
        Arrays.sort(A);
        
        ArrayList<String> arr = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                for(int k = j + 1; k < A.length; k++) {
                    for(int l = k + 1; l < A.length; l++) {
                        if(A[i] + A[j] + A[k] + A[l] == B) {
                            String inter = String.valueOf(A[i])+" "+String.valueOf(A[j])+" "
                            +String.valueOf(A[k])+" "+String.valueOf(A[l]);
                            
                            if(map.containsKey(inter)) {
                                //do nothing
                            } else {
                                map.put(inter, 1);
                                arr.add(inter);
                            }
                        }
                    }
                }
            }
        }
        
        int [][] res = new int[arr.size()][4];
        
        for(int m = 0; m < arr.size(); m++) {
            String [] temp = arr.get(m).split("\\s");
            for(int h = 0; h < temp.length; h++) {
                res[m][h] = Integer.parseInt(temp[h]);
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        int[] a = new int[A.size()];
        int i = 0;
        for (Integer var : A) {
            a[i++] = var;
        }
        return kSum_Trim(a, B, 4);
    }

    private static ArrayList<ArrayList<Integer>> kSum_Trim(int[] a, int target, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSum(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

    private static void kSum(int[] a, int target, int k, int start, ArrayList<ArrayList<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;
        
        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if (a[left] + a[right] < target) {
                    left++;
                }
                else if (a[left] + a[right] > target) {
                    right--;
                }
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++; right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        }
        else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) {
                    continue;
                }
                if (a[i] + max * (k - 1) < target) {
                    continue;
                }
                if (a[i] * k > target) {
                    break;
                }
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                path.add(a[i]);
                kSum(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }
}