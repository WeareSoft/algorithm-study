package hee.codility.w;

import java.util.Stack;

public class Q1_1 {
    public static final int MAX = 0xFFFFF;
    public static final int MIN = 0;
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
//        String string = "13 DUP 4 POP 5 DUP + DUP + -";
        String string = "5 6 + -";
//        String string = "3 DUP 5 - -";

        String[] strings = string.split(" ");
        int result = 0;
        for (String s : strings) {
            switch (s) {
                case "POP":
                    result = pop();
                    break;
                case "DUP":
                    dup();
                    break;
                case "+":
                    add();
                    break;
                case "-":
                    sub();
                    break;
                default:
                    push(Integer.parseInt(s));
                    break;
            }
        }
        System.out.println(stack.peek());
//        return stack.peek();
    }

    private static int push(int i) {
        if (i < MIN || i > MAX) {
            System.out.println(-1);
            return -1;
//            throw new IllegalArgumentException("");
        }
        return stack.push(i);
    }

    private static int pop() {
        return stack.pop();
    }

    private static void dup() {
        hasElements(1);
        push(stack.peek());
    }

    private static void add() {
        hasElements(2);
        push(stack.pop() + stack.pop());
    }

    private static int sub() {
        if (hasElements(2) == -1) {
            return -1;
        }
        return push(stack.pop() - stack.pop());
    }

    private static int hasElements(int i) {
        if (stack.size() < i) {
            System.out.println(-1);
            return -1;
//            throw new IllegalArgumentException("Too few elements available");
        }
        return i;
    }
}