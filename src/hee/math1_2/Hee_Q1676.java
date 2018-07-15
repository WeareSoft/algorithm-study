package hee.math1_2;

import java.util.Scanner;

// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
public class Hee_Q1676 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        int num = scanner.nextInt();

        // num를 소인수분해 했을 때 2*5의 개수가 0의 개수이다
        // 팩토리얼에서는 5의 개수가 항상 2의 개수보다 적기 때문에 5의 개수로만 판단
        // 즉, N/5 + N/5^2 + N/5^3 + N/5^4 ...
        int multiplier=1;
        while (num >= Math.pow(5, multiplier)){
            multiplier++;
        }

        int result = 0;
        for (int j=1; j<=multiplier; j++){
            result += (num/Math.pow(5, j));
        }
        System.out.print(result);
    }
}

/*
풀이가 동일하네요 :)
반복문은 두 번 돌지만 제 코드보다 가독성은 더 좋아보이네요 ㅎㅎㅎ
*/
