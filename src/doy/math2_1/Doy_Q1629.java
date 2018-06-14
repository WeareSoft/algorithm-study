package doy.math2_1;

import java.util.Scanner;

public class Doy_Q1629 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        long a = s.nextLong();
        long b = s.nextLong();
        long c = s.nextLong();

        long res = calc(a, b, c);
        System.out.println(res);
    }

    // 분할정복
    private static long calc(long a, long b, long c) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a % c;
        } else if (b % 2 == 0) {
            long temp = calc(a, b / 2, c);
            return (temp * temp) % c;
        } else { // b % 2 == 1
            return (a * calc(a, b - 1, c)) % c;
        }
    }
}

/*
    풀이는 동일하네요.
    로직 안에서 c로 나눠는 것에 대한 처리에 주의해야 될 것 같아요! :)
*/
