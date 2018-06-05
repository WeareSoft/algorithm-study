package doy;

import java.util.ArrayList;
import java.util.Scanner;

// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
public class Doy_Q1929 {
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int m = s.nextInt();
        int n = s.nextInt();

        ArrayList<Integer> primeList = new ArrayList<>(); // 2~n 까지의 소수 저장
        boolean[] checkPrime = new boolean[n + 1]; // 에라토스테네스의 체 true : 지워짐, false : 지워지지 않음

        for (int i = 2; i <= n; i++) {
            if (!checkPrime[i]) {
                primeList.add(i);
                for (int j = i * 2; j <= n; j += i) {
                    checkPrime[j] = true;
                }
            }
        }

        for (int prime : primeList) {
            if (m <= prime) {
                System.out.println(prime);
            }
        }
    }
}
