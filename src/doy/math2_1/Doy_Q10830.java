package doy.math2_1;

import java.util.Scanner;

// 크기가 N*N인 행렬 A가 주어진다. 이 때, A의 B제곱을 구하는 프로그램을 작성하시오. 수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.
public class Doy_Q10830 {
    static Scanner s = new Scanner(System.in);
    static final int MODNUM = 1000;

    public static void run() {
        int n = s.nextInt();
        long b = s.nextLong();

        int[][] a = new int[n][n];
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
            res[i][i] = 1; // 행렬 곱셈의 항등원
        }

        // 이진수의 원리
        while (b > 0) {
            if (b % 2 == 1) {
                res = mul(res, a);
            }
            a = mul(a, a);
            b /= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mul(int[][] a, int[][] b) {
        int n = a.length;
        int mul[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mul[i][j] += a[i][k] * b[k][j];
                }
                mul[i][j] %= MODNUM;
            }
        }

        return mul;
    }
}
