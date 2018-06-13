package hee.math2_1;

import java.util.Scanner;

// A, B, C는 모두 2,147,483,647 이하의 자연수
public class Hee_Q1629 {
    static Scanner scanner = new Scanner(System.in);

    /* [방법2] 분할 정복 */
    static long mul1(long a, long b, long c){
        if(b == 0) return 1;
        else if(b == 1) return a % c;
        else if(b%2 == 0){
            long temp = mul1(a, b/2, c);
            return (temp * temp) % c;
        }
        else return (a * mul1(a, b-1, c)) % c;
    }

    /* [방법3] 이진수의 원리 */
    static long mul2(long a, long b, long c){
        long result = 1;

        // 곱할 횟수의 이진수에 따라
        // 이진수 자릿수가 1일 때의 값을 곱한다.
        while (b>0){
            if(b%2 == 1){
                result *= a;
                result %= c;
            }

            a = (a*a);
            a %= c;

            b /= 2;
        }
        return result;
    }

    public static void run(){
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        /* [방법1] 가장 직관적, 시간복잡도: O(b) */
//        System.out.print((long)(Math.pow(a, b) % c));

        /* [방법2] 분할 정복 */
        // a^2b = a^b * a^b, a^(2b+1) = a^2b * a
        System.out.print(mul1(a, b, c));

        /* [방법3] 이진수의 원리 */
        // 27 = 11011(2)
        // 3^27 = 3^1 + 3^2 + 3^8 + 3^16
//        System.out.print(mul2(a, b, c));
    }
}

/*
    a^b를 구하는 방법 중 시간 복잡도가 낮은 분할정복, 이진수의 원리에 대해 알아갑니다 ㅎㅎ
*/
