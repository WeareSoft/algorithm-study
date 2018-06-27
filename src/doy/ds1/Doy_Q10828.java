package doy.ds1;

import java.util.Scanner;
import java.util.Stack;

public class Doy_Q10828 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        Stack<Integer> stack = new Stack<>();

        int count = s.nextInt();
        for (int i = 0; i < count; i++) {
            String cmd = s.next();
            switch (cmd) {
                case "push":
                    int num = s.nextInt();
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
