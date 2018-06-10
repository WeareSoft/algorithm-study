package hee.math1_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 골드바흐의 추측 (4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.) 검증 프로그램
// 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1,000,000)
// 만약, n을 만들 수 있는 방법이 여러가지라면, b-a가 가장 큰 것을 출력한다.
// 또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
public class Hee_Q6588 {
    static Scanner scanner = new Scanner(System.in);

    /* 해당 숫자가 소수인지 아닌지를 확인 */
    // 시간 초과...?
//    static public boolean isPrime(int num){
//        if(num < 2){
//            return false; // num=0, 1이면 소수가 아니다
//        }
//        // 2 ~ 루트num 까지 나누어지는지 확인한다
//        for (int i=2; i*i<=num; i++){
//            if(num%i == 0){
//                return false; // 소수가 아니다
//            }
//        }
//        return true;
//    }

    public static void run(){
        final int MAX = 1000000;
        HashMap<Integer, Boolean> primeList = new HashMap<>();

        for(int i=0; i<=MAX; i++){
            primeList.put(i, false);
        }

        /* '에라토스테네스의 체' */
        for (int i = 2; i <= MAX; i++) {
            if(!primeList.get(i)){
                for (int j = i * 2; j <= MAX; j += i) {
                    primeList.replace(j, true);
                }
            }
        }

        // 0이면 프로그램 종료
        while (true) {
            int n = scanner.nextInt();

            if (n == 0){
                return;
            }

            // a를 다음으로 큰 소수로 증가하면서 확인
            int i;
            for(i=2; i<primeList.size(); i++){
                // n 미만의 가장 작은 소수 = a
                int a;
                if(!primeList.get(i)){
                    a = i;

                    // n-a = b가 소수이면 추측 성립
                    int b = n-a;
                    if (!primeList.get(b)){
                        System.out.println(n + " = " + a + " + " + b);
                        break;
                    }
                }
            }

            // 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우
            if(i>primeList.size()){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
