package doy;

import java.util.Scanner;

public class Doy_Q2609 {
    // 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int max = num1 > num2 ? num1 : num2;

        for (int i=max; i>0; i--) {
            if(num1%i == 0 && num2%i == 0){
                int gcd = i;
                int lcm = num1*num2 / gcd;

                System.out.println(gcd);
                System.out.println(lcm);

                break;
            }
        }
    }

    /*
    public static int getGCD(int num1, int num2) {
        if(num2 == 0)
            return num1;
        else
            return getGCD(num2, num1 % num2);
    }

    public static int getLCM(int num1, int num2, int gcd) {
        return gcd * (num1/gcd) * (num2/gcd);
    }
    */
}
