package doy.ds1;

import java.util.Scanner;
import java.util.Stack;

public class Doy_Q10799 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        Stack<Integer> stack = new Stack<>();

        String input = s.nextLine();
        int res = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '(':
                    stack.push(i); // index를 넣음
                    break;

                case ')':
                    if (i - stack.peek() == 1) { // index가 1 차이나면
                        // 레이저
                        stack.pop();
                        res += stack.size();
                    } else {
                        stack.pop();
                        res += 1;
                    }
                    break;
            }
        }
        System.out.println(res);
    }
}
