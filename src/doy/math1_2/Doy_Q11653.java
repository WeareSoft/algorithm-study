package doy.math1_2;

import java.util.Scanner;

public class Doy_Q11653 {
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int n = s.nextInt();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        if (n > 1) {
            System.out.println(n);
        }
    }
}

/*
    풀이가 동일하네요^^
    소인수분해를 구하는 간단한 방법을 알게되었습니다.
    소수와 소인수분해에서는 2~루트N을 잘 기억해두면 좋을 거 같네요 :)
*/
