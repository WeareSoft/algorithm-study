package doy.math2_2;

import java.util.Scanner;

// 자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 프로그램을 작성하시오.
public class Doy_Q11689 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        long n = s.nextLong();

        System.out.println(phi(n));
    }

    // 오일러 피 함수, GCD(n, k) = 1
    private static long phi(long n) {
        long ans = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                ans -= ans / i;
            }
        }

        if (n > 1) {
            ans -= ans / n;
        }

        return ans;
    }
}

/*
    오일러 파이 함수는 암호학의 RSA 암호에서도 핵심적인 역할을 한다고 합니다. 
    이번 스터디에서 오일러 파이 함수의 간단한 개념과 원리(곱셈적 함수)에 대해 얘기해보면 좋을 거 같아요 :)
*/
