package hee.nhn;

import java.util.ArrayList;
import java.util.Scanner;

public class Hee_1809_Q1 {
    static int N, P;
    static ArrayList<Integer> originAL;
    static ArrayList<Integer> subAL;
    static ArrayList<Integer> newAL;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = sc.nextInt();

        originAL = new ArrayList<>();
        newAL = new ArrayList<>(); // 위아래

        for (int i = 0; i < N; i++) {
            originAL.add(i); // 0 ~ N-1
        }

        while (P-- > 0) {
            int N = sc.nextInt();
            newAL = new ArrayList<>();

            while (true) {
                subAL = new ArrayList<>();

                // 중간 위치의 원소들 subAL 저장
                int originSize = originAL.size();
                for (int i = 0; i < originSize - (2 * N); i++) {
                    subAL.add(originAL.remove(N)); // 아예 공간이 삭제
                }

                // 2N 이하이면 재귀 탈출
                if (subAL.size() <= (2 * N))
                    break;

                newAL = originAL;
                originAL = subAL;
            } // 1회전 끝

            // subAL + originAL + newAL
            for (int i = 0; i < originAL.size(); i++)
                subAL.add(originAL.get(i));

            for (int i = 0; i < newAL.size(); i++)
                subAL.add(newAL.get(i));


            originAL = subAL;
        } // P번 회전 끝

        // 결과 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(originAL.get(i) + 1);
        }
    }
}
