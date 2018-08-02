package LeetCode.src.Problems.P701_P800.P716_MaxStack.Java;

public class Solution {
    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(10);
        obj.push(20);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.peekMax();
        System.out.println(param_4);
        int param_5 = obj.popMax();
        System.out.println(param_5);
    }
}