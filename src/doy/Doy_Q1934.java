package doy;

import java.util.Scanner;

public class Doy_Q1934 {
    // 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int count = s.nextInt();
        for(int i=0; i<count; i++) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            int max = num1 > num2 ? num1 : num2;

            for (int j = max; j > 0; j--) {
                if (num1 % j == 0 && num2 % j == 0) {
                    int gcd = j;
                    int lcm = num1 * num2 / gcd;

                    System.out.println(lcm);
                    break;
                }
            }
        }
    }
}
