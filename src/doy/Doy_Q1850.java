package doy;

import java.io.*;
import java.util.*;

public class Doy_Q1850 {
    // 모든 자리가 1로만 이루어져 있는 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 이 때, A와 B의 최대공약수를 구하는 프로그램을 작성하시오.
    // solution : 입력받은 두 수(A와 B를 이루는 1의 개수)의 최대공약수가 결과 값(A와 B의 최대공약수)의 1의 개수이다.
    //            따라서 입력받은 두 수의 최대공약수를 구한 후 이 수만큼의 1을 출력하면 된다.
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Scanner s = new Scanner(System.in);
    public static void run() throws Exception {
        // [방법 1] BufferedReader 이용, 12408 KB  624 MS
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        for (int i=0; i<gcd(num1, num2); i++) {
            bw.write("1");
        }

        br.close();
        bw.close();

        // [방법 2] 표준 입출력 + StringBuffer 이용, 60256 KB  712 MS
//        StringBuffer sb = new StringBuffer();
//        long num1 = s.nextLong();
//        long num2 = s.nextLong();
//
//        for (int i=0; i<gcd(num1, num2); i++) {
//            sb.append("1");
//        }
//
//        System.out.println(sb);

        // [방법 3] 표준 입출력, 시간 초과
//        long num1 = s.nextLong();
//        long num2 = s.nextLong();
//
//        for (int i=0; i<gcd(num1, num2); i++) {
//            System.out.print("1");
//        }
    }

    static long gcd(long x, long y) {
        if(y == 0) {
            return x;
        }
        else {
            return gcd(y, x%y);
        }
    }
}

// reference : http://ksj14.tistory.com/entry/BackJoon1850-%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98
