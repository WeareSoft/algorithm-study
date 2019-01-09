package hee.boj.math1_1;

// 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.
// 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다.
// 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
// 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Hee_Q1934 {
    public static Scanner scanner = new Scanner(System.in);

    // GCD [방법3]
    // 유클리드 호제법 - 재귀함수 사용X
    public static int gcd2(int num1, int num2){
        int tmp;

        // 나머지가 0이 될 때까지 반복
        while (num2 != 0) {
            tmp = num1 % num2; // 나머지를 구한다.
            num1 = num2; // 나머지와 num2를 비교한다.
            num2 = tmp;
        }
        return num1;
    }

    // LCM
    // 두 수의 최대공약수: gcd일 때, 최소공배수: gcd * (num1/gcd) * (num2/gcd)
    public static int lcm(int num1, int num2){
        int gcd = gcd2(num1, num2);
        int lcm = gcd * (num1/gcd) * (num2/gcd);

        return lcm;
    }


    public static void run(){
        int count = scanner.nextInt();
        int[][] num = new int[count][2];

        for(int i=0; i<count; i++){
            num[i][0] = scanner.nextInt();
            num[i][1] = scanner.nextInt();
        }

        for(int i=0; i<count; i++){
            System.out.println(lcm(num[i][0], num[i][1]));
        }
    }
}

/*
    이전 문제와 거의 같은 문제네요 ㅎㅎ
    한 번 입력받고 바로 lcm를 구해 출력하면 배열을 만들지 않아도 될거같아요 :)
*/
