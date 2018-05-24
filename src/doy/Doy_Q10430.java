package doy;

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
