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

/*
    풀이가 동일하네요.
    다음 스터디에서는 stack의 메서드에 대해서 조금 더 상세히 같이 공부하면 좋을 거 같아요.
*/
