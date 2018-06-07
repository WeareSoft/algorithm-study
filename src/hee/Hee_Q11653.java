package hee;

import java.util.Scanner;

// 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
public class Hee_Q11653 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        int num = scanner.nextInt();

        // 소인수분해는 num을 소수의 곱으로 분해하는 것
        // 2~루트num 까지 순서대로 num를 나눌 수 없을 때까지 계속해서 나눈다
        for(int i=2; i*i<=num; i++){
           while(num%i == 0) {
                System.out.println(i);
                num = num/i;
           }
        }
        // 마지막으로 남은 수 num가 0과 1이 아니면 그 수도 소수이다
        if(num>1){
            System.out.println(num);
        }

    }
}
