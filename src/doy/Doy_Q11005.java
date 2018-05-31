package doy;

import java.util.Scanner;

public class Doy_Q11005 {
    // 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
    static Scanner s = new Scanner(System.in);

    public static void run() {
        int n = s.nextInt();
        int b = s.nextInt();
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % b;
            if (r < 10) {
                sb.append(r);
            } else {
                sb.append((char) (r + 'A' - 10));
            }
            n /= b;
        }

        System.out.println(sb.reverse());
    }
}
