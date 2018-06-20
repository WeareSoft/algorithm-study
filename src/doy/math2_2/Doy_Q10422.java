package doy.math2_2;

import java.util.Scanner;

public class Doy_Q10422 {
    static Scanner s = new Scanner(System.in);
    static long[] catalanNum = new long[2501];
    static final int MOD = 1000000007;

    public static void run() {
        initCatalanNum();

        int count = s.nextInt();
        for (int i = 0; i < count; i++) {
            int n = s.nextInt();

            if (n % 2 == 0) {
                System.out.println(catalanNum[n / 2]);
            } else {
                System.out.println(0);
            }
        }
    }

    private static void initCatalanNum() {
        catalanNum[0] = catalanNum[1] = 1;

        for (int i = 2; i <= catalanNum.length - 1; i++) {
            catalanNum[i] = 0;
            for (int j = 0; j < i; j++) {
                catalanNum[i] += catalanNum[j] * catalanNum[i - j - 1];
                catalanNum[i] %= MOD;
            }
        }
    }
}

/*
    reference : https://www.geeksforgeeks.org/program-nth-catalan-number/
*/