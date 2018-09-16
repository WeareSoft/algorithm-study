package hee.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_Q2110 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int N = scanner.nextInt(); // 집의 개수 N (2 ≤ N ≤ 200,000)
        int C = scanner.nextInt(); // 공유기의 개수 C (2 ≤ C ≤ N)

        // 집의 좌표 X (1 ≤ xi ≤ 1,000,000,000)
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (N-- > 0) {
            arrayList.add(scanner.nextInt());
        }
        Collections.sort(arrayList);

        /* 이진 탐색 이용 */
        long min = 1;
        long max = arrayList.get(arrayList.size()-1);
        while (min <= max) {
            long mid = (min + max) / 2;
            int countWIFI = setCountWIFI(arrayList, mid);

            if(countWIFI >= C) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    /* 가장 인접한 두 공유기 사이의 거리가 x일 때, 설치할 수 있는 공유기의 수 */
    static int setCountWIFI(ArrayList<Integer> arrayList, long x) {
        int res = 1; // 첫번째 집에 설치
        int standardHouse = arrayList.get(0); // 첫번째집을 기준

        for (int i=1; i<arrayList.size(); i++) {
            // 두 집 사이의 거리 >= x이면 공유기 설치
            if(arrayList.get(i) - standardHouse >= x) {
                res++;
                standardHouse = arrayList.get(i);
            }
        }
        return res;
    }
}