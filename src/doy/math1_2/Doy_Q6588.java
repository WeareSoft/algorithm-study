package doy.math1_2;

import java.util.HashMap;
import java.util.Scanner;

// 백만 이하의 모든 짝수에 대해서, 골드바흐의 추측을 검증하는 프로그램을 작성하시오.
public class Doy_Q6588 {
    static Scanner s = new Scanner(System.in);
    static final int MAX = 1000000;

    public static void run() {
        // 0 부터 100만 까지 소수 여부 세팅, 소수 : true, 소수X : false
        HashMap<Integer, Boolean> primeList = new HashMap<>();
        for (int i = 0; i <= MAX; i++) {
            primeList.put(i, true);
        }

        for (int i = 2; i <= MAX; i++) {
            if (primeList.get(i)) {
                for (int j = i * 2; j <= MAX; j += i) {
                    primeList.replace(j, false);
                }
            }
        }

        while (true) {
            int n = s.nextInt();
            if (n == 0) break;

            int i;
            for (i = 2; i < primeList.size(); i++) {
                if (primeList.get(i)) { // i 가 소수이면
                    int a = i;
                    int b = n - a;
                    if (primeList.get(b)) { // b = n-a 가 소수이면
                        System.out.println(n + " = " + a + " + " + b);
                        break;
                    }
                }
            }

            // 소수의 합으로 나타낼 수 없는 경우
            if (i > primeList.size()) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
