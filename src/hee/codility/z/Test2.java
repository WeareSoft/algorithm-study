package hee.codility.z;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static final int MAX = 1000000000;

    public int solution(int[] A) {
        if (A.length < 3) {
//            System.out.println(0);
//            return;
            return 0;
        }

        /* 기울기 배열 초기화 */
        int[] inclination = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            inclination[i] = A[i + 1] - A[i];
        }

        /* 기울기의 값이 동일한 2개가 연속일 때, 기울기의 연속된 갯수 저장 */
        List<Integer> counts = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < inclination.length; i++) {
            if (inclination[i - 1] == inclination[i]) {
                cnt++;
                continue;
            }
            if (cnt != 1) { // 기울기가 연속된 갯수 저장
                counts.add(cnt);
            }
            cnt = 1; // 다시 초기화
        }
        if (cnt != 1) { // 마지막 기울기 확인
            counts.add(cnt);
        }

        int sum = 0;
        for (int i = 0; i < counts.size(); i++) {
            if (sum > MAX) {
//                System.out.println(-1);
//                return;
                return -1;
            }
            sum += cntStable(counts.get(i));
        }
        return sum;
//        System.out.println(sum);
    }

    public int cntStable(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return sum;
    }
}
