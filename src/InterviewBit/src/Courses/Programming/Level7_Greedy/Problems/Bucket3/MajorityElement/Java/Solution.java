package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket3.MajorityElement.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 1, 2}));
    }
    
    public static int majorityElement(final int[] A) {
        int count=0, ret = 0;
        for (int num: A) {
            if (count==0) {
                ret = num;
            }
            if (num!=ret) {
                count--;
            }
            else {
                count++;
            }
        }
        return ret;
    }
}