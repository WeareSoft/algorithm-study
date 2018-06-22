package hee.math2_1;

import java.util.Scanner;

// 자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 프로그램
// 자연수 n (1 ≤ n ≤ 10^12)
public class Hee_Q11689 {
    static Scanner scanner = new Scanner(System.in);

    // 오일러 피 함수: 1~n까지의 자연수 중 n과 서소로인 수의 개수
    static long phi(long n) {
        long ans = n;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                ans -= ans / i;
            }
        }
        if (n > 1)
            ans -= ans / n;

        return ans;
    }

    public static void run(){
        long n = scanner.nextLong();

        System.out.println(phi(n));
    }
}

/*
    풀이가 동일하네요 :)
    오일러 피의 개념을 한 번 더 정리해보고, 응용 분야를 알아보면 좋을거 같아요!
*/
