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

/*
    저도 재귀함수를 이용하면 시간이 너무 많이 걸려 반복문을 이용해서 카탈란의 수를 구했어요.
    카탈란 수의 기본적인 공식은 외우되, 카탈란 수의 적용 사례와 원리에 대해서 이번 주에 한 번 정리해보는 게 좋을 거 같네요 :)

    A에 괄호가 k쌍이 있다면 B에는 n−1−k쌍이 있어야 한다. 
    EX) (A)B와 같이 넣는다고 하면 A와 B도 잘 짜여져 있어야 한다.
    => C4 = C0C3 + C1C2 + C2C1 + C3C0
    => 즉, 카탈란의 수 Cn = sum{i=0~(n-1)}(Ci * Cn-i-1)
    출처: http://suhak.tistory.com/77 [수학 이야기]
*/
