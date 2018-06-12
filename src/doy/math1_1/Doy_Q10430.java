package doy.math1_1;

import java.util.Scanner;

public class Doy_Q10430 {
    // (A+B)%C는 (A%C + B%C)%C 와 같을까?
    // (A×B)%C는 (A%C × B%C)%C 와 같을까?
    // 세 수 A, B, C가 주어졌을 때, 위의 네가지 값을 구하는 프로그램을 작성하시오.
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();

        System.out.println((A+B) % C);
        System.out.println((A%C + B%C) % C);
        System.out.println((A*B) % C);
        System.out.println((A%C * B%C) % C);
    }
}

/* 
    너무 쉬운 문제라... 피드백할 게 없네요..ㅠㅠ
    다만 변수명이 대문자인 것은 좋지 않아요~ㅎㅎㅎ
    다음에 클린코드를 위한 변수명은 어떻게 설정하면 좋을지 같이 얘기해보는것도 좋을 거 같아요 :)
*/
