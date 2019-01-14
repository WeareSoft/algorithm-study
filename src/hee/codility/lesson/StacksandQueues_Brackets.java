package hee.codility.lesson;

import java.util.Stack;

public class StacksandQueues_Brackets {
    // [TIP] inpit "{{{{", null, ""
    public int solution(String S) {
        if (S == null) {
            return 0;
        } else if (S.isEmpty()) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        for (Character C : S.toCharArray()) {
            if (C == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return 0;
            } else if (C == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return 0;
            } else if (C == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return 0;
            } else {
                stack.add(C);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
