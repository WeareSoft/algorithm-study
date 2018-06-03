package doy;

import java.util.Scanner;

// B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
public class Doy_Q2745 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        // [방법 1] Java API 이용
        String num = s.next();
        int b = s.nextInt();
        int res = Integer.parseInt(num, b);

        System.out.println(res);

        // [방법 2] 자리수에 맞게 곱하고 더하기
//        StringBuilder n = new StringBuilder(s.next());
//        int b = s.nextInt();
//        int res = 0;
//
//        n.reverse();
//
//        for (int i = 0; i < n.length(); i++) {
//            int c = n.charAt(i);
//
//            if ('0' <= c && c <= '9') {
//                c = c - '0';
//                res += c * Math.pow(b, i);
//            } else {
//                c = c - 'A' + 10;
//                res += c * Math.pow(b, i);
//            }
//        }
//
//        System.out.println(res);
    }
}

/*
    Integer API를 이용하면 진법 변환을 훨씬 더 간단하게 할 수 있다는 것을 알았습니다 :)
    또한 int c = n.charAt(i); 다음과 같이 char형을 바로 int로 바꿀 때, 
    해당 char가 숫자라면 c = c - '0'; 다음과 같이 계산해야 올바른 int가 나오는 것도 알게 되었네요^^
    
    앞으로 (양수의) 진수로 변환하는 문제를 풀 때는 parseInt/toString을 이용하면 좋을 거 같아요!
*/
