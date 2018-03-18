package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D18_QueuesAndStacks.Java;

import java.util.*;


class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "racecar";// scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}

class Solution {
    private Stack<Character> stk;
    private LinkedList<Character> queue;

    Solution(){
        stk = new Stack<Character>();
        queue = new LinkedList<Character>();
    }

    public void pushCharacter(char c){
        stk.push(c);
    }

    public char popCharacter(){
        return (char) stk.pop();
    }

    public void enqueueCharacter(char c){
        queue.add(c);
    }

    public char dequeueCharacter(){
        return (char) queue.remove();
    }
}
