package doy.math1_1;

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

/*
    StringBuilder 함수에 reverse()라는 좋은 것이 있었네요^^
    풀이가 훨씬 간단해지는거 같아요ㅎㅎ 
    'A'의 아스키코드 = 65는 기본적으로 알아두는 것이 좋을 거 같아요.
*/
