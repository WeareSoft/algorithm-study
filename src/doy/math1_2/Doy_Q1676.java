package doy.math1_2;

import java.util.Scanner;

// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
public class Doy_Q1676 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        int n = s.nextInt();
        int count = 0;
        int divideNum = 5;

        // n을 소인수분해 했을 때 2*5의 개수가 0의 개수
        // 팩토리얼에서는 5의 개수가 항상 2의 개수보다 적기 때문에 5의 개수로만 판단
        while (n >= divideNum) {
            count += n / divideNum;
            divideNum *= 5;
        }

        System.out.println(count);
    }
}
