package hee.datastructure1;

import java.util.Scanner;
import java.util.Stack;

// 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램
public class Hee_Q10828 {
    static Scanner scanner = new Scanner(System.in);
    static Stack stack = new Stack();

    public static void run(){
        int N = scanner.nextInt();

        while (N > 0){
            String command = scanner.next();

            switch (command){
                case "push":
                    stack.push(scanner.nextInt());
                    break;

                case "pop":
                    System.out.println(stack.empty() ? "-1" : stack.pop());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.empty() ? "1" : "0");
                    break;

                case "top":
                    System.out.println(stack.empty() ? "-1" : stack.peek());
                    break;
                default:
                    break;
            }
            N--;
        }
    }
}

/*
    풀이가 동일하네요.
    삼항연산자를 쓰니 더 깔끔해 보이네요 :)
*/
