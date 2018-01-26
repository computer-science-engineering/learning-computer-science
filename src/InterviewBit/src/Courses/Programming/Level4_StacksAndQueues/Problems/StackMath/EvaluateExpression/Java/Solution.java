package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.StackMath.EvaluateExpression.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //String[] input = new String[]{"2", "1", "+", "3", "*"};
        String[] input = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(input));
    }
    
    public static int evalRPN(String[] A) {
        int a, b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : A) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
    }
}