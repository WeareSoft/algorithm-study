package hee;

import java.util.*;


public class Hee_Q11004 {
    // 수 N개 A1, A2, ..., AN이 주어진다.
    // A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int count = scanner.nextInt();
        int position = scanner.nextInt();

        int arrays[] = new int[count];

        for (int i=0; i<count; i++){
            arrays[i] = scanner.nextInt();
        }
        Arrays.sort(arrays);

        System.out.print(arrays[position-1]);
    }
}


