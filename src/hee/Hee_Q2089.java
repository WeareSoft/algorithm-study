package hee;

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
