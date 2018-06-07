package hee;

import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q1929 {
    static Scanner scanner = new Scanner(System.in);

    static public void run(){
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Boolean> checkPrime = new ArrayList<>();

        // 값 초기화
        for (int i=0; i<=n; i++){
            checkPrime.add(i, true); // true이면 소수이다
        }

        // 에라토스테네스의 체
        for (int i=2; i<=n; i++){
            if(checkPrime.get(i) == true){
                // 소수로 저장한 수의 배수들은 소수가 아니므로 false로 바꾼다
                // i가 1,000,000 인 경우 i*i는 범위를 넘어가므로 j=i*i -> j=i*2
                for (int j=i*2; j<=n; j+=i){
                    checkPrime.set(j, false);
                }
            }
        }

        // 값 출력
        for (int i=m; i<=n; i++){
            if(checkPrime.get(i) == true){
                System.out.println(i);
            }
        }
    }
}
