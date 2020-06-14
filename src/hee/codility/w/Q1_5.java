package hee.codility.w;

import java.util.ArrayList;
import java.util.List;

public class Q1_5 {
    public static void main(String[] args) {
        int[] A = {6, 1, 4, 6, 3, 2, 7, 4}; // 2~
        int K = 3, L = 2;

        if (A.length < K + L) {
            System.out.println(-1);
//            return -1;
        }

        // K를 항상 큰 수로 만든다.
        if (K < L) {
            int tmp = L;
            L = K;
            K = tmp;
        }

        // K개의 연속된 수 중 가장 큰 값을 구한다.
        int maxK = Integer.MIN_VALUE;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i <= A.length - K; i++) {
            int Ak = 0;
            for (int j = i; j < i + K; j++) {
                Ak += A[j];
            }
            /* 최댓값의 시작 인덱스 저장 */
            if (maxK < Ak) { // 새로운 최댓값
                maxK = Ak; // 최댓값 변경
                indexes.removeAll(indexes);
                indexes.add(i);
            } else if (maxK == Ak) { // 최댓값과 동일한 값
                indexes.add(i);
            }
        }

        // 최댓값이 같은 위치에 대해 각각 조사한다.
//        for (int i = 0; i < indexes.size(); i++) {
//            // K 뽑아낸 위치의 앞쪽
//            if (i >= L) {
//                for (int j = 0; j <)
//            }
//            // K 뽑아낸 위치의 뒷쪽
//            if () {
//
//            }
//        }
    }
}
