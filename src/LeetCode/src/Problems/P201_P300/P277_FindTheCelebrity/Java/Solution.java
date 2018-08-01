package LeetCode.src.Problems.P201_P300.P277_FindTheCelebrity.Java;

public class Solution extends Relation {
    public static void main(String[] args) {
        System.out.println(findCelebrity(10));
    }

    public static int findCelebrity(int n) {
        if (n <= 0) {
            return -1;
        }
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }
}