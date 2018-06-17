package hee.math2_1;

import java.math.BigInteger;
import java.util.Scanner;

// n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
// n은 1,000,000,000,000,000,000보다 작거나 같은 자연수
// 첫째 줄에 n번째 피보나치 수를 1,000,000으로 나눈 나머지를 출력한다.
public class Hee_Q2749 {
    static Scanner scanner = new Scanner(System.in);

    // 나누려는 수(M = 10^m): 1,000,000(10^6)
    // 피사노의 주기(K): 15*10^(k-1), 단, M>100(m>2)인 경우
    // n번째 피보나치 수를 M으로 나눈 나머지 = N % (피사노의 주기)번째의 피보나치의 수를 M으로 나눈 나머지
//    public static void run(){
//        final int M = 1000000;
//        final int K = M * 15 / 10; // 피사노의 주기
//        long N = scanner.nextLong();
//
//        int no = (int)(N % K); // N % (피사노의 주기)번째
//
//        int fiboArrays[] = new int[K];
//        fiboArrays[0] = 0;
//        fiboArrays[1] = 1;
//
//        int i;
//        for(i=2; i<=no; i++) {
//            fiboArrays[i] = fiboArrays[i - 1] + fiboArrays[i - 2];
//            fiboArrays[i] %= M;
//        }
//        System.out.println(fiboArrays[no]);
//    }

    public static void run(){
        final int M = 1000000;
        final int K = M * 15 / 10; // 피사노의 주기
        long N = scanner.nextLong();

        long no = N % K; // N % (피사노의 주기)번째

        if (N <= 1) {
            System.out.println(N);
            return;
        }

        int a = 0, b = 1, result = 0;
        int i;
        for(i=2; i<=no; i++) {
            result = a + b;

            a = (b % M);
            b = (result % M);
        }
        System.out.println(result % M);
    }


    /* n번째 피보나치의 수 */
//    static long fibonacci(long n){
//        if(n <= 1)
//            return n;
//        else
//            return fibonacci(n-1) + fibonacci(n-2);
//    }
}

