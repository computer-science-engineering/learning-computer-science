package InterviewCake.src.Questions.BracketValidator.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String input= "((a + b))";
        System.out.println(isValid_editorial(input));        
    }

    public static boolean isValid_editorial(String code) {

        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');
    
        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());
    
        Stack<Character> openersStack = new Stack<>();
    
        for (char c : code.toCharArray()) {
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.empty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();
    
                    // if this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }
        return openersStack.empty();
    }
}