package doy;

import java.util.Scanner;

// 10진법의 수를 입력 받아서 -2진수를 출력하는 프로그램을 작성하시오.
public class Doy_Q2089 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        int num = s.nextInt();
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            System.out.println("0");
            return;
        }

        while (num != 0) {
            if (num < 0 && num % 2 != 0) { // 음의 홀수일 때
                sb.append(1);
                num = (num / -2) + 1;
                continue;
            }

            sb.append(num % -2);
            num /= -2;
        }

        sb.reverse();
        System.out.println(sb);
    }
}
