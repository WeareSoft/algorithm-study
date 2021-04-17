package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * Balanced Brackets
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
public class BalancedBrackets {

    static Map<Character, Character> pair = new HashMap<>();

    static {
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');
    }

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char peek = stack.peek();
                if (pair.get(peek) == ch) {
                    stack.pop();
                } else {
                    return "NO";
                }
            } else {
                stack.add(ch);
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{{[[(())]]}}"));
        System.out.println(isBalanced("{[(])}"));
    }
}
