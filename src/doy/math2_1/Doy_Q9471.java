package doy.math2_1;

import java.util.Scanner;

// 피보나치 수열을 m으로 나눈 나머지가 주기를 이룬다는 것을 증명했다.
// k(m)을 반복하는 부분 수열의 길이라고 했을 때, m이 주어졌을 때, k(m)을 구하는 프로그램을 작성하시오.
public class Doy_Q9471 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        int count = s.nextInt();

        for (int i = 0; i < count; i++) {
            int testNum = s.nextInt();
            int mod = s.nextInt();

            int f1 = 1, f2 = 1, f3;
            int period = 0;

            while (true) {
                f3 = (f1 + f2) % mod;

                f1 = f2;
                f2 = f3;
                period++;

                if (f1 == 1 && f2 == 1) {
                    break;
                }
            }

            System.out.println(testNum + " " + period);
        }
    }
}

/*
    피사노 주기는 항상 15 * 10^(k-1)인 것도 기억하고 있으면 좋을 거 같아요^^
    피보나치 수열은 "1, 1, "로 시작하므로 피보나치 수열을 M으로 나눈 나머지가 또 다시 1이 연속("1, 1, ")으로 나올 때, 또 다른 주기가 시작된다는 것을 알았습니다.
*/
