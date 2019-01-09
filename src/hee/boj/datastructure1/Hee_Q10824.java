package hee.boj.datastructure1;

import java.util.Scanner;

public class Hee_Q10824 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        // [방법1] valueOf 메서드 이용
//        System.out.println(Long.valueOf(scanner.next() + scanner.next() ) + Long.valueOf(scanner.next() + scanner.next()));

        // [방법2] parseLong 메서드 이용
        String[] num = new String[4];

        for (int i=0; i<num.length; i++){
            num[i] = scanner.next();
        }

        System.out.println(Long.parseLong(num[0] + num[1]) + Long.parseLong(num[2] + num[3]) );
    }
}
