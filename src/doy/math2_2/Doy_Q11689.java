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
