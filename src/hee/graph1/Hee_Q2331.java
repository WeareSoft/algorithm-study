package hee.graph1;

import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q2331 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int A = scanner.nextInt(); // A(1 ≤ A ≤ 9999)
        int P = scanner.nextInt(); // P(1 ≤ P ≤ 5)

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(A);

        while (true) {
            int res = 0;

            while (A != 0) {
                res += Math.pow(A % 10, P); // 나머지^P
                A = A / 10; // 몫
            }
//            System.out.println("res: " + res);

            if (arrayList.contains(res)) { // 해당하는 숫자가 이미 있으면
                System.out.println(arrayList.indexOf(res)); // 해당하는 숫자의 index를 구한다.
                return;
            }

            arrayList.add(res);
            A = res;
        }

    }
}