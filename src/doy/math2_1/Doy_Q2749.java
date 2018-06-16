package doy.math2_1;

import java.util.Scanner;

public class Doy_Q2749 {
    static Scanner s = new Scanner(System.in);
    static final int MOD = (int) Math.pow(10, 6); // 나눌 수 : 10^6
    static final int PERIOD = 15 * (MOD / 10); // 나눌 수가 10^k 일 때, K>2 라면, 주기는 항상 15 * 10^(k-1)

    public static void run() {
        long n = s.nextLong();
        int index = (int) (n % PERIOD);
        int fibo[] = new int[index + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= index; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fibo[i] %= MOD;
        }

        System.out.println(fibo[index]);
    }
}

/*
    풀이가 동일하네요.
    다음 스터디에서는 피사노의 주기를 구하는 방법에 대해서 함께 얘기해보면 좋을 거 같아요^^
*/
