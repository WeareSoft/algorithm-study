package hee.boj.datastructure1;

import java.util.Scanner;

public class Hee_Q10799 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        String string = scanner.next();

        /* [방법1] 단순한 개수 세기를 이용 */
        int result = 0;
        int cnt = 0; // 오른쪽 괄호의 개수

        for (int i=0; i<string.length(); i++){
            // '('이면
            // '('의 개수+1
            if (string.charAt(i) == '(')
                cnt++;
            // ')'이면
            // 1. 바로 전 index에 '('이 있으면 레이저이므로 '('의 개수-1 (조각의 개수 + '('의 개수)
            // 2. 레이저가 아니라면 쇠막대기의 끝이므로 '('의 개수-1 (조각의 개수 + 1)
            else{
                if (string.charAt(i-1) == '('){
                    cnt--;
                    result += cnt;
                } else {
                    cnt--;
                    result++;
                }
            }
        }

        System.out.println(result);

        /* [방법2] Stack을 이용 */
//        Stack stack = new Stack();
//        int result = 0;
//
//        for (int i=0; i<string.length(); i++){
//            // '('이면
//            // '('의 index를 stack에 넣는다.
//            if (string.charAt(i) == '('){
//                stack.push(i);
//            }
//            // ')'이면
//            // 1. stack의 top이 바로 전 index면 레이저이므로 하나를 pop하고 (조각의 개수 + stack 안의 '('의 개수)
//            // 2. 레이저가 아니라면 쇠막대기의 끝이므로 하나를 pop하고 (조각의 개수 + 1)
//            else {
//                if(stack.peek().equals(i-1)){
//                    stack.pop();
//                    result += stack.size();
//                } else {
//                    stack.pop();
//                    result += 1;
//                }
//            }
//        }
//        System.out.println(result);
    }
}
