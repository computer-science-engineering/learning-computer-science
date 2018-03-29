package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.IntervalTree.OrderOfPeopleHeights.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] A = {7, 4, 7, 5, 6, 5}; //{5, 3, 2, 6, 1, 4};
        int[] B = {0, 4, 1, 0, 1, 2}; //{0, 1, 2, 0, 3, 2};
        int[] result = order(A, B);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
    
    public static int[] order(int[] A, int[] B) {
        int[][] people = new int[A.length][2];
        for (int i=0; i<A.length; i++) {
            people[i][0] = A[i];
            people[i][1] = B[i];
        }

        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        // Note: this sorts by decreasing order
        Arrays.sort(people, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0]!=o2[0] ? -o1[0]+o2[0] : o1[1]-o2[1];
           }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people) {
            res.add(cur[1], cur);       
        }
        int[][] resultPeople = res.toArray(new int[people.length][]);
        int[] result = new int[resultPeople.length];
        for (int i=0; i<resultPeople.length; i++) {
            result[i] = resultPeople[i][0];
        }
        return result;
    }
}