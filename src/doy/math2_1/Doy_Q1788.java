package doy.math2_1;

import java.util.Scanner;

// n이 주어졌을 때, 피보나치 수 F(n)을 구하는 프로그램을 작성하시오. n은 음수로 주어질 수도 있다.
// 첫째 줄에 F(n)이 양수이면 1, 0이면 0, 음수이면 -1을 출력한다. 둘째 줄에는 F(n)의 절대값을 출력한다. 이 수가 충분히 커질 수 있으므로, 절대값을 1,000,000,000으로 나눈 나머지를 출력한다.
// F(0) = 0, F(-1) = 1, F(-2) = -1, F(-3) = 2, F(-4) = -3, F(-5) = 5, F(-6) = -8
// => 양수의 피보나치와 대칭, n이 음의 2의 배수일 때는 -를 붙인 값
public class Doy_Q1788 {
    static Scanner s = new Scanner(System.in);
    static final int MOD = (int) Math.pow(10, 9);

    public static void run() {
        int n = s.nextInt();

        /* 방법 1. 재귀함수 : 시간 초과
        long res = fibo(Math.abs(n));
        */

        /* 방법 2. 배열에 피보나치 수 할당 : 런타임 에러
        long fibo[] = new long[Math.abs(n) + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= Math.abs(n); i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fibo[i] %= MOD;
        }
        long res = fibo[Math.abs(n)];
        */

        // 방법 3. 변수에 새로운 피보나치 수 할당 반복 : 11444 KB / 124 MS
        long f1 = 0, f2 = 1, res = 0;

        for (int i = 0; i < Math.abs(n); i++) {
            if (i == 1) {
                res = 1;
            } else {
                res = f1 + f2;
                res %= MOD;

                f1 = f2;
                f2 = res;
            }
        }

        // 출력
        if (n < 0 && n % 2 == 0) { // 음의 2의 배수
            System.out.println(-1);
        } else if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        System.out.println(res);
    }

    /*
    private static long fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fibo(n - 1) + fibo(n - 2)) % MOD;
        }
    }
    */
}
