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

/*
    풀이가 동일하네요. 
    Stack으로 풀 수 있는 문제 중 단순한 count로도 풀리는 경우도 많은 거 같아요.
    push()의 경우 count++, pop()의 경우 count--;를 이용하면 간단히 풀 수 있어요!!
    참고) 스택(Stack)의 사용 예제
        * 웹 브라우저 방문기록 (뒤로가기)
        * 실행취소 (undo)
        * 역순 문자열 만들기
        * 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)
        * 후위표기법 계산
*/
