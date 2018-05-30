package hee;

import java.util.ArrayList;
import java.util.Scanner;

// 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
// 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.
public class Hee_Q11005 {
    static Scanner scanner = new Scanner(System.in);

    static String codeToString(long code){
        return Character.toString((char)(code + 55));
    }

    public static void run(){
        long num = scanner.nextLong();
        int proposition = scanner.nextInt();
        ArrayList<String> res = new ArrayList<>();

        // num = 0이 될 때까지 나머지를 계속 구한다
        while (num != 0){
            long rest = (int)num%proposition; // 나머지를 구한다
            num = num/proposition; // 몫은 다시 num으로 넣는다

            // 나머지를 ArrayList에 넣는다
            if(rest >= 10){
                res.add(codeToString(rest));
            } else {
                res.add(Long.toString(rest));
            }
        }

        // 값 출력
        for(int i=res.size()-1; i>=0; i--)
            System.out.print(res.get(i));

    }
}
