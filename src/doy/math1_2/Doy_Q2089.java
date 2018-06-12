package doy.math1_2;

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

/*
    num = (num / -2) + 1; 를 저는 num = (num - 1) / -2; 로 처리한 것을 제외하면 풀이가 동일하네요.
    음의 진수로 변환할 때는 해당 진수로 나누어 지지 않는 음수의 값들을 주의깊게 고려해야 될 것 같아요 :)
    ex) -3의 진수로 변환하는 경우, -1 -2 -4 -5 -7 -8 ... 등을 주의깊게 고려!
    ex) -4의 진수로 변환하는 경우, -1 -2 -3 -5 -6 -7 ... 등을 주의깊게 고려!
*/
