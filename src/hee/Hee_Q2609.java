package hee;

import java.util.*;


public class Hee_Q2609 {
    // 두 개의 자연수를 입력받아 최대 공약수(GCD)와 최소 공배수(LCM)를 출력하는 프로그램을 작성하시오.
    static Scanner scanner = new Scanner(System.in);

    // GCD [방법1]
    // (2 ~ 두 수 중 더 작은 값)까지 나누어 본다.
    public static int gcd1(int num1, int num2){
        int min = num1;
        int gcd = 1;

        if(num1 > num2){
            min = num2;
        }

        for(int i=2; i<min; i++){
            if((num1 % i == 0) && (num2 % i == 0)){
                gcd = i;
            }
        }
        return gcd;
    }

    // GCD [방법2]
    // 유클리드 호제법
    public static int gcd2(int num1, int num2){
        if (num2 == 0) {
            return num1;
        } else {
            return gcd2(num2, num1 % num2);
        }
    }

    // LCM
    // 두 수의 최대공약수: gcd일 때, 최소공배수: gcd * (num1/gcd) * (num2/gcd)
    public static int lcm(int num1, int num2){
        int gcd = gcd2(num1, num2);
        int lcm = gcd * (num1/gcd) * (num2/gcd);

        return lcm;
    }

    public static void run() {
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

//        System.out.println(gcd1(num1, num2));
        System.out.println(gcd2(num1, num2));
        System.out.println(lcm(num1, num2));
    }
}


/*
    gcd 방법1은 for문의 시작을 어디서부터 하냐의 차이가 조금 있네요..
    최대공약수와 최소공배수를 구하는 제일 좋은 방법에 대해 같이 정리해봐요 :)
*/
