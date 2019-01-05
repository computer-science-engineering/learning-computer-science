package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.FindKPairsWithSmallestSums.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        List<int[]> result = kSmallestPairs(nums1, nums2, k);
        for (int[] item : result) {
            for (int res : item) {                
                System.out.print(res + " ");
            }
            System.out.println("");
        }
    }

    // The run time complexity is O(k Log k) since que.size <= k and we do at most k loop.
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // min queue, sorted by pair sum
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<int[]> res = new ArrayList<>();
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 == 0 || N2 == 0) return res; // no pairs to form, just return an empty res list
        // offer initial pairs {num1, num2, index_of_num2}
        for (int i = 0; i < Math.min(N1, k); i++) q.offer(new int[]{nums1[i], nums2[0], 0});
        // get 1st k elem into result, each time, offer potential better pairs into queue
        // if there r not enough pair, just return all pairs
        for (int i = 0; i < Math.min(N1 * N2, k); i++) {
            // get the best pair and put into res
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            // next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
            // for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
            // for B, it might be a better choice, so we offer it into queue
            if (cur[2] < N2 - 1 ) { // still at least one elem after num2 in array nums2
                int idx = cur[2] + 1;
                q.offer(new int[]{cur[0], nums2[idx], idx});
            }
        }
        return res;
    }

    public static List<int[]> kSmallestPairs_1(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (k > n1*n2) { 
            System.out.print("k pairs don't exist"); 
            return result; 
        } 
       
        // Stores current index in arr2[] for 
        // every element of arr1[]. Initially 
        // all values are considered 0. 
        // Here current index is the index before 
        // which all elements are considered as 
        // part of output. 
        int index2[] = new int[n1]; 
       
        while (k > 0) { 
            // Initialize current pair sum as infinite 
            int min_sum = Integer.MAX_VALUE; 
            int min_index = 0; 
       
            // To pick next pair, traverse for all  
            // elements of arr1[], for every element, find  
            // corresponding current element in arr2[] and 
            // pick minimum of all formed pairs. 
            for (int i1 = 0; i1 < n1; i1++) { 
                // Check if current element of arr1[] plus 
                // element of array2 to be used gives  
                // minimum sum 
                if (index2[i1] < n2 &&  
                    nums1[i1] + nums2[index2[i1]] < min_sum) { 
                    // Update index that gives minimum 
                    min_index = i1; 
       
                    // update minimum sum 
                    min_sum = nums1[i1] + nums2[index2[i1]]; 
                } 
            } 
            
            result.add(new int[]{nums1[min_index], nums2[index2[min_index]]});
            //System.out.print("(" + nums1[min_index] + ", " + nums2[index2[min_index]]+ ") "); 
       
            index2[min_index]++; 
            k--; 
        }
        return result; 
    }
}