package doy;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Doy_Q10989 {
    // N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
    // 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
    static Scanner s = new Scanner(System.in);
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void run() {
        int t = s.nextInt();
//        int t = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            cnt[n]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                for (int j = 0; j < cnt[i]; j++) {
                    System.out.println(i);
//                    bw.write(Integer.toString(i) + "\n");
                }
            }
        }
    }
}
