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

/*
    둘 다 '에라토스테네스의 체'를 이용한 풀이로, 동일하네요.
    그리고 Boolean(Object)의 기본값은 null이고 boolean(primitive)의 기본값은 false라는 것도 새로 알게 되었어요.^^
    issue1) i가 1,000,000 인 경우 i*i는 범위를 넘어가므로 j=i*i -> j=i*2
    issue2) 주어진 조건의 범위를 제대로 확인하고 값은 초기화해야 된다는 것도 알았어요.
*/
