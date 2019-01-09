package hee.boj.math1_1;

import java.util.*;


public class Hee_Q10430 {
    // (A+B)%C는 (A%C + B%C)%C 와 같을까?
    // (A×B)%C는 (A%C × B%C)%C 와 같을까?
    // 세 수 A, B, C가 주어졌을 때, 위의 네가지 값을 구하는 프로그램을 작성하시오.
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        System.out.println(((num1 + num2)) % num3);
        System.out.println((num1 % num3 + num2 % num3) % num3);
        System.out.println( (num1 * num2) % num3);
        System.out.println((num1 % num3 * num2 % num3) % num3);
    }
}

/* 
    사실.. 이 문제의 의도가 뭔지 잘 모르겠네요 ㅎㅎㅎ
    그냥 단순 계산일까요...? ㅠㅠ
*/
