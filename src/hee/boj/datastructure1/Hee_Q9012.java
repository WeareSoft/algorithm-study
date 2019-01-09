package hee.boj.datastructure1;

import java.util.Scanner;

public class Hee_Q9012 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        int N = scanner.nextInt();

        while (N > 0){
            String string = scanner.next();

            /* [방법1] '(' ')'의 개수가 동일하면 VPS(Valid PS, 올바른 괄호 문자열) */
            int cnt = 0;
            for (int i=0; i<string.length(); i++){
                if(string.charAt(i) == '('){
                    cnt++;
                } else {
                    cnt--;
                    if (cnt == -1)
                        break;
                }
            }
            System.out.println(cnt == 0 ? "YES" : "NO");

            /* [방법2] Stack을 이용하는 방법 */
//            Stack stack = new Stack();
//
//            int i=0;
//            for (i=0; i<string.length(); i++){
//                if(string.charAt(i) == '('){
//                    stack.push('(');
//                } else {
//                    if (stack.empty()){
//                        System.out.println("NO");
//                        break;
//                    } else {
//                        stack.pop();
//                    }
//                }
//            }
//
//            if (!stack.empty()){
//                System.out.println("NO");
//            } else if (stack.empty() && i == string.length()){
//                System.out.println("YES");
//            }

            N--;
        }
    }
}

/*
    ')'이 먼저 나올 때의 조건을 생각해봐야겠네요 :)
    카운트를 세는 방법이 훨씬 명확하고 이해가 잘 가는거같네요 ㅎㅎ
*/
