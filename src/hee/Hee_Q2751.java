package hee;

import java.util.Arrays;
import java.util.Scanner;

public class Hee_Q2751 {
    // N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절대값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
    // 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int count = scanner.nextInt();
        if (count<1 || count>1000000){
            System.out.println("범위를 벗어난 입력값입니다.");
            return;
        }

        int num[] = new int[count];

        for(int i=0; i<count; i++){
            num[i] = scanner.nextInt();
        }

        Arrays.sort(num);
        for (int j=0; j<num.length; j++) {
            System.out.println(num[j]);
        }

    }
}
