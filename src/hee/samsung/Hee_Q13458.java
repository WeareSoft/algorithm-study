package hee.samsung;

import java.util.Scanner;

public class Hee_Q13458 {
    static int n, b, c;
    static int[] A;

    static long res = 0; // [주의] 범위 초과 주의!(문법적으로 오류가 없으면 범위 생각)

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        // input

        /* [방법1] */
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= b) {
                res++; // 총감독관 1명으로 감시 가능
                continue;
            }

            res++; // 총감독관 1명 무조건 감시
            int student = A[i] - b; // 총감독관이 감시한 후 남은 인원

            int rest = (student % c) == 0 ? 0 : 1; // 나머지가 존재하면 부감독관 1명 더 필요
            res += ((student / c) + rest); // 몫 만큼의 부감독관 + 나머지에 따라 부감독관 추가 필요
        }

        /* [방법2] */
        // 총 감독관 먼저 세팅(학생수>0 이므로 각 강의실에는 총 감독관은 무조건 1명 존재)
        res = A.length;

        for (int i = 0; i < n; i++) {
            // 총감독관이 감시한 후 남은 인원
            int student = A[i] - b;

            // 남은 인원이 존재하면 부감독관 추가
            if (student > 0) {
                int rest = (student % c) == 0 ? 0 : 1;
                res += (student / c) + rest;
            }
        }

        /* 결과 출력 */
        System.out.println(res);
    }
}
