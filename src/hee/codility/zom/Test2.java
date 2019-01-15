package hee.zom;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static final int MAX = 1000000000;

    public static void main(String[] args) {
//        int[] A = {1, 3, 5, 7, 9};
//        int[] A = {7,7,7,7};
//        int[] A = {3,-1,-5,-9};
//        int[] A = {0,1};
//        int[] A = {1,1,2,5,7};
//        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0, -1};
        int[] A = {-1, -1, -1};

        if (A.length < 3) {
            System.out.println(0);
            return;
//            return 0;
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
            } else {
                if (cnt != 1) {
                    counts.add(cnt);
                }
                cnt = 1;
            }
        }
        if (cnt != 1) {
            counts.add(cnt);
        }

        int sum = 0;
        for (int i = 0; i < counts.size(); i++) {
            if (sum > MAX) {
                System.out.println(-1);
                return;
//                return -1;
            }
            sum += cntStable(counts.get(i));
        }
//        return sum;
        System.out.println(sum);
    }

    public static int cntStable(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return sum;
    }
}
