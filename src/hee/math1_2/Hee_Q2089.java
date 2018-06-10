package hee.math1_2;

import java.util.Scanner;

public class Hee_Q2089 {
    static Scanner scanner = new Scanner(System.in);

    static public void run(){
        int num = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        if(num == 0){
            System.out.print("0");
            return;
        }

        while (num != 0){
            // num가 음의 홀수인 경우
            if (num < 0 && (num % 2 != 0)){
                stringBuilder.append(1); // 나머지 = 1;
//                System.out.println("num: " + num + ", stringBuilder: " + "1");
                num = (num-1) / -2;
            }
            // 그 외의 경우
            else{
                stringBuilder.append(num % -2);
//                System.out.println("num: " + num + ", stringBuilder: " + num % -2);
                num = num / -2;
            }
        }

        System.out.print(stringBuilder.reverse());
    }
}

/*
    평소에 생각해보지 못했던 -진수에 대해서 알아갑니다~
    해당 진수로 나누어 지지 않는 음수의 값 고려!!
*/
