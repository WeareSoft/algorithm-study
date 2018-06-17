package hee.math2_1;

import java.util.Scanner;

// 첫째 줄에 n이 주어진다. n은 절대값이 1,000,000을 넘지 않는 정수이다.
// 첫째 줄에 F(n)이 양수이면 1, 0이면 0, 음수이면 -1을 출력한다. 둘째 줄에는 F(n)의 절대값을 출력한다.
// 이 수가 충분히 커질 수 있으므로, 절대값을 1,000,000,000으로 나눈 나머지를 출력한다.
public class Hee_Q1788 {
    static Scanner scanner = new Scanner(System.in);

    /* [방법1] */
//    public static void run(){
//        final int M = 1000000000;
//        int n = scanner.nextInt();
//        int a = 0, b = 1, result = 0;
//
//        if (n==0 || n==1){
//            System.out.print(n + "\n" + n);
//            return;
//        }
//        else if (n >= 1){
//            for (int i=1; i<=n; i++){
//                result = (a + b) % M;
//                b = a % M;
//                a = result;
//            }
//            System.out.print("1" + "\n" + result);
//            return;
//        }
//        else{
//            for (int i=0; i>n; i--){
//                result = (b - a) % M;
//                b = a % M;
//                a = result;
//            }
//            int sign = (result == 0) ? 0 : (result > 0) ? 1 : -1;
//            System.out.print(sign + "\n" + Math.abs(result));
//            return;
//        }

    /* [방법2] (음수 조건을 포함한) 피보나치의 규칙성 */
    // 1. n = -k, n = k에 대한 피보나치의 절댓값은 같다.
    // 2. n = -k(음수)일 때, n이 짝수이면 음의 피보나치 값을 갖는다.
    public static void run() {
        final int M = 1000000000;
        int n = scanner.nextInt();
        int a = 0, b = 1, result = 0;
        int sign = 1; // 부호

        if (n == 0 || n == 1) {
            System.out.print(n + "\n" + n);
            return;
        }

        // 규칙성 2.
        if(n < 0 && (Math.abs(n)%2) == 0) sign = -1;
        else sign = 1;

        // 규칙성 1.
        for (int i=1; i<=Math.abs(n); i++){
            result = (a + b) % M;
            b = a;
            a = result;
        }
        System.out.print(sign + "\n" + result);
    }
}

/*
    풀이가 같네요 :)
    음수의 피보나치는 양수의 피보나치와 절댓값은 같지만, 음수이면서 2의배수일 때는 음수 값을 같는 규칠을 알게 되었네요.
*/
